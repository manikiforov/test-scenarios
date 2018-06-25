
theme: /

    state: newNode_0
        a:  Скажи мне "Привет" или "Пока".
            Или синонимы этих слов
        go!: /newNode_1
    @IntentGroup
        {
          "boundsTo" : "/newNode_0",
          "global" : true,
          "fallback" : "/newNode_4",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "привет"
                }
              ],
              "then" : "/newNode_2"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "пока"
                }
              ],
              "then" : "/newNode_3"
            }
          ]
        }
    state: newNode_1
        state: 1
            e!: привет

            go!: /newNode_2

        state: 2
            e!: пока

            go!: /newNode_3

        state: Fallback
            q: *
            go!: /newNode_4

    state: newNode_2
        a: Ну привет!
        buttons:
            "в текстовый бло" -> /newNode_5

    state: newNode_3
        a: Ну пока
        buttons:
            "в цифровой блок" -> /newNode_6

    state: newNode_4
        a: Непонятно
    @InputText
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "prompt" : "Введите текст",
          "varName" : "text",
          "then" : "/newNode_7"
        }
    state: newNode_5
        a: Введите текст

        state: CatchText || modal = true
            q: *
            script:
                $session.text = $parseTree.text;
            go!: /newNode_7
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_5",
                name: "newNode_5 buttons",
                handler: function($context) {
                  $reactions.buttons([
                  ]);
                }
            });
    @InputNumber
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "prompt" : "Введите число",
          "varName" : "number",
          "minValue" : 1,
          "maxValue" : 5,
          "failureMessage" : [
            "Введите число от 1 до 5"
          ],
          "then" : "/newNode_8"
        }
    state: newNode_6
        a: Введите число

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
                go!: /newNode_8
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_6",
                name: "newNode_6 buttons",
                handler: function($context) {
                  $reactions.buttons([
                  ]);
                }
            });

    state: newNode_7
        a: {{$session.text}} вы вввели
        go!: /newNode_10
    @Transition
        {
          "boundsTo" : "/newNode_7",
          "then" : "/newNode_0"
        }
    state: newNode_10
        go!: /newNode_0

    state: newNode_8
        a: {{$session.number}}  цифра лол
        go!: /newNode_9
    @Transition
        {
          "boundsTo" : "/newNode_8",
          "then" : "/newNode_0"
        }
    state: newNode_9
        go!: /newNode_0
