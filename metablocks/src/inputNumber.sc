
theme: /

    state: newNode_0
        q!: inputNumber
        go!: /newNode_1
    @InputNumber
        {
          "prompt" : "Ввод числа",
          "varName" : "numb",
          "minValue" : 1,
          "maxValue" : 5,
          "failureMessage" : [
            "Введите число от 1 до 5"
          ],
          "then" : "/newNode_2"
        }
    state: newNode_1
        a: Ввод числа

        state: CatchNumber
            q: $Number
            script:
                var failureMessages = [
                    "Введите число от 1 до 5"
                ];
                var failureRandom = failureMessages[$reactions.random(failureMessages.length)];
                if ($parseTree._Number < 1) {
                    $reactions.answer(failureRandom);
                } else
                if ($parseTree._Number > 5) {
                    $reactions.answer(failureRandom);
                } else
                {
                    $session.numb = $parseTree._Number;
                    $temp.numb_ok = true;
                }
            if: $temp.numb_ok
                go!: /newNode_2
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..

    state: newNode_2
        a: Ваше число - {{$parseTree.numb}}
