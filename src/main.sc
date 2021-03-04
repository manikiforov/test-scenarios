 theme: /
 
    state: Echo
        event!: noMatch
        a: Вы сказали: {{$parseTree.text}}

 
    state: Echo
        event!: noMatch
        a: Вы ответили: {{$parseTree.text}}
 