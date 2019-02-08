require: script.js

theme: /

    state: test
        q!: test
        a: before
        script:
            $reactions.answer("before2");
            compute();
            $reactions.answer("after");
        a: after2
        
    state: a
        q!: $regexp_i<Fifth 1>
        a: fifth
        
    state: check
        q: http
        script:
            $http.check(method: 'GET', urls: ['https://rnd.mts.ru/personal/mobilnaya-svyaz/tarifi/vibrat-tarif'])