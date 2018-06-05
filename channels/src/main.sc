theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}
        
    state: phone
        q!: задарма
        a: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras dapibus enim et gravida laoreet. Integer neque felis, dictum in tempus maximus, vulputate non mi. Ut viverra sem nec eros aliquet, id imperdiet elit sagittis. Suspendisse vestibulum, sem sed feugiat vulputate, nisi odio volutpat quam, sed dignissim urna diam eget eros. Suspendisse tempor sodales luctus. Proin nec maximus nibh, a tincidunt ligula. Phasellus tincidunt nulla sem, quis dapibus quam euismod eget. Donec faucibus iaculis aliquet. Nam tempor at mauris elementum ullamcorper. Aenean condimentum mauris in tempus efficitur. Praesent non volutpat quam, a euismod elit.
            Donec lobortis turpis ultricies purus semper, id euismod risus sodales. In mollis eros justo, ac condimentum neque pellentesque laoreet. Integer eget neque tincidunt, tristique eros ullamcorper, efficitur mauris. Sed vestibulum, elit ac blandit gravida, velit odio tincidunt lorem, a eleifend nibh libero non magna. Curabitur vel ipsum nec neque tempor posuere. Nunc vel nulla tempus, gravida velit ac, malesuada ante. Pellentesque sollicitudin auctor ante, quis facilisis ligula cursus non. Quisque leo enim, ornare a accumsan eu, tristique eu ante. Vestibulum et nulla eu nulla viverra tristique. Donec sed urna eu libero fringilla aliquet eget eu tellus. Mauris mattis, quam eget tincidunt consequat, lectus felis vulputate ipsum, sit amet mollis diam dui in turpis. Cras in urna faucibus, volutpat lectus ac, consequat est. Aliquam semper blandit quam. Mauris ullamcorper massa in egestas varius.
            Maecenas auctor enim est, eu viverra diam vulputate in. Curabitur ut justo sit amet risus pretium dapibus. Curabitur convallis pulvinar aliquam. Etiam id leo id erat mattis fringilla consequat ut purus. Cras lacinia in lorem eu commodo. Donec elementum odio vitae leo pharetra, vel egestas mi lobortis. Vivamus leo tellus, fermentum vitae sem id, faucibus laoreet lectus. Nullam vel elit et dolor rutrum molestie non vitae leo. Aenean congue sem vel massa auctor maximus. Sed pulvinar urna vitae tincidunt luctus. Pellentesque lacinia rhoncus ultricies. Donec et mi quis nunc pharetra rhoncus eget a ante. Mauris tellus erat, semper at libero sit amet, fringilla sodales mi. Pellentesque egestas eros vitae aliquet lobortis. Nunc at lectus arcu. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
            Curabitur malesuada porttitor eros, at varius est elementum et. Aliquam fermentum vestibulum eleifend. Sed sed ex libero. Cras viverra dapibus massa a finibus. Ut dui nisl, lobortis eu leo at, vulputate tristique ipsum. Fusce vulputate enim et ex cursus fringilla. Cras gravida orci at cursus iaculis. Nunc venenatis ullamcorper imperdiet. Donec ultricies finibus neque. Nullam porta dui vel dignissim tincidunt. Nunc porttitor, dolor id placerat volutpat, nisi diam tincidunt erat, nec rutrum augue lacus rhoncus augue. Nam blandit ipsum pellentesque sem lobortis blandit. Cras ultricies augue et quam vestibulum rutrum. Praesent ex odio, rhoncus ac risus sit amet, gravida tristique lorem. Phasellus eu molestie enim, vitae consequat lacus. Phasellus rhoncus purus sem, vitae cursus nunc pretium scelerisque.
            Nullam eleifend arcu eget purus lacinia interdum. Donec lobortis neque felis, nec egestas augue rhoncus nec. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus vitae vulputate lectus, non posuere sem. Curabitur justo libero, porttitor non tortor vel, sagittis imperdiet nisi. Proin et neque in ante sagittis posuere nec euismod tortor. Nullam vitae porttitor nibh. Sed ipsum est, efficitur ut pharetra mattis, fermentum ut sapien. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Etiam ut faucibus arcu. Suspendisse et nulla lectus. Maecenas ultrices lacus velit, a euismod risus ultrices eget. Ut justo neque, placerat sed urna eget, porta varius ante. Donec tristique quis odio eget ullamcorper. Vivamus vel lobortis nibh, sit amet ornare leo.
            Etiam mollis sapien in justo venenatis tristique. Curabitur id vulputate mauris, a congue sapien. Quisque pellentesque sit amet sem vitae ultricies. Duis viverra congue odio, non interdum nulla faucibus in. Quisque non semper massa. In porta nunc eu lorem varius pulvinar. Phasellus non urna consequat, mattis mi tempor, fermentum odio. Duis velit metus, facilisis vel ligula at, euismod mattis elit. Vivamus efficitur nisl ipsum, ac convallis quam tempus non. Mauris nibh libero, rhoncus rhoncus odio vel, ornare eleifend ex.

    state: stop
        q!: stop
        a: Вы прервали меня
        
    state: raw
        event: rawRequestEvent
        a: LOL
        script:
            log($request);
            
    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.
                
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
