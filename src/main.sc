
theme: /

    state: newNode_0
        if: $session.transition
            go!: /newNode_80
        else:
            go!: /newNode_78

    state: newNode_80
        random:
            a:  Привет! 🙂
                Я робот-рекрутер компании Л’Этуаль - крупной сети магазинов парфюмерии и косметики!
                Мы приглашаем тех, кому интересна работа в атмосфере абсолютной роскоши и комфорта с культовыми творениями мировых брендов  и новинками макияжа, ухода за кожей и ароматов в качестве продавца-консультанта в новый флагманский магазин в ТЦ Авиапарк (м. ЦСКА).
        go!: /newNode_81
    @Transition
        {
          "boundsTo" : "/newNode_80",
          "then" : "/newNode_106"
        }
    state: newNode_81
        go!: /newNode_106

    state: newNode_78
        random:
            a:  Привет! 🙂
                Я робот-рекрутер компании Л’Этуаль - крупной сети магазинов парфюмерии и косметики!
                Мы приглашаем тех, кому интересна работа в атмосфере абсолютной роскоши и комфорта с культовыми творениями мировых брендов  и новинками макияжа, ухода за кожей и ароматов в качестве продавца-консультанта в новый флагманский магазин в ТЦ Авиапарк (м. ЦСКА).
        random:
            a:  Хочешь хорошо зарабатывать, каждое лето посещать Париж за счет Компании и стать классным Beauty-экспертом?
                Тогда тебе точно к нам!
        random:
            a:  Я расскажу тебе об уникальных условиях работы в нашей компании и запишу тебя на собеседование 😉
                Ты готова рассматривать вакансию продавца-консультанта в ТЦ Авиапарк?
        go!: /newNode_79
    @IntentGroup
        {
          "boundsTo" : "/newNode_78",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Да",
                  "transition" : "/newNode_2"
                },
                {
                  "name" : "Нет",
                  "transition" : "/newNode_1"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_78",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "ответить на вопросы"
                },
                {
                  "type" : "example",
                  "value" : "Да, перейти к вопросам"
                },
                {
                  "type" : "example",
                  "value" : "перейти к вопросам"
                },
                {
                  "type" : "example",
                  "value" : "да"
                },
                {
                  "type" : "example",
                  "value" : "да перейти к вопросам"
                },
                {
                  "type" : "example",
                  "value" : "согласна"
                },
                {
                  "type" : "pattern",
                  "value" : "Дальше"
                },
                {
                  "type" : "pattern",
                  "value" : "Далее"
                }
              ],
              "then" : "/newNode_2"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Нет, мне не очень интересно"
                },
                {
                  "type" : "example",
                  "value" : "не очень интересно"
                },
                {
                  "type" : "example",
                  "value" : "нет"
                },
                {
                  "type" : "example",
                  "value" : "неинтересно"
                },
                {
                  "type" : "example",
                  "value" : "не хочу"
                }
              ],
              "then" : "/newNode_1"
            }
          ]
        }
    state: newNode_79
        state: 1
            e: ответить на вопросы
            e: Да, перейти к вопросам
            e: перейти к вопросам
            e: да
            e: да перейти к вопросам
            e: согласна
            q: Дальше
            q: Далее

            go!: /newNode_2

        state: 2
            e: Нет, мне не очень интересно
            e: не очень интересно
            e: нет
            e: неинтересно
            e: не хочу

            go!: /newNode_1

        state: Fallback
            q: *
            go!: /newNode_78
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_79",
                name: "newNode_79 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Да"
                    , transition: "/newNode_2"
                    },
                    {text: "Нет"
                    , transition: "/newNode_1"
                    },
                  ]);
                }
            });

    state: newNode_2
        random:
            a:  Что тебя ждёт:
                - защищенность, стабильность и уверенность в завтрашнем дне
                - оформление в соответствии с ТК РФ
                - график работы 2/2
                - ФИКСИРОВАННАЯ СТАВКА 50 000 + % ОТ ЛИЧНЫХ ПРОДАЖ
                СРЕДНИЙ ДОХОД от 80 000 тыс. рублей. в месяц. Весь доход официальный.
                - бесплатные обеды и кофе-брейки
                - место работы: новый флагманский магазин в ТЦ "Авиапарк"
        random:
            a:  - профессиональное обучение за счет Компании
                - интересная и престижная работа в команде Профессионалов
                - неограниченная возможность зарабатывать
                - уникальная программа карьерного роста
                ПОЕЗДКА В ПАРИЖ КАЖДЫЙ ГОД ЗА СЧЕТ КОМПАНИИ! 🗼
        random:
            a:  Мы открываем новые возможности для самореализации и создаем все условия для твоего развития. Присоединяйся к команде профессионалов Л’Этуаль и воспользуйся шансом осуществить свои мечты! 😉
                Ответь, пожалуйста, на несколько вопросов. Это не займет много времени.
        go!: /newNode_10
    @IntentGroup
        {
          "boundsTo" : "/newNode_2",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Ответить на вопросы",
                  "transition" : "/newNode_106"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_2",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "ответить на вопросы"
                },
                {
                  "type" : "example",
                  "value" : "заполнить анкету"
                },
                {
                  "type" : "example",
                  "value" : "перейти к вопросам"
                },
                {
                  "type" : "example",
                  "value" : "какие вопросы"
                },
                {
                  "type" : "pattern",
                  "value" : "далее"
                },
                {
                  "type" : "pattern",
                  "value" : "дальше"
                },
                {
                  "type" : "example",
                  "value" : "вопросы"
                }
              ],
              "then" : "/newNode_106"
            }
          ]
        }
    state: newNode_10
        state: 1
            e: ответить на вопросы
            e: заполнить анкету
            e: перейти к вопросам
            e: какие вопросы
            e: вопросы
            q: далее
            q: дальше

            go!: /newNode_106

        state: Fallback
            q: *
            go!: /newNode_2
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_10",
                name: "newNode_10 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Ответить на вопросы"
                    , transition: "/newNode_106"
                    },
                  ]);
                }
            });

    state: newNode_1
        random:
            a:  Я понял, очень жаль!
                Может в другой раз тебе будет интереснее. Удачи в поисках работы мечты!
        go!: /newNode_6
    @IntentGroup
        {
          "boundsTo" : "/newNode_1",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "И все-таки ДА 😉",
                  "transition" : "/newNode_2"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "перейти к вопросам"
                },
                {
                  "type" : "example",
                  "value" : "еще раз"
                },
                {
                  "type" : "example",
                  "value" : "вакансия интересна"
                },
                {
                  "type" : "example",
                  "value" : "вернуться"
                },
                {
                  "type" : "example",
                  "value" : "интересно"
                },
                {
                  "type" : "example",
                  "value" : "хочу работать"
                }
              ],
              "then" : "/newNode_2"
            }
          ]
        }
    state: newNode_6
        state: 1
            e: перейти к вопросам
            e: еще раз
            e: вакансия интересна
            e: вернуться
            e: интересно
            e: хочу работать

            go!: /newNode_2
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_6",
                name: "newNode_6 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "И все-таки ДА 😉"
                    , transition: "/newNode_2"
                    },
                  ]);
                }
            });
    @InputText
        {
          "boundsTo" : "",
          "title" : "ФИО",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "prompt" : "Напиши, пожалуйста, имя и фамилию 🙂",
          "varName" : "name",
          "then" : "/newNode_73"
        }
    state: newNode_106 || modal = true
        a: Напиши, пожалуйста, имя и фамилию 🙂

        state: CatchText
            q: *
            script:
                $session.name = $parseTree.text;
            go!: /newNode_73
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_106",
                name: "newNode_106 buttons",
                handler: function($context) {
                }
            });

    state: newNode_15
        random:
            a: Приятно познакомиться, {{$session.name.firstName}}! 😉
        go!: /newNode_130
    @InputPhoneNumber
        {
          "boundsTo" : "/newNode_15",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "prompt" : "Пожалуйста, введи свой номер телефона, чтобы мы пригласили тебя на собеседование, например, 89998887766 📲",
          "varName" : "phone",
          "failureMessage" : [
            "Что-то не так, пожалуйста, напиши номер еще раз 🙂"
          ],
          "then" : "/newNode_95"
        }
    state: newNode_130
        a: Пожалуйста, введи свой номер телефона, чтобы мы пригласили тебя на собеседование, например, 89998887766 📲

        state: CatchPhoneNumber
            q: $mobilePhoneNumber
            script:
                $session.phone = $parseTree._mobilePhoneNumber;
            go!: /newNode_95

        state: WrongPhoneNumber
            script:
                var failureMessages = [
                    "Что-то не так, пожалуйста, напиши номер еще раз 🙂"
                ];
                $temp.failureRandom = failureMessages[$reactions.random(failureMessages.length)];
                $reactions.answer($temp.failureRandom);
            go: ../CatchPhoneNumber

        state: CatchAll
            q: *
            go!: ../WrongPhoneNumber
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_130",
                name: "newNode_130 buttons",
                handler: function($context) {
                }
            });

    state: newNode_95
        if: $session.phone
            go!: /newNode_98
        else:
            go!: /newNode_96

    state: newNode_98
        random:
            a: Хорошо, теперь мы будем на связи. Идем дальше 😉
        go!: /newNode_101
    @Transition
        {
          "boundsTo" : "/newNode_98",
          "then" : "/newNode_97"
        }
    state: newNode_101
        go!: /newNode_97

    state: newNode_97
        random:
            a: Уточни, пожалуйста, свой пол.
        go!: /newNode_102
    @IntentGroup
        {
          "boundsTo" : "/newNode_97",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Женский",
                  "transition" : ""
                },
                {
                  "name" : "Мужской",
                  "transition" : ""
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_97",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "$sex"
                }
              ],
              "then" : "/newNode_131"
            }
          ]
        }
    state: newNode_102
        state: 1
            e: $sex

            go!: /newNode_131

        state: Fallback
            q: *
            go!: /newNode_97
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_102",
                name: "newNode_102 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Женский"
                    },
                    {text: "Мужской"
                    },
                  ]);
                }
            });

    state: newNode_18
        random:
            a: В каком городе ты живёшь?
        go!: /newNode_21
    @IntentGroup
        {
          "boundsTo" : "/newNode_18",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_18",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "$city"
                }
              ],
              "then" : "/newNode_140"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "$CITY::city"
                }
              ],
              "then" : "/newNode_140"
            }
          ]
        }
    state: newNode_21
        state: 1
            e: $city

            go!: /newNode_140

        state: 2
            e: $CITY::city

            go!: /newNode_140

        state: Fallback
            q: *
            go!: /newNode_18
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_21",
                name: "newNode_21 buttons",
                handler: function($context) {
                }
            });

    state: newNode_23
        random:
            a: Какое у тебя гражданство?
        go!: /newNode_24
    @IntentGroup
        {
          "boundsTo" : "/newNode_23",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Россия",
                  "transition" : ""
                },
                {
                  "name" : "Другое",
                  "transition" : ""
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_23",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "$citizenship"
                }
              ],
              "then" : "/newNode_146"
            }
          ]
        }
    state: newNode_24
        state: 1
            e: $citizenship

            go!: /newNode_146

        state: Fallback
            q: *
            go!: /newNode_23
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_24",
                name: "newNode_24 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Россия"
                    },
                    {text: "Другое"
                    },
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
          "prompt" : "Сколько тебе лет?",
          "varName" : "age",
          "failureMessage" : [
            "Напиши, пожалуйста, цифрой сколько тебе лет, например, 18."
          ],
          "then" : "/newNode_99",
          "minValue" : 14,
          "maxValue" : 100
        }
    state: newNode_85
        a: Сколько тебе лет?

        state: CatchNumber
            q: $Number
            script:
                var failureMessages = [
                    "Напиши, пожалуйста, цифрой сколько тебе лет, например, 18."
                ];
                var failureRandom = failureMessages[$reactions.random(failureMessages.length)];
                if ($parseTree._Number < 14) {
                    $reactions.answer(failureRandom);
                } else
                if ($parseTree._Number > 100) {
                    $reactions.answer(failureRandom);
                } else
                {
                    $session.age = $parseTree._Number;
                    $temp.age_ok = true;
                }
            if: $temp.age_ok
                go!: /newNode_99
            else:
                go: CatchNumber

        state: CatchAll
            q: *
            go!: ..
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_85",
                name: "newNode_85 buttons",
                handler: function($context) {
                }
            });

    state: newNode_99
        if: $session.sex && $session.sex === "Женский"
            go!: /newNode_148
        else:
            go!: /newNode_134

    state: newNode_148
        random:
            a:  В Л’Этуаль тебе предстоит работать с большим ассортиментом продукции, общаться с покупателями и помогать им сделать самый правильный выбор. 😊
                Тебе интересен мир косметики, парфюмерии и красоты, ты готова к работе продавца-консультанта?
        go!: /newNode_105
    @IntentGroup
        {
          "boundsTo" : "/newNode_148",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Да",
                  "transition" : ""
                },
                {
                  "name" : "Нет",
                  "transition" : ""
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_148",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "$ready"
                }
              ],
              "then" : "/newNode_133"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "далее"
                },
                {
                  "type" : "pattern",
                  "value" : "дальше"
                }
              ],
              "then" : "/newNode_148"
            }
          ]
        }
    state: newNode_105
        state: 1
            e: $ready

            go!: /newNode_133

        state: 2
            q: далее
            q: дальше

            go!: /newNode_148

        state: Fallback
            q: *
            go!: /newNode_148
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_105",
                name: "newNode_105 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Да"
                    },
                    {text: "Нет"
                    },
                  ]);
                }
            });

    state: newNode_120
        random:
            a:  {{$session.name.firstName}}, спасибо что уделила мне время и ответила на мои вопросы. 🙂
                Мы приглашаем тебя на собеседование.
                Собеседования проходят с понедельника по пятницу в 11:00 и в 14:00 (время московское).
        go!: /newNode_121
    @Transition
        {
          "boundsTo" : "/newNode_120",
          "then" : "/newNode_59"
        }
    state: newNode_121
        go!: /newNode_59

    state: newNode_59
        if: $session.datePoints = 10
            go!: /newNode_60
        else:
            go!: /newNode_60

    state: newNode_60
        if: $session.formattedDates && $session.formattedDates.length > 0
            go!: /newNode_57
        else:
            go!: /newNode_57

    state: newNode_134
        random:
            a:  {{$session.name.firstName}}, спасибо за уделенное время и ответы на все мои вопросы!
                Мы рассмотрим твою анкету. В случае заинтересованности мы свяжемся с тобой! 🙂
        go!: /newNode_123
    @IntentGroup
        {
          "boundsTo" : "/newNode_134",
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
                  "type" : "pattern",
                  "value" : "*"
                }
              ],
              "then" : "/newNode_92"
            }
          ]
        }
    state: newNode_123
        state: 1
            q: *

            go!: /newNode_92
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_123",
                name: "newNode_123 buttons",
                handler: function($context) {
                }
            });

    state: newNode_118
        if: $session.date && $session.parsedDate
            go!: /newNode_65
        elseif: $session.parsedDate
            go!: /newNode_61
        else:
            go!: /newNode_62

    state: newNode_57
        random:
            a:  Список ближайших дат собеседований.
                Введи порядковую цифру даты, которая удобна тебе. Например, 1: {{$session.formattedDates}}
        go!: /newNode_132
    @IntentGroup
        {
          "boundsTo" : "/newNode_57",
          "actions" : [ ],
          "global" : false,
          "fallback" : "/newNode_57",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "$TEXT::date"
                }
              ],
              "then" : "/newNode_118"
            }
          ]
        }
    state: newNode_132
        state: 1
            q: $TEXT::date

            go!: /newNode_118

        state: Fallback
            q: *
            go!: /newNode_57

    state: newNode_65
        random:
            a:  Введи порядковую цифру удобного для тебя времени\или введи цифру 0 для возврата к выбору даты:
                {{$session.formattedTimeDict[$session.date]}}
        go!: /newNode_66
    @IntentGroup
        {
          "boundsTo" : "/newNode_65",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Вернуться к выбору даты",
                  "transition" : "/newNode_57"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_65",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : " $TEXT::time"
                }
              ],
              "then" : "/newNode_67"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Вернуться к выбору даты"
                }
              ],
              "then" : "/newNode_57"
            },
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "0"
                }
              ],
              "then" : "/newNode_57"
            }
          ]
        }
    state: newNode_66
        state: 1
            q:  $TEXT::time

            go!: /newNode_67

        state: 2
            e: Вернуться к выбору даты

            go!: /newNode_57

        state: 3
            q: 0

            go!: /newNode_57

        state: Fallback
            q: *
            go!: /newNode_65
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_66",
                name: "newNode_66 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Вернуться к выбору даты"
                    , transition: "/newNode_57"
                    },
                  ]);
                }
            });

    state: newNode_67
        if: $session.time && $session.parsedTime
            go!: /newNode_74
        elseif: $session.parsedTime
            go!: /newNode_68
        else:
            go!: /newNode_70

    state: newNode_74
        if: $session.job_interview
            go!: /newNode_77
        else:
            go!: /newNode_75

    state: newNode_91
        random:
            a: Мне было очень приятно с тобой общаться! Желаю успехов на собеседовании!
        go!: /newNode_94
    @IntentGroup
        {
          "boundsTo" : "/newNode_91",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_91",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "спасибо"
                }
              ],
              "then" : "/newNode_179"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "схема"
                },
                {
                  "type" : "example",
                  "value" : "проезд"
                },
                {
                  "type" : "example",
                  "value" : "схема проезда"
                },
                {
                  "type" : "example",
                  "value" : "как проехать"
                },
                {
                  "type" : "example",
                  "value" : "проехать"
                },
                {
                  "type" : "example",
                  "value" : "как найти"
                },
                {
                  "type" : "example",
                  "value" : "найти"
                },
                {
                  "type" : "example",
                  "value" : "подробнее"
                }
              ],
              "then" : "/newNode_103"
            }
          ]
        }
    state: newNode_94
        state: 1
            e: спасибо

            go!: /newNode_179

        state: 2
            e: схема
            e: проезд
            e: схема проезда
            e: как проехать
            e: проехать
            e: как найти
            e: найти
            e: подробнее

            go!: /newNode_103

        state: Fallback
            q: *
            go!: /newNode_91
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_94",
                name: "newNode_94 buttons",
                handler: function($context) {
                }
            });

    state: newNode_73
        if: $session.name && $session.name.firstName && $session.name.recognized
            go!: /newNode_15
        elseif: $session.name && $session.name.firstName && $session.name.surName && $session.name.patrName && !$session.name.recognized
            go!: /newNode_107
        elseif: $session.name && $session.name.firstName && $session.name.surName && !$session.name.recognized
            go!: /newNode_108
        else:
            go!: /newNode_106

    state: newNode_92
        random:
            a:  {{$session.name.firstName}}, спасибо за уделенное время и ответы на все мои вопросы!
                Мы рассмотрим твою анкету. В случае заинтересованности мы свяжемся с тобой! 🙂
        go!: /newNode_93
    @IntentGroup
        {
          "boundsTo" : "/newNode_92",
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
                  "type" : "pattern",
                  "value" : "*"
                }
              ],
              "then" : "/newNode_92"
            }
          ]
        }
    state: newNode_93
        state: 1
            q: *

            go!: /newNode_92
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_93",
                name: "newNode_93 buttons",
                handler: function($context) {
                }
            });

    state: newNode_96
        random:
            a: Дождись, пожалуйста, ответа от Л`Этауль, у нас уже есть твой отклик.
        go!: /newNode_116
    @IntentGroup
        {
          "boundsTo" : "/newNode_96",
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
                  "type" : "pattern",
                  "value" : "*"
                }
              ],
              "then" : "/newNode_96"
            }
          ]
        }
    state: newNode_116
        state: 1
            q: *

            go!: /newNode_96
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_116",
                name: "newNode_116 buttons",
                handler: function($context) {
                }
            });

    state: newNode_179
        random:
            a: Всегда рад помочь 🙂
        go!: /newNode_180
    @IntentGroup
        {
          "boundsTo" : "/newNode_179",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_91",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "pattern",
                  "value" : "*"
                }
              ],
              "then" : "/newNode_179"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "схема"
                },
                {
                  "type" : "example",
                  "value" : "проезд"
                },
                {
                  "type" : "example",
                  "value" : "схема проезда"
                },
                {
                  "type" : "example",
                  "value" : "как проехать"
                },
                {
                  "type" : "example",
                  "value" : "проехать"
                },
                {
                  "type" : "example",
                  "value" : "как найти"
                },
                {
                  "type" : "example",
                  "value" : "найти"
                },
                {
                  "type" : "example",
                  "value" : "подробнее"
                }
              ],
              "then" : "/newNode_103"
            }
          ]
        }
    state: newNode_180
        state: 1
            q: *

            go!: /newNode_179

        state: 2
            e: схема
            e: проезд
            e: схема проезда
            e: как проехать
            e: проехать
            e: как найти
            e: найти
            e: подробнее

            go!: /newNode_103

        state: Fallback
            q: *
            go!: /newNode_91
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_180",
                name: "newNode_180 buttons",
                handler: function($context) {
                }
            });

    state: newNode_103
        random:
            a:  Подробная схема проезда (Симферопольский бульвар, д. 28, к.1):
                м. Чертановская, последний вагон из центра.
                Поднимаемся по эскалатору. После стеклянных дверей поворачиваем направо и идем по подземному переходу. В конце перехода  -  тоже направо. Выходим на Симферопольский бульвар (справа трамвайные пути).
        random:
            a: Идем прямо, до пересечения со Старобалаклавской улицей. Переходим ее по наземному переходу. Левее видим парковку. За ней находится здание коттеджного типа с красной крышей. Вход в металлическую дверь двухэтажного корпуса.
        image: https://248305.selcdn.ru/zfl_prod/81737966/81737969/zzCcrjY6CHbhWstn.png
        random:
            a: Также всю информацию я продублировал в смс.
        go!: /newNode_104
    @IntentGroup
        {
          "boundsTo" : "/newNode_103",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_91",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "схема"
                },
                {
                  "type" : "example",
                  "value" : "проезд"
                },
                {
                  "type" : "example",
                  "value" : "схема проезда"
                },
                {
                  "type" : "example",
                  "value" : "как проехать"
                },
                {
                  "type" : "example",
                  "value" : "проехать"
                },
                {
                  "type" : "example",
                  "value" : "как найти"
                },
                {
                  "type" : "example",
                  "value" : "найти"
                },
                {
                  "type" : "example",
                  "value" : "подробнее"
                }
              ],
              "then" : "/newNode_103"
            }
          ]
        }
    state: newNode_104
        state: 1
            e: схема
            e: проезд
            e: схема проезда
            e: как проехать
            e: проехать
            e: как найти
            e: найти
            e: подробнее

            go!: /newNode_103

        state: Fallback
            q: *
            go!: /newNode_91
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_104",
                name: "newNode_104 buttons",
                handler: function($context) {
                }
            });

    state: newNode_107
        random:
            a:  Пожалуйста, подтверди, что твои:
                Фамилия - {{$session.name.surName}}
                Имя - {{$session.name.firstName}}
                Отчество - {{$session.name.patrName}}
        go!: /newNode_127
    @IntentGroup
        {
          "boundsTo" : "/newNode_107",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Да",
                  "transition" : ""
                },
                {
                  "name" : "Нет",
                  "transition" : ""
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_107",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "$yes"
                }
              ],
              "then" : "/newNode_15"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "$no"
                }
              ],
              "then" : "/newNode_106"
            }
          ]
        }
    state: newNode_127
        state: 1
            e: $yes

            go!: /newNode_15

        state: 2
            e: $no

            go!: /newNode_106

        state: Fallback
            q: *
            go!: /newNode_107
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_127",
                name: "newNode_127 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Да"
                    },
                    {text: "Нет"
                    },
                  ]);
                }
            });

    state: newNode_108
        random:
            a:  Пожалуйста, подтверди, что твои:
                Фамилия - {{$session.name.surName}}
                Имя - {{$session.name.firstName}}
        go!: /newNode_128
    @IntentGroup
        {
          "boundsTo" : "/newNode_108",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Да",
                  "transition" : ""
                },
                {
                  "name" : "Нет",
                  "transition" : ""
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_108",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "$yes"
                }
              ],
              "then" : "/newNode_15"
            },
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "$no"
                }
              ],
              "then" : "/newNode_106"
            }
          ]
        }
    state: newNode_128
        state: 1
            e: $yes

            go!: /newNode_15

        state: 2
            e: $no

            go!: /newNode_106

        state: Fallback
            q: *
            go!: /newNode_108
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_128",
                name: "newNode_128 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Да"
                    },
                    {text: "Нет"
                    },
                  ]);
                }
            });

    state: newNode_131
        random:
            a: Спасибо.
        go!: /newNode_139
    @Transition
        {
          "boundsTo" : "/newNode_131",
          "then" : "/newNode_18"
        }
    state: newNode_139
        go!: /newNode_18

    state: newNode_140
        random:
            a: Понял 🙂
        go!: /newNode_115
    @Transition
        {
          "boundsTo" : "/newNode_140",
          "then" : "/newNode_23"
        }
    state: newNode_115
        go!: /newNode_23

    state: newNode_146
        random:
            a: 🙂
        go!: /newNode_147
    @Transition
        {
          "boundsTo" : "/newNode_146",
          "then" : "/newNode_85"
        }
    state: newNode_147
        go!: /newNode_85

    state: newNode_133
        if: $session.score >= 100
            go!: /newNode_120
        else:
            go!: /newNode_134

    state: newNode_61
        random:
            a: К сожалению, эта дата недоступна для собеседования...
        go!: /newNode_63
    @Transition
        {
          "boundsTo" : "/newNode_61",
          "then" : "/newNode_57"
        }
    state: newNode_63
        go!: /newNode_57

    state: newNode_62
        random:
            a: Извини, я тебя не понял. Попробуй ввести дату еще раз, пожалуйста.
        go!: /newNode_64
    @Transition
        {
          "boundsTo" : "/newNode_62",
          "then" : "/newNode_57"
        }
    state: newNode_64
        go!: /newNode_57

    state: newNode_68
        random:
            a: К сожалению, это время недоступно для собеседования...
        go!: /newNode_72
    @Transition
        {
          "boundsTo" : "/newNode_68",
          "then" : "/newNode_65"
        }
    state: newNode_72
        go!: /newNode_65

    state: newNode_70
        random:
            a: Извини, я тебя не понял. Попробуй выбрать время еще раз, пожалуйста.
        go!: /newNode_71
    @Transition
        {
          "boundsTo" : "/newNode_70",
          "then" : "/newNode_65"
        }
    state: newNode_71
        go!: /newNode_65

    state: newNode_75
        random:
            a: К сожалению, я не смог записать тебя на собеседование. Пожалуйста, попробуй еще раз.
        go!: /newNode_76
    @IntentGroup
        {
          "boundsTo" : "/newNode_75",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [
                {
                  "name" : "Записаться на собеседование",
                  "transition" : "/newNode_60"
                }
              ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_75",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "Записаться на собеседование"
                }
              ],
              "then" : "/newNode_60"
            }
          ]
        }
    state: newNode_76
        state: 1
            e: Записаться на собеседование

            go!: /newNode_60

        state: Fallback
            q: *
            go!: /newNode_75
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_76",
                name: "newNode_76 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Записаться на собеседование"
                    , transition: "/newNode_60"
                    },
                  ]);
                }
            });

    state: newNode_77
        random:
            a:  Отлично, мы будем ждать тебя {{$session.job_interview.date}} в {{$session.job_interview.time}}.
                Мы ждём тебя по адресу: г.Москва, Симферопольский бульвар, д. 28, к.1.
                Путь от метро Чертановская займет не более 5 минут.
                Приходи на собеседование, будет интересно! 🙂
        random:
            a: Если у тебя возникнут вопросы или ты захочешь перенести встречу, звони: 8(495) 937-07-29 или 8-916-690-73-65
        go!: /newNode_82
    @Transition
        {
          "boundsTo" : "/newNode_77",
          "then" : "/newNode_83"
        }
    state: newNode_82
        go!: /newNode_83
    @HttpRequest
        {
          "boundsTo" : "",
          "title" : "отправка смс",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "url" : "https://hh.aimylogic.com/sms",
          "method" : "POST",
          "dataType" : "json",
          "body" : "{\r\n    \"phone\": \"{{$session.phone}}\",\r\n    \"message\": \"Собеседование в Л`Этуаль {{$session.job_interview.date}} в {{$session.job_interview.time}}. Адрес: https://bitly.su/9MvrHt\"\r\n}\r\n",
          "okState" : "/newNode_103",
          "errorState" : "/newNode_103",
          "timeout" : 0,
          "headers" : [ ],
          "vars" : [ ]
        }
    state: newNode_83
        script:
            var headers = {
            };
            var result = $http.query("https://hh.aimylogic.com/sms", {
                method: "POST",
                headers: headers,
                query: $session,
                body: _.template("{\r    \"phone\": \"{{$session.phone}}\",\r    \"message\": \"Собеседование в Л`Этуаль {{$session.job_interview.date}} в {{$session.job_interview.time}}. Адрес: https://bitly.su/9MvrHt\"\r}\r", {variable: '$session'})($session),
                dataType: "json",
                timeout: 0 || 10000
            });
            var $httpResponse = result.data;
            $session.httpStatus = result.status;
            $session.httpResponse = $httpResponse;
            if (result.isOk && result.status >= 200 && result.status < 300) {
                $reactions.transition("/newNode_103");
            } else {
                $reactions.transition("/newNode_103");
            }
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_83",
                name: "newNode_83 buttons",
                handler: function($context) {
                }
            });
