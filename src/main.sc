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
          "prompt" : "Введите текст или отправитесь играть в покер со Смертью!",
          "varName" : "text",
          "then" : "/newNode_2"
        }
    state: newNode_1
        a: Введите текст или отправитесь играть в покер со Смертью!

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
          "failureMessage" : [ "Введите число от 1 до 5", "Где твои мозги?!", "Не хотите в Болливуд?!" ]
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
                go!:
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..
