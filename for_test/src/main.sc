require: myLib.js

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
            fibonacci(100);
        a:  Start processing!