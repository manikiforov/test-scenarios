theme: /
    state: 
        q!: *
        a: Вы сказали: {{$parseTree.text}}
    
    state: image
        q!: image
        a: изображение
        script:
            $response.replies.push( {
                type: "image",
                imageUrl: "https://cdn1.imggmi.com/uploads/2019/10/16/0af36bc6017573383e65d9860b16d9ff-full.jpg",
                text: "описаниизображения.jpg"
            } )
        
    state: audio1
        q!: audio1
        a: аудио
        audio: http://techslides.com/demos/samples/sample.mp3 || name="asdasda.mp3"
    
    state: audio2
        q!: audio2
        a: аудио
        audio: https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3 || name = asdasda.mp3
    
    state: buttons
        q!: buttons
        a: кнопки
        buttons:
            "Кнопка1" -> /NormalButtons1
            "Кнопка2" -> /NormalButtons2
            
    state: NormalButtons1
        a: Результат нажатия кнопки 1
        
    state: NormalButtons2
        a: Результат нажатия кнопки 2
        
    state: inline
        q!: inlineButtons
        a: 123
        inlineButtons:
            {text:"Просмотреть", url:"http://ya.ru"}
    
    state: switch
        q!: switch
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
        q!: reset
        script:
            $reactions.newSession({message: "/start", data: $request.data});