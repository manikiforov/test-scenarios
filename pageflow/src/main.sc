require: integration.js
require: function.js

theme: /
    init:
        bind("preProcess", function($context) {
            var $session = $context.session, $temp = $context.temp, $request = $context.request, $parseTree = $context.parseTree;
            $session.noBackButton = false;
            $session.dontPushState = false;
        });
        bind("postProcess", function($context) {
            var $session = $context.session;
            var $temp = $context.temp;
            var $response = $context.response;
            var $client = $context.client;3
            rememberLastState();
            if (!testMode() && !$temp.specialState) {
                services.updatePageInfo();
            }
            $response.orgData = { 'firm': $client.FirmArr, 'number': $client.numberArr };
        });

    state: CatchAll
        q!: *
        script:
            pageName("Что то ");
        a: Что то не понятное11123123123

    state: Первый стейт
        q!: 1
        script:
            pageName("Первый стейт");
        a: Пойдем по первой

        state: Первый контекстный
            q: контекст1
            script:
                pageName("Первый контекстный");
            a: Вошли в сумрак контекста

        state: Первый контекстный без имени
            q: контекст2
            a: Вошли в бездну без имени

    state: Второй стейт
        q!: 2
        script:
            pageName("Второй стейт");
        a: Пойдем по второй

    state: Безымянный
        q!: 3
        a: АААААА! Нет имени!
