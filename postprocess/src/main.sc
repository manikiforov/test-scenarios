init:
	bind("postProcess", function($context) {
		if ($client && $client.post){
		    log('Условие в ПОСТпроцессе -----> ' + $client.post);
		    $reactions.transition('/postProcess'); 
		    return false;
		}
	});


theme: /

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