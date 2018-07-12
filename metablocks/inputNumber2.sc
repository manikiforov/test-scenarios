
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
