require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Echo
        q!: *start
        a: Вы сказали: {{$parseTree.text}}
        script:
            $analytics.setSessionResult("Результат сессии2");
            $analytics.setSessionData("key1", "value1");
            $analytics.setSessionData("key2", "value2");

    state:
        q!: го
        a: Вы сказали: {{$parseTree.text}}
        script:
            $analytics.setSessionResult("Бдыщ");
            
            
    state:
        q!: endSession
        script:
            $session = new Object();
            $response.endSession = true;
            $analytics.setSessionResult("Завершили");
        a: конец сессии
        
    state:
        q!: stop
        script:
            $jsapi.stopSession()
            $analytics.setSessionResult("Пауза");
        a: $jsapi.stopSession()
        
    state: 
        q!: пиу
        a: Вы сказали: {{$parseTree.text}}
        script:
            $analytics.setSessionResult(" ");        

    state: Yes
        q: Да
        a: Спасибо за доверие! До свидания!
        script:
            $dialer.setCallResult("YES");
            $dialer.hangUp();
    
    state: No
        q: Нет
        a: Очень жаль, что вы отказались. До свидания!
        script:
           $dialer.setCallResult("NO");
           $dialer.hangUp();
    
    state: Maybe
        q: Наверное
        a: Мы вам перезвоним попозже. До связи!
        script:
            $dialer.setCallResult("MAYBE");
            $dialer.hangUp();
            
    state: Yes2
        q: Точно
        a: Спасибо за доверие! До свидания!
        script:
            $dialer.setCallResultAccepted();
            $dialer.hangUp();

    state: No2
        q: Не надо
        a: Очень жаль, что вы отказались. До свидания!
        script:
           $dialer.setCallResultRejected();
           $dialer.hangUp();
        
        

