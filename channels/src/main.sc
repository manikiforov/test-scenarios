
theme: /
    @HttpRequest
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "url" : "http://tools.aimylogic.com/api/rss2json?url=https://yandex.ru/blog/company/rss",
          "method" : "GET",
          "dataType" : "json",
          "body" : "",
          "okState" : "/newNode_1",
          "errorState" : "",
          "timeout" : 0,
          "headers" : [ ],
          "vars" : [
            {
              "name" : "items",
              "value" : "$httpResponse"
            }
          ]
        }
    state: newNode_0
        script:
            var headers = {
            };
            var result = $http.query("http://tools.aimylogic.com/api/rss2json?url=https://yandex.ru/blog/company/rss", {
                method: "GET",
                headers: headers,
                query: $session,
                dataType: "json",
                timeout: 0 || 10000
            });
            var $httpResponse = result.data;
            $session.httpStatus = result.status;
            $session.httpResponse = $httpResponse;
            if (result.isOk && result.status >= 200 && result.status < 300) {
                $session["items"] = $httpResponse;
                $reactions.transition("/newNode_1");
            }
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_0",
                name: "newNode_0 buttons",
                handler: function($context) {
                }
            });

    state: newNode_1
        if: $session.items.next()
            go!: /newNode_2
        else:
            go!: /newNode_3

    state: newNode_2
        random:
            a: {{$session.items.current().title}}
        buttons:
            "Дальше" -> /newNode_1
            {text: "еще1", url: "https://yandex.ru"}
            "123" -> /newNode_3
            {text: "123 3", url: "http://yandex.ru"}
            {text: "qweqweqweqweqwewqeeeeeeeeeeeee", url: "ya.ru"}
            "1" -> /newNode_3
            "1241" -> /newNode_3
            {text: "124141414", url: "mail.ru"}

    state: newNode_3
        random:
            a: Больше нет новостей
