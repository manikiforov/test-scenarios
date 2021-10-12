
theme: /

    state: Start
        q!: *
        a: "Вы сказали и бот ответил КОПИЯ КОПИЙ:"
        script:
            $reactions.buttons({button: {text: "Red Button", request_contact: true}})