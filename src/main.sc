theme: /

    state: 
        q!: *
        a: привет

    state: 
        q!: bitrix
        a: Вы сказали: {{$parseTree.text}} токен: {{ $request.data.customData.bitrix.accessToken }}
        script:
            var bitrix = $request.data.customData.bitrix;
            log(bitrix);
            var url = bitrix.clientEndpoint + "imbot.bot.list";
            var options = {
                dataType: "json",
                headers: {
                    "Content-Type": "application/json"
                },
                body: {
                    "auth": bitrix.accessToken
                }
            };
            var response = $http.post(url, options);
            $reactions.answer(JSON.stringify(response.data));
