theme: /
    state: toInputPhone
        q!: inputPhone
        go!: /InputPhoneNumber

    state: InputPhoneNumber
        InputPhoneNumber:
            prompt = Введите номер телефона
            varName = phone
            failureMessage = ["Это не формат мобильного телефона"]
            then = /newNode
            actions = []

    state: newNode
        a: Ваш номер - {{$session.phone}}
    
    