
theme: /

    state: Start
        q!: start1
        a: Вы сказали и бот ответил: {{$parseTree.text}}
        go!: /newNode_2

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
