
theme: /

    state: newNode_0
        q!: switch
        go!: /newNode_1
    @Switch
        {
          "prompt" : "Вам ответит первый освободившийся оператор",
          "ignoreOffline" : false,
          "firstMessage" : "",
          "closeChatPhrases" : [
            "хватит"
          ],
          "destination" : "",
          "attributes" : {
            "фыв" : "фыв"
          },
          "onClose" : "/newNode_3",
          "chatClosedMessage" : "Оператор завершил диалог",
          "noOperatorsOnlineState" : "/newNode_2"
        }
    state: newNode_1
        if: false || hasOperatorsOnline()
            script:
                var switchReply = {type:"switch"};
                switchReply.ignoreOffline = false;
                switchReply.closeChatPhrases = [
                     "хватит"
                ];
                switchReply.destination = "";
                switchReply.attributes = {
                         "фыв": "фыв"
                };
                switchReply.firstMessage = "";
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

    state: newNode_2
        a: Нет операторов

    state: newNode_3
        a: Диалог закрылся
