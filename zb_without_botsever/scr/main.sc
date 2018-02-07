
theme: /
    @Switch
        {
          "prompt" : "Вам ответит первый освободившийся оператор",
          "ignoreOffline" : false,
          "firstMessage" : "клиент на проводе",
          "closeChatPhrases" : [ "пока пока " ],
          "destination" : "",
          "attributes" : { },
          "onClose" : "",
          "chatClosedMessage" : "Оператор завершил диалог",
          "noOperatorsOnlineState" : ""
        }
    state: newNode_0
        if: false || hasOperatorsOnline()
            script:
                var switchReply = {type:"switch"};
                switchReply.ignoreOffline = false;
                switchReply.closeChatPhrases = [
                     "пока пока "
                ];
                switchReply.destination = "";
                switchReply.attributes = {
                };
                switchReply.firstMessage = "клиент на проводе";
                $response.replies = $response.replies || [];
                $response.replies.push(switchReply);
            a: Вам ответит первый освободившийся оператор
        else:
            go!:
        state: NoOperatorsOnline
            event: noLivechatOperatorsOnline
            go!:
        state: LivechatReset
            event: livechatFinished
            a: Оператор завершил диалог
            go!:
