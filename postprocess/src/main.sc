init:
    bind("postProcess", function($context) {
        if ($context.client && $context.client.post) {
            log('Условие в ПОСТпроцессе -----> ' + $context.client.post);
            $reactions.transition('/fray_test/postProcess'); 
            return false;
        }
    });

theme: /fray_test


    state:
        q!: testpostprocess
        script:
            $client.post = 'true';
            log('Был в state 1 -----> ' + ($client.wasHere ? 'да' : 'нет'));
            $client.wasHere = true;
            log('ПОСТ -----> ' + $client.post);

    state:
        q!: testpostprocessClean
        script:
            $client.post = undefined;
            log('NO ПОСТ -----> ' + $client.post);

    state: postProcess
        script:
            $client.post = undefined;
            $client.wasHere = false;
        a: я пришел из постпроцесса сюды!