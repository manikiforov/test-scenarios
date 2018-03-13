require: common.js
    module = common
require: integration.js

theme: /

    init:
        bind("preProcess", function($context) {
            var $session = $context.session, $temp = $context.temp, $request = $context.request, $parseTree = $context.parseTree;
            checkButtonTransition();
            $session.noBackButton = false;
            $session.dontPushState = false;

            if ($request.data.targetState) {
                $temp.targetState  = $request.data.targetState;
            } else if ($session.lastActiveTime) {
                var interval = currentDate() - $session.lastActiveTime;
                if (interval > 120 * 60 * 1000 && !testMode()) {
                    $request.data.targetState = $temp.targetState || currentState();
                    $reactions.newSession( {message: $request.query, data: $request.data} );
                }
            }
        });

        bind("postProcess", function($context) {
            var $session = $context.session;
            var $temp = $context.temp;
            var $response = $context.response;
            var $client = $context.client;
            rememberLastState();
            if (!testMode() && !$temp.specialState) {
                services.updatePageInfo();
            }
            setMarkupMode("markdown");
            setFacebookMenuTitle();

            if (!$session.dontPushState) {
                pushBackState();
            }
            if (!$session.noBackButton) {
                pushBackButton();
            }

            $response.orgData = { 'firm': $client.FirmArr, 'number': $client.numberArr };

            $session.lastActiveTime = currentDate();
        });
        
    state: CatchAll
        q!: *
        script: pageName("Что то непонятно");
        a: Что то не понятное
        
    state: Первый стейт
        q!: 1
        script: pageName("Первый стейт");
        a: Пойдем по первой
        
        state: Первый контекстный
            q: контекст1
            script: pageName("Первый контекстный");
            a: Вошли в сумрак контекста
            
        state: Первый контекстный без имени
            q: контекст2
            a: Вошли в бездну без имени
            
    state: Второй стейт
        q!: 2
        script: pageName("Второй стейт");
        a: Пойдем по второй
        
    state: Безымянный
        q!: 3
        a: АААААА! Нет имени!