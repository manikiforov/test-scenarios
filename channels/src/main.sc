theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил1: {{$parseTree.text}}

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
                    closeChatPhrases: ["/closeLiveChat", "Закрыть диалог"],
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