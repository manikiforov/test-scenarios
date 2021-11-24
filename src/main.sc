require: script/testFns.js

theme: /

    state: start
        q!: start
        a: Старт!


    state: TestClientInContext
        q!: testClientInContext
        script:
            testClientInContext();


    state: TestClientInJsapiContext
        q!: testClientInJsapiContext
        script:
            testClientInJcapiContext();


    state: Undef
        q!: *
        a: Я ожидаемо ничего не понял.
