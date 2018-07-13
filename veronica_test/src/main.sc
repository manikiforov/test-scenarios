require: all.sc
    module = common
require: patterns.sc
    module = common

theme: /

    state: newNode_0
        e!: start
        a: Мы стартанули!
        go!: /newNode_1
    @InputText
        {
          "prompt" : "Введите текст",
          "varName" : "tex",
          "then" : "/newNode_3"
        }
    state: newNode_1
        a: Введите текст

        state: CatchText || modal = true
            q: *
            script:
                $session.tex = $parseTree.text;
            go!: /newNode_3

    state: newNode_2
        a: Вы сказали {{$parseTree.tex}}
        a: Ваше число - {{$parseTree.numb}}
    @InputNumber
        {
          "prompt" : "Ввод числа",
          "varName" : "number",
          "minValue" : 1,
          "maxValue" : 5,
          "failureMessage" : [
            "Введите число от 1 до 5",
            "Где твои мозги?!"
          ],
          "then" : "/newNode_2"
        }
    state: newNode_3
        a: Ввод числа

        state: CatchNumber
            q: $Number
            script:
                var failureMessages = [
                    "Введите число от 1 до 5",
                    "Где твои мозги?!"
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
                go!: /newNode_2
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..
