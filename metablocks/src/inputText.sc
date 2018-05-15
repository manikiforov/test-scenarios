
theme: /
    @InputText
        {
          "prompt" : "Введите текст",
          "varName" : "tex",
          "then" : "/newNode_1"
        }
    state: newNode_0
        a: Введите текст

        state: CatchText
            q: *
            script:
                $session.tex = $parseTree.text;
            go!: /newNode_1

    state: newNode_1
        a: Вы сказали {{$parseTree.tex}}

    state: start
        q!: inputText
        go!: /newNode_0
