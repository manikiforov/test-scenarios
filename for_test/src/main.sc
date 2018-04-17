
theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}

    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.

    state: newNode_3
        a: kek?

    state: reqursivePatterns
        q!: $activateService
        a: Рекурсия

    state: newNode_4
        a: not kek?
