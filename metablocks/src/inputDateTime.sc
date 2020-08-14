theme: /

    state: toInputDate
        q!: inputDate
        go!: /InputDateTime

    state: InputDateTime
        InputDateTime:
            prompt = Введите дату
            varName = date
            failureMessage = ["Не думаю, что это дата"]
            then = /newNode_answerDate
            actions = []

    state: newNode_answerDate
        a: Значит вы выбрали дату - {{toPrettyString($session.date)}}
        go!: /InputDateTime
        