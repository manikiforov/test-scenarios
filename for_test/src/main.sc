
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
          "then" : ""
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
                go!:
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..
