
theme: /
    @InputText
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "prompt" : "Введите текст",
          "varName" : "text",
          "then" : "/newNode_1"
        }
    state: newNode_0 || modal = true
        a: Введите текст

        state:
            q: * *start *
            script:
              Zenflow.start();

        state: CatchText
            q: *
            script:
                addClientVarToSession("text", $parseTree.text);
            go!: /newNode_1
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_0",
                name: "newNode_0 buttons",
                handler: function($context) {
                }
            });
    @InputNumber
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "prompt" : "Введите число",
          "varName" : "number",
          "failureMessage" : [
            "Введите число от 1 до 5"
          ],
          "then" : "/newNode_2",
          "minValue" : 1,
          "maxValue" : 5
        }
    state: newNode_1
        a: Введите число

        state: CatchNumber
            q: * $Number *
            script:
                var failureMessages = [
                    "Введите число от 1 до 5"
                ];
                var failureRandom = failureMessages[$reactions.random(failureMessages.length)];
                if ($parseTree._Number < 1) {
                    $reactions.answer(failureRandom);
                } else
                if ($parseTree._Number > 5) {
                    $reactions.answer(failureRandom);
                } else
                {
                    addClientVarToSession("number", $parseTree._Number);
                    $temp.number_ok = true;
                }
            if: $temp.number_ok
                go!: /newNode_2
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_1",
                name: "newNode_1 buttons",
                handler: function($context) {
                }
            });
    @InputPhoneNumber
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "prompt" : "Введите номер телефона",
          "varName" : "phonekki",
          "failureMessage" : [
            "Некорректный номер телефона"
          ],
          "then" : "/newNode_3"
        }
    state: newNode_2
        a: Введите номер телефона

        state: CatchPhoneNumber
            q: * $mobilePhoneNumber *
            script:
                addClientVarToSession("phonekki", $parseTree._mobilePhoneNumber);
            go!: /newNode_3

        state: WrongPhoneNumber
            script:
                var failureMessages = [
                    "Некорректный номер телефона"
                ];
                $temp.failureRandom = failureMessages[$reactions.random(failureMessages.length)];
                $reactions.answer($temp.failureRandom);
            go: ../CatchPhoneNumber

        state: CatchAll
            q: *
            go!: ../WrongPhoneNumber
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_2",
                name: "newNode_2 buttons",
                handler: function($context) {
                }
            });
    @HttpRequest
        {
          "boundsTo" : "",
          "url" : "http://www.google.com",
          "method" : "GET",
          "body" : "",
          "okState" : "/newNode_4",
          "errorState" : "/newNode_5",
          "timeout" : 0,
          "headers" : [ ],
          "vars" : [ ]
        }
    state: newNode_3
        script:
            var headers = {
            };
            var result = $http.query("http://www.google.com", {
                method: "GET",
                headers: headers,
                query: $session,
                timeout: 0 || 10000
            });
            var $httpResponse = result.data;
            $session.httpStatus = result.status;
            $session.httpResponse = $httpResponse;
            if (result.isOk && result.status >= 200 && result.status < 300) {
                $reactions.transition("/newNode_4");
            } else {
                $reactions.transition("/newNode_5");
            }

    state: newNode_4
        random:
            a: qweqwe
        go!: /newNode_6
    @Transition
        {
          "boundsTo" : "/newNode_4",
          "then" : "/newNode_7"
        }
    state: newNode_6
        go!: /newNode_7

    state: newNode_5
        image: https://248305.selcdn.ru/public_test/260/261/FF9AVyVy0OfHQji2.png
        go!: /newNode_9
    @Transition
        {
          "boundsTo" : "/newNode_5",
          "then" : "/newNode_8"
        }
    state: newNode_9
        go!: /newNode_8
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "$EMAIL"
                }
              ],
              "then" : "/newNode_10"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "$AGREEMENT"
                }
              ],
              "then" : ""
            }
          ]
        }
    state: newNode_7
        state: 1
            q: $EMAIL

            go!: /newNode_10

        state: 2
            q: $AGREEMENT

            go!: /
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_7",
                name: "newNode_7 buttons",
                handler: function($context) {
                }
            });
    @EndSession
        {
          "boundsTo" : ""
        }
    state: newNode_8
        script:
            $session = new Object();
            $response.endSession = true;
    @TransferToOperator
        {
          "boundsTo" : "",
          "titleOfCloseButton" : "Переключить на бота",
          "messageBeforeTransfer" : "Вы будете переведены на оператора",
          "ignoreOffline" : true,
          "messageForWaitingOperator" : "Вам ответит первый освободившийся оператор",
          "noOperatorsOnlineState" : "",
          "dialogCompletedState" : ""
        }
    state: newNode_10
        if: true || hasOperatorsOnline()
            script:
                var switchReply = {type:"switch"};
                switchReply.ignoreOffline = true;
                switchReply.appendCloseChatButton = true;
                switchReply.closeChatPhrases = ["Переключить на бота"];
                switchReply.firstMessage = $context.client.chatHistory.map(function(val) {
                    return val.type + "\n" + val.text;
                }).join("\n\n");
                $response.replies = $response.replies || [];
                $response.replies.push(switchReply);

            a: Вы будете переведены на оператора
            if: !hasOperatorsOnline()
                a: Вам ответит первый освободившийся оператор

            buttons:
                "Переключить на бота"
        else:
            go!: /
        init:
            $jsapi.bind({
                type: "preProcess",
                name: "savingVisitorChatHistory",
                path: "/",
                handler: function($context) {
                    $context.client.chatHistory = $context.client.chatHistory || [];
                    var chatHistory = $context.client.chatHistory;
                    if ($context.request.query) {
                        chatHistory.push({type:"CLIENT", text:$context.request.query});
                    }
                    chatHistory.splice(0, chatHistory.length - 10);
                }
            });
            $jsapi.bind({
                type: "postProcess",
                name: "savingBotChatHistory",
                path: "/",
                handler: function($context) {
                    $context.client.chatHistory = $context.client.chatHistory || [];
                    var chatHistory = $context.client.chatHistory;
                    if ($context.response.replies) {
                        $context.response.replies
                            .filter(function(val) { return val.type === "text"; })
                            .forEach(function(val) { chatHistory.push({ type:"BOT", text: val.text }); });
                    }
                    chatHistory.splice(0, chatHistory.length - 10);
                }
            });

        state: DialogCompleted
            go!: /

        state: livechatFinished
            event: livechatFinished
            go!: /newNode_10/DialogCompleted
