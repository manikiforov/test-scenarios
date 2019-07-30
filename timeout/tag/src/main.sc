theme: /
    state:
        q: *
        a: Набери timeout чтобы начать
    
    state: Start
        q!: timeout
        a: Таймер начался когда вы сказали: {{$parseTree.text}}
        a: Напишите что нибудь и таймер перезапустится
        script: $reactions.timeout({interval: "0 h 0m 5s", targetState: '/timedout'});
        
        state:
            q: *
            a: Перезапускаю таймер
            go!: /Start

    state: timedout
        a: Первый таймер закончился, второй начался. Напиши что нибудь и снова начнется первый
        timeout: /end || interval = "0 h 0m 5s"
        
        state:
            q: *
            a: Перезапускаю таймер
            go!: /timedout

    state: end
        a: Тест окончен
        go: /