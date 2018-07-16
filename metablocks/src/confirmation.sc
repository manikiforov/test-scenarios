
theme: /
    @Confirmation
        {
          "prompt" : "Вы согласны?",
          "agreeState" : "/newNode_3",
          "disagreeState" : "/newNode_2",
          "useButtons" : false,
          "agreeButton" : "Да",
          "disagreeButton" : "Нет"
        }
    state: newNode_4
        a: Вы согласны?
        state: Agree
            q: $agree
            go!: /newNode_3
        state: Disagree
            q: $disagree
            go!: /newNode_2

    state: newNode_1
        q!: confirmation
        go!: /newNode_4

    state: newNode_2
        a: Отказ!

    state: newNode_3
        a: Согласен
