
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
        a: ты сказал kek???
