require: all.sc
  module = common

require: patterns.sc

  module = common

theme: /

    state: newNode_3
        a: пыщ!

    state: newNode_6
        image: https://248305.selcdn.ru/public_test/sadmin/O3O9argQgcvlEwRe.jpg

    state: newNode_7
        image: https://248305.selcdn.ru/public_test/sadmin/NXxJAPvXHWr0pqld.jpg
    @InputText
        {
          "prompt" : "\"Введите текст или отправитесь играть в покер со Смертью1!\"",
          "varName" : "text",
          "then" : "/newNode_2"
        }
    state: newNode_1
        a: "Введите текст или отправитесь играть в покер со Смертью1!"

        state: CatchText || modal = true
            q: *
            script:
                $session.text = $parseTree.text;
            go!: /newNode_2
    @InputNumber
        {
          "prompt" : "\"Введите число, о Величаший!\"",
          "varName" : "number",
          "minValue" : 0,
          "maxValue" : 10,
          "failureMessage" : [
            "Введите число от 0 до 10",
            "о онет",
            "не очень супер"
          ],
          "then" : "/newNode_5"
        }
    state: newNode_2
        a: "Введите число, о Величаший!"

        state: CatchNumber
            q: $Number
            script:
                var failureMessages = [
                    "Введите число от 0 до 10",
                    "о онет",
                    "не очень супер"
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
                go!: /newNode_5
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..
    @Confirmation
        {
          "prompt" : " \"Вы согласны перейти в плоский мир?\"",
          "agreeState" : "/newNode_3",
          "disagreeState" : "/newNode_8",
          "useButtons" : true,
          "agreeButton" : "Да",
          "disagreeButton" : "Нет"
        }
    state: newNode_5
        a:  "Вы согласны перейти в плоский мир?"
        buttons:
            "Да" -> Agree
            "Нет" -> Disagree
        state: Agree
            q: agree
            go!: /newNode_3
        state: Disagree
            q: disagree
            go!: /newNode_8
    @Switch
        {
          "prompt" : "Вам ответит первый освободившийся оператор",
          "ignoreOffline" : false,
          "oneTimeMessage" : false,
          "firstMessage" : "",
          "closeChatPhrases" : [ ],
          "destination" : "",
          "onClose" : "/newNode_7",
          "chatClosedMessage" : "Оператор завершил диалог",
          "noOperatorsOnlineState" : "/newNode_6"
        }
    state: newNode_8
        if: false || hasOperatorsOnline()
            script:
                var switchReply = {type:"switch"};
                switchReply.ignoreOffline = false;
                switchReply.oneTimeMessage = false;
                switchReply.closeChatPhrases = [
                ];
                switchReply.destination = "";
                switchReply.firstMessage = "";
                $response.replies = $response.replies || [];
                $response.replies.push(switchReply);
            a: Вам ответит первый освободившийся оператор
        else:
            go!: /newNode_6
        state: NoOperatorsOnline
            event: noLivechatOperatorsOnline
            go!: /newNode_6
        state: LivechatReset
            event: livechatFinished
            a: Оператор завершил диалог
            go!: /newNode_7
