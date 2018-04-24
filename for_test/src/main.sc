
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

    state: newNode_5
        if: Новое условие
            go!: /newNode_3
        else:
            go!: /newNode_4
