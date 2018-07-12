
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

    state: newNode_1 || modal = true, noContext = true
        a: Вы сказали {{$parseTree.tex}}

    state: newNode_2
        script:
            INPUTTEXT
        go!: /newNode_0
