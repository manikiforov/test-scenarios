require: patterns.sc

theme: /

    state:
        eg!: Patterns.Syn
        a: Вчера произошел захват
        
    state: CatchAll || noContext = true
        q!: *
        a: Не понял