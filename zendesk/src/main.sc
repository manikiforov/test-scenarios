theme: /

    state: answer
        q!: 
    state: 
        q!: *
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
