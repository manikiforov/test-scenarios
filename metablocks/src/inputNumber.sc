
theme: /

    state: newNode_1
        q!: inputNumber
        go!: /InputNumber

    state: InputNumber
        InputNumber:
            prompt = Вветите число от 0 до 10
            varName = number
            failureMessage = ["Число от 0 до 10","от 0 до 10, мать твою!"]
            then = /newNode
            minValue = 0
            maxValue = 10
            actions = []

    state: newNode
        a: Ваше число - {{$parseTree.nubmer}}