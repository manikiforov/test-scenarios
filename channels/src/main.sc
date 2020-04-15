theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}
        
    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.
        
    state: Switch
        q!: operator
        random:
        {
          "type":"switch",               //тип сообщения
          "firstMessage":"..."  ,        //опциональные параметры
          "closeChatPhrases": [".."],
          "ignoreOffline":true|false,
          "oneTimeMessage": true|false
        } 
        