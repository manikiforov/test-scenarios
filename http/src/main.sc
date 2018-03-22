theme: /

    state: CatchAll
        q!: *
        a: Лол работает
        
    state: First
        q!: Пыщ
        script:
            $reactions.answer($http.query('http://localhost:9001/method1').data.text);