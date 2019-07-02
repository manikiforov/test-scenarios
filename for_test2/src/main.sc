
theme: /
    @InputText
        {
          "prompt" : "Введите текст или отправитесь играть в покер со Смертью1!",
          "varName" : "text",
          "then" : "/newNode_02"
        }
    state: newNode_01 || modal = true
        a: Введите текст или отправитесь играть в покер со Смертью1!

        state: CatchText
            q: *
            script:
                addClientVarToSession("text", $parseTree.text);
            go!: /newNode_02
    @InputNumber
        {
          "prompt" : "Введите число, о Величаший!",
          "varName" : "number",
          "failureMessage" : [
            "Введите число от 1 до 5",
            "кусь",
            "бусь"
          ],
          "then" : "/newNode_03",
          "minValue" : 0,
          "maxValue" : 10
        }
    state: newNode_02
        a: Введите число, о Величаший!

        state: CatchNumber
            q: $Number
            script:
                var failureMessages = [
                    "Введите число от 1 до 5",
                    "кусь",
                    "бусь"
                ];
                var failureRandom = failureMessages[$reactions.random(failureMessages.length)];
                if ($parseTree._Number < 0) {
                    $reactions.answer(failureRandom);
                } else
                if ($parseTree._Number > 10) {
                    $reactions.answer(failureRandom);
                } else
                {
                    addClientVarToSession("number", $parseTree._Number);
                    $temp.number_ok = true;
                }
            if: $temp.number_ok
                go!: /newNode_03
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..
    @Confirmation
        {
          "prompt" : "Вы согласны перейти в плоский мир?",
          "agreeState" : "",
          "disagreeState" : "",
          "useButtons" : true,
          "agreeButton" : "лололололол",
          "disagreeButton" : "найн"
        }
    state: newNode_03
        a: Вы согласны перейти в плоский мир?
        buttons:
            "лололололол" -> Agree
            "найн" -> Disagree
        state: Agree
            q: $agree
            go!:
        state: Disagree
            q: $disagree
            go!:
    @Switch
        {
          "prompt" : "Вам ответит первый освободившийся оператор",
          "ignoreOffline" : false,
          "firstMessage" : "",
          "closeChatPhrases" : [ ],
          "destination" : "",
          "attributes" : { },
          "onClose" : "",
          "chatClosedMessage" : "Оператор завершил диалог",
          "noOperatorsOnlineState" : ""
        }
    state: newNode_04
        if: false || hasOperatorsOnline()
            script:
                var switchReply = {type:"switch"};
                switchReply.ignoreOffline = false;
                switchReply.closeChatPhrases = [
                ];
                switchReply.destination = "";
                switchReply.attributes = {
                };
                switchReply.firstMessage = "";
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
