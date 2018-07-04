
theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}

    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.

    state: newNode_3
        a: kek?

    state: newNode_4
        a: not kek?

    state: newNode_5
        q!: pic
        image: https://cdn.iz.ru/sites/default/files/styles/900x506/public/article-2017-05/SZ_Blue_Sky_graded_300dpi.jpg?itok=8rYrZcWT
