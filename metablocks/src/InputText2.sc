
theme: /
    @InputText
        {
          "prompt" : "Введите текст",
          "varName" : "text",
          "then" : "/newNode_1"
        }
    state: newNode_0
        a: Введите текст

        state: CatchText || modal = true
            q: *
            script:
                $session.text = $parseTree.text;
            go!: /newNode_1

    state: newNode_1
        a: Вы сказали {{$parseTree.tex}}

    state: start
        q!: InputText2
        go!: /newNode_0
