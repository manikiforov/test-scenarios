theme: /

    state: CatchAll
        q!: *
        a: Лол работает f[f[f[a
        
    state: First
        q!: Пыщ
        script:
            $reactions.answer($http.query('http://echo.jsontest.com/key/value/one/two').data.one);