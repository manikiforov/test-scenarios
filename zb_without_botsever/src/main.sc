
theme: /
    @Switch
        {
          "prompt" : "Вам ответит первый освободившийся оператор",
          "ignoreOffline" : false,
          "firstMessage" : "клиент на проводе",
          "closeChatPhrases" : [ "пока пока " ],
          "destination" : "",
          "attributes" : { },
          "onClose" : "/newNode_3",
          "chatClosedMessage" : "Оператор завершил диалог",
          "noOperatorsOnlineState" : "/newNode_2"
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
            go!: /newNode_2
        state: NoOperatorsOnline
            event: noLivechatOperatorsOnline
            go!: /newNode_2
        state: LivechatReset
            event: livechatFinished
            a: Оператор завершил диалог
            go!: /newNode_3

    state: newNode_1
        q!: switch
        go!: /newNode_0

    state: newNode_2
        a: 123

    state: newNode_3
        a: 456
