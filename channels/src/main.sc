theme: /
    state: 
        q!: *
        a: Вы сказали: {{$parseTree.text}}
    
    state: image
        q!: JA image
        a: изображение
        script:
            $response.replies.push( {
                type: "image",
                imageUrl: "https://cdn1.imggmi.com/uploads/2019/10/16/0af36bc6017573383e65d9860b16d9ff-full.jpg",
                text: "описаниизображения.jpg"
            } )
        
    state: audio2
        q!: JA audio2
        a: аудио
        audio: https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3 || name = asdasda.mp3
    
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
            
    state: attach
        event!: I_DIGITAL_ATTACHMENT
        go!: тут что-то есть