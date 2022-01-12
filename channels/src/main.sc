theme: /

    state: Start
        q!: start
        a: ВЫ ВЫБРАЛИ РЕВИЗИЮ: {{$parseTree.text}}
        
    state: CatchAll
        q!: *
        a: Скажите боту что-то осмысленное!
        
    state: Switch
        q!: switch
        a: тут происходит перевод на оператор, пока этого нет, к сожалению. сорян
        