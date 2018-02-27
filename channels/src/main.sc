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
                    "{{ yamlButton(main.CatchAll, 'Yes') }}" -> Switch
                    "{{ yamlButton(main.CatchAll, 'No') }}" -> /Menu
                
        state: Switch
            a: Переводим на оператора, кстати Марксу уже больше 200лет!
            buttons:
                { text: "{{ yamlButton(main.Switch, 'Go2Menu') }}", storeForViberLivechat: true }
            script:
                noBackButton();
                dontPushState();
                $response.replies = $response.replies || [];
                if ($temp.switchFirstMessage) {
                    $client.history = $temp.switchFirstMessage;
                } else {
                    $client.history = services.createFirstMessage();
                }
                $response.replies
                 .push({
                    type:"switch",
                    closeChatPhrases: ["/closeLiveChat", yamlButton(main.Switch, 'Go2Menu')],
                    firstMessage: $client.history,
                    lastMessage: yamlScript(main.Switch, 'ClientClosedChat'),
                });

            state: NoOperatorsOnline
                event: noLivechatOperatorsOnline
                script:
                    if ($temp.switchFirstMessage) {
                        $client.history = $temp.switchFirstMessage;
                    } else {
                        $client.history = services.createFirstMessage();
                    }
                    noBackButton();
                    dontPushState();
                a: {{ yamlAnswer(main.NoOperatorsOnline) }}
                buttons:
                    "{{ lang(main.MenuButton) }}"

                state: GetUserInfo
                    q: * ($phoneNumber|$email) *
                    script:
                        noBackButton();
                        dontPushState();
                        var info = $request.query;
                        log($request.query);
                        $response.replies = $response.replies || [];
                        $response.replies
                         .push({
                            type:"switch",
                            firstMessage: 'Данное сообщение было отправлено в нерабочее время.\n' + $client.history + '\n' + info,
                            ignoreOffline: true,
                            oneTimeMessage: true
                         });
                    a: {{ yamlAnswer(main.GetUserInfo) }}
                    go!: /Menu

                state: NoInfo
                    q: *
                    script:
                        noBackButton();
                        dontPushState();
                    a: {{ yamlAnswer(main.NoInfo) }}
                    buttons:
                        "{{ lang(main.MenuButton) }}"
        