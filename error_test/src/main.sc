theme: /

    init:
        bind("onAnyError", function($context) {
            $session.lastRequestFailed = true;
            if (!$temp.lastRequestFailed) {
                $reactions.answer("Что-то пошло не так"); 
            } else {
                $reactions.answer("Что-то опять пошло не так");
            }
        });

    state:
        q!: first
        a: FFFF