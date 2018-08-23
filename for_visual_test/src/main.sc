
theme: /

    state: newNode_0
        q!: *
        image: https://248305.selcdn.ru/zfl_prod/sadmin/tEwXdCr7DLb1swff.png
        go!: /newNode_1
    @InputText
        {
          "prompt" : "Введите текст",
          "varName" : "text",
          "then" : "/newNode_2"
        }
    state: newNode_1
        a: Введите текст

        state: CatchText || modal = true
            q: *
            script:
                $session.text = $parseTree.text;
            go!: /newNode_2
    @InputNumber
        {
          "prompt" : "Ввод числа",
          "varName" : "number",
          "failureMessage" : [
            "Введите число от 1 до 5"
          ],
          "then" : "/newNode_3",
          "minValue" : 1,
          "maxValue" : 5
        }
    state: newNode_2
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
                    $session.number = $parseTree._Number;
                    $temp.number_ok = true;
                }
            if: $temp.number_ok
                go!: /newNode_3
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..
    @Confirmation
        {
          "prompt" : "Вы согласны?",
          "agreeState" : "/newNode_0",
          "disagreeState" : "/newNode_5",
          "useButtons" : true,
          "agreeButton" : "Да",
          "disagreeButton" : "Нет"
        }
    state: newNode_3
        a: Вы согласны?
        buttons:
            "Да" -> Agree
            "Нет" -> Disagree
        state: Agree
            q: $agree
            go!: /newNode_0
        state: Disagree
            q: $disagree
            go!: /newNode_5

    state: newNode_5
        a: 654546546
