theme: /
    state:
        q: *
        a: Набери time чтобы начать
    
    state: Start
        q!: time
        a: Таймер начался когда вы сказали: {{$parseTree.text}}
        a: Напишите что нибудь и таймер перезапустится
        script: $reactions.timeout({interval: '30 seconds', targetState: './timedout'});
        
        state:
            q: *
            a: Перезапускаю таймер
            go!: /Start

        state: timedout
            a: Первый таймер закончился, второй начался. Напиши что нибудь и снова начнется первый
            timeout: /end || interval = "10 sec"

    state: end
        a: Тест окончен
        go: /