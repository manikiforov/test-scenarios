theme: /OffTopic


    state: Politics
        # Что ты думаешь о Путине
        q!: * (~конституция/констетуци*/канституци*/политик*/$politicNamesRus/~президент/~презедент/~призидент/единорос*/$politicNamesForeign/$politicNamesHistoric/$politicParty/политич* (~партия/~ситуация/~взгляд)/~Америка) *
        intent!: /Politics
        script:
            $reactions.answer(ans.sorry);


    state: WhatIsTheWeatherLike
        # какая погода
        q!: * $weather *
        q!: * ($which/$comWhat за/$how/($how/$comWhat) $with) прогноз* * $weather *
        q!: * $weatherCondition *

        # как там на улице
        q!: * {($comWhat/$how) * (на (улице/улке)/за (окном/окошком/окошечком))} *
        intent!: /WhatIsTheWeatherLike
        script:
            $reactions.answer(ans.sorry);


    state: Calculator
        # Сколько будет дважды два
        q!: * (сложи*/умнож*/вычти*/вычесть/раздели*/остат* от делен*/калькулят*) *
        q!: * {(посчит*/вычисл*) * $CalcOpPrefix} *
        q!: * $CalcFunc *
        q!: * $CalcTrigonometryDegree *
        q!: * $CalcTrigonometryDegreeWithoutSpaces *
        q!: * $CalcTrigonometryRadian *
        q!: * $CalcMul $Number *
        q!: $Number $CalcOp $Number
        q!: $SimpleExpressionWithoutSpaces
        q!: * ($Number $CalcOp $Number/$SimpleExpressionWithoutSpaces) (=/равно/равня*) *
        q!: * $skolko (будет/будит) ($SimpleExpressionWithoutSpaces/$Number $CalcOp $Number) *
        script:
            $reactions.answer(ans.sorry);
































