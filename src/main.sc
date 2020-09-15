require: functions.js

theme: /
    state: NoInput || noContext=true
        event: speechNotRecognized
        script:
            $session.noInputCounter = $session.noInputCounter || 0;
            $session.noInputCounter++;
        
        if: $session.noInputCounter >= 5
            a: Кажется какие-то проблемы со связью. Перезвоню вам позднее.
            script:
                hangUp();
        else:
            a: Вас плохо слышно, повторите, пожалуйста!
    

    state: Main
        q: * *start
        a: Привет, я телефонный бот!
        a: Ваш номер {{getCaller()}}.
        a: Согласны ли вы на наши распрекрасные условия?
        a: Ответьте: да, нет или наверное
        
        state: Yes
            q: Да
            a: Как хорошо, что вы согласны!
            script:
                $dialer.redial()
            a: Теперь скажи одно любое небольшое предложение, а я за тобой повторю.
            
            state: Repeat1
                q: *
                a: Вы сказали: {{$parseTree.text}}
                script:
                    hangUp();
            
        state: No
            q: Нет
            a: Очень жаль, что вы отказались.
            script:
               $dialer.setCallResult("Отказ");
            a: Теперь скажи одно любое небольшое предложение, а я за тобой повторю.
            
            state: Repeat2
                q: *
                a: Вы сказали: {{$parseTree.text}}
                script:
                    hangUp();
            
        state: Maybe
            q: Наверное
            a: Ах какая неуверенность! В следующий раз будте смелее.
            script:
                $dialer.setCallResult("Сомнение");
            a: Теперь скажи одно любое предложение, а я за тобой повторю.
    
            state: Repeat3
                q: *
                a: Вы сказали: {{$parseTree.text}}
                script:
                    hangUp();
    
    state: ClientHungUp
        event!: hangup
        script:
            log("hangup event works properly")
    
    state: reset
        q!: рестарт
        script:
            $reactions.newSession({message: "/start", data: $request.data});
       
    state: CatchAll
        q!: *
        a: Вы сказали что-то, чего я не понимаю, а именно: {{$parseTree.text}}. Но отсутствие внятного результата для меня тоже результат. За сим прощаюсь!
        script:
            hangUp();
