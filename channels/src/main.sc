
theme: /

    state: newNode_0
        random:
            a: Скажи сколько || tts = "", ttsEnabled = false
        go!: /newNode_3
    @IntentGroup
        {
          "boundsTo" : "/newNode_0",
          "actions" : [
            {
              "type" : "buttons",
              "buttons" : [ ]
            }
          ],
          "global" : false,
          "fallback" : "/newNode_4",
          "intents" : [
            {
              "phrases" : [
                {
                  "type" : "example",
                  "value" : "$NUMBER"
                }
              ],
              "then" : "/newNode_2"
            }
          ]
        }
    state: newNode_3
        state: 1
            e: $NUMBER

            go!: /newNode_2

        state: Fallback
            q: *
            go!: /newNode_4
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_3",
                name: "newNode_3 buttons",
                handler: function($context) {
                }
            });

    state: newNode_2
        random:
            a: вы сказали {{$session.NUMBER}} || tts = "", ttsEnabled = false

    state: newNode_4
        random:
            a:  не понял
                 || tts = "", ttsEnabled = false
