
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
          "agreeState" : "",
          "disagreeState" : "",
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
            go!:
        state: Disagree
            q: $disagree
            go!:
