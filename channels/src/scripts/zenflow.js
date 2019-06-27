var Zenflow = (function () {
    var OMIT_CONTEXT_FIELDS = ['currentState', 'contextPath', 'contextHistory', 'transitionsHistory', 'smartRandom', 'transitions'];

    function extractParseTreeTags(pt) {
        var tags = {};
        Object.keys(pt).forEach(function (key) {
            if (key.indexOf("_") === 0) {
                key = key.substring(1);
                var tag = pt[key];
                if (tag && tag.length) {
                    var values = [];
                    tag.forEach(function (t) {
                        values.push(t.value);
                    });
                    tags[key] = values[0];
                }
            }
        });
        return tags;
    }

    function extractAlexaSlots(currentState) {
        try {
            return $jsapi.internal.getAlexaSlotValues(currentState);
        }
        catch (e) {
            return {};
        }
    }

    function createGlobalVars($context) {
        return {
            channelType: $context.request.channelType,
            channelId: $context.request.channelBotId,
            userId: $context.request.channelUserId,
            queryText: $context.request.query,
            rawRequest: $context.request.rawRequest
        }
    }

    function createUserData($context) {
        var $client = $context.client;
        var $session = $context.session;
        var lastSeen = $client.lastSeen;
        var time = $jsapi.currentTime();
        var userData = {lastSeen: $session.lastSeen};

        if (!lastSeen || time - lastSeen > 1000) {
            $client.lastSeen = time;

            if (lastSeen) {
                lastSeen = Math.round(($client.lastSeen - lastSeen) / 1000);
                if (lastSeen > 0) {
                    userData.lastSeen = lastSeen;
                }
            }
        }

        $jsapi.log("USER DATA: " + JSON.stringify(userData));

        return userData;
    }

    function preProcess($context) {
        $jsapi.log("PREPROCESS");

        var channelType = $context.request.channelType;

        _.extend($context.session, extractParseTreeTags($context.parseTree));
        if (channelType === "alexa") {
            _.extend($context.session, extractAlexaSlots($context.currentState));
        }
        _.extend($context.session, createGlobalVars($context));
        _.extend($context.session, createUserData($context));
        fulfill($context.currentState);
    }

    function postProcess($context) {
        yandexPostProcess($context);
    }

    function yandexPostProcess($context) {
        if ($context.session.channelType != "yandex") {
            return;
        }
        for (var i = 0; i < $context.response.replies.length; i++) {
            var reply = $context.response.replies[i];
            if (reply.type != "buttons") {
                continue;
            }
            for (var j = 0; j < reply.buttons.length; j++) {
                if (!reply.buttons[j].url) {
                    reply.buttons[j].hide = true;
                }
            }
        }
    }

    function preMatch($context) {
        var channelType = $context.request.channelType;

        if (channelType === "yandex") {
            yandexPreMatch($context);
        }
        else if (channelType === "google") {
            googlePreMatch($context);
        }
        else if (channelType === "alexa") {
            alexaPreMatch($context);
        }

        if (!$context.request.query && !$context.request.event) {
            $context.temp.targetState = getFirstState();
        }
    }

    function yandexPreMatch($context) {
        if ($context.request && $context.request.rawRequest) {
            var rawRequest = $context.request.rawRequest;
            // Если новая сессия то делаем сброс сессионных данных на нашей стороне
            if (rawRequest.session && rawRequest.session.new) {
                $context.session = new Object();
                // Если команда отличается от полного текста, это сквозной запрос, если одинаковые то с первого стейта
                if (rawRequest.request && !rawRequest.request.command || rawRequest.request.command === rawRequest.request.original_utterance) {
                    $context.temp.targetState = getFirstState();
                }
            }
        }
    }

    function googlePreMatch($context) {
        if ($context.request && $context.request.rawRequest && $context.request.rawRequest.inputs) {
            var inputs = $context.request.rawRequest.inputs;
            // Проверка что intent запуска приложения, сбрасываем сессионные данные
            if (inputs.length > 0 && inputs[0].intent && inputs[0].intent === "actions.intent.MAIN") {
                $context.session = new Object();
                //если в интенте запуска есть аргументы значит есть текст сквозного запроса, если нету то с первого стейта
                if (inputs.length > 0 && (!inputs[0].arguments || inputs[0].arguments.length < 1)) {
                    $context.temp.targetState = getFirstState();
                }
            }
        }
    }

    function alexaPreMatch($context) {
        var isNewSession = $context
                        && $context.request
                        && $context.request.rawRequest
                        && $context.request.rawRequest.session
                        && $context.request.rawRequest.session.new || false;

        if (isNewSession) {
            $context.session = {};

            var isLaunchRequestWithoutIntents = $context.request.rawRequest.request.type === 'LaunchRequest';

            if (isLaunchRequestWithoutIntents) {
                $context.temp.targetState = getFirstState();
            }
        }
    }

    function initPreProcess() {
        bind("preProcess", preProcess);
        bind("postProcess", postProcess);
        bind("preMatch", preMatch);
    }

    function fulfill(state) {
        if (typeof params === 'undefined'
            || !params
            || !params.fulfillment
            || !params.fulfillment.settings
            || !params.fulfillment.actions
            || !params.fulfillment.actions.length) {

            return;
        }

        var context = $jsapi.context();
        var $temp = context.temp;
        if ($temp.fulfilled && $temp.fulfilled[state]) {
            return;
        }

        $temp.fulfilled = $temp.fulfilled || {};
        $temp.fulfilled[state] = true;

        var action = _.findWhere(params.fulfillment.actions, {state: state});

        if (!action || !action.enabled) {
            log("Action not found or disabled for state " + state);
            return;
        }

        var channels = params.fulfillment.settings.channels;
        var channelId = context.request.botId;
        var config;

        if (channels && channels.length) {
            config = _.findWhere(channels, {channelId: channelId});
        }
        if (!config || !config.url) {
            config = params.fulfillment.settings.default;
        }
        if (config && config.url) {
            var data = _.omit(context.session, OMIT_CONTEXT_FIELDS);
            data = _.omit(data, function (value, key) {
                return key[0] === '_'
            });

            data.userId = context.request.channelUserId;
            data.queryText = context.request.query;
            data.action = action.action;

            log("Fulfillment: " + config.url + " " + JSON.stringify(data));

            var result = $http.query(config.url, {
                method: "POST",
                headers: ["Content-Type", "application/json"],
                dataType: "json",
                timeout: 60000,
                body: JSON.stringify(data)
            });

            if (result.isOk && result.status === 200) {
                _.extend(context.session, result.data);
            }
        }
    }

    function initFulfillment() {
        var transitionFunction = $reactions.transition;
        $reactions.transition = function (arg) {
            var state = typeof arg === 'string' ? arg : arg.value;
            fulfill(state);
            transitionFunction(arg);
        };
    }

    function init() {
        initPreProcess();
        initFulfillment();
    }

    function getFirstState() {
        var states = Object.keys($states);
        for (var i = 0; i < states.length; i++) {
            var state = $states[states[i]];
            if (state.name.indexOf("newNode_") === 0 && state.path.parents.length === 1) {
                return '/' + state.name;
            }
        }
        return null;
    }

    /**
     *
     * @returns string root state from the session context path
     */
    function getBack() {
        var cp = $jsapi.context().session.contextPath;
        if (_.isUndefined(cp) || cp == null) {
            return getFirstState();
        }
        var n = cp.indexOf("/", 1);
        return n === -1 ? cp : cp.substring(0, n);
    }

    function start() {
        var $context = $jsapi.context();
        var $session = $context.session;
        if ($session._started) {
            $jsapi.log("RESTART SESSION");
            var $request = $jsapi.context().request;
            $reactions.newSession({
                message: $request.query,
                session: _.extend({}, createUserData($context), createStartData($context))
            });
            return;
        }
        _.extend($session, createStartData($context));
        $session._started = true;
        var firstState = getFirstState();
        $jsapi.log("FIRST STATE: " + firstState);
        $jsapi.log(JSON.stringify($session));
        if (firstState) {
            $reactions.transition(firstState);
        }
    }

    function createStartData($context) {
        var $parseTree = $context.parseTree;
        if ($parseTree) {
            var index = $parseTree.text.lastIndexOf("start");
            if (index !== -1) {
                var start = $parseTree.text.substring(index + "start ".length);
                if (start) {
                    try {
                        return {start: JSON.parse(start)};
                    } catch (e) {
                        $jsapi.log("start data is not a JSON object");
                    }
                }
            }
        }
        return {start: {}};
    }

    return {
        init: init,
        start: start,
        getBack: getBack
    }
})();