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
        
    state:
        q!: check
        script:
            $temp.url = $http.check("HEAD", ['http://orrp.ru:8013/live_192', 'http://hosting.express.net.ua:13000', 'http://nashe.streamr.ru/rock-128.mp3']);
        a: {{ $temp.url }}