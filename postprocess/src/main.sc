theme: /
    init:


        bind("preProcess", function($context) {
            log('preProcess!');
            $context.temp.count = 1;
        });


        bind("postProcess", function($context) {
            log('postProcess!');
            var $context = $jsapi.context();
            if ($context.temp.count == 5) {
                return;
            }
            $context.temp.targetState = "/fray_test/testpostprocess";
            if ($context.temp.count > 2) {
                $reactions.transition("/postprocess2");
            } else {
                $reactions.transition("/postprocess");
            }
            $context.temp.count = $context.temp.count + 1
        });

    state: start
        q!: start
        a: this should be executed only once before postprocess

    state: postprocess
        go!: ./postprocessEnd

        state: postprocessEnd
            a: state from postprocess transition

    state: postprocess2
        a: postprocess2

    state: fray_test
        state: testpostprocess
            a: fray_test