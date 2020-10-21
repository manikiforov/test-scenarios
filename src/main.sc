theme: /

    state:
        q!: покажи
        a: Для сущности ClientEntity и клиента {{$request.channelUserId}} были созданы следующие рекорды:
        a: {{JSON.stringify($caila.getClientEntityRecords("ClientEntity"))}}
        
    state:
        q!: проверяем addClientEntityRecords с 1 записью
        script:
            $caila.addClientEntityRecords("ClientEntity", [{"type": "synonyms", "rule": ["первый"], "value": "первый"}]);
        a: Готово
        
    state: 
        q!: проверяем addClientEntityRecords с несколькими записями
        script:
            $caila.addClientEntityRecords("ClientEntity", [{"type": "synonyms", "rule": ["второй"], "value": "второй"},
            {"type": "synonyms", "rule": ["третий"], "value": "третий"}]);
        a: Готово
        
    state:
        q!: покажи с id
        a: Для сущности ClientEntity и клиента {{$request.channelUserId}} были созданы следующие рекорды:
        a: {{JSON.stringify($caila.getClientEntityRecords("ClientEntity", "testClientId"))}}
    
    state:
        q!: проверяем addClientEntityRecords с 1 записью и с id
        script:
            $caila.addClientEntityRecords("ClientEntity", [{"type": "synonyms", "rule": ["первый c id"], "value": "первый c id"}], "testClientId");
        a: Готово
        
    state: 
        q!: проверяем addClientEntityRecords с несколькими записями и с id
        script:
            $caila.addClientEntityRecords("ClientEntity", [{"type": "synonyms", "rule": ["второй c id"], "value": "второй c id"},
            {"type": "synonyms", "rule": ["третий c id"], "value": "третий c id"}], "testClientId");
        a: Готово  
    
    state:
        event!: noMatch
        a: Сработал no match