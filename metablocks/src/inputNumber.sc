
theme: /

    state: newNode_inputNumber
        q!: inputNumber
        go!: /InputNumber

    state: InputNumber
        InputNumber:
            prompt = Вветите число от 0 до 10
            varName = number
            failureMessage = ["Число от 0 до 10","от 0 до 10, мать твою!"]
            then = /answerNumber
            minValue = 0
            maxValue = 10
            actions = []

    state: answerNumber
        a: Ваше число - {{$session.number}}