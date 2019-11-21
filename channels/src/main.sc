
theme: /

    state: newNode_0
        random:
            a: Привет!
        image: https://248305.selcdn.ru/zfl_stage/185/186/5QRj2Fe59IswVBS5.jpg
        go!: /newNode_1
    @IntentGroup
        {
          "boundsTo" : "/newNode_0",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Хочу поговорить с оператором"
                },
                {
                  "type" : "example",
                  "value" : "Оператор"
                },
                {
                  "type" : "example",
                  "value" : "Ты бездушная машина, дай мне человека!"
                }
              ],
              "then" : "/newNode_2"
            }
          ]
        }
    state: newNode_1
        state: 1
            e: Хочу поговорить с оператором
            e: Оператор
            e: Ты бездушная машина, дай мне человека!

            go!: /newNode_2
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_1",
                name: "newNode_1 buttons",
                handler: function($context) {
                }
            });
    @TransferToOperator
        {
          "boundsTo" : "",
          "titleOfCloseButton" : "Завершить чат с оператором",
          "messageBeforeTransfer" : "Вы будете переведены на оператора",
          "ignoreOffline" : true,
          "messageForWaitingOperator" : "Вам ответит первый освободившийся оператор",
          "noOperatorsOnlineState" : "",
          "dialogCompletedState" : "/newNode_3"
        }
    state: newNode_2
        if: true || hasOperatorsOnline()
            script:
                var switchReply = {type:"switch"};
                switchReply.ignoreOffline = true;
                switchReply.appendCloseChatButton = true;
                switchReply.closeChatPhrases = ["Завершить чат с оператором"];
                switchReply.firstMessage = $context.client.chatHistory.map(function(val) {
                    return val.type + "\n" + val.text;
                }).join("\n\n");
                $response.replies = $response.replies || [];
                $response.replies.push(switchReply);

            a: Вы будете переведены на оператора
            if: !hasOperatorsOnline()
                a: Вам ответит первый освободившийся оператор

            buttons:
                "Завершить чат с оператором" -> /newNode_2/DialogCompleted
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
            go!: /newNode_3

        state: livechatFinished
            event: livechatFinished
            go!: /newNode_2/DialogCompleted

    state: newNode_3
        random:
            a: Ты вернулся ко мне!
