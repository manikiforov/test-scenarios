patterns:
    $NumberDigit = $regexp<\d+>
            
    
    $NubmerCommaSeparated = $regexp<\d+\.\d+(\.\d+)+>
            

    $NumberOrdinalDigit = $regexp<\d?(1st|2nd|3rd|\dth)>
            

    $NumberOneDigit = (
        (нол*|нул*|zero):0 | 
        (~один|~одна|перв*|единиц*|единичк*|однерка|однёрка|one|first):1 | 
        (~два|дву*|две|втор*|пара|пару|двое|~двойка|~двоечка|two|[a] couple of|second):2 | 
        (~три|трет*|трех|трое|three|~тройка|~троечка|~трешечка|third):3 | 
        (~четыре|четверт*|четырех|четверо|~четверка|~четверочка|*four|fourth):4 | 
        (~пять|пята*|пято*|пятый|пятым*|пяти|пятер*|five|fifth):5 | 
        (~шесть|шест*|шестым*|шести|шестер*|six|sixth):6 | 
        (~семь|седьм*|семи|семер*|seven|seventh):7 | 
        (~восемь|восьм*|восем|eight*):8 | 
        (~девять|~девятка|девят*|девятый|~девяточка|nine|ninth):9 )
            

    $NumberTwoDigit = (
        (десят*|ten|tenth):10 | 
        (одиннадцат*|eleven*):11 | 
        (двенадцат*|twelve|twelfth):12 | 
        (тринадцат*|thirteen*):13 | 
        (четырнадцат*|fourteen*):14 | 
        (пятнадцат*|fifteen*):15 | 
        (шестнадцат*|sixteen*):16 | 
        (семнадцат*|seventeen*):17 | 
        (восемнадцат*|eighteen*):18 | 
        (девятнадцат*|nineteen*):19 )
            

    $NumberNumeric = ($NumberOneDigit | $NumberTwoDigit)
            

    $NumberSimple = ($NumberDigit | $NumberOrdinalDigit | $NumberNumeric)
            

    $NumberDozenWithDash = $regexp<(twenty|thirty|forty|fifty|sixty|seventy|eighty|ninety)-((one|two|three|four|five|six|seven|eight|nine)|(first|second|third|fourth|fifth|sixth|seventh|eighth|nineth))>
            

    $NumberDozen = (
        (двадцать|двадцат*|twenty|twentieth):20 | 
        (тридцать|тридцат*|thirty|thirtieth):30 | 
        (сорок*|forty|fortieth):40 | 
        (пятьдесят|пятидесят*|fifty*|fiftieth):50 | 
        (шестьдесят|шестидесят*|шисят|sixty|sixtieth):60 | 
        (семьдесят|семидесят*|seventy|seventieth):70 | 
        (восемьдесят|восьмидесят*|eighty|eightieth):80 | 
        (девяносто|девяност*|ninety|ninetieth):90 )
            

    $NumberHundred = (
        (сто|ста|[~один] ~сотня|~соточка):100 | 
        (двести|двухсот*|двухста|~два ~сотня):200 | 
        (триста|тристо|трехсот*|трёхста|трехста/~три ~сотня):300 | 
        (четырест*|четырехсот*|четырехста|четырёста/~четыре ~сотня):400 | 
        (пятьсот|пятисот*|пятиста/~пять ~сотня):500 | 
        (шестьсот|шестисот*|шестиста/~шесть ~сотня):600 | 
        (семьсот|семисот*|семиста/~семь ~сотня):700 | 
        (восемьсот|восьмисот*|восемьста/~восемь ~сотня):800 | 
        (девятьсот|девятисот*|девятиста/~девять ~сотня):900 )
            

    $NumberHundredComplex = 
        [$NumberDozen] [$NumberSimple] hundred*: 100
            
        
    $NumberThreeDigit = (
        $NumberHundredComplex [and] [[$NumberDozen] [$NumberSimple]|$NumberDozenWithDash] |
        $NumberHundred [and] [[$NumberDozen] [$NumberSimple]|$NumberDozenWithDash] |
        $NumberDozen [$NumberSimple] |
        $NumberDozenWithDash |
        $NumberSimple 
        )
            

    $NumberThousands = [$NumberThreeDigit] (тысяч*|тыщ*|thousand*):1000
            

    $NumberMillions = [$NumberThreeDigit] (миллион*|million*|millon*):1000000
            

    $NumberBillions = [$NumberThreeDigit] (миллиард*|лярд*|billion*|billones*):1000000000
            

    $Number = (
        $NumberBillions [and|и] [$NumberMillions] [and|и] [$NumberThousands] [and|и] [$NumberThreeDigit] |
        $NumberMillions [and|и] [$NumberThousands] [and|и] [$NumberThreeDigit] |
        $NumberThousands [and|и] [$NumberThreeDigit] |
        $NumberThreeDigit |
        $NubmerCommaSeparated
        )
            
