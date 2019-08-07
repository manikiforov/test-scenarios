var Zenflow = (function () {
    var OMIT_CONTEXT_FIELDS = ['currentState', 'contextPath', 'contextHistory', 'transitionsHistory', 'smartRandom', 'transitions'];

    function extractParseTreeTags(pt) {
        var tags = {};
        Object.keys(pt).forEach(function(key) {
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

    function createGlobalVars($context) {
        return {
            channelType: $context.request.channelType,
            channelId: $context.request.channelBotId,
            userId: $context.request.channelUserId,
            queryText: $context.request.query,
            rawRequest: $context.request.rawRequest
        }
    }

    function preProcess($context) {
        _.extend($context.session, extractParseTreeTags($context.parseTree));
        _.extend($context.session, createGlobalVars($context));
        fulfill($context.currentState);
    }

    function preMatch($context) {
        var yaSession = $context.request && $context.request.rawRequest && $context.request.rawRequest.session && $context.request.rawRequest.session.new;
        if (yaSession || !$context.request.query) {
            $context.temp.targetState = getFirstState();
        }
    }

    function initPreProcess() {
        bind("preProcess", preProcess);
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
        if (!config) {
            config = params.fulfillment.settings.default;
        }
        if (config) {
            var data = _.omit(context.session, OMIT_CONTEXT_FIELDS);
            data = _.omit(data, function (value, key) { return key[0] === '_' });

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
        $reactions.transition = function(arg) {
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
        if (typeof $states === 'undefined' || !!$states['/newNode_0']) {
            return '/newNode_0';
        } else {
            var states = Object.keys($states);
            for (var i = 0; i < states.length; i++) {
                var state = $states[states[i]];
                if (state.name.indexOf("newNode_") === 0 && state.path.parents.length === 1) {
                    return '/' + state.name;
                }
            }
        }
        return null;
    }

    function start() {
        var $session = $jsapi.context().session;
        if ($session._started) {
            var $request = $jsapi.context().request;
            $reactions.newSession({message: $request.query});
            return;
        }
        $session._started = true;
        var firstState = getFirstState();
        if (firstState) {
            $reactions.transition(firstState);
        }
    }

    function fillStartData() {
        var $session = $jsapi.context().session;
        var $parseTree = $jsapi.context().parseTree;
        $session.start = $parseTree.text.substring($parseTree.text.lastIndexOf("start") + "start ".length);
        if($session.start) {
            try {
                $session.start = JSON.parse($session.start);
            }  catch(e) {
                log("start data non JSON object");
            }
        }
    }

    return {
        init: init,
        start: start,
        fillStartData: fillStartData
    }
})();