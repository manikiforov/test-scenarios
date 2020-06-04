
theme: /

    state: newNode_5
        random:
            a: Хочешь мудрую мысль? || tts = "", ttsEnabled = false
        buttons:
            "Да" -> /newNode_1
    @HttpRequest
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "url" : "https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=ru",
          "method" : "GET",
          "dataType" : "json",
          "body" : "{\r\n  \"quoteText\": \"Текст цитаты\",\r\n  \"quoteAuthor\": \"Автор цитаты\",\r\n  \"senderName\": \"Кто опубликовал цитату\",\r\n  \"senderLink\": \"Ссылка на профиль\",\r\n  \"quoteLink\": \"Ссылка на саму цитату на сайте\"\r\n}",
          "okState" : "/newNode_3",
          "errorState" : "/newNode_4",
          "timeout" : 0,
          "headers" : [ ],
          "vars" : [
            {
              "name" : "quoteText",
              "value" : "$httpResponse.quoteText"
            },
            {
              "name" : "quoteAuthor",
              "value" : "$httpResponse.quoteAuthor"
            }
          ]
        }
    state: newNode_1
        script:
            var headers = {
            };
            var result = $http.query("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=ru", {
                method: "GET",
                headers: headers,
                query: $session,
                body: _.template("{\r  \"quoteText\": \"Текст цитаты\",\r  \"quoteAuthor\": \"Автор цитаты\",\r  \"senderName\": \"Кто опубликовал цитату\",\r  \"senderLink\": \"Ссылка на профиль\",\r  \"quoteLink\": \"Ссылка на саму цитату на сайте\"\r}", {variable: '$session'})($session),
                dataType: "json",
                timeout: 0 || 10000
            });
            var $httpResponse = result.data;
            $session.httpStatus = result.status;
            $session.httpResponse = $httpResponse;
            if (result.isOk && result.status >= 200 && result.status < 300) {
                $session["quoteText"] = $httpResponse.quoteText;
                $session["quoteAuthor"] = $httpResponse.quoteAuthor;
                $reactions.transition("/newNode_3");
            } else {
                $reactions.transition("/newNode_4");
            }
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_1",
                name: "newNode_1 buttons",
                handler: function($context) {
                }
            });

    state: newNode_3
        random:
            a: {{$session.quoteText}} {{$session.quoteAuthor}} || tts = "", ttsEnabled = false
        go!: /newNode_6
    @Transition
        {
          "boundsTo" : "/newNode_3",
          "then" : "/newNode_5"
        }
    state: newNode_6
        go!: /newNode_5

    state: newNode_4
        random:
            a: Вот ведь неудача!
