theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил 666: {{$parseTree.text}}
        
    state: CatchAll
        q!: *
        a: Скажите боту что-то осмысленное! а вообще это ветка channels fyi
        
    state: Switch
        q!: switch
        a: тут происходит перевод на оператор, пока этого нет, к сожалению. сорян
        