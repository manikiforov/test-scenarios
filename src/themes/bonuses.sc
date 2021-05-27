theme: /Bonuses

    state: WhatAreBonuses
        # Что такое бонусы
        q!: [$ne] [*скаж*/науч*] [о/про/по [поводу]] $bonus [$ne] [*скаж*/науч*]
        q!: * {$howMuch * $bonus} *
        q!: * {($findOutInf/уточнить) * ($comMy количество $bonus)} *
        q!: * {~функция $bonus} *
        q!: * {$findOutInf [$oneWord] (о/про/по поводу) $bonus} *
        q!: * {~информация (о/про/по [поводу]) $bonus} *
        q!: * $comWhat [это] $oneWord [эти] [накопл*] $bonus *
        q!: * $whatFor [вообще] [$oneWord] [эти] $bonus *
        q!: * (~какой ~цель) [$oneWord] $bonus *
        q!: $bonus $whatFor (она/они) $comNeed *
        q!: $bonus {это $comWhat}
        q!: {[$beginningWords] [в чем] [заключа*] смысл $bonus}
        q!: * в чем смысл $oneWord $bonus *
        q!: * {($comWhere/$how) * ($receiveInf/$earnInf) * $bonus} *
        q!: * {$how * $saveUp * $bonus} *
        q!: * {$how * $useInf * $bonus} *
        q!: * {$how * $buyInf * $bonus} *
        q!: * {$how (начисляю*/начисляе*/появл*) $bonus} *
        q!: * {$how пополнить $bonus} *
        q!: * (купить/приобрести) $bonus *
        q!: * {($comWhere/$how) * $checkInf * $bonus} *
        q!: * инф* по моим $bonus *
        q!: * $comWhere [$possiblePredic] $seeInf $comMy $bonus *
        q!: * систем* начислен* $bonus *
        q!: * {($fromWhere [$possiblePredic] (взять/берут*/беруц*) [$possiblePredic]) $bonus} *
        q!: * {$comWhere * (правила * бонус* прогр*)} *
        intent!: /Bonuses/WhatAreBonuses
        a: Бонусная программа – это система поощрения, подразумевающая под собой накопление определенного количества бонусных баллов за покупки на сайте Столото или в розничных точках продаж, а также возможность использования этих баллов для приобретения лотерейных билетов и участия в бонусных играх.\nБонусные баллы начисляются за покупку лотерейных билетов, а также некоторые другие действия на сайте stoloto.ru, мобильной версии сайта, в мобильном приложении, по SMS​ или при покупке билетов в розничных точках продаж.\nПодробная информация содержится в правилах бонусной программы (раздел Бонусы личного кабинета), а также в Новостях на сайте.

    state: WhatIsTheBonusValue
        # Чему равен бонус
        q!: * (чему/скольк*) * (равен/равняетс*/равняетьс*) * $bonus *
        q!: * ~номинал [у] $bonus *
        q!: * $bonus (равен/равняетс*/равняетьс*) [$oneWord] $rub *
        q!: * скольк* {$rub (в [$oneWord] $bonus)} *
        q!: * $Number $bonus это скольк* *
        intent!: /Bonuses/WhatIsTheBonusValue
        a: За каждые 33 рубля вы получите 1 бонус. Подробная информация содержится в правилах бонусной программы (раздел «Бонусы» личного кабинета), а также в новостях на сайте.


    state: HowToAddBonusesToPurse
        # Как добавить бонусы в кошелек
        q!: * $bonus $toWallet *
        q!: * {$transferInfImp * $bonus * ($toWallet/в $w1All)} *
        q!: * {$sendInf * $bonus * ($toWallet/в $w1All)} *
        q!: * {$appendInf * $bonus * $toWallet} *
        q!: * {$putInf * $bonus * $toWallet} *
        q!: * {$transferInfImp * $bonus * (в ($comMoney/рубли/ден* эквивалент))} *
        q!: * {преобразовать * $bonus * (в ($comMoney/рубли/ден* эквивалент/гигобайт*))} *
        q!: * {$exchangeInf * $bonus * (на ($comMoney/рубли/ден* эквивалент/гигобайт*/интернет))} *
        intent!: /Bonuses/HowToAddBonusesToPurse
        a: Перевести бонусные баллы в Кошелек или преобразовать в рубли технически невозможно.\n\nБонусная программа – это система поощрения, подразумевающая под собой накопление определенного количества бонусных баллов за покупки на сайте Столото или в розничных точках продаж, а также возможность использования этих баллов для приобретения лотерейных билетов и участия в бонусных играх.\n\nБонусные баллы начисляются за покупку лотерейных билетов, а также некоторые другие действия на сайте stoloto.ru, мобильной версии сайта, в мобильном приложении, по SMS​ или при покупке билетов в розничных точках продаж.\n\nПодробная информация содержится в правилах бонусной программы (раздел Бонусы личного кабинета), а также в Новостях на сайте.


    state: WhatCanIBuyForBonuses
        # Что можно купить за бонусы
        q!: * {$comWhat * $buyInf * ((на/за) [$Number] $bonus)} *
        q!: * {$comWhat * $spendInf * $bonus} *
        q!: * {$how * тратят * $bonus} *
        q!: * {$comWhat * тратят * $bonus} *
        q!: * {$how * $spendInf * $bonus} *
        q!: * куда * {$spendInf * $bonus} *
        q!: * {$payInf * $bonus} *
        q!: * $comWhat * $doInfLocal * ($with $bonus) *
        q!: * $comWhat $possiblePredic $doInfLocal $bonus *
        q!: * {применяютс* * $bonus} *
        q!: * $bonus [$beginningWords] $comWhat $with ними [$oneWord] делать *
        q!: * $bonus $possiblePredic $spendInf $only на *
        q!: * $bonus $comWhat {$doInfLocal $possiblePredic} *
        q!: * $bonus куда их * $useInf *
        q!: * какой толк (от/$with) [эт*] $bonus *
        q: * смысл их (накапливать/копить/собирать) * || fromState = /Bonuses/WhereAreMyBonuses
        q: * смысл их (накапливать/копить/собирать) * || fromState = /Bonuses/WhatAreBonuses
        q: * $whatFor они $comNeed * || fromState = /Bonuses/WhatAreBonuses
        intent!: /Bonuses/WhatCanIBuyForBonuses
        a: Бонусные баллы можно потратить на:\n- приобретение билетов в бонусные игры;\n- приобретение новых лотерейных билетов.


    state: HowToBuyATicketForBonuses
        # Как купить билет с помощью бонусов
        q!: * {[$how] * $buyInf * $ticketAndLotteryAll * $bonus} *
        q!: * {[$possiblePredicAll] * $buyInf * $ticketAndLotteryAll * $bonus} *
        q!: * {[$how] * $payInf * $ticketAndLotteryAll * $bonus} *
        q!: * {[$possiblePredicAll] * $payInf * $ticketAndLotteryAll * $bonus} *
        q!: * {($how действ* $payment) * $bonus} *
        q!: * {[$how] * $spendInf * $ticketAndLotteryAll * $bonus} *
        q!: * {[$possiblePredicAll] * $spendInf * $ticketAndLotteryAll * $bonus} *
        q!: * {$buyN * $ticket * $bonus} *
        q!: * {~оплата * $ticket * $bonus} *
        q!: * {$exchangeInf * $ticket * $bonus} *
        q!: * {$comWhere * $payInf * $bonus} *
        q: * {$exchangeInf * (на [$oneWord] $ticket)} * || fromState = /Bonuses/WhatCanIBuyForBonuses
        q: * {$exchangeInf * (на [$oneWord] $ticket)} * || fromState = /Bonuses/WhatAreBonuses

        intent!: /Bonuses/HowToBuyATicketForBonuses
        a: Приобрести билеты лотерей за бонусы Вы можете на сайте stoloto.ru. Для оплаты билета бонусами Вам необходимо нажать на кнопку «Все способы оплаты», далее выбрать способ оплаты «Бонусы».\n\nОбратите внимание, что при покупке билета соотношение одного бонуса к номинальному значению в рублях разнится в зависимости от лотереи (подробная информация содержится в правилах бонусной программы в разделе «Бонусы» личного кабинета).\n\nВажно! За билеты, оплаченные бонусами или подарочными кодами, бонусы не начисляются. Срок действия бонусов: 6 месяцев со дня начисления. По окончании этого срока бонусы сгорают и не могут быть использованы.\n\nТакже Вы можете приобрести билеты в розничных точках продаж.Более подробно ознакомиться с условиями Бонусной программы Вы можете по ссылке http://www.stoloto.ru/bonus?bls=bonus&service=bonus


    state: HowToBuyATicketForSpasibo
        # Как купить билет за бонус Спасибо от Сбербанка
        q!: * $comWhat $oneWord $spasibo *
        q!: * $spasibo * $comWhat $with ним* *
        q!: * (есть/у меня) $spasibo *
        q!: * {[$how] * $buyInf * $ticketAndLotteryAll * $spasibo} *
        q!: * {[$how] * $buyInf * [$bet] * $spasibo} *
        q!: * {[$possiblePredicAll] * $buyInf * $ticketAndLotteryAll * $spasibo} *
        q!: * {[$possiblePredicAll] * $buyInf * $bet * $spasibo} *
        q!: * {[$how] * $payInf * $ticketAndLotteryAll * $spasibo} *
        q!: * {[$how] * $payInf * $bet * $spasibo} *
        q!: * {[$how] * $payInf * $spasibo} *
        q!: * {($how действ* $payment) * $spasibo} *
        q!: * $payInf ~купон спасибо *
        q!: * {[$possiblePredicAll] * $payInf * $ticketAndLotteryAll * $spasibo} *
        q!: * {[$possiblePredicAll] * $payInf * $bet * $spasibo} *
        q!: * {[$how] * $spendInf * $ticketAndLotteryAll * $spasibo} *
        q!: * {[$how] * $spendInf * $bet * $spasibo} *
        q!: * {[$possiblePredicAll] * $spendInf * $ticketAndLotteryAll * $spasibo} *
        q!: * {[$possiblePredicAll] * $spendInf * $bet * $spasibo} *
        q!: * {$buyN * $ticketAndLotteryAll * $spasibo} *
        q!: * {$buyN * $bet * $spasibo} *
        q!: * {~оплата * $ticketAndLotteryAll * $spasibo} *
        q!: * {~оплата * $bet * $spasibo} *
        q!: * {$buyN * $useInf * $spasibo} *
        q!: * {~оплата * $useInf * $spasibo} *
        q!: [$helloAll] $how {$useInf спасибо}
        q!: * {~код * $useInf * $spasibo} *
        q!: * {$exchangeInf * $ticket * $spasibo} *
        q!: * {$exchangeInf * [~купон] * $spasibo} *
        q!: * {$comWhere * $payInf * $spasibo} *
        q!: * ($how/$comWhere) * {$receiveInf * $ticketAndLotteryAll * $spasibo} *
        q!: * {применить * $spasibo} *
        q!: * {реализовать * $spasibo} *
        q!: * ($buyPastPres/есть) * $spasibo * (оформить/$useInf) *
        q!: * (оформить/$useInf) * $buyPastPres * $spasibo *
        q!: * {$buyInf * $specialBonus * $spasibo} *
        q!: * {$payInf * $specialBonus * $spasibo} *
        q!: * {$buyN * $specialBonus * $spasibo} *
        q!: * {~оплата * $specialBonus * $spasibo} *
        q!: * {$spendInf * $specialBonus * $spasibo} *
        q!: * {$useInf * $specialBonus * $spasibo} *
        q!: * $comWhat * $doInfLocal * ($with $specialBonus) * $spasibo *
        q!: * ~оплата [$ticket] $specialBonus * $spasibo *
        q!: * {$inactive * (~способ оплаты) * $specialBonus * $spasibo} *
        q!: * {($comNo такого способа оплаты) * $spasibo} *
        q!: * {$how * $useInf * $spasibo} *
        q!: * обменял* * $spasibo * вводить *
        q!: * получил* $promotionalCode * $spasibo * что [д*] дальше *
        q!: * $buyPastPres $promotionalCode [в/от/у] ($sberbank/сбера/сбере) *
        q!: * {$useInf * $promotionalCode * $sberbank} *
        q!: * {$useInf * $promotionalCode * сбера} *
        q!: * {применить * $promotionalCode * $sberbank} *
        q!: * {применить * $promotionalCode * сбера} *
        q!: * {проверить * $promotionalCode * $sberbank} *
        q!: * {проверить * $promotionalCode * сбера} *
        q!: * {$useInf * ~код * $sberbank} *
        q!: * {$useInf * ~код * сбера} *
        q!: * {$exchangeInf * ~код * $sberbank} *
        q!: * {$exchangeInf * ~код * сбера} *
        q!: * {$specialBonus * $sberbank * ($wrong ~код)} *
        q!: * {$specialBonus * сбера * ($wrong ~код)} *
        q!: * {$specialBonus * $sberbank * $indicatePresSg1} *
        q!: * {$specialBonus * сбера * $indicatePresSg1} *
        q!: * {$promotionalCode * $sberbank * $indicatePresSg1} *
        q!: * {$promotionalCode * сбера * $indicatePresSg1} *
        q!: * {$specialBonus * $sberbank * $indicatePast} *
        q!: * {$specialBonus * сбера * $indicatePast} *
        q!: * {$promotionalCode * $sberbank * $indicatePast} *
        q!: * {$promotionalCode * сбера * $indicatePast} *

        q!: * ($ne активирует*/неактивирует*/$ne проходит/непроходит/нипроходит) * {[$promotionalCode/$specialBonus] * $spasibo} *
        q!: * {[$promotionalCode/$specialBonus] * $spasibo} * * ($ne активирует*/неактивирует*/$ne проходит/непроходит/нипроходит) *

        q!: * {$appendPres3Ne * [$promotionalCode] * $spasibo} *
        q!: * {$workPres3Ne * [$specialBonus] * $spasibo} *
        q!: * {$workPres3Ne * [$promotionalCode] * $spasibo} *
        q!: * {$workPres3Ne * $specialBonus * $sberbank} *
        q!: * {$workPres3Ne * $specialBonus * сбера} *
        q!: * {$workPres3Ne * $promotionalCode * $sberbank} *
        q!: * {$workPres3Ne * $promotionalCode * сбера} *
        q!: * {$appendPres3Ne * $promotionalCode * ($sberbank/сбера)} *
        q!: * {$cantPastPresAll * (активировать/добавить) * ($specialBonus * $spasibo)} *
        q!: * {$cantPastPresAll * (активировать/добавить) * ($promotionalCode * $spasibo)} *
        q!: * {$cantPastPresAll * (активировать/добавить) * ($specialBonus * $sberbank)} *
        q!: * {$cantPastPresAll * (активировать/добавить) * ($specialBonus * сбера)} *
        q!: * {$cantPastPresAll * (активировать/добавить) * ($promotionalCode * $sberbank)} *
        q!: * {$cantPastPresAll * (активировать/добавить) * ($promotionalCode * сбера)} *
        q!: * $cantPastPresAll $inputInf * $ticket по ($specialBonus/$promotionalCode) * ($spasibo/$sberbank/сбера) *

        intent!: /Bonuses/HowToBuyATicketForSpasibo
        a: В рамках Акции клиенты «Спасибо» могут приобрести на площадке «Спасибо» промокод на покупку лотерейных билетов. Промокод - это наш специальный бонус, который необходимо активировать на нашем сайте/мобильной версии/мобильном приложении.\n\nЧтобы оплатить билет специальным бонусом, сформируйте, пожалуйста, комбинацию или выберите билет на официальной странице сайта «Столото» (www.stoloto.ru). Номинал билета не должен превышать сумму специального бонуса. Далее необходимо нажать на кнопку «Все способы».\n\nПосле этого Вы перейдете к списку ресурсов оплаты. Выберите, пожалуйста, из списка «Специальный бонус». Далее Вам нужно ввести специальный бонус и нажать кнопку «Добавить». Инструкцию для оплаты кодом Вы можете посмотреть по ссылке https://www.stoloto.ru/private/infospecbonus


    state: HowToActivateSpasibo
        # Как активировать бонус Спасибо?
        q!: * {активировать * [$ticket] * $spasibo} *
        q!: * {активировать * (~купон спасибо)} *
        q!: * {активировать * ~купон * $sberbank} *
        q!: * {активировать * ~купон * сбера} *
        q!: * {(активировать/открыть) * $specialBonus} *
        q!: * {активировать * $promotionalCode} *
        q!: * {(~неправильный код активации) * $spasibo} *
        q!: * {$inputInf * $promotionalCode * [$spasibo]} *
        q!: * {$inputInf * $specialBonus} *
        q!: * {$inputInf * ~код * $spasibo} *
        q!: * {$inputInf * ~код * $sberbank} *
        q!: * {$inputInf * ~код * сбера} *
        q!: * {$inputInf * ~купон * $spasibo} *
        q!: * {$inputInf * ~купон * $sberbank} *
        q!: * {$inputInf * ~купон * сбера} *
        q!: * {$inputInf * $number * $spasibo} *
        q!: * {$inputInf * $specialBonus * $spasibo} *
        q!: * {вводитс* * $promotionalCode} *
        q!: * {вводитс* * $specialBonus} *
        q!: * $inputInf ($promotionalCode/~код) спасибо *
        q!: * ($buyPastPres/есть) * $spasibo * ($inputInf/активировать) *
        q!: * ($inputInf/активировать) * $buyPastPres * $spasibo *
        q!: * {$registerInf * $promotionalCode} *
        q!: * {$registerInf * $specialBonus} *
        q!: * {$registerInf * ~код * $sberbank} *
        q!: * {$registerInf * ~код * сбера} *
        q!: * {активировать * ($code $bonus)} *
        q!: * {добавить * $specialBonus} *
        q!: * {добавить * $promotionalCode} *
        intent!: /Bonuses/HowToActivateSpasibo
        a: Откройте, пожалуйста, вкладку «Специальный бонус» в личном кабинете на нашем сайте https://www.stoloto.ru/\n\nВведите специальный бонус из письма в поле «Добавить новый». Введите код проверки с картинки и нажмите «Добавить».


    state: IDidntGetBonuses
        # Где мои бонусы?
        q!: * {$comWhere [$comMy] [$comMy/~заработанный/обещан*/акцион*] [$Number] $bonus} *
        q!: * {$comWhere * $ticket * $bonus} *
        q!: * {$bonus * $bonusComePastPresNe} *
        q!: * {получить * $bonus * (за $ticket)} *
        q!: * {[$buyPastPres] * $ticket * $bonus * $bonusComePastPresNe} *
        q!: * {($ne получил*/неполучил*/ниполучил*) [$comMy/~заработанный/обещан*/акцион*] [$Number] $bonus} *
        q!: * {$ticket * ($ne получил*/неполучил*/ниполучил*) * $bonus} *
        q!: * {$bonus $comNo} *
        q!: * {$ticket * [$buyPastPres] * $bonus * $comNo} *
        q!: * {$when * $bonusComeFut * $bonus} *
        q!: * ($when/$howMuch) * {$waitInf [$comMy/~заработанный/обещан*/акцион*/подарочн*] [$Number] $bonus} *
        q!: * {$bonus $bonusDoesntRise} *
        q!: * {обещал* * ([$Number] $bonus) * ($comWhere/$when)} *
        q!: * {должны * $moneyAddInf * $bonus} * $comWhere * (они/$bonus) *
        q!: * {$winPastPerf * ([$Number] $bonus) * ($comWhere/$when)} *
        intent!: /Bonuses/IDidntGetBonuses
        a: Если бонусы не начислились, уточните, пожалуйста, регистрационные данные, название лотереи, способ оплаты, дату и время покупки билета.

        state: GetInformation || fromState = /Bonuses/IDidntGetBonuses
            q: * {$localMobilePhoneNumber * [$localEmail]} *
            q: * {[$localMobilePhoneNumber] * $localEmail} *
            event: noMatch
            script: Webim.switch();


    state: WhereAreMyBonuses
        # Куда делись бонусы?
        q!: * {$bonus * $bonusDisappearPastPres * [за [$ticket/$buyN]]} *
        q!: * {$bonus * (воруют*/ворует*/снимают*)} *
        q!: * у меня сняли $bonus *

        q!: * $returnImp * $bonus * их ($ne тратил*/нетратил*/нитратил*) *
        q!: * $returnImp * $bonus * ($ne тратил*/нетратил*/нитратил*) их *

        q!: * был* накоплен* * $bonus * (сегодня/$comNow) *
        q!: * {куда * $moneyTakeOffPastPres * $bonus} *
        q!: * $why * ($moneyTakeOffPastPres/тратятс*/тратятьс*/тратяц*) $bonus *
        q!: * {связано * уменьшение * $bonus} *
        q!: * {$bonus могут исчезать} *
        q!: * ~исчезновение $bonus *
        q!: * $comWhere $comMy накопл* $bonus *
        q!: * было больше $bonus *
        q!: * $bonus было более *

        # У меня было свыше 200 бонусов, а сейчас осталось 192. Как это случилось?
        q!: * $thereWereBonuses * $nowBonuses *

        intent!: /Bonuses/WhereAreMyBonuses
        a: Бонусные баллы имеют срок действия 6 месяцев и сгорают по истечении этого времени. Данная информация указана в правилах Бонусной программы. В разделе «Бонусы» во вкладке «История транзакций» Бонусной программы можно посмотреть, когда накопленные баллы сгорят.


    state: ICantToUseBonuses
        # Не могу воспользоваться бонусами
        q!: * {$cantPastPres * $useInf * $bonus} *
        q!: * {$cantPastPres * $spendInf * $bonus} *
        q!: * {$cantPastPres * сделать * $bonus} *
        q!: * {$cantPastPres * делать * $bonus} *

        q!: * {$cantPastPres * $buyInf * [$ticket] * $bonus} *
        q!: * {$cantPastPres * $payInf * [$ticket] * $bonus} *
        q!: * {$cantPastPres * $exchangeInf * $bonus} *
        q!: * {$cantPastPres * $buyN * $bonus} *
        q!: * {$cantPastPres * $payment * $bonus} *

        q!: * ($comNo/отсут*) функц* * списать $bonus *
        q!: * {списать * $bonus} * ($comNo/отсут*) [$oneWord] функц* *
        q!: * {списать * $bonus} * функц* ($comNo/отсут*) *

        q!: * $isWritten недостаточн* $bonus *

        q!: * {$why * $nelzya * $buyInf * $bonus} *
        q!: * {$why * $nelzya * $payInf * $bonus} *

        q!: * {$when * $buyInf * $bonus} *
        q!: * {$when * $payInf * $bonus} *

        q!: * {$payPresNe * [$ticketAndLottery] * $bonus} *

        q!: * {$buyInfNe * [$ticket] * $bonus} *
        q!: * {$payInfNe * [$ticket] * $bonus} *

        q!: * {$workPres3Ne $bonus} *
        q!: * {$acceptPresNe * $bonus} *
        q!: * {$comNo * ($payment $bonus)} *
        q!: * {(~способ ~оплата) * $comNo * $bonus} *
        q!: * (~способ ~оплата) * $zero $bonus *
        q!: * {$registerPres3Ne * $buyN * $bonus} *

        q!: * {$payment * $bonus * $error} *
        q!: * {$buyN * $bonus * $error} *
        q!: * {$buyInf * $bonus * $error} *
        q!: * {$payInf * $bonus * $error} *

        q!: * {$payInf * $bonus} * $moneyTakeOffPastPres * $fromWallet *

        q!: * {$error * (~списание $bonus)} *
        q!: * {($availablePlNe/$availableNe) $bonus} *
        intent!: /Bonuses/ICantToUseBonuses
        script: Webim.switch();


    state: ToUseBonusesAndMoneyToPay
        # Как я могу бонусы прибавить к деньгам в кошельке, чтобы купить билет?
        q!: * {$addInf * $bonus * $comMoney * [$ticket]} *
        q!: * {$addInf * $bonus * ~рубль * [$ticket]} *
        # Могу ли я оплатить часть стоимости билета бонусами?
        q!: * {$payInf * $partOfCost * $bonus * [$ticket]} *
        q!: * {вносить * $partOfCost * $bonus * [$ticket]} *
        q!: * {внести * $partOfCost * $bonus * [$ticket]} *
        q!: * {$bonus * (~оплата $partOfCost) * [$ticket]} *
        q!: * $bonus доплатить за $ticket *
        q!: * доплатить $bonus *
        q!: * {$payInf * [$ticketAndLotteryAll] * ($fromWallet и $bonus)} *
        q!: * {$payInf * [$ticketAndLotteryAll] * ($bonus и $fromWallet)} *
        intent!: /Bonuses/ToUseBonusesAndMoneyToPay
        a: Оплатить бонусами часть стоимости билета нельзя.

    #########################Бонусный баланс#################################

    state: IncorrectBonusBalance
        # Некорректный бонусный баланс
        q!: * {$wrong ~отображение [$sum] $bonus} *
        q!: * {$wrong [$sum] $bonus $balance} *
        q!: * {$wrong [~отображение] (бонусн* $balance)} *
        q!: * {~отображение * $bonus * $balance * $incorrectly} *
        q!: * {[$balance] * $bonus * $displayPres3 * $incorrectly} *
        q!: * {(бонусн* $balance) * $displayPres3 * $incorrectly} *
        q!: * {$balance * $bonus * отображен * $incorrectly} *
        q!: * {(бонусн* $balance) * отображен * $incorrectly} *
        q!: * {$incorrectly * $bonus * отображены} *
        q!: * {[~счет] * $displayPres3 * ($ne все [$sum] $bonus)} *
        q!: * {[$balance] * $displayPres3 * ($ne все [$sum] $bonus)} *
        intent!: /Bonuses/IncorrectBonusBalance
        if: ($session.location === 'default' || $session.location === 'premiumclub' || $session.location === 'autorised' || $session.location === 'notautorised' || $session.location === 'default' || $session.location === 'default_1')
            if: $global.bonusBalanceIsCorrect
                script: Webim.switch();
            else:
                a: В данный момент мы обновляем информацию на сайте. Вы сможете посмотреть свой баланс в кратчайшие сроки.
        else:
            if: $global.mobileBonusBalanceIsCorrect
                script: Webim.switch();
            else:
                a: По техническим причинам баланс бонусов в мобильном приложении отображается некорректно. Мы работаем над восстановлением корректного отображения. Информация обновится в ближайшее время.


    state: IncorrectMobileBonusBalance
        # Некорректный бонусный баланс в мобильном приложении
        q!: * $application * {$wrong ~отображение [$sum] $bonus} *
        q!: * {$wrong ~отображение [$sum] $bonus} * $application *
        q!: * $application * {$wrong [$sum] $bonus $balance} *
        q!: * {$wrong [$sum] $bonus $balance} * $application *
        q!: * $application * {$wrong [~отображение] $bonusBalance} *
        q!: * {$wrong [~отображение] $bonusBalance} * $application *

        q!: * {$bonusBalance * $displayPres3 * чушь} *

        q!: * $application * {$bonusBalance * (отображен/$displayPres3/~отображение) * $incorrectly} *
        q!: * {$bonusBalance * (отображен/$displayPres3/~отображение) * $incorrectly} * $application *

        q!: * $application * {$incorrectly * $bonus * (отображены/$displayPres3/~отображение)} *
        q!: * {$incorrectly * $bonus * (отображены/$displayPres3/~отображение)} * $application *

        q!: * {$displayPres3 * ($ne все $bonus) * $application} *
        intent!: /Bonuses/IncorrectMobileBonusBalance
        if: $global.mobileBonusBalanceIsCorrect
            script: Webim.switch();
        else:
            a: По техническим причинам баланс бонусов в мобильном приложении отображается некорректно. Мы работаем над восстановлением корректного отображения. Информация обновится в ближайшее время.


    ##################Бонусные игры###############################


    state: WhatIsBonusPlay
        # Что такое бонусные игры
        q!: [$ne] [*скаж*/науч*] [о/про/по [поводу]] $bonusPlay [$ne] [*скаж*/науч*]
        q!: * $comWhat $oneWord $bonusPlay *
        q!: * $whatFor [$oneWord] $bonusPlay *
        q!: * (~какой ~цель) [$oneWord] $bonusPlay *
        q!: $bonusPlay $whatFor (она/они) $comNeed *
        q!: $bonusPlay {это $comWhat}
        q!: {[$beginningWords] [в чем] [заключа*] смысл $bonusPlay}
        q!: * в чем (суть/смысл) $bonusPlay *
        q!: * {~информация (о/про/по [поводу]) $bonusPlay} *
        q!: * $comWhat ($possiblePredic/$possibly) ($getPrizInf/$winInf) ($with/в) $bonusPlay *
        q!: * какой толк (от/$with) [эт*] $bonusPlay *
        q!: * $comWhat дает * бонус* ~доска *
        q!: * $comWhat * $winInf (на/в) ($bonus/$bonusPlay) *
        intent!: /Bonuses/WhatIsBonusPlay
        a: Бонусная игра нужна для того, чтобы у Вас была возможность увеличивать Ваши бонусы. Для того чтобы сделать ход, купите билет на паровозик, который едет по доске, после этого Вы получаете возможность сыграть в бонусную игру. Основной смысл игры - увеличить количество Ваших бонусов.


    state: HowToPlayBonusPlay
        # Как играть в бонусные игры
        q!: * $playInf ((на/за) [$comMy] [$Number] $bonus/забонус*/набонус*) *
        q!: * {$how * $playInf * $bonusPlay} *
        q!: * {$how * $playInf * (полет фортуны)} *
        q!: * (*скаж*/напомните/$findOutInf/*читать/$link/*интерес*/посмотреть/поглядеть/уточнит*/объяснит*) * {правила * $bonusPlay} *
        q!: * {правила * $bonusPlay} * (*скаж*/напомните/$findOutInf/*читать/$link/*интерес*/посмотреть/поглядеть/уточнит*/объяснит*) *
        q!: [$helloAll] [какие] правила [в] $bonusPlay *
        # Как использовать бонусы в бонусных играх
        q!: * {$how * $useInf * $bonus * $bonusPlay} *
        intent!: /Bonuses/HowToPlayBonusPlay
        script: Webim.switch();


    state: BonusPlayDoesntWork
        # Не работает бонусная игра
        q!: * {$bonusPlay * $inactive} *
        q!: * {($bonusPlay/игры) $openPres3Ne} *
        q!: * {$cantPastPres * ($playInf/запустить/загрузить/$buyInf/$useInf) * $bonusPlay} *
        q!: * {([на/за] [$comMy] [$Number] $bonus) * $cantPastPres * $playInf} *
        q!: * {$when * $bonusComeFut * $bonusPlay} *
        q!: * $bonus * $bonusDisappearPastPres * игра * ($ne (начин*/начал*)/неначин*/неначал*) *
        intent!: /Bonuses/BonusPlayDoesntWork
        script: Webim.switch();


    state: WhatAreChipsInBonusPlaysFor
        q!: * ($whatFor/$comWhat) $oneWord * $chips *
        q!: * {$whatFor * $chips * $bonusPlay} *
        q!: * $comWhat $doInfLocal $with $chips *
        q!: * $chips ($whatFor/$comWhat $with) *
        q!: * $chips [это] $comWhat *
        q!: * {$chips * ($whatFor они дают)} *
        q!: * {$useInf * $chips} *
        q!: * {(~какой ~функция) * $chips} *
        intent!: /Bonuses/WhatAreChipsInBonusPlaysFor
        a: Фишки используются в бонусных играх, чтобы делать ход. Смысловой нагрузки данные фигуры не несут: они заменяют стандартную фигуру в виде паровозика.

    ##########################Спецбонусы###################################

    state: WhatAreSpecialBonuses
        # Что такое спецбонусы
        # Где взять спецбонусы
        q!: [$ne] [*скаж*/науч*] [о/про/по [поводу]] $specialBonus [$ne] [*скаж*/науч*]
        q!: * {~функция $specialBonus} *
        q!: * {$findOutInf $oneWord (о/про/по поводу) $specialBonus} *
        q!: * {~информация (о/про/по [поводу]) $specialBonus} *
        q!: * $comWhat $oneWord $specialBonus *
        q!: * $whatFor $oneWord $specialBonus *
        q!: * (~какой ~цель) [$oneWord] $specialBonus *
        q!: $specialBonus $whatFor (она/они) $comNeed *
        q!: $specialBonus {это $comWhat}
        q!: {[$beginningWords] [в чем] [заключа*] смысл $specialBonus}
        q!: * {$how (начисляю*/начисляе*) $specialBonus} *
        q!: * {($comWhere/$how) * ($receiveInf/$earnInf) * $specialBonus} *
        intent!: /Bonuses/WhatAreSpecialBonuses
        a: Специальные бонусы начисляются за победу в викторинах, которые мы проводим в наших группах в соцсетях. Также их можно получить за участие в акциях, о начале которых мы сообщаем в новостях и информационных рассылках. Способов много. Поэтому подписывайтесь на наши рассылки и сообщества, следите за новостями на сайте, участвуйте в акциях и получайте специальные бонусы.\n\nОтличие специального бонуса от обычного заключается в том, что специальный можно использовать на оплату только определенных лотерей.


    state: HowToBuyForSpecialBonuses
        # Оплата спецбонусами
        #как купить билет за спецбонус
        q!: * {$how * $buyInf * $specialBonus} *
        q!: * {$buyInf * $ticketAndLotteryAll * $specialBonus} *
        q!: * {[$how] * $payInf * $specialBonus} *
        q!: * {$comWhere * $payInf * $specialBonus} *
        q!: * {$payInf * $ticketAndLotteryAll * $specialBonus} *
        q!: * {$how * $buyN * $specialBonus} *
        q!: * {$how * ~оплата * $specialBonus} *
        q!: * {($how действ* $payment) * $specialBonus} *
        q!: * {$buyN * $ticketAndLotteryAll * $specialBonus} *
        q!: * {~оплата * $ticketAndLotteryAll * $specialBonus} *
        q!: * {$how * $spendInf * $specialBonus} *
        q!: * {$spendInf * $ticketAndLotteryAll * $specialBonus} *
        q!: * {$how * $useInf * $specialBonus} *
        q!: * {$useInf * $specialBonus * $ticketAndLotteryAll} *
        q!: * {$useInf * $specialBonus * $ticketAndLotteryAll} *
        q!: * {$exchangeInf * $ticketAndLotteryAll * $specialBonus} *

        q!: * $how * {$receiveInf * $ticketAndLotteryAll * (по $specialBonus)} *
        q!: * $comWhat * $doInfLocal * ($with [$comMy] $specialBonus) *
        q!: * ~оплата [$ticketAndLotteryAll/$bet] $specialBonus *

        q!: [$helloAll] $promotionalCode
        q!: * $promotionalCode * $comWhat ($with ним*/это) *
        q!: * $comWhat $oneWord $promotionalCode *
        q!: * {($how/$possiblePredicAll) * $useInf * $promotionalCode} *
        q!: * {($how/$possiblePredicAll) * $exchangeInf * $promotionalCode} *
        q!: * ($how/$comWhere) * {$receiveInf * $ticketAndLotteryAll * (по $promotionalCode)} *
        q!: * {[$how] * $buyInf * $ticketAndLotteryAll * $promotionalCode} *
        q!: * {[$possiblePredicAll] * $buyInf * $ticketAndLotteryAll * $promotionalCode} *
        q!: * {[$how] * $payInf * $ticketAndLotteryAll * $promotionalCode} *
        q!: * {[$possiblePredicAll] * $payInf * $ticketAndLotteryAll * $promotionalCode} *
        q!: * {[$how] * $spendInf * $ticketAndLotteryAll * $promotionalCode} *
        q!: * {[$possiblePredicAll] * $spendInf * $ticketAndLotteryAll * $promotionalCode} *
        q!: * {$buyN * $ticket * $promotionalCode} *
        q!: * {~оплата * $ticket * $promotionalCode} *
        q!: * {$exchangeInf * $ticketAndLotteryAll * $promotionalCode} *
        q!: * {$comWhere * $payInf * $promotionalCode} *

        q!: * $comNo зачисления (за/по) [$comMy] $specialBonus *
        q!: * {$workPres3Ne * $specialBonus} *
        q!: * {$workPres3Ne * $promotionalCode} *
        q!: * {$appendPres3Ne * $promotionalCode} *

        q!: * ($ne активирует*/неактивирует*) * $specialBonus *
        q!: * $specialBonus * ($ne активирует*/неактивирует*) *
        q!: * ($ne активирует*/неактивирует*) * $promotionalCode *
        q!: * $promotionalCode * ($ne активирует*/неактивирует*) *
        q!: * {$cantPastPresAll * (активировать/добавить) * $specialBonus} *
        q!: * {$cantPastPresAll * (активировать/добавить) * $promotionalCode} *
        q!: * {$cantPastPresAll * $findInf * (вкладк* $specialBonus)} *
        q!: * $comWhere * ($findInf/наход*/расположен*/$here) * ($tab $specialBonus) *
        q!: * $comWhere * (в меню) * $specialBonus *
        q!: * ($comNo/маршрут к) ($tab $specialBonus) *
        q!: * {$activeNe $specialBonus} *
        q!: * {$activeNe $promotionalCode} *
        q!: * $cantPastPresAll $inputInf * $ticket по ($specialBonus/$promotionalCode) *
        q!: * ввожу $specialBonus из $Number ~символ *
        q!: * $specialBonus должен быть длиной *
        q!: * проблема $with $specialBonus *

        q: * {$exchangeInf * (на [$oneWord] $ticket)} * || fromState = /Bonuses/WhatAreSpecialBonuses
        q: * {$exchangeInf * (на [$oneWord] $ticket)} * || fromState = /Bonuses/WhatAreSpecialBonuses

        intent!: /Bonuses/HowToBuyForSpecialBonuses
        a: Спецбонус можно использовать для оплаты билета на определенную лотерею.\n\n1. Выберите числа (или билет) на странице лотереи. Если у Вас есть спецбонусы для оплаты выбранной лотереи, под кнопкой оплаты появится надпись «Доступна оплата специальными бонусами». Нажмите кнопку «Все способы оплаты».\n\n2. На странице способов оплаты выберите «Специальный бонус».\n\n3. Из списка спецбонусов, доступных для данной лотереи, выберите тот, которым оплатите билет.\n\n4. Оплатить развернутую ставку спецбонусами нельзя.\n\n5. Если у Вас есть специальный бонус, который не указан в списке, добавьте его, используя кнопку «Добавить».\nВведите специальный бонус и код проверки. Нажмите «Добавить». Спецбонус появится в списке.\n\n6. Все действующие спецбонусы Вы можете видеть в разделе «Специальные бонусы» личного кабинета.


    state: IDidntGetSpecialBonuses
        # На почту спецбонус так и не пришел
        q!: * {$comWhere [$comMy/~заработанный/обещан*/акцион*] [$Number] $specialBonus} *
        q!: * {$specialBonus * ($bonusComePastPresNe/$smsComePastNe)} *
        q!: * {($ne (дали/дают)/недали/недают/$receivePastNe) * $specialBonus} *
        q!: * {$specialBonus $comNo} *
        q!: * {$findPastPresNe * $specialBonus} *
        q!: * {$sendPastPresNe * $specialBonus} *
        q!: * {$when * $bonusComeFut * $specialBonus} *
        q!: * ($when/$howMuch) * {$waitInf [$comMy/~заработанный/обещан*/акцион*/подарочн*] [$Number] $specialBonus} *
        q!: * {$cantPastPres * получить * $specialBonus} *
        q!: * {([больше/более] [чем] $thirtySixHours) * прошло} *
        q!: * {([больше/более] [чем] $thirtySixHours) * прошли} *
        q!: * {$smsComePastPresNe * $sms * $thirdTicket} *
        q!: * {$smsComePastPresNe * $sms * $thirtySixHours} *
        q!: * {($bonusComePastPresNe/$smsComePastNe/$comNo) * ($specialBonus/$bonus) * $thirtySixHours} *
        q!: * {$smsComePastNe * $ticket * $thirtySixHours} *
        q!: * долж* были * $sendMeInfPerf * ($promotionalCode/$specialBonus) * беспл* $ticket *
        intent!: /Bonuses/IDidntGetSpecialBonuses
        script: Webim.switch();


    state: IDidntGetSpecialBonusForBuyingTwoTickets
        # фри тикет
        q!: * {$when * $bonusComeFut * ($specialBonus/$bonus/$promotionalCode)} * $twoTickets2 *
        q!: * $twoTickets2 * {$when * $bonusComeFut * ($specialBonus/$bonus/$promotionalCode)} *


        # Дайте спецбонус за два купленных билета
        q!: * {$twoTickets2 * ($giftPastPresNe/$receivePastNe/$findPastPresNe/$comWhere/$when/$giveImp/$sendMeImp/$sendMeInfPerf/$duplicateInfPerf/$smsComeFut/подарят/подарите/пришлете/пришлют/скинете/скинут/получить/$waitPres1/$waitInf/$comNo/$bonusComePastPresNe/обещан*/обещали) * ($specialBonus/$bonus/$promotionalCode)} *

        q!: * {$twoTickets2 * (обещан*/обещали) * ($ticket/$specialBonus/$bonus/$promotionalCode)} *

        q!: подарочн* $ticket
        q!: * {($how/$comWhere/$when/$receivePastNe) * (подарочн* $ticket)} *

        q!: * ~бонусный $ticket *

        q!: * (~бонусный) $thirdTicket *
        q!: * {$thirdTicket бесплатно} *
        q!: * {$thirdTicket * ($giftPastPresNe/$comWhere/$gift)} *
        q!: * {($how/$comWhere/$when) * ($receiveInf/$buyInf/получу) * $thirdTicket} *
        # Я до сих пор не получил спецбонус на покупку третьего билета
        q!: * {($how/$when/$giftPastPresNe/$receivePastNe/$findPastPresNe/$comWhere/$when/$giveImp/$sendMeImp/$sendMeInfPerf/$duplicateInfPerf/$smsComeFut/подарят/подарите/пришлете/пришлют/скинете/скинут/получить/$waitPres1/$waitInf/$comNo/$bonusComePastPresNe/обещан*/обещали) * ($specialBonus/$bonus/$promotionalCode) * ($thirdTicket/$freeTicketPromotion)} *


        q!: * $freeTicketPromotion *

        #q!: * {($how/$comWhere/$when) * бесплатн* * $ticket} *
        # закомментировано, тянет лишнее
        q!: * {(бесплатн* $ticket) * $smsComePastPerfNe} *

        # купил два билета, когда будет третий
        q!: * $bought2Tickets * $whereIsTheThird *
        q!: * $whereIsTheThird * $bought2Tickets *

        # участвую в акции 1+1=3, когда будет бонус (билет)
        q!: * {$freeTicketPromotion * ($when/$giftPastPresNe/$receivePastNe/$findPastPresNe/$comWhere/$giveImp/$sendMeImp/$sendMeInfPerf/$duplicateInfPerf/$smsComeFut/подарят/подарите/пришлете/пришлют/скинете/скинут/получить/$waitPres1/$waitInf/$bonusComeFut) * ($specialBonus/$bonus/$ticket/~подарок/$promotionalCode)} *


        q!: * {($buyPastPres/$payPast/взял*) * $twoTicketsAll * ~акция} *
        q!: * $bought2Tickets * $comNeed выбрать еще (один/1) *

        q!: * $twoTicketsAll [$beginningWords] ($comWhere/$when/куда) бонусный *


        q!: * $why $comNo $thirdAll $ticket *
        q!: * что (*дарят/*дарите) $third *
        q!: * $comWhere [же] $third как (было обещано/обещал*) *
        q!: * [$buyInf] {$third бесплатн*} по акции *

        # купил 2 билета, подтвердил почту
        q!: * {(подтвердил*/активировал*/активации) * $mail} * $bought2Tickets *
        q!: * $bought2Tickets * {(подтвердил*/активировал*) * $mail} *

        # условия выполнил, купил 2 билета
        q!: * {(выполнил*/~акция/соблюден*) * ~условие} * ($bought2Tickets/($specialBonus/$bonus/$promotionalCode) на [$buyN] $ticket) *
        q!: * ($bought2Tickets/($specialBonus/$bonus/$promotionalCode) на [$buyN] $ticket) * {(выполнил*/~акция/соблюден*) * ~условие} *


        intent!: /Bonuses/IDidntGetSpecialBonusForBuyingTwoTickets
        a: Спецбонус на покупку 3-го билета будет отправлен по электронной почте в течение 36 часов после окончания проведения акции. С подробными условиями акции Вы можете ознакомиться, пройдя по ссылке http://free-ticket.stoloto.ru . Напишите нам, пожалуйста, если по прошествии 36 часов спецбонус не поступит.
        #script: Webim.switch();



















































