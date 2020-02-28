theme: /
    state: 
        q!: *
        a: Вы сказали: {{$parseTree.text}}
    
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