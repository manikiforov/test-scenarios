theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}
        
    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.
        
    state: hi
        q!: hi
        a: hi-hi
        
    
        