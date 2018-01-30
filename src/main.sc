require: all.sc
require: patterns.sc
    module = common

theme: /

    state: 1
        q!: *
        a: Вы сказали: {{$parseTree.text}}
        a: параметры запроса: {{JSON.stringify($request.data)}}
        go!: /newNode_1
    @InputText
        {
          "prompt" : "Введите текст или отправитесь играть в покер со Смертью1!",
          "varName" : "text",
          "then" : "/newNode_2"
        }
    state: newNode_1
        a: Введите текст или отправитесь играть в покер со Смертью1!

        state: CatchText
            q: *
            script:
                $session.text = $parseTree.text;
            go!: /newNode_2
    @InputNumber
        {
          "prompt" : "Введите число, о Величаший!",
          "varName" : "number",
          "minValue" : -500,
          "maxValue" : 55,
          "failureMessage" : [ "Введите число от 1 до 5", "Где твои мозги?!", "Не хотите в Болливуд?!" ],
          "then" : "/newNode_4"
        }
    state: newNode_2
        a: Введите число, о Величаший!

        state: CatchNumber
            q: $Number
            script:
                var failureMessages = [
                    "Введите число от 1 до 5",
                    "Где твои мозги?!",
                    "Не хотите в Болливуд?!"
                ];
                var failureRandom = failureMessages[$reactions.random(failureMessages.length)];
                if ($parseTree._Number < -500) {
                    $reactions.answer(failureRandom);
                } else
                if ($parseTree._Number > 55) {
                    $reactions.answer(failureRandom);
                } else
                {
                    $session.number = $parseTree._Number;
                    $temp.number_ok = true;
                }
            if: $temp.number_ok
                go!: /newNode_4
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..

    state: newNode_3
        a: пыщ!
    @Confirmation
        {
          "prompt" : "Вы согласны перейти в плоский мир?",
          "agreeState" : "/newNode_3",
          "disagreeState" : "/1",
          "useButtons" : true,
          "agreeButton" : "Дя",
          "disagreeButton" : "Нэт"
        }
    state: newNode_4
        a: Вы согласны перейти в плоский мир?
        buttons:
            "Дя" -> Agree
            "Нэт" -> Disagree
        state: Agree
            q: $agree
            go!: /newNode_3
        state: Disagree
            q: $disagree
            go!: /1
