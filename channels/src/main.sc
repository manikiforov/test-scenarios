

theme: /

    init:
        bind("onException", function($context) {
                $reactions.answer("onException");
                $reactions.answer($context.exception.name);
                $reactions.answer($context.exception.message);
            });

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}
        
    state: raw
        event: rawRequestEvent
        a: LOL
        script:
            log($request);
            
    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.

    state: JS code from file test
        q!: test from file
        script:
            Test.testErrorThrowing();

    state: ECTest
        q!: ectest
        script:
            throw new TypeError('type error');

    state: BSTest
        q!: bstest
        script:
            throw new Error('test error from test_scenarios');

    state: Test
        q: test
        script:
            $reactions.buttons([{button:{text:"test url", url:"https://store.playstation.com/ru-ru/product/EP9000-CUSA08308_00-DTRTEPRPREORDPSN"}}]);
            $reactions.buttons([{button:{text:"test url 2", url:"https://store.playstation.com/ru-ru/product/EP9000-CUSA08308_00-DTRTEPRPREORDPSN"}}]);
            //$reactions.buttons([{button:{text:"test hide", hide:true}}]);

        state: Test url
            q: test url
            a: Работает!

    state: Test image
        event: imageEvent
        a: Я не умею обрабатывать изображения, извините.

    state: Test file
        event: fileEvent
        a: Я не умею обрабатывать файлы, извините.

    state: Prechat
        q!: prechat
        if: !hasOperatorsOnline()
            go!: NoOperatorsOnline
        else:
            go!: ./PrechatO

        state: NoOperatorsOnline
            a: Операторов сейчас нет, они отравились сушами в стриптиз баре.

        state: PrechatO
            a: Перевожу на оператора. Не ходите с ним в стриптиз бар!
            script:
                $response.replies = $response.replies || [];
                $response.replies
                 .push({
                    type:"switch",
                    closeChatPhrases: ["/closeLiveChat", "Закрыть диалог"],
                    firstMessage: $client.history,
                    lastMessage: "Этот паршивец закрыл диалог, запомни это.",
                    attributes: {
                        "Имя": "Доминик",
                        "Фамилия": "Флэндри"
                    }
                });

    state: Destination
        q!: destination
        if: !hasOperatorsOnline("group1")
            go!: NoOperatorsOnline
        else:
            go!: ./Groups

        state: NoOperatorsOnline
            a: Операторов сейчас нет, они отравились сушами в стриптиз баре.

        state: Groups
            a: Перевожу на оператора. Не ходите с ним в стриптиз бар!
            script:
                $response.replies = $response.replies || [];
                $response.replies
                 .push({
                    type:"switch",
                    closeChatPhrases: ["/closeLiveChat", "Закрыть диалог"],
                    firstMessage: $client.history,
                    destination: "group1",
                    lastMessage: "Этот паршивец закрыл диалог, запомни это."
                });

    state: LivechatReset
        event!: livechatFinished
        go!: /CatchAll

    state: Operator
        q!: operator
        if: !hasOperatorsOnline()
            go!: Switch/NoOperatorsOnline
        else:
            go!: ./Switch

        state: Switch
            a: Переводим на оператора, кстати Марксу уже больше 200лет!
            buttons:
                {"text":"Закрыть диалог","storeForViberLivechat":true}
            script:
                $response.replies = $response.replies || [];
                $response.replies
                 .push({
                    type:"switch",
                    closeChatPhrases: ["/closeLiveChat", "Закрыть диалог"],
                    firstMessage: $client.history,
                    lastMessage: "Этот паршивец закрыл диалог, запомни это."
                });

            state: NoOperatorsOnline
                a: Операторов нет, а ты есть. Но ты напиши им, порадуй зарождающуюся шизу.

                state: GetUserInfo
                    q: *
                    script:
                        $response.replies = $response.replies || [];
                        $response.replies
                         .push({
                            type:"switch",
                            firstMessage: $parseTree.text + '\nДанное сообщение было отправлено в нерабочее время.',
                            ignoreOffline: true,
                            oneTimeMessage: true
                         });
                    go!: /CatchAll

