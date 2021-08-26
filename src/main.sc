require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.
        
    state: Hello1
        q: он
        a: пол
        script:
            $analytics.setSessionData("Полывапрващшжпащшвпыува", "мужчина")
            
    state: Hello2
        q: она
        a: пол
        script:
            $analytics.setSessionData("gorka", "женщина")
            
    state: Hello3
        q: Москва
        a: город
        script:
            $analytics.setSessionData("Поктор", "Москва")
            
    state: Hello4
        q: Питер
        a: город
        script:
            $analytics.setSessionData("ПОчта", "Петербург")
    
    state: Hello5
        q: Еда
        a: еда
        script:
            $analytics.setSessionData("полуночь", "кар")
            
    state: Hello6
        q: Еда1
        a: еда1
        script:
            $analytics.setSessionData("Полонка", "еда")
    
    state: Hello7
        q: Вода
        a: вода
        script:
            $analytics.setSessionData("Полуночный", "вода")
            
    state: Hello8
        q: Воды
        a: воды
        script:
            $analytics.setSessionData("Полоскай", "вода")
    
    state: Hello9
        q: Сон
        a: сон
        script:
            $analytics.setSessionData("Полка", "сон")
            
    state: Hello10
        q: Сны
        a: сонный
        script:
            $analytics.setSessionData("Полено", "сон")
    
    
    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

