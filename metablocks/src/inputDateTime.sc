theme: /

    state: toInputDate
        q!: inputDate
        go!: /InputDateTime

    state: InputDateTime
        InputDateTime:
            prompt = Введите дату
            varName = date
            failureMessage = ["Не думаю, что это дата"]
            then = /newNode
            actions = []

    state: newNode
        a: Значит вы выбрали дату - {{toPrettyString($session.date)}}
        go!: /InputDateTime
        