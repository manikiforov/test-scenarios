
theme: /
    @InputText
        {
          "prompt" : "Введите текст",
          "varName" : "text",
          "then" : ""
        }
    state: newNode_0
        a: Введите текст

        state: CatchText || modal = true
            q: *
            script:
                $session.text = $parseTree.text;
            go!: /

    state: newNode_1
        a: Вы сказали {{$parseTree.tex}}

    state: start
        q!: InputText2
        go!: /newNode_0
