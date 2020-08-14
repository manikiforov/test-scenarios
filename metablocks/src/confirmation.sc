theme: /

    state: toConfirmation
        q!: conf
        go!: /Confirmation

    state: Confirmation
        Confirmation:
            prompt = Вы согласны?
            agreeState = /newNode
            disagreeState = /newNode_0
            useButtons = true
            agreeButton = Конечно!
            disagreeButton = Пфф

    state: newNode
        a: Я рад что вы согласны, но может вы передумали?
        go!: /Confirmation

    state: newNode_0
        a: Плохо что вы не согласны, но может вы передумаете?
        go!: /Confirmation
        