
theme: /

    state: newNode_0
        q: привет
        a: привет
        
    state: CatchAll
        q: *
        script:
            $response.zendesk = {
                closeTicket: false,
                htmlBody: false,
                needResponse: true,
                assigneeEmail: '',
                assigneeGroupName: 'Поддержка',
                addTags: [],
                removeTags: []
            }
