theme: /
    state: toHttp
        q!: http
        go!: /HttpRequest

    state: HttpRequest
        HttpRequest:
            url = https://www.random.org/integers/?num=1&min=1&max=100&col=1&base=10&format=plain&rnd=new
            method = POST
            dataType = json
            body = 
            okState = /newNode
            errorState = /newNode_0
            timeout = 1000
            vars = [{"name":"random","value":"$httpResponse"}]
            headers = [{"name":"Content-Type","value":"application/json"}]

    state: newNode
        a: Случайноче число через http запрос = {{$session.random}}

    state: newNode_0
        a: Что-то пошло не так. Запрос не обработан