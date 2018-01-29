theme: /

    state: 
        q!: *
        a: Вы сказали: {{$parseTree.text}}
        a: параметры запроса: {{JSON.stringify($request.data)}}