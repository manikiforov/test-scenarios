theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил КОПИЯ2222: {{$parseTree.text}}
        
    state: CatchAll
        q!: *
        a: Скажите боту что-то осмысленное!
        
    state: Switch
        q!: switch
        a: тут происходит перевод на оператор, пока этого нет, к сожалению. сорян
        