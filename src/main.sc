theme: /

    state: Echo | modal=true
        event!: noMatch
        a: Вы сказали: {{$parseTree.text}}

    state: newNode
        q!: start
        go!: /InputNumber

    state: InputNumber
        InputNumber:
            prompt = Вветите число
            varName = number
            failureMessage = ["Число от 0 до 10"]
            then = /InputText
            minValue = 0
            maxValue = 10
            actions = []
            html = <i>Введите число <b>ыавпрп</b></i>
            htmlEnabled = true
            failureMessageHtml = ["<i>Введите число от 0 до 10</i>"]

    state: InputText
        InputText:
            prompt = Вветите текст
            varName = text
            then = /InputPhoneNumber
            actions = []
            html = <u><br>Введите текст</br></u>
            htmlEnabled = true

    state: InputPhoneNumber
        InputPhoneNumber:
            prompt = Введи номер телефона
            varName = phone
            failureMessage = ["Это не формат мобильного телефона"]
            then = /InputFile
            actions = []
            html = <u><b>Введите номер телефон</b></u>
            htmlEnabled = true
            failureMessageHtml = ["<i>Это не формат <b>мобильного телефона</b></i>"]

    state: InputFile
        InputFile:
            prompt = Отправьте файл
            varName = file
            then = /Confirmation
            errorState = /InputFile
            actions = []
            html = <i>Отправь <br>файл</i><br>
            htmlEnabled = true

    state: Confirmation
        Confirmation:
            prompt = Хочешь перейти на оператора
            agreeState = /TransferToOperator
            disagreeState = /Confirmation
            useButtons = true
            agreeButton = Да
            disagreeButton = Нет

    state: TransferToOperator
        TransferToOperator:
            titleOfCloseButton = Закрыть диалог
            messageBeforeTransfer = Сейчас переведем на оператора
            prechatAttributes = {"Имя":"Тестер"}
            ignoreOffline = true
            messageForWaitingOperator = Ждем оператора
            noOperatorsOnlineState = 
            dialogCompletedState = 
            actions = []
            messageBeforeTransferHtml = <i style=""><b>Вы будете переведены на оператора</b></i>
            messageForWaitingOperatorHtml = <b>Вам ответит первый освободившийся оператор</b>
            sendMessageHistoryAmount = 5
            sendMessagesToOperator = false
            htmlEnabled = true