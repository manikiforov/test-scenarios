theme: /Ticket

    state: CheckTicket
        # Как проверить билет?
        q!: [$helloAll] $result
        q!: [$helloAll] $regexp<\d{1,15}> {есть $prize}
        q!: [$helloAll] *скажит* [$sum] [$comMy] $prize
        q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize *
        q!: [$helloAll] ($sum/$result) [$comMy] $prize [интересует] [$ticket] [$number $Number]
        q!: [$helloAll] ставка $Number [$how/$comWhere] $checkTicketInf
        q!: [$helloAll] $possiblePredic [$li] $checkTicketInf
        q!: [$helloAll] ($ticket/$ticketNumber) $Number ($ticketRun/$ticketRunNumber) $Number
        q!: (CheckTicket/* Check Ticket/*Check-Ticket)
        q!: [$helloAll] я $winPastPerf
        q!: [$helloAll] [я] $want знать $win
        q!: [$skolko] {[~мой] $ticket $winPastPerf}
        q!: [$helloAll] $prizeAndSum [по] $ticket
        q!: [$helloAll] $comWhat за $prizeAndSum
        q!: [$how/$comWhere] [его/их] $checkTicketInf
        q!: {[$meDat] $comNeed $checkTicketInf}
        q!: [$helloAll] {[я] $winPastPerf $something} [сегодня]
        q!: [$helloAll] {[$comWhat] я $winPastPerf}
        q!: [$helloAll] [$comMy] [$code $Number] {~какой [$comMy] $win}
        q!: [$helloAll] [$comMy] [$code $Number] как ой [$comMy] $prize
        q!: $Number $comWhat за $prize
        q!: {$howMuch $prizeAndSum [в] [$lottery/$stoloto]}
        q!: $localMobilePhoneNumber этот $phoneAndNum $winPastPerf

        q!: * у меня $prize $or как
        q!: * $ticketRun $Number $ticketNumber $Number $number $ticketPack $Number [~мой] ($ticket/$ticketRun/$lottery) $win *
        q!: * $how $checkTicketInf (смогу/сможем)
        q!: * $isTicketWin *
        q!: * ($boughtTicket/$boughtTicketIn5) * (кажется/кажеться/возможн*) [я] $winPastPerf *
        q!: * ($boughtTicket/$boughtTicketIn5) * $winPastPerf [я] (кажется/кажеться/возможн*) *

        # для новогодних тиражей (когда не названа конкретная лотерея)
        q!: * $isTicketWin * $newYear *
        q!: * $newYear * $isTicketWin *
        q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * $newYear *
        q!: * какой $prize составил * $newYear * $ticket *
        q!: * {$how * сыграл* * ($newYear $ticket)} *
        q!: * {~проверка * ($newYear ($ticketRun/$ticketAndLottery))} *
        q!: * {($newYear $ticket) * $comWhat * $winPastPerf} *
        q!: * {$checkTicket * ($newYear ($ticketAndLottery/розыгрыш*/$ticketRun))} *
        q!: * {($checkTicket/$checkInf/$findOutInf/$findInf/$findOutImp) * ($newYear $win)} *
        q!: * $tellImp [мне] [$please] ~сумма $prize ([по] $newYear $ticket) *
        q!: * {~какой ((у/по) $newYear $ticket) $win} *
        q!: * $howMuch (составил/составляет) $newYear $win *
        q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $newYear $prizeAndSum)} *
        q!: * $winPastPerf ($li) (я/[~мой] [$oneWord] $newYear ($ticket/$ticketRun/$lottery)) *
        q!: * узнать $balance $comMy $newYear $ticket *

        intent!: /Ticket/CheckTicket
        a: Какая лотерея Вас интересует?
        script:
            if ($parseTree._newYear) {
                $session.newYear = true;
            } else {
                $session.newYear = false;
            }


        state: RussianLoto
            q: * $russianLoto *
            q: * $1369 *

            q!: [$helloAll] $prizeAndSum [по] $ticket $russianLoto
            q!: {~какой [$comMy] $win $russianLoto}
            q!: {$howMuch $prizeAndSum ([в] $russianLoto)}

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * $russianLoto *

            q!: * {[$how/$comWhere] * $checkTicket * $russianLoto} *
            q!: * {[$how/$comWhere] * $checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $russianLoto} *

            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $russianLoto} *

            q!: * {($findOutInf/$findOutImp) * $win * $russianLoto} *
            q!: * {[$how/$comWhere] * $findInf * $win * $russianLoto} *

            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $russianLoto} *

            q!: * {$how * сыграл* * $ticket * $russianLoto} *
            q!: * {$ticket * $comWhat * $winPastPerf * $russianLoto} *

            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $russianLoto} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $russianLoto} *
            q!: * {$winPastPerf * $or * проиграл* * $russianLoto} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $russianLoto} *
            q!: * {($findOutInf есть [$li]) * $win * $russianLoto} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $russianLoto} *

            q!: * {~какой (у $me) $win} * $russianLoto *
            q!: * $russianLoto * {~какой (у $me) $win} *

            q!: * {~какой ((у/по) $ticket) $win} * $russianLoto *
            q!: * $russianLoto * {~какой ((у/по) $ticket) $win} *

            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $russianLoto} *
            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $russianLoto} *
            q!: * {($howMuch (составил/составляет) $win) * $russianLoto} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $russianLoto} *
            q!: * {($comWhat [я] $winPastPerf) * $russianLoto} *
            q!: * {($findOutInf/$checkInf) * $result * $russianLoto} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $russianLoto} *
            q!: * {(какие числа выпали) * $russianLoto} *

            # для новогоднего тиража Русского лото

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * {$newYear * $russianLoto} *

            q!: * {(какой $prize составил * $newYear * $ticket) * $russianLoto} *

            q!: * [$how/$comWhere] * {$checkTicket * $russianLoto * $newYear} * [$how/$comWhere] *

            q!: * $russianLoto * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $newYear} *
            q!: * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $newYear} * $russianLoto *
            q!: * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $russianLoto} * $newYear *

            q!: * $russianLoto * {($checkTicket/$checkInf/$findOutInf/$findOutImp/$findInf) * $win * $newYear} *
            q!: * {($checkTicket/$checkInf/$findOutInf/$findOutImp/$findInf) * $win * $newYear} * $russianLoto *


            q!: * $russianLoto * {~проверка * ($ticketAndLottery/$ticketRun) * $newYear} *
            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $newYear} * $russianLoto *

            q!: * $russianLoto * {сыграл* * $ticket * $newYear} *
            q!: * {сыграл* * $ticket * $newYear} * $russianLoto *

            q!: * $russianLoto * {$comWhat * $winPastPerf * ($newYear [$ticket])} *
            q!: * {$comWhat * $winPastPerf * ($newYear [$ticket])} * $russianLoto *

            q!: * $russianLoto * {$winPastPerf * ($or ($comNo/$comWhat)) * $newYear} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $newYear} * $russianLoto *

            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $russianLoto * $newYear} *

            q!: * {($winPastPerf * $or * проиграл*/проиграл* * $or * $winPastPerf) * $russianLoto * $newYear} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $russianLoto * $newYear} *
            q!: * {(($findOutInf есть [$li]) * $win) * $russianLoto * $newYear} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $russianLoto * $newYear} *

            q!: * {~какой ((у/по) $ticket) $win} * $newYear * $russianLoto *
            q!: * $newYear * $russianLoto * {~какой ((у/по) $ticket) $win} *
            q!: * $russianLoto * {~какой ((у/по) $newYear $ticket) $win} *
            q!: * {~какой ((у/по) $newYear $ticket) $win} * $russianLoto *

            q!: * $russianLoto * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $newYear} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $newYear} * $russianLoto *

            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $russianLoto * $newYear} *
            q!: * {($howMuch (составил/составляет) $win) * $russianLoto * $newYear} *

            q!: * $russianLoto * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $newYear} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $newYear} * $russianLoto *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $newYear $prizeAndSum) * $russianLoto} *

            q!: * {($comWhat [я] $winPastPerf) * $russianLoto * $newYear} *

            q!: * $russianLoto * {($findOutInf/$checkInf) * $result * $newYear} *
            q!: * {($findOutInf/$checkInf) * $result * $newYear} * $russianLoto *

            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $russianLoto * $newYear} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] $newYear ($ticket/$ticketRun/$lottery))) * $russianLoto} *

            q!: * {($tellImp [мне] [$please] ~сумма $prize ([по] $newYear $ticket)) * $russianLoto} *

            q!: * {(узнать $balance $comMy $newYear $ticket) * $russianLoto} *

            q!: * {(какие числа выпали) * $russianLoto * $newYear} *

            # для 1369 тиража
            q!: [$helloAll] $prizeAndSum [по] $ticket $1369
            q!: {~какой [$comMy] $win $1369}
            q!: {$howMuch $prizeAndSum ([в] $1369)}

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * $1369 *

            q!: * {[$how/$comWhere] * $checkTicket * $1369} *
            q!: * {[$how/$comWhere] * $checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $1369} *

            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $1369} *

            q!: * {($findOutInf/$findOutImp) * $win * $1369} *
            q!: * {[$how/$comWhere] * $findInf * $win * $1369} *

            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $1369} *

            q!: * {$how * сыграл* * $ticket * $1369} *
            q!: * {$ticket * $comWhat * $winPastPerf * $1369} *

            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $1369} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $1369} *
            q!: * {$winPastPerf * $or * проиграл* * $1369} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $1369} *
            q!: * {($findOutInf есть [$li]) * $win * $1369} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $1369} *

            q!: * {~какой (у $me) $win} * $1369 *
            q!: * $1369 * {~какой (у $me) $win} *

            q!: * {~какой ((у/по) $ticket) $win} * $1369 *
            q!: * $1369 * {~какой ((у/по) $ticket) $win} *

            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $1369} *
            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $1369} *
            q!: * {($howMuch (составил/составляет) $win) * $1369} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $1369} *
            q!: * {($comWhat [я] $winPastPerf) * $1369} *
            q!: * {($findOutInf/$checkInf) * $result * $1369} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $1369} *
            q!: * {(какие числа выпали) * $1369} *

            if: $parseTree._newYear || $parseTree._1369 || $session.newYear
                if: checkIfCurrentDateIsBefore("2021-01-01 18:00")
                    # до 18:00 1 января
                    a: Результаты новогоднего тиража лотереи «Русское лото» будут опубликованы на сайте 1 января 2021 года после 18:00 мск.
                    script:
                        $session.newYear = false;
                else:
                    go!: ../Other
            else:
                if: Time.isSpecialEvent(18)
                    # если 1 января до 18:00
                    a: Результаты новогоднего тиража лотереи «Русское лото» будут опубликованы на сайте 1 января 2021 года после 18:00 мск.
                else:
                    if: Time.sundayTimeIsGood() // Setting testMode to true via /setTestMode will enable sunday-like answer forever.
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        go!: ../Other


        state: MyWish
            # как проверить билет акции Мое желание
            q: * $myWish *

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * $myWish *
            q!: * {[$how/$comWhere] * $checkTicket * ($ticket/розыгрыш*) * $myWish} *
            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $myWish} *
            q!: * {[$how/$comWhere] * $checkTicket * $ticketRun * $myWish} *
            q!: * {[$how/$comWhere] * $checkTicket * [$lottery] * $myWish} *
            q!: * {$findOutInf * $win * $myWish} *
            q!: * {$findOutImp * $win * $myWish} *
            q!: * {~проверка * $ticket * $myWish} *
            q!: * {~проверка * $ticketRun * $myWish} *
            q!: * {~проверка * $lottery * $myWish} *
            q!: * {$how * сыграл* * $ticket * $myWish} *
            q!: * {$ticket * $comWhat * $winPastPerf * $myWish} *
            q!: [$helloAll] $prizeAndSum [по] $ticket $myWish

            q!: * {[$how/$comWhere] * $findInf * $win * $myWish} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $myWish} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $myWish} *
            q!: * {$winPastPerf * $or * проиграл* * $myWish} *
            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $myWish} *
            q!: * {($findOutInf есть [$li]) * $win * $myWish} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $myWish} *

            q!: {~какой [$comMy] $win $myWish}
            q!: {$howMuch $prizeAndSum [в] $myWish}
            q!: * {~какой у $me $win} * $myWish *
            q!: * $myWish * {~какой у $me $win} *
            q!: * {~какой ((у/по) $ticket) $win} * $myWish *
            q!: * $myWish * {~какой ((у/по) $ticket) $win} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $myWish} *
            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $myWish} *
            q!: * {($howMuch (составил/составляет) $win) * $myWish} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $myWish} *
            q!: * {($comWhat [я] $winPastPerf) * $myWish} *
            q!: * {($findOutInf/$checkInf) * $result * $myWish} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $myWish} *

            if: checkIfCurrentDateIsBefore("2021-01-01 18:00")
                a: Результаты розыгрыша «Мое желание» смотрите 1 января 2021 года в 15:30 на НТВ в прямом эфире, а также на сайте www.stoloto.ru 01.01.2021 публикуются новости о результатах розыгрышей с указанием данных о победителях.
            else:
                # Результаты Вы можете посмотреть на сайте по ссылке
                a: Результаты Вы можете посмотреть на сайте по ссылке https://www.stoloto.ru/press/news/2021/01/01/itogi-akcii-moyo-zhelanie


        state: GoldenShoe
            q: * $goldenShoe *

            q!: [$helloAll] $prizeAndSum [по] $ticket $goldenShoe
            q!: {~какой [$comMy] $win $goldenShoe}
            q!: {$howMuch $prizeAndSum ([в] $goldenShoe)}

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * $goldenShoe *

            q!: * {[$how/$comWhere] * $checkTicket * $goldenShoe} *
            q!: * {[$how/$comWhere] * $checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $goldenShoe} *

            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $goldenShoe} *

            q!: * {($findOutInf/$findOutImp) * $win * $goldenShoe} *
            q!: * {[$how/$comWhere] * $findInf * $win * $goldenShoe} *

            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $goldenShoe} *

            q!: * {$how * сыграл* * $ticket * $goldenShoe} *
            q!: * {$ticket * $comWhat * $winPastPerf * $goldenShoe} *

            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $goldenShoe} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $goldenShoe} *
            q!: * {$winPastPerf * $or * проиграл* * $goldenShoe} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $goldenShoe} *
            q!: * {($findOutInf есть [$li]) * $win * $goldenShoe} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $goldenShoe} *

            q!: * {~какой (у $me) $win} * $goldenShoe *
            q!: * $goldenShoe * {~какой (у $me) $win} *

            q!: * {~какой ((у/по) $ticket) $win} * $goldenShoe *
            q!: * $goldenShoe * {~какой ((у/по) $ticket) $win} *

            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $goldenShoe} *
            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $goldenShoe} *
            q!: * {($howMuch (составил/составляет) $win) * $goldenShoe} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $goldenShoe} *
            q!: * {($comWhat [я] $winPastPerf) * $goldenShoe} *
            q!: * {($findOutInf/$checkInf) * $result * $goldenShoe} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $goldenShoe} *
            q!: * {(какие числа выпали) * $goldenShoe} *

            # для новогоднего тиража Золотой подковы

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * {$newYear * $goldenShoe} *

            q!: * {(какой $prize составил * $newYear * $ticket) * $goldenShoe} *

            q!: * [$how/$comWhere] * {$checkTicket * $goldenShoe * $newYear} * [$how/$comWhere] *

            q!: * $goldenShoe * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $newYear} *
            q!: * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $newYear} * $goldenShoe *
            q!: * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $goldenShoe} * $newYear *

            q!: * $goldenShoe * {($checkTicket/$checkInf/$findOutInf/$findOutImp/$findInf) * $win * $newYear} *
            q!: * {($checkTicket/$checkInf/$findOutInf/$findOutImp/$findInf) * $win * $newYear} * $goldenShoe *


            q!: * $goldenShoe * {~проверка * ($ticketAndLottery/$ticketRun) * $newYear} *
            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $newYear} * $goldenShoe *

            q!: * $goldenShoe * {сыграл* * $ticket * $newYear} *
            q!: * {сыграл* * $ticket * $newYear} * $goldenShoe *

            q!: * $goldenShoe * {$comWhat * $winPastPerf * ($newYear [$ticket])} *
            q!: * {$comWhat * $winPastPerf * ($newYear [$ticket])} * $goldenShoe *

            q!: * $goldenShoe * {$winPastPerf * ($or ($comNo/$comWhat)) * $newYear} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $newYear} * $goldenShoe *

            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $goldenShoe * $newYear} *

            q!: * {($winPastPerf * $or * проиграл*/проиграл* * $or * $winPastPerf) * $goldenShoe * $newYear} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $goldenShoe * $newYear} *
            q!: * {(($findOutInf есть [$li]) * $win) * $goldenShoe * $newYear} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $goldenShoe * $newYear} *

            q!: * {~какой ((у/по) $ticket) $win} * $newYear * $goldenShoe *
            q!: * $newYear * $goldenShoe * {~какой ((у/по) $ticket) $win} *
            q!: * $goldenShoe * {~какой ((у/по) $newYear $ticket) $win} *
            q!: * {~какой ((у/по) $newYear $ticket) $win} * $goldenShoe *

            q!: * $goldenShoe * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $newYear} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $newYear} * $goldenShoe *

            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $goldenShoe * $newYear} *
            q!: * {($howMuch (составил/составляет) $win) * $goldenShoe * $newYear} *

            q!: * $goldenShoe * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $newYear} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $newYear} * $goldenShoe *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $newYear $prizeAndSum) * $goldenShoe} *

            q!: * {($comWhat [я] $winPastPerf) * $goldenShoe * $newYear} *

            q!: * $goldenShoe * {($findOutInf/$checkInf) * $result * $newYear} *
            q!: * {($findOutInf/$checkInf) * $result * $newYear} * $goldenShoe *

            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $goldenShoe * $newYear} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] $newYear ($ticket/$ticketRun/$lottery))) * $goldenShoe} *

            q!: * {($tellImp [мне] [$please] ~сумма $prize ([по] $newYear $ticket)) * $goldenShoe} *

            q!: * {(узнать $balance $comMy $newYear $ticket) * $goldenShoe} *
            q!: * {(какие числа выпали) * $goldenShoe * $newYear} *

            if: $parseTree._newYear || $session.newYear
                if: checkIfCurrentDateIsBefore("2021-01-01 10:30")
                    # если 1 января до 10:30
                    a: Результаты новогоднего тиража лотереи «Золотая подкова» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                    script:
                        $session.newYear = false;
                else:
                    go!: ../Other
            else:
                if: Time.isSpecialEvent(10, 30)
                    # если 1 января до 10:30
                    a: Результаты новогоднего тиража лотереи «Золотая подкова» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        go!: ../Other

        state: Bingo75
            q: * $bingo *

            q!: [$helloAll] $prizeAndSum [по] $ticket $bingo
            q!: {~какой [$comMy] $win $bingo}
            q!: {$howMuch $prizeAndSum ([в] $bingo)}

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * $bingo *

            q!: * {[$how/$comWhere] * $checkTicket * $bingo} *
            q!: * {[$how/$comWhere] * $checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $bingo} *

            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $bingo} *

            q!: * {($findOutInf/$findOutImp) * $win * $bingo} *
            q!: * {[$how/$comWhere] * $findInf * $win * $bingo} *

            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $bingo} *

            q!: * {$how * сыграл* * $ticket * $bingo} *
            q!: * {$ticket * $comWhat * $winPastPerf * $bingo} *

            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $bingo} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $bingo} *
            q!: * {$winPastPerf * $or * проиграл* * $bingo} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $bingo} *
            q!: * {($findOutInf есть [$li]) * $win * $bingo} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $bingo} *

            q!: * {~какой (у $me) $win} * $bingo *
            q!: * $bingo * {~какой (у $me) $win} *

            q!: * {~какой ((у/по) $ticket) $win} * $bingo *
            q!: * $bingo * {~какой ((у/по) $ticket) $win} *

            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $bingo} *
            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $bingo} *
            q!: * {($howMuch (составил/составляет) $win) * $bingo} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $bingo} *
            q!: * {($comWhat [я] $winPastPerf) * $bingo} *
            q!: * {($findOutInf/$checkInf) * $result * $bingo} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $bingo} *
            q!: * {(какие числа выпали) * $bingo} *

            # для новогоднего тиража Бинго-75

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * {$newYear * $bingo} *

            q!: * {(какой $prize составил * $newYear * $ticket) * $bingo} *

            q!: * [$how/$comWhere] * {$checkTicket * $bingo * $newYear} * [$how/$comWhere] *

            q!: * $bingo * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $newYear} *
            q!: * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $newYear} * $bingo *
            q!: * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $bingo} * $newYear *

            q!: * $bingo * {($checkTicket/$checkInf/$findOutInf/$findOutImp/$findInf) * $win * $newYear} *
            q!: * {($checkTicket/$checkInf/$findOutInf/$findOutImp/$findInf) * $win * $newYear} * $bingo *


            q!: * $bingo * {~проверка * ($ticketAndLottery/$ticketRun) * $newYear} *
            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $newYear} * $bingo *

            q!: * $bingo * {сыграл* * $ticket * $newYear} *
            q!: * {сыграл* * $ticket * $newYear} * $bingo *

            q!: * $bingo * {$comWhat * $winPastPerf * ($newYear [$ticket])} *
            q!: * {$comWhat * $winPastPerf * ($newYear [$ticket])} * $bingo *

            q!: * $bingo * {$winPastPerf * ($or ($comNo/$comWhat)) * $newYear} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $newYear} * $bingo *

            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $bingo * $newYear} *

            q!: * {($winPastPerf * $or * проиграл*/проиграл* * $or * $winPastPerf) * $bingo * $newYear} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $bingo * $newYear} *
            q!: * {(($findOutInf есть [$li]) * $win) * $bingo * $newYear} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $bingo * $newYear} *

            q!: * {~какой ((у/по) $ticket) $win} * $newYear * $bingo *
            q!: * $newYear * $bingo * {~какой ((у/по) $ticket) $win} *
            q!: * $bingo * {~какой ((у/по) $newYear $ticket) $win} *
            q!: * {~какой ((у/по) $newYear $ticket) $win} * $bingo *

            q!: * $bingo * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $newYear} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $newYear} * $bingo *

            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $bingo * $newYear} *
            q!: * {($howMuch (составил/составляет) $win) * $bingo * $newYear} *

            q!: * $bingo * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $newYear} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $newYear} * $bingo *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $newYear $prizeAndSum) * $bingo} *

            q!: * {($comWhat [я] $winPastPerf) * $bingo * $newYear} *

            q!: * $bingo * {($findOutInf/$checkInf) * $result * $newYear} *
            q!: * {($findOutInf/$checkInf) * $result * $newYear} * $bingo *

            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $bingo * $newYear} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] $newYear ($ticket/$ticketRun/$lottery))) * $bingo} *

            q!: * {($tellImp [мне] [$please] ~сумма $prize ([по] $newYear $ticket)) * $bingo} *

            q!: * {(узнать $balance $comMy $newYear $ticket) * $bingo} *
            q!: * {(какие числа выпали) * $bingo * $newYear} *
            if: $parseTree._newYear || $session.newYear
                if: checkIfCurrentDateIsBefore("2021-01-01 10:30")
                    # если 1 января до 10:30
                    a: Результаты новогоднего тиража лотереи «Бинго-75» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                    script:
                        $session.newYear = false;
                else:
                    go!: ../Other
            else:
                if: Time.isSpecialEvent(10, 30)
                    # если 1 января до 10:30
                    a: Результаты новогоднего тиража лотереи «Бинго-75» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        go!: ../Other

        state: 6of36
            q: * $6of36 *

            q!: [$helloAll] $prizeAndSum [по] $ticket $6of36
            q!: {~какой [$comMy] $win $6of36}
            q!: {$howMuch $prizeAndSum ([в] $6of36)}

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * $6of36 *

            q!: * {[$how/$comWhere] * $checkTicket * $6of36} *
            q!: * {[$how/$comWhere] * $checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $6of36} *

            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $6of36} *

            q!: * {($findOutInf/$findOutImp) * $win * $6of36} *
            q!: * {[$how/$comWhere] * $findInf * $win * $6of36} *

            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $6of36} *

            q!: * {$how * сыграл* * $ticket * $6of36} *
            q!: * {$ticket * $comWhat * $winPastPerf * $6of36} *

            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $6of36} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $6of36} *
            q!: * {$winPastPerf * $or * проиграл* * $6of36} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $6of36} *
            q!: * {($findOutInf есть [$li]) * $win * $6of36} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $6of36} *

            q!: * {~какой (у $me) $win} * $6of36 *
            q!: * $6of36 * {~какой (у $me) $win} *

            q!: * {~какой ((у/по) $ticket) $win} * $6of36 *
            q!: * $6of36 * {~какой ((у/по) $ticket) $win} *

            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $6of36} *
            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $6of36} *
            q!: * {($howMuch (составил/составляет) $win) * $6of36} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $6of36} *
            q!: * {($comWhat [я] $winPastPerf) * $6of36} *
            q!: * {($findOutInf/$checkInf) * $result * $6of36} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $6of36} *
            q!: * {(какие числа выпали) * $6of36} *

            # для новогоднего тиража 6 из 36

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * {$newYear * $6of36} *

            q!: * {(какой $prize составил * $newYear * $ticket) * $6of36} *

            q!: * [$how/$comWhere] * {$checkTicket * $6of36 * $newYear} * [$how/$comWhere] *

            q!: * $6of36 * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $newYear} *
            q!: * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $newYear} * $6of36 *
            q!: * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $6of36} * $newYear *

            q!: * $6of36 * {($checkTicket/$checkInf/$findOutInf/$findOutImp/$findInf) * $win * $newYear} *
            q!: * {($checkTicket/$checkInf/$findOutInf/$findOutImp/$findInf) * $win * $newYear} * $6of36 *


            q!: * $6of36 * {~проверка * ($ticketAndLottery/$ticketRun) * $newYear} *
            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $newYear} * $6of36 *

            q!: * $6of36 * {сыграл* * $ticket * $newYear} *
            q!: * {сыграл* * $ticket * $newYear} * $6of36 *

            q!: * $6of36 * {$comWhat * $winPastPerf * ($newYear [$ticket])} *
            q!: * {$comWhat * $winPastPerf * ($newYear [$ticket])} * $6of36 *

            q!: * $6of36 * {$winPastPerf * ($or ($comNo/$comWhat)) * $newYear} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $newYear} * $6of36 *

            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $6of36 * $newYear} *

            q!: * {($winPastPerf * $or * проиграл*/проиграл* * $or * $winPastPerf) * $6of36 * $newYear} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $6of36 * $newYear} *
            q!: * {(($findOutInf есть [$li]) * $win) * $6of36 * $newYear} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $6of36 * $newYear} *

            q!: * {~какой ((у/по) $ticket) $win} * $newYear * $6of36 *
            q!: * $newYear * $6of36 * {~какой ((у/по) $ticket) $win} *
            q!: * $6of36 * {~какой ((у/по) $newYear $ticket) $win} *
            q!: * {~какой ((у/по) $newYear $ticket) $win} * $6of36 *

            q!: * $6of36 * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $newYear} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $newYear} * $6of36 *

            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $6of36 * $newYear} *
            q!: * {($howMuch (составил/составляет) $win) * $6of36 * $newYear} *

            q!: * $6of36 * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $newYear} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $newYear} * $6of36 *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $newYear $prizeAndSum) * $6of36} *

            q!: * {($comWhat [я] $winPastPerf) * $6of36 * $newYear} *

            q!: * $6of36 * {($findOutInf/$checkInf) * $result * $newYear} *
            q!: * {($findOutInf/$checkInf) * $result * $newYear} * $6of36 *

            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $6of36 * $newYear} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] $newYear ($ticket/$ticketRun/$lottery))) * $6of36} *

            q!: * {($tellImp [мне] [$please] ~сумма $prize ([по] $newYear $ticket)) * $6of36} *

            q!: * {(узнать $balance $comMy $newYear $ticket) * $6of36} *
            q!: * {(какие числа выпали) * $6of36 * $newYear} *

            if: $parseTree._newYear || $session.newYear
                if: checkIfCurrentDateIsBefore("2021-01-01 10:30")
                    # до 10:30 1 января
                    a: Результаты новогоднего тиража лотереи «6 из 36» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                    script:
                        $session.newYear = false;
                else:
                    go!: ../Other
            else:
                if: Time.isSpecialEvent(10, 30)
                    # если 1 января до 10:30
                    a: Результаты новогоднего тиража лотереи «6 из 36» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        go!: ../Other


        state: HousingLottery
            q: * $housingLottery *

            q!: [$helloAll] $prizeAndSum [по] $ticket $housingLottery
            q!: {~какой [$comMy] $win $housingLottery}
            q!: {$howMuch $prizeAndSum ([в] $housingLottery)}

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * $housingLottery *

            q!: * {[$how/$comWhere] * $checkTicket * $housingLottery} *
            q!: * {[$how/$comWhere] * $checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $housingLottery} *

            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $housingLottery} *

            q!: * {($findOutInf/$findOutImp) * $win * $housingLottery} *
            q!: * {[$how/$comWhere] * $findInf * $win * $housingLottery} *

            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $housingLottery} *

            q!: * {$how * сыграл* * $ticket * $housingLottery} *
            q!: * {$ticket * $comWhat * $winPastPerf * $housingLottery} *

            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $housingLottery} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $housingLottery} *
            q!: * {$winPastPerf * $or * проиграл* * $housingLottery} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $housingLottery} *
            q!: * {($findOutInf есть [$li]) * $win * $housingLottery} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $housingLottery} *

            q!: * {~какой (у $me) $win} * $housingLottery *
            q!: * $housingLottery * {~какой (у $me) $win} *

            q!: * {~какой ((у/по) $ticket) $win} * $housingLottery *
            q!: * $housingLottery * {~какой ((у/по) $ticket) $win} *

            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $housingLottery} *
            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $housingLottery} *
            q!: * {($howMuch (составил/составляет) $win) * $housingLottery} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $housingLottery} *
            q!: * {($comWhat [я] $winPastPerf) * $housingLottery} *
            q!: * {($findOutInf/$checkInf) * $result * $housingLottery} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $housingLottery} *
            q!: * {(какие числа выпали) * $housingLottery} *

            # для новогоднего тиража Жилищной лотереи

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * {$newYear * $housingLottery} *

            q!: * {(какой $prize составил * $newYear * $ticket) * $housingLottery} *

            q!: * [$how/$comWhere] * {$checkTicket * $housingLottery * $newYear} * [$how/$comWhere] *

            q!: * $housingLottery * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $newYear} *
            q!: * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $newYear} * $housingLottery *
            q!: * {$checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $housingLottery} * $newYear *

            q!: * $housingLottery * {($checkTicket/$checkInf/$findOutInf/$findOutImp/$findInf) * $win * $newYear} *
            q!: * {($checkTicket/$checkInf/$findOutInf/$findOutImp/$findInf) * $win * $newYear} * $housingLottery *


            q!: * $housingLottery * {~проверка * ($ticketAndLottery/$ticketRun) * $newYear} *
            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $newYear} * $housingLottery *

            q!: * $housingLottery * {сыграл* * $ticket * $newYear} *
            q!: * {сыграл* * $ticket * $newYear} * $housingLottery *

            q!: * $housingLottery * {$comWhat * $winPastPerf * ($newYear [$ticket])} *
            q!: * {$comWhat * $winPastPerf * ($newYear [$ticket])} * $housingLottery *

            q!: * $housingLottery * {$winPastPerf * ($or ($comNo/$comWhat)) * $newYear} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $newYear} * $housingLottery *

            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $housingLottery * $newYear} *

            q!: * {($winPastPerf * $or * проиграл*/проиграл* * $or * $winPastPerf) * $housingLottery * $newYear} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $housingLottery * $newYear} *
            q!: * {(($findOutInf есть [$li]) * $win) * $housingLottery * $newYear} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $housingLottery * $newYear} *

            q!: * {~какой ((у/по) $ticket) $win} * $newYear * $housingLottery *
            q!: * $newYear * $housingLottery * {~какой ((у/по) $ticket) $win} *
            q!: * $housingLottery * {~какой ((у/по) $newYear $ticket) $win} *
            q!: * {~какой ((у/по) $newYear $ticket) $win} * $housingLottery *

            q!: * $housingLottery * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $newYear} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $newYear} * $housingLottery *

            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $housingLottery * $newYear} *
            q!: * {($howMuch (составил/составляет) $win) * $housingLottery * $newYear} *

            q!: * $housingLottery * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $newYear} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $newYear} * $housingLottery *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $newYear $prizeAndSum) * $housingLottery} *

            q!: * {($comWhat [я] $winPastPerf) * $housingLottery * $newYear} *

            q!: * $housingLottery * {($findOutInf/$checkInf) * $result * $newYear} *
            q!: * {($findOutInf/$checkInf) * $result * $newYear} * $housingLottery *

            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $housingLottery * $newYear} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] $newYear ($ticket/$ticketRun/$lottery))) * $housingLottery} *

            q!: * {($tellImp [мне] [$please] ~сумма $prize ([по] $newYear $ticket)) * $housingLottery} *

            q!: * {(узнать $balance $comMy $newYear $ticket) * $housingLottery} *
            q!: * {(какие числа выпали) * $housingLottery * $newYear} *

            if: $parseTree._newYear || $session.newYear
                if: checkIfCurrentDateIsBefore("2021-01-01 10:30")
                    # до 10.30 1 января
                    a: Результаты новогоднего тиража «Жилищной лотереи» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                    script:
                        $session.newYear = false;
                else:
                    go!: ../Other
            else:
                if: Time.isSpecialEvent(10, 30)
                    # если 1 января до 10:30
                    a: Результаты новогоднего тиража «Жилищной лотереи» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        go!: ../Other



        state: OtherNamedLottery
            q: * $otherNamedLottery *

            q!: [$helloAll] $prizeAndSum [по] $ticket $otherNamedLottery
            q!: {~какой [$comMy] $win $otherNamedLottery}
            q!: {$howMuch $prizeAndSum ([в] $otherNamedLottery)}

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * $otherNamedLottery *

            q!: * {[$how/$comWhere] * $checkTicket * $otherNamedLottery} *
            q!: * {[$how/$comWhere] * $checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $otherNamedLottery} *

            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $otherNamedLottery} *

            q!: * {($findOutInf/$findOutImp) * $win * $otherNamedLottery} *
            q!: * {[$how/$comWhere] * $findInf * $win * $otherNamedLottery} *

            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $otherNamedLottery} *

            q!: * {$how * сыграл* * $ticket * $otherNamedLottery} *
            q!: * {$ticket * $comWhat * $winPastPerf * $otherNamedLottery} *

            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $otherNamedLottery} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $otherNamedLottery} *
            q!: * {$winPastPerf * $or * проиграл* * $otherNamedLottery} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $otherNamedLottery} *
            q!: * {($findOutInf есть [$li]) * $win * $otherNamedLottery} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $otherNamedLottery} *

            q!: * {~какой (у $me) $win} * $otherNamedLottery *
            q!: * $otherNamedLottery * {~какой (у $me) $win} *

            q!: * {~какой ((у/по) $ticket) $win} * $otherNamedLottery *
            q!: * $otherNamedLottery * {~какой ((у/по) $ticket) $win} *

            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $otherNamedLottery} *
            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $otherNamedLottery} *
            q!: * {($howMuch (составил/составляет) $win) * $otherNamedLottery} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $otherNamedLottery} *
            q!: * {($comWhat [я] $winPastPerf) * $otherNamedLottery} *
            q!: * {($findOutInf/$checkInf) * $result * $otherNamedLottery} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $otherNamedLottery} *
            q!: * {(какие числа выпали) * $otherNamedLottery} *
            if: $parseTree._matchball
                script: Webim.switch();

            else:
                a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».

        state: Other
            q: * $multiTicketRun *
            q: ($stoloto/спортлото/[спорт] лото)

            q!: [$helloAll] $prizeAndSum [по] $ticket $multiTicketRun
            q!: {~какой [$comMy] $win $multiTicketRun}
            q!: {$howMuch $prizeAndSum ([в] $multiTicketRun)}

            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prize * $multiTicketRun *

            q!: * {[$how/$comWhere] * $checkTicket * $multiTicketRun} *
            q!: * {[$how/$comWhere] * $checkTicket * ($ticketAndLottery/розыгрыш*/$ticketRun) * $multiTicketRun} *

            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $multiTicketRun} *

            q!: * {($findOutInf/$findOutImp) * $win * $multiTicketRun} *
            q!: * {[$how/$comWhere] * $findInf * $win * $multiTicketRun} *

            q!: * {~проверка * ($ticketAndLottery/$ticketRun) * $multiTicketRun} *

            q!: * {$how * сыграл* * $ticket * $multiTicketRun} *
            q!: * {$ticket * $comWhat * $winPastPerf * $multiTicketRun} *

            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $multiTicketRun} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $multiTicketRun} *
            q!: * {$winPastPerf * $or * проиграл* * $multiTicketRun} *

            q!: * {(есть ли $prize/есть $prize $or $comNo/узнать $balance $comMy $ticket) * $multiTicketRun} *
            q!: * {($findOutInf есть [$li]) * $win * $multiTicketRun} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $multiTicketRun} *

            q!: * {~какой (у $me) $win} * $multiTicketRun *
            q!: * $multiTicketRun * {~какой (у $me) $win} *

            q!: * {~какой ((у/по) $ticket) $win} * $multiTicketRun *
            q!: * $multiTicketRun * {~какой ((у/по) $ticket) $win} *

            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeAndSum) * $multiTicketRun} *
            q!: * {($skolko [$moneyAndRub] [я] $winPastPerf) * $multiTicketRun} *
            q!: * {($howMuch (составил/составляет) $win) * $multiTicketRun} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeAndSum) * $multiTicketRun} *
            q!: * {($comWhat [я] $winPastPerf) * $multiTicketRun} *
            q!: * {($findOutInf/$checkInf) * $result * $multiTicketRun} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $multiTicketRun} *
            q!: * {(какие числа выпали) * $multiTicketRun} *

            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».


        state: CheckButtonIsNotActive
            # Кнопка Проверить не активна
            q!: * {$button $checkTicket [$ticket] $activeNe} *
            q!: * ($indicatePresSg1/$indicatePast) ($ticketRun/$ticketRunNumber) и ($ticket/$ticketNumber) * {$button $activeNe} *
            q!: * ($indicatePresSg1/$indicatePast) ($ticket/$ticketNumber) и ($ticketRun/$ticketRunNumber) * {$button $activeNe} *
            q: * {$button $activeNe} *
            intent: /Ticket/CheckTicket/CheckButtonIsNotActive
            a: Сложность, о которой Вы пишете, может возникать на стороне Вашего браузера. Папки с копиями данных Вашего браузера (cache браузера) могут быть переполнены и подгружать старые страницы с информацией.\n\nОбновите, пожалуйста, страницу, с которой возникает сложность, круговой стрелкой или сочетанием кнопок ctrl+f5. Если все останется по-прежнему, то попробуйте почистить данные Вашего браузера или зайти и выполнить действие с другого браузера.\n\nИнструкция по очистке данных Вашего браузера находится по ссылке https://yandex.ru/support/common/browsers-settings/cache.html . Если ситуация повторится, то сообщите, пожалуйста, нам об этом.

        state: IDontRememberWhichLottery
            # Я не помню, какая лотерея
            q: * {[я] ($forgetPastPres/$knowNe/$lookPast3Ne) ((какая/какую/$comWhat за) $lottery)} *
            q: * ($forgetPastPres/$knowNe/$lookPast3Ne) (какую/что) $buyPastPres *
            q: * ($forgetPastPres/$knowNe/$lookPast3Ne) * в какой * $lottery *
            q: * {($forgetPastPres/$knowNe/$lookPast3Ne) * ($how [она] называет*)} *
            q: * {($forgetPastPres/$knowNe/$lookPast3Ne) * ~название} *
            q: * (вчерашн*/дешевая/сегодняшн*/сегоднящ*/утрен*) *
            q: * {$buyPastPres ((за/по) $numberRub)} *
            q: * {$ticket ((за/по) $numberRub)} *
            q: [за/по] $numberRub
            q: * {$buyPastPres * много} *
            q: * разные *
            intent: /Ticket/CheckTicket/IDontRememberWhichLottery
            go!: ../Other

        state: LocalCatchAll
            event: noMatch || fromState = /Ticket/CheckTicket
            script: Webim.switch();

        state: CatchLocalNoTicketRun || fromState = /Ticket/CheckTicket
            q: * $comNo * {$Number $ticketRun} *
            q: * $comNo * (этого/этому/этом/данного/данному/данном/~наш/~мой/~такой) $ticketRun *
            q: * $comWhere {$Number $ticketRun} *
            q: * (пишет/говорит/написано) $comNo $ticketRun *
            q: * {(в приложении) * $findPastPresNe * $ticketRun} *
            q: * ~архив $ticketRun *
            go!: /Lottery/WhereToFindResults

        state: ThereAreNoTicketRunNumberAndTicketNumber
            q: $comWhere * (его/это/он) *
            q: * это $comWhere *
            q: * серия $Number *
            q: * $ne ($number/$ticketNumber) $nothing *
            q: * $only ($number/$ticketNumber) и $code *
            q: * $comWhere (этот/эти) $number *
            q: * $comWhere эти $numeral *
            q: * {$forgetPastPres $number} *
            q: * $comNo этих данных *
            intent: /Ticket/CheckTicket/ThereAreNoTicketRunNumberAndTicketNumber
            go!: /Ticket/ThereAreNoTicketRunNumberAndTicketNumber

        state: CheckByQrCode
            q: * {[$generalNamedLottery] * ($by $qrCode)} *
            a: Отсканировать QR-код на билете Вы можете с помощью специальной программы-распознавателя или официального приложения «Столото» для iOS или Android.

        state: Coupon
            # у меня купон
            q: * ~купон *
            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».\n\nНомер тиража и номер билета Вы можете посмотреть на черно-белой квитанции, которую Вам выдали при покупке билета. Номер тиража указан в верхней части квитанции после слов «Билет действителен для 1 тиража (ей)». Если у Вас не сохранилась квитанция, Вы можете зарегистрироваться с номером телефона, указанным при покупке купона, на сайте. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты», там же Вы найдете всю информацию о билете.


    state: CheckTicketByQrCode
        # Проверить билет по Qr коду
        q!: * {$checkTicket * [$prize] * ([$by] $qrCode)} *
        q!: * $checkTicket * [$ticket/розыгрыш*] * [$generalNamedLottery] * ($by $qrCode) * [$ticket] *
        q!: * [$cantPastPres] * $checkTicket * [$ticket/розыгрыш*] * [$generalNamedLottery] * ($by $qrCode) *
        q!: * $cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$ticket/розыгрыш*] * [$generalNamedLottery] * ($by $qrCode) *
        q!: * ($by $qrCode) * $cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$ticket/розыгрыш*] * [$generalNamedLottery] *

        q!: * {$findOutInf * $win * [$generalNamedLottery] * ($by $qrCode)} *
        q!: * [$cantPastPres] * $findOutInf * $win * [$generalNamedLottery] * ($by $qrCode) *
        q!: * ($by $qrCode) * [$cantPastPres] * $findOutInf * $win * [$generalNamedLottery] *
        # Как отсканировать билет
        q!: $scanInf
        q!: * {[$how] * $scanInf * $ticketAll} *
        q!: * {[$how] * $scanInf * $lottery} *
        q!: * {[$how] * $scanInf * $qrCode} *
        q!: * {[$how] * $scanInf * $code} *
        intent!: /Ticket/CheckTicketByQrCode
        a: Отсканировать QR-код на билете Вы можете с помощью специальной программы-распознавателя или официального приложения «Столото» для iOS или Android.


    state: HowToCheckCoupon
        # Как проверить купон
        q!: * [$generalNamedLottery] * какой $prize составил * ~купон * [$generalNamedLottery] *
        q!: * {$checkTicket * ~купон * [$win] * [$generalNamedLottery]} *
        q!: * {$checkTicket * ~купон * [$win] * [$generalNamedLottery]} *
        q!: * {$checkInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$checkInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$findOutInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$findOutInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$findInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$findInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$findOutImp * $win * ~купон * [$generalNamedLottery]} *
        q!: * {~проверка * ~купон * [$generalNamedLottery]} *
        q!: * {$how * сыграл* * ~купон * [$generalNamedLottery]} *
        q!: * {~купон * $comWhat * $winPastPerf * [$generalNamedLottery]} *
        q!: [$generalNamedLottery] {[~мой] ~купон $winPastPerf} [$generalNamedLottery]
        q!: [$helloAll] $prizeAndSum [по] ~купон [$generalNamedLottery]
        q!: * [$generalNamedLottery] * {выигрышн* ~купон} ($or ($comNo/$comWhat)) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {выйгрышн* ~купон} ($or ($comNo/$comWhat)) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $tellImp [мне] [$please] ~сумма $prize ([по] ~купон) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {~какой ((у/по) ~купон) $win} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $winPastPerf ($li) ~купон * [$generalNamedLottery] *

        q!: * {$cantPastPres * проверять * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * проверить * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * проверит * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * проверет * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * пробить * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * пробить * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * $checkInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * понять * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$checkTicketPresNe * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * $findOutInf * $win * ~купон * [$generalNamedLottery]} *

        q!: * {$cantPastPres * ~проверка * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * $how * сыграл* * ~купон * [$generalNamedLottery]} *
        q!: * никак ($ne (проверю/проверить/про верить)/непроверю/непроверить/нипроверю/нипроверить) ~купон * [$generalNamedLottery] *
        q!: * никак ~купон * [$generalNamedLottery] ($ne (проверю/проверить/про верить)/непроверю/непроверить/нипроверю/нипроверить) *
        q!: * {$cantPastPres * $findInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * [$generalNamedLottery] * {~какой ((у/по) ~купон) $win} * $cantPastPres * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $cantPastPres * {~какой ((у/по) ~купон) $win} * [$generalNamedLottery] *
        q!: * {$cantPastPres * ($winPastPerf ($li) ~купон) * [$generalNamedLottery]} *

        intent!: /Ticket/HowToCheckCoupon
        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».\n\nНомер тиража и номер билета Вы можете посмотреть на черно-белой квитанции, которую Вам выдали при покупке билета. Номер тиража указан в верхней части квитанции после слов «Билет действителен для 1 тиража (ей)». Если у Вас не сохранилась квитанция, Вы можете зарегистрироваться с номером телефона, указанным при покупке купона, на сайте. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты», там же Вы найдете всю информацию о билете.


    state: ICantEnterTheCirculationNumber
        # Не могу ввести номер тиража
        q!: * $ticketRun * (3/три) ($numeral/числ*) * у моего * $ticketRun (4/четыре) ($numeral/числ*) *
        q!: * $inputPresSg3Ne * ($ticketRunNumber/$ticketRun) *
        q!: * ($ticketRunNumber/$ticketRun) * $inputPresSg3Ne *
        q!: * $ne (полностью/целиком) (вводит*/в водит*) * ($ticketRunNumber/$ticketRun) *
        q!: * ($ticketRunNumber/$ticketRun) * $ne (полностью/целиком) (вводит*/в водит*) *
        q!: * ($ticketRunNumber/$ticketRun) * (вводит*/в водит*) * $ne (полностью/целиком) *
        q!: * ($ticketRunNumber/$ticketRun) * (вводит*/в водит*/$inputInf/вводятс*/вводятьс*) * $only *
        q!: * {$cantPastPresAll * $inputInf * $ticketRunNumber} *
        q!: * {$cantPastPresAll * $inputInf * $ticketRun} *
        q!: * {$cantPastPresAll * (вписать/написать/указать) * $ticketRunNumber} *
        q!: * {$cantPastPresAll * (вписать/написать/указать) * $ticketRun} *
        q!: * {($ne (вписывает*/вбивает*)/невписывает*/нивписывает*/невбивает*/нивбивает*) * ($ticketRunNumber/$ticketRun)} *
        q!: * {($ne (ставитс*/ставитьс*)/неставитс*/ниставитс*/неставитьс*/ниставитьс*) * (трехзн* ($ticketRunNumber/$ticketRun))} *

        q!: * $ticketRun * в поле * $only (3/три/4/четыре) *
        q!: * дает ввести только (3/три)
        q!: * $insertInf полный $ticketRunNumber *
        q!: * (что-то/чтото) $ne так * $indicatePresSg1 * $ticketRun *
        q!: * {$ticketRunNumber ($ne высвеч*/невысвеч*/нивысвеч*)} *

        q!: * $comNo такого $ticketRun *
        q!: * ($ne находит/ненаходит/нинаходит) $ticketRun *
        q!: * $ticketRun ($ne находит/ненаходит/нинаходит) *
        q!: * ($ne найден/ненайден/нинайден) $ticketRun *
        q!: * $ticketRun ($ne найден/ненайден/нинайден) *
        intent!: /Ticket/ICantEnterTheCirculationNumber
        script: Webim.switch();


    state: TypesOfTickets
        q: * $didntGivePhone * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale
        q: * ($ne требовал*/нетребовал*/нитребовал*) * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale


        q: * $didntGivePhone * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * ($ne требовал*/нетребовал*/нитребовал*) * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * {$givePastPresPl3Ne * $receipt} * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * {$givePastNe * $receipt} * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale


        q: * $didntGivePhone * || fromState = /Ticket/NoRegistrationTicket
        q: * ($ne требовал*/нетребовал*/нитребовал*) * || fromState = /Ticket/NoRegistrationTicket


        q: * $didntGivePhone * || fromState = /Ticket/IBoughtATicketInPyaterochkaWhatIsNext

        a: Существует два вида билетов, которые Вы можете приобрести в точках распространения: с указанием номера мобильного телефона (электронные билеты) и без (типографские билеты, на лицевой стороне которых указана вся информация по билету). Ознакомиться с образцами билетов Вы можете на сайте, пройдя по ссылке http://www.stoloto.ru/ruslotto/rules . Если у Вас остались вопросы, пожалуйста, напишите нам.


    state: TypesOfTicketsFull
        # Нужно ли предъявлять чек при получении выигрыша?
        q!: * {$presentInf * $receipt * $prizeAll} *
        q!: * {$presentInf * $receipt * $cashoutInf} *
        q!: * {$presentInf * $receipt * $winFutSg13} *
        q!: * {$presentInf * $receipt * $winFutSg2} *
        q!: * {$presentInf * $receipt * $winFutSg2} *
        q!: * {($comNeed [$li] $receipt) * $prizeAll} *
        q!: * {($comNeed [$li] $receipt) * $cashoutInf} *
        q!: * {($comNeed [$li] $receipt) * $winFutSg13} *
        q!: * {($comNeed [$li] $receipt) * $winFutSg2} *
        q!: * {($comNeed [$li] $receipt) * $winFutSg2} *
        q!: * ($comNeed $li $receipt) * $paperTicketAll *
        q!: * ~получение $prizeAndSum * {$presentInf [$only] [сам] $ticket} *
        q!: * (получить/забрать/отдали/выдали) $prizeAndSum * {$presentInf [$only] [сам] $ticket} *
        q!: * ~получение $prizeAndSum * кроме [самого] $ticket *
        q!: * (получить/забрать/отдали/выдали) $prizeAndSum * кроме [самого] $ticket *
        q!: * ~разница * {бумажн* * электрон*} * ~получение $prizeAndSum *
        q!: * Настоящий купон предназначен только для регистрации *
        q!: * $isWritten * не является лотерейным билетом *

        # купил билет на почте, а номер телефона не спросили
        q!: * ($boughtTicket/$boughtTicketIn5) * $didntGivePhone *


        q: * это купон * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * сказали * $registerInf * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * $paid * $retailPointOfSale * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * {$buyPastPres * $retailPointOfSale} * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * (предназнач*/нужен) * для $registration * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * у меня без $phoneAndNum * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * $didntGivePhone * || fromState = /Ticket/IsItNecessaryToRegisterTicket

        a: Существует два вида билетов: типографские и электронные.\n\nТипографские билеты, на лицевой стороне которых уже указан номер тиража. При покупке билета не указывается номер телефона. Основанием для получения выигрыша является сам билет.\n\nЭлектронные билеты, при покупке которых указывается номер телефона. При продаже оператор розничной точки, после уточнения номера телефона покупателя, регистрирует билет через специальный терминал и выдает черно-белую квитанцию, которая содержит всю информацию по билету, в том числе уникальный ключ и номер тиража. Основанием для получения выигрыша является уникальный ключ и код выигрыша (который поступает в смс на номер телефона, указанный при регистрации билета).\n\nОзнакомиться с образцами билетов Вы можете на сайте, пройдя по ссылке http://www.stoloto.ru/ruslotto/rules


    state: IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        # Пришло смс с выигрышем, проверяю, пишет, что билет без выигрыша
        q!: * $smsWithWinCodeCame * $ticketDidntWin *
        q!: * $ticketDidntWin * $smsWithWinCodeCame *

        q!: * $winTicket * $ticketDidntWin *

        # я выиграл, выдает без выигрыша
        q!: * я $winPastPerf * $ticketDidntWin *

        # Пришло уведомление о выигрыше, выигрыш не отображается
        q!: * $smsWithWinCodeCame * ($prizeAndSum * $displayPres3Ne/$displayPres3Ne * $prizeAndSum) *

        q!: * ($sms/$notification/~поздравление/$letter) $about $prize * на сайте инф* (о нем/по нему) [никак*] $comNo *

        # не выиграл, а пришла смс
        q!: * $winPastPerfNe ($but/а) $smsCame *

        intent!: /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        a: Уточните, пожалуйста, уникальный ключ квитанции. Уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр.

        state: GetNumber || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
            q: * {[$uniqueKey] * $receiptKey} *
            script: Webim.switch();


    state: HowToExchangeAWinningTicketForANewOne
        # Как выигрышный билет обменять на новый?
        q!: * использовать $prize повторно *
        q!: * $playInf (снова/вновь/опять/заново/дальше) на $prizeAndSumAndWinTicket *
        q!: * {$payInf выигрышем} *
        q!: * {((на/за) [эт*] $prizeAndSumAndWinTicket) * $buyInf * [$possiblePredicAll]} *
        q!: * {($with [эт*] выигрыша) * $buyInf} *
        q!: * {($win $ticketAndLotteryAll) * $exchangeInf} * на ($new/следующ*/$ticketAndLotteryAll) *
        q!: * {($ticketAndLotteryAll [кот*] $win) * $exchangeInf} * на ($new/следующ*/$ticketAndLotteryAll) *
        q!: * {$winTicket * $exchangeInf} * на ($new/следующ*/$ticketAndLotteryAll) *
        q!: * $exchangeInf * $ticketAndLotteryAll на ($new/следующ*) * $win *
        q!: * $winPastPerf * {$exchangeInf * (на [$new/следующ*] $ticketAll)} *
        q!: * $winPastPerf * {$exchangeInf * (на [$new/следующ*] $ticketRun)} *
        q!: * $winPastPerf * {$exchangeInf * (на [$new/следующ*] $lottery)} *

        q!: * ($winPastPerf/$prizeAndSum) * (ей/ими/им/этой суммой) $payInf ([за] [$new/следующ*] ($ticketAll/$ticketRun/$lottery)) *
        q!: * ($winPastPerf/$prizeAndSum) * $payInf (ей/ими/им/этой суммой) ([за] [$new/следующ*] ($ticketAll/$ticketRun/$lottery)) *
        q!: * ($winPastPerf/$prizeAndSum) * ([за] [$new/следующ*] ($ticketAll/$ticketRun/$lottery)) (ей/ими/им/этой суммой) $payInf *
        q!: * ($winPastPerf/$prizeAndSum) * ([за] [$new/следующ*] ($ticketAll/$ticketRun/$lottery)) $payInf (ей/ими/им/этой суммой) *
        q!: * ($winPastPerf/$prizeAndSum) * $payInf ([за] [$new/следующ*] ($ticketAll/$ticketRun/$lottery)) (ей/ими/им/этой суммой) *
        q!: * ($winPastPerf/$prizeAndSum) * (ей/ими/им/этой суммой) ([за] [$new/следующ*] ($ticketAll/$ticketRun/$lottery)) $payInf *

        q!: * $prizeAll * {$payInf ($new/следующ*) ($ticketAll/$ticketRun/$lottery)} *
        q!: * $prizeAll * оплаты [на/за] ($new/следующ*) ($ticketAll/$ticketRun/$lottery) *

        q!: * $prizeAll * {$buyInf * ($ticketAll/$ticketRun/$lottery)} *
        q!: * {$prizeAll * $buyInf * (($new/следующ*) ($ticketAll/$ticketRun/$lottery))} *

        q!: * ($winPastPerf/$prizeAndSum) * $want [на] [них/нее/него/эту сумму] $buyInf [на] [них/нее/него/эту сумму] [$new/следующ*] ($ticketAll/$ticketRun/$lottery) [на] [них/нее/него/эту сумму] *
        q!: * ($winPastPerf/$prizeAndSum) * $want [на] [них/нее/него/эту сумму] [$new/следующ*] ($ticketAll/$ticketRun/$lottery) [$new/следующ*] [на] [них/нее/него/эту сумму] $buyInf *

        q!: * ($winPastPerf/$prizeAndSum) * на (них/нее/него/эту сумму) $buyInf [$new/следующ*] ($ticketAll/$ticketRun/$lottery) *
        q!: * ($winPastPerf/$prizeAndSum) * $buyInf на (них/нее/него/эту сумму) [$new/следующ*] ($ticketAll/$ticketRun/$lottery) *
        q!: * ($winPastPerf/$prizeAndSum) * $buyInf [$new/следующ*] ($ticketAll/$ticketRun/$lottery) [$new/следующ*] на (них/нее/него/эту сумму) *
        q!: * ($winPastPerf/$prizeAndSum) [состав*] ($comMoney/$numberRub/~сумма) * на (них/нее/него/эту сумму) [$new/следующ*] ($ticketAll/$ticketRun/$lottery) [$new/следующ*] $buyInf *
        q!: * ($winPastPerf/$prizeAndSum) [состав*] ($comMoney/$numberRub/~сумма) * ($ticketAll/$ticketRun/$lottery) [$new/следующ*] $buyInf [$new/следующ*] на (них/нее/него/эту сумму) *
        q!: * ($winPastPerf/$prizeAndSum) [состав*] ($comMoney/$numberRub/~сумма) * ($ticketAll/$ticketRun/$lottery) [$new/следующ*] на (них/нее/него/эту сумму) [$new/следующ*] $buyInf *





        q!: * {$exchangeInf * $prizeAndSumAndWinTicket} на [$new/следующ*] ($ticketAll/$ticketRun/$lottery) *
        q!: * {($buyInf [$new/следующ*/повторно/еще/еще один] ($ticketAll/$ticketRun/$lottery)) * (на [$sum] $prizeAndSumAndWinTicket)} *
        q!: * {$buyInf ([$new/следующ*/повторно/еще/еще один] ($ticketAll/$ticketRun/$lottery)) (на [$sum] $prizeAndSumAndWinTicket)} *
        q!: * {($buyInf [$new/следующ*/повторно] ($ticketAll/$ticketRun/$lottery)) * (у меня $prizeAndSum)} *

        q!: * $prizeAndSumAndWinTicket (на/для) [повторн*] $buyN ($new/следующ*) [$ticketAll/$ticketRun/$lottery] *

        q!: * {$prizeAndSumAndWinTicket * ($transferInfImp/$sendInf/$useInf/потратить) * ($buyN [$new/следующ*] ($ticketAll/$ticketRun/$lottery))} *

        q!: * $winPastPerf * {($useInf/потратить) * ($buyN [$new/следующ*] ($ticketAll/$ticketRun/$lottery))} *


        q!: * {$prizeAndSumAndWinTicket * потратить * (на ($new/следующ*) ($ticketAll/$ticketRun/$lottery))} *
        q!: * $winPastPerf * {потратить * (на ($new/следующ*) ($ticketAll/$ticketRun/$lottery))} *

        q!: * {$prizeAndSumAndWinTicket потратить (на $ticket)} *



        q!: * {$payInf ([$comMy] $prizeAndSumAndWinTicket) ([за] [$new/следующ*] ($ticketAll/$ticketRun/$lottery))} *
        q!: * у меня * $prizeAndSumAndWinTicket * {(им/ими) $payInf ([за] [$new] ($ticketAll/$ticketRun/$lottery))} *
        q!: * $payInf [$new/следующ*] [$ticketAll/$ticketRun/$lottery] ($comMoney/$numberRub/~сумма) ~который $winPastPerf *
        q!: * $buyInf [$new/следующ*/повторно/еще/еще один] ($ticketAll/$ticketRun/$lottery) * на ($comMoney/$numberRub/~сумма/$ticket) ~который $winPastPerf *
        q!: * ($ticketAll/$ticketRun/$lottery) [$new/следующ*/повторно/еще/еще один] $buyInf * на ($comMoney/$numberRub/~сумма/$ticket) ~который $winPastPerf *
        intent!: /Ticket/HowToExchangeAWinningTicketForANewOne

        a: Уточните, пожалуйста, где Вы приобретали билет?

        state: IBoughtInRetailPointOfSale
            q: * $retailPointOfSale *
            q: * на руках *
            q: * совкомбанк* *
            q: * $geography *
            q!: {($win $paperTicketAll) * $exchangeInf} * на $new *
            a: При покупке билета Вы указывали номер телефона?

            state: Yes
                q: * (указывал*/указал*) *
                q: * $comYes *
                a: Если Вы приобретали билет в розничных точках продаж с указанием номера телефона, Вы можете получить выигрыш в точке продаж и там же приобрести новый билет либо можно получить свой выигрыш в Кошелек Столото и приобрести новый билет на сайте.\n\nДля этого нужно зарегистрироваться на сайте с номером телефона, указанным Вами при покупке билета. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты». Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в личном кабинете, то напишите нам, пожалуйста.\n\nДля получения выигрыша в Кошелек Столото Вам необходимо зайти в Ваш личный кабинет, в раздел «Мои билеты». Выберите справа вкладку «Выигрышные». Затем необходимо нажать кнопку «Получить» с правой стороны (рядом с суммой Вашего выигрыша). Также Вы можете нажать на номер выигрышного билета и перейти на страницу квитанции. На странице счастливой квитанции нажмите кнопку «Перевести».\n\nМаксимальная сумма выигрыша к зачислению составляет 100 000 рублей для идентифицированных пользователей, 15 000 рублей для неидентифицированных​. Полная инструкция по получению выигрыша - по ссылке http://www.stoloto.ru/lottery/winning . Ознакомьтесь, пожалуйста.

            state: No
                q: * $indicatePastNe *
                q: * $comNo *
                q: * без [указани*] ($telephoneNumber/$telephone) *
                q: * ($ne требовал*/нетребовал*/нитребовал*) *
                a: Если Вы приобретали билеты в розничных точках продаж без указания номера телефона, то Ваш выигрыш Вы можете получить в той же точке продаж или в лотерейной сети «БалтЛото», на Почте России, в киоске. С адресами точек продаж и лимитами выплат ознакомьтесь, пожалуйста, по ссылке http://www.stoloto.ru/map . Там же Вы сможете приобрести новые билеты.

            state: LocalCatchAll
                event: noMatch
                script: Webim.switch();

        state: IBoughtOnWebsite
            q: * $here *
            q: * $online *
            q: * (на/через/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/~интернет/$application/~программа/комп/~компьютер/моб* ~версия) *
            q: * по (~интернет/телефону) *
            q: * (черезсайт/черезъсайт/черезьсайт/у вас/увас) *
            q: (электроно/электронно/по электронке/электронный/$eTicket)
            q: ({($website/$application) [$stoloto]}/[$stoloto] ~интернет)
            q!: {($win $eTicket) * $exchangeInf} * на $new *
            q!: * {$exchangeInf * $prizeAll * (на [$new/еще один] $ticketAll) * $eTicket} *
            a: Уточните, пожалуйста, Вы приобретали билет через личный кабинет или без регистрации на сайте?

            state: IBoughtInAccount
                q: ($account/личный) [помоему/по моему/вроде [бы]]
                q: * {заводил* $account} *
                q: * в личном *
                q: * (на/через/черес/в/($with/при) ~помощь) ($account/личк*) *
                q: (через/черес/в/($with/при) ~помощь) ~личный
                q: * я $registered *
                q: $registered
                q: * ($with/по/после) $registration *
                q: после
                q: * $registration прошла *
                q: * пришлось $registerInfRefl *
                q: * $registerPastRefl3 *
                a: Если Вы приобретали билет через личный кабинет, Вы можете получить выигрыш в Кошелек Столото, а затем выигрышными средствами из Кошелька оплатить новый билет.\n\nДля получения выигрыша в Кошелек Столото Вам необходимо зайти в Ваш личный кабинет, в раздел «Мои билеты». Выберите справа вкладку «Выигрышные». Затем необходимо нажать кнопку «Получить» с правой стороны (рядом с суммой Вашего выигрыша). Также Вы можете нажать на номер выигрышного билета и перейти на страницу квитанции. На странице счастливой квитанции нажмите кнопку «Перевести».\n\nМаксимальная сумма выигрыша к зачислению составляет 100 000 рублей для идентифицированных пользователей, 15 000 рублей для неидентифицированных​. Полная инструкция по получению выигрыша - по ссылке http://www.stoloto.ru/lottery/winning . Ознакомьтесь, пожалуйста.

            state: IBoughtWithoutRegistration
                q: без
                q: * без $registration *
                q: * я $registeredNe *
                q: $registeredNe
                q: * $registerPastContReflSg3Ne *
                q: * ($ne заводил*/незаводил*/низаводил*) $account *
                q: * $account ($ne заводил*/незаводил*/низаводил*) *
                a: Если Вы приобретали билет на сайте без регистрации с указанием номера телефона, Вы можете получить свой выигрыш в Кошелек Столото, а затем выигрышными средствами из Кошелька оплатить новый билет.\n\nДля этого нужно зарегистрироваться на сайте с номером телефона, указанным Вами при покупке билета. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты». Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в личном кабинете, то напишите нам, пожалуйста.\n\nДля получения выигрыша в Кошелек Столото Вам необходимо зайти в Ваш личный кабинет, в раздел «Мои билеты». Выберите справа вкладку «Выигрышные». Затем необходимо нажать кнопку «Получить» с правой стороны (рядом с суммой Вашего выигрыша). Также Вы можете нажать на номер выигрышного билета и перейти на страницу квитанции. На странице счастливой квитанции нажмите кнопку «Перевести».\n\nМаксимальная сумма выигрыша к зачислению составляет 100 000 рублей для идентифицированных пользователей, 15 000 рублей для неидентифицированных​. Полная инструкция по получению выигрыша - по ссылке http://www.stoloto.ru/lottery/winning . Ознакомьтесь, пожалуйста.

            state: LocalCatchAll
                event: noMatch
                script: Webim.switch();

        state: IBoughtOnWebsiteInAccount
            q: [$website] $account
            q: * (на/через/черес/в/($with/при) ~помощь) $account *
            q: * (на/через/черес/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/~интернет/$application/~программа/комп/~компьютер/моб* ~версия) $with $registration *
            q: * по ~интернет $with $registration *
            q: * (черезсайт/черезъсайт/черезьсайт/у вас/увас) $with $registration *
            q: * {$online ($with $registration)} *
            q: * $here ($with $registration) *
            go!: /Ticket/HowToExchangeAWinningTicketForANewOne/IBoughtOnWebsite/IBoughtInAccount

        state: IBoughtOnWebsiteWithoutRegistration
            q: * (на/через/черес/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/~интернет/$application/~программа/комп/~компьютер/моб* ~версия) без $registration *
            q: * по ~интернет без $registration *
            q: * (черезсайт/черезъсайт/черезьсайт/у вас/увас) без $registration *
            q: * {$online (без ($registration/авторизации))} *
            q: * $here (без ($registration/авторизации)) *
            go!: /Ticket/HowToExchangeAWinningTicketForANewOne/IBoughtOnWebsite/IBoughtWithoutRegistration

        state: LocalCatchAll
            event: noMatch
            script: Webim.switch();


    state: GaveTicketHowToCheck
        # Подарили билет, как проверить выигрыш?
        q!: * {$giftPast * $ticketAll * $checkTicket} *
        q!: * {$giftPast * $ticketAll * ~проверка} *
        intent!: /Ticket/GaveTicketHowToCheck
        script: Webim.switch();


    state: IBoughtATicketWhatIsNext
        # Купил билет, что делать дальше
        q!: * {$buyPastPres * ($ticketAll/$lottery)} * (дальше/делать/~действие) *
        q!: * {$payPast * ($ticketAll/$lottery)} * (дальше/делать/~действие) *
        q!: * (дальше/делать/~действие) * {$buyPastPres * ($ticketAll/$lottery)} *
        q!: * (дальше/делать/~действие) * {$payPast * ($ticketAll/$lottery)} *
        intent!: /Ticket/IBoughtATicketWhatIsNext
        a: Билет принимает участие в тираже, на который он был оформлен. По ссылке https://www.stoloto.ru/lottery/onlinesale Вы можете ознакомиться, как принять участие в наших лотереях.


    state: IBoughtATicketInPyaterochkaWhatIsNext
        # Купил билет в Пятерочке, что дальше
        q!: * $boughtTicketIn5 * (дальше/$doInfLocal/~действие/отследить/отслеживать) *
        q!: * (дальше/делать/~действие/отследить/отслеживать) * $boughtTicketIn5 *

        q!: * $comWhat делать $with ($paperTicketAll/($ticketAll/$lottery) из $retailPointOfSale)
        q!: * у $meGen [есть] ($paperTicketAll/($ticketAll/$lottery) из $retailPointOfSale) $comWhat {дальше делать}
        q!: * у $meGen [есть] ($paperTicketAll/($ticketAll/$lottery) из $retailPointOfSale) * $comWhat $with ним* делать *
        intent!: /Ticket/IBoughtATicketInPyaterochkaWhatIsNext
        a: Вы можете зарегистрироваться на сайте с номером телефона, указанным Вами при покупке билета. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты».\n\nИнструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации - по ссылке http://www.stoloto.ru/registration .\n\nЕсли после успешной регистрации Вы не видите Ваш билет в личном кабинете, то напишите нам, пожалуйста.\n\nПроверить билет можно после проведения тиража.


    state: StarterTicket
        # Что такое стартовый тираж?
        q!: [$helloAll] [$beginningWords] $starterTicket
        q!: * {$comWhat * ~стартовый [$ticketRun]} *
        q!: * {$tellMe * ~стартовый [$ticketRun]} *
        intent!: /Ticket/StarterTicket
        a: В случае, если Вы приобретаете многотиражный билет, для корректной проверки квитанции необходимо указывать номер первого из тех тиражей, на которые приобретен билет.


    state: ThereAreNoTicketRunNumberAndTicketNumber

        # Где посмотреть стартовый тираж?
        q!: * {$comWhere * $starterTicket} *
        q!: * {($findInf/$findPastPresNe) * $starterTicket} *
        q!: * {($findOutInf/определить) * $starterTicket} *
        q!: * {($knowNe/$forgetPastPres) * $starterTicket} *
        q!: * {$comNeed * $starterTicket} *

        # общее
        q!: [$helloAll] [$beginningWords] ($ticketRunNumber/ $ticketNumber) [$comWhat такое]
        q!: [$helloAll] [$beginningWords] ($ticketRunNumber/$ticketNumber) [$comWhat] это *
        q!: [$helloAll] $locTellMe [$please] [$beginningWords] ($ticketRunNumber/$ticketNumber) *

        q!: * $comWhat [$here] $bePresSg3 ($starterTicket/$ticketNumber/$ticketRun/$ticketRunNumber) *
        q!: * {($comWhat (такое/такой/из этого)) ($ticketNumber/$ticketRun/$ticketRunNumber)} *
        q!: * выглядит ($starterTicket/$ticketNumber/$ticketRun/$ticketRunNumber) *

        q!: * а ($starterTicket/$ticketNumber/$ticketRun/$ticketRunNumber) какой *
        q!: * ($starterTicket/$ticketNumber/$ticketRun/$ticketRunNumber) $ne пойму какой *

        q!: * $skolko $numeral * в ($ticketNumber/$ticketRunNumber) *
        q!: * из скольки $numeral * ($ticketRunNumber/$ticketNumber) *
        q!: * $skolko $numeral номере ($ticket/$ticketRun) *
        q!: * $skolko $numeral содерж* ($ticketRunNumber/$ticketNumber) *
        q!: * какие $numeral * явл* ($ticketRunNumber/$ticketNumber/$ticketRun) *

        q!: * ($ticketRunNumber/$ticketNumber/$ticketRun) {$howMuch [там/это] $numeral} *

        q!: [$helloAll] $how $oneWord какой ($ticketRunNumber/$ticketNumber/$ticketRun)

        q!: * {($ne ~дата) * ($ne $ticketRun)} *
        q!: * {($ne ~дата) * ($ne $ticketRunNumber)} *
        q!: * {($ne ~дата) * ($ne $ticketNumber)} *

        q!: * это и есть ($ticketRunNumber/$ticketNumber) *

        q!: * $comWhere ($starterTicket/$ticketRunNumber/$ticketRun/$ticketNumber) $generalNamedLottery *

        q!: * $comWhat $oneWord в поле ($ticketNumber/$ticketRunNumber) *

        # Где посмотреть номер тиража? (билета)
        q!: * {(я/мы) * (не (знаю/знаем)) * $ticketRun} *
        q!: * {($comWhat (значит/означает)) $ticketRunNumber} *

        q!: * в каком ($ticketRunNumber/$ticketRun) (он/они) $playPastPres *
        q!: * в каком ($ticketRunNumber/$ticketRun) и $when *
        q!: * $comWhere ($ticketRunNumber/$ticketRun) [и] $how *

        q!: * {$comWhere * $ticketRunNumber} *

        q!: * {какой * $ticketRun * $ticket} *

        q!: * {($how/$comWhere/$fromWhere) * ($seeInf/$findOutInf/$receiveInf/выгля*) * $ticketRun * [$ticket]} *

        q!: * {($how/$comWhere/$fromWhere) * ($seeInf/$findOutInf/$receiveInf/выгля*) * $number * ($ticketRun/$ticket)} *

        q!: * {($how/$fromWhere) * ($seeInf/$findOutInf) * $when * $lottery} *

        q!: * {$comWhere $indicatePartPas $ticketRun} *
        q!: * $comWhere * {$indicatePartPas $ticketRun} *
        q!: * {$comWhere находит* ($ticketRunNumber/$ticketRun)} *
        q!: * {$comWhere посмотреть ($ticketRunNumber/$ticketRun)}

        q!: * {[$cantPastPres/$onTicket] * $findInf * $ticketRunNumber} * [$checkTicket/~проверка] *
        q!: * {[$cantPastPres] $findInf $ticketRun} * [$checkTicket/~проверка] *
        q!: * {$checkInf * $ticketRunNumber} *
        q!: * {$forgetPastPres [[на] [~какой]] $ticketRun} *
        q!: * {$lookPast3Ne ($ticketRunNumber/$ticketRun)} *
        q!: * (какой/$when) ($ticketRunNumber/$ticketRun)
        q!: * на какой ($ticketRunNumber/$ticketRun) *


        q!: * после какого $ticketRun *
        q!: * {[$buyPastPres] * [$onTicket/$ticket] * $writeDownPastNe * $ticketRunNumber} *
        q!: * {$writeDownPastNe $ticketRun} *
        q!: * {[$buyPastPres] * [$ticketAll/$onTicket] * ($findOutInf/определить) * $ticketRunNumber} *
        q!: * ($findOutInf/определить) $ticketRunNumber * {(куплен*/приобрет*) * $ticket} *
        q!: * [$how/$cantPastPres] {($findOutInf/определить) $ticketRun} * [~проверка/$checkTicket] *
        q!: * $how * определяет* * $ticketRun *
        q!: * {$findPastPresNe $ticketRunNumber} *

        q!: * {$findPastPresNe нигде $ticketRun} *

        q!: * {$findPastPresNe нигде $ticketRunNumber} *
        q!: * {$knowNe * $ticketRunNumber * [$checkTicket] * [$ticket]} *
        q!: * {$forgetPastPres * $ticketRunNumber * [$checkTicket] * [$ticket]} *
        q!: * то какой $ticketRun *
        q!: * {$ticketRun $knowNe}
        q!: * какой ($ticketRunNumber/$ticketRun) по [$oneWord] $ticket *
        q!: * {$knowNe * (~какой $ticketRun) * [$checkTicket] * [$ticket]} *
        q!: * {$forgetPastPres * (~какой $ticketRun) * [$checkTicket] * [$ticket]} *
        q!: * {$knowNe * ($comMy $ticketRun) * [$checkTicket] * [$ticket]} *
        q!: * {$forgetPastPres * ($comMy $ticketRun) * [$checkTicket] * [$ticket]} *

        q!: * {($knowNe/$forgetPastPres) я $ticketRun} * [$checkTicket] * [$ticket] *
        q!: * [$checkTicket] * [$ticket] * {($knowNe/$forgetPastPres) я $ticketRun} *

        q!: * $comNeed ($ticketRunNumber/$ticketRun) *
        q!: * [$buyPastPres] * [$ticket] * {$comNo [на нем] $ticketRunNumber} * [$ticket] *
        q!: * [$buyPastPres] * [$ticket] * {$comNo $ticketRun} * [$ticket] *

        q!: * {$checkInf * [$ticket] * (без $ticketRunNumber)} *
        q!: * {$checkInf * $ticket * $comNo * $ticketRunNumber} *
        q!: * {$checkInf * $ticket * $comNo * $ticketRun} *
        q!: * {$checkInf * $ticket * $writtenNe * $ticketRunNumber} *
        q!: * {$checkInf * $ticket * $writtenNe * $ticketRun} *
        q!: * {$checkInf * $generalNamedLottery * $writtenNe * $ticketRunNumber} *
        q!: * {$checkInf * $generalNamedLottery * $writtenNe * $ticketRun} *

        q!: * {$checkInf * (без $ticketRunNumber)} *
        q!: * {$checkInf * (без $ticketRun)} *

        q!: * [$checkTicket] * {[$generalNamedLottery] * [$ticket] * $writtenNe * $ticketRunNumber} * [$checkTicket] *
        q!: * [$checkTicket] * {[$generalNamedLottery] * [$ticket] * $writtenNe * $ticketRun} * [$checkTicket] *

        q!: * {(в ~какой $ticketRun) * $playPastPres * $ticket} *
        q!: * {(в ~какой $ticketRunNumber) * $playPastPres * $ticket} *
        q!: * (к ~какой ($ticketRun/$ticketRunNumber)) * относит* *
        q!: * какой это [был] $ticketRun *
        q!: * на какой ($ticketRun/$ticketRunNumber) *
        q!: * какой $ticketRunNumber у *
        q!: * $ticketRunNumber какой *

        q!: * [у меня $ticketAll] без $ticketRunNumber *
        q!: * без $ticketRun *
        q!: * {$smsComePastNe (~какой $ticketRun)} *

        q!: * $ticketRunNumber $unclear *
        q!: * $comWhere $ticketRun

        q!: * серия и $ticketRun одно и *

        # Где на билете указан номер билета?
        q!: * $ticketNumber являет* $uniqueKey *

        q!: * {$comWhere * $seeInf * $ticketNumber} *
        q!: * {могу * $seeInf * $ticketNumber} *
        q!: * {$comWhere * [$receiveInf] * $ticketNumber} *
        q!: * {($comWhere/что из этого) * $number * $ticket} *


        # (купил/куплю) билет, где посмотреть номер
        q!: * ($boughtTicket/$willBuyTicket) * $wheresHisNumber *
        # купил билет забыл его номер
        q!: * $boughtTicket * $noNumber *


        q!: * {[$cantPastPres] * ($findInf/$findPastPresNe) * $ticketNumber * [$checkTicket/~проверка]} *
        q!: * {$findPastPresNe нигде $ticketNumber} *
        q!: * {($findOutInf/определить) * $ticketNumber} *

        q!: * ($findOutInf/определить) $number * {(куплен*/приобрет*/~проверка/$checkTicket) * $ticket} *
        q!: * ($findOutInf/определить/посмотреть) $number и серию *
        q!: * $comWhere $number * $comWhere серия *
        q!: * {$checkInf $ticketNumber} *
        q!: * {$comNo * $ticketNumber} *
        q!: * {$lookPast3Ne $ticketNumber} *
        q!: * {$writtenNe * $ticketNumber * [$checkTicket] * [$generalNamedLottery]} *
        q!: * {$forgetPastPres $ticketNumber} *
        q!: * $forgetPastPres $number $paid * $ticketAndLotteryAll *

        q!: * {$writeDownPastNe $ticketNumber} *
        q!: * {($ne написали) $ticketNumber} *


        q!: * {$knowNe * $ticketNumber} *
        q!: * $comNeed $ticketNumber *
        q!: * {$ticketAll * $knowNe * ((его/их) $number)} *
        q!: * {$ticketAll * ($findOutInf/определить) * ((его/их) $number)} *
        q!: * {$cantPastPres ($findOutInf/определить) $number} * (~проверка/$checkTicket) *
        q!: * $ticketAll * {$forgetPastPres [его/их] $number} *
        q!: * {$smsComePastNe (~какой $ticketNumber)} *
        q!: * {какой $ticketNumber}
        q!: * $ticketNumber какой у *

        q!: * какой $ticketNumber $Number $ticketRun *

        q!: * {[я] $forgetPastPres [$comMy] $ticketNumber} *


        q!: * $ticketNumber $unclear *

        # На билете нет номера тиража и номера билета
        q!: * $comWhat такое {$ticketNumber и $ticketRunNumber} *
        q!: * {$comWhere * $ticketNumber * $ticketRunNumber} *
        q!: * {$comNo * $ticketNumber * $ticketRunNumber} *
        q!: * {($findInf/$findPastPresNe) * $ticketNumber * $ticketRunNumber} *
        q!: * {($findOutInf/определить) * $ticketNumber * $ticketRunNumber} *
        q!: * {$forgetPastPres * $ticketNumber * $ticketRunNumber} *
        q!: * {$writeDownPastNe * $ticketNumber * $ticketRunNumber} *
        q!: * {$knowNe * $ticketNumber * $ticketRunNumber} *
        q!: * {$writtenNe * $ticketNumber * $ticketRunNumber} *
        q!: * {$lookPast3Ne * $ticketNumber * $ticketRunNumber} *

        q!: * ($comWhere посмотреть/записать) * {$number и $ticketRun} *
        q!: * {($ne ($number/$ticketNumber)) ($ne ($ticketRun/$ticketRunNumber))} *

        q!: * $comWhere * {$number $ticketRun и $ticket} *
        q!: * $comNo * {$number $ticketRun и $ticket} *
        q!: * $lookPast3Ne * {$number $ticketRun и $ticket} *
        q!: * ($findInf/$findPastPresNe) * {$number $ticketRun и $ticket} *
        q!: * ($findOutInf/определить) * {$number $ticketRun и $ticket} *
        q!: * $forgetPastPres * {$number $ticketRun и $ticket} *
        q!: * $writeDownPastNe * {$number $ticketRun и $ticket} *
        q!: * {$number $ticketRun и $ticket} * $writeDownPastNe *
        q!: * $knowNe * {$number $ticketRun и $ticket} *
        q!: * {$number $ticketRun и $ticket} * $knowNe *
        q!: * $writtenNe * {$number $ticketRun и $ticket} *
        q!: * {$number $ticketRun и $ticket} * $writtenNe *
        q!: * $smsComePastPerfNe * {$number $ticketRun и $ticket} *
        q!: * {$number $ticketRun и $ticket} * $smsComePastPerfNe *



        q!: * {$checkTicket * $ticket * (($without/$comNo) [$number] серии/серии $comNo)} *





        q!: * на одном $indicatePartPas ($ticketRunNumber/$ticketNumber/$ticketRun) * на другом *
        q!: * {(брать/взять) ($ticketRunNumber/$ticketNumber/$ticketRun)} *
        q!: * {выгляд* * ($ticketRunNumber/$ticketNumber)} *

        q!: * какой * у меня ($ticketRunNumber/$ticketNumber) *
        q!: * {$lostPast * ($ticketRunNumber/$ticketNumber/$starterTicket)} *


        # Как узнать дату розыгрыша билета?
        q!: * {$comWhere * $indicatePartPas * $drawDate} *
        q!: * {$findOutInf * $drawDate * $ticket} *

        q!: * $findOutInf * время розыгрыш*
        q!: * понять $drawDate
        q!: * {($comNo/$knowNe/$writtenNe) $drawDate} *

        q!: * (~дата розыгрыш*) $ne пойму какая *

        q!: * $findOutInf * время розыгрыш*
        q!: * $ticket * ($when/какого числа/в какой день) * $beFutSgPl3 * разыгрыват* *
        q!: * {$ticket * ($when/какого числа/в какой день) * $beFutSgPl3 * розыг*} *
        q!: * {$ticket * ($when/какого числа/в какой день) * (розыг*/разыг*)} *
        q!: * ($when/какого числа/в какой день) * $beFutSgPl3 разыгрыват* * $ticket *
        q!: * ($when/какого числа/в какой день) * ($beFutSgPl3 (разыгрыват*/проводит*/проходить)/проходит/пройдет) [$comMy/~данный] ($generalNamedLottery/$lottery/$ticketRun/игра по $ticketRun) *

        q!: * $ticket * ($when/какого числа/в какой день) [$beFutSgPl3 [проводит*/проходит*]/состоит*] их розыгрыш* *
        q!: * $ticket * ($when/какого числа/в какой день) [$beFutSgPl3 [проводит*/проходит*]/состоит*] (розыгрыш*/$lottery)
        q!: * ($when/какого числа/в какой день) {($beFutSgPl3 [проводит*/проходит*]/состоит*) розыгрыш*} * $ticket *
        q!: * ($when/какого числа/в какой день) {[$beFutSgPl3 [проводит*/проходит*]/состоит*] розыгрыш*} [по] [$comMy/дан*] $lottery
        q!: * ($when/какого числа/в какой день) розыгрыш* [по] [$comMy/дан*] $ticket *
        q!: * {(($when/какого числа/в какой день) $ticketRun) * $knowNe} *
        q!: * ($when/какого числа/в какой день) у меня игра *
        q!: * ($when/какого числа/в какой день) ($beFutSgPl3/состоит*) $or уже был розыгрыш* *
        q!: * розыгрыш* [на/по] $generalNamedLottery ($when/какого числа/в какой день) [$beFutSgPl3] [проводит*/проходит*]

        q!: * $ticket * ($when/какого числа/в какой день) {[$beFutSgPl3 [проводит*/проходит*]/состоит*] игра} *
        q!: * $ticket * ($when/какого числа/в какой день) * $possiblePredic разыграть *

        q!: * ($when/какого числа/в какой день) * $ticket * $beFutSgPl3 * в (розыгрыше/игре) *

        intent!: /Ticket/ThereAreNoTicketRunNumberAndTicketNumber
        a: Уточните, пожалуйста, Вы приобретали билет в розничных точках продаж или через сайт?

        state: IBoughtInRetailPointOfSale || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber
            q: * $retailPointOfSale *
            q: * на руках *
            q: * $geography *
            q: * ~купон *
            q: * ~серия *
            q!: * $ticket без $drawDate *
            q!: * {(($without/$comNo) [$number] серии/серии $comNo) * $retailPointOfSale * [$ticket/$checkTicket]} *
            q!: * $retailPointOfSale * {$comNo [на нем] $ticketRunNumber} *
            q!: * {$comNo [на нем] $ticketRunNumber} * $retailPointOfSale *
            q!: * {$retailPointOfSale * определяет* * $ticketRun} *
            q!: * $retailPointOfSale * (какой/$when) ($ticketRunNumber/$ticketRun)
            q!: * {$retailPointOfSale * (на какой ($ticketRunNumber/$ticketRun))} *
            q!: * {$retailPointOfSale * ($ticketRunNumber какой)} *
            q!: * $retailPointOfSale * {$findPastPresNe * ($ticketRunNumber/$ticketRun)} *
            q!: * (~купон/$retailPointOfSale) * {$comWhere находит* ($ticketRunNumber/$ticketRun)} *
            q!: * {$comWhere находит* ($ticketRunNumber/$ticketRun)} * (~купон/$retailPointOfSale) *
            q!: * ~купон * а $number $comNo *
            q!: * посмотреть ($ticketRunNumber/$ticketRun) * (~купон/$retailPointOfSale) *
            q!: * {($how/$comWhere/$fromWhere) * ($seeInf/$findOutInf/$receiveInf/выгля*) * $ticketRun * (~купон)} *
            q!: * ($ne стало) $ticketRunNumber на $ticket *
            q!: * {(на купон*) * $ticketRunNumber} *
            q!: * {(на купон*) * $ticketRun} *
            q!: * {(на купон*) * $ticketNumber} *
            q!: * {(на купон*) * $drawDate} *
            q!: * {$findInf * $ticketRunNumber * ~купон} *
            q!: * {$findInf * $ticketRun * ~купон} *
            q!: * {$findInf * $ticketNumber * ~купон} *
            q!: * ~купон * (какой/$when) ($ticketRunNumber/$ticketRun)
            q!: * {~купон * (на какой ($ticketRunNumber/$ticketRun))} *
            q!: * {~купон * ($ticketRunNumber какой)} *
            q!: * $findInf * {$ticketNumber * $ticketRun} * ~купон *
            q!: * ~купон * {(брать/взять) ($ticketRunNumber/$ticketNumber/$ticketRun)} *
            q!: * {(брать/взять) ($ticketRunNumber/$ticketNumber/$ticketRun)} * ~купон *

            q!: * {($comWhere * $indicatePartPas) * $drawDate * (~купон/$retailPointOfSale)} *
            q!: * {($knowNe/$writtenNe) * $drawDate * (~купон/$retailPointOfSale)} *

            q!: * [$ticket] * $retailPointOfSale * $drawDate *

            q!: * [$ticket] * $retailPointOfSale * $when * $beFutSgPl3 * разыгрыват* * [$ticket] *
            q!: * [$ticket] * $retailPointOfSale * $when [$beFutSgPl3] розыгрыш* *
            q!: * [$ticket] * $retailPointOfSale * $when {[$beFutSgPl3] игра} *
            q!: * [$ticket] * $retailPointOfSale * $when * $possiblePredic разыграть *
            # Где на билете (на купоне) тираж
            q!: * $comWhat $onTicketAll $bePresSg3 ($starterTicket/$ticketRun/$ticketRunNumber/$ticketNumber/$number/датой) *
            q!: * {($comWhere/выгля*) * ($starterTicket/$ticketRun/$ticketRunNumber/$ticketNumber/$number/дата) * $onTicketAll} *
            q!: * {($findPastPresNe/$fromWhere/$seeInf/$findOutInf/$receiveInf) * ($starterTicket/$ticketRun/$ticketRunNumber/$ticketNumber/дату) * $onTicketAll} *
            q!: * {$cantPastPres * ($starterTicket/$ticketRun/$ticketRunNumber/$ticketNumber) * $onTicketAll} *
            q!: * {какой * $ticketRun * $onTicketAll} *




            q!: * {$findInf * $onTicket * $number} *
            q!: * {$findOutInf * $onTicket * $number} *
            q!: * {$comNo * $onTicket * $number} *
            q!: * {$writeDownPastNe * $onTicket * $number} *
            q!: * {$writtenNe * $onTicket * $number} *



            q!: * {$comWhere ($starterTicket/$ticketRun/$ticketRunNumber/$ticketNumber) (на нем)} *
            q!: * у меня $ticketAll без $number *

            q!: * $comWhere * $number серии *
            q!: * (на/в) $ticket [$oneWord] {($number $ticketPack) [и] серия} *
            q!: * серия $ticket (есть/имеет*) $number $comNo *

            q!: * {$only серия и ($number $ticketPack)} *
            q!: * $number * и $number $ticketPack *
            q!: * ($only/есть) [$number] $ticketPack *
            q!: * ($number/№/N) $ticketPack $Number серия $Number *
            q!: * {$checkInf * ($only $number $ticketPack)} *
            q!: $here $number (с буквой/пачки) *


            a: Если Вы приобретали билет в розничных точках продаж и указывали номер телефона, номер тиража, номер билета и дату розыгрыша Вы можете посмотреть на черно-белой квитанции, которую Вам выдали при покупке билета. Номер тиража указан в верхней части квитанции после слов «Билет действителен для 1 тиража (ей)». Если у Вас не сохранилась квитанция, Вы можете зарегистрироваться с этим номером телефона на сайте. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты», там же Вы найдете всю информацию о билете. Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в Личном кабинете, напишите нам, пожалуйста.

        state: IBoughtInInternet || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber
            q: [$website] $account
            q: * (на/через/черес/в/(с/при) ~помощь) [$this/ваш*] ($website/$account/[$application] $stoloto/~интернет/$application/~программа/комп/~компьютер/моб* ~версия) *
            q: (электроно/электронно/по электронке/электронный/$eTicket)
            q: * по (~интернет/телефону) *
            q: * (черезсайт/черезъсайт/черезьсайт/у вас/увас) *
            q: ({($website/$application) [$stoloto]}/[$stoloto] ~интернет)
            q: * $here *
            q: * $online *
            q!: * $online * {$findPastPresNe нигде $ticketRun} *
            q!: * {$findPastPresNe нигде $ticketRun} * $online *
            q!: * $online * {$findPastPresNe нигде $ticketRunNumber} *
            q!: * {$findPastPresNe нигде $ticketRunNumber} * $online *
            q!: * $online * {$findPastPresNe нигде $ticketNumber} *
            q!: * $online * (какой/$when) ($ticketRunNumber/$ticketRun)
            q!: * {$online * (на какой ($ticketRunNumber/$ticketRun))} *
            q!: * ($online/$eTicket) * {$comWhere находит* $ticketRun} *
            q!: * {$comWhere находит* ($ticketRunNumber/$ticketRun)} * ($online/$eTicket) *
            q!: * {$findPastPresNe нигде $ticketNumber} * $online *
            q!: * {$eTicket * определяет* * $ticketRun} *
            q!: * $eTicket * (какой/$when) ($ticketRunNumber/$ticketRun)
            q!: * какой $eTicket (номером/номиром/тиражом) *
            q!: * {($ticketRunNumber какой) * $eTicket} *
            q!: * {$eTicket * (на какой ($ticketRunNumber/$ticketRun))} *
            q!: * {$buyPastPres * [$ticket] * $online} * {$forgetPastPres [его/их] $number} *
            q!: * {$buyPastPres * [$ticket] * $website} * {$forgetPastPres [его/их] $number} *
            q!: * {$buyPastPres * [$ticket] * $online} * $comNeed [его/их] $number *
            q!: * {$buyPastPres * [$ticket] * $website} * $comNeed [его/их] $number *
            q!: * {$buyPastPres * $online * ($writeDownPastNe [его/их] $number)} *
            q!: * {$buyPastPres * $online * ($findOutInf [его/их] $number)} *
            q!: * {$buyPastPres * $website * ($writeDownPastNe [его/их] $number)} *
            q!: * без входа * ($findOutInf/определить) ($ticketNumber/$ticketRun/$ticketRunNumber) *
            q!: * $eTicket * ($writeDownPastNe/$smsComePastPerfNe) (его/их) $number *
            q!: * $eTicket * {(брать/взять) ($ticketRunNumber/$ticketNumber/$ticketRun)} *
            q!: * посмотреть ($ticketRunNumber/$ticketRun) * $eTicket *
            q!: * {(брать/взять) ($ticketRunNumber/$ticketNumber/$ticketRun)} * $eTicket *
            q!: * $eTicket * ~дата (розыгрыш*/проведени*) *
            q!: * {($comWhere * $indicatePartPas) * (~дата розыгрыш*) * $eTicket} *
            q!: * {($comWhere * $indicatePartPas) * (~дата проведени*) * $eTicket} *
            q!: * {$knowNe * (~дата розыгрыш*) * $eTicket} *
            q!: * {$knowNe * (~дата проведени*) * $eTicket} *
            q!: * {$writtenNe * (~дата розыгрыш*) * $eTicket} *
            q!: * {$writtenNe * (~дата проведени*) * $eTicket} *
            q!: * $eTicket * $when * $beFutSgPl3 * разыгрыват* *
            q!: * $when * $beFutSgPl3 разыгрыват* * $eTicket *
            q!: * $eTicket * $when [$beFutSgPl3] розыгрыш* *
            q!: * $eTicket * $when {[$beFutSgPl3] игра} *
            q!: * $eTicket * $when * $possiblePredic разыграть *
            q!: * {$smsComePastPerfNe ($ticketRunNumber/$ticketNumber)} *
            a: Если Вы приобретали билет через сайт, номер тиража, номер билета и дату розыгрыша можно посмотреть в личном кабинете в разделе «Мои билеты». Если Вы приобретали билет через сайт, но у Вас еще нет регистрации, зарегистрируйтесь, пожалуйста, на сайте с номером телефона, указанным при покупке билета. Билет и вся информация о нем отобразятся в личном кабинете в разделе «Мои билеты». Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в Личном кабинете, напишите нам, пожалуйста.


    state: IsItNecessaryToRegisterTicket
        # Как регистрировать бумажный билет и зачем?
        q!: * {$registerInf * $ticketAll} *
        q!: * $boughtTicketIn5 * {$registerInf * $comNeed} *
        q!: * $comNeed * $registration $ticketAll *
        q!: * ($ticketAll [при покупк*]/$boughtTicket) * ($ne (регестрировал*/регистрировал*)/нерегестрировал*/нерегистрировал/$registeredNe) * {его $registerInf} *
        intent!: /Ticket/IsItNecessaryToRegisterTicket
        a: Все билеты фиксируются на тираж при покупке. Дополнительно регистрировать билет не требуется.


    state: NoRegistrationTicket
        # Где посмотреть билет, купленный без регистрации?
        q!: * {($buyPastPres/$payPast) * [$ticket] * $withoutRegistrationAll} * [$comWhere/$how] *

        q!: * {$paid * $withoutRegistrationAll} *

        q!: * $ticketAll * $withoutRegistration *

        q!: * ($payPast/$buyPastPres) * $how * {получить * $ticket} *
        q!: * ($payPast/$buyPastPres) * $how * (его/иво/их) (получит/получить) *

        q!: * $boughtTicketCouponPacket * {($cantPastPres/$comWhere/$how) * ($findInf/посмотреть)} *
        q!: * $boughtTicketCouponPacket * $comWhere * (наблюдать/отследить/отслеживать) *
        q!: * $boughtTicketCouponPacket * $comWhere (его/их) $seeInf *
        q!: * $boughtTicketCouponPacket * {$comWhere * ~информация * $ticketAll} *
        q!: * $boughtTicketCouponPacket * {$how * $appendInf} *
        q!: * $boughtTicketCouponPacket * {$possiblePredic * $findInf} *
        q!: * $boughtTicketCouponPacket * куда (он/они) (пришел/пришли) *

        q!: * {$boughtUsingExternalResource * (узнать $ticket)} *

        q!: * {$buyPastPres * $ticketAll * $online} * понять $comWhere он* *

        q!: * $comWhere (сам/сами) $ticket *
        q!: * $comWhere * отображает* * $paid * $ticket *
        q!: * $comWhere отображают* $comMy $ticket *

        q!: * {$payPast * $online} * $comWhere $receiveInf $ticket *
        q!: * $how * {$findInf $comMy $ticketAll} *
        q!: * ($buyPastPres/$payPast) * $findOutInf $about [$comMy] $ticket *
        q!: * $seeInf инф* $about [$comMy] $ticket *
        q!: * $seeInf инф* $about * $paid * $ticket *
        q!: * ($how/$comWhere) [я] [мне/$possiblePredic/могу] {$seeInf [$comMy] [$paid] $ticket} *
        q!: * ($how $findOutInf $ticket) * ($buyPastPres/$payPast) *
        q!: * $how * найти [$comMy] $paid $ticket *
        q!: * забить * $ticket * на сайт *

        q!: * ($how/$comWhere) * {$seeInf * ($website/$account/интернет*) * $ticket} *

        q!: * {($buyPastPres/$buyFut) * (~интернет/инет/инете)} * бумажн* $ticket * ($ne будет/небудет/нибудет) *

        q!: * {$findInf [$comMy] $ticket (по $number $telephone)} *

        # билет потерял
        q!: * {$lostPast * $ticket} *

        # чек потерял
        q!: * $lostReceipt *
        q!: * {$receipt * ($ne дали/недали)} *

        # купили билет, чек потеряли
        q!: * $boughtTicket * $lostReceipt *

        q!: * ($buyPastPres * $ticket/$ticket * $buyPastPres) $but потерял* *

        # проверить билет без чека
        # проверить билет, если чек потерял
        q!: * {$checkInf * $withoutReceipt * $ticket} *
        q!: * $checkMyTicket * $lostReceipt *
        q!: * $lostReceipt * $checkMyTicket *
        # получить выигрыш без чека
        # получить выигрыш билет без регистрации
        # получить выигрыш я не зарегистрирован
        q!: * $getPrize * ($withoutReceipt/$withoutRegistration/$registeredNe) *
        q!: * ($withoutReceipt/$withoutRegistration/$registeredNe) * $getPrize *
        q!: * {$cashoutInf * $ticket * $withoutReceipt} *

        # получить выигрыш, потерял чек
        q!: * $getPrize * $lostReceipt *
        q!: * $lostReceipt * $getPrize *

        q!: * {[$how] $appendInf [$comMy] $ticketAll}
        q!: * $how {загрузить [$comMy] $ticketAll} *
        q!: * {[$me] $comNeed $appendInf [$comMy] $ticketAll}
        q!: * {$want $appendInf [$comMy] $ticketAll}
        q!: * {$appendInf [$comMy] $ticketAll $here} *
        q!: * {$appendInf * $paid * $ticketAll} *

        q!: * ($appendInf/загрузить) * $ticketAll * ((в/на/$via) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт/(в/на) $stoloto) *
        q!: * ($appendInf/загрузить) * ((в/на/$via) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт/(в/на) $stoloto) * $ticketAll *
        q!: * $ticketAll * ($appendInf/загрузить) * ((в/на/$via) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт/(в/на) $stoloto) *
        q!: * $ticketAll * ((в/на/$via) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт/(в/на) $stoloto) * ($appendInf/загрузить) *
        q!: * ((в/на/$via) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт/(в/на) $stoloto) * ($appendInf/загрузить) * $ticketAll *
        q!: * ((в/на/$via) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт/(в/на) $stoloto) * $ticketAll * ($appendInf/загрузить) *
        q!: * $insertInf их $number * $forTo * (отражалис*/отразилис*/появилис*/отобразилис*/отображалис*) в [$oneWord] ($account/~приложение/мои билеты/~программа) *
        q!: * $buyPastPres * $retailPointOfSale * увидеть в [$oneWord] ($account/~приложение/мои билеты/~программа) *
        q!: * $buyPastPres * $retailPointOfSale * его подтвердить у вас *
        q!: * {($appendInf * $ticket) * ($buyPastPres * за налич*)} *

        intent!: /Ticket/NoRegistrationTicket
        a: Если Вы приобретали билет на сайте без регистрации или в розничных точках продаж с указанием номера телефона, Вы можете зарегистрироваться на сайте с номером телефона, указанным Вами при покупке билета. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты». Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в личном кабинете, то напишите нам, пожалуйста.

        state: ProblemNotSolved || fromState = /Ticket/NoRegistrationTicket
            q: * $tryPast *
            q: * $cantPastPres *
            q: * $bonusComePastPresNe *
            q: * $smsComePastPresNe *
            q: * $comNo *
            q: * $receivePastNe *
            q: * $findPastPresNe *
            q: * $helpPastPresNe *
            q: * $problem *
            script: Webim.switch();


    state: UnavailableToBuyTicket
        # Недоступна покупка билетов
        q!: * сложно $buyInf $ticketAndLottery *
        q!: * {выходит оплатите позже} *
        q!: * купилис* $only *
        q!: * ($payPastReflNe/$buyPastRefl3Ne/$registerTicketPastReflNe) * $buyNAll *
        q!: * [взял*] * $buyNAll * ($payPastReflNe/$buyPastRefl3Ne/$registerTicketPastReflNe) *

        q!: * [$how] * {$cantPastPresAll * ($buyInf/$payInf) * [$ticketAndLottery]} *
        q!: * {$cantPastPresAll * ($buyInf/$payInf) * [$ticketAndLottery]} * [$how] *

        q!: * {$cantPastPresAll * ~ставка} *
        q!: * {$want * ($buyInf/$payInf)} * (выкидывает/выбрасывает) *

        q!: * $no ~возможность ($buyInf/$payInf) *
        q!: * $when * ($buyInf/$payInf) *

        q!: * ($buyInf/$payInf) * (~пустой ~экран) *
        q!: * (~пустой ~экран) * ($buyInf/$payInf) *

        q!: * $why * ($buyInf/$payInf) * $nelzya *

        q!: * ($button/~поле) * ($buyInf/$payInf) * $activeNe *
        q!: * $activeNe * ($button/~поле) * ($buyInf/$payInf) *
        q!: * ($buyInf/$payInf) * ($button/~поле) * $activeNe *
        q!: * ($buyInf/$payInf) * $activeNe * ($button/~поле) *

        q!: * ($buyInf/$payInf/$payment) * $activeNe *
        q!: * $activeNe * ($buyInf/$payInf/$payment) *

        q!: * {$comNo (~окно ~вариант $payment)} *
        q!: * {$cantPastPres * ($buyN/$payment)} *
        q!: * $ne обрабатыв* $buyN *

        q!: * ($ne идет/неидет/$acceptPresNe/$dismissPastPres) * $payment *
        q!: * $payment * ($ne идет/неидет/$acceptPresNe/$dismissPastPres) *

        q!: * ($producePres3Ne/$confirmPres3Ne) $payment *
        q!: * $payment ($producePres3Ne/$confirmPres3Ne) *

        q!: * $payment $comWhat пошло $ne так *

        q!: * {$ticket (так и $ne купил*)} *

        q!: * $ticket * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * $payment *
        q!: * $ticket * $payment * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * $payment * $ticket *
        q!: * $payment * $ticket * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) *
        q!: * $payment * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * $ticket *

        q!: * $workFut * ($buyN/$payment) *
        q!: * ($buyN/$payment) * $workFut *

        q!: * {$payPresNe * ($ticketAndLottery/$bet)} *

        q!: [$helloAll] {$why ($payPresNe/$payInfNe)}
        q!: * {([так] $slowly) $passPres ($buyN/$payment)} *

        q!: * [$why] * {($buyInfNe/$payInfNe) * $ticketAndLottery} * [$why] *

        q!: * [$comMoney] * [$sendPastPres] * {$buyPresRefl3Ne * $ticket} *
        q!: * {$ticket * $buyPresRefl3 * долго} *
        q!: * $payment [за] $ticketAndLottery $delay *

        q!: * ($payment/$buyN/$buyInf/$payInf) * $error *
        q!: * $error * ($payment/$buyN/$buyInf/$payInf) *

        q!: * ($moneyTakeOffPastPres/$payPast) * (вис*/наход*/$ticket) в $basket *
        q!: * (так и/до сих пор/(он/они) еще/$paid $ticket) [вис*/наход*] в $basket *

        q!: * {$moneyTakeOffPastPres * $ticket * ($buyPastRefl3Ne/$confirmPastReflNe/$notPaid)} *

        q!: * {$payPast * $ticket * ($buyPastRefl3Ne/$notPaid)} *
        q!: * {оплач* * $ticket * ($buyPastRefl3Ne/$notPaid)} *
        q!: * {(пыта* $payInf) * $ticket * ($buyPastRefl3Ne/$notPaid)} *

        q!: * (недоступност*/$inactive/$workPres3Ne/$workFut) * платежн* систем* *
        q!: * платежн* систем* * ($inactive/$workPres3Ne/$workFut) *


        q!: * {($buyPastPres/$payPast) * $ticketAndLottery} * ошибк* сервер* *
        q!: * {$payPast * $ticket} * результ* $comNo *
        q!: * $ticket остал* $notPaid *

        intent!: /Ticket/UnavailableToBuyTicket
        if: $global.byuingTicketIsAvailable
            a: Уточните, пожалуйста, способ оплаты, а также на каком этапе и какая возникает сложность.
        else:
            a: По техническим причинам временно может быть недоступна оплата билетов. А пока мы работаем над устранением этой проблемы, пожалуйста, не дублируйте Ваши оплаты после того, как первая попытка не удалась. Мы просим немного Вашего терпения и обещаем, что очень скоро платежи станут проходить так же быстро, как и всегда.
            #a: Мы уже работаем над возобновлением продажи билетов онлайн. Вы можете приобрести билет в одной из точек продаж лотерейных билетов, указанных на сайте «Столото», в лотерейном центре в Москве или дождаться возобновления продаж онлайн.

        state: GetAnswer
            event: noMatch
            script: Webim.switch();


    state: ICantBuyBingoLotteries
        # Не могу купить Бинго-игры
        q!: * {$cantPastPresAll * $buyInf * [$ticket] * $bingoLotteries} *
        q!: * {$cantPastPresAll * $buyInf * [$lottery] * $bingoLotteries} *
        q!: * {$cantPastPresAll * ~ставка * $bingoLotteries} *
        q!: * {$want * $buyInf * $bingoLotteries} * (выкидывает/выбрасывает) *
        q!: * $no ~возможность $buyInf * $bingoLotteries *
        q!: * {$button * $buyInf * $activeNe * $bingoLotteries} *
        q!: * {~поле * $buyInf * $activeNe * $bingoLotteries} *
        q!: * {$buyInf * $activeNe * $bingoLotteries} *
        q!: * {$cantPastPres * $buyN * $bingoLotteries} *
        q!: * {$workFut * $buyN * $bingoLotteries} *
        q!: * {$when * $buyInf * $bingoLotteries} *
        q!: * {(~пустой ~экран) * $buyInf * $bingoLotteries} *
        q!: * {[$why] * $buyInfNe * [$ticket] * $bingoLotteries} *
        q!: * {[$why] * $buyInfNe * [$lottery] * $bingoLotteries} *
        q!: * {$buyPresRefl3Ne * [$ticket] * $bingoLotteries} *
        q!: * {[$ticket] * $buyPresRefl3 * долго * $bingoLotteries} *
        q!: * ($buyN/$buyInf) * $bingoLotteries * $error *
        q!: * $error * ($buyN/$buyInf) * $bingoLotteries *
        q!: * {$why * $nelzya * $buyInf * $bingoLotteries} *
        q!: * (невозможност*/недоступност*) $buyN * $bingoLotteries *
        q!: * ($ne доступн*/недоступн*) ($buyN/$ticket/$lottery) $bingoLotteries *
        q!: * ($buyN/$ticket/$lottery) $bingoLotteries ($ne доступн*/недоступн*) *
        q!: * недоступност* ($ticket/$lottery) $bingoLotteries *
        intent!: /Ticket/ICantBuyBingoLotteries
        if: $global.byuingBingoLotteriesIsAvailable
            script: Webim.switch();
        else:
            a: В системе онлайн-продаж произошло некорректное отображение информации. Мы работаем над возобновлением доступности игр.


    state: IBoughtTwoTimesTheSameTicket
        # Дважды купил один и тот же билет
        q!: * {повторно купилис* $ticketAndBet} *
        q!: * (программа/система) * продублировал* мою $bet *
        q!: * {$mistakenly $buyPastPres} $twoTickets *
        q!: * $ticket * {$buyPastPres дважды} *
        q!: * {$buyPastPres дважды} * $ticket *
        q!: * {$buyPastPres $ticket дважды} *
        q!: * {$buyPastPres ((один/1) [и тот же] $ticket) $twoTimes} *
        q!: * {$buyPastPres (одни и те же $ticket) $twoTimes} *
        q!: * {$buyPastPres (два $ticket) $twoTimes} *
        q!: * {$buyPastPres (одинаков* $ticketAndBet) $twoTimes} *
        q!: * {$buyPastPres ([одну/1] [и ту же] $bet) $twoTimes} *
        q!: * {$buyPastPres * ($Number одинаков* $ticketAndBet)} *
        q!: * {$buyPastPres * ((дв*/три/четыре/пять/нескольк*) одинаков* $ticketAndBet)} *
        q!: * {(получилос*/появилос*) * (($Number/дв*/три/четыре/пять/нескольк*) одинаков*)} *
        q!: * ($ne нужн*/$ne в первый раз) * {одинаков* $ticketAndBet} *
        q!: * (случайно/по ошибке/ненамеренно) * ($Number/дв*/три/четыре/пять/нескольк*) $ticket $with одинаков* *
        q!: * создал* $ticket $with одинаков* *
        q!: * {(у меня) (2/дв*) одинаков* $ticketAndBet} *
        q!: * {(2/дв*) (абсолютно одинаков*) $ticketAndBet} *
        q!: * куплено ((од*/1) [и тот же] $ticketAndBet) $twoTimes *
        q!: * $twoTimes $buyPastPres одно и (то же/тоже) *
        q!: * $twoTimes $payPast [за] одно и (то же/тоже) *
        q!: * {$payPast ([за] [один/1] [и тот же] $ticket) $twoTimes} *
        q!: * {$payPast ([за] одни и те же $ticket) $twoTimes} *
        q!: * {$payPast ([за] два $ticket) $twoTimes} *
        q!: * {$payPast ([за] одинаков* $ticketAndBet) $twoTimes} *
        q!: * {$payPast ([за] [одну/1] [и ту же] $bet) $twoTimes} *
        q!: * {набрал* ([за] [одну/1] [и ту же] $bet) $twoTimes} *
        q!: * {$payPast * ($Number одинаков* $ticketAndBet)} *
        q!: * {$payPast * ((дв*/три/четыре/пять/нескольк*) одинаков* $ticketAndBet)} *
        q!: * (поставил*/принял*) * ($Number одинаков* $ticketAndBet) *
        q!: * выбрал* одинаков* $bet *
        q!: * {случайно $buyPastPres $twoTimes} *
        q!: * {случайно $payPast $twoTimes} *
        q!: * случайно ($payPast/$buyPastPres) од* и (ту*/тот*/те*) *
        q!: * $ticket * {оплатилис* $twoTimes} *
        q!: * $ticket * {оплатилс* $twoTimes} *
        q!: * один и тот же $ticket оплатилс* *
        q!: * {$ticket * купилис* * $twoTimes} *
        q!: * {$ticket * купилс* * $twoTimes} *
        q!: * $ticketAndBet был* {$paid $twoTimes} *
        q!: * был* {$paid $twoTimes} $ticketAndBet *
        q!: * {$ticketAndBet $paid $twoTimes} *
        q!: * {$payment проходит $twoTimes} *
        q!: * {$payment прошла $twoTimes} *
        q!: * {$payment произошла $twoTimes} *
        q!: * {~списание произошло $twoTimes} *
        q!: * {$payment * $ticket * прошла * дважды} *
        q!: * {$payment снял* дважды} *
        q!: * {$payment списал* $twoTimes} *
        q!: * {(за [од*/1] $ticketAndBet) списан* ((двойн*/тройн*) $payment)} *
        q!: * {(за [од*/1] $ticketAndBet) списал* ((двойн*/тройн*) $payment)} *
        q!: * {$payment * $ticket * списал* * дважды} *
        q!: * {$buyN $ticket дважды} *
        q!: * {~сумма списал* дважды} *
        q!: * (уберите/убрать) $payment (за/на) повторн* $ticketAndBet *

        q!: * (~списание/снял*/списал*/списывал*) $twoTimes (за/на) ([од*/1] [и т* же] $ticketAndBet) *
        q!: * $twoTimes (~списание/снял*/списал*/списывал*) [$comMoney] (за/на) ([од*/1] [и т* же] $ticketAndBet) *
        q!: * (~списание/снял*/списал*/списывал*) [$comMoney] (за/на) ([од*/1] [и т* же] $ticketAndBet) $twoTimes *
        q!: * [$comMoney] (за/на) ([од*/1] [и т* же] $ticketAndBet) (снял*/списал*/списывал*) $twoTimes *

        q!: * $twoTimes (снял*/списал*/списывал*) $comMoney *
        q!: * взяли $twoTimes оплату *
        q!: * (двойн*/тройн*) $payment *
        q!: * $comMoney (снял*/списал*/списывал*) $twoTimes *
        q!: * (снял*/списал*/списывал*) $comMoney $twoTimes *
        q!: * {$comMoney [был*] списан* $twoTimes} *
        q!: * {ставка прошла $twoTimes} *
        q!: * {$buyN совершен* дважды} *
        q!: * {задвоил* ($ticket/$bet/$buyN/$lottery)} *
        q!: * (~задвоение/~дублирование) [одной и той же] $bet *
        q!: * (~задвоение/~дублирование) ($buyN/$ticket) *
        q!: * двойн* $buyN $ticket *
        q!: * ~задвоение $payment *
        q!: * {убрать ~задвоение} *
        q!: * {возникл* ~задвоение} *
        q!: * {произошл* ~задвоение} *
        q!: * (двойн*/тройн*) ~оплата од* и т* же ($ticket/$bet/$buyN/$lottery) *
        q!: * оказал* ($Number/две/три) одинаков* $buyN *
        q!: * ($buyPastPres/$payPast) $Number $ticket $with одинаков* ($bet/$numeral/числами) *

        intent!: /Ticket/IBoughtTwoTimesTheSameTicket
        a: Удалить купленные на сайте квитанции невозможно. Каждая оплата подтверждается отдельно, все проведенные оплаты соответствуют подтверждениям Вами этих оплат. Если Вы неоднократно подтвердили оплату, то получили несколько раз оформленный билет, только так может возникнуть задвоение.\n\nОбратите, пожалуйста, внимание на следующее. Если в момент покупки билета появляется сообщение об ошибке или рекомендация попробовать позже, при этом квитанции остались неоплаченными и с Кошелька списали деньги, проверьте, пожалуйста, наличие билетов в разделе «Купленные квитанции» позже. Билеты должны будут появиться.\n\nБлагодарим за понимание.​


    state: HowToCancelATicketPurchase
        # Как отменить покупку билета?
        q!: * {отменить * $buyN * $ticket} *
        q!: * {отменить * $buyN * $lottery} *
        q!: * {отменить * продажу * $ticket} *
        q!: * {отменить * продажу * $lottery} *
        q!: * {отменить * $payment * $ticket} *
        q!: * {отменить * $payment * $lottery} *
        q!: * {отменить * $paid * $ticket} *
        q!: * {отменить * $paid * $lottery} *
        q!: * {отменить * ($bet/заказ/оплату)} *
        q!: * {вернуть * $paid * $ticket} *
        q!: * {вернуть * $paid * $lottery} *
        q!: * {$buyPastPres * $ticket * отменить} *
        q!: * {$buyPastPres * $lottery * отменить} *
        q!: * {$payPast * $ticket * отменить} *
        q!: * {$payPast * $lottery * отменить} *
        q!: * отказат* от $ticket и вернуть $comMoney *
        intent!: /Ticket/HowToCancelATicketPurchase
        script: Webim.switch();


    state: FavoriteNumbers
        # Как выбрать любимые числа?
        q!: * $comWhat (такое/значит/означ*) [~функция/~опция/~фильтр] свои (номера/числа/$numeral) *
        q!: * [~функция/~опция/~фильтр] свои (номера/числа/$numeral) * $comWhat (она/он/это) (такое/значит/означ*) *
        q!: * {[$chooseInf] * $favoriteNumbers} *
        q!: * (набрать/$chooseInf) св* (номера/числа/$numeral) в $bingoLotteries *
        q!: * {(сам* (вписать/вписывать) (числа/$numeral)) * $bingoLotteries} *
        q!: * {$chooseInf * $numeral * $bingoLotteries} *
        q!: * {$chooseInf * числа * $bingoLotteries} *
        q!: * {$chooseInf * $manually * $bingoLotteries} *
        q!: * {$chooseInf * (номера боч*)} *
        intent!: /Ticket/FavoriteNumbers
        a: Билеты Бинго лотерей содержат готовую комбинацию чисел. При покупке данных билетов на сайте есть возможность выбрать любимые числа. В лотереях «Русское лото», «Золотая подкова» и «Жилищная лотерея» есть возможность выбрать до 7 любимых чисел. В лотерее «6 из 36» - до 3-х любимых чисел. Функция «Любимые числа» доступна только на основной версии сайта www.stoloto.ru.


    state: TicketDidntShowupInAccount
        # После оплаты билет не отобразился в ЛК
        q!: * {$error * ~отображение * ($ticket * [$generalNamedLottery])} *
        q!: * {$problem * ~отображение * ($ticket * [$generalNamedLottery])} *

        q!: * [$generalNamedLottery] * {(($ticket/~ставка) * [$generalNamedLottery]) * ($ne (появил*/появлял*/появляет*/появляют*)/непоявил*/непоявлял*/непоявляет*/непоявляют*/нипоявил*/нипоявлял*/нипоявляет*/нипоявляют*/$displayPresPl3Ne/$displayPresSg3Ne/$displayPastNe)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $waitInf * ($ticket/~ставка) * [$generalNamedLottery] * (появил*/отобразил*/отразил*) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * ($when/$howLong/долго) * {(($ticket/~ставка) * [$generalNamedLottery]) * (отражен/отражена/отражены/отображен/отображена/отображены/$displayFut3)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * (($ticket/~ставка) * [$generalNamedLottery]) * ($when/$howLong) * (отражен/отражена/отражены/отображен/отображена/отображены/$displayFut3) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $or $ticket $displayFut3 * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * ($ticket/~ставка) * [$generalNamedLottery] * (появил*/отображают*/отражают*/отобразил*/отразил*/отображены/отражены) (кроме/помимо/исключая) * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$displayPresSg3Ne $buyN} * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * (в [$comMy] $account) $ne одного $ticket * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $ne $ticketAll (в [$comMy] $account) * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$comNo [$again] [$comMy] [куплен*/оплачен*/никак*] $ticket (в [$comMy] $account)} * [$generalNamedLottery] *
        q!: * {(в [$comMy] $account) отсутств* ([куплен*/оплачен*/приобретен*/$comMy/$Number] $ticket)} *

        q!: * {($ticket (все равно/там/[у меня] так и) $comNo) * [$generalNamedLottery]} *

        # зарегистрировалась, билетов нет
        q!: * [$generalNamedLottery] * $registerPastRefl3 * $ticket ($comNo/отсутств*) * [$generalNamedLottery] *

        # Билета не в разделе купленных
        q!: * [$generalNamedLottery] * {([эт*] $ticket) ($comNo [там])} (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах/[$comMy] билеты/[$comMy] билетов/личк*) * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {его ($comNo [там])} (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах) * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy/зарегистр*] билетах/[$comMy] билеты/[$comMy] билетов) $comNo ($ticket/одного) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $ticket (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах/[$comMy] билеты/[$comMy] билетов/личк*) $comNo * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * (его/их) $ne (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах/[$comMy] билеты/[$comMy] билетов) * $only $Number * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * $ne все $bonusComePastPres (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах/[$comMy] билеты/[$comMy] билетов) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $ne стоит * (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/$comMy билетах) * [$generalNamedLottery] *



        #q!: * {$comWhere [находит*] [$again] [$comMy] [$Number] [куплен*/оплачен*] [мной/мною] $ticket} *
        q!: * $Number (куплен*/оплач*) [мной/мною] $ticket [$lottery] [$generalNamedLottery] $comWhere *
        q!: * из $Number (куплен*/оплач*/приобретен*) [мной/мною] $ticket в [личн*] кабинете *


        q!: * [$generalNamedLottery] * $when * ($ticket/он/они) * [$generalNamedLottery] * (отображен*/появит*/появят*/появля*/виден/видны) * в [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах/[$comMy] $account) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $when * (отображен*/появит*/появят*/появля*/виден/видны) * (куплен*/оплачен*/приобретен*) $ticket * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах) [все] $nothing * [$generalNamedLottery] *
        q!: * $findPastPresNe (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах) * $generalNamedLottery *

        q!: * [$generalNamedLottery] * (в/во) (разделе/графе/вкладке) [$comMy] билеты [все] $nothing * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * (в/во) (разделе/графе/вкладке) [$comMy] билеты горит $only * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$bonusComePastPresNe ([$paid] $ticket [$generalNamedLottery])} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$bonusComePastPresNe (в купленных)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$bonusComePastPresNe $buyN (в [$comMy] $ticket)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {($bonusComePastPresNe/$ne указан*/$ne отмечен*) * ($ticket * [$generalNamedLottery]) * ((в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах))} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * ((в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах)) * (он/они) * (отсутству*/$ne (значитс*/значитьс*/значатс*/значатьс*)/незначитс*/незначитьс*/низначитс*/низначитьс*/незначатс*/незначатьс*/низначатс*/низначатьс*) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $cantPastPresAll просмотреть [$comMy] [$Number] [куплен*/оплачен*] [мной/мною] $ticket * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {[$comMy/все] $ticket [у меня] $displayPresPl3Ne} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {([$comMy] $ticket) (у меня) $displayPresSg3Ne} * [$generalNamedLottery] *


        q!: * [$generalNamedLottery] * {[куплен*/оплачен*] [$Number] $ticket ($again/до сих [пор]/так и) $comNo} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {(куплен*/оплачен*) [$Number] $ticket отсутств*} * [$generalNamedLottery] *

        q!: * {($ticket * [$generalNamedLottery]) * ((в/во) (списке билетов/$oneWord все билеты)) * отсутств*} *

        q!: * [$generalNamedLottery] * {$payPast * ($ticketAndLottery/~пакет) * [$payment]} * {$receivedNe * $ticketAndLottery} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$payPast * ($ticketAndLottery/~пакет) * [$payment]} * {$comNo * ($ticketAndLottery/~пакет)} * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * ($buyPastPres/$payPast) * [$generalNamedLottery] * {$comNo $ticketAndLottery} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $why $comNo $ticket * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$buyN * $ticketAndLottery} * {$comNo * $ticketAndLottery} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$buyN * прошла} * {$comNo * $ticketAndLottery} * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery])} * $comNo * (его/их/ничего/на сайте/(в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах)) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery])} * (его/их/ничего/на сайте/(в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах)) * $comNo * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery])} * {$findPastPresNe * $ticket} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery])} * {$findPastPresNe (его/иво/их/ничего/на сайте/у меня [в] $account)} * [$generalNamedLottery] *
        q!: * {$payPast * $ticket * [$generalNamedLottery]} * куда * (делся/делись/деться/дется/девается/деваются) *
        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery])} * {$receivePastNe * $ticket} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery])} * {$bonusComePastPresNe * ($ticket/он/они) * [$receipt]} *
        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery])} * {$receivePastNe * (его/иво/их/ничего) * [$receipt]} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$findPastPresNe [я] [$comMy] $ticket} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {[так и/все еще] $findPastPresNe $ticket} * [$generalNamedLottery] *

        q!: * {$payPast * $ticketAndLottery * [$generalNamedLottery]} * тишина *
        q!: * {$buyPastPres * $ticketAndLottery * [$generalNamedLottery]} * тишина *
        q!: * {$payPast * $ticket * [$generalNamedLottery]} * отсутств* *
        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * отсутств* *


        q!: * {$payPast * $ticket * [$generalNamedLottery]} * $comWhere [же] ($ticket/он/они) *
        q!: * {$payPast * $ticket * [$generalNamedLottery]} * ($ticket/он/они) $comWhere *
        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * $comWhere [же] ($ticket/он/они) *
        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * ($ticket/он/они) $comWhere *

        q!: * {$buyPastPres * $ticketAndLottery * [$generalNamedLottery]} * $receivedNe * $ticketAndLottery * [$generalNamedLottery] *
        q!: * {$buyPastPres * $ticketAndLottery * [$generalNamedLottery]} * $ticketAndLottery * $receivedNe * [$generalNamedLottery] *
        q!: * {$buyPastPres * ~пакет * [$generalNamedLottery]} * $receivedNe * $ticketAndLottery * [$generalNamedLottery] *
        q!: * {$buyPastPres * ~пакет * [$generalNamedLottery]} * $ticketAndLottery * $receivedNe * [$generalNamedLottery] *

        q!: * {$buyPastPres * $ticketAndLottery * [$generalNamedLottery]} * $comNo * $ticketAndLottery * [$generalNamedLottery] *
        q!: * {$buyPastPres * $ticketAndLottery * [$generalNamedLottery]} * $ticketAndLottery * $comNo * [$generalNamedLottery] *
        q!: * {$buyPastPres * ~пакет * [$generalNamedLottery]} * $comNo * $ticketAndLottery * [$generalNamedLottery] *
        q!: * {$buyPastPres * ~пакет * [$generalNamedLottery]} * $ticketAndLottery * $comNo * [$generalNamedLottery] *

        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * $comNo * (его/их/ничего/на сайте/(в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах)) * [$generalNamedLottery] *
        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * (его/их/ничего/на сайте/(в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах)) * $comNo * [$generalNamedLottery] *

        q!: * {беру * $ticket * [$generalNamedLottery]} * $comNo * (его/их/ничего/на сайте) * [$generalNamedLottery] *
        q!: * {беру * $ticket * [$generalNamedLottery]} * (его/их/ничего/на сайте) * $comNo * [$generalNamedLottery] *

        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * (его/иво/их) ($ne оказалос*/неоказалос*/ниоказалос*) * [$generalNamedLottery] *
        q!: * {$payPast * $ticket * [$generalNamedLottery]} * (его/иво/их) ($ne оказалос*/неоказалос*/ниоказалос*) * [$generalNamedLottery] *

        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * $findPastPresNe * $ticket * [$generalNamedLottery] *
        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * $ticket * $findPastPresNe * [$generalNamedLottery] *

        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * $bonusComePastPresNe * ($ticket/он/они) * [$receipt] * [$generalNamedLottery] *
        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * ($ticket/он/они) * $bonusComePastPresNe * [$receipt] * [$generalNamedLottery] *

        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * $findPastPresNe (его/их/ничего/на сайте/у меня [в] $account) * [$generalNamedLottery] *
        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * (его/их/ничего/на сайте/у меня [в] $account) $findPastPresNe * [$generalNamedLottery] *

        q!: * {$buyPastPres * ~пакет * [$generalNamedLottery]} * $findPastPresNe (его/их/ничего/на сайте/у меня [в] $account) * [$generalNamedLottery] *
        q!: * {$buyPastPres * ~пакет * [$generalNamedLottery]} * (его/их/ничего/на сайте/у меня [в] $account) $findPastPresNe * [$generalNamedLottery] *
        q!: * {$payPast * ~пакет * [$generalNamedLottery]} * $findPastPresNe (его/их/ничего/на сайте/у меня [в] $account) * [$generalNamedLottery] *
        q!: * {$payPast * ~пакет * [$generalNamedLottery]} * (его/их/ничего/на сайте/у меня [в] $account) $findPastPresNe * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * $buyPastPres * [$generalNamedLottery] * {(в $application) $findPastPresNe}

        q!: * [$generalNamedLottery] * $payPast * $ticket * [$generalNamedLottery] * {(в $application) $findPastPresNe} *
        q!: * [$generalNamedLottery] * $ticket * [$generalNamedLottery] * $payPast * {(в $application) $findPastPresNe} *

        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * куда * (делс*/делис*/детьс*/детс*/девае*/деваю*) * [$generalNamedLottery] *

        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * $receivePastNe * ($ticket/его/их/ничего) * [$receipt] * [$generalNamedLottery] *
        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * ($ticket/его/их/ничего) * $receivePastNe * [$receipt] * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * $displayPres3 $only один $ticket * [$generalNamedLottery] *
        q!: * {$payPast * $ticket * [$generalNamedLottery]} * ($bonusComePastPres/$displayPres3/добавил*/отображен*/высветилс*/моих билетах/на сайте/виден/в [$comMy] $account) [$only] ($Number/один/два) * [$generalNamedLottery] *
        q!: * {$payPast * ~пакет * [$generalNamedLottery]} * ($bonusComePastPres/$displayPres3/добавил*/отображен*/высветилс*/на сайте/виден/в [$comMy] $account) [$only] ($Number/один/два) * [$generalNamedLottery] *


        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * ($bonusComePastPres/$displayPres3/добавил*/отображен*/высветилс*/моих билетах/на сайте/виден/в [$comMy] $account) [$only] ($Number/один/два) * [$generalNamedLottery] *
        q!: * {$buyPastPres * ~пакет * [$generalNamedLottery]} * ($bonusComePastPres/$displayPres3/добавил*/отображен*/высветилс*/на сайте/виден/в [$comMy] $account) [$only] ($Number/один/два) * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * ($buyPastPres/$payPast/$moneyTakeOffPastPres) * [$generalNamedLottery] * $ticket [в $application] $only * [$generalNamedLottery] *


        q!: * {$payPast * $ticket * [$generalNamedLottery]} * (1/один) * ($bonusComePastPres/$displayPres3/добавил*/отображен*/высветилс*/моих билетах/виден) * [$generalNamedLottery] *
        q!: * {$payPast * ~пакет * [$generalNamedLottery]} * (1/один) * ($bonusComePastPres/$displayPres3/добавил*/отображен*/высветилс*/моих билетах/виден) * [$generalNamedLottery] *


        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * (1/один) * ($bonusComePastPres/$displayPres3/добавил*/отображен*/высветилс*/моих билетах/виден) * [$generalNamedLottery] *
        q!: * {$buyPastPres * ~пакет * [$generalNamedLottery]} * (1/один) * ($bonusComePastPres/$displayPres3/добавил*/отображен*/высветилс*/моих билетах/виден) * [$generalNamedLottery] *


        q!: * {$payPast * $ticket * [$generalNamedLottery]} * ($findPastPres/$receivePast) [$only] ($Number/один) * [$generalNamedLottery] *
        q!: * {$payPast * ~пакет * [$generalNamedLottery]} * ($findPastPres/$receivePast) [$only] ($Number/один) * [$generalNamedLottery] *


        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * ($findPastPres/$receivePast) [$only] ($Number/один) * [$generalNamedLottery] *
        q!: * {$buyPastPres * ~пакет * [$generalNamedLottery]} * ($findPastPres/$receivePast) [$only] ($Number/один) * [$generalNamedLottery] *

        q!: * {$buyPastPres * ($Number $ticket) * [$generalNamedLottery]} * один есть *
        q!: * {$payPast * ($Number $ticket) * [$generalNamedLottery]} * один есть *

        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * получ* * у меня * $Number $ticket * [$generalNamedLottery] *


        q!: * {$payPast * $ticket * [$generalNamedLottery]} * в $account $ticket (~ноль/~нуль/0) * [$generalNamedLottery] *
        q!: * {$payPast * ~пакет * [$generalNamedLottery]} * в $account $ticket (~ноль/~нуль/0) * [$generalNamedLottery] *

        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * в $account $ticket (~ноль/~нуль/0) * [$generalNamedLottery] *
        q!: * {$buyPastPres * ~пакет * [$generalNamedLottery]} * в $account $ticket (~ноль/~нуль/0) * [$generalNamedLottery] *

        q!: * {$payPast * $ticketAndLottery * [$generalNamedLottery]} * $comNo в $account *
        q!: * {$buyPastPres * $ticketAndLottery * [$generalNamedLottery]} * $comNo в $account *


        q!: * [$generalNamedLottery] * {$comMoney * ($ticket * [$generalNamedLottery]) * $bonusDisappearPastPres} * $bonusComePastPresNe * ($ticket/он/они) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$comMoney * ($ticket * [$generalNamedLottery]) * $bonusDisappearPastPres} * ($ticket/он/они) * $bonusComePastPresNe * [$generalNamedLottery] *


        q!: * $payPast * [$generalNamedLottery] * {$ticket [мне] ($ne дали)} *
        q!: * [$generalNamedLottery] * {$ticket [мне] ($ne дали)} * $payPast *

        q!: * [$generalNamedLottery] * {$findPastPresNe $ticket} * [$generalNamedLottery] * ($payPast/$buyPastPres) *
        q!: * ($payPast/$buyPastPres) * [$generalNamedLottery] * {$findPastPresNe $ticket} * [$generalNamedLottery] *


        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * $comNo * $ticketAndLottery *
        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * $ticketAndLottery * $comNo *


        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * $bonusComePastPresNe * $ticketAndLottery *
        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * $ticketAndLottery * $bonusComePastPresNe *


        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * $comNo * $ticketAndLottery *
        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * $ticketAndLottery * $comNo *


        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * $bonusComePastPresNe * $ticketAndLottery *
        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * $ticketAndLottery * $bonusComePastPresNe *


        q!: * {$moneyTakeOffPastPres * $numberRub * [$generalNamedLottery]} * $comNo * $ticketAndLottery *
        q!: * {$moneyTakeOffPastPres * $numberRub * [$generalNamedLottery]} * $ticketAndLottery * $comNo *


        q!: * {$moneyTakeOffPastPres * (за $ticketAndLottery) * [$generalNamedLottery]} * $comNo * $ticketAndLottery *
        q!: * {$moneyTakeOffPastPres * (за $ticketAndLottery) * [$generalNamedLottery]} * $ticketAndLottery * $comNo *

        q!: * {$moneyTakeOffPastPres * ($ticket * [$generalNamedLottery]) * $givePastPresPl3Ne} *
        q!: * {$moneyTakeOffPastPres * $comMoney * [$generalNamedLottery]} * {$ticket * $receivePastNe} * [$generalNamedLottery] *


        q!: * {$payPast * ($ticket * [$generalNamedLottery]) * $givePastPresPl3Ne} * [$generalNamedLottery] *

        q!: * {оплач* * ($ticket * [$generalNamedLottery]) * $givePastPresPl3Ne} * [$generalNamedLottery] *
        q!: * {(пыта* $payInf) * ($ticket * [$generalNamedLottery]) * $givePastPresPl3Ne} * [$generalNamedLottery] *


        q!: * {$comMoney * взяли * [$generalNamedLottery]} * {$ticket * $givePastPresPl3Ne} * [$generalNamedLottery] *


        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * [$generalNamedLottery] * $findPastPresNe * $ticketAndLottery * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * [$generalNamedLottery] * $ticketAndLottery * $findPastPresNe * [$generalNamedLottery] *


        q!: * $findPastPresNe * ($ticketAndLottery * [$generalNamedLottery]) * {$comMoney [$fromWallet] $bonusDisappearPastPres} *
        q!: * ($ticketAndLottery * [$generalNamedLottery]) * $findPastPresNe * {$comMoney [$fromWallet] $bonusDisappearPastPres} *

        q!: * [$generalNamedLottery] * {$comMoney [$fromWallet] $bonusDisappearPastPres} * $findPastPresNe * $ticketAndLottery *
        q!: * [$generalNamedLottery] * {$comMoney [$fromWallet] $bonusDisappearPastPres} * $ticketAndLottery * $findPastPresNe *


        q!: * {$payPast * ($comWhere [$oneWord] [$comMy] $ticket) * [$generalNamedLottery]} *
        q!: * {$payPast * $ticket * [$generalNamedLottery]} * $comWhere (он/они) *
        q!: * {$buyPastPres  * ($comWhere [$oneWord] [$comMy] $ticket) * [$generalNamedLottery]} *
        q!: * {$buyPastPres * $ticket * [$generalNamedLottery]} * $comWhere (он/они) *


        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * [$generalNamedLottery] * ($comWhere [$oneWord] [$comMy] $ticket) *

        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * [$generalNamedLottery] * ($comWhere [$oneWord] [$comMy] $ticket) *


        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * $bonusComePastPresNe * $ticket * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * $ticket * $bonusComePastPresNe * [$generalNamedLottery] *


        q!: * [$generalNamedLottery] * {$comMoney [$fromWallet] $bonusDisappearPastPres} * ($comWhere [$oneWord] [$comMy] $ticket) *
        q!: * [$generalNamedLottery] * {$comMoney [$fromWallet] $moneyTakeOffPastPres} * ($comWhere [$oneWord] [$comMy] $ticket) *

        q!: * [$generalNamedLottery] * {$comMoney [$fromWallet] $moneyTakeOffPastPres} * $bonusComePastPresNe * $ticket * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$comMoney [$fromWallet] $moneyTakeOffPastPres} * $ticket * $bonusComePastPresNe * [$generalNamedLottery] *


        q!: * [$generalNamedLottery] * {($ticket * [$generalNamedLottery]) * $bonusComePastPresNe * (в [$comMy] $account)} * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$cantPastPres * $findInf * $ticket} * [$generalNamedLottery] *


        q!: * [$generalNamedLottery] * $comWhere * $findInf * (куплен*/оплачен*) $ticket * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$findPastPresNe * ($ticket * [$generalNamedLottery]) * (в [$comMy] $account)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$findFut1Ne * ($ticket * [$generalNamedLottery]) * (в [$comMy] $account)} * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery]) * $bonusComePastPresNe} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery]) * $usingExternalResource * $bonusComePastPresNe} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery]) * $usingExternalResource} * в [раздел*] (куплен*/оплачен*/приобретен*/[$comMy] билетах/[$comMy] билеты/[$comMy] билетов) $comNo * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$payment * ($ticket * [$generalNamedLottery]) * $usingExternalResource * $bonusComePastPresNe} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery]) * $fromExternalResource * $bonusComePastPresNe} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$payPast * ($ticket * [$generalNamedLottery]) * $fromExternalResource} * в [раздел*] (куплен*/оплачен*/приобретен*/[$comMy] билетах/[$comMy] билеты/[$comMy] билетов) $comNo * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$payment * ($ticket * [$generalNamedLottery]) * $fromExternalResource * $bonusComePastPresNe} * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * $buyPastPres * [$generalNamedLottery] * {(в $account) * $moneyAddPartPasNe} *
        q!: * [$generalNamedLottery] * $payPast * $ticket * [$generalNamedLottery] * {(в $account) * $moneyAddPartPasNe} *
        q!: * [$generalNamedLottery] * $ticket * [$generalNamedLottery] * $payPast * [$generalNamedLottery] * {(в $account) * $moneyAddPartPasNe} *


        q!: * {($buyN * $ticket * [$generalNamedLottery]) * $fromExternalResource * $bonusComePastPresNe} *

        q!: * [$generalNamedLottery] * {$buyPastPres * ($ticket * [$generalNamedLottery]) * $bonusComePastPresNe} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$payment * ($ticket * [$generalNamedLottery]) * $bonusComePastPresNe} * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {(~возврат сум*) * ($ticket * [$generalNamedLottery]) * $bonusComePastPresNe} * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$ticket [так и/до сих пор/еще] $bonusComePastPresNe} * [$generalNamedLottery] *


        q!: * [$generalNamedLottery] * $comNo * {(куплен*/оплачен*) [$oneWord] $ticket} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {(куплен*/оплачен*) [$oneWord] $ticket} * $comNo *


        q!: * [$generalNamedLottery] * {$findPastPresNe * ((куплен*/оплачен*) [$oneWord] $ticket)} * [$generalNamedLottery] *

        #q!: * {$bonusDisappearPastPres * $ticket} *


        q!: * [$generalNamedLottery] * {($ne [сам*] $ticketAndLottery) ($ne [~возврат] $comMoney)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {($ne [сам*] $ticketAndLottery) ($ne $receipt)} * [$generalNamedLottery] *


        q!: * [$generalNamedLottery] * {($returnImp/вернутс*/вернутьс*) * ($or [$comMy] $comMoney) * ($or [$comMy] $ticketAndLottery)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$giveImp * ($or [$comMy] $comMoney) * ($or [$comMy] $ticketAndLottery)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$returnFutPl23 * ($or [$comMy] $comMoney) * ($or [$comMy] $ticketAndLottery)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * ($returnImp/$askYou вернуть/вернутс*/вернутьс*/$returnFutPl23) [мне] {([$comMy] $comMoney) $or ([$comMy] $ticketAndLottery)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$sendMeImp * ($or [$comMy] $comMoney) * ($or [$comMy] $ticketAndLottery)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$duplicateInfPerf * ($or [$comMy] $comMoney) * ($or [$comMy] $ticketAndLottery)} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$sendMeInfPerf * ($or [$comMy] $comMoney) * ($or [$comMy] $ticketAndLottery)} * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * $comWhere * $comMoney и $ticketAndLottery * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * {$returnImp * $comMoney} * $ticketAndLottery * $bonusComePastPresNe * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * (появлен*/~отображение) [$oneWord] $ticketAndLottery * [$generalNamedLottery] *



        q!: * [$generalNamedLottery] * $waitInf * $paid * $ticketAndLottery * [$generalNamedLottery] *

        q!: * [$generalNamedLottery] * $account $ticketGen там * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * (пишу из/я в) $account * $ticketGen (там/$comNo) *


        q!: * [$generalNamedLottery] * {$comMoney * $moneyTakeOffPastPres} * {$ticket $comNo} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {$ticket $comNo} * {$comMoney * $moneyTakeOffPastPres} * [$generalNamedLottery] *

        q!: * {все ([$comMy] $ticket) $displayPresPl3Ne} *
        q!: * [$generalNamedLottery] * $why (высвеч*/отобража*) $Number $ticket *
        q!: * [$generalNamedLottery] * $comWhere остальные $Number $ticket * [$generalNamedLottery] *
        q!: * сделайте * $forTo * (он/они/$ticket) * был* * в $account *
        #q!: * {$smsComePastNe * $ticket} * {[$sms] * [$smsComePast]} *

        # Деньги списали, билет не появился
        q!: * [$generalNamedLottery] * $moneyWasDebited * [$generalNamedLottery] * $noTicket2 * [$generalNamedLottery] *

        # Бонусы списали, билет не появился
        q!: * [$generalNamedLottery] * $bonusesWereDebited * [$generalNamedLottery] * $noTicket * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $noTicket * [$generalNamedLottery] * $bonusesWereDebited * [$generalNamedLottery] *

        # Билет, купленный за спецбонус, не появился
        q!: * [$generalNamedLottery] * $ticket * [$generalNamedLottery] * $paid * $forBonuses * ($comNo/$bonusComePastPresNe/исчез*/делс*/делис*/$comWhere) * [$generalNamedLottery] *
        # у меня так и не появился билет оплаченный спец бонусом
        q!: * [$generalNamedLottery] * ($comNo/$bonusComePastPresNe/исчез*/делс*/делис*/$comWhere) * $ticket * [$generalNamedLottery] * $paid * ($forBonuses/$bonus/$specialBonus) * [$generalNamedLottery] *

        intent!: /Ticket/TicketDidntShowupInAccount
        if: $global.ticketInAccountIsAvailable
            #a: На момент Вашего обращения были сложности с оплатой билетов на сайте. Сейчас все работает в штатном режиме. Если в течение суток билет не отобразился в Вашем личном кабинете, то в течение 5 рабочих дней средства за незарегистрированные билеты будут возвращены на счет, с которого происходила оплата. Пожалуйста, ожидайте.
            if: $parseTree._matchball
                script: Webim.switch();

            elseif: $parseTree._generalNamedLottery && $parseTree._fromExternalResource || $parseTree._generalNamedLottery && $parseTree._usingExternalResource || $parseTree._generalNamedLottery && $parseTree._fromWallet
                a: Уточните, пожалуйста, Ваши регистрационные данные (номер телефона и адрес электронной почты), дату и время покупки.

            elseif: $parseTree._generalNamedLottery && !$parseTree._fromExternalResource || $parseTree._generalNamedLottery && !$parseTree._usingExternalResource || $parseTree._generalNamedLottery && !$parseTree._fromWallet
                a: Уточните, пожалуйста, Ваши регистрационные данные (номер телефона и адрес электронной почты), а также способ оплаты, дату и время покупки.

            elseif: !$parseTree._generalNamedLottery && $parseTree._fromExternalResource || !$parseTree._generalNamedLottery && $parseTree._usingExternalResource || !$parseTree._generalNamedLottery && $parseTree._fromWallet
                a: Уточните, пожалуйста, Ваши регистрационные данные (номер телефона и адрес электронной почты), а также название лотереи, дату и время покупки.

            else:
                a: Уточните, пожалуйста, Ваши регистрационные данные (номер телефона и адрес электронной почты), а также название лотереи, способ оплаты, дату и время покупки.

        else:
            a: Отображение купленных билетов в личных кабинетах производится с задержкой. А пока мы работаем над устранением этой проблемы, пожалуйста, не дублируйте Ваши оплаты после того, как первая попытка не удалась. Мы просим немного Вашего терпения и обещаем, что очень скоро платежи станут проходить так же быстро, как и всегда.
            #a: Отображение купленных билетов в личных кабинетах производится с задержкой. А пока мы работаем над устранением этой проблемы, пожалуйста, не дублируйте ваши оплаты после того, как первая попытка не удалась. Наши специалисты уже работают над исправлением ситуации. Приносим извинения за доставленные неудобства.


        state: GetData || fromState = /Ticket/TicketDidntShowupInAccount
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            q: * $generalNamedLottery *
            event: noMatch
            script: Webim.switch();


    state: TheTicketIsRegisteredForALongTime
        # Задержка в регистрации билета
        q!: * (идет $registration ваш*/$waitPres1 $registration [$comMy]) ($ticket/$buyN/ставк*/~пакет) *

        q!: * {($error/$problem/$cantPastPres) * ($registration [$comMy] ($ticket/$buyN/ставк*/~пакет))} *


        q!: * ($buyPastPres/$payPast) * {идет $registration} *


        q!: * $payment (прошла/прошел) а $registration $comNo *
        q!: * $comNo $registration [$comMy] ($ticket/$buyN/ставк*/~пакет) *
        q!: * {$ticket $registeredNe} *


        q!: * {$why * $slowly * оформляют* * $ticketAndLottery} *
        q!: * (висит/завис/зависл*) * ($registration/оформление) * ($buyN/$ticketAndLottery/ставк*/~пакет) *
        q!: * $slowly * $passPres * $registration * ($ticketAndLottery/~ставка/~пакет) *
        q!: * $registration [$comMy] ($buyN/$ticketAndLottery/ставк*/~пакет) * (длит*/идет/продолжает*) (более/больше/минут) *
        q!: * $registration [$comMy] ($buyN [$oneWord]/$ticketAndLottery/ставк*/~пакет) (более/больше) *
        q!: * ($buyN/$ticketAndLottery/ставк*/~пакет) $registerPresRefl3 (уже/почти/более/больше) *
        q!: * ($ne (появил*/появлял*/появляет*/появляют*)/непоявил*/непоявлял*/непоявляет*/непоявляют*/нипоявил*/нипоявлял*/нипоявляет*/нипоявляют*/$displayPresPl3Ne/$displayPresSg3Ne/$displayPastNe) * (инф* $about $registration * ($ticket/$buyN/ставк*/~пакет)) *

        q!: * {$delay * ($registration/~оформление) * ($buyN/$ticketAndLottery/ставк*/~пакет)} *

        q!: * {$registerPres3Ne * ($ticket/$buyN/ставк*/~пакет)} *

        q!: * {($ticket/$buyN/ставк*/~пакет) * ($registerPresRefl3/$registerPres3) * $slowly} *

        q!: * {$transferPartPas * $ticket * $registerPastPerfNe} *
        q!: * {$moneyTakeOffPastPres * $ticket * $registerPastPerfNe} *
        q!: * {$moneyTakeOffPastPres * $ticket * $registeredNe} *
        q!: * {$payPast * $ticket * $registerPastPerfNe} *
        q!: * {$payPast * $ticket * $registeredNe} *
        q!: * {оплач* * $ticket * $registerPastPerfNe} *
        q!: * {оплач* * $ticket * $registeredNe} *
        q!: * {(пыта* $payInf) * $ticket * $registerPastPerfNe} *
        q!: * {(пыта* $payInf) * $ticket * $registeredNe} *

        q!: * ($buyN/транзакц*/$payment) * (прошла/прошел) * $ticketAndBet * ($registerPastPerfNe/$registeredNe) *
        q!: * ($buyN/транзакц*/$payment) * (прошла/прошел) * ($registerPastPerfNe/$registeredNe) * $ticketAndBet *
        q!: * (прошла/прошел) * ($buyN/транзакц*/$payment) * $ticketAndBet * ($registerPastPerfNe/$registeredNe) *
        q!: * (прошла/прошел) * ($buyN/транзакц*/$payment) * ($registerPastPerfNe/$registeredNe) * $ticketAndBet *
        q!: * ($registerPastPerfNe/$registeredNe) * $ticketAndBet * ($buyN/транзакц*/$payment) * (прошла/прошел) *
        q!: * ($registerPastPerfNe/$registeredNe) * $ticketAndBet * (прошла/прошел) * ($buyN/транзакц*/$payment) *
        q!: * $ticketAndBet * ($registerPastPerfNe/$registeredNe) * ($buyN/транзакц*/$payment) * (прошла/прошел) *
        q!: * $ticketAndBet * ($registerPastPerfNe/$registeredNe) * (прошла/прошел) * ($buyN/транзакц*/$payment) *
        q!: * $comMoney * $returnPastNe * {$registeredNe * $ticketAndBet} *
        q!: * $returnPastNe * $comMoney * {$registeredNe * $ticketAndBet} *
        q!: * {$registeredNe $ticketAndBet} * возникл* $error *
        q!: * {$registeredNe * $ticketAndBet} * $comMoney * $returnPastNe *
        q!: * {$registeredNe * $ticketAndBet} * $returnPastNe * $comMoney *
        q!: * {$comNo ($registration $ticketAndBet)} *
        q!: * {$cantPastPres * ($registration $ticketAndBet)} *
        q!: * $ticketAndBet ($ne (прошел/прошли)/непрошел/непрошли/нипрошел/нипрошли) $registration *
        q!: * $ticketAndBet $registration ($ne (прошел/прошли)/непрошел/непрошли/нипрошел/нипрошли) *
        intent!: /Ticket/TheTicketIsRegisteredForALongTime
        if: $global.ticketRegistrationIsAvailable
            script: Webim.switch();
        else:
            a: На настоящий момент регистрация билетов в личном кабинете производится с задержкой. Ваш платеж может пройти успешно, и билет будет отображен в личном кабинете. Если в процессе регистрации билетов возникли ошибки, то средства за незарегистрированные билеты будут возвращены на счет, с которого происходила оплата. Наши специалисты уже работают над выяснением причины. Приносим извинения за доставленные неудобства.


    state: HowToGiveATicket
        # Как подарить билет
        q!: *дарить другу
        q!: $how *дарить [близким]
        q!: * {$how * *дарить * $ticketAndLottery * [$buyInf]} *
        q!: * {$want * *дарить * $ticketAndLottery * [$buyInf]} *
        q!: * {$possiblePredicAll * *дарить * $ticketAndLottery * [$buyInf]} *
        q!: * {могу * *дарить * $ticketAndLottery * [$buyInf]} *
        q!: * ($how/$want/$possiblePredicAll/могу) * {отправить * $ticketAndLottery * (в подарок)} *
        intent!: /Ticket/HowToGiveATicket
        a: Для этого есть два способа.\n\nНа странице лотереи: выберите числа или билет на странице лотереи, нажмите на кнопку «Подарить другу», после чего введите контакты получателя и отправьте подарочный билет.\n\nНа странице билета в мобильном приложении: выберите числа, нажмите на значок подарка, введите номер телефона друга и оплатите билет.\n\nВ разделе «Подари билет»: ссылка на раздел есть в нижней части главной страницы сайта. Подробную видеоинструкцию смотрите по ссылке https://www.youtube.com/watch?v=j6pmrIMTURU . В этом случае Вы можете подарить сразу несколько билетов и приложить к ним открытку.\n\nПожалуйста, проверяйте правильность указанного номера получателя, так как в дальнейшем данный телефонный номер невозможно будет изменить.


    state: HowToGiveAPaidTicket
        # Как подарить оплаченный билет
        q!: * {$how * *дарить * $paid * $ticketAndLottery} *
        q!: * {$want * *дарить * $paid * $ticketAndLottery} *
        q!: * {$possiblePredicAll * *дарить * $paid * $ticketAndLottery} *
        q!: * {[могу] * *дарить * $paid * $ticketAndLottery} *
        q!: * (купил*/приобрел*/оплатил*) * $ticketAndLottery * *дарить *
        intent!: /Ticket/HowToGiveAPaidTicket
        a: К сожалению, подарить уже приобретенный билет не представляется возможным.


    state: HowToChangeATicket
        # Как поменять билет
        q!: * {$exchangeInf * $ticket} *
        q!: * $ne на тот $ticketRun *
        q!: * {сдать * $ticket} *
        q!: * вернуть $ticket *
        intent!: /Ticket/HowToChangeATicket
        a: К сожалению, успешно оплаченные билеты невозможно изменить, отменить или обменять. Каждый билет учтен в призовом фонде тиража в соответствии с заключенным Вами договором с оператором лотереи.\n\nВы можете проверить билеты после розыгрыша. Надеемся, они окажутся для Вас счастливыми.


    state: HowToDeleteTickets
        # Как удалить билеты?
        q!: * {$deleteInf * $ticket} *
        q!: * {$deleteInf * архив} *
        q!: * (очистить/отчистить) * (($old/$played) $ticket) *
        q!: * (($old/$played) $ticket) * (очистить/отчистить) *
        intent!: /Ticket/HowToDeleteTickets
        a: Самостоятельное удаление квитанций невозможно: они автоматически перемещаются в архив по истечении 180 дней с момента проведения тиража.


    state: HowToDeleteTicketsFromBasket
        # Как удалить билеты из корзины
        q!: * {$deleteInf * $ticket * (из $basket)} *
        q!: * {$deleteInf * $ticket * ($with $basket)} *
        q!: * {$deleteInf * ~товар * (из $basket)} *
        q!: * {$deleteInf * ~товар * ($with $basket)} *
        intent!: /Ticket/HowToDeleteTicketsFromBasket
        a: Для удаления билета наведите на него курсор мыши, после этого появится иконка корзины справа от вкладки «Оплатить». После нажатия на эту кнопку выбранный билет будет удален.\n\nЕсли в корзине есть несколько билетов, Вы можете удалить сразу все или только выбранные. Для выбора ненужных билетов поставьте галочки рядом с номерами тиражей, после этого нажмите на кнопку в виде корзины (находится справа от вкладки «Стоимость»). Билеты будут удалены. Если нужно удалить все билеты, то сразу нажмите на кнопку в виде корзины справа от вкладки «Стоимость».


    state: HowToPutATicketInTheBasket
        # Как положить билет в корзину
        q!: * {$putInf * $ticket * (в $basket)} *
        intent!: /Ticket/HowToPutATicketInTheBasket
        a: Для того, чтобы положить билеты в Корзину, Вам необходимо выбрать понравившуюся Вам комбинацию в нужной лотерее. Например, в «6 из 45». Далее, справа, на странице формирования билета нажмите на кнопку «В корзину». Готово. Выбранная Вами комбинация теперь в Корзине, ждет оплаты. Если Вы не желаете ограничиваться одной комбинацией, можете повторить процедуру. В Корзину можно добавлять билеты разных лотерей.\n\nОбращаем Ваше внимание, что билеты таких лотерей, как «Золотая подкова», «6 из 36», «Жилищная лотерея», «Бинго-75» и «Русское лото» могут храниться в Корзине не более 24 часов.


    state: HowLongIsTheTicketStoredInTheBasket
        # Сколько времени хранится билет в корзине?
        q!: * $howLong2 * {($savePres3/лежать) * $ticketAndLotteryAll * $basket} *
        q!: * $ticketAndLotteryAll * {$howLong2 * ($savePres3/лежать) * $basket} *
        q!: * $basket * {$howLong2 * ($savePres3/лежать) * $ticketAndLotteryAll} *

        q!: * ($skolko [часов]) * {($savePres3/лежать) * $ticket * $basket} *
        q!: * $ticket * {($skolko [часов]) * ($savePres3/лежать) * $basket} *
        q!: * $basket * {($skolko [часов]) * ($savePres3/лежать) * $ticket} *

        q!: * (ложил*/положил*/отложил*/сохранил*/помещал*/поместил*/собрал*) * $ticketAndLotteryAll * {$basket * пуст*} *
        q!: * $ticketAndLotteryAll * (ложил*/положил*/отложил*/сохранил*/помещал*/поместил*/собрал*) * {$basket * пуст*} *
        q!: * (ложил*/положил*/отложил*/сохранил*/помещал*/поместил*/собрал*) * $ticketAndLotteryAll * $basket * их {там $comNo} *
        q!: * (ложил*/положил*/отложил*/сохранил*/помещал*/поместил*/собрал*) * $basket * $ticketAndLotteryAll * их {там $comNo} *

        q!: * {$ticketAndLotteryAll * $savePres3ReflNe * $basket} *
        q!: * отлож* $ticket * {$basket * (пропал*/пропада*)} *
        intent!: /Ticket/HowLongIsTheTicketStoredInTheBasket
        a: Положить билеты в Корзину могут только зарегистрированные пользователи. Для этого Вам необходимо авторизоваться на сайте Столото. Билеты лотерей с многомиллионными выигрышами хранятся в корзине до момента оплаты (но если Вы положили в корзину билет на спецвыпуск, то оплатить билет нужно до начала этого выпуска), билеты лотерей с ТВ-трансляцией хранятся не более 24 часов.

    #state: HowLongCanIBuyABirthdayTicket
        # До какого времени можно купить билет на  тираж по случаю дня рождения
        #q!: * до ~какой (~время/~число/~день) * {$buyInf * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * ($birthdayRL/$anniversaryDraw2) * до ~какой (~время/~число/~день) * $buyInf *
        #q!: * когда * {$buyInf * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$buyInf * [$ticket] * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * могу * {$buyInf * [$ticket] * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * ($birthdayRL/$anniversaryDraw2) * когда * $buyInf *
        #q!: * {$whatTime * $buyInf * [$ticket] * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$whatTime * $payInf * [$ticket] * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$whatTime * $buyInf * [$ticket] * 1358} *
        #q!: * {$whatTime * $payInf * [$ticket] * 1358} *
        #q!: * {$whatTime * $buyInf * [$lottery] * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$whatTime * $payInf * [$lottery] * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$whatTime * $buyInf * [$lottery] * 1358} *
        #q!: * {$whatTime * $payInf * [$lottery] * 1358} *
        #q!: * {$whatTime * $buyInf * [лото] * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$whatTime * $payInf * [лото] * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$whatTime * $buyInf * [лото] * 1358} *
        #q!: * {$whatTime * $payInf * [лото] * 1358} *
        #q!: * {$whatTime * продают* * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$whatTime * продают* * 1358} *
        #q!: * {$whatTime * продает* * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$whatTime * продает* * 1358} *
        #q!: * {$whatTime * продават* * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$whatTime * продават* * 1358} *
        #q!: * {$when * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {$when * ~продажа * 1358} *
        #q!: * {$when * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {*канчивает* * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {*канчивают* * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {завершает* * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {завершают* * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {завершите * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {завершат* * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {закрывает* * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {закрывают* * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {закроете * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {закроют * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {~окончание * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {~завершение * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {~закрытие * ~продажа * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * {~закрытие * $ticketRun * ($birthdayRL/$anniversaryDraw2)} *
        #q!: * $comWhere * [$ticketRun] * ($birthdayRL/$anniversaryDraw2) *
        #if: SpecialDay.isEvent(17, 10, 17, 20)
            #a: Приобрести билеты лотереи «Русское лото» на тираж 1358 можно было до 17.10.2020 17:20 мск. Билеты, приобретенные после закрытия продаж, оформляются на следующий тираж.
        #else:
            #a: Приобрести билеты лотереи «Русское лото» на тираж 1358 Вы можете до 17.10.2020 17:20 мск.



    #state: WhyIcantBuyABirthdayTicket
        #q!: * {$why * ($russianLoto/$birthdayRL) * ($registered/$registerPres3/оформлен*/оформляют*/оформил*/продал*/перенесен/перенесли/купилс*/$buyPresRefl3) * (~другой $ticketRun)} *
        #q!: * {$why * ($russianLoto/$birthdayRL) * ($registered/$registerPres3/оформлен*/оформляют*/оформил*/продал*/перенесен/перенесли/купилс*/$buyPresRefl3) * (~другой $ticketRunNumber)} *
        #q!: * {$why * ($russianLoto/$birthdayRL) * ($registered/$registerPres3/оформлен*/оформляют*/оформил*/продал*/перенесен/перенесли/купилс*/$buyPresRefl3) * ($ne на тот $ticketRun)} *
        #q!: * {$why * ($russianLoto/$birthdayRL) * ($registered/$registerPres3/оформлен*/оформляют*/оформил*/продал*/перенесен/перенесли/купилс*/$buyPresRefl3) * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * ($russianLoto/$birthdayRL) * ($registered/$registerPres3/оформлен*/оформляют*/оформил*/продал*/перенесен/перенесли/купилс*/$buyPresRefl3) * (~следующий $ticketRun)} *
        #q!: * {$why * ($russianLoto/$birthdayRL) * ($registered/$registerPres3/оформлен*/оформляют*/оформил*/продал*/перенесен/перенесли/купилс*/$buyPresRefl3) * (~следующий $ticketRunNumber)} *
        #q!: * {$why * ($russianLoto/$birthdayRL) * ($registered/$registerPres3/оформлен*/оформляют*/оформил*/продал*/перенесен/перенесли/купилс*/$buyPresRefl3) * (на * $ticketRun)} *
        #q!: * {$why * $russianLoto * ($ne на $birthdayRL)} *
        #q!: * {$why * $ticket * ($ne на $birthdayRL)} *
        #q!: * {$why * (в $ticket) * ($ne $birthdayRL)} *
        #q!: * {$why * (на $ticket) * ($ne $birthdayRL)} *
        #q!: * {продают* * $birthdayRL} *
        #q!: * {продает* * $birthdayRL} *
        #q!: * $buyPastPres * $birthdayRL * а [в] $ticket [на] [$oneWord] $ticketRun *
        #q!: * {$buyInf * [$ticket] * $birthdayRL} *
        #q!: * {$cantPastPresAll * $buyInf * [$ticket] * $birthdayRL} *
        #q!: * {$buyInfNe * [$ticket] * $birthdayRL} *
        #q!: * {$buyInf * [$ticket] * $russianLoto * (17 10)} *
        #if: SpecialDay.isEvent(17, 10, 17, 20)
            #a: Приобрести билеты лотереи «Русское лото» на тираж 1358 можно было до 17.10.2020 17:20 мск. Билеты, приобретенные после закрытия продаж, оформляются на следующий тираж.
        #else:
            #script: Webim.switch();


    #state: RedTaburet
        # Акция ред табурет (на сайте https://redtaburet.ru/), удвоение покупки.
        #q!: * (что/как) * [получить] * (выигрыш*/выиигрыш*/выйгрыш*/выйграш*/выиграш*/выгрыш*/выгреш*/вигрыш*/ввигрыш*/выигыщ*/вывигрыш*/вывиграш*/выегриш*/выегреш*/выграш/выйраш/выгрвш/ыИграш/выиграеш*/вигириш*/ввгрыш*/~приз/призовые) * $redTaburet *
        #q!: * {[$how] * $getInf * $prizeWithMoney * $redTaburet} *
        #q!: * $redTaburet *
        #q!: * {$billion * еще * (какие/какие-нибудь/какиенибудь/что/чтото/что-то/чтонибудь/что-нибудь) * (~приз/~подарок)} *
        #q!: * [что] * (~дополнительный/доп) (выигрыш*/выиигрыш*/выйгрыш*/выйграш*/выиграш*/выгрыш*/выгреш*/вигрыш*/ввигрыш*/выигыщ*/вывигрыш*/вывиграш*/выегриш*/выегреш*/выграш/выйраш/выгрвш/ыИграш/выиграеш*/вигириш*/ввгрыш*/~приз/призовые) * [$ticketRun] * ($birthdayRL/$anniversaryDraw2/1358) * [$ticketRun] *
        #a: Каждого участника праздничного тиража ждёт подарок: магазин дизайнерской мебели Red Taburet удвоит Вашу покупку. Подробные условия акции здесь: https://www.stoloto.ru/press/news/2020/09/20/Russkomu-loto-26-let





    #state: HowLongCanIBuyADistributionTicket
        # До какого времени можно купить билет на распределительный тираж
        #q!: * до ~какой (~время/~число/~день) * {$buyInf * ($distributionCirculation/$anniversaryDraw)} *
        #q!: * ($distributionCirculation/$anniversaryDraw) * до ~какой (~время/~число/~день) * $buyInf *
        #q!: * до скольки * {$buyInf * ($distributionCirculation/$anniversaryDraw)} *
        #intent!: /Ticket/HowLongCanIBuyADistributionTicket
        #a: Приобрести билеты лотереи «Русское лото» на тираж 1306 Вы можете до 19.10.2019 19:20 мск.


    #state: WhyTheTicketWasIssuedForAnotherEdition
        # Билет РЛ оформился на другой тираж
        #q!: * {$why * $russianLoto * $registered * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * $registered * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registered * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * $registered * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registered * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * $registered * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registered * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * $registerPres3 * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPres3 * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPres3 * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPres3 * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPres3 * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPres3 * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPres3 * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * $registerPast3 * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPast3 * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPast3 * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPast3 * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPast3 * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPast3 * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPast3 * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * оформлен* * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * оформлен* * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформлен* * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * оформлен* * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформлен* * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * оформлен* * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформлен* * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * оформляют* * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * оформляют* * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформляют* * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * оформляют* * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформляют* * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * оформляют* * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформляют* * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * оформил* * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * оформил* * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформил* * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * оформил* * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформил* * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * оформил* * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформил* * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * продал* * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * продал* * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * продал* * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * продал* * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * продал* * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * продал* * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * продал* * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * перенесен * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесен * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесен * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесен * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесен * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесен * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесен * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * перенесли * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесли * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесли * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесли * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесли * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесли * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесли * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * купилс* * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * купилс* * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * купилс* * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * купилс* * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * купилс* * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * купилс* * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * купилс* * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * $buyPresRefl3 * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * ($ne на $anniversaryDraw)} *
        #q!: * {$why * $ticket * ($ne на $anniversaryDraw)} *
        #q!: * {$why * (в $ticket) * ($ne $anniversaryDraw)} *
        #q!: * {$why * (на $ticket) * ($ne $anniversaryDraw)} *

        #q!: * $buyPastPres * $anniversaryDraw * а [в] $ticket [на] 1307 $ticketRun *
        #q!: * $buyPastPres * $anniversaryDraw * а [в] $ticket [на] $ticketRun 1307 *
        #q!: * {$buyInf * [$ticket] * $anniversaryDraw} *
        #q!: * {$cantPastPresAll * $buyInf * [$ticket] * $anniversaryDraw} *
        #q!: * {$buyInfNe * [$ticket] * $anniversaryDraw} *
        #q!: * {(закрыт* продаж*) * $anniversaryDraw} *
        #q!: * {продают* * $anniversaryDraw} *
        #q!: * {продает* * $anniversaryDraw} *
        #q!: * {$buyInf * [$ticket] * $russianLoto * (20 10)} *
        #intent!: /Ticket/WhyTheTicketWasIssuedForAnotherEdition
        #if: $client.testMode || Time.otherTicketRunTimeIsGood()
            #a: Приобрести билеты лотереи «Русское лото» на тираж 1306 можно было до 19.10.2019 19:20 мск. Билеты, приобретенные после закрытия продаж, оформляются на следующий тираж.
        #else:
            #script: Webim.switch();


    state: HowToBuyANewYearTicket
        # Как купить билет на новогодний тираж?
        q!: * {([$possiblePredicAll] * [$ticketAndLotteryAll] * $buyInf * [$ticketAndLotteryAll] * [$possiblePredicAll] * [$ticketAndLotteryAll]) * ($newYear/$1369) * [$bingoLotteries]} *
        q!: * {([$possiblePredicAll] * [$ticketAndLotteryAll] * $payInf * [$ticketAndLotteryAll] * [$possiblePredicAll] * [$ticketAndLotteryAll]) * ($newYear/$1369) * [$bingoLotteries]} *

        q!: * (интерес*/у вас * есть/есть * у вас/есть $li) [свободн*] $ticketAndLotteryAll * {[$bingoLotteries] * ($newYear/$1369)} *
        q!: * {[$bingoLotteries] * ($newYear/$1369)} * есть [$li] [в продаже] [свободн*] $ticketAndLotteryAll *
        q!: * (интерес*/у вас * есть/есть * у вас/есть $li) $newYear$ticketAndLotteryAll * [$bingoLotteries] *

        q!: * в продаже * {$ticketAndLotteryAll * [$bingoLotteries] * ($newYear/$1369)} *
        q!: * в продаже * {$bingoLotteries * ($newYear/$1369)} *


        intent!: /Ticket/HowToBuyANewYearTicket
        if: $parseTree._RL || $parseTree._1369
            if: checkIfCurrentDateIsBefore("2021-01-01 11:00")
                a: Приобрести билеты на новогодний тираж лотереи «Русское лото» Вы можете:\n\nонлайн:\n- на сайте stoloto.ru;\n- через приложение «Столото» для iOS и Android;\n\nофлайн:\n- лотерейные киоски «Столото»;\n- отделения Почты России;\n- магазины «Ароматный мир», «Бристоль», «О'КЕЙ», Ozon;\n- салоны связи «Мегафон», «Связной», «Теле2», «Билайн», «Ростелеком».\n\nБилеты без указания номера телефона возможно будет приобрести до 21:00 31.12.2020. Билеты с указанием номера телефона возможно будет купить до 11:00 01.01.2021.
            else:
                a: Билеты на новогодний тираж «Русского лото» возможно было приобрести до 11:00 01.01.2021. Билеты, оплаченные позже, оформляются на следующий тираж.

        elseif: $parseTree._bingoGames
            a: Приобрести билеты на новогодний тираж бинго-лотерей Вы можете:\n\nонлайн:\n- на сайте stoloto.ru;\n- через приложение «Столото» для iOS и Android;\n\nофлайн:\n- лотерейные киоски «Столото»;\n- отделения Почты России;\n- магазины «Ароматный мир», «Бристоль», «О'КЕЙ»;\n- салоны связи «Мегафон», «Связной», «Теле2», «Билайн», «Ростелеком».\n\nПо лотерее «Русское лото» билеты без указания номера телефона возможно будет приобрести до 21:00 31.12.2020. Билеты с указанием номера телефона возможно будет купить до 11:00 01.01.2021.\n\nПо лотереям «Жилищная лотерея», «6 из 36», «Золотая подкова», «Бинго-75» билеты можно будет приобрести до 16:50 «Жилищная лотерея», 15:40 «6 из 36», 16:20 «Золотая подкова», 15:20 «Бинго-75» 31.12.2020.\n\nБилеты лотерей, оплаченные после закрытия продаж, будут оформлены на следующий тираж.

        elseif: $parseTree._bingo || $parseTree._6of36 || $parseTree._goldenShoe || $parseTree._HL
            if: checkIfCurrentDateIsBefore("2020-12-31 16:50")
                a: Приобрести билеты на новогодний тираж лотерей «Жилищная лотерея», «6 из 36», «Золотая подкова», «Бинго-75» Вы можете:\n\nонлайн:\n- на сайте stoloto.ru;\n- через приложение «Столото» для iOS и Android;\n\nофлайн:\n- лотерейные киоски «Столото»;\n- отделения Почты России;\n- магазины «Ароматный мир», «Бристоль», «О'КЕЙ»;\n- салоны связи «Мегафон», «Связной», «Теле2», «Билайн», «Ростелеком».
            else:
                a: Билеты на новогодний тираж возможно было приобрести до 16:50 «Жилищная лотерея», 15:40 «6 из 36», 16:20 «Золотая подкова», 15:20 «Бинго-75» 31.12.2020. Билеты, оплаченные позже, оформляются на следующий тираж.

        else:
            a: Приобрести билеты на новогодний тираж бинго-лотерей Вы можете:\n\nонлайн:\n- на сайте stoloto.ru;\n- через приложение «Столото» для iOS и Android;\n\nофлайн:\n- лотерейные киоски «Столото»;\n- отделения Почты России;\n- магазины «Ароматный мир», «Бристоль», «О'КЕЙ»;\n- салоны связи «Мегафон», «Связной», «Теле2», «Билайн», «Ростелеком».\n\nПо лотерее «Русское лото» билеты без указания номера телефона возможно будет приобрести до 21:00 31.12.2020. Билеты с указанием номера телефона возможно будет купить до 11:00 01.01.2021.\n\nПо лотереям «Жилищная лотерея», «6 из 36», «Золотая подкова», «Бинго-75» билеты можно будет приобрести до 16:50 «Жилищная лотерея», 15:40 «6 из 36», 16:20 «Золотая подкова», 15:20 «Бинго-75» 31.12.2020.\n\nБилеты лотерей, оплаченные после закрытия продаж, будут оформлены на следующий тираж.


    state: HowLongCanIBuyANewYearTicket
        # До какого времени можно купить билет на новогодний тираж
        q!: * $whatTime * {([$possiblePredicAll] * [$ticketAndLotteryAll] * $buyInf * [$ticketAndLotteryAll] * [$possiblePredicAll] * [$ticketAndLotteryAll]) * ($newYear/$1369/$januaryFirst) * [$bingoLotteries]} *
        q!: * $whatTime * {([$possiblePredicAll] * [$ticketAndLotteryAll] * $payInf * [$ticketAndLotteryAll] * [$possiblePredicAll] * [$ticketAndLotteryAll]) * ($newYear/$1369/$januaryFirst) * [$bingoLotteries]} *

        q!: * [$bingoLotteries] * $whatTime * {([$possiblePredicAll] * $buyInf * [$possiblePredicAll]) * [$ticketAndLotteryAll] * ($newYear/$1369/$januaryFirst)} *
        q!: * [$bingoLotteries] * $whatTime * {([$possiblePredicAll] * $payInf * [$possiblePredicAll]) * [$ticketAndLotteryAll] * ($newYear/$1369/$januaryFirst)} *

        q!: * {([$possiblePredicAll] * [$ticketAndLotteryAll] * $buyInf * [$ticketAndLotteryAll] * [$possiblePredicAll] * [$ticketAndLotteryAll]) * ($newYear/$1369/$januaryFirst) * [$bingoLotteries]} * $whatTime *
        q!: * {([$possiblePredicAll] * [$ticketAndLotteryAll] * $payInf * [$ticketAndLotteryAll] * [$possiblePredicAll] * [$ticketAndLotteryAll]) * ($newYear/$1369/$januaryFirst) * [$bingoLotteries]} * $whatTime *

        q!: * {([$possiblePredicAll] * $buyInf * [$possiblePredicAll]) * [$ticketAndLotteryAll] * ($newYear/$1369/$januaryFirst)} * $whatTime * [$bingoLotteries] *
        q!: * {([$possiblePredicAll] * $payInf * [$possiblePredicAll]) * [$ticketAndLotteryAll] * ($newYear/$1369/$januaryFirst)} * $whatTime * [$bingoLotteries] *

        q!: * [$bingoLotteries] * $whatTime * {(продают*/продает*/продават*) * [$ticketAndLotteryAll] * ($newYear/$1369/$januaryFirst)} *
        q!: * {(продают*/продает*/продават*) * [$ticketAndLotteryAll] * ($newYear/$1369/$januaryFirst)} * $whatTime * [$bingoLotteries] *

        q!: * {((еще/уже) * (продают*/продает*/продават*/продаж*)) * ($newYear/$1369/$januaryFirst) * [$bingoLotteries]} *

        q!: * $whatTime * {([$ticketAndLotteryAll] * (продают*/продает*/продават*) * [$ticketAndLotteryAll]) * ($newYear/$1369/$januaryFirst) * [$bingoLotteries]} *
        q!: * {([$ticketAndLotteryAll] * (продают*/продает*/продават*) * [$ticketAndLotteryAll]) * ($newYear/$1369/$januaryFirst) * [$bingoLotteries]} * $whatTime *
        q!: * ([$ticketAndLotteryAll] * (продают*/продает*/продават*) * [$ticketAndLotteryAll]) * $whatTime * ($newYear/$1369/$januaryFirst) * [$bingoLotteries] *

        q!: * $whatTime * открыт* продаж* * ($newYear/$1369/$januaryFirst) * [$bingoLotteries] *

        q!: * {(*канчивает*/*канчивают*/закончитс*/закончитьс*/закончитц*/закончиц*/закончатс*/закончатьс*/закончатц*/закончац*/завершает*/завершают*/завершите/завершат*/закрывает*/закрывают*/закроете/закроют/~окончание/~завершение/~закрытие/закончил*/завершил*/закрыл*/прекращае*/прекратитс*/прекратитьс*/прекратиц*/прекратитц*/прекратите/прекратил*/открыта/открыты/закрыта/закрыты) * ~продажа * ($newYear/$1369/$januaryFirst) * [$bingoLotteries]} *

        q!: * {(*канчивает*/завершает*/истекает) * (время * ((на/для) $buyN)) * ($newYear/$1369/$januaryFirst) * [$bingoLotteries]} *

        q!: * {($when/$whatTime) * ((поставить/сделать/прием*/приним*) * $bet) * ($newYear/$1369/$januaryFirst) * [$bingoLotteries]} *

        q!: * {(31 декабр*/$januaryFirst) * (буд* * продава*) * ($newYear/$1369) * [$bingoLotteries]} *

        q!: * (последн*/крайний) срок * ((на/для) $buyN/$forTo $buyInf) * ($newYear/$1369/$januaryFirst) * [$bingoLotteries] *

        intent!: /Ticket/HowLongCanIBuyANewYearTicket

        if: $parseTree._RL || $parseTree._1369
            if: checkIfCurrentDateIsBefore("2021-01-01 11:00")
                a: Билеты на новогодний тираж лотереи «Русское лото» без указания номера телефона возможно будет приобрести до 21:00 31.12.2020. Билеты с указанием номера телефона возможно будет купить до 11:00 01.01.2021.

            elseif: checkIfCurrentDateIsAfter("2021-01-01 11:00") && checkIfCurrentDateIsBefore("2021-01-10")
                a: Билеты на новогодний тираж лотереи «Русское лото» возможно было приобрести до 11:00 01.01.2021. Билеты, оплаченные позже, оформляются на следующий тираж.

            else:
                script: Webim.switch();

        elseif: $parseTree._bingoGames
            a: По лотерее «Русское лото» билеты на новогодний тираж без указания номера телефона возможно будет приобрести до 21:00 31.12.2020. Билеты с указанием номера телефона возможно будет купить до 11:00 01.01.2021. По лотереям «Жилищная лотерея», «6 из 36», «Золотая подкова», «Бинго-75» билеты можно будет приобрести до 16:50 «Жилищная лотерея», 15:40 «6 из 36», 16:20 «Золотая подкова», 15:20 «Бинго-75» 31.12.2020. Билеты лотерей, оплаченные после закрытия продаж, будут оформлены на следующий тираж.

        elseif: $parseTree._bingo
            if: checkIfCurrentDateIsBefore("2020-12-31 15:20")
                a: Билеты на новогодний тираж лотереи «Бинго-75» возможно будет приобрести до 15:20 31.12.2020.

            elseif: checkIfCurrentDateIsAfter("2020-12-31 15:20") && checkIfCurrentDateIsBefore("2021-01-10")
                a: Билеты на новогодний тираж лотереи «Бинго-75» возможно было приобрести до 15:20 31.12.2020. Билеты, оплаченные позже, оформляются на следующий тираж.
            else:
                script: Webim.switch();

        elseif: $parseTree._6of36
            if: checkIfCurrentDateIsBefore("2020-12-31 15:40")
                a: Билеты на новогодний тираж лотереи «6 из 36» возможно будет приобрести до 15:40 31.12.2020.

            elseif: checkIfCurrentDateIsAfter("2020-12-31 15:40") && checkIfCurrentDateIsBefore("2021-01-10")
                a: Билеты на новогодний тираж лотереи «6 из 36» возможно было приобрести до 15:40 31.12.2020. Билеты, оплаченные позже, оформляются на следующий тираж.
            else:
                script: Webim.switch();

        elseif: $parseTree._goldenShoe
            if: checkIfCurrentDateIsBefore("2020-12-31 16:20")
                a: Билеты на новогодний тираж лотереи «Золотая подкова» возможно будет приобрести до 16:20 31.12.2020.

            elseif: checkIfCurrentDateIsAfter("2020-12-31 16:20") && checkIfCurrentDateIsBefore("2021-01-10")
                a: Билеты на новогодний тираж лотереи «Золотая подкова» возможно было приобрести до 16:20 31.12.2020. Билеты, оплаченные позже, оформляются на следующий тираж.
            else:
                script: Webim.switch();

        elseif: $parseTree._HL
            if: checkIfCurrentDateIsBefore("2020-12-31 16:50")
                a: Билеты на новогодний тираж «Жилищной лотереи» возможно будет приобрести до 16:50 31.12.2020.

            elseif: checkIfCurrentDateIsAfter("2020-12-31 16:50") && checkIfCurrentDateIsBefore("2021-01-10")
                a:

            else:
                script: Webim.switch();

        else:
            a: По лотерее «Русское лото» билеты на новогодний тираж без указания номера телефона возможно будет приобрести до 21:00 31.12.2020. Билеты с указанием номера телефона возможно будет купить до 11:00 01.01.2021. По лотереям «Жилищная лотерея», «6 из 36», «Золотая подкова», «Бинго-75» билеты можно будет приобрести до 16:50 «Жилищная лотерея», 15:40 «6 из 36», 16:20 «Золотая подкова», 15:20 «Бинго-75» 31.12.2020. Билеты лотерей, оплаченные после закрытия продаж, будут оформлены на следующий тираж.


    state: HowLongCanIBuyNewYearEveTicket
        # до какого времени можно купить билет на предновогодний тираж
        q!: * $whatTime * {([$possiblePredicAll] * [$ticketAndLotteryAll] * $buyInf * [$ticketAndLotteryAll] * [$possiblePredicAll] * [$ticketAndLotteryAll]) * ($newYearEve/500/278/422/1368) * [$bingoLotteries]} *
        q!: * $whatTime * {([$possiblePredicAll] * [$ticketAndLotteryAll] * $payInf * [$ticketAndLotteryAll] * [$possiblePredicAll] * [$ticketAndLotteryAll]) * ($newYearEve/500/278/422/1368) * [$bingoLotteries]} *

        q!: * {([$possiblePredicAll] * [$ticketAndLotteryAll] * $buyInf * [$ticketAndLotteryAll] * [$possiblePredicAll] * [$ticketAndLotteryAll]) * ($newYearEve/500/278/422/1368) * [$bingoLotteries]} * $whatTime *
        q!: * {([$possiblePredicAll] * [$ticketAndLotteryAll] * $payInf * [$ticketAndLotteryAll] * [$possiblePredicAll] * [$ticketAndLotteryAll]) * ($newYearEve/500/278/422/1368) * [$bingoLotteries]} * $whatTime *

        q!: * $whatTime * {(продают*/продает*/продават*) * [$ticketAndLotteryAll] * ($newYearEve/500/278/422/1368) * [$bingoLotteries]} *
        q!: * {(продают*/продает*/продават*) * [$ticketAndLotteryAll] * ($newYearEve/500/278/422/1368) * [$bingoLotteries]} * $whatTime *

        q!: * {(*канчивает*/*канчивают*/завершает*/завершают*/завершите/завершат*/закрывает*/закрывают*/закроете/закроют/~окончание/~завершение/~закрытие/закончил*/завершил*/закрылис*) * ~продажа * ($newYearEve/500/278/422/1368)} *

        q!: * {(*канчивает*/завершает*/истекает) * (время * ((на/для) $buyN)) * ($newYearEve/500/278/422/1368)} *

        q!: * {($when/$whatTime) * (поставить/сделать * $bet) * ($newYearEve/500/278/422/1368)} *

        q!: * {(24 декабр*/до какого декабр*) * (буд* * продава*) * ($newYearEve/500/278/422/1368)} *

        intent!: /Ticket/HowLongCanIBuyNewYearEveTicket

        if: checkIfCurrentDateIsBefore("2020-12-24 20:20")
            a: Типографские билеты лотерей Вы можете приобрести до 24 декабря 18:00 по мск. Закрытие продаж электронных билетов на 500 тираж лотереи «Бинго-75» состоится в 19:00 по мск, на 278 тираж лотереи «6 из 36» в 19:20 по мск, на 278 тираж лотереи «Золотая подкова» в 19:40 по мск, на 422 тираж «Жилищной лотереи» в 20:00 по мск, на 1368 тираж лотереи «Русское лото» в 20:20 по мск. Ознакомьтесь, пожалуйста, с информацией на нашем сайте: https://www.stoloto.ru/press/news/2020/12/20/Izmeneniya-grafika-translyacij-TV-loterej
        else:
            a: Типографские билеты лотерей Вы могли приобрести до 24 декабря 18:00 по мск. Закрытие продаж электронных билетов на 500 тираж лотереи «Бинго-75» состоялось в 19:00 по мск, на 278 тираж лотереи «6 из 36» в 19:20 по мск, на 278 тираж лотереи «Золотая подкова» в 19:40 по мск, на 422 тираж «Жилищной лотереи» в 20:00 по мск, на 1368 тираж лотереи «Русское лото» в 20:20 по мск. Билеты, оплаченные позже, оформляются на следующий тираж.


    state: TicketWasIssuedForAnotherEdition
        # Билет оформился на другой тираж

        q!: * {($ticket/$bingoLotteries) * (оформилс*/оформилас*/купилс*/купилас*) * (на (~другой/следующ*) ($ticketRun/$ticketRunNumber))} *
        q!: * $why * {($ticket/$bingoLotteries) * ($registered/$registerPres3/$registerPast3/оформлен*/оформляют*/оформил*/продал*/перенесен/перенесли/купилс*/$buyPresRefl3) * (на (~другой/следующ*) ($ticketRun/$ticketRunNumber))} *
        q!: * {($ticket/$bingoLotteries) * ($registered/$registerPres3/$registerPast3/оформлен*/оформляют*/оформил*/продал*/перенесен/перенесли/купилс*/$buyPresRefl3) * (на (~другой/следующ*) ($ticketRun/$ticketRunNumber))} * $why *
        q!: * {($ticket/$bingoLotteries) * ($registered/$registerPres3/$registerPast3/оформлен*/оформляют*/оформил*/продал*/перенесен/перенесли/купилс*/$buyPresRefl3) * ($ne на тот ($ticketRun/$ticketRunNumber))} *


        intent!: /Ticket/TicketWasIssuedForAnotherEdition
        if: checkIfCurrentDateIsBefore("2020-12-24 20:20")
            script: Webim.switch();
        else:
            if: checkIfCurrentDateIsBefore("2020-12-26 23:00")
                a: Типографские билеты лотерей Вы могли приобрести до 24 декабря 18:00 по мск. Закрытие продаж электронных билетов на 500 тираж лотереи «Бинго-75» состоялось в 19:00 по мск, на 278 тираж лотереи «6 из 36» в 19:20 по мск, на 278 тираж лотереи «Золотая подкова» в 19:40 по мск, на 422 тираж «Жилищной лотереи» в 20:00 по мск, на 1368 тираж лотереи «Русское лото» в 20:20 по мск. Билеты, оплаченные позже, оформляются на следующий тираж.
            else:
                if: $parseTree._RL
                    if: checkIfCurrentDateIsAfter("2021-01-01 11:00") && checkIfCurrentDateIsBefore("2021-01-10")
                        a: Билеты на новогодний тираж лотереи «Русское лото» возможно было приобрести до 11:00 01.01.2021. Билеты, оплаченные позже, оформляются на следующий тираж.
                    else:
                        script: Webim.switch();

                elseif: $parseTree._bingoGames
                    if: checkIfCurrentDateIsAfter("2021-01-01 11:00") && checkIfCurrentDateIsBefore("2021-01-10")
                        a: Билеты на новогодние тиражи Бинго лотерей возможно было приобрести до 11:00 01.01.2021. Билеты, оплаченные позже, оформляются на следующий тираж.
                    else:
                        script: Webim.switch();

                elseif: $parseTree._bingo
                    if: checkIfCurrentDateIsAfter("2020-12-31 15:20") && checkIfCurrentDateIsBefore("2021-01-10")
                        a: Билеты на новогодний тираж лотереи «Бинго-75» возможно было приобрести до 15:20 31.12.2020. Билеты, оплаченные позже, оформляются на следующий тираж.
                    else:
                        script: Webim.switch();

                elseif: $parseTree._6of36
                    if: checkIfCurrentDateIsAfter("2020-12-31 15:40") && checkIfCurrentDateIsBefore("2021-01-10")
                        a: Билеты на новогодний тираж лотереи «6 из 36» возможно было приобрести до 15:40 31.12.2020. Билеты, оплаченные позже, оформляются на следующий тираж.
                    else:
                        script: Webim.switch();

                elseif: $parseTree._goldenShoe
                    if: checkIfCurrentDateIsAfter("2020-12-31 16:20") && checkIfCurrentDateIsBefore("2021-01-10")
                        a: Билеты на новогодний тираж лотереи «Золотая подкова» возможно было приобрести до 16:20 31.12.2020. Билеты, оплаченные позже, оформляются на следующий тираж.
                    else:
                        script: Webim.switch();

                elseif: $parseTree._HL
                    if: checkIfCurrentDateIsAfter("2020-12-31 16:50") && checkIfCurrentDateIsBefore("2021-01-10")
                        a: Билеты на новогодний тираж «Жилищной лотереи» возможно было приобрести до 16:50 31.12.2020. Билеты, оплаченные позже, оформляются на следующий тираж.
                    else:
                        script: Webim.switch();

                else:
                    if: checkIfCurrentDateIsAfter("2021-01-01 11:00") && checkIfCurrentDateIsBefore("2021-01-10")
                        a: Билеты на новогодние тиражи Бинго лотерей возможно было приобрести до 11:00 01.01.2021. Билеты, оплаченные позже, оформляются на следующий тираж.
                    else:
                        script: Webim.switch();


    state: WhereToBuyChristmasGiftSets
        # Где купить подарочные новогодние наборы РЛ?
        q!: {подарочн* (~набор/тубус*/тобус*)}
        q!: (~набор/тубус*/тобус*) [$with] [$ticket] [@RL]
        q!: {(~набор/тубус*/тобус*) ([к] $newYear/$billion)}
        q!: (~набор/тубус*/тобус*) [на] $1369 [$ticketRun]

        q!: * {($buyInf/продаж*/продает*/продают*) * ((~набор/тубус*/тобус*) * [$ticketAndLotteryAll]) * ($newYear/@RL/$1369/подарочн*/$billion)} *

        q!: * {($buyInf/продаж*/продает*/продают*) * ([подарочн*] * ((~набор/тубус*/тобус*) * [$ticketAndLotteryAll])) * $newYear * @RL} *
        q!: * {($buyInf/продаж*/продает*/продают*) * ([подарочн*] * ((~набор/тубус*/тобус*) * [$ticketAndLotteryAll])) * $newYear * $1369} *

        q!: * (интерес*/у вас * есть/есть * у вас) * {((~набор/тубус*/тобус*) * [$ticketAndLotteryAll]) * ($newYear/@RL/$1369/подарочн*/$billion)} *
        q!: * {((~набор/тубус*/тобус*) * [$ticketAndLotteryAll]) * ($newYear/@RL/$1369/подарочн*/$billion)} * (интерес*/у вас * есть/есть * у вас) *

        intent!: /Ticket/WhereToBuyChristmasGiftSets
        if: checkIfCurrentDateIsBefore("2020-12-31 21:00")
            a: Новогодние подарочные наборы лотереи «Русское лото» можно приобрести в розничных пунктах продаж «Столото», отделениях «Почты России», в магазине Ozon.
        else:
            script: Webim.switch();
























