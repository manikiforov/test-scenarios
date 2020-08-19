
theme: /

    state: newNode_011
        random:
            a: Здравствуйте!!!!  Вы записаны на прием к врачу на завтрашний день. Подтвердите, пожалуйста, ваше присутствие.
        go!: /newNode_1
    @IntentGroup
        {
          "boundsTo" : "/newNode_0",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_6",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Подтверждаю"
                },
                {
                  "type" : "example",
                  "value" : "Буду"
                },
                {
                  "type" : "example",
                  "value" : "Приду"
                },
                {
                  "type" : "example",
                  "value" : "Ждите"
                }
              ],
              "then" : "/newNode_2"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Отказываю"
                },
                {
                  "type" : "example",
                  "value" : "Не смогу"
                },
                {
                  "type" : "example",
                  "value" : "Не получится"
                },
                {
                  "type" : "example",
                  "value" : "В другой раз"
                }
              ],
              "then" : "/newNode_4"
            }
          ]
        }
    state: newNode_1
        state: 1
            e: Подтверждаю!!!
            e: Буду
            e: Приду
            e: Ждите

            go!: /newNode_2

        state: 2
            e: Отказываю
            e: Не смогу!!!
            e: Не получится
            e: В другой раз

            go!: /newNode_4

        state: Fallback
            q: *
            go!: /newNode_6
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_1",
                name: "newNode_1 buttons",
                handler: function($context) {
                }
            });

    state: newNode_2
        random:
            a:  Спасибо за информацию! Ждем вас в назначенное время.
                Хорошего дня!
        go!: /newNode_3
    @EndSession
        {
          "boundsTo" : "/newNode_2"
        }
    state: newNode_3
        script:
            $session = new Object();
            $response.endSession = true;

    state: newNode_4
        random:
            a: Хотели бы вы перенести ваш прием на другое время или планируете отказаться от посещения?
        go!: /newNode_5
    @IntentGroup
        {
          "boundsTo" : "/newNode_4",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Перенести"
                },
                {
                  "type" : "example",
                  "value" : "Скорректировать"
                },
                {
                  "type" : "example",
                  "value" : "Сменить время"
                },
                {
                  "type" : "example",
                  "value" : "Сменить дату"
                },
                {
                  "type" : "example",
                  "value" : "В другое время"
                }
              ],
              "then" : "/newNode_10"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Отказаться"
                },
                {
                  "type" : "example",
                  "value" : "Не смогу"
                },
                {
                  "type" : "example",
                  "value" : "Не получится"
                },
                {
                  "type" : "example",
                  "value" : "Не интересно"
                }
              ],
              "then" : "/newNode_15"
            }
          ]
        }
    state: newNode_5
        state: 1
            e: Перенести
            e: Скорректировать
            e: Сменить время
            e: Сменить дату
            e: В другое время

            go!: /newNode_10

        state: 2
            e: Отказаться
            e: Не смогу
            e: Не получится
            e: Не интересно

            go!: /newNode_15
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_5",
                name: "newNode_5 buttons",
                handler: function($context) {
                }
            });

    state: newNode_6
        random:
            a: Не удалось разобрать ваш ответ. Подтверждаете ли вы посещение?
        go!: /newNode_7
    @IntentGroup
        {
          "boundsTo" : "/newNode_6",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_8",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Подтверждаю"
                },
                {
                  "type" : "example",
                  "value" : "Буду"
                },
                {
                  "type" : "example",
                  "value" : "Приду"
                },
                {
                  "type" : "example",
                  "value" : "Ждите"
                }
              ],
              "then" : "/newNode_2"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Отказываю"
                },
                {
                  "type" : "example",
                  "value" : "Не смогу"
                },
                {
                  "type" : "example",
                  "value" : "Не получится"
                },
                {
                  "type" : "example",
                  "value" : "В другой раз"
                }
              ],
              "then" : "/newNode_4"
            }
          ]
        }
    state: newNode_7
        state: 1
            e: Подтверждаю
            e: Буду
            e: Приду
            e: Ждите

            go!: /newNode_2

        state: 2
            e: Отказываю
            e: Не смогу
            e: Не получится
            e: В другой раз

            go!: /newNode_4

        state: Fallback
            q: *
            go!: /newNode_8
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_7",
                name: "newNode_7 buttons",
                handler: function($context) {
                }
            });

    state: newNode_8
        random:
            a: К сожалению, при обработке вашего ответа возникла ошибка. В ближайшее время наш оператор свяжется с вами.
        go!: /newNode_9
    @EndSession
        {
          "boundsTo" : "/newNode_8"
        }
    state: newNode_9
        script:
            $session = new Object();
            $response.endSession = true;

    state: newNode_10
        random:
            a: Укажите, пожалуйста, время и дату для повторного звонка.
        go!: /newNode_11
    @IntentGroup
        {
          "boundsTo" : "/newNode_10",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_12",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "$TEXT"
                }
              ],
              "then" : "/newNode_14"
            }
          ]
        }
    state: newNode_11
        state: 1
            q: $TEXT

            go!: /newNode_14

        state: Fallback
            q: *
            go!: /newNode_12
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_11",
                name: "newNode_11 buttons",
                handler: function($context) {
                }
            });

    state: newNode_12
        random:
            a: К сожалению, не удалось разобрать ваш ответ. Повторите, пожалуйста, пожелание относительно даты и времени повторного звонка.
        go!: /newNode_13
    @IntentGroup
        {
          "boundsTo" : "/newNode_12",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_8",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "$TEXT"
                }
              ],
              "then" : "/newNode_14"
            }
          ]
        }
    state: newNode_13
        state: 1
            q: $TEXT

            go!: /newNode_14

        state: Fallback
            q: *
            go!: /newNode_8
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_13",
                name: "newNode_13 buttons",
                handler: function($context) {
                }
            });

    state: newNode_14
        random:
            a:  Спасибо за информацию! Информация передана ответственному сотруднику.
                Хорошего дня!
        go!: /newNode_16
    @EndSession
        {
          "boundsTo" : "/newNode_14"
        }
    state: newNode_16
        script:
            $session = new Object();
            $response.endSession = true;

    state: newNode_15
        random:
            a: Спасибо за информацию! Если вы измените ваше решение, то позвоните по номеру +7 911 123 45 67.
        go!: /newNode_17
    @EndSession
        {
          "boundsTo" : "/newNode_15"
        }
    state: newNode_17
        script:
            $session = new Object();
            $response.endSession = true;
