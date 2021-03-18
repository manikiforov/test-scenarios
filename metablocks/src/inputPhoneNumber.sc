theme: /
    state: toInputPhone
        q!: inputPhone
        go!: /InputPhoneNumber

    state: InputPhoneNumber
        InputPhoneNumber:
            prompt = Введите номер телефона
            varName = phone
            failureMessage = ["Это не формат мобильного телефона"]
            then = /newNodePhone

    state: newNodePhone
        a: Ваш номер - {{$session.phone}}
    
    