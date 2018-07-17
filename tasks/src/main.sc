theme: /

    state: CatchAll
        q!: *
        a: Вводи что-то осмысленное, ибо время ценно.
        
    state: start
        q!: start
        a: Привет. Это тестовый бот с таск-трекером внутри. Пока могу не очень много,  только добавить таску на сегодня или на завтра:( Но я быстро учусь.
        buttons:
            "Today" -> /Task_today
            "Tomorrow" -> /Task_tomorrow
        
    state: Task_today
        script: $client.data.today = $client.data.today + "/n" + $parseTree.text
        
    state: Task_tomorrow
        script: $client.data.tomorrow = $client.data.tomorrow + "/n" + $parseTree.text
        
    state: all
        q!: all 
        a: Вот все что есть: {{$client.data}}