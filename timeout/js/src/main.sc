theme: /
    state: 
        q: *
        a: Набери timeout или loop чтобы начать
    
    state: Start
        q!: timeout
        a: Таймер начался когда вы сказали: {{$parseTree.text}}
        a: Напишите что нибудь и таймер перезапустится
        script: $reactions.timeout({interval: '0 h 0m 15s', targetState: '/timedout'});
        
        state:
            q: *
            a: Перезапускаю таймер
            go!: /Start

    state: timedout
        a: Первый таймер закончился, второй начался. Напиши что нибудь и второй таймер перезапустится
        timeout: /end || interval =  "0 h 0m 5s"
        
        state:
            q: *
            a: Перезапускаю таймер
            go!: /timedout

    state: end
        a: Тест окончен
        go: /
        
    state: loop
        q!: loop
        a: Цикл бам бам
        timeout: /loop || interval = 1s
        
    state: TariffBlocked || noChangeState=true
        event: tariffBlocked
        script:
            $reactions.answer("Извините, работа приостановлена");   