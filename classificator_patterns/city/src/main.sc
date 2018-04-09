require: patterns/city.sc

theme: /

    state: CatchAll || noContext = true
        q!: *
        a: Не понял
    
    state:
        eg!: Patterns.InExample.City
        script:
            if ($parseTree._City.name == "Санкт-Петербург") {
                $reactions.answer("Дождливо(");
            } else {
                $reactions.answer("На дерибасовской хорошая погода");
            }