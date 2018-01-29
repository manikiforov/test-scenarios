
theme: /

    state: 1
        q!: *
        a: Вы сказали: {{$parseTree.text}}
        a: параметры запроса: {{JSON.stringify($request.data)}}
        go!: /newNode_1
    @InputText
        {
          "prompt" : "Введите текст или отправитесь играть в покер со Смертью!",
          "varName" : "text"
        }
    state: newNode_1
        a: Введите текст или отправитесь играть в покер со Смертью!

        state: CatchText
            q: *
            script:
                $session.text = $parseTree.text;
            go!:
