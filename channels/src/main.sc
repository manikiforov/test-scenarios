theme: /
    
    state:
        q!: start
        a: Вы сказали и бот ответил {{$parseTree.text}} copy
    
    state: 
        q!: *
        a: скажите что-то осмысленное
    
    state: image
        q!: JA image
        a: изображение
        image: https://248305.selcdn.ru/public_test/255/256/JtRAnNB2EYoldTfo.jpg
        
    state: audio
        q!: JA audio
        a: аудио
        audio: https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3 || name = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
    
    state: buttons
        q!: JA buttons
        a: кнопки
        buttons:
            "Кнопка1" -> /NormalButtons1
            "Кнопка2" -> /NormalButtons2
            
    state: NormalButtons1
        a: Результат нажатия кнопки 1
        
    state: NormalButtons2
        a: Результат нажатия кнопки 2
        
    state: inline
        q!: JA inlineButtons
        a: 123
        inlineButtons:
            {text:"Просмотреть", url:"http://ya.ru"}
    
    state: switch
        q!: JA switch
        script:
            $response.replies = $response.replies || [];
            $response.replies.push({
                type:"switch",
                closeChatPhrases: ["/closeLiveChat", "Закрыть диалог"],
                firstMessage: $client.history,
                lastMessage: "Этот паршивец закрыл диалог, запомни это.",
                attributes: {
                "Имя": "Доминик",
                "Фамилия": "Флэндри"
                }
            });
            
    state: reset
        q!: JA reset
        script:
            $reactions.newSession({message: "/start", data: $request.data});
            
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