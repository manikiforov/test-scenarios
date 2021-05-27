theme: /Payments

    state: WhereToPutWinCode
        # Куда вводить код выигрыша
        q!: * $comWhat $oneWord $code $prize *
        q!: * $whatFor $oneWord $code $prize *
        q!: $code $prize $whatFor (он/они) $comNeed *
        q!: $code $prize {это $comWhat}
        q!: * {$insertInf * $code * $win} *
        q!: [$helloAll] куда {$sendInf $code $win}
        q!: * {$useInf * $code * $win} *
        q!: * {$insertInf * $win * ~номер * $sms} *
        q!: * {$comWhere * $insertInf * $code * $win} *
        q!: * (куда/$comWhere) * $insertInf * ($ticketNumber и $code) *
        q!: * $comWhat $doInfLocal $with $code $win *
        q!: * {$sms * $code * $checkInf} *
        q!: * {$sms * ~номер * $checkInf} *
        q!: * $sms * $win * $checkInf *
        q!: * {$win * $code * $checkInf} *
        q!: * {$smsComePast * ($sms/$notification) * $win} * $checkInf *
        q!: * $checkInf * {$smsComePast * ($sms/$notification) * $win} *
        q!: * {$smsComePast * $code * $checkInf} *

        q!: * $smsComePast * ($sms/$code) * $winPastPerf *
        q!: * $smsComePast $sms о $prize *
        q!: * $smsComePast * $sms * $prize * $ticketNumber * $code *
        q!: * $smsComePast * $sms * $prize * и $ticketNumber *
        q!: * $smsComePast * $sms * $with $ticketNumber * и $code *
        q!: * $smsComePast * $sms * $with $number ($win $ticket/$prize) *
        q!: * $smsComePast * $sms * есть [какой-то/какой то] $prize *
        q!: * $smsComePast * $sms * что $winTicket *
        q!: * {[$onTelephone/на тел] $smsComePast} [от] [$stoloto] ($sms/$notification/$code) [$with/о] [$code] $win [$Number] [в $sms] [$comWhat] [эт*] [значит/означает]
        q!: [$helloAll] [мне] {[$onTelephone/на тел] $smsComePast} ($sms/$notification) $comWhat (какой-то/какой то/у меня/есть) $win [$comWhat] [эт*] [значит/означает]
        q!: * $receivePast $code $win * {$comWhat $doInf (дальше/потом/после)} *
        q!: * {$comWhat $doInf (дальше/потом/после)} * $receivePast $code $win *
        q!: * $smsComePast $code $win * {$comWhat $doInf (дальше/потом/после)} *
        q!: * {$comWhat $doInf (дальше/потом/после)} * $smsComePast $code $win *
        q!: $code $win [$Number]
        q!: * ($smsComePast/$receivePast) * $sms * $prize в * $ticket $regexp<\d+> $code [$win] *
        q!: $prize в * $ticket $regexp<\d+> $code [$win] [№]$regexp<\d+> *
        q!: * $number $prize $Number $comWhat эт* (значит/означает) *
        q!: * $prize в $generalNamedLottery и $code * $comWhat эт* (значит/означает) *
        intent!: /Payments/WhereToPutWinCode
        a: Код выигрыша - это числовая комбинация, которая поступает в sms в случае выигрыша. Данный код необходим для получения выигрыша в точке продаж. Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».

        ####################Проблемы с оплатой########################

    state: IСantPayByCard
        # Не могу оплатить картой
        q!: * $why * {$fromBankCard $comNo $payment} *
        q!: * {$payPastReflNe * $buyNAll * ($fromBankCard/$bankCardAndOther)} *

        q!: * {$cantPastPresAll * ([$ticketAndLottery] * $buyPayInf * [$ticketAndLottery]) * $bankCardAndOther} *

        q!: * {$cantPastPresAll * $bet * $bankCardAndOther} *
        q!: * {$want * $buyPayInf * $bankCardAndOther} * $cantPastPresAll *

        q!: * {$payment * $bankCardAndOther * $activeNe} *
        q!: * {$buyPayInf * $bankCardAndOther * $activeNe} *

        q!: * {$cantPastPres * $buyN * $bankCardAndOther} *
        q!: * {$cantPastPres * $payment * $bankCardAndOther} *
        q!: * {$cantPastPres * $ticket * $bankCardAndOther} *

        q!: * (невозможност*/недоступност*) ($buyN/$payment) * $bankCardAndOther *
        q!: * {($ne идет/неидет) * $payment * $bankCardAndOther} *

        q!: * {$producePres3Ne $payment ($by $bankCardAndOther)} *
        q!: * {$nelzya * $buyPayInf * $bankCardAndOther} *

        q!: * {$acceptPresNe * $payment * $bankCardAndOther} *
        q!: * {$acceptPresNe карт*} *
        q!: * {$dismissPastPres * $payment * $bankCardAndOther} *
        q!: * {$confirmPres3Ne $payment $bankCardAndOther} *
        q!: * {$workFut * $buyN * $bankCardAndOther} *
        q!: * {$workFut * $payment * $bankCardAndOther} *
        q!: * {$when * $buyPayInf * $bankCardAndOther} *

        q!: * {(~пустой ~экран) * $buyPayInf * $bankCardAndOther} *

        q!: * {$payPresNe * $buyNAll * $bankCardAndOther} *

        q!: [$helloAll] {$why $payPresNe [$by] $bankCardAndOther}

        q!: * {([так] $slowly) $passPres $buyN ($by $bankCardAndOther)} *
        q!: * {([так] $slowly) $passPres $payment ($by $bankCardAndOther)} *

        q!: * [$why] * {$buyPayInfNe * [$ticketAndLottery] * $bankCardAndOther} * [$why] *


        q!: * {$buyPresRefl3Ne * [$ticket] * $bankCardAndOther} *
        q!: * [$ticket] * {$buyPresRefl3 * долго * $bankCardAndOther} *

        q!: * ($payment/$buyN/$buyPayInf) * $bankCardAndOther * $error *
        q!: * $error * ($payment/$buyN/$buyPayInf) * $bankCardAndOther *

        # деньги с карты списались, билет не оплачен
        q!: * $debitedFromCard * $ticketWasNotBought *
        q!: * $ticketWasNotBought * $debitedFromCard *

        q!: * ($bankCardAndOther/$fromBankCard) * $ticketWasNotBought *
        q!: * ($bankCardAndOther/$fromBankCard) * {$buyNAll $registerTicketPastReflNe} *
        q!: * {$buyNAll $registerTicketPastReflNe} * ($bankCardAndOther/$fromBankCard) *

        q!: * {$payPast * $buyNAll * ($bankCardAndOther/$fromBankCard)} * результ* $comNo *

        q!: * $why может $workInfNe $payment $bankCardAndOther *
        q!: $notPaid $bankCardAndOther

        intent!: /Payments/IСantPayByCard
        if: $global.byuingTicketIsAvailable
            if: $global.cardPaymentIsAvailable
                script: Webim.switch();
            else:
                a: Мы уже работаем над возобновлением оплаты по банковским картам. Сейчас Вы можете оплатить лотерейный билет любым другим способом, указанным на нашем сайте или в мобильном приложении.
        else:
            a: По техническим причинам временно может быть недоступна оплата билетов. А пока мы работаем над устранением этой проблемы, пожалуйста, не дублируйте Ваши оплаты после того, как первая попытка не удалась. Мы просим немного Вашего терпения и обещаем, что очень скоро платежи станут проходить так же быстро, как и всегда.


    state: ICantPayFromPurse
        # Не могу оплатить из Кошелька
        q!: * $why * {$fromWallet $comNo $payment} *
        q!: * {$payPastReflNe * [$buyNAll] * ($fromWallet/$w1All)} *

        q!: * {$cantPastPresAll * ([$ticketAndLottery] * $buyPayInf * [$ticketAndLottery]) * $w1All} *

        q!: * {$want * $buyPayInf * $w1All} * $cantPastPresAll *
        q!: * {$payment * $w1All * $activeNe} *
        q!: * {$buyPayInf * $w1All * $activeNe} *

        q!: * {$cantPastPres * $buyN * $w1All} *
        q!: * {$cantPastPres * $payment * $w1All} *
        q!: * (невозможност*/недоступност*) $buyN * $w1All *
        q!: * {($ne идет/неидет) * $payment * $w1All} *

        q!: * {$producePres3Ne * $payment * ($by $w1All/$fromWallet)} *
        q!: * {$nelzya * $buyPayInf * $w1All} *

        q!: * {$acceptPresNe * $payment * $w1All} *
        q!: * {$dismissPastPres * $payment * $w1All} *
        q!: * {$confirmPres3Ne $payment ($by $w1All)} *
        q!: * {$workFut * $buyN * $w1All} *
        q!: * {$workFut * $payment * $w1All} *
        q!: * {$error * $payment * $w1All} *
        q!: * {$when * $buyPayInf * $w1All} *
        q!: * {(~пустой ~экран) * $buyPayInf * $w1All} *

        q!: * {$payPresNe * $buyNAll * $w1All} *
        q!: * {$payPresNe $fromWallet} *

        q!: [$helloAll] {$why $payPresNe ([$by] $w1All)}
        q!: [$helloAll] {$why $payInfNe ([$by] $w1All)}
        q!: * {([так] $slowly) $passPres $buyN ($by $w1All)} *
        q!: * {([так] $slowly) $passPres $payment ($by $w1All)} *
        q!: * [$why] * {$buyPayInfNe * [$ticketAndLottery] * $w1All} * [$why] *

        q!: * {$buyPresRefl3Ne * [$ticket] * $w1All} *
        q!: * [$ticket] * {$buyPresRefl3 * долго * $w1All} *

        q!: * ($payment/$buyN/$buyPayInf) * $w1All * $error *
        q!: * $error * ($payment/$buyN/$buyPayInf) * $w1All *

        # деньги с кошелька списали, билет не оплачен
        q!: * $debitedFromWallet * $ticketWasNotBought *
        q!: * $ticketWasNotBought * $debitedFromWallet *

        q!: * $w1All * $ticket остал* $notPaid *

        q!: * {$payPast * $ticket * $w1All} * результ* $comNo *
        q!: * $w1All * {$ticket (так и $ne купил*)} *
        q!: * $why может $workInfNe $payment ($with/из) $w1All *
        q!: $notPaid ($with/из) $w1All
        q!: * $w1All * {$buyNAll $registerTicketPastReflNe} *
        q!: * {$buyNAll $registerTicketPastReflNe} * $w1All *
        intent!: /Payments/ICantPayFromPurse
        if: $global.byuingTicketIsAvailable
            if: $global.paymentFromWalletIsAvailable
                a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.
            else:
                a: Мы уже работаем над возобновлением продажи билетов на нашем сайте. Сейчас вы можете оплатить лотерейный билет любым другим способом, указанным на нашем сайте или в мобильном приложении.
        else:
            a: По техническим причинам временно может быть недоступна оплата билетов. А пока мы работаем над устранением этой проблемы, пожалуйста, не дублируйте Ваши оплаты после того, как первая попытка не удалась. Мы просим немного Вашего терпения и обещаем, что очень скоро платежи станут проходить так же быстро, как и всегда.

        state: GetUserData || fromState = /Payments/ICantPayFromPurse
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Payments/ICantPayFromPurse
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Payments/ICantPayFromPurse
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        ##########################Баланс##############################

    state: BalanceUnavailable
        # Недоступен баланс

        q!: * $comNo данных [о/по] $balance *
        q!: * $comNo данных [о/по] $wallet *
        q!: * {$downloadPres3Ne (данные [о/по] [$comMy] ($balance/$wallet))} *

        q!: * {$cantPastPresAll $findInf (остаток [$comMoney] ($inWallet/$onBalanceLoc))} *
        q!: * {$cantPastPresAll (~информация (о/по) $balance)} *
        q!: * {$walletAll * обнул*} *
        q!: * $walletAll пустой *
        q!: * {$walletAll * $zero} *

        #q!: * {$wallet * $problem} *
        #q!: * {($balance/~счет) * $problem} *
        #q!: * {$walletAll * $zeroAdj} *

        q!: * ($comNo/пропал/отсутс*) $balance *
        q!: * {(после ~обновление) * $comNo * $comMoney} *
        q!: * {(после ~обновление) * $bonusDisappearPastPres * $comMoney} *
        q!: * куда (делас*/подевалас*) сум* ($inWallet/$fromWallet) *
        q!: {$comNo $comMoney $inWallet}
        q!: {$comNo $comMoney $onBalanceLoc}
        #q!: * {$bonusComePastPresNe ([сум*] ([в] $wallet/[на] $balance [$wallet]))} *
        #q!: * {$bonusComePastPresNe сум* ([в/на] [$comMy] $account)} *
        q!: * {$findPastPresNe ([$comMy] $balance)} *
        q!: * {$displayPresSg3Ne ([$comMy] $balance)} *
        q!: * {$findPastPresNe * $comMoney * $onBillLoc} *
        q!: * {$findPastPresNe * $comMoney * $account} *
        q!: * {$findPastPresNe * $comMoney * $inWallet} *
        q!: * {$displayPresPl3Ne * $comMoney * $onBillLoc} *
        q!: * {$displayPresPl3Ne * $comMoney * $account} *
        q!: * {$displayPresPl3Ne * $comMoney * $inWallet} *
        q!: * {$displayPresPl3Ne * $comMoney * $onBalanceLoc} *

        q!: * {$cantPastPres * $findInf * $balance} *
        q!: * $cantPastPresAll $checkInf [$inWallet] [$comMy] $balance *
        q!: * {$cantPastPres * ~обновление * $walletAll} *
        q!: * {$cantPastPres * обновить * $walletAll} *
        q!: * {$balance * $changeNe} *
        q!: * {$changeNe $wallet} *
        q!: * {$wallet * завис} *
        q!: * $comWhat [у вас] [$ne так/$happenPast] $with [~мой] $walletAll *
        q!: * {$walletAll * ($updatePresSg3Ne/$openPres3Ne/просит обновить)} *

        q!: * {($balance [$wallet]) [$isWritten] $inactive} *
        q!: * {$wallet [$isWritten] $inactive} *
        q!: * ($balance/$wallet) * {он $inactive} *
        q!: * {$inactive * $comMoney * $wallet} *
        #q!: * {$cantPastPres * $useInf * $comMoney} *
        #q!: * {$bonusDisappearPastPres * $walletAll} *
        q!: * {$bonusDisappearPastPres $comMoney ([c/в/на] [~мой] $account)} *

        q!: * $walletAll (был*/лежал*) * ($comMoney/$rub) * их $comNo *
        q!: * {куда * $bonusDisappearPastPres * $comMoney} *
        q!: * {$comWhere * $moneyAndRub * $walletAll} *

        intent!: /Payments/BalanceUnavailable
        if: $client.testMode || $global.balanceIsAvailable
            script: Webim.switch();
        else:
            a: В настоящий момент баланс Кошелька Столото может быть недоступен. Мы работаем над скорейшим устранением проблемы.



    state: IncorrectBalance
        # Некорректно отображается баланс
        q!: * {$wrong [на $wallet] $balance} *
        q!: * {$wrong ~отображение $balance} *
        q!: * {$balance * $displayPres3 * $incorrectly} *
        q!: * {$balance * отображен * $incorrectly} *
        q!: * {~отображение * $balance * $incorrectly} *
        q!: * $wallet * {$incorrectly * $comMoney * отображены} *
        q!: * {$incorrectly * $comMoney * отображены} * $wallet *
        q!: * {$wallet * $wrong * $comMoney} *
        q!: * {$balance * $wrong * $comMoney} *
        q!: * {$wallet * $displayPres3 * ($ne все $comMoney)} *
        q!: * {~счет * $displayPres3 * ($ne все $comMoney)} *
        q!: * {$balance * $displayPres3 * ($ne все $comMoney)} *
        q!: * {($wallet/$balance) * $displayPres3 * чушь} *
        intent!: /Payments/IncorrectBalance
        if: $global.balanceIsCorrect
            script: Webim.switch();
        else:
            a: В данный момент мы обновляем информацию на сайте. Вы сможете посмотреть баланс своего Кошелька в кратчайшие сроки.


        ##########################Вопросы про банковские карты########


    state: HowToRemoveABancCard
        # Как отвязать банковскую карту?
        q!: * {$unpinInfImp * $bankCardAll} *
        q!: * {$blockInf * $bankCardAll * [$ticketAll]} *
        q!: * {$blockImpFut * $bankCardAll * [$ticketAll]} *
        intent!: /Payments/HowToRemoveABancCard
        script: Webim.switch();


    state: HowToChangeABankCard
        # Как изменить банковскую карту?
        q!: * {$changeInfImpAll * $bankCardAll} *
        q!: * {$changePast $bankCardAll} *
        q!: * {$wrong $bankCardAll} *
        q!: * {вбить * $bankCardAll} *
        q!: * добавить [$new/еще] [одну/1] $bankCardAll *
        q!: * {$attachInf * $bankCardAll} *
        q!: * {$appendInf * ($new $bankCardAll)} *
        q!: * {ввести * ($new $bankCardAll)} *
        q!: * {(у $meGen) * ($new $bankCardAll)} *
        intent!: /Payments/HowToChangeABankCard
        a: Для изменения данных банковской карты при пополнении Кошелька, обратитесь, пожалуйста, в службу поддержки компании ООО РНКО «Единая касса» по адресу электронной почты support@w1.ru или по номеру телефона 8-495-777-11-25. Кошелек Столото интегрирован в платформу Единого Кошелька, поэтому у нас, к сожалению, нет доступа к данной информации. При обращении сообщите, пожалуйста, номер Вашего Кошелька.\n\nЕсли Вы хотите оплатить билет другой картой, выберите способ оплаты «Банковская карта». После этого нажмите, пожалуйста, на кнопку «Использовать другую карту». В открывшемся окне необходимо ввести реквизиты новой карты, нажать «Далее». Таким образом Вы сможете произвести оплату другой картой.


    state: ICantToChangeABankCard
        # Не могу изменить банковскую карту

        q!: * [$ticket] * {$cantPastPresAll * ($changeInfImpAll/$attachInf/вбить) * $bankCardAll} *

        q!: * $cantPastPresAll * {$changeInfImpAll * $bankCardAll * [$depositInf/~пополнение]} *
        q!: * $cantPastPresAll * {$changeInfImpAll * $bankCardAll * $payingForTicket} *
        q!: * $cantPastPresAll * {$changeInfImpAll * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} *
        q!: * $cantPastPresAll * {$changeInfImpAll * $bankCardAll * ($payment * $wallet)} *

        q!: * {$changeInfImpAll * $bankCardAll * [$depositInf/~пополнение]} * $cantPastPresAll *
        q!: * {$changeInfImpAll * $bankCardAll * $payingForTicket} * $cantPastPresAll *
        q!: * {$changeInfImpAll * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} * $cantPastPresAll *
        q!: * {$changeInfImpAll * $bankCardAll * ($payment * $wallet)} * $cantPastPresAll *


        q!: * $cantPastPresAll * {$attachInf * $bankCardAll * [$depositInf/~пополнение]} *
        q!: * $cantPastPresAll * {$attachInf * $bankCardAll * $payingForTicket} *
        q!: * $cantPastPresAll * {$attachInf * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} *
        q!: * $cantPastPresAll * {$attachInf * $bankCardAll * ($payment * $wallet)} *

        q!: * {$attachInf * $bankCardAll * [$depositInf/~пополнение]} * $cantPastPresAll *
        q!: * {$attachInf * $bankCardAll * $payingForTicket} * $cantPastPresAll *
        q!: * {$attachInf * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} * $cantPastPresAll *
        q!: * {$attachInf * $bankCardAll * ($payment * $wallet)} * $cantPastPresAll *

        q!: * {$cantPastPresAll * (добавить [$new/еще] [одну/1] $bankCardAll) * [$depositInf/~пополнение]} *
        q!: * {$cantPastPresAll * (добавить [$new/еще] [одну/1] $bankCardAll) * $payingForTicket} *
        q!: * {$cantPastPresAll * (добавить [$new/еще] [одну/1] $bankCardAll) * ($buyInf/$buyN/$buyPastPres)} *
        q!: * {$cantPastPresAll * (добавить [$new/еще] [одну/1] $bankCardAll) * ($payment * $wallet)} *

        q!: * $cantPastPresAll * {вбить * $bankCardAll * [$depositInf/~пополнение]} *
        q!: * $cantPastPresAll * {вбить * $bankCardAll * $payingForTicket} *
        q!: * $cantPastPresAll * {вбить * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} *
        q!: * $cantPastPresAll * {вбить * $bankCardAll * ($payment * $wallet)} *

        q!: * {вбить * $bankCardAll * [$depositInf/~пополнение]} * $cantPastPresAll *
        q!: * {вбить * $bankCardAll * $payingForTicket} * $cantPastPresAll *
        q!: * {вбить * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} * $cantPastPresAll *
        q!: * {вбить * $bankCardAll * ($payment * $wallet)} * $cantPastPresAll *

        q!: * {$appendInf * ($new $bankCardAll) * $cantPastPresAll} *
        q!: * {ввести * ($new $bankCardAll) * $cantPastPresAll} *
        intent!: /Payments/ICantToChangeABankCard
        a: Опишите подробнее, пожалуйста, в чем у Вас возникла сложность?


    state: HowToChangeABankCardToFillUpPurse
        # Как изменить банковскую карту для пополнения Кошелька?
        q!: * {$changeInfImpAll * $bankCardAll * ($depositInf/~пополнение)} *
        q!: * {$changeInfImpAll * $bankCardAll * ($payment * $wallet)} *

        q!: * {($wrong $bankCardAll) * ($depositInf/~пополнение)} *
        q!: * {($wrong $bankCardAll) * $payment * $wallet} *

        q!: * {$attachInf * $bankCardAll * ($depositInf/~пополнение)} *
        q!: * {$attachInf * $bankCardAll * ($payment * $wallet)} *

        q!: * {вбить * $bankCardAll * ($depositInf/~пополнение)} *
        q!: * {вбить * $bankCardAll * ($payment * $wallet)} *

        q!: * {(добавить [$new/еще] [одну/1] $bankCardAll) * ($depositInf/~пополнение)} *
        q!: * {(добавить [$new/еще] [одну/1] $bankCardAll) * $payment * $wallet} *
        intent!: /Payments/HowToChangeABankCardToFillUpPurse
        a: Для изменения данных банковской карты при пополнении Кошелька, обратитесь, пожалуйста, в службу поддержки компании ООО РНКО «Единая касса» по адресу электронной почты support@w1.ru или по номеру телефона 8-495-777-11-25. Кошелек Столото интегрирован в платформу Единого Кошелька, поэтому у нас, к сожалению, нет доступа к данной информации. При обращении сообщите, пожалуйста, номер Вашего Кошелька.


    state: HowToChangeABankCardToPayForTickets
        # Как изменить банковскую карту для оплаты билетов
        q!: * {$changeInfImpAll * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} *

        q!: * {$changeInfImpAll * $bankCardAll * $payingForTicket} *

        q!: * {($wrong $bankCardAll) * ($buyInf/$buyN/$buyPastPres)} *
        q!: * {($wrong $bankCardAll) * $payment * $ticketAll} *
        q!: * {($wrong $bankCardAll) * ($payInf/$payPast) * $ticketAll} *

        q!: * {$attachInf * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} *
        q!: * {$attachInf * $bankCardAll * $payingForTicket} *

        q!: * {вбить * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} *
        q!: * {вбить * $bankCardAll * $payingForTicket} *

        q!: * {(добавить [$new] $bankCardAll) * ($buyInf/$buyN/$buyPastPres)} *
        q!: * {(добавить [$new] $bankCardAll) * $payment * $ticketAll} *
        q!: * {(добавить [$new] $bankCardAll) * ($payInf/$payPast) * $ticketAll} *
        intent!: /Payments/HowToChangeABankCardToPayForTickets
        a: Если Вы хотите оплатить билет другой картой, выберите способ оплаты «Банковская карта». После этого нажмите, пожалуйста, на кнопку «Использовать другую карту». В открывшемся окне необходимо ввести реквизиты новой карты, нажать «Далее». Таким образом Вы сможете произвести оплату другой картой.

        #####################Общие вопросы про деньги##############

    state: WhereIsTheMoney
        # Где деньги
        q!: [$helloAll] [$comYes] {[$beginningWords] $comWhere [$comObsceneWord/$negative] [$comMy] $moneyAndRub} [зин*]
        q!: [$helloAll] [$comYes] [$beginningWords] $comWhere [же] [$comObsceneWord] [$comMy] $moneyAndRub
        q!: [$helloAll] [$comYes] {[$beginningWords] $comWhat [$comObsceneWord] $with [$comMy] $moneyAndRub}
        q!: * {($returnImp/отдайте) [$comMy] $moneyAndRub} *
        q!: * {зависли [$comMy] $moneyAndRub} *
        q!: [$helloAll] [$comMy] $moneyAndRub (пропал*/исчезл*/потерялис*)
        q!: [$helloAll] (пропал*/исчезл*/потерялис*) [$comMy] $moneyAndRub
        q!: * (куда/где) (пропал*/исчезл*/потерялис*) [$comMy] $moneyAndRub *
        q!: [$helloAll] $why ($ne отдаете/неотдаете/ниотдаете) {[$comMy] $moneyAndRub}
        q!: [$helloAll] $why {[$comMy] $moneyAndRub} ($ne отдаете/неотдаете/ниотдаете)
        intent!: /Payments/WhereIsTheMoney
        a: Опишите подробнее, пожалуйста, в чем у Вас возникла сложность?



    state: HowToTransferTheMoney
        # Как перевести деньги (без уточнения, куда)
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $transferInfImp [$comMy] $moneyAndRub} [$onBill]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $sendInf [$comMy] $moneyAndRub} [$onBill]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $moneyAddInf [$comMy] $moneyAndRub} [$onBill]

        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [*скаж*/$ne *скаж*] [$please] {[$how/$want] [я] [могу] $transferInfImp [$comMy] $moneyAndRub} [$onBill]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [*скаж*/$ne *скаж*] [$please] {[$how/$want] [я] [могу] $sendInf [$comMy] $moneyAndRub} [$onBill]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [*скаж*/$ne *скаж*] [$please] {[$how/$want] [я] [могу] $moneyAddInf [$comMy] $moneyAndRub} [$onBill]
        intent!: /Payments/HowToTransferTheMoney
        a: Уточните, пожалуйста, Вы хотите пополнить Кошелек, перевести выигрыш на Кошелек или перевести выигрыш из Кошелька на сторонние ресурсы?

        state: LocalCatchAll || fromState = /Payments/HowToTransferTheMoney
            event: noMatch
            script: Webim.switch();


    state: HowToTransferTheMoneyToPurse
        # Как перевести деньги в Кошелек (без уточнения, выигрыш или пополнить)
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $transferInfImp [$comMy] $moneyAndRub $toWalletAll} [$how это сделать]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $sendInf [$comMy] $moneyAndRub $toWalletAll} [$how это сделать]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $moneyAddInf [$comMy] $moneyAndRub $toWalletAll} [$how это сделать]

        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [я] [могу] $transferInfImp [$comMy] $moneyAndRub $toWalletAll} [$how это сделать]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [я] [могу] $sendInf [$comMy] $moneyAndRub $toWalletAll} [$how это сделать]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [я] [могу] $moneyAddInf [$comMy] $moneyAndRub $toWalletAll} [$how это сделать]

        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $transferInfImp $toWallet} [$how это сделать]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $sendInf $toWallet} [$how это сделать]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $moneyAddInf $toWallet} [$how это сделать]

        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [я] [могу] $transferInfImp $toWallet} [$how это сделать]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [я] [могу] $sendInf $toWallet} [$how это сделать]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [я] [могу] $moneyAddInf $toWallet} [$how это сделать]
        q!: ~перевод $moneyAndRub $toWallet
        intent!: /Payments/HowToTransferTheMoneyToPurse
        a: Уточните, пожалуйста, Вы хотите пополнить Кошелек или перевести выигрыш на Кошелек?


    state: ICantToTransferTheMoney
        # Не могу перевести деньги (без уточнения, куда)
        q!: * {$cantPastPresAll * $transferInfImp * $moneyAndRub} *
        q!: * {$cantPastPresAll * $sendInf * $moneyAndRub} *
        q!: * {$cantPastPresAll * $moneyAddInf * $moneyAndRub} *
        q!: * {$cantPastPresAll * получить * $moneyAndRub} *

        q!: * {$transferInfNe * $moneyAndRub} *
        q!: * {$sendInfNe * $moneyAndRub} *
        q!: * {$moneyAddInfNe * $moneyAndRub} *

        q!: * {$moneyAddPastPresNe * $moneyAndRub} *
        q!: * {$moneyAddPartPasNe * $moneyAndRub} *
        q!: * {$smsComePastPerfNe * $moneyAndRub} *
        q!: * {$smsComePresNe * $moneyAndRub} *

        q!: * {$moneyAndRub * ($transferPastPresNe/$addPastPlSg3Ne)} *

        q!: * {$howLong * $moneyAddPastPres * $moneyAndRub} *
        q!: * {$slowly * $moneyAddPastPres * $moneyAndRub} *
        q!: * {$when * $moneyAddPastPres * $moneyAndRub} *

        q!: * {$howLong * $bonusComePastPres * $moneyAndRub} *
        q!: * {$slowly * $bonusComePastPres * $moneyAndRub} *
        q!: * {$when * $bonusComePastPres * $moneyAndRub} *

        q!: * {$howLong * $bonusComeFut * $moneyAndRub} *
        q!: * {$when * $bonusComeFut * $moneyAndRub} *
        q!: * {$howLong * $transferFut * $moneyAndRub} *
        q!: * {$when * $transferFut * $moneyAndRub} *
        q!: * ($transferFut/$bonusComeFut) $li * $moneyAndRub *

        q!: * $howLong * ~зачисление *

        q!: * {$transferPastPres * $moneyAndRub} * $comWhere *
        q!: * {$sendPastPres * $moneyAndRub} * $comWhere *
        q!: $comWhere $moneyAndRub я $transferPast

        q!: * куда [мне] {$transferPast $moneyAndRub} *
        q!: [$helloAll] [$comYes] [$beginningWords] как (быстро/долго) {доходят $comMoney}
        q!: [$helloAll] [$comYes] [$beginningWords] (быстро/долго) $li {доходят $comMoney}
        q!: [$helloAll] [$comYes] [$beginningWords] [за] сколько [по времени] {доходят $comMoney}
        q!: [$helloAll] {$why [мне] $onBill $smsComePastPerfNe}
        q!: [$helloAll] {$why [мне] $onBill $sendPastPresNe}
        q!: [$helloAll] {$why [мне] $onBill $transferPastPresNe}

        q!: [$helloAll] {$moneyAndRub $moneyTakeOffPastPres} ($but/а) [$moneyAndRub] ($onBalanceLoc/$onBillLoc) {$comNo [их/$nothing]} [$why]
        q!: [$helloAll] {$moneyAndRub $moneyAddPastPres} ($but/а) [$moneyAndRub] ($onBalanceLoc/$onBillLoc) {$comNo [их/$nothing]} [$why]
        q!: * куда * $sendPartPas * $moneyAndRub *
        q!: * куда [у меня/$comMy] ушли [$comMy] $moneyAndRub *
        q!: * куда пришли [$comMy/мне] $moneyAndRub *
        q!: * (каков/~какой) ~срок * (~начисление/~зачисление) * $moneyAndRub *
        q!: * $skolko (проходит/длитс*/длитьс*) (~начисление/~зачисление/~перечисление) *
        q!: * $winTicket * {(~начисление/~зачисление/~перечисление) $comNo} *
        q!: * {(~начисление/~зачисление/~перечисление) $comNo} * $winTicket *
        q!: * $moneyAndRub {[$ne] сразу $smsComePres $onBill}
        q!: * $moneyAndRub $ne сели *
        q!: * $why $comNo перевода *

        intent!: /Payments/ICantToTransferTheMoney
        a: Уточните, пожалуйста, у Вас не получается пополнить Кошелек, перевести выигрыш на Кошелек или перевести выигрыш из Кошелька на сторонние ресурсы?

        state: LocalCatchAll || fromState = /Payments/ICantToTransferTheMoney
            event: noMatch
            script: Webim.switch();

    state: ICantToTransferTheMoneyToPurse
        # Не могу перевести деньги в Кошелек (не уточнено, выигрыш или при пополнении)
        q!: * {$cantPastPresAll * $transferInfImp * $moneyAndRub * $toWalletAll} *
        q!: * {$cantPastPresAll * $sendInf * $moneyAndRub * $toWalletAll} *
        q!: * {$cantPastPresAll * $moneyAddInf * $moneyAndRub * $toWalletAll} *

        q!: * {$transferInfNe * $moneyAndRub * $toWalletAll} *
        q!: * {$sendInfNe * $moneyAndRub * $toWalletAll} *
        q!: * {$moneyAddInfNe * $moneyAndRub * $toWalletAll} *
        q!: * {$transferPastPresNe * $moneyAndRub * $toWalletAll} *

        q!: * {$moneyAddPresNe * $moneyAndRub * $toWalletAll} *
        q!: * {$smsComePastPerfNe * $moneyAndRub * $toWalletAll} *
        q!: * {$smsComePresNe * $moneyAndRub * $toWalletAll} *

        q!: * {$smsComePastPerfNe * $moneyAndRub * (до [$comMy] $wallet)} *
        q!: * {$smsComePresNe * $moneyAndRub * (до [$comMy] $wallet)} *

        q!: * {$moneyAddPastPresNe * $moneyAndRub * $toWalletAll} *
        q!: * {$moneyAddPartPasNe * $moneyAndRub * $toWalletAll} *

        q!: * {$moneyAndRub * ($ne сели) * $toWallet} *

        q!: * {($transferInfImp/$sendInf/$moneyAddInf) * $toWallet * $error} *
        q!: * {($addPastPlSg3Ne/$transferPastPresNe) * [$moneyAndRub] * $toWallet} *
        q!: * когда * {$smsComeFut * $toWallet} *
        q!: * {($ne загружен*/незагружен*/низагружен*) * $toWallet} *
        q!: * {($ne попал*/непопал*/нипопал*) $toWallet} *

        q!: * {($when/$howLong) $oneWord $moneyAndRub $toWalletAll} *

        q!: * {$howLong * $moneyAddPastPres * $moneyAndRub * $toWalletAll} *
        q!: * {$slowly * $moneyAddPastPres * $moneyAndRub * $toWalletAll} *
        q!: * {$when * $moneyAddPastPres * $moneyAndRub * $toWalletAll} *

        q!: * {$howLong * $bonusComePastPres * $moneyAndRub * $toWalletAll} *
        q!: * {$slowly * $bonusComePastPres * $moneyAndRub * $toWalletAll} *
        q!: * $howLong * {$bonusComePastPres * $moneyAndRub} * $inWallet *
        q!: * $when * {$bonusComePastPres * $moneyAndRub} * $inWallet *
        q!: * {$when * $bonusComePastPres * $moneyAndRub * $toWalletAll} *

        q!: * {$howLong * $bonusComeFut * $moneyAndRub * $toWalletAll} *
        q!: * {$when * $bonusComeFut * $moneyAndRub * $toWalletAll} *
        q!: * $howLong * {$bonusComeFut * $moneyAndRub} * $inWallet *
        q!: * $when * {$bonusComeFut * $moneyAndRub} * $inWallet *
        q!: * {$howLong * $transferFut * $moneyAndRub * $toWalletAll} *
        q!: * {$when * $transferFut * $moneyAndRub * $toWalletAll} *

        q!: * ($transferFut/$bonusComeFut) $li * $moneyAndRub * $toWalletAll *

        q!: * {$transferPastPres * $moneyAndRub * $toWalletAll} * ($howLong/$when/$comWhere) *
        q!: * {$sendPastPres * $moneyAndRub * $toWalletAll} * ($howLong/$when/$comWhere) *

        q!: * {$transferPastPres * [$moneyAndRub] * $toWalletAll * $bonusComePastPresNe} *
        q!: * {$transferInfImp * [$moneyAndRub] * $toWalletAll * $transferPastPresNe} *
        q!: * {$sendPastPres * [$moneyAndRub] * $toWalletAll * $bonusComePastPresNe} *
        q!: * {$moneyAddPastPres * [$moneyAndRub] * $toWalletAll * $bonusComePastPresNe} *

        q!: * ($moneyAndRub * ($transferPastPres/$sendPastPres/$moneyAddPastPres)/($transferPastPres/$sendPastPres/$moneyAddPastPres) * $moneyAndRub)  * {$inWallet * ($updatePresPlSg3Ne/$updatePastNe)} *

        q!: * {($sendPastPerf/$transferPast) * $toWallet} * $comNo *
        q!: * {($ne все) * ($sendPastPerf/$transferPast) * $toWallet} *
        q!: * $inWallet $comNo переведен* ($sum/$comMoney) *
        q!: * загрузил* $comMoney $toWallet (а/$but) их *

        q!: * $howLong * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $toWalletAll *
        q!: * $when * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $toWalletAll *
        q!: * $waitInf * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $toWalletAll *
        q!: * {долго * (~начисление/~зачисление) * $toWalletAll} *

        q!: * {($comNo * ~поступление/~поступление * $comNo) * $toWallet} *
        q!: * $comNo * $inWallet * хотя * ($transferPastPres/$sendPastPres/$moneyAddPastPres) *
        q!: * {($ne (произошло/происходит)/непроизошло/нипроизошло/непроисходит/нипроисходит) * (~начисление/~зачисление) * $toWalletAll} *

        intent!: /Payments/ICantToTransferTheMoneyToPurse
        a: Уточните, пожалуйста, у Вас не получается пополнить Кошелек или перевести выигрыш на Кошелек?

        #####################Получение выигрыша################################

    state: HowToGetPrize
        # Как получить выигрыш
        q!: [$helloAll] (~правило/~способ) ~получение $prizeAndSum
        q!: [$helloAll] $winPastPerf
        q!: * $how * (забираетс*/забираетьс*) * $prizeAndSum *
        q!: * ~правило выплат* $prizeAndSum *
        q!: * ($comWhere/куда) * {(производят*/производит*/произвести) * ~выплата} *
        q!: * $winPastPerf * варианты * получения *
        q!: * {[$how] * $getInf * $prizeWithMoney} *
        q!: * {$how * получают * $prizeWithMoney} *
        q!: * {$comWhere получают $prizeWithMoney} *
        q!: * {$how * $getInf * $prizeWithMoney * $bySms} *
        q!: * {$how * $getInf * $prizeWithMoney * $ticket} *
        q!: * $how * выплата * крупн* $prizeWithMoney *
        q!: * ~большой $prizeWithMoney * $how * $transferPres3 *
        q!: * {$comWhere * $getInf * $prizeWithMoney * $ticket} *
        q!: [$helloAll] {$how [я] получу $prizeAndSum} *
        q!: [$helloAll] {$how $receiveInf $prizeAndSum}
        q!: [$helloAll] {($how/$comWhere) $getInf}
        # Где их обналичить
        q!: [$helloAll] {[$how/$comWhere] [его/ее/их] $cashoutInf}
        q!: * {$cashoutInf * $ticket} *
        # У меня выйгрыш, что сделать, чтобы забрать его
        q!: * (меня/я) * $win * $comWhat * ($doInfLocal/дальше/потом) *
        q!: * $comWhat * ($doInfLocal/дальше/потом) * ($me/я) * $win *
        # У меня выйгрыш, к кому я могу обратиться
        q!: * $win * (к кому/куда) * (обращат*/оброшатся/обратит*/идти) *
        q!: * (к кому/куда) * (обращат*/оброшатся/обратит*/идти) * $win *
        # Ссылка на получение выигрыша
        q!: [$helloAll] {(~получение/~обналичивание/~выдача/~выплата) $prizeAndSum}
        q!: * (куда/$how) {($transferPres3/$sendPres3/зачисляет*) $prizeWithMoney} *
        q!: * куда {$getPrizPresPlSg3 $prizeWithMoney} *
        q!: * $how $transferFut $prizeAndSum *
        q!: * куда * ($transferFut/$smsComeFut/приходит/выплачивает*/выплачивают*) * $prizeAndSum *
        q!: * $prizeAndSum * $bonusComeFut на *
        q!: * $prizeAndSum (приходит/поступает) автоматич* ($onBankCard/$onTelephone/$onQiwi/$onMoneyYandex) *
        q!: * подсказк* * ~получение $prizeAndSum *
        q!: * ~какой [пакет*] док* * (~получение/~оформление) [$oneWord] $prizeAndSum *
        q!: * {$winPastPerf * ($how/$comWhere) * $getInf} *
        q!: * {$winPastPerf * ($how/$comWhere) * $cashoutInf} *

        q!: * $ifAll * ($winPastPerf/$winFutSg13) * {куда (выплату/выплаты) [делают]} *
        q!: * $ifAll * ($winPastPerf/$winFutSg13) * {$how (выплату/выплаты) делают} *
        q!: * $ifAll * ($winPastPerf/$winFutSg13) * {(куда/$how) оплату делают} *

        q!: * $ifAll * ($winPastPerf/$winFutSg13) * $how * (передадут/передадите) *
        q!: * $ifAll * ($winPastPerf/$winFutSg13) * $prizeAndSum * появл* *


        q!: * $ifAll * ($winPastPerf/$winFutSg13) $nextActions *
        q!: * $ifAll $prizeAll $nextActions *

        q!: * $ifAll * $winFutSg13 * (~крупный/$comWhat) *
        q!: * ~выплата * ~крупный * *прашиваете *
        q!: * $winTicket * $exchangeInf на $comMoney *
        q!: у меня ($prize/$win $moneyAndRub)
        q!: [$helloAll] [я] $winPastPerf [в] $generalNamedLottery
        q!: * $comNeed $li для получения * $prizeAll * (хранить/сохранять) *
        q!: * $Number $comMy $ticket $winPastPerf *
        q!: * $comNeed * получ* * $prizeAll * ~офис *
        intent!: /Payments/HowToGetPrize
        a: Способ получения выигрыша зависит от способа оформления билета, вида лотереи и суммы выигрыша. Полная инструкция по получению выигрыша размещена по ссылке http://www.stoloto.ru/lottery/winning . Ознакомьтесь, пожалуйста. Если у Вас останутся вопросы, пожалуйста, обращайтесь.

        state: IBoughtInPyaterochka
            # Покупал в Пятерочке
            q: * {$buyPastPres * $pyaterochka} *
            q: * {взял* * $pyaterochka} *
            q: * {брал* * $pyaterochka} *
            q: * ($ticket/$lottery/лото) из $pyaterochka *
            a: К сожалению, в магазинах «Пятерочка» выигрыш получить невозможно. Процедура получения выигрыша зависит от суммы выигрыша:\n\nдо 1 000 рублей – Вы сможете получить в салоне связи «Мегафон»;\nот 1 000 до 10 000 рублей – в салонах связи «Евросеть»/«Связной»;\nдо 10 000 рублей - в отделениях Почты России;\nдо 500 000 рублей – на нашем сайте, в Кошелек Столото.

        state: IBoughtOnline
            # Покупал в интернете
            q!: * {$getInf * $prizeWithMoney} * ($buyPastPres/взял*/брал*/$paid/играл*) * ($online/черезсайт/черезъсайт/черезьсайт/электроно/электронно/по $internet/(на/через/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/$internet/$application/~программа/комп/~компьютер/моб* ~версия)) *

            q!: * {$getInf * $prizeWithMoney} * * ($online/черезсайт/черезъсайт/черезьсайт/электроно/электронно/по $internet/(на/через/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/$internet/$application/~программа/комп/~компьютер/моб* ~версия)) * ($buyPastPres/взял*/брал*/$paid/играл*) *

            q!: * ($buyPastPres/взял*/брал*/$paid/играл*) * ($online/черезсайт/черезъсайт/черезьсайт/электроно/электронно/по $internet/(на/через/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/$internet/$application/~программа/комп/~компьютер/моб* ~версия)) * {$getInf * $prizeWithMoney} *

            q!: * ($online/черезсайт/черезъсайт/черезьсайт/электроно/электронно/по $internet/(на/через/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/$internet/$application/~программа/комп/~компьютер/моб* ~версия)) * ($buyPastPres/взял*/брал*/$paid/играл*) * {$getInf * $prizeWithMoney} *

            q!: * {получу * $prizeWithMoney} * $buyFut * ($online/черезсайт/черезъсайт/черезьсайт/электроно/электронно/по $internet/(на/через/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/$internet/$application/~программа/комп/~компьютер/моб* ~версия)) *

            q: {$buyPastPres $here}
            q: {взял* $here}
            q: {брал* $here}
            q: * ($buyPastPres/взял*/брал*/$paid/играл*) * ($online/черезсайт/черезъсайт/черезьсайт/электроно/электронно/по $internet/(на/через/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/$internet/$application/~программа/комп/~компьютер/моб* ~версия)) *

            q: * ($online/черезсайт/черезъсайт/черезьсайт/электроно/электронно/по $internet/(на/через/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/$internet/$application/~программа/комп/~компьютер/моб* ~версия)) * ($buyPastPres/взял*/брал*/$paid/играл*) *

            a: Уточните, пожалуйста, у Вас есть регистрация на сайте www.stoloto.ru?

            state: IAmRegistered
                q: $comYes [$comYes]
                q: [$comYes] [$comYes] [у меня] (есть/имеет*/имею) [у меня]
                q: * (есть/имеет*/имею) * $registration *
                q: * $registration * (есть/имеет*/имею) *
                q: * {я $registered} *
                q: $registered
                q: * {заводил* $account} *
                q: * $registration прошла *
                q: * пришлось $registerInfRefl *
                q: * $registerPastRefl3 *
                a: Вы можете перевести выигрыш в Кошелек Столото, а затем воспользоваться им для оплаты новых билетов на сайте или перевести на сторонний ресурс.\n\nА также можно выписать из квитанции уникальный ключ и обратиться с кодом выигрыша и паспортом в точку распространения для получения наличными (кроме Почты России).\n\nС подробной информацией Вы можете ознакомиться, пройдя по ссылке: https://www.stoloto.ru/lottery-winning

            state: IAmNotRegistered
                q: $comNo [$comNo]
                q: [$comNo] [у меня] ($comNo/$ne имеет*/$ne имею) [у меня]
                q: * ($comNo/$ne имеет*/$ne имею) * $registration *
                q: * $registration * ($comNo/$ne имеет*/$ne имею) *
                q: * {я $registeredNe} *
                q: $registeredNe
                q: * $registerPastContReflSg3Ne *
                q: * ($ne заводил*/незаводил*/низаводил*) $account *
                q: * $account ($ne заводил*/незаводил*/низаводил*) *
                a: Вы можете зарегистрироваться на сайте с номером телефона, указанным Вами при покупке билета. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты».\n\nИнструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: www.stoloto.ru/registration .\n\nЕсли после успешной регистрации Вы не видите Ваш билет в личном кабинете, то напишите нам, пожалуйста.


    state: HowToGetPrizeIfTheNumberHasChanged
        # Как получить выигрыш, если номер изменился
        q!: * {$getPrizInf * $prizeWithMoney} * {$changePast * $phoneAndNum} *
        q!: * {$changePast * $phoneAndNum} * {$getPrizInf * $prizeWithMoney} *
        q!: * {$getPrizInf * $prizeWithMoney} * $phoneAndNum * ($ne актив*/неактив*) *
        q!: * $phoneAndNum * ($ne актив*/неактив*) * {$getPrizInf * $prizeWithMoney} *
        q!: * {$getPrizInf * $prizeWithMoney} * {утерян * $phoneAndNum} *
        q!: * {утерян * $phoneAndNum} * {$getPrizInf * $prizeWithMoney} *
        q!: * {$getPrizInf * $prizeWithMoney} * {((доступа/доспупа) к [$oneWord] $phoneAndNum) * $comNo} *
        q!: * {((доступа/доспупа) к [$oneWord] $phoneAndNum) * $comNo} * {$getPrizInf * $prizeWithMoney} *
        q!: * {$getPrizInf * $prizeWithMoney * ($wrong $phoneAndNum) * [$duringRegistration]} *
        q!: * {$getPrizInf * $prizeWithMoney * (~новый $phoneAndNum)} *
        q!: * {$getPrizInf * $prizeWithMoney * (сейчас * ~другой $phoneAndNum)} *
        q!: * {$getPrizInf * $prizeWithMoney} * $phoneAndNum другой *
        q!: * {$getPrizInf * $prizeWithMoney * ($phoneAndNum $old)} *

        q!: * {утерян * $phoneAndNum} * $onExternalResource *

        q: * {[$getPrizInf] * $comMoney} * || fromState = /Phone/PhoneNumberChange/InLK
        q: * {[$getPrizInf] * $prize} * || fromState = /Phone/PhoneNumberChange/InLK
        q: * {быть * $comMoney} * || fromState = /Phone/PhoneNumberChange/InLK
        q: * {быть * $prize} * || fromState = /Phone/PhoneNumberChange/InLK
        q: * {$comWhat * делать * ($comMoney/$prize)} * || fromState = /Phone/PhoneNumberChange/InLK


        q: * {$changePast * $phoneAndNum} * || fromState = /Payments/HowToWithdrawMoney
        q: * {утерян * $phoneAndNum} * || fromState = /Payments/HowToWithdrawMoney
        q: * {(доступа к [$oneWord] $phoneAndNum) * $comNo} * || fromState = /Payments/HowToWithdrawMoney
        q: * ~новый $phoneAndNum * || fromState = /Payments/HowToWithdrawMoney
        q: * сейчас * ~другой $phoneAndNum * || fromState = /Payments/HowToWithdrawMoney
        q: * $phoneAndNum другой * || fromState = /Payments/HowToWithdrawMoney
        q: * $phoneAndNum * ($ne актив*/неактив*) * || fromState = /Payments/HowToWithdrawMoney

        intent!: /Payments/HowToGetPrizeIfTheNumberHasChanged
        a: Вам необходимо создать новый личный кабинет с новым номером телефона и перевести денежные средства из старого аккаунта в новый.\n\nДля перевода денежных средств из одного личного кабинета в другой необходимо, чтобы оба кабинета были идентифицированы.\n\nПройти идентификацию Вы можете, находясь на странице с информацией, по ссылке: https://www.stoloto.ru/wallet_identification . Вам просто необходимо нажать на желтую кнопку «Пройти идентификацию» и далее следовать инструкциям.\n\nЕсли у Вас пройдена идентификация, то направьте, пожалуйста, на почту info@stoloto.ru следующие документы:\n- скан Вашего паспорта (страница с фото);\n- договор с оператором сотовой связи на Ваш старый номер телефона (можно запросить у оператора);\n- договор с оператором сотовой связи на Ваш новый номер телефона (можно запросить у оператора);\n- заявление в свободной форме о переводе денежных средств из старого кабинета в новый (написано от руки и отсканировано или сфотографировано).\n\nПример заявления:\n\nЯ, (ФИО в именительном падеже), (дата рождения), проживающая по адресу (адрес с индексом), (номер телефона), являюсь зарегистрированным пользователем на Вашем сайте www.stoloto.ru (указываете логин, почту и номер телефона от личного кабинета нашего сайта). На 01.11.2014 (дату заявления ставите) на счете Кошелька Столото № (номер Кошелька вышеуказанного кабинета) данного личного кабинета находятся (указываете баланс Кошелька) рублей. К сожалению, данными средствами нет возможности воспользоваться, номер телефона (указываете номер телефона от личного кабинета) более не работоспособен. Прошу помочь в разрешении данной ситуации. Прошу осуществить перевод средств из моего старого Кошелька Столото № (номер Кошелька вышеуказанного кабинета) в мой новый Кошелек Столото № (номер нового Кошелька нового кабинета) личного кабинета (указываете логин, почту и номер телефона от нового личного кабинета нашего сайта), где номер телефона работоспособен и я могу ими воспользоваться.\n(ниже дату, подпись и расшифровку подписи).\n\nВ случае, если у Вас нет возможности предоставить договор с оператором связи, то Вам необходимо пройти полную идентификацию с помощью скайпа в двух личных кабинетах. Пройти идентификацию Вы можете, находясь на странице с информацией, по ссылке: https://www.stoloto.ru/wallet_identification . Вам просто необходимо нажать на желтую кнопку «Пройти идентификацию» и далее следовать инструкциям.\n\nНаправьте, пожалуйста, комплект документов на электронную почту info@stoloto.ru. В теме письма укажите «Перевод средств».


    state: WinDeadlines
        # Какие сроки получения выигрыша?
        q!: * {(~ограничение по времени) * (~получение $prizeAndSumAndWinTicket)} *
        q!: * (каков/~какой) ~срок * (~получение/~выплата) ($prizeAndSumAndWinTicket/(по/у) $ticket) *
        q!: * есть ли сроки (~получение $prizeAndSumAndWinTicket) *
        q!: * {(у ~получение $prizeAndSumAndWinTicket) * (есть ~срок)} *
        q!: * сориентир* по срокам (~получение $prizeAndSumAndWinTicket) *
        q!: * ~срок обращения за * $prizeAndSum *
        q!: * $when * {(истекает/истечет) * срок * ((~получение/~выплата) ($prizeAndSumAndWinTicket/(по/у) $ticket))} *
        intent!: /Payments/WinDeadlines
        script: Webim.switch();


    state: HowToGetOldPrize
        # Как получить старый выигрыш
        q!: * более 180 дней *
        q!: * $prize действителен * (полгода/пол года/6 месяцев/180 дней) *
        q!: * {~заявление * $prize} *
        q!: * (~пропуск/пропустил*) ~время ~выплата * $prize *
        q!: * {(истек/истекли) * ~срок * (~выплата/$prize)} *
        q!: * срок $prize прошел *
        q!: * (есть/имеет*/имею) * $oldPrize *
        q!: * ($ne получен*/неполучен*/ниполучен*) $oldPrize *
        q!: * {$receivedNe * $oldPrize} *
        q!: * {[$cantPastPresAll] * $getPrizInf * $oldPrize * [$w1All]} *
        q!: * {$getPrizInfNe * $oldPrize * [$w1All]} *
        q!: * {$getPrizPastPresNe * $oldPrize * [$w1All]} *
        q!: * {$getPrizPresPlSg3 * $oldPrize * [$w1All]} *
        q!: * {[$cantPastPresAll] * $transferInfImp * $oldPrize * [$w1All]} *
        q!: * {$transferInfNe * $oldPrize * [$w1All]} *
        q!: * {$transferPres3 * $oldPrize * [$w1All]} *
        q!: * {$transferPastPresNe * $oldPrize * [$w1All]} *
        q!: * {[$cantPastPresAll] * $sendInf * $oldPrize * [$w1All]} *
        q!: * {$sendInfNe * $oldPrize * [$w1All]} *
        q!: * {$sendPres3 * $oldPrize * [$w1All]} *
        q!: * {$sendPastPresNe * $oldPrize * [$w1All]} *
        q!: * {[$cantPastPresAll] * $moneyAddInf * $oldPrize * [$w1All]} *
        q!: * {$moneyAddInfNe * $oldPrize * [$w1All]} *
        q!: * {$moneyAddPastPresNe * $oldPrize * [$w1All]} *
        q!: * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) $oldPrize * [$w1All] *

        q!: * {[$cantPastPresAll] * $getPrizInf * $oldPrize * $toWalletAll} *
        q!: * {[$cantPastPresAll] * $depositInf * $oldPrize * $toWalletAll} *
        q!: * {$getPrizInfNe * $oldPrize * $toWalletAll} *
        q!: * {$getPrizPastPresNe * $oldPrize * $toWalletAll} *
        q!: * {$getPrizPresPlSg3 * $oldPrize * $toWalletAll} *
        q!: * {[$cantPastPresAll] * $transferInfImp * $oldPrize * $toWalletAll} *
        q!: * {$transferInfNe * $oldPrize * $toWalletAll} *
        q!: * {$transferPres3 * $oldPrize * $toWalletAll} *
        q!: * [$getPrizInf] * {$transferPastPresNe * $oldPrize * $toWalletAll} *
        q!: * {[$cantPastPresAll] * $sendInf * $oldPrize * $toWalletAll} *
        q!: * {$sendInfNe * $oldPrize * $toWalletAll} *
        q!: * {$sendPres3 * $oldPrize * $toWalletAll} *
        q!: * {$sendPastPresNe * $oldPrize * $toWalletAll} *
        q!: * {[$cantPastPresAll] * $moneyAddInf * $oldPrize * $toWalletAll} *
        q!: * {$moneyAddInfNe * $oldPrize * $toWalletAll} *
        q!: * {$moneyAddPastPresNe * $oldPrize * $toWalletAll} *
        q!: * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) $oldPrize * $toWalletAll *
        q: * $oldPrize * || fromState = /Payments/HowToGetPrize
        q: * $oldPrize * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * $oldPrize * || fromState = /Payments/CantWithdrawMoneyToPurse
        q: * $oldPrize * || fromState = /Payments/HowToWithdrawMoney
        q: * $oldPrize * || fromState = /Payments/WithdrawDoesntWork
        q: * $oldPrize * || fromState = /Payments/WithdrawDoesntWorkRusLoto

        intent!: /Payments/HowToGetOldPrize
        a: Выигрыши по тиражам, с момента проведения которых прошло более 6 месяцев, могут быть выплачены на основании Вашего письменного заявления в том случае, если мы признаем причину неполучения выигрыша уважительной. После рассмотрения заявления мы либо перечислим сумму выигрыша на указанный в заявлении счет, либо в письменной форме вышлем уведомление об отказе в выплате (вместе с оригиналом Вашего билета).\n\nСписок документов, которые необходимо нам направить на почтовый адрес:\n\n1. оригинал билета (или квитанцию, распечатанную из личного кабинета);\n2. заявление (скачать форму заявления можно по ссылке https://www.stoloto.ru/lottery-winning );\n3. копию паспорта ( 2-я, 3-я стр. и страницу с пропиской);\n4. банковские реквизиты (точный перечень реквизитов Вы можете посмотреть по ссылке https://www.stoloto.ru/lottery-winning ).\n\nАдрес для отправки: 109316, г. Москва, Волгоградский проспект, д. 43, корп. 3, Акционерное общество «Технологическая компания «Центр».\n\nС более подробной информацией о том, как получить выигрыш, Вы можете ознакомиться на нашем сайте, пройдя по ссылке https://www.stoloto.ru/lottery-winning .


    state: GaveTicketHowToGetPrize
        # Подарили билет, он выиграл, как получить приз?
        q!: * {$giftPast * $ticketAll * $getPrizInf * $prizeWithMoney} *
        q!: * {$giftPast * $ticketAll * $cashoutInf} *
        q!: * {$giftPast * $ticketAll * (~получение/$withdrawalToPurse/~обналичивание/~выдача) * $prizeWithMoney} *
        q!: * {$giftPast * $ticketAll * $winPastPerf} *
        q!: * {$giftPast * $ticketAll * $win} *
        intent!: /Payments/GaveTicketHowToGetPrize
        script: Webim.switch();


    state: ForeignerHowToGetPrize
        # Как получить выигрыш, если у тебя нет паспорта РФ и ты иностранец
        q!: * {$foreigner * $getPrizInf * $prizeWithMoney} *
        q!: * {$foreigner * $cashoutInf} *
        q!: * {$foreigner * (~получение/$withdrawalToPurse/~обналичивание/~выдача/получу) * $prizeWithMoney} *
        q!: * {$foreigner * $ticketAll * $winPastPerf} *
        q!: * {$foreigner * $ticketAll * $win} *
        intent!: /Payments/ForeignerHowToGetPrize
        script: Webim.switch();


    state: WhereIsThePrize
        # Где выигрыш

        q!: [$helloAll] ~выплата ($ne прошл*/непрошл*/нипрошл*)
        q!: [$helloAll] ($ne прошл*/непрошл*/нипрошл*) ~выплата
        q!: * $comWhere [еще] [этот] [$comMy] $prizeAndSum *
        q!: * $comWhere [же] [$comObsceneWord/$negative] [$comMy] $prizeAndSum *
        q!: [$helloAll] [$comYes] {[$beginningWords] $comWhat [$comObsceneWord] $with [$comMy] $prizeAndSum}
        q!: * {($returnImp/отдайте) [$comMy] $prizeAndSum} *
        q!: * {зависли [$comMy] $prizeAndSum} *
        q!: * $winPastPerf * $comWhere (они/$comMoney) *
        q!: * (куда/$comWhere) (делс*/делис*) * ($prize/$winPastPerf) *
        q!: * {([$comMy] [$ne выпл*/невыпл*/нивыпл*] $prizeAndSum [$comMy]) ([гдето/где-то/где то/кудато/куда-то/куда то] (потерялис*/потерялс*/пропал*) [гдето/где-то/где то/кудато/куда-то/куда то]/$receivedNe/$ne оплачивают/неоплачивают/ниоплачивают/$ne зачли/$findPastPresNe/украл*)} *
        q!: {$prize $comNo}

        intent!: /Payments/WhereIsThePrize
        a: Опишите подробнее, пожалуйста, в чем у Вас возникла сложность?


    state: HowToTransferPrize
        # Как перевести выигрыш (без уточнения, куда)
        q!: * {$transferInfImp * $prizeAll} *
        q!: * {$sendInf * $prizeAll} *
        q!: * {$moneyAddInf * $prizeAll} *

        q!: * $prizeAll [$beginningWords] {[$how/$want] [мне/я] [$possiblePredicAll/могу/магу] $getPrizInf [$comMy] $prizeWithMoney} [к] себе $onBill
        q!: * $prizeAll [$beginningWords] {[$how/$want] [мне/я] [$possiblePredicAll/могу/магу] $getPrizInf [$comMy] $moneyAndRub} [к] себе $onBill


        q!: [$helloAll] {(~вывод/~выведение/~перевод/~отправка) $prizeAndSum}
        q!: [$helloAll] {(~вывод/~выведение) $moneyAndRub}
        q!: * порядок (~вывод/~выведение/~снятие/~обналичивание) *
        q!: [$helloAll] [извините] [меня] [$please] [$ne] [*скаж*/науч*] [$beginningWords] вывод $prizeWithMoney $how
        q!: * {$prizeAll * $withdrawInf} *
        q!: * {($how/могу/магу/$want/$possiblePredicAll/разобратьс*/разобратс*/разобратц*/разобрац*) * $withdrawInf * [~способ/$moneyAndRub]} *


        q!: * {[$generalNamedLottery] * $withdrawInf} *
        q!: * $how * (снимаютс*/снимаютьс*/вывод/выведение) *
        q!: * {произвести ~выплата} *
        intent!: /Payments/HowToTransferPrize
        a: Уточните, пожалуйста, Вы хотите перевести выигрыш в Кошелек Столото или из Кошелька Столото на сторонний ресурс?

        state: LocalCatchAll || fromState = /Payments/HowToTransferPrize
            event: noMatch
            script: Webim.switch();


    state: ThereIsNoGreenButton
        # Тут нет зеленой кнопки
        q!: * {[$here] $comNo $green $button} *
        q!: * {[$here] $findPastPresNe $green $button} *
        intent!: /Payments/ThereIsNoGreenButton
        a: Уточните, пожалуйста, Вы хотите вывести выигрыш в Кошелек или из Кошелька на сторонний ресурс?

        state: LocalCatchAll || fromState = /Payments/ThereIsNoGreenButton
            event: noMatch
            script: Webim.switch();


    state: ICantToTransferPrize
        # Не могу перевести выигрыш (без уточнения, куда)
        q!: * {$cantPastPresAll * $transferInfImp * $prizeAll} *
        q!: * {$cantPastPresAll * $sendInf * $prizeAll} *
        q!: * {$cantPastPresAll * $moneyAddInf * $prizeAll} *
        q!: * {$cantPastPresAll * $getPrizInf * $prizeAndSumAndWinTicket} *
        q!: * {$cantPastPresAll * $depositInf * $prizeAndSumAndWinTicket} *
        q!: * {$cantPastPresAll * $withdrawInf * $moneyAndRub} *
        q!: * {$cantPastPresAll * $withdrawInf * $generalNamedLottery} *

        q!: * $withdrawInf * $error *
        q!: * пытаюс* $withdrawInf *
        q!: * $why * {$nelzya * $withdrawInf} *
        q!: * когда * $transferInfImp * $prizeAll *
        q!: * когда * $sendInf * $prizeAll *
        q!: * когда * {$smsComeFut * $prizeAll} *
        q!: * $ticket * $prize * ($moneyAddInf нет/$moneyAddInfNe/{$moneyAddPartPas (нет/не)}) *

        q!: * {$transferInfNe * $prizeAll} *
        q!: * {$sendInfNe * $prizeAll} *
        q!: * {$moneyAddInfNe * $prizeAll} *
        q!: * {($payOffPastPresNe/$ne сели) * $prizeAll} *

        q!: * {$withdrawPres3Ne * $prizeWithMoney} *
        q!: * {$withdrawPres3Ne * $moneyAndRub} *
        q!: * {$withdrawPres3Ne * $prizeAll} *
        q!: * {$withdrawPres3Ne * $generalNamedLottery} *
        q!: * {$withdrawPastPerf3Ne * $prizeWithMoney} *
        q!: * {$withdrawPastPerf3Ne * $moneyAndRub} *
        q!: * {$withdrawPastPerf3Ne * $prizeAll} *
        q!: * {$withdrawPastPerf3Ne * $generalNamedLottery} *
        q!: * {$getPrizPastPresNe * $prizeAndSumAndWinTicket} *

        q!: * {$moneyAddPastPresNe * $prizeAll} *
        q!: * {$moneyAddPartPasNe * $prizeAll} *
        q!: * {$smsComePastPerfNe * $prizeAll} *
        q!: * {$smsComePastPerfNe * $moneyAndRub * $winPastPerf} *
        q!: * {$smsComePresNe * $prizeAll} *
        q!: * {$transferPastPresNe * $prizeAll} *
        q!: * {($ne проходит/непроходит/нипроходит) * $prizeAll} *
        q!: * куда * {$bonusDisappearPastPres * $prizeAndSum} *
        q!: * {(куда * (ушел/ушли/$sendPartPas/$transferPast/направилс*)) * $prizeAndSumAndWinTicket} *
        q!: * {уходят * $prizeAll} *
        q!: * {($ne (весь/все/полностью)) * $prizeAndSumAndWinTicket} *
        q!: * $prizeAndSum $only по *
        q!: * $prizeAll * $bonusComePastPres $only *
        q!: * {$findPastPresNe * $prizeAndSum} *
        q!: * $prizeAndSum * так и $comNo *
        q!: * $prizeAll * $comMoney $comNo *
        q!: * $prizeAll * $numberRub * $bonusComePastPres * $numberRub *
        q!: * $prizeAll * $numberRub * $moneyAddPartPas *

        q!: * {~вывод * $prizeWithMoney * $error} *
        q!: * {~вывод * $prizeAll * $error} *
        q!: * {$cantPastPresAll * ~вывод * $prizeWithMoney} *
        q!: * {$cantPastPresAll * ~вывод * $prizeAll} *

        q!: * {$howLong * $moneyAddPastPres * $prizeAndSumAndWinTicket} *
        q!: * {$slowly * $moneyAddPastPres * $prizeAndSumAndWinTicket} *
        q!: * {$when * $moneyAddPastPres * $prizeAndSumAndWinTicket} *

        q!: * {$howLong * $bonusComePastPres * $prizeAndSumAndWinTicket} *
        q!: * {$slowly * $bonusComePastPres * $prizeAndSumAndWinTicket} *
        q!: * {$when * $bonusComePastPres * $prizeAndSumAndWinTicket} *

        q!: * {$howLong * $bonusComeFut * $prizeAndSumAndWinTicket} *
        q!: * {$when * $bonusComeFut * $prizeAndSumAndWinTicket} *
        q!: * {$howLong * $transferFut * $prizeAndSumAndWinTicket} *
        q!: * {$when * $transferFut * $prizeAndSumAndWinTicket} *

        q!: * ($bonusComeFut/$transferFut) $li * $prizeAndSumAndWinTicket *

        q!: * {$slowly * $transferPres3 * $prizeAll} *
        q!: * {$slowly * $sendPres3 * $prizeAll} *
        q!: * {$howLong * $transferPres3 * $prizeAll} *
        q!: * {$howLong * $sendPres3 * $prizeAll} *

        q!: * {$transferPastPres * $prizeAndSum} * ($comWhere/$only/$comNo) *
        q!: * там $only $oneWord $prizeAndSum *
        q!: * $prizeAll * $transferPast *
        q!: * {$sendPastPres * $prizeAndSum} * $comWhere *
        q!: * $comNo * (~начисление/~зачисление/~перечисление) $prizeAll *
        q!: * $winPastPerf * {$comMoney $findPastPresNe} *
        q!: * $winPastPerf * {($comMoney/$nothing) $comNo} *
        q!: * $winPastPerf * {$onBalance * $bonusComePastPresNe} *
        q!: * $winPastPerf * {$onBill * $bonusComePastPresNe} *
        q!: * ($problem/$error) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeAndSumAndWinTicket *
        q!: * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeAndSumAndWinTicket * ($problem/$error/(чтото/что то/что-то) * $ne так) *
        q!: * {$bonusComePastPresNe * $prizeAll * $onBillLoc} *
        q!: * {$bonusComePastPresNe * $prizeAll * $onBalanceLoc} *
        q!: * {$prizeAndSum * ($ne (появил*/появлял*/появляет*/появляют*)/непоявил*/непоявлял*/непоявляет*/непоявляют*/нипоявил*/нипоявлял*/нипоявляет*/нипоявляют*/$displayPresPl3Ne/$displayPresSg3Ne/$displayPastNe)} *
        q!: * $prizeAll * $balance * ~прежний *
        q!: * $prizeAll * (а/$but) $moneyAddPastPres *


        q!: * $howLong * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeAndSumAndWinTicket *
        q!: * $when * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeAndSumAndWinTicket *
        q!: * $waitInf * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeAndSumAndWinTicket *
        q!: * $skolko * $waitInf $prizeAndSumAndWinTicket *
        q!: * долго * длит* * ~выплата *
        q!: * {(долго/$howLong) * $getPrizPresPlSg3} *
        q!: * $prizeAll {$ne сразу $smsComePres $onBill}
        q!: * $winPastPerf * {$comMoney $displayPresSg3Ne} *

        q!: * $winPastPerf $Number $ticket * $only за *

        q!: * $prizeAll * $comWhere * $moneyAndRub *
        q!: * $prizeAll * $comMoney $comWhere *
        q!: [$helloAll] {$ticket ($ne выплачен)}
        q!: [$helloAll] {$prizeAll ($ne выплачен)}
        q!: * куда {вывел* [$comMy] $prizeAll} *
        q!: * куда {вывел* [$comMy] $moneyAndRub} *
        q!: * куда {$moneyAddPartPas [$comMy] $prizeAll} *
        q!: * $prizeAll * куда * (ушли/ушел) *
        q!: * (вывел/вывела/вывели) * $comWhere (он/они) *

        q!: $transferImp * $prizeAll $onBill

        q!: * $prizeAll * $ne сразу $bonusComePastPres * $onBill *
        q!: * $prizeAll * $ne сразу $onBill $bonusComePastPres *

        q!: * $prizeAll * $onBillLoc (его/ево/иво/их) $comNo *
        q!: * $prizeAll * $onBillLoc $nothing *
        q!: * {$getPrizPastPres * $prizeAll} * ($moneyAndRub/$nothing) $comNo *
        q!: * $smsComePast $prizeAll $only $with одн* $ticketAndLottery *
        q!: * $transferPartPas * меньше * (выиграно/$winPastPerf) *

        q!: * {$cantPastPresAll * (произвести ~выплата/~выплата произвести)} *

        intent!: /Payments/ICantToTransferPrize
        a: Уточните, пожалуйста, у Вас не получается перевести выигрыш на Кошелек или из Кошелька на сторонние ресурсы?

        state: LocalCatchAll || fromState = /Payments/ICantToTransferPrize
            event: noMatch
            script: Webim.switch();


    state: HowToWithdrawMoneyToPurse
        # Как перевести выигрыш в Кошелек?
        q!: * порядок (~вывод/~выведение/~снятие/~обналичивание) * $toWallet *
        q!: * $comWhat [$oneWord] перевести $toWallet *
        q!: * [$how] $getPrizInf $toWallet *
        q!: * $prizeAll {$comNeed $toWallet} *
        q!: * {[$how] $getPrizInf ($prizeAll/~розыгрыш) $toWallet} *
        q!: * {выведите * ($prizeAll/~розыгрыш) * $toWallet} *
        q!: * {$transferInfImp * ($prizeAll/~розыгрыш) * $toWallet} *
        q!: * {$sendInf * ($prizeAll/~розыгрыш) * $toWallet} *
        q!: * {$moneyAddInf * ($prizeAll/~розыгрыш) * $toWallet} *
        q!: * {$moneyAddInf * ($prizeAll/~розыгрыш) * $onBalance} *
        q!: * {$transferInfImp * ($prizeAll/~розыгрыш) * $onBalance} *
        q!: [$helloAll] {$sendInf [$please] ($prizeAll/~розыгрыш) ([$comMy] $walletNom)}
        q!: [$helloAll] {$moneyAddInf [$please] ($prizeAll/~розыгрыш) ([$comMy] $walletNom)}
        q!: [$helloAll] {$transferInfImp [$please] ($prizeAll/~розыгрыш) ([$comMy] $walletNom)}

        q!: * {внести * ($prizeAll/~розыгрыш) * $toWallet} *
        q!: * {добавить * ($prizeAll/~розыгрыш) * $toWallet} *
        q!: * {оформить * ($prizeAll/~розыгрыш) * $toWallet} *

        q!: * {$getPrizInf $prizeAndSum $toAccount} *
        q!: * {$transferInfImp * $prizeAndSumAndWinPast * $toAccount} *
        q!: * {$sendInf * $prizeAndSumAndWinPast * $toAccount} *
        q!: * {$moneyAddInf * $prizeAndSumAndWinPast * $toAccount} *

        q!: * {$depositInf * $prizeAll * $toWalletAll} *

        q!: * $how ($transferPres3/$sendPres3) $prizeAndSum $toWalletAll *

        q!: * $forTo * {$getPrizPastPres $prizeAndSum $toWalletAll} *
        q!: * $forTo * {$transferPastPres $prizeAndSum $toWalletAll} *
        q!: * $forTo * {$sendPastPres $prizeAndSum $toWalletAll} *
        q!: * $forTo * {$moneyAddPastPres $prizeAndSum $toWalletAll} *

        q!: * {$getPrizInf $prizeAndSum $toWalletAll} *
        q!: * {$transferInfImp $prizeAndSum $toWalletAll} *
        q!: * {$sendInf $prizeAndSum $toWalletAll} *
        q!: * {$moneyAddInf $prizeAndSum $toWalletAll} *
        q!: * {внести $prizeAndSum $toWalletAll} *
        q!: * {$depositInf $prizeAndSum $toWalletAll} *

        q!: * {$withdrawInf $moneyAndRub $toWalletAll} *
        q!: * {($how/могу/магу/$want/$possiblePredicAll) * $withdrawInf * $toWalletAll} *

        q!: [$helloAll] (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) $prizeAndSumAndWinTicket $toWalletAll
        q!: [$helloAll] $withdrawalToPurse $moneyAndRub $toWalletAll

        q!: * ($comWhat $comNeed/помож*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeAndSumAndWinTicket * $toWalletAll *

        q: $toWalletAll || fromState = /Payments/HowToGetPrize
        q: в [$stoloto] || fromState = /Payments/HowToTransferPrize
        q: [$comMy] $walletNom [$stoloto] || fromState = /Payments/HowToTransferPrize
        q: * $toWalletAll * || fromState = /Payments/HowToTransferPrize

        q: {[я] [$want] $prizeAndSumAndWinTicket $toWallet} || fromState = /Payments/HowToTransferTheMoney
        q: {[я] [$want] $prizeAndSumAndWinTicket [$toWallet]} || fromState = /Payments/HowToTransferTheMoneyToPurse
        q: {[я] [$want] перевести} || fromState = /Payments/HowToTransferTheMoneyToPurse

        intent!: /Payments/HowToWithdrawMoneyToPurse
        a: Получить выигрыш Вы можете в Ваш Кошелек Столото. Для этого Вам необходимо зайти на страницу Вашей квитанции, нажав на ее номер в разделе «Мои билеты». Далее Вы увидите большую зеленую кнопку «Перевести выигрыш в Кошелек». Нажмите на нее, пожалуйста. Код выигрыша для получения выигрыша в Кошелек Столото не нужен. Пройдя по ссылке https://www.stoloto.ru/private/tickets/type/winners , Вы сможете увидеть Ваши выигрышные квитанции. Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации - по ссылке http://www.stoloto.ru/registration


    state: HowToWithdrawMoneyFromPaperTicketToPurse
        # Как вывести бумажный билет в Кошелек
        q!: * {$withdrawInf * $notETicket} *
        q!: * {(сделать ~выплата) * $notETicket} *
        q!: * {$getPrizInf * $notETicket * $toWallet} *
        q!: * {$transferInfImp * $notETicket * $toWallet} *
        q!: * {$sendInf * $notETicket * $toWallet} *
        q!: * {$moneyAddInf * $notETicket * $toWallet} *

        q!: * {$getPrizInfNe * $notETicket * $toWallet} *
        q!: * {$transferInfNe * $notETicket * $toWallet} *
        q!: * {$sendInfNe * $notETicket * $toWallet} *
        q!: * {$moneyAddInfNe * $notETicket * $toWallet} *

        q!: * $getPrizInf * $prize * $notETicket * на $website *
        q!: * $notETicket * $getPrizInf * $prize * на $website *
        q!: * $prize * $notETicket * $moneyAddInf * $onBill

        q!: * $notETicket * {$getPrizInf * $prizeAndSumAndWinTicket * $toWalletAll} *
        q!: * {$getPrizInf * $prizeAndSumAndWinTicket * $toWalletAll} * $notETicket *

        q!: * {$winNotETicket * $getPrizInf * $toWalletAll} *
        q!: * {$winNotETicket * $transferInfImp * [$toWalletAll]} *
        q!: * {$winNotETicket * $sendInf * $toWalletAll} *
        q!: * {$winNotETicket * $moneyAddInf * $toWalletAll} *

        q!: * {$winNotETicket * $getPrizInfNe * $toWalletAll} *
        q!: * {$winNotETicket * $transferInfNe * $toWalletAll} *
        q!: * {$winNotETicket * $sendInfNe * $toWalletAll} *
        q!: * {$winNotETicket * $moneyAddInfNe * $toWalletAll} *

        q!: * оформить $prizeAndSumAndWinTicket $online *

        q: * $notETicket * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * $retailPointOfSale * || fromState = /Payments/HowToWithdrawMoneyToPurse

        intent!: /Payments/HowToWithdrawMoneyFromPaperTicketToPurse
        a: На билетах указан номер тиража?

        state: CirculationIsIndicated
            # тираж указан
            q: $comYes [$comYes]
            q: есть
            q: * указан* *
            q: * есть {($ticketRun/$ticketRunNumber)} *
            a: К сожалению, перевод выигрыша в Кошелек с билетов, при покупке которых Вы не указывали номер телефона, а номер тиража указан на самом билете (на лицевой стороне), невозможен.\n\nЕсли Вы приобретали билеты в точках продаж, то Ваш выигрыш Вы можете получить в той же точке продаж или в лотерейной сети «БалтЛото», на Почте России, в киоске. С адресами точек продаж и лимитами выплат ознакомьтесь, пожалуйста, по ссылке http://www.stoloto.ru/map

        state: CirculationIsNotIndicated
            # тираж не указан
            q: $comNo [$comNo]
            q: * {$writtenNe * [$ticketRun/$ticketRunNumber]} *
            q: * $comNo ($ticketRun/$ticketRunNumber) *
            q: * ($ticketRun/$ticketRunNumber) $comNo *
            a: Если Вы приобретали билет в розничных точках продаж с указанием номера телефона, Вы можете зарегистрироваться на сайте с номером телефона, указанным Вами при покупке билета. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты». Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в личном кабинете, то напишите нам, пожалуйста.\n\nПолучить выигрыш Вы можете в Ваш Кошелек Столото. Для этого Вам необходимо зайти на страницу Вашей квитанции, нажав на ее номер в разделе «Мои билеты». Далее Вы увидите большую зеленую кнопку «Перевести выигрыш в Кошелек». Нажмите на нее, пожалуйста. Код выигрыша для получения выигрыша в Кошелек Столото не нужен. Пройдя по ссылке https://www.stoloto.ru/private/tickets/type/winners , Вы сможете увидеть Ваши выигрышные квитанции.


    state: CantWithdrawMoneyToPurse
        # Билет не вывести на кошелек
        q!: * {$withdrawPast * $toWalletAll * [@RL]} * [$comWhere/куда/$when] * [@RL] *

        q!: * [@RL] * {($transferPast/$sendPastPerf) * $prizeAllRL * $toWalletAll} * [@RL] *

        # билет стоит как выплаченный
        q!: * [@RL] * (отметк*/пометк*) $about (получени*/выплате) $prizeAll * [@RL] *
        q!: * [@RL] * $ticket * [@RL] * (как/в категории/отмечен*/числ* [в]) выплачен* * [@RL] *

        # как я получила выигрыш, я ничего не получала
        q!: * [@RL] * ($how/$comWhere) {я $receivePast $prizeAll} * [@RL] *

        # не перевести выигрыш в кошелек
        q!: * {$getPrizInfNe * [$prizeAndSumAndWinTicket] * $toWalletAll} *
        q!: * [@RL] * {$transferInfNe * $prizeAllRL * $toWalletAll} * [@RL] *
        q!: * [@RL] * {$sendInfNe * $prizeAllRL * $toWalletAll} * [@RL] *
        q!: * [@RL] * {$moneyAddInfNe * $prizeAllRL * $toWalletAll} * [@RL] *


        # выигрыш не добавляется в кошелек
        q!: * [@RL] * {$getPrizPastPresNe * [$prizeAndSumAndWinTicketRL] * $toWalletAll} * [@RL] *
        q!: * [@RL] * {$getPrizPastPresNe * $moneyAndRubRL * $toWalletAll} * [@RL] *

        q!: * [@RL] * [$transferInfImp/$getPrizInf/$moneyAndRub] * {$prizeAllRL * ($transferPastPresNeAll/$ne прошел) * $toWalletAll} * [@RL] *

        q!: * {($prizeAllRL * [$moneyAndRub]) * $bonusComePastPresNe * ($toWallet/$inWallet)} * [@RL] * [$howLong/$when] *

        q!: * [@RL] * {($number $Number * [@RL]) * $bonusComePastPresNe * $toWallet} * [@RL] *
        q!: * {$prizeAndSumRL $toWalletAll $bonusComePastPresNe} *
        q!: * {$prizeAllRL * ($toWalletAll/$inWallet) * $addPastPlSg3Ne} * [@RL] *

        q!: * {$bonusComePastPresNe * $prizeAll * $fastLotteries} *

        q!: * {$prizeAndSumAndWinTicketRL * $toWalletAll * всплывает} * [@RL] *
        q!: * {$prizeAndSumAndWinTicketRL * $toWalletAll * ($ne записыв*)} * [@RL] *

        q!: * [@RL] * {$prizeRL $displayPresSg3Ne (в $account)} * [@RL] *
        q!: * [@RL] * {$prizeRL $displayPresPl3Ne (в $account)} * [@RL] *

        q!: * {$prizeAllRL * $inWallet * $findPastPresNe} *
        q!: * $prizeAllRL * $findPastPresNe * $onBillLoc

        q!: * {$payOffPastPresNe * $toWalletAll * [@RL]} *

        # тираж не добавляется в кошелек
        q!: * ($lotteriesWithoutRL/$ticketRun) * $transferPastPresNeAll * $toWallet *
        q!: * ($lotteriesWithoutRL/$ticketRun) * $toWallet * $transferPastPresNeAll *
        q!: * $transferPastPresNeAll * ($lotteriesWithoutRL/$ticketRun) * $toWallet *
        q!: * $transferPastPresNeAll * $toWallet * ($lotteriesWithoutRL/$ticketRun) *
        q!: * $toWallet * ($lotteriesWithoutRL/$ticketRun) * $transferPastPresNeAll *
        q!: * $toWallet * $transferPastPresNeAll * ($lotteriesWithoutRL/$ticketRun) *

        q!: * {$moneyAndRub * $bonusComePastPresNe * $toWalletAll} * (за [$oneWord] $ticketRun) *
        q!: * {($moneyAndRub * за [$oneWord] $ticketRun) *$bonusComePastPresNe * $toWalletAll} *

        q!: * {$toWallet * $bonusComePastPresNe * ($moneyAndRub * $lotteriesWithoutRL)} *
        q!: * {$toWallet * $bonusComePastPresNe * ($lotteriesWithoutRL * $moneyAndRub)} *



        # не начисляется билет в кошелек
        q!: * [$moneyAddPastPres] * {$moneyAddPastPresNe * ($ticketRun/[$oneWord] $ticket) * $toWallet} *

        q!: * [@RL] * {$transferPastPresNeAll * ((по/за/$with) * $ticket) * $toWallet} * [@RL] *

        # Не получается перевести выигрыш в Кошелек
        q!: * [$prizeAndSumAndWinTicketRL] * {$cantPastPresAll * $getPrizInf * $toWalletAll} * [@RL] *
        q!: * [@RL] * $cantPastPresAll * [@RL] * {$getPrizInf * [$prizeAndSumAndWinTicketRL] * $toWalletAll} * [@RL] *
        q!: * [@RL] * {$getPrizInf * [$prizeAndSumAndWinTicketRL] * $toWalletAll} * $cantPastPresAll * [@RL] *

        q!: * $moneyAndRubRL * {$cantPastPresAll * $getPrizInf * $toWalletAll} * [@RL] *
        q!: * [@RL] * $cantPastPresAll * [@RL] * {$getPrizInf * $moneyAndRubRL * $toWalletAll} * [@RL] *
        q!: * [@RL] * {$getPrizInf * $moneyAndRubRL * $toWalletAll} * $cantPastPresAll * [@RL] *

        q!: * [$uniqueKey] * $prizeAllRL * [$moneyAndRub] * [@RL] * {$cantPastPresAll * ($transferInfPrizeToWallet/$transferN/$moneyAddN/$cashing/~получение) * ($toWalletAll/$onBalance)} * [@RL] *
        q!: * [$uniqueKey] * [@RL] * $cantPastPresAll * [@RL] * {($transferInfPrizeToWallet/$transferN/$moneyAddN/$cashing/~получение) * $prizeAllRL * ($toWalletAll/$onBalance)} * [@RL] *
        q!: * [$uniqueKey] * [@RL] * {($transferInfPrizeToWallet/$transferN/$moneyAddN/$cashing/~получение) * $prizeAllRL * ($toWalletAll/$onBalance)} * $cantPastPresAll * [@RL] *

        # не получается перевести лотерею в кошелек
        q!: * [$moneyAndRub] * ($lotteriesWithoutRL/$ticketRun) * {$cantPastPresAll * $transferInfPrizeToWallet * $toWallet} *
        q!: * [$moneyAndRub] * $cantPastPresAll * {$transferInfPrizeToWallet * ($lotteriesWithoutRL/$ticketRun) * $toWallet} *
        q!: * [$moneyAndRub] * {$transferInfPrizeToWallet * ($lotteriesWithoutRL/$ticketRun) * $toWallet} * $cantPastPresAll *

        # что с получением выигрыша в кошелек
        q!: * [@RL] * ($howLong/$when/$waitInf/$comWhat $with) * ($transferN/$moneyAddN/$cashing/~получение) * $prizeAllRL * $toWalletAll * [@RL] *

        # не производится выплата в кошелек
        q!: * [@RL] * {(($producePres3Ne/$takePlacePastNe) * ($transferN/$moneyAddN/$cashing/~получение)) * $prizeAllRL * $toWalletAll} * [@RL] *
        q!: * [@RL] * {($transferN/$moneyAddN/$cashing/~получение) * $prizeAllRL * $toWalletAll} * ($producePres3Ne/$takePlacePastNe) * [@RL] *

        q!: * {($producePres3Ne/$takePlacePastNe) * ~выплата * $fastLotteries} *
        q!: * [@RL] * {($producePres3Ne/$takePlacePastNe) * ~выплата * $toWalletAll} * [@RL] *

        # Пытаюсь получить выигрыш в кошелек, но возникает ошибка
        q!: * [@RL] * {($getPrizInf/$getPrizPastPres) * ($toWallet/$toAccount) * $error} * [@RL] *

        q!: * [@RL] * {($getPrizInf/$getPrizPastPres) * $prizeAllRL * ($toWallet/$toAccount)} * [@RL] * $error * [@RL] *
        q!: * [@RL] * $error * {($getPrizInf/$getPrizPastPres) * $prizeAllRL * ($toWallet/$toAccount)} * [@RL] *

        q!: * [@RL] * {($getPrizInf/$getPrizPastPres) * $moneyAndRubRL * ($toWallet/$toAccount)} * [@RL] * $error * [@RL] *
        q!: * [@RL] * $error * {($getPrizInf/$getPrizPastPres) * $moneyAndRubRL * ($toWallet/$toAccount)} * [@RL] *

        q!: * [@RL] * {($transferInfPrizeToWallet/$transferPrizeToWallet) * $prizeAllRL * ($toWallet/$toAccount)} * [@RL] * $error * [@RL] *
        q!: * [@RL] * $error * {($transferInfPrizeToWallet/$transferPrizeToWallet) * $prizeAllRL * ($toWallet/$toAccount)} * [@RL] *

        q!: * [@RL] * ($getPrizInf/$transferInfPrizeToWallet) $prizeAndSum $toWalletAll * [@RL] * $error * [@RL] *


        q!: * {(($transferN/$moneyAddN/$cashing/~получение) * $prizeAllRL) * ($toWalletAll/$toAccount/$onW1) * $error} *
        q!: * $prizeAllRL * {($transferN/$moneyAddN/$cashing/~получение) * ($toWalletAll/$toAccount/$onW1) * $error} *
        q!: * $error * {($transferN/$moneyAddN/$cashing/~получение) * $prizeAllRL * ($toWalletAll/$toAccount/$onW1)} * [@RL] *

        q!: * [@RL] * {$cashing * $toWalletAll * $error} * [@RL] *

        # медленно переводится в кошелек
        q!: * [@RL] * {($slowly/$howLong) * $getPrizPresPlSg3 * $toWallet} * [@RL] *

        q!: * (долго/$howLong) * {$transferPres3All * $prizeAllRL * ($toWalletAll/$toAccount)} * [@RL] *
        q!: * {$transferPres3All * $prizeAllRL * ($toWalletAll/$toAccount)} * (долго/$howLong) *
        q!: * $prizeAllRL * {(долго/$howLong) * $transferPres3All * ($toWalletAll/$toAccount)} * [@RL] *

        q!: * (долго/$howLong/$delay/$difficulty) * {($transferN/$moneyAddN/$cashing/~получение) * $prizeAllRL * ($toWalletAll/$toAccount/$onW1)} * [@RL] *
        q!: * {($transferN/$moneyAddN/$cashing/~получение) * $prizeAllRL * ($toWalletAll/$toAccount/$onW1)} * (долго/$howLong/$delay) * [@RL] *

        q!: * $prizeAllRL * (долго/$howLong) * ($transferN/$moneyAddN/$cashing/~получение) * ($toWalletAll/$toAccount/$onW1) * [@RL] *

        q!: * [@RL] * {(долго/$howLong/$delay/~опоздание/зависл*) * $cashing * $toWalletAll} * [@RL] *

        q!: * (долго/$howLong/$howLong2) * запрос * $cashing * [@RL] * $toWalletAll *
        q!: * (долго/$howLong/$howLong2) * запрос * ($transferN/$moneyAddN/~получение) * $prizeAllRL * $toWalletAll *


        # не получается вывод в кошелек
        q!: * [@RL] * {$cashing * $toWallet * $cantPastPresAll} * [@RL] *
        q!: * [@RL] * {$cashing * $toWallet * $bonusComePastPresNe} * [@RL] *
        q!: * [@RL] * {$workFut * $cashing * $toWallet} * [@RL] *

        q!: * [@RL] * {$prizeAllRL * $toWalletAll * $difficulty} * [@RL] *
        q!: * [@RL] * {$prizeAllRL * $toWalletAll * $delay} * [@RL] *

        # когда появится выигрыш в кошельке
        q!: * $prizeAllRL * $when * [$displayFut3/$bonusComePastPresFut] * ($toWalletAll/$inWallet) * [@RL] *

        q!: * ($howLong/$when) * $prizeAllRL * ($toWalletAll/$inWallet) * ($displayFut3/$bonusComePastPresFut) * [@RL] *

        q!: * ($howLong/$when) * $prizeAllRL * ($displayFut3/$bonusComePastPresFut) * ($toWalletAll/$inWallet) * [@RL] *

        q!: * [@RL] * $when * {$prizeAllRL * (выведут/$transferFut/$sendFut) * $toWalletAll} * [@RL] *
        q!: * [@RL] * (выведут/$transferFut/$sendFut) $li * $prizeAllRL * $toWalletAll * [@RL] *

        # не весь выигрыш переведен в кошелек
        q!: * $notAllPrizeRL * ($bonusComePastPres/$getPrizPastPres/$transferPastPres/$sendPastPres/$moneyAddPastPres/$transferPartPas/$sendPartPas/$moneyAddPartPas/добавлен/добавлены/$received) * $toWalletAll * [@RL] *

        q!: * $notAllPrizeRL * $toWalletAll * ($bonusComePastPres/$getPrizPastPres/$transferPastPres/$sendPastPres/$moneyAddPastPres/$transferPartPas/$sendPartPas/$moneyAddPartPas/добавлен/добавлены/$received) * [@RL] *

        q!: * [@RL] * ($bonusComePastPres/$getPrizPastPres/$transferPastPres/$sendPastPres/$moneyAddPastPres/$transferPartPas/$sendPartPas/$moneyAddPartPas/добавлен/добавлены/$received) * $toWalletAll * $notAllPrizeRL *

        q!: * [@RL] * ($bonusComePastPres/$getPrizPastPres/$transferPastPres/$sendPastPres/$moneyAddPastPres/$transferPartPas/$sendPartPas/$moneyAddPartPas/добавлен/добавлены/$received) * $notAllPrizeRL * $toWalletAll * [@RL] *

        q!: * [@RL] * $toWalletAll * [@RL] * ($bonusComePastPres/$getPrizPastPres/$transferPastPres/$sendPastPres/$moneyAddPastPres/$transferPartPas/$sendPartPas/$moneyAddPartPas/добавлен/добавлены/$received) * $notAllPrizeRL *

        q!: * [@RL] * $toWalletAll * $notAllPrizeRL * ($bonusComePastPres/$getPrizPastPres/$transferPastPres/$sendPastPres/$moneyAddPastPres/$transferPartPas/$sendPartPas/$moneyAddPartPas/добавлен/добавлены/$received) * [@RL] *

        q!: * {($ne (весь/все) $prizeAndSumAndWinTicket) * $fastLotteries} *

        # выигрыш получен в кошелек не полностью
        q!: * $prizeAllRL * ($ne полностью) * ($bonusComePastPres/$getPrizPastPres/$transferPastPres/$sendPastPres/$moneyAddPastPres/$transferPartPas/$sendPartPas/$moneyAddPartPas/добавлен/добавлены/$received) * $toWalletAll * [@RL] *

        q!: * $prizeAllRL * ($ne полностью) * $toWalletAll * ($bonusComePastPres/$getPrizPastPres/$transferPastPres/$sendPastPres/$moneyAddPastPres/$transferPartPas/$sendPartPas/$moneyAddPartPas/добавлен/добавлены/$received) * [@RL] *

        q!: * $prizeAllRL * ($bonusComePastPres/$getPrizPastPres/$transferPastPres/$sendPastPres/$moneyAddPastPres/$transferPartPas/$sendPartPas/$moneyAddPartPas/добавлен/добавлены/$received) * $toWalletAll * ($ne полностью) * [@RL] *

        q!: * $prizeAllRL * $toWalletAll * ($bonusComePastPres/$getPrizPastPres/$transferPastPres/$sendPastPres/$moneyAddPastPres/$transferPartPas/$sendPartPas/$moneyAddPartPas/добавлен/добавлены/$received) * ($ne полностью) * [@RL] *


        q!: * [@RL] * {$toWalletAll * $transferPartPasAll * меньше} * (выиграно/$winPastPerf) * [@RL] *

        # написано, выигрыш получен
        q!: * [@RL] * $isWritten * я [уже] (получил*/забрал*/взял*) $prizeAndSum * [@RL] *

        q!: * [@RL] * $isWritten * (выплачено/выплатил*) * [@RL] *

        q!: * [@RL] * ($isWritten/$how) * уже $received * [@RL] *
        q!: * [@RL] * $isWritten [что] $received $but * [@RL] *
        q!: * [@RL] * {$isWritten [что] ($prizeAndSum/все/$ticket) $received} * [@RL] *
        q!: * [@RL] * $isWritten что ($prizeAndSum/$comMoney) $toWallet * [@RL] *
        q!: * [@RL] * ($isWritten/статус) * {$receivePast $prizeAndSum} * [@RL] *
        q!: * [@RL] * ($isWritten/~статус) * {($prizeAndSum/$moneyAndRub) $received} * [@RL] *

        q!: * [@RL] * [$bonusComePastPresNe/$prizeAllRL] * $isWritten * [$prizeAllRL] * (уже/его/их) $receivePast * [@RL] *
        q!: * [@RL] * [$bonusComePastPresNe/$prizeAllRL] * $isWritten * (он/что) $received * [@RL] *

        q!: * [@RL] * $isWritten * {$prizeAllRL уже $received} * [@RL] *

        q!: * $prizeAllRL * $isWritten * (им воспользовалис*/$received/$receivePast) * [@RL] *

        q!: * [@RL] * $isWritten * $moneyAddPartPas * $toWalletAll * [@RL] *

        q!: * [@RL] * {$isWritten * забрал* * $prizeAndSum} * [@RL] *

        q!: * [@RL] * (стоит/стоят/висит/висят/отмечен*/отражае*/отображае*) [что] $prizeAndSum $received * [@RL] *
        q!: * [$prizeAllRL] * (стоит/стоят/висит/висят/отмечен*/отражае*/отображае*) как $received * [@RL] *

        q!: * $prizeAllRL * (~статус/$isWritten/стоит/стоят/висит/висят/отмечен*/отражае*/отображае*) * (получен*/выплачен*/$received) * [@RL] *

        q!: * [@RL] * вы выиграл* * $prize получен* * [@RL] *

        # выигрыш кем-то получен за меня
        q!: * [@RL] * кто {(получил/забрал) $comMy $prizeAndSum} * [@RL] *
        q!: * [@RL] * кто (их (получил/забрал)/(получил/забрал) их) *

        q!: * [@RL] * {(кем-то/кем то/кемто) $received} * [@RL] *

        q!: * [@RL] * {$prizeAndSum $received} * я $ne *
        q!: * [@RL] * я $ne * {$prizeAndSum $received} * [@RL] *
        q!: * [@RL] * (куда/кем) {$prizeAndSum $received} * [@RL] *

        q!: * [@RL] * $received а кем * [@RL] *
        q!: * [@RL] * {$received * (кем и куда)} * [@RL] *
        q!: * [@RL] * {$received * (кем и когда)} * [@RL] *

        q!: * [@RL] * читаю * $received * [@RL] *
        q!: * [@RL] * за меня получен * [@RL] *
        q!: * [@RL] * кто забрал [$comMy] $prize * [@RL] *

        # что значит выигрыш получен?
        q!: * [@RL] * ~состояние $received * [@RL] *
        q!: * [@RL] * $comWhat (значит/значат/означает/означают) {($receivePast/$received) [$prizeAndSum/$moneyAndRub]} * [@RL] *
        q!: * [@RL] * ((выведен/выведены) $toWallet/$received) * $comWhat это (значит/значат/означает/означают) * [@RL] *

        # получен, но выигрыш не получен

        q!: * [@RL] * $received $but ($toWalletAll/$inWallet) * [@RL] *

        q!: * [@RL] * $received * $receivePastNe * [@RL] *

        q!: * [@RL] * [$bonusComePastPresNe/$prizeAllRL] * (хотя/а) $isWritten * $received * [@RL] *


        # выигрыш получен, а в кошельке нету
        q!: * [@RL] * $prizeIsReceived * [@RL] * ($zeroInWallet/$walletHasNotBeenUpdated/$moneyDidntCome/$prizeDidntCome/$nothingHasCome) * [@RL] *

        q!: * [@RL] * ($zeroInWallet/$walletHasNotBeenUpdated/$moneyDidntCome/$prizeDidntCome/$nothingHasCome) * [@RL] * $prizeIsReceived * [@RL] *

        q!: * [@RL] * $prizeIsReceived * {(его/их) * ($smsComePastPresNe/$receivePastNe/$comNo)} * [@RL] *

        q!: * [@RL] * $prizeIsReceived * (кем/куда) * $received * [@RL] *
        q!: * [@RL] * {$ticket * $received} * (кем/куда) * $received * [@RL] *

        q!: * [@RL] * $prizeIsReceived * а (куда/где он) * [@RL] *

        q!: * [@RL] * $prizeIsReceived * (это $ne так/как было так и остал*/(в/на) какой $wallet) * [@RL] *

        q!: * [@RL] * выплачен* * $inWallet * $comNo * [@RL] *

        # в какой кошелек вывелся выигрыш

        q!: * [@RL/$prizeAllRL] * (на/в) (какой/какой-то/некий) [то/именно] $wallet * [@RL/$prizeAllRL] *
        q!: * $prizeAllRL * (уходят/ушли/ушел) * в (непонятн*/$ne понятн*) $wallet *

        q!: * [$moneyAndRub] * [@RL] * ($moneyTakeOffPastPres/$transferPastPres/$sendPastPres) * [$moneyAndRub] * в какой $wallet *
        q!: * в какой $wallet * [$moneyAndRub] * ($moneyTakeOffPastPres/$transferPastPres/$sendPastPres) * [$moneyAndRub] * [@RL] *

        # вывел в кошелек, в кошельке ноль
        q!: * {($withdrawPast/выведен*/$transferPartPas) * [@RL] * $toWallet} * $zeroInWallet * [@RL] *

        # перевел выигрыш в кошелек, не дошел
        q!: * [@RL] * {($getPrizPastPres/$getPrizInf) * $toWalletAll * $bonusComePastPresNe} * [@RL] *

        q!: * [@RL] * {($getPrizPastPres/$getPrizInf) * [$prizeAllRL] * $toWalletAll} * ($bonusComePastPresNe/$changePastNe/перевода $comNo/$comNo перевода/$findPastPresNe/$but там/один $smsComePast/$comWhere/$zeroAdj/$zero/$nothing) * [@RL] *

        q!: * {($getPrizPastPres/$getPrizInf) * $moneyAndRubRL * $toWalletAll} * ($bonusComePastPresNe/$changePastNe/перевода $comNo/$comNo перевода/$findPastPresNe/$but там/один $smsComePast/$comWhere/$zeroAdj/$zero/$nothing) * [@RL] *

        q!: * [@RL] * {($transferPastPresAll/$transferInfPrizeToWallet/$transferPartPasAll) * $prizeAllRL * $toWalletAll} * ($bonusComePastPresNe/$changePastNe/перевода $comNo/$comNo перевода/$findPastPresNe/$but там/один $smsComePast/$comWhere/$zeroAdj/$zero/$nothing/(он/они) (пропал*/исчез/исчезл*)) * [@RL] *

        # перевел выигрыш, в кошельке ноль
        q!: * $prizeAllRL * ($transferPastPres/$sendPastPres/$moneyAddPastPres) * {$inWallet * ($updatePresPlSg3Ne/$updatePastNe)} *
        q!: * ($transferPastPres/$sendPastPres/$moneyAddPastPres) * $prizeAllRL * {$inWallet * ($updatePresPlSg3Ne/$updatePastNe)} *

        q!: * {$getPrizPastPres * $prizeAndSumAndWinTicketRL} но {$inWallet * $comNo} *

        # нет начисления выигрыша в кошелек

        q!: * $prizeAllRL * $smsComePastPerfNe [$comMy] $walletNom

        q!: * {(после перевода $prizeAllRL) * $depositPastPresNe} *

        q!: * $comNo * (~начисление/~зачисление/~перечисление) $prizeAndSumRL * $toWalletAll * [@RL] *
        q!: * [@RL] * {($comNo * ~поступление/~поступление * $comNo) * $prizeAllRL * $toWalletAll} * [@RL] *

        q!: * $comWhere * $prizeAllRL * {$findPastPresNe * $inWallet} * [@RL] *
        q!: * {$waitInf * (появлен* $prizeAllRL * $inWallet)} * [@RL] *

        q!: * {$receivedNe $prizeAndSumRL} * (хотя/$ne смотря/несмотря/нисмотря/а/$but) *

        q!: * ($winPastPerf/~выплата) * [@RL] * $wallet * ($zeroAdj/$zero) *

        q!: * {(потерялис*/потерялс*/пропал*/$receivedNe/$ne оплачивают/неоплачивают/ниоплачивают/$ne зачли/$findPastPresNe) * $prizeAll * $fastLotteries} *

        # выигрыш в кошелек, но что-то пошло...
        q!: * {$prizeAllRL * $toWalletAll} * (чтото/что то/что-то) * $ne так *
        q!: * {$prizeAllRL * $toWalletAll} * (а/и) куда *


        q!: * {$prizeAllRL * $toWallet} * $comNo *
        q!: * $prizeAllRL * $inWallet * ($zero/должно быть) * [@RL] *

        q!: * {$prizeAndSumAndWinPastRL * $toWalletAll} * $butAll [их/его/иво] ($toWalletAll/там/в нем/должн*) *

        q!: * $prizeAndSumAndWinPastRL * $toWalletAll * {($comMoney/$nothing/там/все равно) [их/его/иво] $comNo} *
        q!: * $toWalletAll * $prizeAndSumAndWinPastRL * {($comMoney/$nothing/там/все равно) [их/его/иво] $comNo} *

        q!: * {$prizeAndSumAndWinTicketRL * $toWalletAll} * (все равно/до сих пор/по прежнему/по-прежнему/пропали) *

        # выигрыш в кошелек только за один билет
        q!: * {(выведен*/$transferPartPas) * $toWallet * ($only (по/за/$with) $oneWord $ticket)} *
        q!: * [@RL] * {$transferPartPas * $toWallet * ($only $oneWord $prizeAllRL)} *
        q!: * $prizeAllRL * $toWallet * $only *
        q!: * {$prizeAllRL * $toWalletAll * ($only (по/за/$with))} *

        # выиграл, а в кошельке только
        q!: * [@RL] * $prizeAndSumAndWinPastRL * [$moneyAndRub] * [@RL] * $inWallet $only ($numberRub/$Number) * [@RL] *
        q!: * $prizeAndSumAndWinPast * [$moneyAndRub] * $why $inWallet ($numberRub/$Number) * [@RL] *
        q!: * [@RL] * $prizeAndSumAndWinPastRL * [$moneyAndRub] * [@RL] * {$inWallet [их/его/иво] $comNo} * [@RL] *
        q!: * [@RL] * $prizeAndSumAndWinPastRL * [$moneyAndRub] * [@RL] * $toWalletAll * ($bonusComePastPres/$transferPast/$transferPartPas/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) $only * [@RL] *
        q!: * [@RL] * $prizeAndSumAndWinPastRL * [$moneyAndRub] * [@RL] * ($bonusComePastPres/$transferPast/$transferPartPas/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * $toWalletAll * $only * [@RL] *

        q!: * [@RL] * $prizeAndSumAndWinPastRL * [$moneyAndRub] * [@RL] * $butAll * $toWalletAll * ($bonusComePastPres/$transferPast/$transferPartPas/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) @duckling.number * [@RL] *

        q!: * [@RL] * $prizeAndSumAndWinPastRL * [$moneyAndRub] * [@RL] * ($inWallet/$toWalletAll) ($nothing/его/иво/их/$prizeAndSum/$comMoney/они/так и) $bonusComePastPresNe *
        q!: * [@RL] * $prizeAndSumAndWinPastRL * [$moneyAndRub] * [@RL] * ($inWallet/$toWalletAll) $bonusComePastPresNe ($nothing/его/иво/их/$prizeAndSum/$comMoney/они) *
        q!: * [@RL] * $prizeAndSumAndWinPastRL * [$moneyAndRub] * [@RL] * ($nothing/его/иво/их/$prizeAndSum/$comMoney/они/так и) {$bonusComePastPresNe ($inWallet/$toWalletAll)} *
        q!: * [@RL] * $prizeAndSumAndWinPastRL * [$moneyAndRub] * [@RL] * $bonusComePastPresNe ($inWallet/$toWalletAll) ($nothing/его/иво/их/$prizeAndSum/$comMoney/они) *
        q!: * [@RL] * $prizeAndSumAndWinPastRL * [$moneyAndRub] * [@RL] * $bonusComePastPresNe ($nothing/его/иво/их/$prizeAndSum/$comMoney/они) ($inWallet/$toWalletAll) *

        q!: * [@RL] * $winPastPerf $numberRub * [@RL] * $butAll $bonusComePastPres $prize $numberRub * [@RL] *
        q!: * [@RL] * $prizeAndSumAndWinPast ($numberRub/$Number) $butAll выплатил* ($numberRub/$Number) * [@RL] *

        q!: * {[$received] * $prizeAllRL} * $butAll $inWallet * [$only] *
        q!: * $prizeAllRL * ($balance/$wallet) показывает *
        q!: * $prizeAllRL * [$moneyAndRub] * [@RL] * в $account {$comNo $prize} * [@RL] *

        q!: * [@RL] * (был* $prize/$winPastPerf) * [@RL] * $walletHasNotBeenUpdated * [@RL] *

        q!: * [@RL] * ($prize/$winPastPerf) * [@RL] * ($balance/сумм*) [в] $wallet ($changePastNe/остал* прежн*) * [@RL] *
        q!: * ($balance/сумм*) [в] $wallet ($changePastNe/остал* прежн*) * ($prize/$winPastPerf) * [@RL] *

        q!: * [@RL] * $winPastPerf * [@RL] * (нигде/ни где) их $findFut1Ne *

        q!: * [@RL] * $winPastPerf $numberRub * [@RL] * они $bonusComePastPresNe $onBalanceLoc

        q!: * $Number $winTicket * [@RL] * $bonusComePastPres $only $numberRub *


        # неактивна кнопка в кошелек
        q!: * [@RL] * {$toWallet * $button * $activeNe} * [@RL] *
        q!: * [@RL] * {$toWallet * $button * $findPastPresNe} * [@RL] *
        q!: * {($prizeAndSumRL * $toAccount/$toAccount * $prizeAndSumRL) * $button * $activeNe} *
        q!: * [@RL] * {$button * $toWallet * ~серый} * [@RL] *

        # отдельные запросы про быстрые лотереи
        q!: * {$prizeAndSumAndWinPast * $fastLotteries * $bonusComePastPres} * $only *
        q!: * $fastLotteries * ($moneyAddPartPas/$transferPartPas) * $only *
        q!: * ($bonusComePastPres/$moneyAddPartPas/$transferPartPas) $only * {$prizeAndSumAndWinPast * $fastLotteries} *

        q!: * {$prizeAll * $fastLotteries} * $numberRub * $bonusComePastPres * $numberRub *

        q!: * $fastLotteries * {куда * (уходят/ушли/ушел) * $prizeAll} *
        q!: * {куда * (уходят/ушли/ушел) * $prizeAll} * $fastLotteries *

        # после выигрыша кошелек пустой
        q!: * [@RL] * после $prize $wallet пустой * [@RL] *
        q!: * [@RL] * $prizeAndSum $ne $inWallet * [@RL] *


        q!: * [@RL] * {$inWallet * ($prizeAllRL ($comNo/отсутств*)/($comNo/отсутств*) [$oneWord] $prizeAllRL)} * [@RL] *
        q!: * [@RL] * {$prizeAllRL * ($inWallet ($comNo/отсутств*)/($comNo/отсутств*) [$oneWord] $inWallet)} * [@RL] *

        q!: * [@RL] * {($ne загружен*/незагружен*/низагружен*) * $prizeAllRL * $toWalletAll} * [@RL] *

        # неверное зачисление выигрыша в кошелек
        q!: * $prizeAllRL * $toWalletAll * уменьшил* *
        q!: * $prizeAllRL * $inWallet * ($ne соответ*/несоответ*/нисоответ*) *
        q!: * {$prizeRL * $moneyAddPartPas * неверно} *
        q!: * [@RL] * $wrong (~начисление/~зачисление/~перечисление) $prizeAllRL * $toWalletAll * [@RL] *

        q!: * [@RL] * $with $oneWord (лотереи/$ticketGen) * [@RL] * {$comNo $inWallet} * [@RL] *

        # нажал получить в кошелек, но ...

        q!: * [@RL] * нажал* (получить/забрать) * но $inWallet *
        q!: * [@RL] * нажал* (получить/забрать) $prizeRL * куда *
        q!: * [@RL] * нажал* * ($prizeAllRL/$transferInfImp) * $toWalletAll * [@RL] *
        q!: * [@RL] * нажал* * {$prizeAllRL * $transferInfImp} * $toWalletAll * [@RL] *

        q: в || fromState = /Payments/ThereIsNoGreenButton
        q: [$comMy] $walletNom [$stoloto] || fromState = /Payments/ThereIsNoGreenButton
        q: * $toWalletAll * || fromState = /Payments/ThereIsNoGreenButton

        q: * {$transferPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/WhereIsThePrize
        q: * {$sendPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/WhereIsThePrize
        q: * {$moneyAddPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/WhereIsThePrize

        q: в || fromState = /Payments/ICantToTransferPrize
        q: [$comMy] $walletNom [$stoloto] || fromState = /Payments/ICantToTransferPrize
        q: * $toWalletAll * || fromState = /Payments/ICantToTransferPrize
        q: * {$transferPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/ICantToTransferPrize
        q: * {$sendPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/ICantToTransferPrize
        q: * {$moneyAddPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/ICantToTransferPrize
        q: * {[$transferInfImp] * $prizeAll * $toWallet} * || fromState = /Payments/ICantToTransferPrize
        q: * {$sendInf * $prizeAll * $toWallet} * || fromState = /Payments/ICantToTransferPrize
        q: * {$moneyAddInf * $prizeAll * $toWallet} * || fromState = /Payments/ICantToTransferPrize
        q: * $bonusComePastPresNe $inWallet * || fromState = /Payments/ICantToTransferPrize

        q: * {[$here] $comNo $green $button} * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * $comWhere * $button * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * $button $toWalletAll $activeNe * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * {($ne горит/негорит) $green} * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * {[$here] $findPastPresNe $green $button} * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * {[$prizeAll] * $transferPastPresNe} * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * {$moneyAndRub * $transferPastPresNe} * || fromState = /Payments/HowToWithdrawMoneyToPurse

        q: второе || fromState = /Payments/ICantToTransferTheMoney
        q: * {[$transferInfImp] * $prizeAll * $toWallet} * || fromState = /Payments/ICantToTransferTheMoney
        q: * {$sendInf * $prizeAll * $toWallet} * || fromState = /Payments/ICantToTransferTheMoney
        q: * {$moneyAddInf * $prizeAll * $toWallet} * || fromState = /Payments/ICantToTransferTheMoney
        q: [$helloAll] [$transferInfImp] $toWallet || fromState = /Payments/ICantToTransferTheMoney

        q: второе || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$getPrizInf * $prizeAll * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {[$transferInfImp] * $prizeAll * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$sendInf * $prizeAll * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$moneyAddInf * $prizeAll * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$moneyAddPastPresNe * $prizeAll * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$moneyAddPartPasNe * $prizeAll * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$smsComePastPerfNe * $prizeAll * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$smsComePresNe * $prizeAll * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$transferPastPresNe * $prizeAll * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: [$helloAll] [$transferInfImp] $toWallet || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: [$helloAll] $transferInfImp || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * $lotteriesWithoutRL * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * $with $ticket * || fromState = /Payments/ICantToTransferTheMoneyToPurse

        intent!: /Payments/CantWithdrawMoneyToPurse

        if: $parseTree._RL
            if: $global.withdrawalRLToPurseIsAvailable
                a: Если у Вас возникли проблемы с переводом выигрыша в Кошелек, уточните, пожалуйста, уникальный ключ квитанции. Уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр.
            else:
                a: Мы уже работаем над выяснением причины этой проблемы. Как только будет получена актуальная информация, специалисты займутся устранением проблемы. Вы можете посмотреть свой баланс в ближайшее время.
                #a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Многократно возросла нагрузка на все информационные системы, поэтому сегодня начисление выигрышей может проходить с задержкой. Наши специалисты уже работают над этим. Выигрыш будет зачислен на Ваш баланс в ближайшее время.


        else:
            if: $global.withdrawalToPurseIsAvailable
                a: Если у Вас возникли проблемы с переводом выигрыша в Кошелек, уточните, пожалуйста, уникальный ключ квитанции. Уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр.
            else:
                a: Мы уже работаем над выяснением причины этой проблемы. Как только будет получена актуальная информация, специалисты займутся устранением проблемы. Вы можете посмотреть свой баланс в ближайшее время.


        state: GetNumber || fromState = /Payments/CantWithdrawMoneyToPurse
            q: * {[$uniqueKey] * $receiptKey} *
            script: Webim.switch();


    state: HowToTransferMoneyToNewPurse
        # Как перевести деньги в новый кошелек
        q!: * {($transferInfImp/~перевод/$sendInf/вывести/$forTo * ($transferPastPres/$sendPast)) * ($prizeAndSum/$moneyAndRub/$balance/~счет) * $toNewWalletAll} *

        q!: * (из/$with) [$comMy] (старого/текущего) * $toNewWalletAll *

        q!: * {($transferInfImp/~перевод/$sendInf/$forTo * ($transferPastPres/$sendPast)) * [$prizeAndSum] * ((из/$with) [$comMy] (старого/текущего) * (новый/вновь созданный))} *

        q!: * {($transferInfImp/~перевод/$sendInf/$forTo * ($transferPastPres/$sendPast)) * $moneyAndRub * ((из/$with) [$comMy] (старого/текущего) * (новый/вновь созданный))} *

        q!: * {($transferInfImp/~перевод/$sendInf/$forTo * ($transferPastPres/$sendPast)) * [$prizeAndSum] * ((из/$with) (одного/этого) * другой)} *

        q!: * {($transferInfImp/~перевод/$sendInf/$forTo * ($transferPastPres/$sendPast)) * $moneyAndRub * ((из/$with) (одного/этого) * другой)} *

        q!: * {($transferInfImp/~перевод/$forTo * ($transferPastPres/$sendPast)) * ($prizeAndSum/$moneyAndRub/$balance/~счет) * ((из/$with) [$comMy] (старой/старого) ($registration/профиля))} *

        q!: * {объединить * ($comTwo [$comMy] $wallet)} *
        q!: * {($transferInfImp/~перевод/$forTo * ($transferPastPres/$sendPast)) * ($wallet/$balance/~счет)} * (в/во) (новый/вновь созданный) *
        q!: * (сделал*/создал*) $new $accountAcc * ($transferInfImp/~перевод) *
        intent!: /Payments/HowToTransferMoneyToNewPurse
        a: Для перевода денежных средств из одного личного кабинета в другой необходимо, чтобы оба кабинета были идентифицированы.\n\nПройти идентификацию Вы можете, находясь на странице с информацией, по ссылке: https://www.stoloto.ru/wallet_identification . Вам просто необходимо нажать на желтую кнопку «Пройти идентификацию» и далее следовать инструкциям.\n\nЕсли у Вас пройдена идентификация, то направьте, пожалуйста, на почту info@stoloto.ru следующие документы:\n- скан Вашего паспорта (страница с фото);\n- договор с оператором сотовой связи на Ваш старый номер телефона (можно запросить у оператора);\n- договор с оператором сотовой связи на Ваш новый номер телефона (можно запросить у оператора);\n- заявление в свободной форме о переводе денежных средств из старого кабинета в новый (написано от руки и отсканировано или сфотографировано).\n\nПример заявления:\n\nЯ, (ФИО в именительном падеже), (дата рождения), проживающая по адресу (адрес с индексом), (номер телефона), являюсь зарегистрированным пользователем на Вашем сайте www.stoloto.ru (указываете логин, почту и номер телефона от личного кабинета нашего сайта). На 01.11.2014 (дату заявления ставите) на счете Кошелька Столото № (номер Кошелька вышеуказанного кабинета) данного личного кабинета находятся (указываете баланс Кошелька) рублей. К сожалению, данными средствами нет возможности воспользоваться, номер телефона (указываете номер телефона от личного кабинета) более не работоспособен. Прошу помочь в разрешении данной ситуации. Прошу осуществить перевод средств из моего старого Кошелька Столото № (номер Кошелька вышеуказанного кабинета) в мой новый Кошелек Столото № (номер нового Кошелька нового кабинета) личного кабинета (указываете логин, почту и номер телефона от нового личного кабинета нашего сайта), где номер телефона работоспособен и я могу ими воспользоваться.\n(ниже дату, подпись и расшифровку подписи).\n\nВ случае, если у Вас нет возможности предоставить договор с оператором связи, то Вам необходимо пройти полную идентификацию с помощью скайпа в двух личных кабинетах. Пройти идентификацию Вы можете, находясь на странице с информацией, по ссылке: https://www.stoloto.ru/wallet_identification . Вам просто необходимо нажать на желтую кнопку «Пройти идентификацию» и далее следовать инструкциям.\n\nНаправьте, пожалуйста, комплект документов на электронную почту info@stoloto.ru. В теме письма укажите «Перевод средств».


    state: HowToWithdrawMoney
        # Как вывести выигрыш из Кошелька?
        q!: * {$cashoutInf * $wallet} *
        q!: * {$cashoutInf * $prizeWithMoney} *
        q!: * {$cashoutInf * $fromWallet} *

        q!: [$helloAll] {[$how] $prizeAndSum $onExternalResource}
        q!: [$helloAll] [$beginningWords] {$how $fromWallet $onExternalResource}
        q!: [$helloAll] [$beginningWords] {($fromWallet/$fromAccount) $onExternalResource}
        q!: * $how * {$prizeAll * ($fromWallet/$onExternalResource/$fromAccount)} *

        q!: * $how * {(снимает*/снимают*) * ($fromWallet/$onExternalResource)} *

        q!: [$helloAll] [$beginningWords] $possiblePredic [~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата] $onExternalResource
        q!: * порядок (~вывод/~выведение/~снятие/~обналичивание) * ($fromWallet/$onExternalResource) *
        q!: * {$possiblePredic * $onExternalResource} *
        q!: * {$appendInf * $onExternalResource} *
        q!: * {$prizeAll * $returnFutPl23 * $onExternalResource} *

        q!: * $want * ($fromWallet/$onExternalResource) *
        q!: * ($fromWallet/$onExternalResource) * $how
        q!: * $how ($fromWallet/$onExternalResource)
        q!: * $or ($fromWallet/$onExternalResource)

        q!: * {$prizeWithMoney $how $getPrizPresPlSg3} *
        q!: * $how * $getPrizPresPlSg3 * $prizeWithMoney *

        q!: * [$how] * {$getPrizInf * [$prizeWithMoney] * $fromWallet} *
        q!: * [$how] * {$getPrizInf * [$prizeWithMoney] * $onExternalResource} *
        q!: * {$withdrawInf * [$prizeWithMoney] * $fromAccount} *

        q!: * {$transferInfImp * [$prizeWithMoney] * $fromWallet} *
        q!: * {$transferInfImp * [$prizeWithMoney] * $onExternalResource} *
        q!: [$helloAll] [$how] {$transferInfImp [$prizeWithMoney] (на тел)}
        q!: * {$transferInfImp * $prizeAll * $fromAccount} *

        q!: * {$sendInf * [$prizeWithMoney] * $fromWallet} *
        q!: * {$sendInf * [$prizeWithMoney] * $onExternalResource} *
        q!: [$helloAll] [$how] {$sendInf [$prizeWithMoney] (на тел)}
        q!: * {$sendInf * $prizeAll * $fromAccount} *

        q!: * {$moneyAddInf * [$prizeWithMoney] * $onExternalResource} *
        q!: [$helloAll] [$how] {$moneyAddInf [$prizeWithMoney] (на тел)}
        q!: * {$depositInf * [$prizeWithMoney] * $onExternalResource} *
        q!: [$helloAll] [$how] {$depositInf [$prizeWithMoney] (на тел)}
        q!: * {оформить * $prizeAll * $onExternalResource} *

        q!: * {$getPrizPresPlSg3 * $fromWallet} *
        q!: * {$getPrizPresPlSg3 * $onExternalResource} *

        q!: * $prizeAndSum * ($payment ($telephone/моб* связи)) *
        q!: * {$fromWallet * ($payInf [за] моб* связь)} *
        # Хочу чтобы выигрыш переводился на телефон
        q!: * $forTo * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource} *
        q!: * $forTo * {$transferPastPres * [$prizeWithMoney] * $onExternalResource} *
        q!: * $forTo * {$sendPastPres * [$prizeWithMoney] * $onExternalResource} *
        q!: * $forTo * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource} *
        q!: * $forTo * {$smsComePast * [$prizeWithMoney] * $onExternalResource} *
        q!: * $forTo * $prizeWithMoney * $onExternalResource *

        q!: [$helloAll] (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) {($onExternalResource/$fromWallet) ([$comMy] $prizeWithMoney)}
        q!: [$helloAll] (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) {$onExternalResource $fromWallet ([$comMy] $prizeWithMoney)}

        q!: * {$how * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource} *
        q!: * {$possiblePredic * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource} *


        q!: * {$how * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet} *
        q!: * $comWhat $comNeed * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource *
        q!: * $comWhat $comNeed * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet *
        q!: * (помоч*/помог*) $with (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~выплата) * $onExternalResource *
        q!: * (помоч*/помог*) $with (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~выплата) * $fromWallet *
        q!: * $possiblePredic (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~выплата) * $onExternalResource *
        q!: * $possiblePredic (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~выплата) * $fromWallet *
        # Выигрыш в Кошельке, как оттуда вывести
        q!: * ($prizeAndSum $inWallet/$toWalletAll) * {($cashoutInf/$getPrizInf/$transferInfImp) * $fromThere} *
        q!: * {[$toWalletAll] * $fromExternalResource} * {обратно * $getPrizInf} *
        q!: * {$inWallet $prizeAndSum} * $how * $getPrizInf *
        q!: * {$inWallet $numberRub} * $how * $getPrizInf *

        q!: * {($getPrizInf/$transferInfImp) [$comMy] $prizeAndSum} (который/которые) ($transferPastPres/$moneyAddPastPres/$sendPastPres) $toWalletAll *
        q!: * $getPrizInf $prizeAndSum (~переведенный/~выведенный/~отправленный/~перечисленный) $toWalletAll *
        q!: * ($getPrizPastPres/$sendPastPerf/$moneyAddPastPres/$transferPastPres) * $toWallet * {дальше $how получить} *

        q!: * случайно * $toWalletAll *

        q!: * {$depositPast * ($mistakenly/нечайно/нечаянно/случайно)} *
        q!: * ($mistakenly/нечайно/нечаянно/случайно) внесен* $moneyAndRub *
        q!: * {($mistakenly/нечайно/нечаянно/случайно) $depositPastPres} ($wallet/$toWalletAll/$w1/$onW1) * $how отозвать *
        q!: * {(отменить/отозвать) * пополнение} *
        q!: * $fromWallet * обратно на $ticket *
        q!: * (вернуть/отозвать) * $fromWallet *

        q!: * {$withdrawInf * ($ne $prize)} *

        q: $fromWallet || fromState = /Payments/HowToGetPrize
        q: $onExternalResource [$ne $toWalletAll] || fromState = /Payments/HowToGetPrize

        q: из || fromState = /Payments/HowToTransferPrize
        q: * $fromWallet * || fromState = /Payments/HowToTransferPrize
        q: * $onExternalResource [$ne $toWalletAll] * || fromState = /Payments/HowToTransferPrize
        q: $externalResource || fromState = /Payments/HowToTransferPrize
        q: [на] (сторонний/сторонние) || fromState = /Payments/HowToTransferPrize
        q: на ресурсы || fromState = /Payments/HowToTransferPrize
        q: * (со/из) $stoloto * || fromState = /Payments/HowToTransferPrize
        q: * с сайта * || fromState = /Payments/HowToTransferPrize

        q: из || fromState = /Payments/HowToTransferTheMoney
        q: * $fromWallet * || fromState = /Payments/HowToTransferTheMoney
        q: * $onExternalResource [$ne $toWalletAll] * || fromState = /Payments/HowToTransferTheMoney
        q: $externalResource || fromState = /Payments/HowToTransferTheMoney
        q: [на] (сторонний/сторонние) || fromState = /Payments/HowToTransferTheMoney
        q: на ресурсы || fromState = /Payments/HowToTransferTheMoney
        q: * (со/из) $stoloto * || fromState = /Payments/HowToTransferTheMoney
        q: * с сайта * || fromState = /Payments/HowToTransferTheMoney

        intent!: /Payments/HowToWithdrawMoney
        a: Перевести из Кошелька Столото возможно только выигранные деньги. Для того чтобы это сделать, в личном кабинете в разделе Кошелёк нажмите, пожалуйста, зеленую кнопку «Перевести». Далее Вам нужно получить платежный пароль, нажав на кнопку запроса. Пароль поступит на тот номер телефона, который был указан в Вашем личном кабинете. Введите, пожалуйста, код, полученный в sms, в соответствующее поле. Далее нажмите кнопку «Подтвердить». У Вас откроются все варианты для перевода средств из Кошелька, и Вы сможете выбрать нужный Вам.


    state: WithdrawDoesntWork
        # Не могу обналичить кошелек (кроме Русского лото)
        q!: * {$cantPastPresAll * $cashoutInf * $wallet} *
        q!: * {$cantPastPresAll * $cashoutInf * $prizeWithMoney} *

        q!: * {$cantPastPresAll * $cashoutInf * $fromWallet} *
        q!: * {$cantPastPresAll * $cashoutInf * $fromAccount} *
        q!: * {$cantPastPresAll * $withdrawInf * $fromAccount} *
        q!: * ($ne вывести/невывести/нивывести) * $fromAccount *
        q!: * $fromAccount * ($ne вывести/невывести/нивывести) *

        q!: * {$cantPastPresAll * $getPrizInf * [$prizeWithMoney] * $fromWallet} *
        q!: * {$cantPastPresAll * $onExternalResource} *
        q!: * $onExternalResource * работает *
        q!: * {$onExternalResource * ($ne было/небыло) * ~поступление} *
        q!: * {$cantPastPresAll * $getPrizInf * [$prizeWithMoney] * $onExternalResource} *

        q!: * {$cantPastPresAll * $appendInf * $onExternalResource} *

        q!: * {$cantPastPresAll * $transferInfImp * [$prizeWithMoney] * $fromWallet} *
        q!: * {$cantPastPresAll * $transferInfImp * [$prizeWithMoney] * $onExternalResource} *
        q!: * {$cantPastPresAll * $transferInfImp * $prizeAll * $fromAccount} *

        q!: * {$cantPastPresAll * $sendInf * [$prizeWithMoney] * $fromWallet} *
        q!: * {$cantPastPresAll * $sendInf * [$prizeWithMoney] * $onExternalResource} *
        q!: * {$cantPastPresAll * $sendInf * $prizeAll * $fromAccount} *

        q!: * {$cantPastPresAll * $moneyAddInf * [$prizeWithMoney] * $onExternalResource} *
        q!: * {$cantPastPresAll * $depositInf * [$prizeWithMoney] * $onExternalResource} *
        q!: * {$cantPastPresAll * оформить * $prizeAll * $onExternalResource} *

        q!: * $cantPastPresAll * $prizeAndSum * ($payment $telephone) *

        q!: * {$cantPastPresAll * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet} *
        q!: * {$cantPastPresAll * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource} *

        q!: * {$workFut * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * ($fromWallet/$onExternalResource)} *

        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource *
        q!: * $comNo * (~начисление/~зачисление/~перечисление) $prizeAndSum * $onExternalResource *

        q!: * {$getPrizInfNe * [$prizeAndSumAndWinTicket/$prizeWithMoney] * ($fromWallet/$onExternalResource)} *

        # Не обналичивается кошелек
        q!: * {$cashoutPastPresNe * $wallet} *
        q!: * {$cashoutPastPresNe * $prizeWithMoney} *
        q!: * {$cashoutPastPresNe * $fromWallet} *

        q!: * {$getPrizPastPresNe * [$prizeWithMoney] * $fromWallet} *
        q!: * {$getPrizPastPresNe * [$prizeWithMoney] * $onExternalResource} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $fromWallet} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $onExternalResource} *
        q!: * {$withdrawPres3Ne * $prizeAll * $fromAccount} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $fromAccount} *

        q!: * {$transferPastPresNe * [$prizeWithMoney] * $fromWallet} *
        q!: * {$transferPastPresNe * [$prizeWithMoney] * $onExternalResource} *
        q!: * {$transferPastPresNe * $prizeAll * $fromAccount} *

        q!: * {$sendPastPresNe * [$prizeWithMoney] * $fromWallet} *
        q!: * {$sendPastPresNe * [$prizeWithMoney] * $onExternalResource} *
        q!: * {$sendPastPresNe * $prizeAll * $fromAccount} *

        q!: * {$moneyAddPastPresNe * [$prizeWithMoney] * $onExternalResource} *

        q!: * {$producePres3Ne * ($fromWallet/$onExternalResource)} *

        # Перевел средства из Кошелька Столото, не поступили
        q!: * $withdrewFromWallet * $problemsWithWalletCashing *
        q!: * {$cashoutPastPres * $wallet * $bonusComePastPresNe} *
        q!: * {$cashoutPastPres * $prizeWithMoney * $bonusComePastPresNe} *

        q!: * {$moneyTakeOffPastPres * $fromWallet} * {$prizeWithMoney * $bonusComePastPresNe} *

        q!: * {($getPrizPastPres/$transferPastPres/$sendPastPres) * ($fromWallet/$onExternalResource)} *

        q!: * {$getPrizPastPres * [$prizeWithMoney] * $fromWallet * $bonusComePastPresNe} *
        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource * $bonusComePastPresNe} *

        q!: * {$transferPastPres * [$prizeWithMoney] * $fromWallet * $bonusComePastPresNe} *
        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource * $bonusComePastPresNe} *

        q!: * {$sendPastPres * [$prizeWithMoney] * $fromWallet * $bonusComePastPresNe} *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource * $bonusComePastPresNe} *

        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource * $bonusComePastPresNe} *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource * $bonusComePastPresNe} *
        q!: * {($comMoney/$rub) * $onExternalResource * $bonusComePastPresNe} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prizeWithMoney * $fromWallet * $bonusComePastPresNe} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prizeWithMoney * $onExternalResource * $bonusComePastPresNe} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet * $difficulty} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource * $difficulty} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet * $delay} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource * $delay} *

        # Обналичил кошелек где деньги

        q!: * {$cashoutPastPres * $wallet * $comWhere * $prizeWithMoney} *

        q!: * {$getPrizPastPres * $fromWallet * $comWhere * [$prizeWithMoney]} *
        q!: * {$transferPastPres * $fromWallet * $comWhere * [$prizeWithMoney]} *
        q!: * {$sendPastPres * $fromWallet * $comWhere * [$prizeWithMoney]} *

        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource * $comWhere} *
        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource * $comWhere} *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource * $comWhere} *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource * $comWhere} *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource * $comWhere} *

        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource} * $when *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource} * $when *
        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource} * $when *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource} * $when *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource} * $when *

        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource} * $comNo *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource} * $comNo *
        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource} * $comNo *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource} * $comNo *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource} * $comNo *

        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource * $error} *
        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource * $error} *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource * $error} *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource * $error} *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource * $error} *

        q!: * {$getPrizPastPres * [$prizeWithMoney] * $fromWallet * $error} *
        q!: * {$transferPastPres * [$prizeWithMoney] * $fromWallet * $error} *
        q!: * {$sendPastPres * [$prizeWithMoney] * $fromWallet * $error} *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $fromWallet * $error} *
        q!: * {$depositPastPres * [$prizeWithMoney] * $fromWallet * $error} *

        q!: * {$cashoutInf * $wallet * $error} *
        q!: * {$cashoutInf * $prizeWithMoney * $error} *
        q!: * {$getPrizInf * [$prizeWithMoney] * $fromWallet * $error} *
        q!: * {$getPrizInf * [$prizeWithMoney] * $onExternalResource * $error} *
        q!: * {$transferInfImp * [$prizeWithMoney] * $fromWallet * $error} *
        q!: * {$transferInfImp * [$prizeWithMoney] * $onExternalResource * $error} *
        q!: * {$sendInf * [$prizeWithMoney] * $fromWallet * $error} *
        q!: * {$sendInf * [$prizeWithMoney] * $onExternalResource * $error} *
        q!: * {$moneyAddInf * [$prizeWithMoney] * $onExternalResource * $error} *
        q!: * {$depositInf * [$prizeWithMoney] * $onExternalResource * $error} *

        q!: * {$error * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource} *
        q!: * {$error * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet} *

        q!: * {$onExternalResource * $bonusComePastPresFut * $prizeWithMoney * ($howLong/$when)} *
        q!: * {$prizeAndSum * $bonusComePastPresNe * $onExternalResource} *
        q!: * {($howLong/долго) * ($transferPres3/$sendPres3/$getPrizPresPlSg3) * $fromWallet} *
        q!: * {($howLong/долго) * ($transferPres3/$sendPres3/$getPrizPresPlSg3) * $onExternalResource} *

        q!: * {$when * выведут * [$moneyAndRub/$prizeAll] * $onExternalResource} *
        q!: * {$howLong * выведут * [$moneyAndRub/$prizeAll] * $onExternalResource} *

        q!: * {$howLong * $bonusComeFut * $moneyAndRub * $fromWallet} *
        q!: * {$when * $bonusComeFut * $moneyAndRub * $fromWallet} *
        q!: * {$howLong * $transferFut * $moneyAndRub * $fromWallet} *
        q!: * {$when * $transferFut * $moneyAndRub * $fromWallet} *

        q!: * $when * $fromWallet * $onExternalResource *

        q!: * $onExternalResource * $bonusComePastPres $Number *

        q!: * {~время * $prizeWithMoney * $onExternalResource} *
        q!: * $getPrizPastPres * [$prizeWithMoney] * $onExternalResource * $howLong *
        q!: * {$howLong * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата/~начисление/~зачисление/~перечисление) * $onExternalResource} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prizeWithMoney * $fromWallet * $comWhere} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * ($ne (весь/все) $prizeWithMoney) * $fromWallet * $bonusComePastPres} *
        q!: * {$onExternalResource * ($ne (весь/все) $prizeWithMoney) * $bonusComePastPres} *

        q!: * $prizeAndSum $inWallet * {$cantPastPresAll * ($cashoutInf/$getPrizInf/$transferInfImp) * $fromThere} *
        q!: * {$cantPastPresAll ($getPrizInf/$transferInfImp) [$comMy] $prizeAndSum} (который/которые) ($transferPastPres/$moneyAddPastPres/$sendPastPres) $toWalletAll *

        q!: * долго * длит* * ~выплата * $fromWallet *
        q!: * долго * длит* * ~выплата * $onExternalResource *
        q!: * {(прошл* $li транзакц*) * $onExternalResource} *

        q!: * $skolko (проходит/длитс*/длитьс*/длиц*) (~начисление/~зачисление/~перечисление/~перевод/~отправка/~выплата) * $onExternalResource *

        q!: * долго * (проходит/длитс*/длитьс*/длиц*) * (~начисление/~зачисление/~перечисление/~перевод/~отправка/~выплата) * $onExternalResource *

        q!: * $comNo * (~начисление/~зачисление/~перечисление) [$prizeAll] * ($fromWallet/$onExternalResource) *
        q!: * ($fromWallet/$onExternalResource) * (~начисление/~зачисление/~перечисление) * $comNo *
        q!: * $why * $comNo * $onExternalResource *

        # ничего на карту не пришло
        q!: * {$nothing * $onExternalResource * $smsComePastPerfNe} *

        # не весь выигрыш переведен на карту
        q!: * {$notAllSum * $bonusComePastPres * $onExternalResource}
        q!: * {$notAllSum * $getPrizPastPres * $onExternalResource} *
        q!: * {$notAllSum * $transferPastPres * $onExternalResource} *
        q!: * {$notAllSum * $sendPastPres * $onExternalResource} *
        q!: * {$notAllSum * $moneyAddPastPres * $onExternalResource} *

        q!: * {$notAllSum * $received * $onExternalResource} *
        q!: * {$notAllSum * $transferPartPas * $onExternalResource} *
        q!: * {$notAllSum * $sendPartPas * $onExternalResource} *
        q!: * {$notAllSum * $moneyAddPartPas * $onExternalResource} *

        q!: * номер карты * $ne соответствует формату *

        q: из || fromState = /Payments/ICantToTransferPrize
        q: * $fromWallet * || fromState = /Payments/ICantToTransferPrize
        q: * $onExternalResource [$ne $toWalletAll] * || fromState = /Payments/ICantToTransferPrize
        q: $externalResource || fromState = /Payments/ICantToTransferPrize
        q: [на] (сторонний/сторонние) || fromState = /Payments/ICantToTransferPrize
        q: на ресурсы || fromState = /Payments/ICantToTransferPrize
        q: * {$transferInfImp * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferPrize
        q: * {$sendInf * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferPrize
        q: * {$moneyAddInf * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferPrize
        q: * (со/из) $stoloto * || fromState = /Payments/ICantToTransferPrize
        q: * с сайта * || fromState = /Payments/ICantToTransferPrize

        q: (третье/последнее) || fromState = /Payments/ICantToTransferTheMoney
        q: из || fromState = /Payments/ICantToTransferTheMoney
        q: * $fromWallet * || fromState = /Payments/ICantToTransferTheMoney
        q: * $onExternalResource * || fromState = /Payments/ICantToTransferTheMoney
        q: $externalResource || fromState = /Payments/ICantToTransferTheMoney
        q: [на] (сторонний/сторонние) || fromState = /Payments/ICantToTransferTheMoney
        q: на ресурсы || fromState = /Payments/ICantToTransferTheMoney
        q: * (со/из) $stoloto * || fromState = /Payments/ICantToTransferTheMoney
        q: * с сайта * || fromState = /Payments/ICantToTransferTheMoney
        q: * {$transferInfImp * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferTheMoney
        q: * {$sendInf * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferTheMoney
        q: * {$moneyAddInf * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferTheMoney

        intent!: /Payments/WithdrawDoesntWork
        a: По вопросам перевода средств из Кошелька Столото, пожалуйста, обратитесь в службу поддержки компании ООО РНКО «Единая касса» (support@w1.ru) или по номеру телефона 8-495-777-11-25.


    state: WithdrawDoesntWorkRusLoto
        # Не могу обналичить кошелек (стейт только для Русского лото)
        q!: * {$cantPastPresAll * $cashoutInf * $wallet * @RL} *
        q!: * {$cantPastPresAll * $cashoutInf * $prizeWithMoney * @RL} *

        q!: * {$cantPastPresAll * $cashoutInf * $fromWallet * @RL} *
        q!: * {$cantPastPresAll * $cashoutInf * $fromAccount * @RL} *
        q!: * {$cantPastPresAll * $withdrawInf * $fromAccount * @RL} *
        q!: * {($ne вывести/невывести/нивывести) * $fromAccount * @RL} *

        q!: * {$cantPastPresAll * $getPrizInf * [$prizeWithMoney] * $fromWallet * @RL} *
        q!: * {$cantPastPresAll * $onExternalResource * @RL} *
        q!: * {$onExternalResource * @RL} * работает *
        q!: * @RL * {$onExternalResource * ($ne было/небыло) * ~поступление} *
        q!: * $onExternalResource * @RL * {($ne было/небыло) * ~поступление} *
        q!: * {$cantPastPresAll * $getPrizInf * [$prizeWithMoney] * $onExternalResource * @RL} *

        q!: * {$cantPastPresAll * $transferInfImp * [$prizeWithMoney] * $fromWallet * @RL} *
        q!: * {$cantPastPresAll * $transferInfImp * [$prizeWithMoney] * $onExternalResource * @RL} *
        q!: * {$cantPastPresAll * $transferInfImp * $prizeAll * $fromAccount * @RL} *

        q!: * {$cantPastPresAll * $sendInf * [$prizeWithMoney] * $fromWallet * @RL} *
        q!: * {$cantPastPresAll * $sendInf * [$prizeWithMoney] * $onExternalResource * @RL} *
        q!: * {$cantPastPresAll * $sendInf * $prizeAll * $fromAccount * @RL} *

        q!: * {$cantPastPresAll * $moneyAddInf * [$prizeWithMoney] * $onExternalResource * @RL} *
        q!: * {$cantPastPresAll * $depositInf * [$prizeWithMoney] * $onExternalResource * @RL} *
        q!: * {$cantPastPresAll * оформить * $prizeAll * $onExternalResource * @RL} *

        q!: * {$cantPastPresAll * $prizeAndSum * ($payment $telephone) * @RL} *

        q!: * {$cantPastPresAll * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet * @RL} *
        q!: * {$cantPastPresAll * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource * @RL} *

        q!: * @RL * {$workFut * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * ($fromWallet/$onExternalResource)} *
        q!: * {$workFut * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * ($fromWallet/$onExternalResource)} * @RL *
        q!: * {$workFut * ((~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * @RL) * ($fromWallet/$onExternalResource)} *

        q!: * @RL * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * @RL * $fromWallet *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet * @RL *

        q!: * @RL * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * @RL * $onExternalResource *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource * @RL *
        q!: * $comNo * (~начисление/~зачисление/~перечисление) $prizeAndSum * $onExternalResource * @RL *

        q!: * @RL * {$getPrizInfNe * [$prizeAndSumAndWinTicket/$prizeWithMoney] * ($fromWallet/$onExternalResource)} *
        q!: * {$getPrizInfNe * ([$prizeAndSumAndWinTicket/$prizeWithMoney] * @RL) * ($fromWallet/$onExternalResource)} *
        q!: * {$getPrizInfNe * [$prizeAndSumAndWinTicket/$prizeWithMoney] * ($fromWallet/$onExternalResource)} * @RL *

        # Не обналичивается кошелек
        q!: * {$cashoutPastPresNe * $wallet * @RL} *
        q!: * {$cashoutPastPresNe * $prizeWithMoney * @RL} *
        q!: * {$cashoutPastPresNe * $fromWallet * @RL} *

        q!: * {$getPrizPastPresNe * [$prizeWithMoney] * $fromWallet * @RL} *
        q!: * {$getPrizPastPresNe * [$prizeWithMoney] * $onExternalResource * @RL} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $fromWallet * @RL} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $onExternalResource * @RL} *
        q!: * {$withdrawPres3Ne * $prizeAll * $fromAccount * @RL} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $fromAccount * @RL} *

        q!: * {$transferPastPresNe * [$prizeWithMoney] * $fromWallet * @RL} *
        q!: * {$transferPastPresNe * [$prizeWithMoney] * $onExternalResource * @RL} *
        q!: * {$transferPastPresNe * $prizeAll * $fromAccount * @RL} *

        q!: * {$sendPastPresNe * [$prizeWithMoney] * $fromWallet * @RL} *
        q!: * {$sendPastPresNe * [$prizeWithMoney] * $onExternalResource * @RL} *
        q!: * {$sendPastPresNe * $prizeAll * $fromAccount * @RL} *

        q!: * {$moneyAddPastPresNe * [$prizeWithMoney] * $onExternalResource * @RL} *

        # Перевел средства из Кошелька Столото, не поступили
        q!: * $withdrewFromWallet * @RL * $problemsWithWalletCashing *
        q!: * {$producePres3Ne * ($fromWallet/$onExternalResource) * @RL} *

        q!: * {$cashoutPastPres * $wallet * $bonusComePastPresNe * @RL} *
        q!: * {$cashoutPastPres * $prizeWithMoney * $bonusComePastPresNe * @RL} *

        q!: * @RL * {$moneyTakeOffPastPres * $fromWallet} * {$prizeWithMoney * $bonusComePastPresNe} *
        q!: * {$moneyTakeOffPastPres * $fromWallet} * {$prizeWithMoney * $bonusComePastPresNe} * @RL *


        q!: * {($getPrizPastPres/$transferPastPres/$sendPastPres) * ($fromWallet/$onExternalResource) * @RL} *

        q!: * {$getPrizPastPres * [$prizeWithMoney] * $fromWallet * $bonusComePastPresNe * @RL} *
        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource * $bonusComePastPresNe * @RL} *

        q!: * {$transferPastPres * [$prizeWithMoney] * $fromWallet * $bonusComePastPresNe * @RL} *
        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource * $bonusComePastPresNe * @RL} *

        q!: * {$sendPastPres * [$prizeWithMoney] * $fromWallet * $bonusComePastPresNe * @RL} *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource * $bonusComePastPresNe * @RL} *

        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource * $bonusComePastPresNe * @RL} *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource * $bonusComePastPresNe * @RL} *
        q!: * {($comMoney/$rub) * $onExternalResource * $bonusComePastPresNe * @RL} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prizeWithMoney * $fromWallet * $bonusComePastPresNe * @RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prizeWithMoney * $onExternalResource * $bonusComePastPresNe * @RL} *

        q!: * @RL * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * ($fromWallet/$onExternalResource) * ($difficulty/$delay)} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * ($fromWallet/$onExternalResource) * ($difficulty/$delay)} * @RL *
        q!: * {((~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * @RL) * ($fromWallet/$onExternalResource) * ($difficulty/$delay)} *

        # Обналичил кошелек где деньги
        q!: * {$cashoutPastPres * $wallet * $comWhere * $prizeWithMoney * @RL} *

        q!: * {$getPrizPastPres * $fromWallet * $comWhere * [$prizeWithMoney] * @RL} *
        q!: * {$transferPastPres * $fromWallet * $comWhere * [$prizeWithMoney] * @RL} *
        q!: * {$sendPastPres * $fromWallet * $comWhere * [$prizeWithMoney] * @RL} *

        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource * $comWhere * @RL} *
        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource * $comWhere * @RL} *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource * $comWhere * @RL} *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource * $comWhere * @RL} *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource * $comWhere * @RL} *

        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource * @RL} * $when *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource * @RL} * $when *
        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource * @RL} * $when *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource * @RL} * $when *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource * @RL} * $when *

        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource * @RL} * $comNo *
        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource} * $comNo * @RL *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource * @RL} * $comNo *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource} * $comNo * @RL *
        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource * @RL} * $comNo *
        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource} * $comNo * @RL *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource * @RL} * $comNo *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource} * $comNo * @RL *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource * @RL} * $comNo *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource} * $comNo * @RL *

        q!: * {$getPrizPastPres * [$prizeWithMoney] * $onExternalResource * $error * @RL} *
        q!: * {$transferPastPres * [$prizeWithMoney] * $onExternalResource * $error * @RL} *
        q!: * {$sendPastPres * [$prizeWithMoney] * $onExternalResource * $error * @RL} *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $onExternalResource * $error * @RL} *
        q!: * {$depositPastPres * [$prizeWithMoney] * $onExternalResource * $error * @RL} *

        q!: * {$getPrizPastPres * [$prizeWithMoney] * $fromWallet * $error * @RL} *
        q!: * {$transferPastPres * [$prizeWithMoney] * $fromWallet * $error * @RL} *
        q!: * {$sendPastPres * [$prizeWithMoney] * $fromWallet * $error * @RL} *
        q!: * {$moneyAddPastPres * [$prizeWithMoney] * $fromWallet * $error * @RL} *
        q!: * {$depositPastPres * [$prizeWithMoney] * $fromWallet * $error * @RL} *

        q!: * {$cashoutInf * $wallet * $error * @RL} *
        q!: * {$cashoutInf * $prizeWithMoney * $error * @RL} *
        q!: * {$getPrizInf * [$prizeWithMoney] * $fromWallet * $error * @RL} *
        q!: * {$getPrizInf * [$prizeWithMoney] * $onExternalResource * $error * @RL} *
        q!: * {$transferInfImp * [$prizeWithMoney] * $fromWallet * $error * @RL} *
        q!: * {$transferInfImp * [$prizeWithMoney] * $onExternalResource * $error * @RL} *
        q!: * {$sendInf * [$prizeWithMoney] * $fromWallet * $error * @RL} *
        q!: * {$sendInf * [$prizeWithMoney] * $onExternalResource * $error * @RL} *
        q!: * {$moneyAddInf * [$prizeWithMoney] * $onExternalResource * $error * @RL} *
        q!: * {$depositInf * [$prizeWithMoney] * $onExternalResource * $error * @RL} *

        q!: * {$error * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource * @RL} *
        q!: * {$error * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet * @RL} *

        q!: * {$when * выведут * [$moneyAndRub/$prizeAll] * $onExternalResource * @RL} *
        q!: * {$howLong * выведут * [$moneyAndRub/$prizeAll] * $onExternalResource * @RL} *

        q!: * {$onExternalResource * $bonusComePastPresFut * $prizeWithMoney * ($howLong/$when) * @RL} *
        q!: * {$prizeAndSum * $bonusComePastPresNe * $onExternalResource * @RL} *
        q!: * {($howLong/долго) * ($transferPres3/$sendPres3/$getPrizPresPlSg3) * $fromWallet * @RL} *
        q!: * {($howLong/долго) * ($transferPres3/$sendPres3/$getPrizPresPlSg3) * $onExternalResource * @RL} *
        q!: * {$howLong * $bonusComeFut * $moneyAndRub * $fromWallet * @RL} *
        q!: * {$when * $bonusComeFut * $moneyAndRub * $fromWallet * @RL} *
        q!: * {$howLong * $transferFut * $moneyAndRub * $fromWallet * @RL} *
        q!: * {$when * $transferFut * $moneyAndRub * $fromWallet * @RL} *

        q!: * {~время * $prizeWithMoney * $onExternalResource * @RL} *

        q!: * @RL * $getPrizPastPres * [$prizeWithMoney] * $onExternalResource * $howLong *
        q!: * $getPrizPastPres * [$prizeWithMoney] * @RL * $onExternalResource * $howLong *
        q!: * $getPrizPastPres * [$prizeWithMoney] * $onExternalResource * $howLong * @RL *

        q!: * {$howLong * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата/~начисление/~зачисление/~перечисление) * $onExternalResource * @RL} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prizeWithMoney * $fromWallet * $comWhere * @RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * ($ne (весь/все) $prizeWithMoney) * $fromWallet * $bonusComePastPres * @RL} *
        q!: * {$onExternalResource * ($ne (весь/все) $prizeWithMoney) * $bonusComePastPres * @RL} *

        q!: * @RL * $prizeAndSum [по] [$ticket] $inWallet * {$cantPastPresAll * ($cashoutInf/$getPrizInf/$transferInfImp) * $fromThere} *
        q!: * $prizeAndSum [по] [$ticket] @RL $inWallet * {$cantPastPresAll * ($cashoutInf/$getPrizInf/$transferInfImp) * $fromThere} *
        q!: * $prizeAndSum [по] [$ticket] $inWallet * {$cantPastPresAll * ($cashoutInf/$getPrizInf/$transferInfImp) * $fromThere} * @RL *

        q!: * {$cantPastPresAll ($getPrizInf/$transferInfImp) [$comMy] $prizeAndSum} [по] [$ticket] @RL (который/которые) ($transferPastPres/$moneyAddPastPres/$sendPastPres) $toWalletAll *

        q!: * долго * длит* * ~выплата * $fromWallet * @RL *
        q!: * долго * длит* * ~выплата * $onExternalResource * @RL *
        q!: * {(прошл* $li транзакц*) * $onExternalResource * @RL} *

        q!: * $skolko (проходит/длитс*/длитьс*/длиц*) (~начисление/~зачисление/~перечисление/~перевод/~отправка/~выплата) * $onExternalResource * @RL *

        q!: * долго * (проходит/длитс*/длитьс*/длиц*) * (~начисление/~зачисление/~перечисление/~перевод/~отправка/~выплата) * $onExternalResource * @RL *

        q!: * $comNo * (~начисление/~зачисление/~перечисление) [$prizeAll] * {@RL * ($fromWallet/$onExternalResource)} *
        q!: * {@RL * ($fromWallet/$onExternalResource)} * (~начисление/~зачисление/~перечисление) * $comNo *
        q!: * $why * $comNo * {$onExternalResource * @RL} *

        q!: * {(номер карты) * ($ne соответствует формату) * @RL} *

        # ничего на карту не пришло
        q!: * @RL * {$nothing * $onExternalResource * $smsComePastPerfNe} *
        q!: * {$nothing * $onExternalResource * $smsComePastPerfNe} * @RL *

        # не весь выигрыш по РЛ переведен на карту
        q!: * {$notAllSumRL * $bonusComePastPres * $onExternalResource}
        q!: * {$notAllSumRL * $getPrizPastPres * $onExternalResource} *
        q!: * {$notAllSumRL * $transferPastPres * $onExternalResource} *
        q!: * {$notAllSumRL * $sendPastPres * $onExternalResource} *
        q!: * {$notAllSumRL * $moneyAddPastPres * $onExternalResource} *

        q!: * {$notAllSumRL * $received * $onExternalResource} *
        q!: * {$notAllSumRL * $transferPartPas * $onExternalResource} *
        q!: * {$notAllSumRL * $sendPartPas * $onExternalResource} *
        q!: * {$notAllSumRL * $moneyAddPartPas * $onExternalResource} *

        intent!: /Payments/WithdrawDoesntWorkRusLoto
        if: $global.withdrawalFromPurseRLIsAvailable
            a: По вопросам перевода средств из Кошелька Столото, пожалуйста, обратитесь в службу поддержки компании ООО РНКО «Единая касса» (support@w1.ru) или по номеру телефона 8-495-777-11-25.
        else:
            a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Многократно возросла нагрузка на все информационные системы, поэтому сегодня выплаты могут происходить с задержкой. Наши специалисты уже работают над этим. Средства будет перечислены на Ваш счет в ближайшее время.

        ##################Кошелек#############################################

    state: WhatIsAPurse
        # Что такое Кошелек
        q!: * $comWhat $oneWord [вообще] [этот] [виртуальн*] $wallet *
        q!: $wallet {это $comWhat} [вообще]
        q!: * $comWhat это за $wallet
        q!: * $whatFor * ~оферта *
        intent!: /Payments/WhatIsAPurse
        a: При регистрации на сайте автоматически создается Кошелек. Для этого Вы подтверждаете оферту Кошелька.


    state: HowToCreateAPurse
        # Как создать Кошелек
        q!: [$helloAll] {($makeInf/установить/добавить) [$comMy] $wallet}
        q!: * {$makeInf $wallet} *
        q!: * {установить $wallet} *
        q!: * {открыть $wallet} *
        q!: * добавить $comMy $wallet *
        q!: * [$withdrawInf] * $if $comNo $wallet *
        q!: * {$comNeed создавать $wallet} *
        intent!: /Payments/HowToCreateAPurse
        a: Кошелек формируется автоматически при регистрации личного кабинета.


    state: HowToFindAPurse
        # Как найти Кошелек
        q!: [$helloAll] {(*смотреть/увидеть/найти) [этот/эту] [$comMy] [$tab] $wallet}
        q!: * [$prizeAndSumAndWinTicket] * $how [мне] {(*смотреть/увидеть/найти) [этот/эту] [~сам] [$comMy] [$tab] $wallet [то]} *
        q!: * $cantPastPres {найти [~сам] [этот/эту] [$comMy] [$tab] $wallet} *
        q!: * $findFut1Ne [~сам] [этот/эту] [$comMy] [$tab] $wallet *
        q!: [$helloAll] [$beginningWords] $comWhere [$comMy] [$electronic] $wallet
        q!: * $comWhere [~сам] [этот/эта] [$comMy] $tab $wallet *
        q!: * $beginningWords $comWhere [~сам] [этот/эта] [$comMy]  $wallet *
        q!: * $comWhere * (наход*/расположен*/искать/$seeInf) [~сам] [этот/эта] [$comMy] [$tab] $wallet *
        q!: * $comWhere * на (~сайт/[~сайт] $stoloto) [~сам] [этот/эта] [$comMy] [$tab] $wallet *
        q!: * $comWhere ~сам [$tab] $wallet *
        q!: * в (какой/кокой) $wallet вывод* ($prizeAndSumAndWinTicket/$prizeWithMoney) *
        q!: * такое $wallet * его найти *

        intent!: /Payments/HowToFindAPurse
        a: Кошелек Столото находится в личном кабинете в разделе «Кошелек».


    state: HowToFindOutNumberOfPurse
        # Как узнать номер Кошелька
        q!: * {($how/$comWhere/$cantPastPres) * $findInf * $walletNumber} *
        q!: * {($how/$comWhere/$cantPastPres) * $findOutInf * $walletNumber} *
        q!: * {($how/$comWhere) * $checkInf * $walletNumber} *
        q!: * {($how/$comWhere) * $receiveInf * $walletNumber} *
        q!: * $comWhere * (написан*/записан*) * $walletNumber *
        q!: $comWhere [$oneWord] $walletNumber
        q!: * {$comNeed [$comMy] $walletNumber} *
        q!: * (просит/просят) [$comMy] $walletNumber *
        q!: {[$comMy] $walletNumber [просит/просят]}
        q!: *скажи* [мне] [$please] $walletNumber
        q!: * {[я] $forgetPastPres [$comMy] $walletNumber} *
        q!: * ~какой {(у меня) $walletNumber} *
        q!: * ~какой * $walletNumber * {$tiedM * $account} *
        q!: * $findOutInf * $walletNumber * {($tiedM/относящ*/привязан*/$registered) * $account} *
        q!: * *скажи* * $walletNumber * {($tiedM/относящ*/привязан*/$registered) * $account} *
        q!: * $knowNe * $walletNumber * {($tiedM/относящ*/привязан*/$registered) * $account} *
        q!: * (увидеть/посмотреть) * ~какой * $walletNumber * {$registered * $account} *
        q!: * (увидеть/посмотреть) * ~какой * $walletNumber * {$registerPast3 * ($account/я)} *
        q!: * (увидеть/посмотреть) * ~какой * $walletNumber * $duringRegistration *
        q!: * (увидеть/посмотреть) * $walletNumber $account *
        q!: * {$displayPresSg3Ne $walletNumber} *
        intent!: /Payments/HowToFindOutNumberOfPurse
        a: Раздел «Кошелек» находится в Вашем личном кабинете. Номер Кошелька можно найти в левом верхнем углу раздела «Кошелек», под суммой Вашего баланса.


    state: HowToLoginToPurse
        # как зайти в кошелек
        q!: * $how * {$enterInfAll * ($toWallet/(в/во/на) $tab $wallet)} *
        # не могу зайти в кошелек
        q!: * {$enterInfAll * $cantPastPresAll * ($toWallet/(в/во/на) $tab $wallet)} *
        q!: * {$enterPresSg3Ne ($toWallet/(в/во/на) $tab $wallet)} *

        q!: * (~проблема/$difficulty) $with ~вход ($toWallet/(в/во/на) $tab $wallet) *

        q!: * $wallet * {(в него) ($enterInfAll/$enterPresSg3Ne)} *

        a: Опишите подробнее, пожалуйста, в чем у Вас возникла сложность?


    state: HowToSeePurseTransactionHistory
        # Как посмотреть операции по Кошельку
        q!: * {$seeInf * операции * $w1All} *
        q!: * {$seeInf * операций * $w1All} *
        q!: * {$seeInf * ~движение * $w1All} *
        q!: * {$seeInf * детализац* * $w1All} *
        q!: * {$seeInf * (историю списан*) * $w1All} *
        q!: * {$seeInf * (историю *числен*) * $w1All} *
        q!: * {$seeInf * (историю транзакц*) * $w1All} *
        q!: * {$seeInf * (историю вывод*)} *
        q!: * {$seeInf * (историю [в] $w1All)} *
        q!: * {$findOutInf * (историю списан*) * $w1All} *
        q!: * {$findOutInf * (историю *числен*) * $w1All} *
        q!: * {$findOutInf * (историю транзакц*) * $w1All} *
        q!: * есть история операций * $w1All *
        q!: * {$findOutInf * детализац* * $w1All} *
        q!: * {$findOutInf * ~движение * $w1All} *
        q!: * $checkInf * расходы * $w1All *
        q!: * {($seeInf/$checkInf/$findOutInf) * (историю пополнен*)} *
        q!: * $comWhere * {$seeInf * пополнения} *

        q!: * выписк* по * (пополнен*/операциям/операций/списан*/зачислен*) *
        intent!: /Payments/HowToSeePurseTransactionHistory
        a: Для получения выписки по Вашему Кошельку Столото, пожалуйста, обратитесь в службу поддержки компании ООО РНКО «Единая касса» по адресу электронной почты support@w1.ru или по номеру телефона 8-495-777-11-25. Кошелек Столото интегрирован в платформу Единого Кошелька, поэтому у нас, к сожалению, нет доступа к данной информации. Она может быть предоставлена только по личному запросу владельца.


    state: HowToFillUpPurse
        # Как пополнить кошелек
        q!: [$walletAll] $how [мне] $depositInf
        q!: * {$depositInf [на сайте] [$comMy] $walletAll} *
        q!: * $how (пополнить/пополнять) $stoloto *
        q!: * {$depositInf ($moneyAndRub/наличн*/наличк*) $toWallet} *
        q!: * ~пополнение [~счет] ($walletAll/$account) *
        q!: * {(пополнять/по полнять/пополнить/по полнить/пополнть/пополнит) * $possiblePredic} *
        q!: * {(пополнять/по полнять/пополнить/по полнить/пополнть/пополнит) * (получитс*/получитьс*)} *
        q!: * {$depositInf * $fromExternalResource} *
        q!: * {$moneyAddInf * $fromExternalResource} *
        q!: * {~пополнение * $fromExternalResource} *
        q!: * {~начисление * $fromExternalResource} *
        q!: * {~зачисление * $fromExternalResource} *
        q!: * {$transferInfImp * $fromExternalResource} *

        q: {[я] [$want] пополнить} || fromState = /Payments/HowToTransferTheMoney
        q: {[я] [$want] пополнить} || fromState = /Payments/HowToTransferTheMoneyToPurse

        intent!: /Payments/HowToFillUpPurse
        a: Вы можете пополнить баланс Кошелька Столото доступными на сайте способами в разделе «Кошелек» личного кабинета.


    state: DepositDoesntWork
        # Пополнил Кошелек Столото, деньги не поступили
        q!: * $depositWallet1 * $depositDoesntWork1 *
        q!: * $payPast1 * $depositDoesntWork2 *

        q!: [$helloAll] [$why] {~пополнение $comNo}
        q!: * {задерж* * пополн*} *
        q!: * $when * (пополнитс*/пополнитьс*) *
        q!: * $skolko * (времени/$waitInf/идет) * ~пополнение *
        q!: * {$waitInf * (~пополнение [~счет] ($walletAll/$account))} *
        q!: * {~пополнение * ($comNo (начислен*/зачислен*))} *
        q!: {$comWhere ~пополнение [$localMobilePhoneNumber]}
        q!: я $depositPast [в/на] [$stoloto]
        q!: [$helloAll] [я] [только] [что/только] [$usingExternalResource/$fromExternalResource] $depositPastPres [на] ($balance [$w1All]/счет/$w1All) [на] [сумму] [$numberRub] [$usingExternalResource/$fromExternalResource] [в/на] [$stoloto]
        q!: [$helloAll] [я] $depositPastPres ($usingExternalResource/$fromExternalResource) [на] [сумму] [$numberRub]
        q!: [$helloAll] [$usingExternalResource/$fromExternalResource] [я] {$depositPastPres [сюда] [на] $moneyAndRub} [$usingExternalResource/$fromExternalResource] [на] [сумму] [$numberRub] [в/на] [$stoloto]
        q!: * {(недавно/полчаса) * $depositPastPres} *
        q!: * сейчас (пополнил/пополнила) *


        q!: * {$depositPast * обновите} *
        q!: * пополнилс* ($ne полност*/неполност*/ниполност*) *
        q!: * $isWritten [что] [$wallet] пополнилс* *
        q!: * {($ne (произошло/происходит)/непроизошло/нипроизошло/непроисходит/нипроисходит) пополнен*} *
        q!: * {$depositPastPres * $usingExternalResource} *
        q!: * {$depositPastPres * ~поступление} *
        q!: * {($sendPastPres/$transferPastPres) * $fromExternalResource * $toWallet} *
        q!: * {((раньше/ранее) * ($sendPastPres/$transferPastPres)) * $fromExternalResource * (на $stoloto)} *
        q!: * {($usingExternalResource/$fromExternalResource) * (завел/завела)} *

        q!: * {$depositPastPres * ~сумма * $bonusComePastPresNe} *
        q!: * {$depositPastPres * $numberRub * $bonusComePastPresNe} *
        q!: * {$depositPastPres * [$comMoney] * $transferPastPresNe} *
        q!: * {$depositPastPres * ~сумма * $transferPastPresNe} *
        q!: * {$depositPastPres * $numberRub * $transferPastPresNe} *

        q!: * {$depositPastPres * $howLong * [$moneyAndRub]} *
        q!: * {$depositPastPres * $howLong * ~сумма} *
        q!: * {$depositPastPres * $howLong * ~начисление * [$moneyAndRub]} *
        q!: * {$depositPastPres * $howLong * ~зачисление * [$moneyAndRub]} *
        q!: * {$depositPastPres * $when * ~начисление * [$moneyAndRub]} *
        q!: * {$depositPastPres * $when * ~зачисление * [$moneyAndRub]} *
        q!: * {$depositPastPres * $when * $moneyAndRub} *
        q!: * {$depositPastPres * $when * $bonusComePastPres * [$moneyAndRub]} *

        q!: * $depositPastPres * больше $Number мин* *
        q!: * {$depositPastPres * $bonusComePastPresNe * $onBill} *


        q!: * {$depositPastPres * $moneyAndRub * $comNo} *
        q!: * {$depositPastPres * ~сумма * $comNo} *
        q!: * {$depositPastPres * $moneyAndRub * $comWhere} *
        q!: * {$depositPastPres * ~сумма * $comWhere} *
        q!: * {$depositPastPres * $moneyAndRub * куда} *
        q!: * {$depositPastPres * ~сумма * куда} *
        q!: * {$depositPastPres * $moneyAndRub * $zero} *
        q!: * {$depositPastPres * ~сумма * $zero} *
        q!: * {$depositPastPres * $moneyAndRub * тишина} *
        q!: * {$depositPastPres * ~сумма * тишина} *
        q!: * {$depositPastPres * ~сумма * $increasePastPresNe} *
        q!: * {$depositPastPres * $balance * $increasePastPresNe} *
        q!: * {$depositPastPres * ~сумма * $changePastNe} *
        q!: * {$depositPastPres * $walletAll * $changePastNe} *
        q!: * {$depositPastPres * $walletAll * $comNo} *
        q!: * {$depositPastPres * $walletAll * $comWhere} *
        q!: * {$depositPastPres * $walletAll * куда} *
        q!: * {$depositPastPres * $walletAll * $zero} *
        q!: * {$depositPastPres * $walletAll * тишина} *
        q!: * {$depositPastPres * $walletAll * $zeroAdj} *
        q!: * {$depositPastPres * $walletAll * $when} *

        q!: * {~пополнение * $walletAll * $when} *


        q!: * ($sendPastPres/$transferPastPres) * $moneyAndRub * $walletAll * [$inWallet] * ($updatePresPlSg3Ne/$updatePastNe) *
        q!: * {$depositPastPres * $walletAll} * [$inWallet] * ($updatePresPlSg3Ne/$updatePastNe/$findPastPres) *

        q!: * {списание * $fromExternalResource} * $walletAll * ($zero/$comNo/$zeroAdj) *
        q!: * {$depositPastPres * $fromExternalResource} * $nothing $cantPastPres *

        q!: * $skolko $depositPresRefl *
        q!: * $skolko * (занимает/поступает) * ~пополнение *
        q!: * {$slowly * $depositPresRefl * $walletAll} *
        q!: * {$howLong * $depositPresRefl * $walletAll} *

        q!: * {$howLong * ~начисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$howLong * ~зачисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$howLong * ~пополнение * $fromExternalResource * [$toWalletAll]} *
        q!: * {$when * ~начисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$when * ~зачисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$when * ~пополнение * $fromExternalResource * [$toWalletAll]} *
        q!: * {$slowly * ~начисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$slowly * ~зачисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$slowly * ~пополнение * $fromExternalResource} *
        q!: * {$howLong * ~пополнение * $moneyAndRub} *
        q!: * {$howLong * ~пополнение * $walletAll} *

        q!: * $when * (пройдет * $payment/$payment * пройдет) * (по $qiwi/($with/через/($with/при) ~помощь) ($qiwi/$moneyYandex/мтсденьги/мтс деньги/теле2/теле 2)) *
        q!: * (по $qiwi/($with/через/($with/при) ~помощь) ($qiwi/$moneyYandex/мтсденьги/мтс деньги/теле2/теле 2)) * $when * (пройдет * $payment/$payment * пройдет) *

        q!: * {$howLong * $moneyAddPastPres * $moneyAndRub * ~пополнение} *
        q!: * {$slowly * $moneyAddPastPres * $moneyAndRub * ~пополнение} *
        q!: * {$when * $moneyAddPastPres * $moneyAndRub * ~пополнение} *
        q!: * {$howLong * $bonusComePastPres * $moneyAndRub * ~пополнение} *
        q!: * {$slowly * $bonusComePastPres * $moneyAndRub * ~пополнение} *
        q!: * {$when * $bonusComePastPres * $moneyAndRub * ~пополнение} *

        q!: * $comNo $moneyAndRub $fromExternalResource *

        q!: * {~пополнение * $moneyAndRub * $bonusComeFut} *
        q!: * {~пополнение * $moneyAndRub * $transferFut} *



        q!: * {$fromExternalResource * [$when] * $moneyAndRub * $bonusComeFut} * [$inWallet] *
        q!: * {$fromExternalResource * [$when] * $moneyAndRub * $transferFut} *

        q!: * {$fromExternalResource * $howLong * $moneyAndRub * $bonusComeFut} * [$inWallet] *
        q!: * {$fromExternalResource * $howLong * $moneyAndRub * $transferFut} *

        q!: * {$howLong * $moneyAddPastPres * $moneyAndRub * $fromExternalResource} *
        q!: * {$slowly * $moneyAddPastPres * $moneyAndRub * $fromExternalResource} *
        q!: * {$when * $moneyAddPastPres * $moneyAndRub * $fromExternalResource} *
        q!: * {$howLong * $bonusComePastPres * $moneyAndRub * $fromExternalResource} *
        q!: * {$slowly * $bonusComePastPres * $moneyAndRub * $fromExternalResource} *
        q!: * {$when * $bonusComePastPres * $moneyAndRub * $fromExternalResource} *

        q!: * {$howLong * $moneyAddPastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *
        q!: * {$slowly * $moneyAddPastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *
        q!: * {$when * $moneyAddPastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *
        q!: * {$howLong * $bonusComePastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *
        q!: * {$slowly * $bonusComePastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *
        q!: * {$when * $bonusComePastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *

        q!: * {$howLong * $moneyAddPastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$slowly * $moneyAddPastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$when * $moneyAddPastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$howLong * $bonusComePastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$slowly * $bonusComePastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$when * $bonusComePastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$howLong * $bonusComeFut * $moneyAndRub * $usingExternalResource} *
        q!: * {$when * $bonusComeFut * $moneyAndRub * $usingExternalResource} *
        q!: * {$howLong * $transferFut * $moneyAndRub * $usingExternalResource} *
        q!: * {$when * $transferFut * $moneyAndRub * $usingExternalResource} *

        q!: * {$cantPastPresAll * внести * $moneyAndRub * $toWallet} *
        q!: * {$cantPastPresAll * внести * ~сумма * $toWallet} *
        q!: * {$cantPastPresAll * внести * $moneyAndRub * $onBalance} *
        q!: * {$cantPastPresAll * внести * ~сумма * $onBalance} *
        q!: * {$cantPastPresAll * внести * $moneyAndRub * $onBill} *
        q!: * {$cantPastPresAll * внести * ~сумма * $onBill} *
        q!: * {$cantPastPresAll * $depositInf * $walletAll} *
        q!: * {$cantPastPresAll * $depositInf * ($moneyAndRub/наличн*/наличк*) * $toWallet} *
        q!: * {$cantPastPresAll * $depositInf * $bankCardInstr} *
        q!: * {$cantPastPresAll * (~пополнение [~счет] ($walletAll/$account))} *
        q!: {$cantPastPresAll [$moneyAndRub] $depositInf}
        q!: * {$cantPastPresAll ~пополнение} *
        q!: * {($ne $depositInf) * $walletAll} *

        q!: * $how $depositInf * $cantPastPresAll *

        q!: * {$cantPastPresAll * $depositInf * [$toWallet] * $fromExternalResource} *
        q!: * {$cantPastPresAll * $moneyAddInf * $fromExternalResource} *
        q!: * {$cantPastPresAll * $transferInfImp * [$moneyAndRub] * $fromExternalResource * [$wallet]} *
        q!: * {$cantPastPresAll * ~пополнение * $fromExternalResource} *
        q!: * {$cantPastPresAll * ~начисление * $fromExternalResource} *
        q!: * {$cantPastPresAll * ~зачисление * $fromExternalResource} *
        q!: * {$cantPastPresAll * $depositInf * $error} *
        q!: * {$depositInf * $walletAll * $error} *

        q!: * {$error [$with/при] ~пополнение} *
        q!: [$helloAll] $comWhat $with ~пополнение
        q!: * {(~пополнение [~счет] ($walletAll/$account)) * $error} *
        q!: * {$depositInf * $fromExternalResource * $error} *
        q!: * {$moneyAddInf * $fromExternalResource * $error} *
        q!: * {~пополнение * $fromExternalResource * $error} *
        q!: * {~начисление * $fromExternalResource * $error} *
        q!: * {~зачисление * $fromExternalResource * $error} *

        q!: * $when $workFut ~пополнение *
        q!: * {$comMoney $depositPastPresNe} *
        q!: * {$comMoney * $bonusDisappearPastPres} * $bonusComePastPresNe *
        q!: * {$comMoney * $bonusDisappearPastPres} * $depositPastPresNe *
        q!: * {$comMoney * $bonusDisappearPastPres} * $inWallet $comNo *
        q!: * {$bonusComePastPresNe ~оплата $toWallet} *

        q!: * {$fromExternalResource * $transferPastPres * $toWallet * $bonusComePastPresNe * [$moneyAndRub]} *

        q!: * {$bonusComePastPresNe * $fromExternalResource * [$moneyAndRub] * [$toWallet]} *

        q!: * {$bonusComePastPresNe * [$moneyAndRub] * ~пополнение} *
        q!: * {$bonusComePastPresNe * (пополнен* $moneyAndRub) * [$toWalletAll]} *

        q!: * {$fromExternalResource * $transferPastPres * $when * $bonusComeFut} *
        q!: * {$howLong * $fromExternalResource * $toWallet * [$moneyAndRub]} *

        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $inWallet * $comNo} *
        q!: * {$fromExternalResource * $transferPastPres * $inWallet * $comNo} *
        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $inWallet * $zero} *
        q!: * {$fromExternalResource * $transferPastPres * $inWallet * $zero} *

        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $onBalanceLoc * $comNo} *
        q!: * {$fromExternalResource * $transferPastPres * $onBalanceLoc * $comNo} *
        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $onBalanceLoc * $zero} *
        q!: * {$fromExternalResource * $transferPastPres * $onBalanceLoc * $zero} *

        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $onBillLoc * $comNo} *
        q!: * {$fromExternalResource * $transferPastPres * $onBillLoc * $comNo} *
        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $onBillLoc * $zero} *
        q!: * {$fromExternalResource * $transferPastPres * $onBillLoc * $zero} *

        q!: * {$fromExternalResource * $transferPastPres * [$toWalletAll]} * {(их/$comMoney) * $comNo} *

        q!: * {$fromExternalResource * $moneyTakeOffPastPres} * ($balance на нуле/пишет $zero/$zeroAdj) *
        q!: * {$fromExternalResource * $transferPastPres} * ($balance на нуле/пишет $zero/$zeroAdj) *


        q!: * $depositInf * {$fromExternalResource * $moneyTakeOffPastPres} *

        q!: * $transferPastPres * $usingExternalResource * {$comNo * ((на/в) $walletAll)} *

        q!: * ($usingExternalResource/$fromExternalResource) * ($comMoney ($comNo/$findPastPresNe)/($comNo/$findPastPresNe) $comMoney) *
        q!: * ($comMoney ($comNo/$findPastPresNe)/($comNo/$findPastPresNe) $comMoney) * ($usingExternalResource/$fromExternalResource) *


        q!: * {$transferPastPres * $usingExternalResource * [$wallet] * $bonusComePastPresNe} *
        q!: * {$depositPastPres * $usingExternalResource * [$wallet] * $bonusComePastPresNe} *
        q!: * {$depositPastPres * $usingExternalResource * $moneyAndRub * $bonusComePastPresNe} *
        q!: * {$transferPastPres * $numberRub * $toWallet} * {$findPastPresNe * их} *
        q!: * {$comMoney $moneyTakeOffPastPres} (а/$but) $wallet пуст* *

        q!: * {депозит * $bonusComePastPresNe} *

        q!: * ($depositInf * $wallet/$wallet * $depositInf) * {$comMoney * [$moneyTakeOffPastPres] * $bonusComePastPresNe} *


        q!: * {$payPast * $fromExternalResource * $moneyAndRub * $bonusComePastPresNe} *
        q!: * {$payPast * $usingExternalResource * $moneyAndRub * $bonusComePastPresNe} *

        q!: * {$payment * $fromExternalResource * $moneyAndRub * $bonusComePastPresNe} *
        q!: * {$payment * $usingExternalResource * $moneyAndRub * $bonusComePastPresNe} *

        q!: * {$sendPastPres * $toWalletAll * $usingExternalResource * $moneyAndRub * $bonusComePastPresNe} *

        q!: * {$fromExternalResource * $toWallet * $slowly} *
        q!: * {$fromExternalResource * $toWallet * быстро} *
        q!: * {$fromExternalResource * $toWallet * $when} *
        q!: * {$fromExternalResource * $toWallet * скоро} *
        q!: * {$fromExternalResource * $onBalance * $slowly} *
        q!: * {$fromExternalResource * $onBalance * быстро} *
        q!: * {$fromExternalResource * $onBalance * $when} *
        q!: * {$fromExternalResource * $onBalance * скоро} *
        q!: * {$fromExternalResource * $onBill * $slowly} *
        q!: * {$fromExternalResource * $onBill * быстро} *
        q!: * {$fromExternalResource * $onBill * $when} *
        q!: * {$fromExternalResource * $onBill * скоро} *
        q!: * {$fromExternalResource * $walletAll * $updatePresSg3Ne} *
        q!: * {$fromExternalResource  * $toWallet * $changeNe} *
        q!: * {$fromExternalResource * $onBalance * $changeNe} *
        q!: * {$fromExternalResource * $onBill * $changeNe} *
        q!: * {$fromExternalResource  * $toWallet * $bonusComeFut} *
        q!: * {$fromExternalResource * $onBalance * $bonusComeFut} *
        q!: * {$fromExternalResource * $onBill * $bonusComeFut} *
        q!: * {$fromExternalResource * $inWallet * $findPastPresNe} *
        q!: * {$transferPastPresNe * $comMoney * $fromExternalResource} *
        q!: * {$findPastPresNe * ~пополнение} *
        q!: * [$fromExternalResource] * {$walletAll * $depositPastPresNe} *
        q!: * {$inWallet $comNo $moneyAndRub переведен* $fromExternalResource} *
        q!: * {$inWallet $comNo $moneyAndRub переведен* $poExternalResource} *
        q!: * {$inWallet $findPastPresNe $moneyAndRub переведен* $fromExternalResource} *
        q!: * {$inWallet $findPastPresNe $moneyAndRub переведен* $poExternalResource} *
        q!: * {$inWallet $displayPresSg3Ne ((внесен*) $payment [$numberRub])} *
        q!: * {$inWallet $displayPresPl3Ne ((внесен*) $payment [$numberRub])} *
        q!: * {$onBalanceLoc $displayPresSg3Ne ((внесен*) $payment [$numberRub])} *
        q!: * {$onBalanceLoc $displayPresPl3Ne ((внесен*) $payment [$numberRub])} *

        q!: * $depositPastPres $toWalletAll $Number $butAll *
        q!: * $depositPastPres $butAll $walletAll $displayPres3 *

        q!: * $fromExternalResource * $balance * ($former/как [и] был/$changeNe) *

        q!: * $fromExternalResource * ($inWallet $isWritten/зачислите/$comMoney $ne сели) *


        q!: * $transferPastPres $numberRub [на ваш счет] (а/но) $balance показывает [$only] $numberRub *

        q!: * {$fromExternalResource * $transferPastPres} * $comWhere [$comMy] $comMoney *
        q!: * (~перевод/$transferInfImp/перевожу) * $fromExternalResource * сервис $availableNe *

        q!: * при попытке пополн* *

        q: {$comMoney $comNo} || fromState = /Payments/HowToFillUpPurse

        q: первое || fromState = /Payments/ICantToTransferTheMoney
        q: [$comYes] {[я] [$want] $depositInf ($walletAll [$stoloto])} || fromState = /Payments/ICantToTransferTheMoney
        q: * {$want $depositInf} * || fromState = /Payments/ICantToTransferTheMoney
        q: {[я] [$cantPastPresAll] $depositInf} || fromState = /Payments/ICantToTransferTheMoney
        q: * пополн* * || fromState = /Payments/ICantToTransferTheMoney
        q: * [~пополнение] * $fromExternalResource * || fromState = /Payments/ICantToTransferTheMoney

        q: первое || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: [$comYes] {[я] [$want] $depositInf ($walletAll [$stoloto])} || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$want $depositInf} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: {[я] [$cantPastPresAll] $depositInf} || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * пополн* * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * [~пополнение] * $fromExternalResource * || fromState = /Payments/ICantToTransferTheMoneyToPurse

        q: {[я] [$cantPastPresAll] $depositInf} || fromState = /Payments/WhereIsTheMoney
        q: * пополн* * || fromState = /Payments/WhereIsTheMoney
        q: * [~пополнение] * $fromExternalResource * || fromState = /Payments/WhereIsTheMoney
        q: * (через/черес) [банк*] карт* * || fromState = /Payments/WhereIsTheMoney
        intent!: /Payments/DepositDoesntWork
        a: По вопросам пополнения баланса Кошелька Столото, пожалуйста, обратитесь в службу поддержки компании ООО РНКО «Единая касса» (support@w1.ru) или по номеру телефона 8-495-777-11-25.


    #############################идентификация#############################


    state: HowToGetIdentification
        # Что такое идентификация
        # Зачем нужна идентификация
        q!: [$helloAll] [~вопрос] [про/о/об] $identification
        q!: * $comWhat $oneWord $identification *
        q!: * [$ne могу понять] * $whatFor [$oneWord] $oneWord $identification * [$ne могу понять] *
        q!: $identification $whatFor (она/ее) *
        q!: $identification {это $comWhat}
        q!: $identification $comWhat дает *
        q!: * {$identification * влияет} *
        q!: * {$identification * (пройти/проити)} *
        q!: * {$identification * проходить} *
        q!: * {$identification * подтвердить} *
        q!: * $identificateInf [$comMy] [личн*] данные *
        q!: * чем *лич* $identification через заполнение анкеты *
        q!: * куда * по поводу $identification *
        q!: * {$how [мне] $identificateInf} *
        q!: * $how * {сделать * $identification} *
        intent!: /Payments/HowToGetIdentification
        a: Существует два вида идентификации.\n\nИдентификация Кошелька «Столото» проводится ООО РНКО «Единая касса» и служит для увеличения его лимитов.\n\nИдентификация «Столото» - для получения выигрыша по лотерейному билету от 15 000 рублей.\n\nУточните, пожалуйста, о каком виде идентификации Вы хотели бы узнать подробнее?


    state: HowToGetPurseIdentification
        # Что такое идентификация кошелька
        # Зачем нужна идентификация кошелька
        q!: [$helloAll] [~вопрос] [про/о/об] $purseIdentification
        q!: [$helloAll] $possiblePredic $purseIdentification
        q!: * $comWhat $oneWord $purseIdentification *
        q!: * $comWhat $oneWord * статус * (упрощ*/частичн*) $identificateAll *
        q!: * [$ne могу понять] * $whatFor [$oneWord] $oneWord $purseIdentification * [$ne могу понять] *
        q!: * как понять $purseIdentification *
        q!: * (~какой ~цель) [$oneWord] $purseIdentification *
        q!: $purseIdentification $whatFor (она/ее) *
        q!: $purseIdentification {это $comWhat}
        q!: $purseIdentification $comWhat [она] дает *
        q!: * чем *лич* (полн*/упрощен*/видео) $identification *
        q!: * чем *лич* (видеоидентификац*/видеоинформац*/видеоиндефикац*) *
        q!: * чем *лич* $identification $by ($skype/$viber/$gosuslugi/$videoCall) *
        q!: * {$purseIdentification * влияет} *
        q!: * {$purseIdentification * (пройти/проити)} *
        q!: * {$purseIdentification * проходить} *
        q!: * {$purseIdentification * подтвердить} *
        q!: * $how * {сделать * $purseIdentification} *
        q!: * {(пройти/проити) * $identification * (на сайте)} *
        q!: * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/$videoCall) *
        q!: * $identificateInf $by ($skype/$viber/$gosuslugi/$videoCall) *
        q!: * [$how] * {$identificateInf * ([~статус] * $w1All)} *
        q!: * $comWhat (значит/означает/такое) [статус] [$comMy] $w1All $identificateAllNe *
        q!: * как (понять/понимать) [статус] [$comMy] $w1All $identificateAllNe *
        q!: статус [$comMy] $w1All $identificateAllNe
        q!: * {статус [$comMy] $w1All} без $identification * ($comWhat/$how) это *
        q!: * $w1All $identificateAllNe * $how * это сделать *
        q!: * {$cantPastPresAll * $payInf} * (из за/из-за) $identification *
        q!: * ($payPast/оплачиваю) * (потребовал*/требуют) * $identification *
        q!: * куда * по поводу $purseIdentification *
        q!: * {(расширить/рассширить) * $w1All} *
        q!: * {(~какой ~лимит) * $w1All * $identification} *
        q!: [$helloAll] статус [$comMy] $w1All
        q!: * $comWhat $oneWord статус [$comMy] $w1All *

        q: * ($w1All/$purseIdentification/(по/через/черес) инн/един* кас*) * || fromState = /Payments/HowToGetIdentification
        q: * ~первый * || fromState = /Payments/HowToGetIdentification
        q: * (до/менее/меньше) (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/HowToGetIdentification
        q: * {$identificateAllNe * $w1All} * || fromState = /Payments/HowToWithdrawMoney
        q: * (спрашив*/прос*) * $identification * || fromState = /Payments/HowToWithdrawMoney
        q: * ($skype/$viber/$gosuslugi/$videoCall) *  || fromState = /Payments/HowToGetIdentification
        intent!: /Payments/HowToGetPurseIdentification
        a: Идентификация Кошелька - это быстрый процесс, который позволяет установить, что именно Вы (реальный человек с именем, фамилией и паспортом) являетесь владельцем Кошелька «Столото».\n\nЗаконодательство РФ устанавливает ограничения на электронные платежи для анонимных пользователей. Идентификация нужна для того, чтобы расширить возможности по использованию Кошелька «Столото». Идентификацию Кошелька проводит ООО РНКО «Единая касса». Прохождение идентификации Вы осуществляете на свое усмотрение.\n\nИдентификация не влияет на работоспособность Кошелька «Столото». Вы сможете переводить выигрыши в Кошелек и оплачивать билеты, но от идентификации зависят его лимиты и возможность перевода средств на сторонние ресурсы. Ознакомьтесь, пожалуйста, с таблицей статусов пользователей по ссылке https://www.stoloto.ru/wallet_identification .​\n\nПройти идентификацию Вы можете, находясь на странице с информацией по ссылке: https://www.stoloto.ru/wallet_identification . Вам просто нужно нажать на желтую кнопку «Пройти идентификацию» и далее следовать инструкциям.


    state: HowToGetStolotoIdentification
        # Что такое идентификация для получения крупного выигрыша
        q!: [$helloAll] ~вопрос [про/о/об] $stolotoIdentification
        q!: * $comWhat $oneWord $stolotoIdentification *
        q!: * [$ne могу понять] * $whatFor [$oneWord] $oneWord $stolotoIdentification * [$ne могу понять] *
        q!: * как понять $stolotoIdentification *
        q!: * (~какой ~цель) [$oneWord] $stolotoIdentification *
        q!: * какую анкету * ($identification/$stolotoIdentification) *
        q!: $stolotoIdentification $whatFor (она/ее) *
        q!: $stolotoIdentification {это $comWhat}
        q!: $stolotoIdentification $comWhat дает *
        q!: * {$stolotoIdentification * влияет} *
        q!: * {$stolotoIdentification * (пройти/проити)} *
        q!: * {$stolotoIdentification * проходить} *
        q!: * {$stolotoIdentification * подтвердить} *
        q!: * $how * {сделать * $stolotoIdentification} *
        q!: * куда * по поводу $stolotoIdentification *

        q: * получени* [крупн*/больш*] $prize * || fromState = /Payments/HowToGetIdentification
        q: * (крупн*/больш*) $prize * || fromState = /Payments/HowToGetIdentification
        q: * {получ* (в [розн*] точк*)} * || fromState = /Payments/HowToGetIdentification
        q: * ~второй * || fromState = /Payments/HowToGetIdentification
        q: * $identification $stoloto * || fromState = /Payments/HowToGetIdentification
        q: $stoloto || fromState = /Payments/HowToGetIdentification
        q: * (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/HowToGetIdentification
        intent!: /Payments/HowToGetStolotoIdentification
        a: Согласно федеральному закону от 07.08.2001 N 115-ФЗ, при выплате выигрыша по лотерейному билету от 15 000 рублей необходимо пройти процедуру идентификации всем участникам.\n\nИдентификация проходит в несколько этапов:\n1. Необходимо заполнить анкету в Личном кабинете, в разделе «Профиль».\n2. Подтвердить Ваши персональные данные из анкеты в одной из розничных точек. Обязательно возьмите с собой документ, удостоверяющий личность.\n3. После успешного подтверждения данных Вы сможете получать выигрыши любого размера.\n\nЕсли Ваши данные из анкеты изменятся, проходить процедуру идентификации придется повторно.


    state: ICantGetIdentification
        # Не могу пройти идентификацию
        q!: * при попытке [$oneWord] $identification *
        q!: * {$cantPastPresAll * $identification * (пройти/проити)} *
        q!: * {$cantPastPresAll * $identification * проходить} *
        q!: * {$cantPastPresAll * $identification * подтвердить} *
        q!: * {долго * $identification * проходит*} *
        q!: * {скол* * $identification * проходит*} *
        q!: * {скок* * $identification * проходит*} *
        q!: * {скоро * $identification * пройдет} *
        q!: * $when * идентифицируете меня *
        q!: * {$cantPastPresAll * $identificateInf} *
        q!: * прошла * $identification * $or $comNo *
        q!: * $identification ($ne проходит/непроходит/нипроходит) *
        q!: * ($ne проходит/непроходит/нипроходит) $identification *
        q!: * {$identification * ($ne пройдена)} *
        q!: * $why * $ne сделали * $identification *

        intent!: /Payments/ICantGetIdentification
        a: Существует два вида идентификации.\n\nИдентификация Кошелька «Столото» проводится ООО РНКО «Единая касса» и служит для увеличения его лимитов.\n\nИдентификация «Столото» - для получения выигрыша по лотерейному билету от 15 000 рублей.\n\nУточните, пожалуйста, при прохождении какого вида идентификации у Вас возникли трудности?


    state: ICantGetPurseIdentification
        # Не могу пройти идентификацию Кошелька
        q!: * InnPassportValidationError *
        q!: * при попытке [$oneWord] $purseIdentification *
        q!: * {$cantPastPresAll * $purseIdentification * (пройти/проити)} *
        q!: * {$cantPastPresAll * $purseIdentification * проходить} *
        q!: * {$cantPastPresAll * $purseIdentification * подтвердить} *
        q!: * {$cantPastPresAll * (расширить/рассширить) * $w1All} *
        q!: * {долго * $purseIdentification * проходит*} *
        q!: * {скол* * $purseIdentification * проходит*} *
        q!: * {скок* * $purseIdentification * проходит*} *
        q!: * {долго * $purseIdentification * обрабат*} *
        q!: * {скол* * $purseIdentification * обрабат*} *
        q!: * {скок* * $purseIdentification * обрабат*} *
        q!: * {скоро * $purseIdentification * пройдет} *
        q!: * {ответ * $purseIdentification} *
        q!: * $why * $ne сделали * $purseIdentification *
        q!: * $when * {идентифицируете * $w1All} *
        q!: * {$cantPastPresAll * (пройти/проити) * $identification * (на сайте)} *
        q!: * жду * $purseIdentification *
        q!: * $cantPastPresAll подтвердить [$comMy] $w1All *
        q!: * $cantPastPresAll * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/$videoCall) *
        q!: * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/$videoCall) * $cantPastPresAll *
        q!: * $cantPastPresAll * $identificateInf $by ($skype/$viber/$gosuslugi/$videoCall) *
        q!: * $identificateInf $by ($skype/$viber/$gosuslugi/$videoCall) * $cantPastPresAll *
        q!: * {$cantPastPresAll * $identificateInf * $w1All} *
        q!: * {$w1All $identificateAllNe} *
        q!: * $w1All * (все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe *
        q!: * (все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe * $w1All *
        q!: * {$identification * $w1All * (до сих пор $comNo)} *
        q!: * отправил* * час назад * (все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe *
        q!: * $why * {$w1All * $identificateAllNe} *
        q!: * {проверить * заявку * $identification} *
        q!: * {подал* * заявку * $purseIdentification} *
        q!: * (прох*/прош*) $identification * {$w1All * $identificateAllNe} *
        q!: * {$w1All * $identificateAllNe} * (прох*/прош*) $identification *
        q!: * $purseIdentification * $ne *звонил* *
        q!: * $identification $oneWord (1/один) час * (никак*/$comNo) результ* *
        q!: * $identification * в течен* часа *
        q!: * {$identification * ($more (час/часа)/около часа)} *
        q!: * {$identification * ((почти/$more) ($someHours ~час/~сутки))} *
        q!: * ошибк* при $purseIdentification *
        q!: * {($ne проходит) [$comMy] $mail} * $purseIdentification *
        q!: * $purseIdentification * {($ne проходит) [$comMy] $mail} *
        q!: * $purseIdentification ($ne проходит/непроходит/нипроходит) *
        q!: * ($ne проходит/непроходит/нипроходит) $purseIdentification *
        q!: * {$purseIdentification * ($ne пройдена/отклонен*/отклонил*/$confirmPres3Ne)} *
        q!: * $when $beFutSgPl3 пройдена * $purseIdentification *
        q!: * {(пройти/проити) * $identification * ($comNo инн)} *
        q!: * должны были позвонить * ($skype/$viber/$identification) *
        q!: * {$purseIdentification * ($ne связ*/несвяз*/нисвяз*)} *
        q!: * $by ($skype/$viber/$gosuslugi/$videoCall) * (какой статус/$comWhat по статус*) *
        q!: * {ждал* * звонка * ($skype/$viber)} *
        q!: * запрос на $identification * (в обработке/отклонен*) *
        q!: * $identification * запрос (обрабатываетс*/обрабатываетьс*) *
        q!: * (прошел/прошла) * $identification * (присвоить/присвоят) статус *
        q!: * проходил* * $purseIdentification * $when * $result *
        q!: * $comWhere * на $gosuslugi * запрос * $identification *

        q: * ($w1All/$purseIdentification/(по/через/черес) инн/един* кас*) * || fromState = /Payments/ICantGetIdentification
        q: * ~первый * || fromState = /Payments/ICantGetIdentification
        q: * (до/менее/меньше) (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/ICantGetIdentification
        q: * ($skype/$viber/$gosuslugi/$videoCall) * || fromState = /Payments/ICantGetIdentification
        intent!: /Payments/ICantGetPurseIdentification
        a: Идентификацию Кошелька проводит ООО РНКО «Единая касса».\n\nПо вопросам, возникшим в процессе прохождения процедуры идентификации, обратитесь, пожалуйста, в службу поддержки компании ООО РНКО «Единая касса» по адресу электронной почты support@w1.ru или по номеру телефона 8-495-777-11-25.


    state: ICantGetStolotoIdentification
        q: * получени* [крупн*/больш*] $prize * || fromState = /Payments/ICantGetIdentification
        q: * (крупн*/больш*) $prize * || fromState = /Payments/ICantGetIdentification
        q: * {получ* (в [розн*] точк*)} * || fromState = /Payments/ICantGetIdentification
        q: * ~второй * || fromState = /Payments/ICantGetIdentification
        q: * $identification $stoloto * || fromState = /Payments/ICantGetIdentification
        q: $stoloto || fromState = /Payments/ICantGetIdentification
        q: * (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/ICantGetIdentification
        intent!: /Payments/ICantGetStolotoIdentification
        script: Webim.switch();


    state: HowToGetIdentificationIfIAmAForeigner
        # Как пройти идентификацию, если я иностранец
        q!: [$helloAll] ~вопрос [про/о/об] $identification для $foreigner
        q!: * {($comWhat $oneWord $identification) * $foreigner} *
        q!: * {($whatFor [$oneWord] $oneWord $identification) * $foreigner} *
        q!: $identification для $foreigner $whatFor (она/ее) *
        q!: $identification для $foreigner {это $comWhat}
        q!: $identification для $foreigner $comWhat дает *
        q!: * {$identification * (пройти/проити) * $foreigner} *
        q!: * {$identification * проходить * $foreigner} *
        q!: * {$identification * подтвердить * $foreigner} *
        q!: * {($identificateInf [$comMy] [личн*] данные) * $foreigner} *
        q!: * {(куда * по поводу $identification) * $foreigner} *
        q!: * {$how [мне] $identificateInf} * $foreigner *
        q!: * $foreigner * {$how $identificateInf} *
        q!: * просят * $identification * $foreigner *
        q!: * {сделать * $identification * $foreigner} *
        intent!: /Payments/HowToGetIdentificationIfIAmAForeigner
        a: Существует два вида идентификации.\n\nИдентификация Кошелька «Столото» проводится ООО РНКО «Единая касса» и служит для увеличения его лимитов.\n\nИдентификация «Столото» - для получения выигрыша по лотерейному билету от 15 000 рублей.\n\nУточните, пожалуйста, о каком виде идентификации Вы хотели бы узнать подробнее?


    state: IAmAForeignerICantGetIdentification
        # Я иностранец, не могу пройти идентификацию
        q!: * {$cantPastPresAll * $identification * (пройти/проити) * $foreigner} *
        q!: * {$cantPastPresAll * $identification * проходить * $foreigner} *
        q!: * {$cantPastPresAll * $identification * подтвердить * $foreigner} *
        q!: * {$cantPastPresAll * $identification * сделать * $foreigner} *
        q!: * {долго * $identification * проходит* * $foreigner} *
        q!: * {скол* * $identification * проходит* * $foreigner} *
        q!: * {скок* * $identification * проходит* * $foreigner} *
        q!: * {скоро * $identification * пройдет * $foreigner} *

        q!: * {$cantPastPresAll * $identificateInf * $foreigner} *
        q!: * $foreigner * прошла * $identification * $or $comNo *
        q!: * прошла * $identification * $or $comNo * $foreigner *
        q!: * $foreigner * $identification ($ne проходит/непроходит/нипроходит) *
        q!: * $identification ($ne проходит/непроходит/нипроходит) * $foreigner *
        q!: * $foreigner * ($ne проходит/непроходит/нипроходит) $identification *
        q!: * ($ne проходит/непроходит/нипроходит) $identification * $foreigner *
        q!: * {$identification * ($ne пройдена) * $foreigner} *
        q!: * {(при попытке [$oneWord] $identification) * $foreigner} *
        intent!: /Payments/IAmAForeignerICantGetIdentification
        a: Существует два вида идентификации.\n\nИдентификация Кошелька «Столото» проводится ООО РНКО «Единая касса» и служит для увеличения его лимитов.\n\nИдентификация «Столото» - для получения выигрыша по лотерейному билету от 15 000 рублей.\n\nУточните, пожалуйста, при прохождении какого вида идентификации у Вас возникли трудности?


    state: IdentificationOfPurseForForeigner
        # Как идентифицировать кошелек, если я иностранец
        q!: [$helloAll] [~вопрос] [про/о/об] $purseIdentification для $foreigner
        q!: [$helloAll] $possiblePredic $purseIdentification для $foreigner
        q!: * $comWhat $oneWord $purseIdentification для $foreigner *
        q!: * как понять $purseIdentification для $foreigner *
        q!: $purseIdentification для $foreigner {это $comWhat}
        q!: $purseIdentification для $foreigner $comWhat [она] дает *
        q!: * {$purseIdentification * (пройти/проити/проходить/сделать/подтвердить) * $foreigner} *

        q!: * {(при попытке [$oneWord] $purseIdentification) * $foreigner} *
        q!: * {(пройти/проити) * $identification * (на сайте) * $foreigner} *
        q!: * $foreigner * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/$videoCall) *
        q!: * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/$videoCall) * $foreigner *
        q!: * $foreigner * $identificateInf $by ($skype/$viber/$gosuslugi/$videoCall) *
        q!: * $identificateInf $by ($skype/$viber/$gosuslugi/$videoCall) * $foreigner *
        q!: * [$how] * {$identificateInf * ([~статус] * $w1All) * $foreigner} *
        q!: * $foreigner * $comWhat (значит/означает/такое) [статус] [$comMy] $w1All $identificateAllNe *
        q!: * $comWhat (значит/означает/такое) [статус] [$comMy] $w1All $identificateAllNe * $foreigner *
        q!: * $foreigner * как (понять/понимать) [статус] [$comMy] $w1All $identificateAllNe *
        q!: * как (понять/понимать) [статус] [$comMy] $w1All $identificateAllNe * $foreigner *
        q!: * $foreigner * {статус [$comMy] $w1All} без $identification * ($comWhat/$how) это *
        q!: * $foreigner * $w1All $identificateAllNe * $how * это сделать *
        q!: * $w1All $identificateAllNe * $how * это сделать * $foreigner *
        q!: * $foreigner * {$cantPastPresAll * $payInf} * (из за/из-за) $identification *
        q!: * {$cantPastPresAll * $payInf} * (из за/из-за) $identification * $foreigner *
        q!: * $foreigner * ($payPast/оплачиваю) * (потребовал*/требуют) * $identification *
        q!: * ($payPast/оплачиваю) * (потребовал*/требуют) * $identification * $foreigner *
        q!: * $foreigner * куда * по поводу $purseIdentification *
        q!: * куда * по поводу $purseIdentification * $foreigner *

        q!: * {InnPassportValidationError * $foreigner} *
        q!: * {$cantPastPresAll * $purseIdentification * (пройти/проити) * $foreigner} *
        q!: * {$cantPastPresAll * $purseIdentification * проходить * $foreigner} *
        q!: * {$cantPastPresAll * $purseIdentification * подтвердить * $foreigner} *
        q!: * {$cantPastPresAll * $purseIdentification * сделать * $foreigner} *
        q!: * {долго * $purseIdentification * проходит* * $foreigner} *
        q!: * {скол* * $purseIdentification * проходит* * $foreigner} *
        q!: * {скок* * $purseIdentification * проходит* * $foreigner} *
        q!: * {скоро * $purseIdentification * пройдет * $foreigner} *
        q!: * {долго * $purseIdentification * обрабат* * $foreigner} *
        q!: * {скол* * $purseIdentification * обрабат* * $foreigner} *
        q!: * {скок* * $purseIdentification * обрабат* * $foreigner} *
        q!: * {ответ * $purseIdentification * $foreigner} *
        q!: * {$cantPastPresAll * (пройти/проити) * $identification * (на сайте) * $foreigner} *
        q!: * $foreigner * жду * $purseIdentification *
        q!: * жду * $purseIdentification * $foreigner *
        q!: * $foreigner * $cantPastPresAll * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/$videoCall) *
        q!: * $cantPastPresAll * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/$videoCall) * $foreigner *
        q!: * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/$videoCall) * $cantPastPresAll * $foreigner *
        q!: * $foreigner * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/$videoCall) * $cantPastPresAll *
        q!: * $foreigner * $cantPastPresAll * $identificateInf $by ($skype/$viber/$gosuslugi/$videoCall) *
        q!: * $cantPastPresAll * $identificateInf $by ($skype/$viber/$gosuslugi/$videoCall) * $foreigner *
        q!: * $foreigner * $identificateInf $by ($skype/$viber/$gosuslugi/$videoCall) * $cantPastPresAll *
        q!: * $identificateInf $by ($skype/$viber/$gosuslugi/$videoCall) * $cantPastPresAll * $foreigner *
        q!: * {$cantPastPresAll * $identificateInf * $w1All * $foreigner} *
        q!: * $foreigner * {$w1All $identificateAllNe} *
        q!: * {$w1All $identificateAllNe} * $foreigner *
        q!: * {$foreigner * ($w1All * (все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe)} *
        q!: * {$foreigner * ((все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe * $w1All)} *

        q!: * {$foreigner * $identification * $w1All * (до сих пор $comNo)} *
        q!: * {$foreigner * (отправил* * час назад * (все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe)} *
        q!: * $foreigner * $why * {$w1All * $identificateAllNe} *
        q!: * {$foreigner * проверить * заявку * $identification} *
        q!: * $foreigner * (прох*/прош*) $identification * {$w1All * $identificateAllNe} *
        q!: * (прох*/прош*) $identification * {$w1All * $identificateAllNe} * $foreigner *
        q!: * $foreigner * {$w1All * $identificateAllNe} * (прох*/прош*) $identification *
        q!: * {$w1All * $identificateAllNe} * (прох*/прош*) $identification * $foreigner *
        q!: * $foreigner * $purseIdentification * $ne *звонил* *
        q!: * $purseIdentification * $ne *звонил* * $foreigner *
        q!: * $foreigner * $identification $oneWord (1/один) час * (никак*/$comNo) результ* *
        q!: * $identification $oneWord (1/один) час * (никак*/$comNo) результ* * $foreigner *
        q!: * $foreigner * $identification * в течен* часа *
        q!: * $identification * в течен* часа * $foreigner *
        q!: * $foreigner * {$identification * ($more (час/часа)/около часа)} *
        q!: * {$identification * ($more (час/часа)/около часа)} * $foreigner *
        q!: * $foreigner * {$identification * ((почти/$more) ($someHours ~час/~сутки))} *
        q!: * {$identification * ((почти/$more) ($someHours ~час/~сутки))} * $foreigner *
        q!: * {$foreigner * (ошибк* при $purseIdentification)} *
        q!: * $foreigner * {($ne проходит) [$comMy] $mail} * $purseIdentification *
        q!: * {($ne проходит) [$comMy] $mail} * $purseIdentification * $foreigner *
        q!: * $foreigner * $purseIdentification * {($ne проходит) [$comMy] $mail} *
        q!: * $purseIdentification * {($ne проходит) [$comMy] $mail} * $foreigner *
        q!: * {$foreigner * ($purseIdentification ($ne проходит/непроходит/нипроходит))} *
        q!: * {$foreigner * (($ne проходит/непроходит/нипроходит) $purseIdentification)} *
        q!: * {$purseIdentification * ($ne пройдена/отклонен*/отклонил*/$confirmPres3Ne) * $foreigner} *
        q!: * $foreigner * $when $beFutSgPl3 пройдена * $purseIdentification *
        q!: * {(пройти/проити) * $identification * ($comNo инн) * $foreigner} *
        q!: * {(должны были позвонить * ($skype/$viber/$identification)) * $foreigner} *
        q!: * {$purseIdentification * ($ne связ*/несвяз*/нисвяз*) * $foreigner} *
        q!: * {(един* кас*) * $identificateAllNe * $foreigner} *
        q!: * $foreigner * (прошел/прошла) * $identification * (присвоить/присвоят) статус *
        q!: * $foreigner * проходил* * $purseIdentification * $when * $result *
        q!: * $foreigner * $comWhere * на $gosuslugi * запрос * $identification *


        q: * ($w1All/$purseIdentification/(по/через/черес) инн/един* кас*) * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * ~первый * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * (до/менее/меньше) (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * ($skype/$viber/$gosuslugi/$videoCall) *  || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner

        q: * ($w1All/$purseIdentification/(по/через/черес) инн/един* кас*) * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * ~первый * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * (до/менее/меньше) (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * ($skype/$viber/$gosuslugi/$videoCall) * || fromState = /Payments/IAmAForeignerICantGetIdentification

        intent!: /Payments/IdentificationOfPurseForForeigner
        a: Для нерезидентов Российской Федерации доступна только полная идентификация по видеозвонку через Skype или Viber. Для создания заявки на видеоидентификацию Вы можете прислать на почту support@w1.ru свои актуальные паспортные данные, а также второй документ, удостоверяющий Вашу личность. Например: Снилс, ИНН, водительское удостоверение, загранпаспорт, полис медицинского страхования. После отправки документов будет создана заявка на видеоидентификацию. Специалисты с Вами свяжутся для ее проведения.\n\nОбращаем Ваше внимание, что идентификацию Кошелька проводит платежная система ООО РНКО «Единая касса». При возникновении трудностей и дополнительных вопросов обращайтесь, пожалуйста, в службу поддержки компании ООО РНКО «Единая касса» по адресу электронной почты support@w1.ru или по номеру телефона 8-495-777-11-25.


    state: StolotoIdentificationForForeigner
        q: * получени* [крупн*/больш*] $prize * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * (крупн*/больш*) $prize * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * {получ* (в [розн*] точк*)} * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * ~второй * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * $identification $stoloto * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: $stoloto || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner

        q: * получени* [крупн*/больш*] $prize * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * (крупн*/больш*) $prize * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * {получ* (в [розн*] точк*)} * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * ~второй * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * $identification $stoloto * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: $stoloto || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/IAmAForeignerICantGetIdentification
        script: Webim.switch();


    state: WhereToPutIdentificationCode
        # Куда вводить код подтверждения идентификации
        q!: * $comWhat $oneWord $code $confirmation $identification *
        q!: * $whatFor $oneWord $code $confirmation $identification *
        q!: $code $confirmation $identification $whatFor (он/они) $comNeed *
        q!: $code $confirmation $identification {это $comWhat}
        q!: * {$insertInf * ($code $confirmation $identification)} *
        q!: [$helloAll] куда {$sendInf ($code $confirmation $identification)}
        q!: * $identification $code $confirmation куда *
        q!: * {$useInf * ($code $confirmation $identification)} *
        q!: * $comWhat $doInfLocal $with ($code $confirmation $identification) *
        q!: * ~анкета * $smsComePast $code $confirmation *
        q!: * {$smsComePast * ($code $confirmation $identification)} *
        q!: * $identification * {$smsComePast * $code} * $comWhat * дальше *
        intent!: /Payments/WhereToPutIdentificationCode
        a: Если Вы заполнили анкету на сайте, то Вам необходимо обратиться в розничную точку с паспортом и данным кодом, чтобы завершить идентификацию. Код необходимо сообщить продавцу розничной точки.


    #################### Оферта #####################################

    state: HowToConfirmTheOffer
        # Как подтвердить оферту
        q!: [$helloAll] ~оферта
        q!: * ~окно $with ~оферта *
        q!: * ($comWhat/то) [это] $oneWord [~договор] ~оферта *
        q!: * {подтвердит* * ~оферта} *
        q!: * {подписат* * ~оферта} *
        q!: * {(принять/принят/вылазиет/вылазит/перекидывает/перебрасывает) * ~оферта} *
        q!: * [$loginInf/$cantLogIn] * {$isWritten * оферту} * [$loginInf/$cantLogIn] *
        q!: * ($loginInf/$cantLogIn) * (оферту/оферты) *
        q!: * {~оферта * $depositInf * [$walletAll] * [$cantPastPresAll]} *

        intent!: /Payments/HowToConfirmTheOffer
        a: Для подтверждения оферты Кошелька пройдите, пожалуйста, по ссылке http://www.stoloto.ru/oferta/accept . Ознакомиться с текстом оферты Вы можете по ссылке https://www.stoloto.ru/wallet_agreement_loto .


    state: ICantConfirmTheOffer
        # Не могу подтвердить оферту
        q!: * {$cantPastPresAll * подтвердит* * ~оферта} *
        q!: * {$cantPastPresAll * ~подтверждение * ~оферта} *
        q!: * {$cantPastPresAll * подписат* * ~оферта} *
        q!: * {$cantPastPresAll * (принять/принят) * ~оферта} *
        q!: * {ошибк* * ~подтверждение * ~оферта} *
        q!: * {подтвердит* * ~оферта} * (завис*/виснет/висит/тормозит/глючит/крутит*/$inactive/{$slowly * (грузит*/загруж*)}) *
        q!: * {~подтверждение * ~оферта} * (завис*/виснет/висит/тормозит/глючит/крутит*/$inactive/{$slowly * (грузит*/загруж*)}) *
        q!: * (завис*/виснет/висит/тормозит/глючит/крутит*/$inactive/{$slowly * (грузит*/загруж*)}) * {~подтверждение * ~оферта} *
        q!: * {подписат* * ~оферта} * (завис*/виснет/висит/тормозит/глючит/крутит*/$inactive/{$slowly * (грузит*/загруж*)}) *
        q!: * ($ne (подтверждает*/подписывает*)/неподтверждает*/ниподтверждает*/неподписывает*/ниподписывает*) * ~оферта *
        q!: * ~оферта * ($ne (подтверждает*/подписывает*)/неподтверждает*/ниподтверждает*/неподписывает*/ниподписывает*) *
        q!: * $slowly * соглашение $with [$oneWord] ~оферта *

        q: * (завис*/виснет/висит/тормозит/глючит/крутит*/$inactive/{$slowly * (грузит*/загруж*)}) * || fromState = /Payments/HowToConfirmTheOffer
        q: * ($ne (подтверждает*/подписывает*)/неподтверждает*/ниподтверждает*/неподписывает*/ниподписывает*) * || fromState = /Payments/HowToConfirmTheOffer
        intent!: /Payments/ICantConfirmTheOffer
        a: Попробуйте, пожалуйста, подтвердить договор оферты на основной версии сайта, перейдя по ссылке https://www.stoloto.ru/oferta/accept .\n\nЧтобы попасть на основную версию сайта, пройдите по ссылке https://www.stoloto.ru/ . Затем внизу экрана нажмите «Основная версия».


    ##################### проблемы с выплатами #####################

    state: WinningsDontShowUp
        # Проблемы с выплатой
        q!: * {~выплата * $bonusComePastPresNe * [$lotteriesWithoutRL]} *
        q!: * {$problem * ~выплата * [$lotteriesWithoutRL]} *
        q!: * {$comNo * ~выплата * [$lotteriesWithoutRL]} *
        q!: * $when $waitInf ~выплата * [$lotteriesWithoutRL] *
        q!: * {$when * (выплатят/выплатите) * [$lotteriesWithoutRL]} *

        intent!: /Payments/WinningsDontShowUp

        script:
            if ($parseTree._lotteriesWithoutRL){
                $temp.thisLotteryName = $injector[$parseTree._lotteriesWithoutRL].lotteryName
            }

        if: $injector.walletPaymentIsAvailable.allPaymentsUnavailable
            a: В настоящий момент могут быть проблемы с выплатой выигрышей по лотереям. Не волнуйтесь, все победители смогут получить выигрыши чуть позже. Наши специалисты уже работают над исправлением ситуации.
        else:
            if: $client.testMode || $global.walletPaymentIsAvailable.isAvailable
                script: Webim.switch();
            else:
                if: $temp.thisLotteryName
                    go!: LotteryNameCatch
                else:
                    a: Какая лотерея Вас интересует?

        state: LotteryNameCatch || fromState = /Payments/WinningsDontShowUp
            q: * $lotteriesWithoutRL *
            script:
                if ($parseTree.value){
                    $temp.thisLotteryName = $injector[$parseTree.value].lotteryName;
                }
                $temp.unavailableLotteries = $injector.walletPaymentIsAvailable.unavailableLotteries;
            if: $injector.walletPaymentIsAvailable.allPaymentsUnavailable
                a: В настоящий момент могут быть проблемы с выплатой выигрышей по лотереям. Не волнуйтесь, все победители смогут получить выигрыши чуть позже. Наши специалисты уже работают над исправлением ситуации.
            else:
                if: Lotteries.isLotteryAvailable($temp.thisLotteryName, $temp.unavailableLotteries)
                    script: Webim.switch();
                else:
                    a: В настоящий момент могут быть проблемы с выплатой выигрышей по лотерее {{ $temp.thisLotteryName }}. Не волнуйтесь, все победители смогут получить выигрыши чуть позже. Наши специалисты уже работают над исправлением ситуации.

        state: RussianLoto || fromState = /Payments/WinningsDontShowUp
            q: * @RL *
            if: $global.paymentsRLIsAvailable
                script: Webim.switch();
            else:
                a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Поэтому для начисления и выплаты выигрышей нам потребуется больше времени. 2 января мы гарантированно будем готовы к выплатам. Спасибо, что проводите эти новогодние праздники вместе с нами! «Столото» желает Вам счастья, радости и, конечно, удачи в наступившем 2020 году!


    state: WinningsDontShowUpRusLoto
        # Проблемы с выплатой (Русское Лото)
        q!: * {~выплата * $bonusComePastPresNe * @RL} *
        q!: * {$problem * ~выплата * @RL} *
        q!: * {$comNo * ~выплата * @RL} *
        q!: * $when $waitInf ~выплата * @RL *
        q!: * {$when * (выплатят/выплатите) * @RL} *
        intent!: /Payments/WinningsDontShowUpRusLoto
        if: $global.paymentsRLIsAvailable
            script: Webim.switch();
        else:
            a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Поэтому для начисления и выплаты выигрышей нам потребуется больше времени. 2 января мы гарантированно будем готовы к выплатам. Спасибо, что проводите эти новогодние праздники вместе с нами! «Столото» желает Вам счастья, радости и, конечно, удачи в наступившем 2020 году!


 ######################################Автовыплаты############################

    state: WhatIsAutopayment
        # Что такое автовыплата
        q!: $autopayment
        q!: * $comWhat $oneWord $autopayment *
        q!: * $whatFor $oneWord $autopayment *
        q!: * $autopayment * ($comWhat это такое) *
        q!: * {$autopayment * ($comWhat * за функция)} *
        q!: * $how (работает/работают) $autopayment *
        q!: * $autopayment $how (работает/работают) *
        intent!: /Payments/WhatIsAutopayment
        a: Функция «Автовыплата» позволяет автоматически переводить выигрыш в Кошелек в рамках установленной Вами суммы до 10 000 рублей. Хотелось бы отметить, что по правилам быстрых лотерей выигрыши до 100 000 рублей всегда автоматически переводятся в Кошелек Столото. Если функция не будет включена, то Вы сможете получить выигрыш как в Кошелек Столото, так и наличными в розничной точке.


    state: HowToDisableAutopayment
        # Как отключить Автовыплату?
        q!: * {$turnOffInf * $autopayment} *
        q!: * {$annulInf * $autopayment} *
        q!: * {$rejectInf * $autopayment} *
        q!: * {$deleteInf * $autopayment} *
        q!: * $dontWant $forTo $prize ($moneyAddPastPres/$transferPastPres/$sendPastPres/поступал*/попадал*) ($toWalletAll/$onBalance) *
        q!: * {$turnOffInf * ~опция * $prize * $toWalletAll} *
        q!: * {$turnOffInf * ~опция * $prize * $onBalance} *
        q!: * $forTo $prizeWithMoney ($ne (переносил*/переходил*/уходил*)/непереносил*/непереходил*/неуходил*/нипереносил*/нипереходил*/ниуходил*) $toWalletAll [после розыгрыша] *

        q!: * $forTo * {$prizeAndSum $smsComePresNe $toWallet автомат*} *
        q!: * $forTo * {$prizeAndSum ($ne попад*) $toWallet автомат*} *

        q!: * $forTo * {$prizeAndSum (непопад*) $toWallet автомат*} *

        q!: * $forTo * {$prizeAndSum $sendPastPresNe $toWallet автомат*} *
        q!: * $forTo * {$prizeWithMoney $getPrizPastPresNe $toWallet автомат*} *
        q!: * $forTo * {$prizeAndSum $moneyAddPastPresNe $toWallet автомат*} *

        q!: * установить лимит [на/для] ($autopayment/$auto ~перевод/((~перевод/~перечисление) $prizeAndSum $toWalletAll)) *
        q!: * $comWhere * (снять/снят/убрать) гал* $with $autopayment *
        q!: * {изменить * $autopayment} *

        # выигрыш автоматически отправляется в кошелек, а хотелось бы на карту
        q!: * автомат* * $toWallet * $butAll $want *
        q!: * [$prizeAndSum] * автомат* * $toWallet * $turnOffInf *
        q!: * $dontWant * $prizeAndSum * автомат* * $toWallet *
        q!: * сразу $toWallet * $turnOffInf *

        intent!: /Payments/HowToDisableAutopayment
        a: Вы можете отключить функцию «Автовыплаты» в личном кабинете в разделе «Кошелек». Вам необходимо будет снять галочку и нажать кнопку «Сохранить». При нажатии на кнопку «Изменить» у Вас есть возможность изменить сумму автовыплат.


    state: AutopaymentDoesntWork
        # Автовыплата не работает
        q!: * {$autopayment * ($workPres3Ne/$transferPastPresNe)} *
        q!: * [$why] * {$prizeAndSum $transferPastPresNe $toWallet автомат*} *
        q!: * [$why] * {$prizeAndSum $smsComePresNe $toWallet автомат*} *
        q!: * [$why] * {$prizeAndSum ($ne попад*) $toWallet автомат*} *
        q!: * [$why] * {$prizeAndSum ($ne попал*) $toWallet автомат*} *
        q!: * [$why] * {$prizeAndSum (непопад*) $toWallet автомат*} *
        q!: * [$why] * {$prizeAndSum (непопал*) $toWallet автомат*} *
        q!: * [$why] * {$prizeAndSum $sendPastPresNe $toWallet автомат*} *
        q!: * [$why] * {$prizeWithMoney $getPrizPastPresNe $toWallet автомат*} *
        q!: * [$why] * {$prizeAndSum $moneyAddPastPresNe $toWallet автомат*} *
        q!: * [$why] * {$prizeAndSum $moneyAddPartPasNe $toWallet автомат*} *
        intent!: /Payments/AutopaymentDoesntWork
        a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона, адрес электронной почты, - а также уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек. Уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер квитанции, который находится над номером тиража. В открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или 10-ти цифр.

        state: GetUserEmailPhoneAndKey || fromState = /Payments/AutopaymentDoesntWork
            q: * {([$mail] $localEmail) * ([$phoneAndNum] $localMobilePhoneNumber) * ([$uniqueKey] $receiptKey)} *
            script: Webim.switch();

        state: GetUserEmailAndPhone || fromState = /Payments/AutopaymentDoesntWork
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$phoneAndNum] $localMobilePhoneNumber} *
            script:
                $session.usrEmail = $parseTree._localEmail;
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.receiptKey
                a: Укажите, пожалуйста, уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек.
            else:
                script: Webim.switch();

        state: GetUserEmailAndKey || fromState = /Payments/AutopaymentDoesntWork
            q: * {([$mail] $localEmail) * ([$uniqueKey] $receiptKey)} *
            script:
                $session.usrEmail = $parseTree._localEmail;
                $session.receiptKey = $parseTree._receiptKey;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneAndKey || fromState = /Payments/AutopaymentDoesntWork
            q: * {([$phoneAndNum] $localMobilePhoneNumber) * ([$uniqueKey] $receiptKey)} *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
                $session.receiptKey = $parseTree._receiptKey;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: GetUserEmail || fromState = /Payments/AutopaymentDoesntWork
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber && !$session.receiptKey
                a: Укажите, пожалуйста, Ваш номер телефона и уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек.
            elseif: $session.usrPhoneNumber && !$session.receiptKey
                a: Укажите, пожалуйста, уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек.
            elseif: !$session.usrPhoneNumber && $session.receiptKey
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Payments/AutopaymentDoesntWork
            q: * [$helloAll] [$comMy] [$phoneAndNum] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail && !$session.receiptKey
                a: Укажите, пожалуйста, Вашу электронную почту и уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек.
            elseif: $session.usrEmail && !$session.receiptKey
                a: Укажите, пожалуйста, уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек.
            elseif: !$session.usrEmail && $session.receiptKey
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: GetKey || fromState = /Payments/AutopaymentDoesntWork
            q: * {[$uniqueKey] * $receiptKey} *
            script:
                $session.receiptKey = $parseTree._receiptKey;
            if: !$session.usrEmail && !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.
            elseif: $session.usrEmail && !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            elseif: !$session.usrEmail && $session.usrPhoneNumber
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();


    state: AutopaymentDoesntWorkRusLoto
        # Автовыплата не работает
        q!: * {$autopayment * ($workPres3Ne/$transferPastPresNe) * @RL} *
        q!: * [$why] * {$prizeAndSum * @RL * $transferPastPresNe * $toWallet * автомат*} *
        q!: * [$why] * {$prizeAndSum * @RL * $smsComePresNe * $toWallet * автомат*} *
        q!: * [$why] * {$prizeAndSum * @RL * ($ne попад*) * $toWallet * автомат*} *
        q!: * [$why] * {$prize * @RL * ($ne попал*) * $toWallet * автомат*} *
        q!: * [$why] * {$prizeAndSum * @RL * (непопад*) * $toWallet * автомат*} *
        q!: * [$why] * {$prizeAndSum * @RL * (непопал*) * $toWallet * автомат*} *
        q!: * [$why] * {$prizeAndSum * @RL * $sendPastPresNe * $toWallet * автомат*} *
        q!: * [$why] * {$prizeWithMoney * @RL * $getPrizPastPresNe * $toWallet * автомат*} *
        q!: * [$why] * {$prizeAndSum * @RL * $moneyAddPastPresNe * $toWallet * автомат*} *
        q!: * [$why] * {$prizeAndSum * @RL * $moneyAddPartPasNe * $toWallet * автомат*} *
        intent!: /Payments/AutopaymentDoesntWorkRusLoto
        if: $global.autopaymentRLIsWorking
            a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона, адрес электронной почты, - а также уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек. Уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер квитанции, который находится над номером тиража. В открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или 10-ти цифр.
        else:
            a: Функционал автовыплат временно не работает. Наши специалисты сейчас заняты восстановлением этого сервиса. Надеемся, он будет доступен в ближайшие дни. Приносим извинения за возникшие неудобства.

        state: GetUserEmailPhoneAndKey || fromState = /Payments/AutopaymentDoesntWorkRusLoto
            q: * {([$mail] $localEmail) * ([$phoneAndNum] $localMobilePhoneNumber) * ([$uniqueKey] $receiptKey)} *
            script: Webim.switch();

        state: GetUserEmailAndPhone || fromState = /Payments/AutopaymentDoesntWorkRusLoto
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$phoneAndNum] $localMobilePhoneNumber} *
            script:
                $session.usrEmail = $parseTree._localEmail;
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.receiptKey
                a: Укажите, пожалуйста, уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек.
            else:
                script: Webim.switch();

        state: GetUserEmailAndKey || fromState = /Payments/AutopaymentDoesntWorkRusLoto
            q: * {([$mail] $localEmail) * ([$uniqueKey] $receiptKey)} *
            script:
                $session.usrEmail = $parseTree._localEmail;
                $session.receiptKey = $parseTree._receiptKey;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneAndKey || fromState = /Payments/AutopaymentDoesntWorkRusLoto
            q: * {([$phoneAndNum] $localMobilePhoneNumber) * ([$uniqueKey] $receiptKey)} *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
                $session.receiptKey = $parseTree._receiptKey;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: GetUserEmail || fromState = /Payments/AutopaymentDoesntWorkRusLoto
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber && !$session.receiptKey
                a: Укажите, пожалуйста, Ваш номер телефона и уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек.
            elseif: $session.usrPhoneNumber && !$session.receiptKey
                a: Укажите, пожалуйста, уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек.
            elseif: !$session.usrPhoneNumber && $session.receiptKey
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Payments/AutopaymentDoesntWorkRusLoto
            q: * [$helloAll] [$comMy] [$phoneAndNum] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail && !$session.receiptKey
                a: Укажите, пожалуйста, Вашу электронную почту и уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек.
            elseif: $session.usrEmail && !$session.receiptKey
                a: Укажите, пожалуйста, уникальный ключ по билету, выигрыш которого не был зачислен в Кошелек.
            elseif: !$session.usrEmail && $session.receiptKey
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: GetKey || fromState = /Payments/AutopaymentDoesntWorkRusLoto
            q: * {[$uniqueKey] * $receiptKey} *
            script:
                $session.receiptKey = $parseTree._receiptKey;
            if: !$session.usrEmail && !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.
            elseif: $session.usrEmail && !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            elseif: !$session.usrEmail && $session.usrPhoneNumber
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();


    state: WhyIsThePrizeAutomaticallySentToWallet
        # Почему выигрыш автоматически отправлен в Кошелек?

        q!: * (до сих пор/все равно) * автомат* * ($transferPres3/$sendPres3/выплачив*/$moneyAddPastPres/идет) * $toWallet *
        q!: * (до сих пор/все равно) * автомат* * $toWallet * ($transferPres3/$sendPres3/выплачив*/$moneyAddPastPres/идет) *
        q!: * (до сих пор/все равно) * ($transferPres3/$sendPres3/выплачив*/$moneyAddPastPres/идет) * $toWallet * автомат* *

        q!: * $why * [$prizeAndSum] * автомат* * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * $toWallet *

        q!: * $why * [$prizeAndSum] * автомат* * $toWallet * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) *

        q!: * $why * [$prizeAndSum] * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * $toWallet * автомат* *

        q!: * $why * [$prizeAndSum] * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * автомат* * $toWallet *

        q!: * [$prizeAndSum] * автомат* * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * $toWallet * $why *

        q!: * [$prizeAndSum] * автомат* * $toWallet * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * $why *

        q!: * [$prizeAndSum] * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * $toWallet * автомат* * $why *

        q!: * [$prizeAndSum] * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * автомат* * $toWallet * $why *

        q!: * [$prizeAndSum] * $withoutMyConsent * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * $toWallet *

        q!: * [$prizeAndSum] * $withoutMyConsent * $toWallet * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) *

        q!: * [$prizeAndSum] * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * $toWallet * $withoutMyConsent *

        q!: * [$prizeAndSum] * $toWallet * ($transferPres3/$transferPast/$transferPartPas/выплатил*/выплачив*/выплачен*/$sendPres3/$sendPastPerf/$sendPartPas/$moneyAddPastPres/$moneyAddPartPas) * $withoutMyConsent *

        q!: * $why * $toWallet * если * $autopayment *
        q!: * $why * {$prizeAndSum * (падает/упал) * $toWallet} *
        q!: * {$prizeAndSum * (падает/упал) * $toWallet} * $why *

        q!: * сама произ* * выплата * $toWallet *
        q!: * $why $withoutMyConsent они туда отправил* *
        q!: * {$why (сработал*/срабатывает) $autopayment} *
        q!: * {$autopayment * $turnOffPresRefl3Ne} *
        q!: * $autopayment * хотя * $turnOffPast *


        q!: * ($autopayment/~функция/~опция) * ($ne стоит/нестоит/нистоит/$turnOffPast/$ne включен*) * {автомат* * ($moneyAddPastPres/$moneyAddPartPas/$sendPres3/$sendPastPerf/$sendPartPas/выплатил*/выплачив*/выплачен*/$transferPres3/$transferPast/$transferPartPas/попадает/попадают) * $toWallet} *

        q!: * ($ne стоит/нестоит/нистоит/$turnOffPast/$ne включен*) * ($autopayment/~функция/~опция) * {автомат* * ($moneyAddPastPres/$moneyAddPartPas/$sendPres3/$sendPastPerf/$sendPartPas/выплатил*/выплачив*/выплачен*/$transferPres3/$transferPast/$transferPartPas/попадает/попадают) * $toWallet} *

        q!: * {автомат* * ($moneyAddPastPres/$moneyAddPartPas/$sendPres3/$sendPastPerf/$sendPartPas/выплатил*/выплачив*/выплачен*/$transferPres3/$transferPast/$transferPartPas/попадает/попадают) * $toWallet} * ($autopayment/~функция/~опция) * ($ne стоит/нестоит/нистоит/$turnOffPast/$ne включен*) *
        q!: * {автомат* * ($moneyAddPastPres/$moneyAddPartPas/$sendPres3/$sendPastPerf/$sendPartPas/выплатил*/выплачив*/выплачен*/$transferPres3/$transferPast/$transferPartPas/попадает/попадают) * $toWallet} * ($ne стоит/нестоит/нистоит/$turnOffPast/$ne включен*) * ($autopayment/~функция/~опция) *

        q!: * {($autopayment/~функция/~опция) * ($ne стоит/нестоит/нистоит/$turnOffPast/$ne включен*)} * $why * $toWallet *
        q!: * $why * $toWallet * {($autopayment/~функция/~опция) * ($ne стоит/нестоит/нистоит/$turnOffPast/$ne включен*)} *

        q!: * {автомат* * ($moneyAddPastPres/$moneyAddPartPas/$sendPres3/$sendPastPerf/$sendPartPas/выплатил*/выплачив*/выплачен*/$transferPres3/$transferPast/$transferPartPas/попадает/попадают) * $toWallet} * в настройках * $comNo *

        q!: * {автомат* * ($moneyAddPastPres/$moneyAddPartPas/$sendPres3/$sendPastPerf/$sendPartPas/выплатил*/выплачив*/выплачен*/$transferPres3/$transferPast/$transferPartPas/попадает/попадают) * $toWallet} * убрать *

        q!: * $why * автомат* * (переключат*/ползунок) *

        intent!: /Payments/WhyIsThePrizeAutomaticallySentToWallet
        a: Уточните, пожалуйста, название лотереи.

        state: FastLotteries
            q: * $fastLotteries *
            a: Согласно правилам, выигрыши по быстрым лотереям переводятся в Кошелек Столото автоматически.

        state: NotFastLotteries
            q: * $notFastLotteries *
            a: Уточните, пожалуйста, уникальный ключ квитанции. Уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр.

            state: GetNumber || fromState = /Payments/WhyIsThePrizeAutomaticallySentToWallet/NotFastLotteries
                q: * {[$uniqueKey] * $receiptKey} *
                script: Webim.switch();


