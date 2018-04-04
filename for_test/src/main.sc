
theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}

    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.

    state: newNode_2
        q!: kek
        if: kek
            go!: /newNode_3
        else:
            go!: /newNode_4

    state: newNode_3
        a: kek?

    state: newNode_4
        a: not kek?
