
theme: /

    state: newNode_0
        a: Привет
        buttons:
            "1" -> /newNode_1
    @InputText
        {
          "boundsTo" : "",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "prompt" : "Введите текст",
          "varName" : "text",
          "then" : "/newNode_2"
        }
    state: newNode_1
        a: Введите текст

        state: CatchText || modal = true
            q: *
            script:
                $session.text = $parseTree.text;
            go!: /newNode_2
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_1",
                name: "newNode_1 buttons",
                handler: function($context) {
                  $reactions.buttons([
                  ]);
                }
            });

    state: newNode_2
        a: {{$session.text}} вы ввели
