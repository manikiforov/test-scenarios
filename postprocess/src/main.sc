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
        q!: *
        script:
            $client.post = 'true';
            log('Был в state 1 -----> ' + ($client.wasInPost ? 'да' : 'нет'));
            $client.wasInPost = false;
            log('ПОСТ -----> ' + $client.post);

    state:
        q!: clean
        script:
            $client = {};
            log('NO ПОСТ -----> ' + $client.post);

    state: postProcess
        script:
            $client.post = undefined;
            $client.wasInPost = true;
        a: я пришел из постпроцесса сюды!