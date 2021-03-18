
theme: /

    state: answerText
        a: Вы ввели текст - {{$session.text}}

    state: newNode_inputText
        q!: inputText
        go!: /InputText

    state: InputText
        InputText:
            prompt = Вветите текст
            varName = text
            then = /answerText
            actions = []