theme: /

    state: CatchAll
        q!: *
        a: Лол работает
        
    state: First
        q!: Пыщ
        script:
            $reactions.answer($http.query('http://echo.jsontest.com/key/value/one/two').data.one);