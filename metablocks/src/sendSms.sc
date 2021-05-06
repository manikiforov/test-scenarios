theme: /

    state: newNode_sendSms
        q!: sendSms
        go!:/Sms

    state: successResultSms
        a: SMS отправлено
        
    state: failedResultSms
        a: SMS не отправлено

    state: Sms
        Sms:
            text = hello QA
            destination = 79992370897
            okState = /successResultSms
            errorState = /failedResultSms