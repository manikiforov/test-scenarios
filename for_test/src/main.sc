
theme: /
    @InputText
        {
          "prompt" : "Загадай число",
          "varName" : "number",
          "then" : "/newNode_1"
        }
    state: newNode_0
        a: Загадай число

        state: CatchText
            q: *
            script:
                $session.number = $parseTree.text;
            go!: /newNode_1

    state: newNode_1
        a: Hello
