
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
                assigneeEmail: 'b.shabalin@just-ai.com',
                assigneeGroupName: 'Поддержка',
                addTags: [],
                removeTags: []
            }
