theme: /

    state: CatchAll
        q!: *
        a: Вводи что-то осмысленное, ибо время ценно.
        
    state: start
        q!: start
        a: Привет. Это тестовый бот с таск-трекером внутри. Пока могу не очень много,  только добавить таску на сегодня или на завтра:( Но я быстро учусь.
        script:
        buttons:
            "Today" -> /Task_today
            "Tomorrow" -> /Task_tomorrow
        
    state: Task_today
        a: Введи задачу
        
        state: Task_today2
            q: *
            script:
                if ($client.data) {
                    $client.data.today = $client.data.today + '\n' + $parseTree.text;
                }            
                else {
                    $client.data = {};
                    $client.data.today = $parseTree.text
                }
                
    state: Task_tomorrow
        a: Введи задачу
        
        state: Task_today2
            q: *
            script:
                if ($client.data) {
                    $client.data.tomorrow = $client.data.tomorrow + '\n' + $parseTree.text;
                }            
                else {
                    $client.data = {};
                    $client.data.tomorrow = $parseTree.text
                }
        
    state: all
        q!: all 
        a: Вот все что есть на сегодня: {{$client.data['today']}}\nВот все что есть на завтра: {{$client.data['tomorrow']}}
        
    state: empty
        q!: empty
        script: $client.data = {};