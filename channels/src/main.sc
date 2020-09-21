require: patterns.sc
  module = common

require: floatNumber/floatNumber.sc
  module = common

require: slotfilling/slotFilling.sc
  module = common

require: dictionaries/answers.yaml
  var = ans
  name = ans

require: scripts/orderStatus.js
require: scripts/utils.js
require: themes/talk/aboutBot.sc
require: themes/talk/conversation.sc
require: themes/talk/events.sc
require: themes/talk/offTopic.sc
require: themes/shop/orderCancellation.sc
require: themes/shop/orderStatus.sc
require: patterns.sc

init:
    $global.$ = {
        __noSuchProperty__: function(property) {
            return $jsapi.context()[property];
        }
    };


    $jsapi.bind({
        type: "preProcess",
        name: "startingNewSession",
        path: "/",
        handler: function($context) {
            if ($.session.lastActiveTime) {
                var interval = $jsapi.currentTime() - $context.session.lastActiveTime;
                if (interval > 10) {
                    $reactions.newSession({message: $.request.query, session: $.request.data});
                }
            }
        }
    });


    $jsapi.bind({
        type: "postProcess",
        name: "savingLastActiveTime",
        path: "/",
        handler: function($context) {
            $.session.lastActiveTime = $jsapi.currentTime();
        }
    });


    $jsapi.bind({
        type: "postProcess",
        name: "pushGreeting",
        path: "/",
        handler: function($context) {
            if ($.session.lastState == "/Start" && $jsapi.context().currentState != "/Start") {
                var HelloMsg = {
                    "type": "text",
                    "text": "Здравствуйте! Меня зовут Алёна, я ваш виртуальный помощник."
                }
                if (!testMode()) {
                    $.response.replies.unshift(HelloMsg);
                }
            }

            $.session.lastState = $jsapi.context().currentState;

        }
    });



theme: /


    state: Start
        q!: *start
        script:
            if ((($request.rawRequest || {}).clientData || {}).user_crm_id) {
                if ($request.rawRequest.clientData.user_crm_id != "" || $request.rawRequest.clientData.user_crm_id != " " || $request.rawRequest.clientData.user_crm_id != "-") {
                    $session.authorization = true;
                //    $session.userCrmId = $request.rawRequest.clientData.user_crm_id;
                } else {
                    $session.authorization = false;
                }
            } else {
                $session.authorization = false;
            }

        # Чтобы вывести в бота все данные, которые приходят на старте сессии, нужно вывести переменную $context
        #a: {{toPrettyString($context)}}



    state: ClearVars
        # стейт для обновления переменных
        q!: *reset
        script:
            $session = {};
        a: Сессионные переменные обновлены.


    #state: TestAns
    #    q!: выведи ответ
    #    a: {{ans.toOperator}}


    #state: TestRequest
    #    q!: покажи реквест
    #    a: {{toPrettyString($request)}}


    #state: TestContext
    #    q!: покажи контекст
    #    a: {{toPrettyString($context)}}


    state: TestOrderStatus
        q!: тест статус @orderNumber
        script:
            if ($parseTree._orderNumber) {
                $session.orderNumber = $parseTree._orderNumber;
            }
            $temp.res = getOrderParams();
            $reactions.answer(toPrettyString($temp.res));























































