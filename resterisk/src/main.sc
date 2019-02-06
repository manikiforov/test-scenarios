
theme: /

    state: newNode_0
        random:
            a: Как отображаются данные из client в выгрузке
        buttons:
            "ДАЛЕЕ" -> /newNode_1
    @InputText
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "prompt" : "Введите имя",
          "varName" : "name",
          "then" : "/newNode_2"
        }
    state: newNode_1 || modal = true
        a: Введите имя

        state: CatchText
            q: *
            script:
                $session.name = $parseTree.text;
            go!: /newNode_2
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_1",
                name: "newNode_1 buttons",
                handler: function($context) {
                }
            });

    state: newNode_2
        random:
            a:  {{$session.name}} 
                {{$session.channelId}} 
                {{$session.userId}} || tts = "", ttsEnabled = false
