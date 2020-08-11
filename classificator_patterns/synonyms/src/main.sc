require: patterns.sc

theme: /

    state: Patterns
        eg!: Patterns.Syn
        a: Вчера произошел захват
        
    state: CatchAll || noContext = true
        q!: *
        a: Не понял