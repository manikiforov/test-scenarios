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