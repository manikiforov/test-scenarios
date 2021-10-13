
theme: /

    state: Start
        q!: *
        a: "Вы сказали и бот ответил КОПИЯ! :"
        script:
            $reactions.buttons({button: {text: "Red Button", request_contact: true}})