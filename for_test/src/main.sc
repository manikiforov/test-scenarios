theme: /

    init:
        bind("postProcess", function(c) {
            $reactions.answer(JSON.stringify(c.nBest[0].score));
        });

    state:
        q!: test1

    state:
        q!: test2 $weight<1.001>

    state:
        q!: test3 $weight<0.9+0.05>

    state:
        q!: test4 $weight<+0.3>

    state:
        q!: test5 $weight<-0.2>
