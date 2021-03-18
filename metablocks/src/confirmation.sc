theme: /

    state: toConfirmation
        q!: conf
        go!: /Confirmation

    state: Confirmation
        Confirmation:
            prompt = Вы согласны?
            agreeState = /newNode_agree
            disagreeState = /newNode_disagree
            useButtons = true
            agreeButton = Конечно!
            disagreeButton = Пфф

    state: newNode_agree
        a: Я рад что вы согласны, но может вы передумали?
        go!: /Confirmation

    state: newNode_disagree
        a: Плохо что вы не согласны, но может вы передумаете?
        go!: /Confirmation
        