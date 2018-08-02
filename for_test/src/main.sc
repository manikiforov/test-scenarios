
theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}
        go!: /CatchAll

    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.
        go!: /newNode_3

    state: newNode_3
        a: kek?
        go!: /newNode_4

    state: newNode_4
        a: not kek?
        go!: /newNode_5

    state: newNode_5
        q!: pic
        image: https://cdn.iz.ru/sites/default/files/styles/900x506/public/article-2017-05/SZ_Blue_Sky_graded_300dpi.jpg?itok=8rYrZcWT
