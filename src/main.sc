require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет.
        a: Дароу, братишка
        go!: statemaster
        
        state: statemaster
            q!: statemaster
            a: В стейтмастере
            go: /
               
            state: о
                a: ты в state_0
                
                state: state1
                    q: 1
                    a: ты в state_1
                    
                    state: goTo0
                        q: назад
                        a: перехожу в 0 стейт
                        # пропиши путь /Hello/statemaster/state_0
                        
                    state: end
                        q: * пока *
                        # пропиши путь /Bye 
                        go!: /Bye

    state: Bye || noContext = true
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Что ты, черт побери, такое несешь. Ты сказал: {{$request.query}}

