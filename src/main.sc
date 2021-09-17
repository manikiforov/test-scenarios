require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state:  q1
        q!: q
        a: Тег q1
        
        state: q2
            q: q
            a: Тег q2
            
            state: q3
                q: Третий q
                a: Тег q3
                
    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока
        
    state:
        intent!: /Валик
        a: Вошли 1: Валик
        
        state:
            intent: /Адреса
            a: Вошли 2: Адреса
            
            state:
                intent: /Расход
                a: Вошли 3: Расход
                
    state:
        e!: Входим
        a: Тег е1
        
        state:
            e: Входим
            a: Тег е2
            
            state:
                e: Врываемся в третий
                a: Тег е3
                
    
                
    state: Delivery
        intent!: /Доставка
        a: {{toPrettyString($context.entities.filter( function(entity) { return entity.pattern == "Мебель" | entity.pattern == "Виды_доставки" | entity.pattern == "Дни_недели" | entity.pattern == "mystem.persn"}).map( function(entity) { return entity.value }))}}
        a: {{$context.intent.answer}}
        
    state: 
        intent!: /Нужна краска
        a: Краска??
        
    state: Operator
        intent!: /Оператор
        if: !hasOperatorsOnline()
            go!: Switch/NoOperatorsOnline
        else:
            a: Переходим?
            buttons:
                "Да" -> Switch
                "Нет" -> /CatchAll

        state: Switch
            a: Переводим на оператора...
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
                    lastMessage: "Клиент закрыл диалог"
                });

            state: NoOperatorsOnline
                a: Операторов сейчас нет на месте
                buttons:
                    "Вернуться к боту" -> /Start

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
            
    state: /newNode_0
        a: Операторы офлайн
    state: /newNode_1
        a: Вернулись к боту 
    state: 
        event!: match
        a: {{ $context.intent.answer }}
        
    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}
