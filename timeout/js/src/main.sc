theme: /

    state: Start
        q!: time
        a: Вы сказали: {{$parseTree.text}}
        a: параметры запроса: {{JSON.stringify($request.data)}}
        script: $reactions.timeout({interval: '5 seconds', targetState: '/timedout'});
        
    state:
        q: *
        a: Не пиши ничего
        go!: /Start

    state: timedout
        a: Этот ответ должен быть выведен в случае, если клиент молчит
        timeout: /end || interval = "10 sec"

    state: end
        a: Тест окончен
        go: /