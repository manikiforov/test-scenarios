
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
          "agreeState" : "/newNode_4",
          "disagreeState" : "/newNode_04",
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
            go!: /newNode_4
        state: Disagree
            q: $disagree
            go!: /newNode_04
    @Switch
        {
          "prompt" : "Вам ответит апапапапап",
          "ignoreOffline" : false,
          "firstMessage" : "ухты емае",
          "closeChatPhrases" : [
            "пока",
            "ой пока",
            "заеб"
          ],
          "destination" : "",
          "attributes" : {
            "name" : "id12345"
          },
          "onClose" : "/newNode_6",
          "chatClosedMessage" : "Оператор послал вас",
          "noOperatorsOnlineState" : "/newNode_5"
        }
    state: newNode_04
        if: false || hasOperatorsOnline()
            script:
                var switchReply = {type:"switch"};
                switchReply.ignoreOffline = false;
                switchReply.closeChatPhrases = [
                     "пока",
                     "ой пока",
                     "заеб"
                ];
                switchReply.destination = "";
                switchReply.attributes = {
                         "name": "id12345"
                };
                switchReply.firstMessage = "ухты емае";
                $response.replies = $response.replies || [];
                $response.replies.push(switchReply);
            a: Вам ответит апапапапап
        else:
            go!: /newNode_5
        state: NoOperatorsOnline
            event: noLivechatOperatorsOnline
            go!: /newNode_5
        state: LivechatReset
            event: livechatFinished
            a: Оператор послал вас
            go!: /newNode_6

    state: newNode_4 || modal = true
        a: Пиу

    state: newNode_5
        image: https://248305.selcdn.ru/public_test/262/267/rGUxh3sAVYOdhedc.png

    state: newNode_6
        image: https://248305.selcdn.ru/public_test/262/267/u7RjQJV7nK7lOl26.jpg
