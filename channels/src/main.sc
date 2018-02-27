theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}
        
    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.
        
    state: Operator
        q!: operator
        if: !hasOperatorsOnline()
            go!: Switch/NoOperatorsOnline
        else:
            buttons:
                    "Да" -> Switch
                    "Нет" -> /Start
                
        state: Switch
            a: Переводим на оператора, кстати Марксу уже больше 200лет!
            buttons:
                { text: "Закрыть диалог", storeForViberLivechat: true }
            script:
                $response.replies = $response.replies || [];
                $response.replies
                 .push({
                    type:"switch",
                    closeChatPhrases: ["/closeLiveChat", yamlButton(main.Switch, 'Go2Menu')],
                    firstMessage: $client.history,
                    lastMessage: yamlScript(main.Switch, 'ClientClosedChat'),
                });

            state: NoOperatorsOnline
                event: noLivechatOperatorsOnline
                a: Операторов нет, а ты есть.
                buttons:
                    "Вернись в лоно земли обетованной" -> /Start
                state: GetUserInfo
                    q: *
                    script:
                        $response.replies = $response.replies || [];
                        $response.replies
                         .push({
                            type:"switch",
                            firstMessage: 'Данное сообщение было отправлено в нерабочее время.',
                            ignoreOffline: true,
                            oneTimeMessage: true
                         });
                    go!: /Start
        