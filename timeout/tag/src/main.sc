theme: /
    state: Start
        q: * *start
        a: Подождите немного
        #Аналогичная функция так же должна быть достпна в JS API
        timeout: /timedout || interval = 10s

    state: 
        q!: *
        a: Не пишите ничего, пожалуйста.
        go!: /Start

    state: timedout
        a: Этот ответ должен быть выведен в случае, если клиент молчит

        state: 
            q: *
            a: Тест окончен.