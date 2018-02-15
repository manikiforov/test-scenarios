theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}
        
    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.
        
    state: Switch
        q!: switch
        a: тут происходит перевод на оператор, пока этого нет, к сожалению. сорян
        