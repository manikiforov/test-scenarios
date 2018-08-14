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
            while (true);
        go!: /test

    state: test
        a:  Start processing! {{ $client.test }}