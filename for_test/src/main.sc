
theme: /
    @InputText
        {
          "prompt" : "Загадай число",
          "varName" : "number",
          "then" : ""
        }
    state: newNode_0
        a: Загадай число

        state: CatchText
            q: *
            script:
                $session.number = $parseTree.text;
            go!:
