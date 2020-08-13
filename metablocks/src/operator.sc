theme: /

    state: toOperator
        q!: operator
        go!: /TransferToOperator

    state: TransferToOperator
        TransferToOperator:
            titleOfCloseButton = Выйти в окно
            messageBeforeTransfer = Сейчас переведем на оператора
            prechatAttributes = {"Имя":"Tester","Организация":"JuasAI"}
            ignoreOffline = true
            messageForWaitingOperator = Ждем оператора
            noOperatorsOnlineState = /newNode_noOperators
            dialogCompletedState = /newNode_BackToBot
            actions = []

    state: newNode_noOperators
        a: Операторов нет на месте

    state: newNode_BackToBot
        a: Вы вернулись к боту