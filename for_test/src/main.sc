theme: /
    init:
        bind("preProcess", function($context) {
            log('preProcess!');
            $context.temp.count = 1;
        });


        bind("postProcess", function($context) {
            $reactions.transition("/postprocess");
        });

    state: start
        q!: start

    state: postprocess
        go!: ./postprocessEnd

        state: postprocessEnd
            a: state from postprocess transition