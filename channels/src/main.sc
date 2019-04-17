require: function.js

theme: /

    state: Start 
        q!: start
        a: Вы сказали и бот ответил123123: {{$parseTree.text}}

    state: statemaster
        q!: state
        script: pageName("State main");
        a: В главном стейте
        
        state: Первый подстейт
            q: Первый
            script: pageName("Первый подстейт");
            a: Записали, а теперь пиши второй
            
        state: второй простой подстейт
            q!: Второй
            a: Напиши выход
            
            state: exit
                q: выход
                a: жми на exit
                buttons:
                    "exit" -> /Start
            
    state: stop
        q!: stop
        a: Вы прервали меня!!!
        
    state: buttons
        q!: buttons
        a: кнопки
        buttons:
            "Первая" -> /Start
            "Вторая" -> /Stop
            "Третья" -> /CatchAll
        
    state: raw
        event: rawRequestEvent
        a: LOL
        script:
            log($request);
            
    state: vk
        q: контакт
        a:
        
    state: kind
        event: fghf
        a: kind!
        script:
            log($request);
        
    state: webim_actions
        q!: webimAct
        a: actions!
        script:
            $response.actions = [{
               type:"close_chat",
               operatorId:"123"
            },
            {
               type:"redirect_to_department",
               departmentKey:"123"
            },
            {
               type:"redirect_to_operator",
               departmentKey:"123"
            },
            {
               type:"redirect_to_department",
               departmentKey:"123"
            }];
            
    state: image
        event: imageEvent
        a: изображение дошло
        
    state: file
        event: fileEvent
        a: файл дошел!
        
    state: telegramError
        event: telegramApiRequestFailed
        script: $request.data.eventData.errorMessage

    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное .
                
    state: Prechat
        q!: prechat
        if: !hasOperatorsOnline()
            go!: NoOperatorsOnline
        else:
            a: Переходим?
            buttons:
                "Да" -> PrechatO
                "Нет" -> /CatchAll

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
            a: Переходим?
            buttons:
                "Да" -> Groups
                "Нет" -> /CatchAll

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
        
    state: Justswitch
        q!: justswitch
        a: Перевожу на оператора
        script:
            $response.replies = $response.replies || [];
            $response.replies
             .push({
                type:"switch",
                closeChatPhrases: ["/closeLiveChat", "Закрыть диалог"],
                firstMessage: $client.history,
                lastMessage: "Этот паршивец закрыл диалог, запомни это."
            });
        
    state: Operator
        q!: operator
        if: !hasOperatorsOnline()
            go!: Switch/NoOperatorsOnline
        else:
            a: Переходим?
            buttons:
                "Да" -> Switch
                "Нет" -> /CatchAll

        state: Switch
            a: Переводим на оператора, кстати Марксу уже больше 200лет!
            buttons:
                {"text":"Закрыть диалог","storeForViberLivechat":true}
            script:
                $response.replies = $response.replies || [];
                $response.replies
                 .push({
                    type:"switch",
                    appendCloseChatButton: true,
                    closeChatPhrases: ["Закрыть диалог", "/closeLiveChat"],
                    firstMessage: $client.history,
                    lastMessage: "Этот паршивец закрыл диалог, запомни это."
                });

            state: NoOperatorsOnline
                a: Операторов нет, а ты есть. Но ты напиши им, порадуй зарождающуюся шизу.
                buttons:
                    "Вернись в лоно земли обетованной" -> /Start

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
        
    state: OperatorZopim
        q: *zopim*
        a: Перевожу на оператора
        script:
            $response.zopim = {
                needResponse: true,
                departmentName: 'Dep 1'
            };
            
    state: reset
        q!: reset
        script:
            $reactions.newSession({message: "/start", data: $request.data});    