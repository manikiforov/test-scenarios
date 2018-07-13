require: all.sc
    module = common
require: patterns.sc
    module = common

theme: /

    state: newNode_0
        q!: start
        a: Мы стартанули!
        go!: /newNode_1
    @InputText
        {
          "prompt" : "Введите текст",
          "varName" : "tex",
          "then" : "/newNode_2"
        }
    state: newNode_1
        a: Введите текст

        state: CatchText || modal = true
            q: *
            script:
                $session.tex = $parseTree.text;
            go!: /newNode_2

    state: newNode_2
        a: Вы сказали {{$parseTree.tex}}
