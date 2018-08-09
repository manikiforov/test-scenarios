theme: /

    state: answer
        q!: answer
        a: Я вам ответил
        script: $response.zendesk = {
                status: 'OPEN',
                htmlBody: false,
                needResponse: false,
                assigneeEmail: '',
                assigneeGroupName: '',
                addTags: [],
                removeTags: []
            }
    
    state: nonanswer
        q!: nonanswer
        a: Вы сказали: {{$parseTree.text}}
        script: $response.zendesk = {
                status: 'NEW',
                htmlBody: false,
                needResponse: false,
                assigneeEmail: '',
                assigneeGroupName: '',
                addTags: [],
                removeTags: []
            }
