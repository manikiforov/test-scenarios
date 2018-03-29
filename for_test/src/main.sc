
theme: /
    @InputText
        {
          "prompt" : "Введите текст или отправитесь играть в покер со Смертью1!",
          "varName" : "text",
          "then" : "/step2"
        }
    state: step1
        a: Введите текст или отправитесь играть в покер со Смертью1!

        state: CatchText
            q: *
            script:
                $session.text = $parseTree.text;
            go!: /step2
    @InputNumber
        {
          "prompt" : "Введите число, о Величаший!",
          "varName" : "number",
          "minValue" : 0,
          "maxValue" : 10,
          "failureMessage" : [
            "Введите число от 0 до 10",
            "Ты не понял? От 0 до 10!!"
          ],
          "then" : "/step3"
        }
    state: step2
        a: Введите число, о Величаший!

        state: CatchNumber
            q: $Number
            script:
                var failureMessages = [
                    "Введите число от 0 до 10",
                    "Ты не понял? От 0 до 10!!"
                ];
                var failureRandom = failureMessages[$reactions.random(failureMessages.length)];
                if ($parseTree._Number < 0) {
                    $reactions.answer(failureRandom);
                } else
                if ($parseTree._Number > 10) {
                    $reactions.answer(failureRandom);
                } else
                {
                    $session.number = $parseTree._Number;
                    $temp.number_ok = true;
                }
            if: $temp.number_ok
                go!: /step3
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..
    @Confirmation
        {
          "prompt" : "Вы согласны перейти в плоский мир?",
          "agreeState" : "/newNode_4",
          "disagreeState" : "/step4",
          "useButtons" : true,
          "agreeButton" : "Ну давай",
          "disagreeButton" : "Нет, не буду"
        }
    state: step3
        a: Вы согласны перейти в плоский мир?
        buttons:
            "Ну давай" -> Agree
            "Нет, не буду" -> Disagree
        state: Agree
            q: $agree
            go!: /newNode_4
        state: Disagree
            q: $disagree
            go!: /step4
    @Switch
        {
          "prompt" : "оператор курит! Жди",
          "ignoreOffline" : false,
          "firstMessage" : "Покурил? Обслужи!",
          "closeChatPhrases" : [
            "бб",
            "пока",
            "я пошел"
          ],
          "destination" : "",
          "attributes" : {
            "1" : "кек"
          },
          "onClose" : "",
          "chatClosedMessage" : "Оператор завершил диалог",
          "noOperatorsOnlineState" : ""
        }
    state: step4
        if: false || hasOperatorsOnline()
            script:
                var switchReply = {type:"switch"};
                switchReply.ignoreOffline = false;
                switchReply.closeChatPhrases = [
                     "бб",
                     "пока",
                     "я пошел"
                ];
                switchReply.destination = "";
                switchReply.attributes = {
                         "1": "кек"
                };
                switchReply.firstMessage = "Покурил? Обслужи!";
                $response.replies = $response.replies || [];
                $response.replies.push(switchReply);
            a: оператор курит! Жди
        else:
            go!:
        state: NoOperatorsOnline
            event: noLivechatOperatorsOnline
            go!:
        state: LivechatReset
            event: livechatFinished
            a: Оператор завершил диалог
            go!:

    state: newNode_4
        a: Такой кекас!

    state: newNode_5
        image:

    state: newNode_6
        image:
