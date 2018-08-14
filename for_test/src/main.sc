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
            do {
                var i = 1;
            } while(true)
        a:  Start processing!