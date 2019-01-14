theme: /
    init:
        bind("postProcess", function($context) {
            if ($context.client && $context.client.post) {
                log('Условие в ПОСТпроцессе -----> ' + $context.client.post);
                $reactions.transition('/postProcess'); 
                return false;
            }
        });

    state:
        q!: testpostprocess
        script:
            $client.post = 'true';
            log('ПОСТ -----> ' + $client.post);

    state:
        q!: testpostprocessClean
        script:
            $client.post = undefined;
            log('NO ПОСТ -----> ' + $client.post);

    state: postProcess
        script:
            $client.post = undefined;
        a: я пришел из постпроцесса сюды!