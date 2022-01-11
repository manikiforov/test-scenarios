require: function.js

theme: /

    state: Start 
        q!: start
        a:  Вы сказали и бот ответил: {{$parseTree.text}}
        
    state: sendFile
        q!: file
        a: отправка файла
        script:
            $response.replies = $response.replies || [];
            $response.replies.push({
                type:"file",                         // тип, может принимать значения `audio`, `image`
                fileUrl: "https://docs.google.com/document/d/1n1CJFWA1MIR4r1NXbc3rEfbvQwcmvdET/",        // путь до файла
                fileName: "example.docx",            // имя файла
                mimeType: "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            });
            
    state: sendAudio
        q!: audio
        a: отправка аудио!
        script:
            $response.replies = $response.replies || [];
            $response.replies.push({
                type: "audio",
                audioUrl: "https://mobzvonok.ru/_ld/17/1720_Nila_Mania_Iowa.mp3",
                audioName: "1720_Nila_Mania_Iowa"       //поле опционально
            });
       
    state: time
        q!: timeout
        a: Таймер начался, когда вы сказали: {{$parseTree.text}}
        a: Напишите что нибудь и таймер перезапустится
        script: 
          $reactions.timeout({interval: '30 seconds', targetState: '/timeout'});


    state: timeout
        a: Отведенное время закончилось. Спасибо за ваше обращение! Будем рады видеть вас снова.
        
    state:
        q!: Изображение
        image: https://just-ai.com/wp-content/uploads/2020/02/logo_og-2x-1.png

    state: Internal http
        q!: http internal
        script: 
            var result = $http.get("http://localhost:9030/restapi/public/mts-distribution");

    state:
        q!: сайт
        script:
            $temp.url = $http.checkUrls("HEAD", ['https://www.webhook.site/dfb789c5-8c30-49e9-bc6f-987a8269aeeb','https://www.webhook.site/dfb789c5-8c30-49e9-bc6f-987a8269aeeb','https://www.webhook.site/dfb789c5-8c30-49e9-bc6f-987a8269aeeb'], true);
        a: {{ $temp.url }}

    state: statemaster
        q!: state
        script: pageName("State main");
        a: В главном стейте
        
        state: Первый подстейт
            q: Первый
            script: pageName("Первый подстейт");
            a: Записали, а теперь пиши второй
            
        state: второй простой подстейт
            q!: Второй
            a: Напиши выход
            
            state: exit
                q: выход
                a: жми на exit
                buttons:
                    "exit" -> /Start
            
    state: stop
        q!: stop
        a: Вы прервали меня!
        
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
        
    state: kind
        event: fghf
        a: kind!
        script:
            log($request);
        
    state: webim_actions
        q!: webimAct
        a: actions!
        script:
            $response.actions = [{
               type:"close_chat",
               operatorId:"123"
            },
            {
               type:"redirect_to_department",
               departmentKey:"123"
            },
            {
               type:"redirect_to_operator",
               departmentKey:"123"
            },
            {
               type:"redirect_to_department",
               departmentKey:"123"
            }];
            
    state: image
        event: imageEvent
        a: изображение дошло
    
    state: bitrixbot
        event: ONIMBOTJOINCHAT
        a: Бот вернулся, во славу битрикса
    
    state: updatemessage
        event: ONIMBOTMESSAGEUPDATE
        a: Глаз да глаз за оператором
    
    state: deletemessage
        event: ONIMBOTMESSAGEDELETE
        a: Вжух и карандаш испарился
      
    state: file
        event: fileEvent
        a: файл дошел!
        
    state: button_link
        q!: link
        inlineButtons:
            {text:"button", url:"https://www.google.com/"}  
          
        
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
        
    state: Justswitch
        q!: justswitch
        a: Перевожу на оператора
        script:
            $response.replies = $response.replies || [];
            $response.replies
             .push({
                type:"switch",
                closeChatPhrases: ["/closeLiveChat", "Закрыть диалог"],
                firstMessage: $client.history,
                lastMessage: "Этот паршивец закрыл диалог, запомни это."
            });
        
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
        
    state: OperatorZopim
        q: *zopim*
        a: Перевожу на оператора
        script:
            $response.zopim = {
                needResponse: true,
                departmentName: 'Dep 1'
            };
            
    state: reset
        q!: reset
        script:
            $reactions.newSession({message: "/start", data: $request.data});
            
    state: InlineButtons
        q!: Кнопки телеграма
        a: Для Телеграма
        inlineButtons:
            { text: "{{ 'текст из справочника' }}", callback_data: "cb-55" }
            { text: "{{ 'текст из справочника' }}", url: "{{ 'https://just-ai.com/' }}" }
           
    
        state: Getevent
            event: telegramCallbackQuery
            script:
                $session.name = parseInt($request.query);
            go!: /takevariable
    
        state: takevariable
            a: {{ $session.name }}
            