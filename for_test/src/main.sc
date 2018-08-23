init:
    bind("onAnyError", function($context) {
            if ($context.exception.message) {
                $reactions.answer($context.exception.message);
            }
        });
theme: /

    state:
        q: * start
        script:
            while(true) {
                var i = 1;
            }
        a:  Start processing!