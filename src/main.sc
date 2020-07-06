theme: /
    state: 
        q!: *
        a: Вы сказали что-то: {{$parseTree.text}}
    
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
            
    state: ev_f
        event!: fileEvent
        event!: imageEvent
        event!: audioEvent
        a: f
        a: {{ $request.data.eventData.url }}
        script:
            log($request);
        
    state: ev_nexmo_file
        event!: file
        a: nexmo
        a: {{ $request.data.eventData.message.content.file.url }}
        script:
            log($request);        
            
    state: ev_nexmo_image
        event!: image
        a: nexmo
        a: {{ $request.data.eventData.message.content.image.url }}
        script:
            log($request);        
            
    state: ev_nexmo_audio
        event!: audio
        a: nexmo
        a: {{ $request.data.eventData.message.content.audio.url }}
        script:
            log($request);    
            
    state: ev_nexmo_video
        event!: video
        a: nexmo
        a: {{ $request.data.eventData.message.content.video.url }}
        script:
            log($request);             