############################################################################

    state: HowToFindOutTotalWinnings
        # Как узнать общую сумму выигрышей
        q!: * {($findOutInf/$findInf) * (~общий ~сумма [все*] $prizeAndSum)} *
        q!: * {$comNeed * (~общий ~сумма [все*] $prizeAndSum)} *
        q!: * {$getPrizInf * $referenceNDFL} *
        intent!: /Payments/HowToFindOutTotalWinnings
        script: Webim.switch();


###########################################################################

    state: Tax
        # Налог
        q!: * (~налог/налогообложен*/налого обложен*/~налоговый) *
        q!: * {[$how] * [$payInf] * ~налог} *
        q!: * ~какой (~процент/%/~размер) ндфл *
        q!: * $skolko * ндфл *
        q!: * {ндфл * $win} *
        intent!: /Payments/Tax
        if: checkIfCurrentDateIsBefore("2021-01-01")
            a: Налог на доход физических лиц начисляется с любой суммы выигрыша.\n\nВ случае, когда сумма выигрыша не превышает 15 000 рублей, налог необходимо оплачивать самостоятельно в налоговом органе по месту жительства. Налогоплательщики обязаны самостоятельно исчислить суммы налога исходя из полученных сумм выигрышей по ставке, установленной пунктом 1 статьи 224 Налогового кодекса РФ, и представить в налоговый орган по месту своего учета налоговую декларацию по налогу на доходы физических лиц не позднее 30 апреля года, следующего за истекшим налоговым периодом, согласно статье 229, пункт 1. Согласно статье 228, пункт 4, НК РФ, суммы налога, подлежащие уплате в соответствующий бюджет, исчисленные исходя из налоговой декларации, уплачиваются по месту жительства налогоплательщиков в срок не позднее 15 июля года, следующего за истекшим налоговым периодом.\n\nВ ситуации, когда сумма выигрыша превышает 15 000 рублей, победителю нет необходимости оплачивать налог самостоятельно. Согласно изменениям, внесенным в Налоговый кодекс РФ федеральным законом от 27.11.2017 г. № 354-ФЗ при выплате выигрышей в размере от 15 000 рублей удерживается налог в размере 13% с резидентов РФ.\n\nПодробная информация - по ссылке https://www.stoloto.ru/about/tax?int=faq
        else:
            a: Налог на доход физических лиц начисляется с любой суммы выигрыша.\n\nВ случае, когда сумма выигрыша не превышает 15 000 рублей, налог необходимо оплачивать самостоятельно в налоговом органе по месту жительства. Налогоплательщики обязаны самостоятельно исчислить суммы налога исходя из полученных сумм выигрышей по ставке, установленной пунктом 1 статьи 224 Налогового кодекса РФ, и представить в налоговый орган по месту своего учета налоговую декларацию по налогу на доходы физических лиц не позднее 30 апреля года, следующего за истекшим налоговым периодом, согласно статье 229, пункт 1. Согласно статье 228, пункт 4, НК РФ, суммы налога, подлежащие уплате в соответствующий бюджет, исчисленные исходя из налоговой декларации, уплачиваются по месту жительства налогоплательщиков в срок не позднее 15 июля года, следующего за истекшим налоговым периодом.\n\nВ ситуации, когда сумма выигрыша превышает 15 000 рублей, победителю нет необходимости оплачивать налог самостоятельно. Согласно изменениям, внесенным в Налоговый кодекс РФ федеральным законом от 27.11.2017 г. № 354-ФЗ при выплате выигрышей в размере от 15 000 рублей удерживается налог в размере 13% с резидентов РФ с суммы выигрышей до 5 000 000 руб. (включительно), а с суммы превышения 5 000 000 руб. по всем выигрышам за налоговый период - 15%.