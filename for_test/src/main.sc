<<<<<<< HEAD
require: all.sc
    module = common
require: patterns.sc
    module = common
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
            "Ты не понял? От 0 до 10!!!"
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
                    "Ты не понял? От 0 до 10!!!"
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
          "onClose" : "/newNode_6",
          "chatClosedMessage" : "Оператор завершил диалог",
          "noOperatorsOnlineState" : "/newNode_5"
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
            go!: /newNode_5
        state: NoOperatorsOnline
            event: noLivechatOperatorsOnline
            go!: /newNode_5
        state: LivechatReset
            event: livechatFinished
            a: Оператор завершил диалог
            go!: /newNode_6

    state: newNode_4
        a: Такой кекас!

    state: newNode_5
        image: https://248305.selcdn.ru/public_test/39/80/IhNuQHjuw0ER1KHx.jpg

    state: newNode_6
        image: https://248305.selcdn.ru/public_test/39/80/ZpZAMAdFZtpCEAjO.png

    state: newNode_7
        q!: *
        a: Окей, начнем!
        go!: /newNode_8

    state: newNode_8
        random:
            go!: /newNode_9
            go!: /newNode_10
            go!: /newNode_11

    state: newNode_9
        a: 1

    state: newNode_10
        a: 2

    state: newNode_11
        a: 3
=======

theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}

    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.

    state: newNode_3
        a: kek?

    state: newNode_4
        a: not kek?

    state: newNode_5
        q!: pic
        image: https://cdn.iz.ru/sites/default/files/styles/900x506/public/article-2017-05/SZ_Blue_Sky_graded_300dpi.jpg?itok=8rYrZcWT
>>>>>>> branch 'nikitin' of https://bitbucket.org/just-ai/test_scenarios.git
