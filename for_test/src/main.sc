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
            var arr = [];
            while(true) {
                arr.push({'test': '012356789012356789012356789012356789012356789012356789012356789012356789012356789'})
            }
        a:  Start processing!