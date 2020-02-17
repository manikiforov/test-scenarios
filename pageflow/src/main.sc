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
        a: Что то непонятно ничего...

    state: Первый стейт
        q!: 1
        script:
            pageName("Первый стейт");
        a: Первый стейт

        state: Первый контекстный
            q: контекст1
            script:
                pageName("Первый контекстный");
            a: Вошли в сумрак контекста

        state: Первый контекстный без имени
            q: контекст2
            a: Вошли в солярис без имени и фамилии

    state: Второй стейт
        q!: 2
        script:
            pageName("Второй стейт");
        a: Второй стейт

    state: Безымянный
        q!: 3
        a: АААААА! Нет имени!
