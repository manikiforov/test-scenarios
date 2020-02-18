theme: /
    state: 
        q!: *
        a: Вы написали: {{$parseTree.text}}
    
    state: image
        q!: image
        a: изображение
        script:
            $response.replies.push( {
                type: "image",
                imageUrl: "https://img-s2.onedio.com/id-5856bd43f93495cc2689a05b/rev-0/raw/s-907df56c8f0f1bbac319c217407861265de42837.jpg",
                text: "описаниизображения.jpg"
            } )
        
    state: audio1
        q!: audio666
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