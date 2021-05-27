theme: /Lottery

#################################код выигрыша##########################

    state: IfIWinHowWillIKnow
        # Как я узнаю о выигрыше?
        q!: * $ifAll * ($winPastPerf/$winFutSg13) * {($how/я) * узнаю} *
        q!: * {($how/я) * узнаю} * $if * $winFutSg13 *
        q!: * {$ticket выигрышный} * {($how/я) * узнаю} *
        q!: * {$how * узнаю * $prize} *

        q!: * $ifAll * ($winPastPerf/$winFutSg13/$prize) * {вы * (сообщите/оповестите)} *
        q!: * $ifAll * ($winPastPerf/$winFutSg13/$prize) * {(мне/меня) * (сообщат/оповестят)} *
        q!: * $ifAll * ($winPastPerf/$winFutSg13/$prize) * {$bonusComeFut * $notification} *
        q!: * ($how/вы) * (сообщаете/оповещаете) * $prize *
        q!: * (вы/мне) * (сообщите/сообщат/оповестите) * $prize *
        q!: * меня * оповестят * $prize *

        q!: * $ifAll * ($winPastPerf/$winFutSg13/$prize) * {$smsComeFut * $sms} *
        q!: * {(пришлете/присылаете) * $sms * ((в случае/при) $prize)} *
        q!: * {$smsComeFut * $sms * ((в случае/при) $prize)} *
        q!: * {$smsComePres * $sms * ((в случае/при) $prize)} *

        q!: * должн* * {(приходить/прийти/придти) * $sms} * ((в случае/при) $prize) *
        q!: * должн* * ((в случае/при) $prize) * {(приходить/прийти/придти) * $sms} *

        q!: * {(($smsComePres/$smsComeFut/присылаете/пришлете/присылают/пришлют/скидываете/скинете/скидывают/скинут) $li) * ~оповещение * ((в случае/при/о) $prize)} *
        q!: * {(($smsComePres/$smsComeFut/присылаете/пришлете/присылают/пришлют/скидываете/скинете/скидывают/скинут) $li) * ~оповещение * ($ifAll * ($winPastPerf/$winFutSg13))} *

        q!: * {((оповещаете/оповещают/оповестите/оповестят) $li) * ((в случае/при/о) $prize)} *
        q!: * {((оповещаете/оповещают/оповестите/оповестят) $li) * ($ifAll * ($winPastPerf/$winFutSg13))} *

        intent!: /Lottery/IfIWinHowWillIKnow
        a: Уточните, пожалуйста, где Вы приобретали билет, при покупке билета Вы указывали номер телефона?

        state: GetAnswer
            event: noMatch
            script: Webim.switch();


    state: ReceiveWinningCode
        # Не пришло сообщение с кодом выигрыша
        q!: {$win [для] [~получение] $code}
        q!: * {$winCode ($writeDownPastNe/$bePastNe/интересу*)} *

        q!: * {$comNeed * [~получение] * $win * $code} *
        q!: * {$comNeed * $code * $getPrizInf * $prize} *

        q!: * {$givePastPresPl3Ne * $prizeWithMoney} * {$askPresPl3 * $code} *
        q!: * {$askPresPl3 * $code} * {$givePastPresPl3Ne * $prizeWithMoney} *
        q!: * {$askPresPl3 * $winCode} *

        q!: * {$smsComePastPresNe * $code * $cashoutInf} *
        q!: * {$bePastNe * $code * $cashoutInf} *

        q!: * [$win] * [$ticket] * [$win] * {$smsComePastPresNe * $code * $win} *
        q!: * [$win] * [$ticket] * [$win] * {$smsComePastPresNe * $code * $prize} *

        q!: * {$smsComePastPresNe * ($winCode/$smsWithWinCode)} * [получить] *

        q!: * {$smsComePastPresNe * ($winCode/$smsWithWinCode) * $onTelephone} *

        q!: * {$smsComePastPresNe $code} $with $ticketRun *

        q!: * {$findPastPresNe * $code * $cashoutInf} *
        q!: * {$findPastPresNe * $code * $win} *
        q!: * {$findPastPresNe * ($winCode/$smsWithWinCode)} *

        q!: * {$sendPartPasNe * $code * $win} *
        q!: * {$sendPartPasNe * ($winCode/$smsWithWinCode)} *

        q!: * {$lostPast * $code * $cashoutInf} *
        q!: * {$lostPast * ($winCode/$smsWithWinCode)} *
        q!: * {$lostPast * $code * ($win [$ticket])} * [$how] * [$receiveInf] *
        q!: * {$lostPast * $code * ($ticket $win)} *
        q!: * $winPastPerf * $ticket * [$sms] * {$lostPast * $code} *

        q!: * {($lostPast/стер*) * $sms * ($win [$ticket])} * [$how] * [$receiveInf] *


        q!: * $comWhat * $doInfLocal * {$lostPast * $code * $win} *
        q!: * {$lostPast * $code * $win} * $comWhat * $doInfLocal *

        q!: * $getPrizeWithoutMoney * {($lostPast/удален) * $code} *
        q!: * {($lostPast/удален) * $code} * $getPrizeWithoutMoney *

        q!: * {$stopped * ($smsComeInf/идти) * $winCode} *
        q!: * {$stopped * ($smsComeInf/идти) * $smsWithWinCode} *


        q!: * {$sendMeImp * $code * $cashoutInf} *
        q!: * {$sendMeImp * $code * ($win [$ticket])} *
        q!: * {$sendMeImp * ($winCode/$smsWithWinCode)} *

        q!: * {$askYouAll * $sendMeInfPerf * ($winCode/$smsWithWinCode)} *

        q!: * {$duplicateInfPerf * $code * $cashoutInf} *
        q!: * {$duplicateInfPerf * $code * ($win [$ticket])} *
        q!: * {[$askYouAll] * $duplicateInfPerf * ($winCode/$smsWithWinCode)} *

        # Как получить код выигрыша?
        q!: * [$how/$cantPastPresAll] * ($receiveInf/$sendInf) * ($code/$sms) * $win * [$ticket] * [$telephone/$telephoneNumber] * [$cantPastPresAll] *
        q!: * [$how] * ($receiveInf/$sendInf) * ($code/$sms) * ($telephone/$telephoneNumber) * ($win [$ticket]) *
        q!: * $findInf * ($code/$sms) * ($win [$ticket]) *
        q!: * [$how] * узнать * ($code/$sms) * ($win [$ticket]) *

        q!: * {$comWhere * ($win [$ticket]) * $code} *
        q!: * $comWhere * {$findInf * ($win [$ticket]) * $code} *
        q!: * {$comWhere * ($winCode/$smsWithWinCode)} *
        q!: * {$comWhere * $win * $notification} *

        q!: * {($possiblePredic повторно) * ($win [$ticket]) * $code} *

        q!: * {$resetInfAll * ([$sms] * $code) * $win} *
        q!: * {$resetImpAll * ([$sms] * $code) * $win} *
        q!: * {$resetNoun * ([$sms] * $code) * $win} *
        q!: * {заказать * $code * $win} *
        q!: * {$askInf * $code * $win} *
        q!: * (сообщите/мож* * сообщить/укажите/обещали) * $code $win *

        q!: * {$win * $comNo * $notification} *
        q!: * {$win * $bePastNe * $notification} *
        q!: * {$win * $comNo * ($sms * [$code])} *
        q!: * {$win * $bePastNe * ($sms * [$code])} *
        q!: * {$win * $comNo * $code} *
        q!: * {$win * $bePastNe * $code} *

        q!: * {$sendPastPresNe * $sms * [$code] * $win} *
        q!: * {$sendPastPresNe * $code * $win} *
        q!: * {$sendPastPresNe * $notification * $win} *

        q!: * {$requirePastPres * $code * $comWhere * $receiveInf} *
        q!: * {$forgetPastPres $code ($win [$ticket])} *

        q!: * {$code $win $comNeed (на $postOffice)} *

        # Когда высылается код выигрыша?
        q!: * {$sms * $prize * $sendPres3} *
        q!: * {$notification * $prize * $sendPres3} *
        q!: * {$code * $prize * $sendPres3} *
        q!: * {($when * $smsComePres) * $sms * $win} *
        q!: * {((в ~какой ~случай) * $smsComePres) * $sms * $win} *
        q!: * {((всегда [ли]) * $smsComePres) * $sms * $win} *
        q!: * {($when * $smsComePres) * $notification * $win} *
        q!: * {((в ~какой ~случай) * $smsComePres) * $notification * $win} *
        q!: * {((всегда [ли]) * $smsComePres) * $notification * $win} *
        q!: * {($when * $smsComePres) * $code * $win} *
        q!: * {((в ~какой ~случай) * $smsComePres) * $code * $win} *
        q!: * {((всегда [ли]) * $smsComePres) * $code * $win} *

        q!: * {((~какой/~любой) $prize) * $smsComePres * $sms} *
        q!: * {((~какой/~любой) $prize) * $smsComePres * $notification} *
        q!: * {((~какой/~любой) $prize) * $smsComePres * $code} *

        q!: * {($if [есть] $prize) * $sendPresPl2Ne * $sms} *
        q!: * {($if [есть] $prize) * $sendPresPl2Ne * $code} *
        q!: * {($if [есть] $prize) * $sendPresPl2Ne * $notification} *

        q!: * {($if (($ticket/я) $win/$win ($ticket/я))) * $sendPresPl2Ne * $sms} *
        q!: * {($if (($ticket/я) $win/$win ($ticket/я))) * $sendPresPl2Ne * $code} *
        q!: * {($if (($ticket/я) $win/$win ($ticket/я))) * $sendPresPl2Ne * $notification} *

        q!: * {($if (($ticket/я) $win/$win ($ticket/я))) * $sendPres3 * $sms} *
        q!: * {($if (($ticket/я) $win/$win ($ticket/я))) * $sendPres3 * $code} *
        q!: * {($if (($ticket/я) $win/$win ($ticket/я))) * $sendPres3 * $notification} *

        q!: * {$enableInfImp * $notification * $prize} *
        q!: {$localMobilePhoneNumber $localEmail} $code $win
        q!: $code $win {$localMobilePhoneNumber $localEmail}

        q!: * {$givePastPresPl3Ne * $prize * $retailPointOfSale} * $requirePastPres * $code *
        q!: * {$givePastPresPl3Ne * $prize} * ($lostPast * $code/$code * $lostPast) *
        q!: * ($lostPast * $code/$code * $lostPast) * {$givePastPresPl3Ne * $prize} *

        q!: * $forTo ($sendPastPerf/$transferPast/приходил*) [$again] $code $win *
        intent!: /Lottery/ReceiveWinningCode
        if: $global.winningCodeIsAvailable
            a: Коды выигрышей по билетам, приобретенным на сайте или в мобильном приложении, с суммой выигрыша менее 15 000 рублей автоматически не отправляются. Приобретая билет на сайте или в мобильном приложении, Вы можете получать выигрыши в Кошелек Столото, для этого код выигрыша не требуется. Если Вы желаете получить выигрыш в розничной точке, то Вы можете запросить код самостоятельно, отправив sms-запрос с номера телефона, указанного при оформлении билета, на номер 9999 со словом «все» без кавычек. Вам придут коды всех невыплаченных выигрышей.
        else:
            a: Спасибо, что сообщили о задержке отправки СМС-сообщений. Мы уже работаем над возобновлением корректной работы системы рассылок.


    state: GaveTicketReceiveWinningCode
        # Добрый день, Подарили билет Русского лото, билет выиграл. Но у меня нет кода, как его получить?
        q!: * {$giftPast * $ticketAll * $code * [$win]} *
        q!: * {$giftPast * $ticketAll * $receiveInf * $code} *
        intent!: /Lottery/GaveTicketReceiveWinningCode
        script: Webim.switch();


#########################уникальный ключ################################

    state: WhatIsUniqueKey || noContext = true
        # Что такое уникальный ключ
        # Зачем нужен уникальный ключ
        q!: * $comWhat ($oneWord/значит/значат/означает/означают) [слово] [в/на] [$receipt] [$numeral] $uniqueKey *
        q!: * $whatFor $oneWord [этот] $uniqueKey *
        q!: * (~какой ~цель) [$oneWord] $uniqueKey *
        q!: $uniqueKey $whatFor он $comNeed *
        q!: * $uniqueKey {это $comWhat} [значит/означает/такое]
        q!: {[$beginningWords] [в чем] [заключа*] смысл $uniqueKey}
        intent!: /Lottery/WhatIsUniqueKey
        a: Уникальный ключ квитанции - это индивидуальный код идентификации квитанции в системе. В комплекте с номером квитанции он служит свидетельством того, что билет действительно оформлен. Именно поэтому он необходим при получении выигрыша, а также потребуется, если с квитанцией возникла сложность.


    state: HowToFindOutAUniqueKey
        # Как узнать уникальный ключ?
        q!: * ($receiveInf/уточнить) [$again/еще раз] $uniqueKey *
        q!: * {($comWhere [именно]) $receiveInf $uniqueKey} *
        q!: * {($how [именно]) $receiveInf $uniqueKey} *
        q!: * {помог* $receiveInf $uniqueKey} *
        q!: * {$want $receiveInf $uniqueKey} *
        q!: * {$fromWhere $receiveInf $uniqueKey} *
        q!: * {$cantPastPresAll $receiveInf $uniqueKey} *
        q!: * {($comWhere [именно]) [я] [могу] $seeInf $uniqueKey} *
        q!: * {($comWhere [именно]) (написан*/наход*) [дан*/эт*] $uniqueKey} *
        q!: * {($comWhere [именно]) этот $uniqueKey} *
        q!: * {посмотреть этот $uniqueKey} *
        q!: * {($how [именно]) $seeInf $uniqueKey} *
        q!: * {$lostPast $uniqueKey} *
        q!: * [$prizeAll] * ($comNeed [получит*] [~какой то/~какой-то]/~запрос/~получение) $uniqueKey *
        q!: * (сказал*/говорит/говорят) * $uniqueKey [~какой то/~какой-то] $comNeed *
        q!: * {$findOutInf * $uniqueKey} *
        q!: * {$findInf * $uniqueKey} *
        q!: * {$findPastPresNe * $uniqueKey} *
        q!: * {$askPresPl3 * $uniqueKey} *
        q!: * {вышлите * $uniqueKey} *
        q!: * {$receivePastNe $uniqueKey} *
        q!: * {$writtenNe $uniqueKey} *
        q!: * {$requirePastPres * $uniqueKey} *
        q!: * {$askYouAll * $sendMeInfPerf * $uniqueKey} *
        q!: * {$askYouAll * $duplicateInfPerf * $uniqueKey} *
        q!: * {$resetInfAll * $uniqueKey} *
        q!: * [$prizeAll] * {$comNo [у меня] [~такой] $uniqueKey} *
        q!: * {$smsComePastPerfNe $uniqueKey} *
        q!: [$helloAll] [$beginningWords] {$possiblePredic $uniqueKey}

        q: * $comWhere * расположен * || fromState = /Payments/CantWithdrawMoneyToPurse

        q: * $comWhere * расположен * || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: * $comWhere * расположен * || fromState = /Payments/WhyIsThePrizeAutomaticallySentToWallet/NotFastLotteries

        intent!: /Lottery/HowToFindOutAUniqueKey
        a: Уточните, пожалуйста, Вы приобретали билет в розничных точках продаж или через сайт?

        state: IBoughtInRetailPointOfSale || fromState = /Lottery/HowToFindOutAUniqueKey
            q: * $retailPointOfSale *
            q: * на руках *
            q: * $geography *
            q: * ~купон *
            q!: * {(на купон*) * $uniqueKey} *
            q!: * {стерс* * $uniqueKey} *
            q!: * {$retailPointOfSale * [$receipt] * $uniqueKey} *
            q!: * {$lostPast * $receipt * $uniqueKey} *
            q!: * {$findInf * $receipt * $uniqueKey} *
            q!: * {$findOutInf * $receipt * $uniqueKey} *
            q!: * {$findPastPresNe * $receipt * $uniqueKey} *
            q!: * {$resetInfAll * $receipt * $uniqueKey} *
            q!: * {($ne взял*) * $receipt * $uniqueKey} *
            q!: * {выкинул* * $receipt * $uniqueKey * [$receiveInf]} *
            q!: * {$comNo * $receipt * $uniqueKey} *
            q!: * {$askPresPl3 * $uniqueKey * $receipt} *
            q!: * {$requirePastPres * $uniqueKey * $receipt} *
            q!: * {($cantPastPres найти $receipt) * $uniqueKey} *
            q!: * $comWhere * $uniqueKey * $notETicket *
            a: Если Вы приобретали билет в розничных точках продаж и указывали номер телефона, уникальный ключ Вы можете посмотреть на черно-белой квитанции, которую Вам выдали при покупке билета. Если у Вас не сохранилась квитанция, Вы можете зарегистрироваться с этим номером телефона на сайте. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты». Уникальный ключ можно посмотреть здесь же, открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр.\n\nИнструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в Личном кабинете, напишите нам, пожалуйста.

        state: IBoughtInInternet || fromState = /Lottery/HowToFindOutAUniqueKey
            q: [$website] $account
            q: * (на/через/черес/в/(с/при) ~помощь) [$this/ваш*] ($website/$account/[$application] $stoloto/~интернет/$application/~программа/комп/~компьютер/моб* ~версия) *
            q: (электроно/электронно/по электронке/электронный/$eTicket)
            q: * по (~интернет/телефону) *
            q: * (по/через/черес) $sms *
            q: * (черезсайт/черезъсайт/черезьсайт/у вас/увас) *
            q: ({($website/$application) [$stoloto]}/[$stoloto] ~интернет)
            q: * $here *
            q: * $online *
            q!: * {$eTicket * $uniqueKey} *
            q!: * {((по/через/черес) $sms) * $uniqueKey} *
            q!: * {$buyPastPres * $online * $uniqueKey} *
            q!: * {$buyN * $online * $uniqueKey} *
            q!: * {$buyPastPres * $website * $uniqueKey} *
            q!: * {$buyPastPres * $application * $uniqueKey} *
            q!: * {$buyPastPres * ~интернет * $uniqueKey} *
            q!: * {$paid * $online * $uniqueKey} *
            q!: * {$resetInfAll * $uniqueKey * $eTicket} *
            a: Если Вы приобретали билет через сайт, уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр. Если Вы приобретали билет через сайт, но у Вас еще нет регистрации, зарегистрируйтесь, пожалуйста, на сайте с номером телефона, указанным при покупке билета. Билет и вся информация о нем отобразятся в личном кабинете в разделе «Мои билеты».\n\nИнструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в Личном кабинете, напишите нам, пожалуйста.


    state: WhereToWriteUniqueKey
        # Куда писать уникальный ключ

        q!: * $comWhat [мне] [далее] [$comNeed] {*делать (($with/в) [этим/$numeral] $uniqueKey)} *
        q!: {(нашл*/нашел*/нашол*/есть/увидел*) [эт*] $uniqueKey}
        q!: * {(нашл*/нашел*/нашол*/есть/увидел*) [эт*] $uniqueKey} * ($comWhat/дальше) *
        q!: * (куд*/сюда/$here) * $insertInf [эт*] $uniqueKey *
        q!: * $uniqueKey (куд*/сюда/$here) $insertInf *
        q!: * {(куд*/сюда/$here/кому/вам) ([$comNeed] (писать/написать/передать/назвать/скинуть/предоставить/сообщить)) ([эт*] $uniqueKey)} *
        q!: * {([прям*] (сюда/$here/вам)) * (писать/написать/передать/назвать/скинуть/предоставить/сообщить) * ([эт*] $uniqueKey)} *

        q!: * {$uniqueKey * вам * предоставить} *

        q!: вам $comNeed [эт*] $uniqueKey
        q!: * $comNeed * (написать/скинуть) * $uniqueKey *
        q!: * в какое (окно/поле) * $uniqueKey *
        q!: * $comYes есть $uniqueKey *
        q!: * {$uniqueKey вижу} *
        q!: * $comWhat * $givePastPres * $uniqueKey *


        q: * (куд*/сюда/$here/вам) * (писать/написать/$sendMeInfPerf/$sendInf/предоставить) * || fromState = /Payments/CantWithdrawMoneyToPurse
        q: * (писать/написать/$sendMeInfPerf/$sendInf/предоставить) * (куд*/сюда/$here/вам) *|| fromState = /Payments/CantWithdrawMoneyToPurse
        q: * (сюда/вам) * сообщить * || fromState = /Payments/CantWithdrawMoneyToPurse
        q: * что $with ним делать * || fromState = /Payments/CantWithdrawMoneyToPurse
        q: * {$findPastPres * ключ*} * || fromState = /Payments/CantWithdrawMoneyToPurse
        q: есть такой || fromState = /Payments/CantWithdrawMoneyToPurse
        q: * $comWhat [$meDat] (дает/даст) * ($uniqueKey/инф*) * || fromState = /Payments/CantWithdrawMoneyToPurse

        q: * (куд*/сюда/$here/вам) * (писать/написать/$sendMeInfPerf/$sendInf/предоставить) * || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: * (писать/написать/$sendMeInfPerf/$sendInf/предоставить) * (куд*/сюда/$here/вам) *|| fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: * (сюда/вам) * сообщить * || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: * что $with ним делать * || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: * {$findPastPres * ключ*} * || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: есть такой || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: * $comWhat [$meDat] (дает/даст) * ($uniqueKey/инф*) * || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin

        q: * (куд*/сюда/$here/вам) * (писать/написать/$sendMeInfPerf/$sendInf/предоставить) * || fromState = /Payments/WhyIsThePrizeAutomaticallySentToWallet/NotFastLotteries
        q: * (писать/написать/$sendMeInfPerf/$sendInf/предоставить) * (куд*/сюда/$here/вам) *|| fromState = /Payments/WhyIsThePrizeAutomaticallySentToWallet/NotFastLotteries
        q: * (сюда/вам) * сообщить * || fromState = /Payments/WhyIsThePrizeAutomaticallySentToWallet/NotFastLotteries
        q: * что $with ним делать * || fromState = /Payments/WhyIsThePrizeAutomaticallySentToWallet/NotFastLotteries
        q: * {$findPastPres * ключ*} * || fromState = /Payments/WhyIsThePrizeAutomaticallySentToWallet/NotFastLotteries
        q: есть такой || fromState = /Payments/WhyIsThePrizeAutomaticallySentToWallet/NotFastLotteries
        q: * $comWhat [$meDat] (дает/даст) * ($uniqueKey/инф*) * || fromState = /Payments/WhyIsThePrizeAutomaticallySentToWallet/NotFastLotteries

        a: Напишите, пожалуйста, уникальный ключ в ответном сообщении в данном чате.

        state: GetNumber || fromState = /Lottery/WhereToWriteUniqueKey
            q: * {[$uniqueKey] * $receiptKey} *
            script: Webim.switch();


    state: UniqueKeyWithoutContext
        q!: [$helloAll] {$uniqueKey $receiptKey}
        q!: [$helloAll] $receiptKey (вот/это/его/ее) $uniqueKey
        q!: [$helloAll] $uniqueKey $receiptKey и $receiptKey
        q!: * вот $uniqueKey * $receiptKey *
        script: Webim.switch();


###########################################################################


    state: DidntRecieveCodeOrSMS
        # Когда придет сообщение не могу авторизоваться (не пришло сообщение, но не о коде выигрыша)
        q!: * {$smsComePastPresNe * $sms * $loginInf} *
        q!: * {$smsComePastPresNe * $sms * $authorization} *
        q!: * {($comNo/пропал/отсутс*) * $mail * $sendMeImp * $sms} *
        q!: * {($comNo/пропал/отсутс*) * $mail * $askYouAll * ($sendMeInfPerf/$duplicateInfPerf) * $sms} *
        q!: * {$when * $smsComeFut * $sms * $cantPastPres} *
        q!: * {$when * $smsComeFut * $sms * $cantPastPres * $loginInf} *
        q!: * {$when * $smsComeFut * $sms * $cantPastPres * $authorization} *
        q!: * $cantLogIn * {$smsComePastPresNe * $sms} *
        q!: * $cantLogIn * {$when * $smsComeFut * $sms} *
        intent!: /Lottery/DidntRecieveCodeOrSMS
        a: Если смс не поступило, сообщите, пожалуйста, данные, по которым проводили регистрацию: email и номер телефона.

        state: GetUserData || fromState = /Lottery/DidntRecieveCodeOrSMS
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            q!: * {$smsComePastPresNe * $sms * $loginInf * $localEmail * $localMobilePhoneNumber} *
            q!: * {$smsComePastPresNe * $sms * $authorization * $localEmail * $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Lottery/DidntRecieveCodeOrSMS
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            q!: * {$smsComePastPresNe * $sms * $loginInf * $localEmail} *
            q!: * {$smsComePastPresNe * $sms * $authorization * $localEmail} *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Lottery/DidntRecieveCodeOrSMS
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            q!: * {$smsComePastPresNe * $sms * $loginInf * $localMobilePhoneNumber} *
            q!: * {$smsComePastPresNe * $sms * $authorization * $localMobilePhoneNumber} *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: LocalCatchAll || fromState = /Lottery/DidntRecieveCodeOrSMS
            event: noMatch
            script: Webim.switch();


    state: WhereToFindResults
        # Где посмотреть результаты
        q!: $result ~розыгрыш
        q!: * {$wrong * $ticketRun} *
        q!: * {$why $comNo $result} *
        q!: * {$when * [$seeInf] * $result} *
        q!: * {$comWhere * [$seeInf] * $result} *
        q!: * $how $seeInf $result *
        q!: * {$tellImp * $result * $ticketRun} *
        q!: * есть $li $result ($lottery/$ticketRun) *

        # где посмотреть результаты новогоднего тиража
        q!: $result ~розыгрыш $newYear
        q!: * {$why $comNo $result} * $newYear *
        q!: * $newYear * {$why $comNo $result} *
        q!: * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} *
        q!: * {($seeInf/$tellImp) * $result * $newYear} *
        q!: * {($how $seeInf $result) * $newYear} *
        q!: * {$tellImp * $result * ($newYear $ticketRun)} *
        q!: * {(есть $li $result) * $newYear} *
        q!: * есть $li $result $newYear ($lottery/$ticketRun) *

        # где посмотреть результаты новогодних тиражей
        q!: $result $newYearTicketRuns
        q!: * {$why $comNo $result} * $newYearTicketRuns *
        q!: * $newYearTicketRuns * {$why $comNo $result} *
        q!: * {(($when/$comWhere) * [$seeInf]) * $result * $newYearTicketRuns} *
        q!: * {($seeInf/$tellImp) * $result * $newYearTicketRuns} *
        q!: * {($how $seeInf $result) * $newYearTicketRuns} *
        q!: * {$tellImp * $result * $newYearTicketRuns} *
        q!: * {(есть $li $result) * $newYearTicketRuns} *

        intent!: /Lottery/WhereToFindResults

        #if: Lotteries.allLotteriesAvailable($injector)
        #    if: Time.sundayTimeIsGood()
        #        if: $session.lastLottery
        #            script: $reactions.transition(Lotteries.getTargetLotteryPath($session))
        #        else:
        #            a: Какая лотерея Вас интересует?
        #    else:
        #        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
        #else:
        #    if: $session.lastLottery
        #        script: $reactions.transition(Lotteries.getTargetLotteryPath($session))
        #    else:
        #        a: Какая лотерея Вас интересует?



        if: Lotteries.allLotteriesAvailable($injector)
            if: $parseTree._newYearTicketRuns
                if: checkIfCurrentDateIsBefore("2021-01-01 10:30")
                    a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотая подкова», «Бинго-75» на сайте будут доступны 01.01.2021 после 10:30, результаты тиража 1369 «Русского лото» будут опубликованы после 18:00 мск.
                else:
                    a: Какая лотерея Вас интересует?

            elseif: $parseTree._newYear
                a: Какая лотерея Вас интересует?
                script:
                    $session.newYear = true;

            else:
                if: Time.sundayTimeIsGood()
                    if: $session.lastLottery
                        script: $reactions.transition(Lotteries.getTargetLotteryPath($session))
                    else:
                        a: Какая лотерея Вас интересует?
                else:
                    a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
        else:
            if: $session.lastLottery
                script: $reactions.transition(Lotteries.getTargetLotteryPath($session))
            else:
                a: Какая лотерея Вас интересует?



        state: RussianLoto
            q!: {$result ~розыгрыш $russianLoto}
            q!: * {$wrong * $ticketRun * $russianLoto} *
            q!: * {$why $comNo $result ([по] $russianLoto)} *
            q!: * {$when * [$seeInf] * $result * $russianLoto} *
            q!: * {$comWhere * [$seeInf] * $result * $russianLoto} *
            q!: * {($how $seeInf $result) * $russianLoto} *
            q!: * {$tellImp * $result * $ticketRun * $russianLoto} *
            q!: * есть ли $result [$lottery/$ticketRun] $russianLoto *

            q: * $russianLoto *
            q: * $1369 *

            # где посмотреть результаты новогоднего тиража РЛ
            q!: {($result ~розыгрыш $newYear) $russianLoto}
            q!: * {$why $comNo $result} * $newYear * $russianLoto *
            q!: * $russianLoto * {$why $comNo $result} * $newYear *
            q!: * $newYear * $russianLoto * {$why $comNo $result} *
            q!: * $newYear * {$why $comNo $result} * $russianLoto *
            q!: * $russianLoto * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} *
            q!: * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} * $russianLoto *
            q!: * $russianLoto * {($seeInf/$tellImp) * $result * $newYear} *
            q!: * {($seeInf/$tellImp) * $result * $newYear} * $russianLoto *
            q!: * {($how $seeInf $result) * $newYear * $russianLoto} *
            q!: * $russianLoto * {$tellImp * $result * ($newYear $ticketRun)} *
            q!: * {$tellImp * $result * ($newYear $ticketRun)} * $russianLoto *
            q!: * {(есть $li $result) * $newYear * $russianLoto} *
            q!: * $russianLoto * есть $li $result $newYear ($lottery/$ticketRun) *
            q!: * есть $li $result $newYear ($lottery/$ticketRun) * $russianLoto *

            # где посмотреть результаты 1369 тиража
            q!: ($result ~розыгрыш $1369)
            q!: * {$why $comNo $result} * $1369 *
            q!: * $1369 * {$why $comNo $result} *
            q!: * {(($when/$comWhere) * [$seeInf]) * $result * $1369} *
            q!: * {($seeInf/$tellImp) * $result * $1369} *
            q!: * {($how $seeInf $result) * $1369} *
            q!: * {$tellImp * $result * $1369} *
            q!: * {(есть $li $result) * $1369} *

            if: $injector.russianLoto.isAvailable && $injector.isLotteriesAvailable
                if: $parseTree._newYear || $session.newYear || $parseTree._1369
                    if: checkIfCurrentDateIsBefore("2021-01-01 18:00")
                        # до 18:00 1 января
                        a: Результаты новогоднего тиража лотереи «Русское лото» будут опубликованы на сайте 1 января 2021 года после 18:00 мск.
                        script:
                            $session.newYear = false;
                    else:
                        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    if: Time.isSpecialEvent(18)
                        # до 18:00 1 января
                        a: Результаты новогоднего тиража лотереи «Русское лото» будут опубликованы на сайте 1 января 2021 года после 18:00 мск.
                    else:
                        if: Time.sundayTimeIsGood() // Setting testMode to true via /setTestMode will enable sunday-like answer forever.
                            a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                        else:
                            a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.

            else:
                a: По техническим причинам результаты {{ $injector.russianLoto.ticketRun }} тиража лотереи {{ $injector.russianLoto.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.russianLoto.ticketRun }} тиража лотереи {{ $injector.russianLoto.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.


        state: MyWish
            # Подскажите результаты розыгрыша Мое желание
            q!: {$result (~розыгрыш/~акция) $myWish}

            q!: * {$why $comNo $result ([по] $myWish)} *
            q!: * {($when/какого числа) * [$seeInf] * $result * $myWish} *
            q!: * ($when/какого числа) * $seeInf * $myWish *
            q!: * {$comWhere * [$seeInf] * $result * $myWish} *
            q!: * {($how $seeInf $result) * $myWish} *
            q!: * {$tellImp * $result * $ticketRun * $myWish} *
            q!: * есть ли $result [$lottery/$ticketRun] $myWish *

            q: * $myWish *

            if: checkIfCurrentDateIsBefore("2021-01-01 18:00")
                a: Результаты розыгрыша «Мое желание» смотрите 1 января 2021 года в 15:30 на НТВ в прямом эфире, а также на сайте www.stoloto.ru 01.01.2021 публикуются новости о результатах розыгрышей с указанием данных о победителях.
            else:
                # Результаты Вы можете посмотреть на сайте по ссылке
                a: Результаты Вы можете посмотреть на сайте по ссылке https://www.stoloto.ru/press/news/2021/01/01/itogi-akcii-moyo-zhelanie


        state: GoldenShoe
            q!: {$result ~розыгрыш $goldenShoe}
            q!: * {$wrong * $ticketRun * $goldenShoe} *
            q!: * {$why $comNo $result ([по] $goldenShoe)} *
            q!: * {$when * [$seeInf] * $result * $goldenShoe} *
            q!: * {$comWhere * [$seeInf] * $result * $goldenShoe} *
            q!: * {($how $seeInf $result) * $goldenShoe} *
            q!: * {$tellImp * $result * $ticketRun * $goldenShoe} *
            q!: * есть ли $result [$lottery/$ticketRun] $goldenShoe *

            q: * $goldenShoe *

            # где посмотреть результаты новогоднего тиража Золотой подковы
            q!: {($result ~розыгрыш $newYear) $goldenShoe}
            q!: * {$why $comNo $result} * $newYear * $goldenShoe *
            q!: * $goldenShoe * {$why $comNo $result} * $newYear *
            q!: * $newYear * $goldenShoe * {$why $comNo $result} *
            q!: * $newYear * {$why $comNo $result} * $goldenShoe *
            q!: * $goldenShoe * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} *
            q!: * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} * $goldenShoe *
            q!: * $goldenShoe * {($seeInf/$tellImp) * $result * $newYear} *
            q!: * {($seeInf/$tellImp) * $result * $newYear} * $goldenShoe *
            q!: * {($how $seeInf $result) * $newYear * $goldenShoe} *
            q!: * $goldenShoe * {$tellImp * $result * ($newYear $ticketRun)} *
            q!: * {$tellImp * $result * ($newYear $ticketRun)} * $goldenShoe *
            q!: * {(есть $li $result) * $newYear * $goldenShoe} *
            q!: * $goldenShoe * есть $li $result $newYear ($lottery/$ticketRun) *
            q!: * есть $li $result $newYear ($lottery/$ticketRun) * $goldenShoe *


            if: $injector.goldenShoe.isAvailable && $injector.isLotteriesAvailable
                if: $parseTree._newYear || $session.newYear
                    if: checkIfCurrentDateIsBefore("2021-01-01 10:30")
                        # до 10:30 1 января
                        a: Результаты новогоднего тиража лотереи «Золотая подкова» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                        script:
                            $session.newYear = false;
                    else:
                        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    if: Time.isSpecialEvent(10, 30)
                        # до 10:30 1 января
                        a: Результаты новогоднего тиража лотереи «Золотая подкова» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                    else:
                        if: Time.sundayTimeIsGood()
                            a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                        else:
                            a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.


            else:
                a: По техническим причинам результаты {{ $injector.goldenShoe.ticketRun }} тиража лотереи {{ $injector.goldenShoe.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.goldenShoe.ticketRun }} тиража лотереи {{ $injector.goldenShoe.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: Bingo75
            q!: {$result ~розыгрыш $bingo}
            q!: * {$wrong * $ticketRun * $bingo} *
            q!: * {$why $comNo $result ([по] $bingo)} *
            q!: * {$when * [$seeInf] * $result * $bingo} *
            q!: * {$comWhere * [$seeInf] * $result * $bingo} *
            q!: * {($how $seeInf $result) * $bingo} *
            q!: * {$tellImp * $result * $ticketRun * $bingo} *
            q!: * есть ли $result [$lottery/$ticketRun] $bingo *

            q: * $bingo *

            # где посмотреть результаты новогоднего тиража Бинго
            q!: {($result ~розыгрыш $newYear) $bingo}
            q!: * {$why $comNo $result} * $newYear * $bingo *
            q!: * $bingo * {$why $comNo $result} * $newYear *
            q!: * $newYear * $bingo * {$why $comNo $result} *
            q!: * $newYear * {$why $comNo $result} * $bingo *
            q!: * $bingo * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} *
            q!: * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} * $bingo *
            q!: * $bingo * {($seeInf/$tellImp) * $result * $newYear} *
            q!: * {($seeInf/$tellImp) * $result * $newYear} * $bingo *
            q!: * {($how $seeInf $result) * $newYear * $bingo} *
            q!: * $bingo * {$tellImp * $result * ($newYear $ticketRun)} *
            q!: * {$tellImp * $result * ($newYear $ticketRun)} * $bingo *
            q!: * {(есть $li $result) * $newYear * $bingo} *
            q!: * $bingo * есть $li $result $newYear ($lottery/$ticketRun) *
            q!: * есть $li $result $newYear ($lottery/$ticketRun) * $bingo *

            if: $injector.bingo75.isAvailable && $injector.isLotteriesAvailable
                if: $parseTree._newYear || $session.newYear
                    if: checkIfCurrentDateIsBefore("2021-01-01 10:30")
                        # до 10:30 1 января
                        a: Результаты новогоднего тиража лотереи «Бинго-75» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                        script:
                            $session.newYear = false;
                    else:
                        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    if: Time.isSpecialEvent(10, 30)
                        # до 10:30 1 января
                        a: Результаты новогоднего тиража лотереи «Бинго-75» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                    else:
                        if: Time.sundayTimeIsGood()
                            a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                        else:
                            a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.



            else:
                a: По техническим причинам результаты {{ $injector.bingo75.ticketRun }} тиража лотереи {{ $injector.bingo75.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.bingo75.ticketRun }} тиража лотереи {{ $injector.bingo75.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: 6of36
            q!: {$result ~розыгрыш $6of36}
            q!: * {$wrong * $ticketRun * $6of36} *
            q!: * {$why $comNo $result ([по] $6of36)} *
            q!: * {$when * [$seeInf] * $result * $6of36} *
            q!: * {$comWhere * [$seeInf] * $result * $6of36} *
            q!: * {($how $seeInf $result) * $6of36} *
            q!: * {$tellImp * $result * $ticketRun * $6of36} *
            q!: * есть ли $result [$lottery/$ticketRun] $6of36 *

            q: * $6of36 *

            # где посмотреть результаты новогоднего тиража 6 из 36
            q!: {($result ~розыгрыш $newYear) $6of36}
            q!: * {$why $comNo $result} * $newYear * $6of36 *
            q!: * $6of36 * {$why $comNo $result} * $newYear *
            q!: * $newYear * $6of36 * {$why $comNo $result} *
            q!: * $newYear * {$why $comNo $result} * $6of36 *
            q!: * $6of36 * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} *
            q!: * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} * $6of36 *
            q!: * $6of36 * {($seeInf/$tellImp) * $result * $newYear} *
            q!: * {($seeInf/$tellImp) * $result * $newYear} * $6of36 *
            q!: * {($how $seeInf $result) * $newYear * $6of36} *
            q!: * $6of36 * {$tellImp * $result * ($newYear $ticketRun)} *
            q!: * {$tellImp * $result * ($newYear $ticketRun)} * $6of36 *
            q!: * {(есть $li $result) * $newYear * $6of36} *
            q!: * $6of36 * есть $li $result $newYear ($lottery/$ticketRun) *
            q!: * есть $li $result $newYear ($lottery/$ticketRun) * $6of36 *

            if: $injector['6of36'].isAvailable && $injector.isLotteriesAvailable
                if: $parseTree._newYear || $session.newYear
                    if: checkIfCurrentDateIsBefore("2021-01-01 10:30")
                        # до 10:30 1 января
                        a: Результаты новогоднего тиража лотереи «6 из 36» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                        script:
                            $session.newYear = false;
                    else:
                        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    if: Time.isSpecialEvent(10, 30)
                        # до 10:30 1 января
                        a: Результаты новогоднего тиража лотереи «6 из 36» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                    else:
                        if: Time.sundayTimeIsGood()
                            a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                        else:
                            a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.



            else:
                a: По техническим причинам результаты {{ $injector['6of36'].ticketRun }} тиража лотереи {{ $injector['6of36'].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector['6of36'].ticketRun }} тиража лотереи {{ $injector['6of36'].lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: HousingLottery
            q!: {$result ~розыгрыш $housingLottery}
            q!: * {$wrong * $ticketRun * $housingLottery} *
            q!: * {$why $comNo $result ([по] $housingLottery)} *
            q!: * {$when * [$seeInf] * $result * $housingLottery} *
            q!: * {$comWhere * [$seeInf] * $result * $housingLottery} *
            q!: * {($how $seeInf $result) * $housingLottery} *
            q!: * {$tellImp * $result * $ticketRun * $housingLottery} *
            q!: * есть ли $result [$lottery/$ticketRun] $housingLottery *
            q: * $housingLottery *

            # где посмотреть результаты новогоднего тиража ЖЛ
            q!: {($result ~розыгрыш $newYear) $housingLottery}
            q!: * {$why $comNo $result} * $newYear * $housingLottery *
            q!: * $housingLottery * {$why $comNo $result} * $newYear *
            q!: * $newYear * $housingLottery * {$why $comNo $result} *
            q!: * $newYear * {$why $comNo $result} * $housingLottery *
            q!: * $housingLottery * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} *
            q!: * {(($when/$comWhere) * [$seeInf]) * $result * $newYear} * $housingLottery *
            q!: * $housingLottery * {($seeInf/$tellImp) * $result * $newYear} *
            q!: * {($seeInf/$tellImp) * $result * $newYear} * $housingLottery *
            q!: * {($how $seeInf $result) * $newYear * $housingLottery} *
            q!: * $housingLottery * {$tellImp * $result * ($newYear $ticketRun)} *
            q!: * {$tellImp * $result * ($newYear $ticketRun)} * $housingLottery *
            q!: * {(есть $li $result) * $newYear * $housingLottery} *
            q!: * $housingLottery * есть $li $result $newYear ($lottery/$ticketRun) *
            q!: * есть $li $result $newYear ($lottery/$ticketRun) * $housingLottery *



            if: $injector.housingLottery.isAvailable && $injector.isLotteriesAvailable
                if: $parseTree._newYear || $session.newYear
                    if: checkIfCurrentDateIsBefore("2021-01-01 10:30")
                        # до 10:30 1 января
                        a: Результаты новогоднего тиража «Жилищной лотереи» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                        script:
                            $session.newYear = false;
                    else:
                        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    if: Time.isSpecialEvent(10, 30)
                    # до 10:30 1 января
                        a: Результаты новогоднего тиража «Жилищной лотереи» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                    else:
                        if: Time.sundayTimeIsGood()
                            a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                        else:
                            a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.



            else:
                a: По техническим причинам результаты {{ $injector.housingLottery.ticketRun }} тиража лотереи {{ $injector.housingLottery.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.housingLottery.ticketRun }} тиража лотереи {{ $injector.housingLottery.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: Matchball
            q!: {$result ~розыгрыш $matchball}
            q!: * {$wrong * $ticketRun * $matchball} *
            q!: * {$why $comNo $result ([по] $matchball)} *
            q!: * {$when * [$seeInf] * $result * $matchball} *
            q!: * {$comWhere * [$seeInf] * $result * $matchball} *
            q!: * {($how $seeInf $result) * $matchball} *
            q!: * {$tellImp * $result * [$ticketRun] * $matchball} *
            q!: * есть ли $result [$lottery/$ticketRun] $matchball *

            q!: * {~архив * $matchball} *

            q: * $matchball * || fromState = /Lottery/WhereToFindResults
            script: Webim.switch();

        state: OtherNamedLottery
            q!: {$result ~розыгрыш $otherNamedLottery}
            q!: * {$wrong * $ticketRun * $otherNamedLottery} *
            q!: * {$why $comNo $result ([по] $otherNamedLottery)} *
            q!: * {$when * [$seeInf] * $result * $otherNamedLottery} *
            q!: * {$comWhere * [$seeInf] * $result * $otherNamedLottery} *
            q!: * {($how $seeInf $result) * $otherNamedLottery} *
            q!: * {$tellImp * $result * $ticketRun * $otherNamedLottery} *
            q!: * есть ли $result [$lottery/$ticketRun] $otherNamedLottery *
            q: * $otherNamedLottery * || fromState = /Lottery/WhereToFindResults
            # Если мы переходим по лотерее, названной отдельным запросом. Примеры в test/temp.xml
            if: $session.lastLottery
                if: $injector[$session.lastLottery].isAvailable && $injector.isLotteriesAvailable
                    a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    a: По техническим причинам результаты {{ $injector[$session.lastLottery].ticketRun }} тиража лотереи {{ $injector[$session.lastLottery].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
            else:
                if: $injector[$parseTree._otherNamedLottery].isAvailable && $injector.isLotteriesAvailable
                    a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    a: По техническим причинам результаты {{ $injector[$parseTree._otherNamedLottery].ticketRun }} тиража лотереи {{ $injector[$parseTree._otherNamedLottery].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                    #a: Публикация {{ $injector[$parseTree._otherNamedLottery].ticketRun }} тиража лотереи {{ $injector[$parseTree._otherNamedLottery].lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: Other
            q!: {$result ~розыгрыш $multiTicketRun}
            q!: * {$wrong * $ticketRun * $multiTicketRun} *
            q!: * {$why $comNo $result ([по] $multiTicketRun)} *
            q!: * {$when * [$seeInf] * $result * $multiTicketRun} *
            q!: * {$comWhere * [$seeInf] * $result * $multiTicketRun} *
            q!: * {($how $seeInf $result) * $multiTicketRun} *
            q!: * {$tellImp * $result * $ticketRun * $multiTicketRun} *
            q!: * есть ли $result [$lottery/$ticketRun] $multiTicketRun *
            q: * $multiTicketRun * || fromState = /Lottery/WhereToFindResults
            q: ($stoloto/спортлото/[спорт] лото) || fromState = /Lottery/WhereToFindResults
            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».
                Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.


    state: CantCheckResult
        # Не могу проверить билет (стейт включает условия для периода массовых сложностей)
        q!: * $cantPastPres * $isTicketWin *
        q!: * $isTicketWin * $cantPastPres *

        q!: * $why ($ne показывает/непоказывает/нипоказывает) $prize

        q!: * $cantCheckTicket *

        q!: * $checkTicketPresNe * ($ticket/$ticketRun/$lottery) *
        q!: * ($ticket/$ticketRun/$lottery) * $checkTicketPresNe *

        q!: $cantPastPres [его/их] $checkTicketInf

        q!: * $when * $result * их * $comNo *
        intent!: /Lottery/CantCheckResult
        if: Lotteries.allLotteriesAvailable($injector)
            if: Time.sundayTimeIsGood()
                if: $session.lastLottery
                    script: $reactions.transition(Lotteries.getTargetLotteryPath($session))
                else:
                    a: Какая лотерея Вас интересует?
            else:
                a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».
                    Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
        else:
            if: $session.lastLottery
                script: $reactions.transition(Lotteries.getTargetLotteryPath($session))
            else:
                a: Какая лотерея Вас интересует?

        state: RussianLoto
            q: * $russianLoto * || fromState = /Lottery/CantCheckResult
            q: * $1369 *

            q!: * $russianLoto * $cantPastPres * $isTicketWin *
            q!: * $cantPastPres * $isTicketWin * $russianLoto *

            q!: * $russianLoto * $isTicketWin * $cantPastPres *
            q!: * $isTicketWin * $cantPastPres * $russianLoto *

            q!: * $cantCheckTicket * $russianLoto *
            q!: * $russianLoto * $cantCheckTicket *

            q!: * {$cantPastPres * $checkTicketInf * $russianLoto} *

            q!: * {$checkTicketPresNe * $russianLoto} *
            q!: * {$checkTicketPresNe * ($ticket/$ticketRun/$lottery) *$russianLoto} *

            q!: * {$when * $result * $russianLoto} * их * $comNo *

            if: $injector.russianLoto.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(18)
                    # до 18:00 1 января
                    a: Результаты новогоднего тиража лотереи «Русское лото» будут опубликованы на сайте 1 января 2021 года после 18:00 мск.
                else:
                    if: Time.sundayTimeIsGood() // Setting testMode to true via /setTestMode will enable sunday-like answer forever.
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить». Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.russianLoto.ticketRun }} тиража лотереи {{ $injector.russianLoto.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.russianLoto.ticketRun }} тиража лотереи {{ $injector.russianLoto.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.


        state: MyWish
            # Не могу проверить розыгрыш Мое желание
            q: * $myWish * || fromState = /Lottery/CantCheckResult

            q!: * $myWish * $cantPastPres * $isTicketWin *
            q!: * $cantPastPres * $isTicketWin * $myWish *

            q!: * $myWish * $isTicketWin * $cantPastPres *
            q!: * $isTicketWin * $cantPastPres * $myWish *

            q!: * $cantCheckTicket * $myWish *
            q!: * $myWish * $cantCheckTicket *

            q!: * {$cantPastPres * $checkTicketInf * $myWish} *

            q!: * {$checkTicketPresNe * $myWish} *
            q!: * {$checkTicketPresNe * ($ticket/$ticketRun/$lottery) *$myWish} *

            q!: * {$when * $result * $myWish} * их * $comNo *

            if: checkIfCurrentDateIsBefore("2021-01-01 18:00")
                a: Результаты розыгрыша «Мое желание» смотрите 1 января 2021 года в 15:30 на НТВ в прямом эфире, а также на сайте www.stoloto.ru 01.01.2021 публикуются новости о результатах розыгрышей с указанием данных о победителях.
            else:
                # Результаты Вы можете посмотреть на сайте по ссылке
                a: Результаты Вы можете посмотреть на сайте по ссылке https://www.stoloto.ru/press/news/2021/01/01/itogi-akcii-moyo-zhelanie


        state: GoldenShoe
            q: * $goldenShoe * || fromState = /Lottery/CantCheckResult

            q!: * $goldenShoe * $cantPastPres * $isTicketWin *
            q!: * $cantPastPres * $isTicketWin * $goldenShoe *

            q!: * $goldenShoe * $isTicketWin * $cantPastPres *
            q!: * $isTicketWin * $cantPastPres * $goldenShoe *

            q!: * $cantCheckTicket * $goldenShoe *
            q!: * $goldenShoe * $cantCheckTicket *

            q!: * {$cantPastPres * $checkTicketInf * $goldenShoe} *

            q!: * {$checkTicketPresNe * $goldenShoe} *
            q!: * {$checkTicketPresNe * ($ticket/$ticketRun/$lottery) *$goldenShoe} *

            q!: * {$when * $result * $goldenShoe} * их * $comNo *

            if: $injector.goldenShoe.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    # до 10:30 1 января
                    a: Результаты новогоднего тиража лотереи «Золотая подкова» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить». Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.goldenShoe.ticketRun }} тиража лотереи {{ $injector.goldenShoe.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.goldenShoe.ticketRun }} тиража лотереи {{ $injector.goldenShoe.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: Bingo75
            q: * $bingo * || fromState = /Lottery/CantCheckResult

            q!: * $bingo * $cantPastPres * $isTicketWin *
            q!: * $cantPastPres * $isTicketWin * $bingo *

            q!: * $bingo * $isTicketWin * $cantPastPres *
            q!: * $isTicketWin * $cantPastPres * $bingo *

            q!: * $cantCheckTicket * $bingo *
            q!: * $bingo * $cantCheckTicket *

            q!: * {$cantPastPres * $checkTicketInf * $bingo} *

            q!: * {$checkTicketPresNe * $bingo} *
            q!: * {$checkTicketPresNe * ($ticket/$ticketRun/$lottery) *$bingo} *

            q!: * {$when * $result * $bingo} * их * $comNo *

            if: $injector.bingo75.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    # до 10:30 1 января
                    a: Результаты новогоднего тиража лотереи «Бинго-75» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить». Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.bingo75.ticketRun }} тиража лотереи {{ $injector.bingo75.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.bingo75.ticketRun }} тиража лотереи {{ $injector.bingo75.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: 6of36
            q: * $6of36 * || fromState = /Lottery/CantCheckResult
            q!: * $6of36 * $cantPastPres * $isTicketWin *
            q!: * $cantPastPres * $isTicketWin * $6of36 *

            q!: * $6of36 * $isTicketWin * $cantPastPres *
            q!: * $isTicketWin * $cantPastPres * $6of36 *

            q!: * $cantCheckTicket * $6of36 *
            q!: * $6of36 * $cantCheckTicket *

            q!: * {$cantPastPres * $checkTicketInf * $6of36} *

            q!: * {$checkTicketPresNe * $6of36} *
            q!: * {$checkTicketPresNe * ($ticket/$ticketRun/$lottery) *$6of36} *
            q!: * {$when * $result * $6of36} * их * $comNo *

            if: $injector['6of36'].isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    # до 10:30 1 января
                    a: Результаты новогоднего тиража лотереи «6 из 36» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить». Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector['6of36'].ticketRun }} тиража лотереи {{ $injector['6of36'].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector['6of36'].ticketRun }} тиража лотереи {{ $injector['6of36'].lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: HousingLottery
            q: * $housingLottery * || fromState = /Lottery/CantCheckResult

            q!: * $housingLottery * $cantPastPres * $isTicketWin *
            q!: * $cantPastPres * $isTicketWin * $housingLottery *

            q!: * $housingLottery * $isTicketWin * $cantPastPres *
            q!: * $isTicketWin * $cantPastPres * $housingLottery *

            q!: * $cantCheckTicket * $housingLottery *
            q!: * $housingLottery * $cantCheckTicket *

            q!: * {$cantPastPres * $checkTicketInf * $housingLottery} *

            q!: * {$checkTicketPresNe * $housingLottery} *
            q!: * {$checkTicketPresNe * ($ticket/$ticketRun/$lottery) *$housingLottery} *
            q!: * {$when * $result * $housingLottery} * их * $comNo *

            if: $injector.housingLottery.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                # до 10:30 1 января
                    a: Результаты новогоднего тиража «Жилищной лотереи» будут опубликованы на сайте 1 января 2021 года после 10:30 мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить». Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.housingLottery.ticketRun }} тиража лотереи {{ $injector.housingLottery.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.housingLottery.ticketRun }} тиража лотереи {{ $injector.housingLottery.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: Matchball
            q: * $matchball * || fromState = /Lottery/CantCheckResult

            q!: * $matchball * $cantPastPres * $isTicketWin *
            q!: * $cantPastPres * $isTicketWin * $matchball *

            q!: * $matchball * $isTicketWin * $cantPastPres *
            q!: * $isTicketWin * $cantPastPres * $matchball *

            q!: * $cantCheckTicket * $matchball *
            q!: * $matchball * $cantCheckTicket *

            q!: * {$cantPastPres * $checkTicketInf * $matchball} *

            q!: * {$checkTicketPresNe * $matchball} *
            q!: * {$checkTicketPresNe * ($ticket/$ticketRun/$lottery) *$matchball} *
            q!: * {$when * $result * $matchball} * их * $comNo *
            script: Webim.switch();


        state: OtherNamedLottery
            q: * $otherNamedLottery * || fromState = /Lottery/CantCheckResult

            q!: * $otherNamedLottery * $cantPastPres * $isTicketWin *
            q!: * $cantPastPres * $isTicketWin * $otherNamedLottery *

            q!: * $otherNamedLottery * $isTicketWin * $cantPastPres *
            q!: * $isTicketWin * $cantPastPres * $otherNamedLottery *

            q!: * $cantCheckTicket * $otherNamedLottery *
            q!: * $otherNamedLottery * $cantCheckTicket *

            q!: * {$cantPastPres * $checkTicketInf * $otherNamedLottery} *

            q!: * {$checkTicketPresNe * $otherNamedLottery} *
            q!: * {$checkTicketPresNe * ($ticket/$ticketRun/$lottery) *$otherNamedLottery} *
            q!: * {$when * $result * $otherNamedLottery} * их * $comNo *

            if: $session.lastLottery
                if: $injector[$session.lastLottery].isAvailable && $injector.isLotteriesAvailable
                    a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».
                        Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    a: По техническим причинам результаты {{ $injector[$session.lastLottery].ticketRun }} тиража лотереи {{ $injector[$session.lastLottery].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                    #a: Публикация {{ $injector[$session.lastLottery].ticketRun }} тиража лотереи {{ $injector[$session.lastLottery].lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.
            else:
                if: $injector[$parseTree._otherNamedLottery].isAvailable && $injector.isLotteriesAvailable
                    a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».
                        Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    a: По техническим причинам результаты {{ $injector[$parseTree._otherNamedLottery].ticketRun }} тиража лотереи {{ $injector[$parseTree._otherNamedLottery].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                    #a: Публикация {{ $injector[$parseTree._otherNamedLottery].ticketRun }} тиража лотереи {{ $injector[$parseTree._otherNamedLottery].lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: Other
            q: * $multiTicketRun * || fromState = /Lottery/CantCheckResult
            q: ($stoloto/спортлото/[спорт] лото) || fromState = /Lottery/CantCheckResult

            q!: * $multiTicketRun * $cantPastPres * $isTicketWin *
            q!: * $cantPastPres * $isTicketWin * $multiTicketRun *

            q!: * $multiTicketRun * $isTicketWin * $cantPastPres *
            q!: * $isTicketWin * $cantPastPres * $multiTicketRun *

            q!: * $cantCheckTicket * $multiTicketRun *
            q!: * $multiTicketRun * $cantCheckTicket *

            q!: * {$cantPastPres * $checkTicketInf * $multiTicketRun} *

            q!: * {$checkTicketPresNe * $multiTicketRun} *
            q!: * {$checkTicketPresNe * ($ticket/$ticketRun/$lottery) *$multiTicketRun} *
            q!: * {$when * $result * $multiTicketRun} * их * $comNo *

            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».
                Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.

        state: CheckButtonIsNotActive
            # Кнопка Проверить не активна
            q: * {$button $checkTicket [$ticket] $activeNe} *
            q: * {$button $activeNe} *
            intent: /Lottery/CantCheckResult/CheckButtonIsNotActive
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
            intent: /Lottery/CantCheckResult/IDontRememberWhichLottery
            go!: ../Other

        state: ThereAreNoTicketRunNumberAndTicketNumber
            q: * это $comWhere *
            q: * серия $Number *
            q: * $ne ($number/$ticketNumber) $nothing *
            q: * $only ($number/$ticketNumber) и $code *
            q: * $comWhere (этот/эти) $number *
            q: * $comWhere эти $numeral *
            q: * {$forgetPastPres $number} *
            q: * $comNo этих данных *
            intent: /Lottery/CantCheckResult/ThereAreNoTicketRunNumberAndTicketNumber
            go!: /Ticket/ThereAreNoTicketRunNumberAndTicketNumber

        state: CheckByQrCode
            q: * {[$generalNamedLottery] * ($by $qrCode)} *
            a: Отсканировать QR-код на билете Вы можете с помощью специальной программы-распознавателя или официального приложения «Столото» для iOS или Android.

        state: Coupon
            # у меня купон
            q: * ~купон *
            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».\n\nНомер тиража и номер билета Вы можете посмотреть на черно-белой квитанции, которую Вам выдали при покупке билета. Номер тиража указан в верхней части квитанции после слов «Билет действителен для 1 тиража (ей)». Если у Вас не сохранилась квитанция, Вы можете зарегистрироваться с номером телефона, указанным при покупке купона, на сайте. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты», там же Вы найдете всю информацию о билете.


    state: IDontSeeRusLotoResultsInMyTickets
        # Задержка в публикации результатов розыгрыша РЛ в "Мои билеты"
        q!: * {$bonusComePastPresNe * $result * @RL * (мои билеты)} *
        q!: * {$bonusComePastPresNe * $result * @RL * (моих билетах)} *
        q!: * {$comNo * $result * @RL * (мои билеты)} *
        q!: * {$comNo * $result * @RL * (моих билетах)} *
        q!: * {$findPastPresNe * $result * @RL * (мои билеты)} *
        q!: * {$findPastPresNe * $result * @RL * (моих билетах)} *
        q!: * {$delay * $result * @RL * (мои билеты)} *
        q!: * {$delay * $result * @RL * (моих билетах)} *
        q!: * {$inactive * $result * @RL * (мои билеты)} *
        q!: * {$inactive * $result * @RL * (моих билетах)} *
        q!: * {($when будут) * $result * @RL * (мои билеты)} *
        q!: * {($when будут) * $result * @RL * (моих билетах)} *
        q!: * {($when появят*) * $result * @RL * (мои билеты)} *
        q!: * {($when появят*) * $result * @RL * (моих билетах)} *
        q!: * {($when загруз*) * $result * @RL * (мои билеты)} *
        q!: * {($when загруз*) * $result * @RL * (моих билетах)} *
        q!: * {($when $waitInf) * $result * @RL * (мои билеты)} *
        q!: * {($when $waitInf) * $result * @RL * (моих билетах)} *
        q!: * {($when смогу $seeInf) * $result * @RL * (мои билеты)} *
        q!: * {($when смогу $seeInf) * $result * @RL * (моих билетах)} *
        q!: * ($ne опубликован*/неопубликован*/ниопубликован*/$ne опубликовал*/неопубликовал*/ниопубликовал*/$ne выложен*/невыложен*/нивыложен*/$ne выложил*/невыложил*/нивыложил*/$ne выкладываете/невыкладываете/нивыкладываете) * $result * @RL * (мои билеты/моих билетах) *
        q!: * $result * @RL * ($ne опубликован*/неопубликован*/ниопубликован*/$ne опубликовал*/неопубликовал*/ниопубликовал*/$ne выложен*/невыложен*/нивыложен*/$ne выложил*/невыложил*/нивыложил*/$ne выкладываете/невыкладываете/нивыкладываете) * (мои билеты/моих билетах) *
        intent!: /Lottery/IDontSeeRusLotoResultsInMyTickets
        if: $global.rusLotoResultsInMyTicketsAreAvailable
            script: Webim.switch();
        else:
            a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Многократно возросла нагрузка на все информационные системы, поэтому сегодня результаты розыгрыша могут быть опубликованы с задержкой. Все данные будут в вашем личном кабинете в ближайшее время.


    state: ResultsAreNotDisplayedCorrectly
        # некорректно отображается информация о результатах тиража
        q!: * {$incorrectly * $displayPres3 * $result} *
        q!: * {$result * $displayPres3 * ($with ~ошибка)} *
        q!: * {$incorrectly * $displayPres3 * (выпавш* ($numeral/числ*))} *
        q!: * {(выпавш* ($numeral/числ*)) * $displayPres3 * ($with ~ошибка)} *
        q!: * {$incorrectly * $displayPres3 * (инф* о $prize)} *
        q!: * {(инф* о $prize) * $displayPres3 * ($with ~ошибка)} *
        q!: * {$wrong * ~отображение * $result} *
        q!: * {$wrong * ~отображение * (выпавш* ($numeral/числ*))} *
        q!: * {$wrong * ~отображение * (инф* о $prize)} *
        q!: * {~отображение * $result * $incorrectly} *
        q!: * {~отображение * (выпавш* ($numeral/числ*)) * $incorrectly} *
        q!: * {~отображение * (инф* о $prize) * $incorrectly} *
        intent!: /Lottery/ResultsAreNotDisplayedCorrectly
        if: $global.resultsAreDisplayedCorrectly
            script: Webim.switch();
        else:
            a: Результаты розыгрышей загружаются на сайт из тиражных таблиц, подтвержденных протоколами тиражной комиссии. Иногда при проверке билета может возникать некорректное отображение страниц, что никак не сказывается на результате тиража. Все победители в обязательном порядке получат свои выигрыши. Корректная информация будет опубликована в ближайшее время.


    state: WhyDidntPlayTheCirculation
        # Проблема с проведением тиража
        q!: * {$error * (проведени* [$Number] $ticketRun)} *
        q!: * {$error * (проведени* розыгрыш*)} *
        q!: * {$error * (проведени* игры)} *
        q!: * {~трудность * (проведени* [$Number] $ticketRun)} *
        q!: * {~трудность * (проведени* розыгрыш*)} *
        q!: * {~трудность * (проведени* игры)} *
        q!: * {$why * ($ne начинает*/неначинает*) * розыгрыш*} *
        q!: * {(розыгрыш*/$ticketRun) * отменили} *
        q!: * {(розыгрыш*/$ticketRun) * отменен} *
        q!: * {игру * (отменили/перенесли)} *
        q!: * {игра * (отменена/перенесена)} *
        q!: * {(розыгрыш*/$ticketRun) * перенесли} *
        q!: * {(розыгрыш*/$ticketRun) * перенесен} *
        q!: * {$why * $ticketRun * ($ne разыграли/неразыграли)} *
        q!: * {$why * $ticketRun * ($ne разыгран/неразыгран)} *
        q!: * {$why * $ticketRun * ($ne провели/непровели)} *
        q!: * {$why * $ticketRun * ($ne проведен/непроведен)} *
        q!: * (обещали/должны были) (провести/разыграть) [$Number] $ticketRun *
        intent!: /Lottery/WhyDidntPlayTheCirculation
        if: $global.drawTakesPlaceOnTime
            script: Webim.switch();
        else:
            a: По техническим причинам время проведения тиража было изменено. Результаты розыгрыша, как обычно, будут загружаться на сайт и в мобильное приложение только после проведения тиража из таблиц, подтвержденных протоколами тиражной комиссии. Все выигрыши будут выплачены победителям в полном объеме.


    state: HowToPlay
        # Как принять участие в лотерее на сайте
        q!: * новичок *
        q!: * (первый раз/впервые) (участвую/учавствую/пробую играть/играю/$here) *
        q!: * (участвую/учавствую/пробую играть/играю/$here) (первый раз/впервые) *
        q!: [$helloAll] {[я] [$want] $playInf [в ($lottery/$stoloto)/$hereAll]}
        q!: * {$how * $playInf * [$lottery]} *
        q!: * $how (пользоват*/пользовац*) [нов*] $ticket *
        q!: * {$whatToDoInf * $forTo * $playInf} *
        q!: [$helloAll] Купитьбилет

        q!: [$helloAll] {[я] [$want] $buyInf [$ticketAndLotteryAll]}
        q!: [$helloAll] {[я] помогите $buyInf [$ticketAndLotteryAll]}
        q!: [$helloAll] {[я] [$want] $payInf [$ticketAndLotteryAll]}

        #q!: * {$comWhere * $buyInf * $ticketAndLotteryAll} *
        q!: * {$comWhere * $payInf * $ticketAndLotteryAll} *
        q!: * $how $buyInf $buyN *
        q!: * {$how * $buyInf * $ticketAndLotteryAll} *
        q!: * {$how * $payInf * $ticketAndLotteryAll} *
        q!: * {могу * $buyInf * $ticketAndLotteryAll} *
        q!: * {могу * $payInf * $ticketAndLotteryAll} *
        q!: * {$possiblePredicAll * $buyInf * $ticketAndLotteryAll} *
        q!: * {$possiblePredicAll * $payInf * $ticketAndLotteryAll} *
        q!: * $how выбрать $ticketAndLotteryAll *
        q!: * $how $passPres $payment *
        q!: * {$how $payInf} [$ticketAndLotteryAll] $by ($phoneAndNum/$sms) *
        q!: * {$possiblePredicAll $payInf} [$ticketAndLotteryAll] $by ($phoneAndNum/$sms) *
        q!: * {$want $payInf} [$ticketAndLotteryAll] $by ($phoneAndNum/$sms) *
        q!: * {$how $payInf} [$ticketAndLotteryAll] $fromTelephone *
        q!: * {$possiblePredicAll $payInf} [$ticketAndLotteryAll] $fromTelephone *
        q!: * {$want $payInf} [$ticketAndLotteryAll] $fromTelephone *
        #q!: [$helloAll] {($how/$comWhere) $buyInf}
        q!: [$helloAll] {$how $buyInf}
        q!: [$helloAll] {($how/$comWhere) $payInf}

        q!: * {($how $passPres) * ($buyN $ticketAndLottery)} *
        q!: [$helloAll] {($buyInf/$payInf) [$ticketAndLottery] (без ($registration/авторизации))}
        q!: * {$how * ($buyInf/$payInf) * $ticketAndLotteryAll * (без ($registration/авторизации))} *
        q!: * может * летний * $playInf *

        q!: [$helloAll] [я] $buyPastPres {$ticket [(1/2/3/4/5) $item/1шт/2шт/3шт/4шт/5шт]}
        intent!: /Lottery/HowToPlay
        a: Ознакомиться с инструкцией, как принять участие в лотерее на сайте, Вы можете, пройдя по ссылке https://www.stoloto.ru/lottery/onlinesale


    #state: Quarantine
        # Карантин
        #q!: [$helloAll] {$comWhere $buyInf}
        #q!: [$helloAll] вы (работаете/работайте)
        #q!: * {$comWhere * $buyInf * $ticketAndLotteryAll} *
        #q!: * {$buyInf * [$ticketAndLotteryAll] * $quarantine} *
        #q!: * {$buyInf * [$ticketAndLotteryAll] * $quarantine} *
        #q!: * {$buyInf * [$ticketAndLotteryAll] * (из дома)} *
        #q!: * $when буд* продавать $ticketAndLotteryAll *
        #q!: * {буд* * продавать * точк*} *
        #q!: * {буд* * продавать * ~киоск} *
        #q!: * {буд* * продавать * ~центр} *
        #q!: * {буд* * продавать * ~пункт} *
        #q!: * {буд* * продавать * ~ларек} *
        #q!: * {буд* * работать * точк*} *
        #q!: * {буд* * работать * ~киоск} *
        #q!: * {буд* * работать * ~центр} *
        #q!: * {буд* * работать * ~пункт} *
        #q!: * {буд* * работать * ~ларек} *
        #q!: * в услови* $quarantine *
        #q!: * {$quarantine * работ* * точк*} *
        #q!: * {$quarantine * работ* * ~киоск} *
        #q!: * {$quarantine * работ* * ~центр} *
        #q!: * {$quarantine * работ* * ~пункт} *
        #q!: * {$quarantine * работ* * ~ларек} *
        #q!: * {$quarantine * прода* * точк*} *
        #q!: * {$quarantine * прода* * ~киоск} *
        #q!: * {$quarantine * прода* * ~центр} *
        #q!: * {$quarantine * прода* * ~пункт} *
        #q!: * {$quarantine * прода* * ~ларек} *
        #q!: * {$quarantine * вы * прода*} *
        #q!: * {[$quarantine] * закр* * точк*} *
        #q!: * {[$quarantine] * закр* * ~киоск} *
        #q!: * {[$quarantine] * закр* * ~центр} *
        #q!: * {[$quarantine] * закр* * ~пункт} *
        #q!: * {[$quarantine] * закр* * ~ларек} *
        #q!: * {$quarantine * вы * закр*} *
        #q!: * {[$quarantine] * откр* * точк*} *
        #q!: * {[$quarantine] * откр* * ~киоск} *
        #q!: * {[$quarantine] * откр* * ~центр} *
        #q!: * {[$quarantine] * откр* * ~пункт} *
        #q!: * {[$quarantine] * откр* * ~ларек} *
        #q!: * {продолжа* * работать * точк*} *
        #q!: * {продолжа* * работать * ~киоск} *
        #q!: * {продолжа* * работать * ~центр} *
        #q!: * {продолжа* * работать * ~пункт} *
        #q!: * {продолжа* * работать * ~ларек} *
        #q!: * {продолжа* * прода* * точк*} *
        #q!: * {продолжа* * прода* * ~киоск} *
        #q!: * {продолжа* * прода* * ~центр} *
        #q!: * {продолжа* * прода* * ~пункт} *
        #q!: * {продолжа* * прода* * ~ларек} *
        #q!: * {продолжа* * работу * точк*} *
        #q!: * {продолжа* * работу * ~киоск} *
        #q!: * {продолжа* * работу * ~центр} *
        #q!: * {продолжа* * работу * ~пункт} *
        #q!: * {продолжа* * работу * ~ларек} *
        #q!: * {*останов* * ~работа * ~точка} *
        #q!: * {*останов* * ~работа * ~киоск} *
        #q!: * {*останов* * ~работа * ~центр} *
        #q!: * {*останов* * ~работа * ~пункт} *
        #q!: * {*останов* * ~работа * ~ларек} *
        #q!: * {*останов* * ~продажа * ~точка} *
        #q!: * {*останов* * ~продажа * ~киоск} *
        #q!: * {*останов* * ~продажа * ~центр} *
        #q!: * {*останов* * ~продажа * ~пункт} *
        #q!: * {*останов* * ~продажа * ~ларек} *
        #q!: * {встанет * ~работа * ~точка} *
        #q!: * {встанет * ~работа * ~киоск} *
        #q!: * {встанет * ~работа * ~центр} *
        #q!: * {встанет * ~работа * ~пункт} *
        #q!: * {встанет * ~работа * ~ларек} *
        #q!: * {*работают * ~точка} *
        #q!: * {*работают * ~киоск} *
        #q!: * {*работают * ~центр} *
        #q!: * {*работают * ~пункт} *
        #q!: * {*работают * ~ларек} *
        #q!: * {откроет* * ~точка} *
        #q!: * {откроет* * ~киоск} *
        #q!: * {откроет* * ~центр} *
        #q!: * {откроет* * ~пункт} *
        #q!: * {откроет* * ~ларек} *
        #q!: * {откроют* * ~точка} *
        #q!: * {откроют* * ~киоск} *
        #q!: * {откроют* * ~центр} *
        #q!: * {откроют* * ~пункт} *
        #q!: * {откроют* * ~ларек} *
        #q!: * {продают* * ~точка} *
        #q!: * {продают* * ~киоск} *
        #q!: * {продают* * ~центр} *
        #q!: * {продают* * ~пункт} *
        #q!: * {продают* * ~ларек} *
        #q!: * пока карантин *
        #q!: * сейчас (работает/закрыт*) $stoloto *
        #q!: * (работающ*/рабоч*/продающ*) (~точка/~киоск/~центр/~пункт/~ларек) *
        #q!: * {~розыгрыш * (штатн* режим*)} *
        #q!: * {работаете * (штатн* режим*)} *
        #q!: * {разыгрываете * (штатн* режим*)} *
        #q!: * {работает* * (по адресу)} *
        #intent!: /Lottery/Quarantine
        #a: В связи с распространением коронавируса с 28 марта временно приостановлена продажа билетов и выплата выигрышей в московском лотерейном центре «Столото» на Волгоградском проспекте и в собственных точках продаж «Столото». Все выигрыши будут выплачены победителям в полном объеме. Обратиться за получением выигрыша можно в течение трех с половиной лет с даты публикации результатов тиража. Приобрести лотерейные билеты можно на сайте https://www.stoloto.ru/


    state: LotteryRules
        # Правила лотереи
        q!: * инф* о [$lottery] $lotteriesForRules *
        q!: [$helloAll] [какие] правила [$lottery/лото/игры/~розыгрыш] [$lotteriesForRules]
        q!: [$helloAll] правила [$lottery/лото/игры/начисления выигрыш* комбин*/ * ~розыгрыш] [в] $lotteriesForRules

        q!: [$helloAll] [какие] условия ($prize/~розыгрыш) [в] [$lottery/лото/~игра/~розыгрыш] [$lotteriesForRules]
        q!: * правила * каждой $lottery *
        q!: * (условия/правила) [для] участия * $lotteriesForRules *

        q!: * какие условия $prize [в] ($lottery/лото/~игра/~розыгрыш) *
        q!: * какие условия $prize [в] [$lottery/лото/~игра/~розыгрыш] $lotteriesForRules *
        q!: * $lotteriesForRules * какие условия $prize *

        q!: * {(~какой ~условие $possiblePredic $winInf) * [$lotteriesForRules]} *
        q!: * [$lotteriesForRules] * при ~какой ~условие [в/по] [$lotteriesForRules] $ticket * счит* выигрышн* * [$lotteriesForRules] *

        q!: * какие правила [ваш*] ($lottery/лото/игры/~розыгрыш) *
        q!: * какие правила [ваш*] [$lottery/лото/игры/~розыгрыш] [в] $lotteriesForRules *
        q!: * какие правила в [ваш*] ($lottery/лото/игре/розыгрыше) *
        q!: * какие правила в [ваш*] [$lottery/лото/игре/розыгрыше] $lotteriesForRules *
        q!: * $comWhere * правила *читать *
        q!: * $comWhere [$oneWord] (правила/условия [$prize]) [в] [ваш*] ($lottery/лото/~игра/~розыгрыш) *
        q!: * $comWhere [$oneWord] (правила/условия [$prize]) [в] [ваш*] [$lottery/лото/~игра/~розыгрыш] $lotteriesForRules *
        q!: * (*скаж*/напомните/$findOutInf/*читать/прочесть/$link/*интерес*/посмотреть/поглядеть/уточнит*/объяснит*/ознакомит*/понимаю) * (~правило/~условие) [ваш*] ($lottery/лото/игры/начисления выигрыш* комбин*/ * ~розыгрыш) *
        q!: * (~правило/~условие) [ваш*] ($lottery/лото/игры/начисления выигрыш* комбин*/ * ~розыгрыш) * (*скаж*/напомните/$findOutInf/*читать/$link/*интерес*/посмотреть/поглядеть/уточнит*/объяснит*/ознакомит*/какие) *
        q!: * (*скаж*/напомните/$findOutInf/*читать/прочесть/$link/*интерес*/посмотреть/поглядеть/уточнит*/~информация/объяснит*/ознакомит*) * (~правило/~условие) [ваш*] [$lottery/лото/игры/начисления выигрыш* комбин*/ * ~розыгрыш] [в] $lotteriesForRules *
        q!: * (~правило/~условие) [ваш*] [$lottery/лото/игры/начисления выигрыш* комбин*/ * ~розыгрыш] [в] $lotteriesForRules * (*скаж*/напомните/$findOutInf/*читать/прочесть/$link/*интерес*/посмотреть/поглядеть/уточнит*/объяснит*/ознакомит*/какие) *
        q!: * по каким критериям $winPastPres3 [в] $lotteriesForRules *
        q!: * [$lotteriesForRules] * какой {положен $prize} * [$lotteriesForRules] *
        q!: * [$lotteriesForRules] * {(распределяет*/распределяют*) $prize} * [$lotteriesForRules] *

        q!: * (подробнее/вопрос) [узнать] (о/об/про/по) [$lottery/лото/~игра] $lotteriesForRules *
        q!: * (принцип/смысл) ($lottery/лото/~игра) *
        q!: * (принцип/смысл) [$lottery/лото/~игра] $lotteriesForRules *

        q!: * [$lotteriesForRules] * $skolko {$comNeed [$oneWord] (чисел/номеров/$numeral)} для $prize * [$lotteriesForRules] *
        q!: * [$lotteriesForRules] * (($skolko/какое количество/много) (чисел/номеров/$numeral)/$comWhat) (должно/$comNeed) (совпасть/выпасть/выпость/угадать) * [$lotteriesForRules] *
        q!: * [$lotteriesForRules] * ($skolko/какое количество/много) (должно/$comNeed) (совпасть/выпасть/выпость/угадать) (чисел/номеров/$numeral) * [$lotteriesForRules] *
        q!: * [$lotteriesForRules] * $must угадать по * [$lotteriesForRules] *

        q!: * [$lotteriesForRules] * ($skolko/какое количество/много) * (чисел/номеров/$numeral) * (собрать/отметить/угадать) * [$lotteriesForRules] *
        q!: * [$lotteriesForRules] * какой {$beFutSgPl3 $prize} * [$lotteriesForRules] *
        q!: * [$lotteriesForRules] * ~случай $beFutSgPl3 $prize * [$lotteriesForRules] *


        q!: * ~число выпал* $ticket считает* *
        q!: * {$how зачеркивать числа} *
        q!: * {$how * заполнять * $eTicket} *
        q!: * {$lotteriesForRules * (какие $ticket $winPresPl3)} *
        q!: * кто $winPresSg3 в [ваш*] ($lottery/лото/~игра) *
        q!: * кто $winPresSg3 в [ваш*] [$lottery/лото/~игра] $lotteriesForRules *
        q!: * {(какие комбинац* * $winPresPl3) * [$lotteriesForRules]} *
        q!: * [$lotteriesForRules] * какой $ticket (выиграет/выигрывает) * [$lotteriesForRules] *
        q!: * $how будет проходить [ваш*] ($lottery/лото/~игра) *
        q!: * (сам*/$how) (заполнить/заполнять) поля *
        q!: * {((сам*/$how) (заполнить/заполнять)) * $lotteriesForRules} *
        q!: * {(порядок заполнения $ticket) * [$lotteriesForRules]} *
        q!: * $comWhat [это] за [$lottery] $lotteriesForRules *
        q!: * {(от какого призов* фонда) * $lotteriesForRules} *

        intent!: /Lottery/LotteryRules
        if: $parseTree._RLExpress
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/ruslotto2
        elseif: $parseTree._RL
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/ruslotto
        elseif: $parseTree._bingo
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/bingo75/rules
        elseif: $parseTree._6of45
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/6x45/rules
        elseif: $parseTree._matchball
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/5x50/rules
        elseif: $parseTree._5of36
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/5x36plus/rules
        elseif: $parseTree._4of20
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/4x20/rules
        elseif: $parseTree._zodiak
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/zodiac/rules
        elseif: $parseTree._rapido
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/rapido/rules
        elseif: $parseTree._rapido20
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/rapido2/rules
        elseif: $parseTree._12of24
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/12x24/rules
        elseif: $parseTree._duel
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/duel/rules
        elseif: $parseTree._plusJoker
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/joker/rules
        elseif: $parseTree._top3
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/top3/rules
        elseif: $parseTree._keno
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/quickgames/keno?int=right
        elseif: $parseTree._housingLottery
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/gzhl/rules
        elseif: $parseTree._6of36
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/6x36/rules
        elseif: $parseTree._goldenShoe
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/zp/rules
        elseif: $parseTree._7of49
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/7x49/rules
        elseif: $parseTree._specPlay
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/spec/
        else:
            a: Уточните, пожалуйста, какая лотерея Вас интересует?

        state: RLExpress
            q: * $RLExpress *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/ruslotto2

        state: RussianLoto
            q: * @RL *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/ruslotto

        state: Bingo
            q: * $bingo *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/bingo75/rules

        state: 6of45
            q: * $6of45 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/6x45/rules

        state: Matchball
            q: * $matchball *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/5x50/rules

        state: 5of36
            q: * $5of36 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/5x36plus/rules

        state: 4of20
            q: * $4of20 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/4x20/rules

        state: Zodiak
            q: * $zodiak *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/zodiac/rules

        state: Rapido
            q: * $rapido *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/rapido/rules

        state: Rapido20
            q: * $rapido20 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/rapido2/rules

        state: 12of24
            q: * $12of24 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/12x24/rules

        state: Duel
            q: * $duel *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/duel/rules

        state: Joker
            q: * $plusJoker *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/joker/rules

        state: Top3
            q: * $top3 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/top3/rules

        state: Keno
            q: * $keno *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/quickgames/keno?int=right

        state: HousingLottery
            q: * $housingLottery *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/gzhl/rules

        state: 6of36
            q: * $6of36 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/6x36/rules

        state: GoldenShoe
            q: * $goldenShoe *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/zp/rules

        state: 7of49
            q: * $7of49 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/7x49/rules

        state: SpecPlay
            q: * $specPlay *
            q!: * (через какую/в какой) $lottery * {$iPhone * $winInf} *
            q!: * (через какую/в какой) $lottery * {$iPhone * разыгрыв*} *
            q!: * в ($specPlay/новой $lottery) * (кроме/помимо) $iPhone * ($winInf/разыгрыв*) *
            q!: * в ($specPlay/новой $lottery) * ($winInf/разыгрыв*) * (кроме/помимо) $iPhone *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/spec/

        state: Kubishka
            q: * $kubishka *
            a: «Кубышка» - дополнительный розыгрыш, который проводится не в каждом тираже. В «Кубышке» выигрывает тот билет, в котором все 4 невыпавшие числа находятся в верхнем или нижнем игровом поле. Поэтому, если по окончании основных туров у Вас остались четыре незачеркнутых числа, не расстраивайтесь, пожалуйста. Ведь, если все они в одном поле, Вы выиграли денежный приз.\n\nПодробнее с информацией Вы можете ознакомиться по ссылке https://www.stoloto.ru/ruslotto/rules

        state: BonusPlay
            q: ~бонусный
            q: * $bonusPlay *
            a: Данная информация указана на странице бонусной программы. Ознакомиться с информацией Вы можете по данной ссылке: https://www.stoloto.ru/private/bonus

        state: Other
            event: noMatch
            script: Webim.switch();


    state: CanForeignersPlay
        # Могут ли играть иностранцы?
        q!: * (только/лишь) русским $playInf *
        q!: * $countryNotRussia (может/$canPresSg3Ne) $playInf *
        q!: * {$foreigner * $playInf} *
        q!: * {$foreigner * ~игра} *
        q!: * {$bePresSg1Ne * $russian * $playInf} *
        q!: * {$bePresSg1Ne * (резидент* $russia) * $playInf} *
        q!: * {$bePresSg1Ne * $russian * ~игра} *
        q!: * {$bePresSg1Ne * (резидент* $russia) * ~игра} *
        q!: * {(я $ne из $russia) * $playInf} *
        q!: * {(я $ne из $russia) * ~игра} *
        q!: * {(из $countryNotRussia) * $playInf} *
        q!: * {(я из $countryNotRussia) * ~игра} *
        q!: * $with $countryNotRussia * $playInf *
        q!: * {(я $livePresSg1 в $countryNotRussia) * $playInf} *
        q!: * {(я $livePresSg1 в $countryNotRussia) * ~игра} *
        q!: * {(~гражданин $countryNotRussia) * $playInf} *
        q!: * {(~гражданин $countryNotRussia) * ~игра} *
        q!: * {(~гражданин $countryNotRussia) * ~шанс} *
        q!: * {$foreignCitizenship * $playInf} *
        q!: * {$foreignCitizenship * ~игра} *
        q!: * {$comNo [у меня] $russianCitizenship} * ($playInf/~игра) *
        q!: * ($playInf/~игра) * {$comNo [у меня] $russianCitizenship} *
        q!: * {$havePresSg1Ne [я] $russianCitizenship} * ($playInf/~игра) *
        q!: * ($playInf/~игра) * {$havePresSg1Ne [я] $russianCitizenship} *
        q!: * {$comNo [у меня] $russianPassport} * ($playInf/~игра) *
        q!: * ($playInf/~игра) * {$comNo [у меня] $russianPassport} *
        q!: * {$havePresSg1Ne [я] $russianPassport} * ($playInf/~игра) *
        q!: * ($playInf/~игра) * {$havePresSg1Ne [я] $russianPassport} *

        q!: * {$foreigner * $registerInfRefl} *
        q!: * {$foreigner * $registration} *
        q!: * {$bePresSg1Ne * $russian * $registerInfRefl} *
        q!: * {$bePresSg1Ne * (резидент* $russia) * $registerInfRefl} *
        q!: * {$bePresSg1Ne * $russian * $registration} *
        q!: * {$bePresSg1Ne * (резидент* $russia) * $registration} *
        q!: * {(я $ne из $russia) * $registerInfRefl} *
        q!: * {(я $ne из $russia) * $registration} *
        q!: * {(я из $countryNotRussia) * $registerInfRefl} *
        q!: * {(я из $countryNotRussia) * $registration} *
        q!: * {(я $livePresSg1 в $countryNotRussia) * $registerInfRefl} *
        q!: * {(я $livePresSg1 в $countryNotRussia) * $registration} *
        q!: * {(~гражданин $countryNotRussia) * $registerInfRefl} *
        q!: * {(~гражданин $countryNotRussia) * $registration} *
        q!: * {$foreignCitizenship * $registerInfRefl} *
        q!: * {$foreignCitizenship * $registration} *
        q!: * {$comNo [у меня] $russianCitizenship} * ($registerInfRefl/$registration) *
        q!: * ($registerInfRefl/$registration) * {$comNo [у меня] $russianCitizenship} *
        q!: * {$havePresSg1Ne [я] $russianCitizenship} * ($registerInfRefl/$registration) *
        q!: * ($registerInfRefl/$registration) * {$havePresSg1Ne [я] $russianCitizenship} *
        q!: * {$comNo [у меня] $russianPassport} * ($registerInfRefl/$registration) *
        q!: * ($registerInfRefl/$registration) * {$comNo [у меня] $russianPassport} *
        q!: * {$havePresSg1Ne [я] $russianPassport} * ($registerInfRefl/$registration) *
        q!: * ($registerInfRefl/$registration) * {$havePresSg1Ne [я] $russianPassport} *

        q!: * {$foreigner * $buyInf} *
        q!: * {$bePresSg1Ne * $russian * $buyInf} *
        q!: * {$bePresSg1Ne * (резидент* $russia) * $buyInf} *
        q!: * {(я $ne из $russia) * $buyInf} *
        q!: * {(я из $countryNotRussia) * $buyInf} *
        q!: * {(я $livePresSg1 в $countryNotRussia) * $buyInf} *
        q!: * {(~гражданин $countryNotRussia) * $buyInf} *
        q!: * {$foreignCitizenship * $buyInf} *
        q!: * {$comNo [у меня] $russianCitizenship} * $buyInf *
        q!: * $buyInf * {$comNo [у меня] $russianCitizenship} *
        q!: * {$havePresSg1Ne [я] $russianCitizenship} * $buyInf *
        q!: * $buyInf * {$havePresSg1Ne [я] $russianCitizenship} *
        q!: * {$comNo [у меня] $russianPassport} * $buyInf *
        q!: * $buyInf * {$comNo [у меня] $russianPassport} *
        q!: * {$havePresSg1Ne [я] $russianPassport} * $buyInf *
        q!: * $buyInf * {$havePresSg1Ne [я] $russianPassport} *

        q!: * {$possiblePredicAll * $playInf * $nationality} *
        q!: * {мог* * $playInf * $nationality} *
        q!: * {$possiblePredicAll * $registerInfRefl * $nationality} *
        q!: * {мог* * $registerInfRefl * $nationality} *
        q!: * {$possiblePredicAll * $buyInf * $nationality} *
        q!: * {мог* * $buyInf * $nationality} *
        q!: * {$possiblePredicAll * $playInf * $only * $russian} *
        q!: * {мог* * $playInf * $only * $russian} *
        q!: * {$possiblePredicAll * $buyInf * $only * $russian} *
        q!: * {мог* * $buyInf * $only * $russian} *
        intent!: /Lottery/CanForeignersPlay
        a: Для участия в лотереях на сайте понадобится SIM-карта с номером российского, украинского, белорусского, таджикского, казахстанского, молдавского, узбекистанского, армянского, азербайджанского и грузинского операторов связи для возможности завершения регистрации и дальнейшего получения информации. Существует определенная специфика получения выигрышей и оплаты НДФЛ иностранными гражданами.\n\n​С информацией, как зарегистрироваться в системе с помощью других операторов связи (не РФ), ознакомьтесь, пожалуйста, в разделе «Как участвовать в лотереях на сайте stoloto.ru»: https://www.stoloto.ru/lottery/onlinesale


    state: AreThereAnyInstantLotteries
        # У вас есть моментальные лотереи?
        q!: [$helloAll] [про] {$instant $ticketAndLotteryAll}
        q!: [$helloAll] [$beginningWords] {((есть/$comNo) [$li]) $instant}
        q!: [$helloAll] [$beginningWords] {$instant $ticketAndLotteryAll $comNo}
        q!: интересуют $instant
        q!: * {(в $application) * $instant * $ticketAndLotteryAll} *
        q!: * {есть * $instant * $ticketAndLotteryAll} *
        q!: * {работает * $instant * $ticketAndLotteryAll} *
        q!: * {будут * $instant * $ticketAndLotteryAll} *
        q!: * {$comNeed * $instant * $ticketAndLotteryAll} *
        q!: * {$comWhere * $instant * $ticketAndLotteryAll} *
        q!: * {(каком раздел*) * $instant * $ticketAndLotteryAll} *
        q!: * {$playInf * $instant * $ticketAndLotteryAll} *
        q!: * {$buyInf * $instant * $ticketAndLotteryAll} *
        q!: * {верните * $instant * $ticketAndLotteryAll} *
        q!: * {представлены * $instant * $ticketAndLotteryAll} *
        q!: * {доступны * $instant * $ticketAndLotteryAll} *
        q!: * {появ* * $instant * $ticketAndLotteryAll} *
        q!: * {($ne доступны) * $instant * $ticketAndLotteryAll} *
        q!: * {$findInf * $instant * $ticketAndLotteryAll} *
        q!: * $comWhere * $forTo * (стирать/тереть) *
        q!: * {$ticketAndLotteryAll * $need * (стирать/тереть)} *
        q!: * {~игра * $need * (стирать/тереть)} *
        q!: * {$ticketAndLotteryAll * можно * (стирать/тереть)} *
        q!: * {~игра * можно * (стирать/тереть)} *
        q!: * {есть * (стирать/тереть) * $ticketAndLotteryAll} *
        q!: * {есть * (стирать/тереть) * ~игра} *
        q!: * {$comWhere * (стирать/тереть) * $ticketAndLotteryAll} *
        q!: * {$comWhere * стирают* * $ticketAndLotteryAll} *
        q!: * {$buyInf * (стирать/тереть) * $ticketAndLotteryAll} *
        q!: * {есть * (стиралк*/стирашк*)} *
        q!: * {$playInf * (стиралк*/стирашк*)} *
        q!: * {($comWhere/как) * (стиралк*/стирашк*)} *
        q!: * {$buyInf * (стиралк*/стирашк*)} *
        q!: * {найти * (стиралк*/стирашк*)} *
        q!: * ~который * (стираеш*/стирает*/стирают*) *
        q!: * $comWhere стираеш* *
        intent!: /Lottery/AreThereAnyInstantLotteries
        a: На сайте отключена продажа билетов моментальных лотерей. О включении лотерей мы сообщим в новостях, а пока спешите приобретать билеты моментальных лотерей в розничных точках продаж.


    state: MultiStack
        q!: * $multistack *
        intent!: /Lottery/MultiStack
        a: Мультиставка - это функция, позволяющая сделать сразу много автоматических ставок. Вам нужно выбрать только количество билетов и оплатить их, система расставит случайные числа.


    state: ExpandedStack
        q!: * развернут* ~ставка *
        intent!: /Lottery/ExpandedStack
        a: Развернутая ставка - это ставка, которая в одном или двух игровых полях содержит больше одной минимальной комбинации. Например, более 4 чисел в поле 1 и более 4 чисел в поле 2 для «Гослото «4 из 20», более 5 чисел в поле 1 и более 1 числа в поле 2 для «Гослото «5 из 36», более 6 чисел для «Гослото «6 из 45» и так далее. При развернутой ставке выбранные числа будут представлены как максимально возможное число неповторяющихся минимальных комбинаций. Это существенно повышает вероятность выигрыша, но и увеличивает цену билета. Выбрать все числа на игровом поле нельзя. Для каждой лотереи существуют ограничения по количеству выбранных чисел. Они могут отличаться на сайте и при покупке в розничной точке (это связано с установленными лимитами платежей).


    state: WhatIsMultiplier
        # Что такое множитель?
        q!: $multiplier
        q!: * $comWhat $oneWord $multiplier *
        q!: * $whatFor $oneWord $multiplier *
        q!: * (~какой ~цель) [$oneWord] $multiplier *
        q!: $multiplier $whatFor она $comNeed *
        q!: $multiplier {это $comWhat}
        q!: {[$beginningWords] [в чем] [заключа*] смысл $multiplier}
        intent!: /Lottery/WhatIsMultiplier
        a: Множитель - это дополнительная опция, которая позволяет увеличить выигрыш. Если Вы выберете множитель, то сумма Вашего выигрыша увеличится кратно его значению. Стоимость билета также увеличится. Лотереи, в правилах которых есть множитель: «Рапидо», «Рапидо 2.0»,«КЕНО-Спортлото», «12/24», «Топ-3», «Дуэль».\n\nМножители используются в лотереях:\n\n- «Рапидо»;\n- «КЕНО-Спортлото»;\n- «12/24»;\n- «Топ-3»;\n- «Дуэль»;\n- «Джокер».


    state: WhatIsDistributionCirculation
        # Что такое распределительный тираж?
        q!: $distributionCirculation
        q!: * как понять $distributionCirculation *
        q!: * $comWhat $oneWord $distributionCirculation *
        q!: * $whatFor $oneWord $distributionCirculation *
        q!: * (~какой ~цель) [$oneWord] $distributionCirculation *
        q!: {[$beginningWords] [в чем] [заключа*] смысл $distributionCirculation}
        q!: $distributionCirculation $whatFor он $comNeed *
        q!: $distributionCirculation {это $comWhat}
        intent!: /Lottery/WhatIsDistributionCirculation
        a: Распределительный тираж - это розыгрыш, в котором накопленная сумма суперприза или его часть делится между победителями тиража, если никто из участников этого тиража не выиграл суперприз единолично. Периодичность таких тиражей регулируется ФЗ «О лотереях». Он предписывает их проведение не реже одного раза в год, если в течение всего года суперприз никто не выигрывает. В случае если выигрышная комбинация при проведении распределительного тиража угадывается одним человеком, вся сумма суперприза достается этому человеку.


    state: From1to90
        # Вопросы про набор Все числа от 1 до 90
        q!: * {выбрать * $from1To90} *
        q!: * {$findInf * (функцию/опцию) * $from1To90} *
        q!: * {$seeInf * $numeral * $from1To90} *
        q!: * {$useInf * $from1To90} *
        q!: * {откроют* * $from1To90} *
        q!: * {$enableInfImp * $from1To90} *
        q!: * {$enablePresReflSg3 * $from1To90} *
        q!: * {заполнять * $from1To90} *
        q!: * {заполняют* * $from1To90} *
        q!: * {заполняет* * $from1To90} *
        q!: * {повторя* * $from1To90} *
        q!: * {(присут* все ($numeral/числа)) * $from1To90} *
        q!: * {($ne все ($numeral/числа)) * $from1To90} *
        q!: * {(($numeral/числа) $ne все) * $from1To90} *
        q!: * {($how это) * $from1To90} *
        q!: * {(это $how) * $from1To90} *
        q!: * {($how * работает) * $from1To90} *
        q!: * {($how понять) * $from1To90} *
        q!: * {($comWhat [$oneWord] (значит/означает/дает)) * $from1To90} *
        q!: * $comWhat $oneWord * $from1To90 *

        q!: * {~смысл * $from1To90} *
        q!: * {преимуществ* * $from1To90} *
        q!: * {*дарить * [$ticketAndLottery] * $from1To90} *
        q!: * {$buyInf * (в подарок) * [$ticketAndLottery] * $from1To90} *
        q!: * {$buyInf * $from1To90} *
        intent!: /Lottery/From1To90
        a: Игровые комбинации в билетах состоят из чисел от 1 до 90 - данный набор позволяет одновременно купить 5 билетов, на которых гарантированно будут присутствовать все числа в этом диапазоне (каждое число хотя бы раз будет использовано).\n\nБилеты подбираются системой автоматически, игровые комбинации Вы сможете посмотреть только после покупки.\n\nПриобрести набор Вы можете на странице выбора билетов, для этого нажмите на вкладку «Все числа от 1 до 90», после этого система предложит перейти к оплате. Набор нельзя приобрести в подарок.


    #state: WhenWillTheDistributionCirculation
        # Когда будет распределительный тираж?
        #q!: [$helloAll] [а] ($when/какого числа) [в $russianLoto] ($distributionCirculation/$anniversaryDraw) *
        #q!: * ($when/какого числа) $anniversaryDraw *
        #q!: * ($when/какого числа) [в $russianLoto] ($distributionCirculation/$anniversaryDraw)
        #q!: * ($when/какого числа) ($distributionCirculation/$anniversaryDraw) (состоит*/пройдет/будет/будит/разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют) *
        #q!: * ($when/какого числа) ($distributionCirculation/$anniversaryDraw) [в] $russianLoto *
        #q!: * ($when/какого числа) (состоит*/пройдет/будет/будит/разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют) * ($distributionCirculation/$anniversaryDraw) *
        #q!: * ($distributionCirculation/$anniversaryDraw) ($when/какого числа) *
        #q!: * ($distributionCirculation/$anniversaryDraw) * ($when/какого числа) (состоит*/пройдет/будет/будит/разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют) *
        #q!: * {$anniversaryDraw * посмотреть * ~эфир} *
        #q!: * {$anniversaryDraw * узнать * дату} *
        #q!: [а] ($distributionCirculation/$anniversaryDraw) (состоит*/пройдет/будет/будит) 20 октября
        #q!: * ($when/какого числа/в каком ($ticketRun/$ticketRunNumber)) * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) * $billion *
        #q!: * ($when/какого числа/в каком ($ticketRun/$ticketRunNumber)) * $billion * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) *
        #q!: * $billion * ($when/какого числа/в каком ($ticketRun/$ticketRunNumber)) * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) *
        #q!: * $billion * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) * ($when/какого числа/в каком ($ticketRun/$ticketRunNumber)) *
        #q!: * {$when * $beFutSgPl3 * розыг* * $anniversaryDraw} *
        #q!: * {$when * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {$when * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {(какого числа) * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {(какого числа) * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {$when * $beFutSgPl3 * распред* * $billion} *
        #q!: * {(какого числа) * $beFutSgPl3 * распред* * $billion} *
        #q!: * {(в каком $ticketRun) * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {(в каком $ticketRunNumber) * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {(в каком $ticketRun) * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {(в каком $ticketRunNumber) * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {(в каком $ticketRun) * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {(в каком $ticketRunNumber) * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {(в каком $ticketRun) * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {(в каком $ticketRunNumber) * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {(в каком $ticketRun) * $beFutSgPl3 * распред* * $billion} *
        #q!: * {(в каком $ticketRunNumber) * $beFutSgPl3 * распред* * $billion} *
        #q!: * какой ($ticketRunNumber/$ticketRun) (праздничный/юбилейный) *
        #q!: * ($when/какого числа) * ~трансляция * ($distributionCirculation/$anniversaryDraw) *
        #q!: * ($when/какого числа/~какой ~канал/$comWhere/во $skolko) * (~трансляция/~передача/~эфир) * $russianLoto *
        #q!: * ($comWhere/~какой ~канал) * [~трансляция] * ($distributionCirculation/$anniversaryDraw) *
        #q!: * был* ли розыгрыш * ($distributionCirculation/$anniversaryDraw) *
        #q!: * (во $skolko/в какое время) * $anniversaryDraw *
        #q!: * $anniversaryDraw * (был/прошел/началс*) *
        #intent!: /Lottery/WhenWillTheDistributionCirculation
        #a: Трансляция тиража 1306 пройдет 20.10.2019 в 14:00 на НТВ.


    #state: QuestionsAboutABillion
        # Откуда вы уверены, что никто не возьмет джекпот?
        #q!: * (в каком случае/при ~какой ~условие/$how) * {$beFutSgPl3 * разыг* * $billion} *
        #q!: * (в каком случае/при ~какой ~условие/$how) * {$beFutSgPl3 * розыг* * $billion} *
        #q!: * (в каком случае/при ~какой ~условие/$how) * {$beFutSgPl3 * распред* * $billion} *
        #q!: * (в каком случае/при ~какой ~условие/$how) * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) * $billion *
        #q!: * (в каком случае/при ~какой ~условие/$how) * * $billion * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) *
        #intent!: /Lottery/QuestionsAboutABillion
        #a: 89-й ход и распределение части накопленного суперприза в размере 1 млрд рублей будут проведены в случае, если накопленный суперприз на начало тиража будет составлять 1 млрд рублей или более и в этом тираже не будет выигрышей в категории «Джекпот».


    state: WhatIsKubishka
        # Что такое кубышка?
        q!: [$helloAll] ~вопрос [про/о] $kubishka
        q!: * $comWhat $oneWord $kubishka * [$winInf] *
        q!: * $whatFor $oneWord $kubishka * [$winInf] *
        q!: * (~какой ~цель) [$oneWord] $kubishka *
        q!: $kubishka $whatFor она $comNeed *
        q!: $kubishka {это $comWhat}
        q!: * $how {разыгрыв* $kubishka} *
        q!: * {(~какой ~условие $possiblePredic $winInf) * $kubishka} *
        q!: * при ~какой ~условие [в/по] $kubishka $ticket * счит* выигрышн* *
        q!: * (правил*/услови*) $kubishka *
        q!: [$helloAll] [какие] условия ($prize/~розыгрыш) [в] [$lottery/лото/~игра] $kubishka
        q!: * какие условия $prize [в] [$lottery/лото/~игра] $kubishka *
        q!: [$helloAll] [какие] правила [$lottery/лото/игры] $kubishka
        q!: * какие правила [$lottery/лото/игры] [в] $kubishka *
        q!: * $comWhere [$oneWord] (правила/условия [$prize]) [в] [$lottery/лото/~игра] $kubishka *
        q!: * (*скаж*/напомните/$findOutInf/*читать/$link/*интерес*/посмотреть/поглядеть/уточнит*/~информация/объяснит*/понимаю) * (~правило/~условие) [$lottery/лото/игры] [в] $kubishka *
        q!: * (~правило/~условие) [$lottery/лото/игры] [в] $kubishka * (*скаж*/напомните/$findOutInf/*читать/$link/*интерес*/посмотреть/поглядеть/уточнит*/объяснит*) *
        q!: * по каким критериям $winPastPres3 [в] $kubishka *
        q!: * [$kubishka] * $skolko $comNeed [$oneWord] ($numeral/чисел) для $prize * [$kubishka] *
        q!: * (подробнее/вопрос) [узнать] (о/об/про) [$lottery/лото/~игра] $kubishka *
        q!: * (принцип/смысл) [$lottery/лото/~игра] $kubishka *
        q!: * {$kubishka * (какие $ticket $winPresPl3)} *
        q!: * кто $winPresSg3 в [$lottery/лото/~игра] $kubishka *
        intent!: /Lottery/WhatIsKubishka
        a: «Кубышка» - дополнительный розыгрыш, который проводится не в каждом тираже. В «Кубышке» выигрывает тот билет, в котором все 4 невыпавшие числа находятся в верхнем или нижнем игровом поле. Поэтому, если по окончании основных туров у Вас остались четыре незачеркнутых числа, не расстраивайтесь, пожалуйста. Ведь, если все они в одном поле, Вы выиграли денежный приз.\n\nПодробнее с информацией Вы можете ознакомиться по ссылке https://www.stoloto.ru/ruslotto/rules


    state: IWantToWin
        # Хочу выиграть
        q!: * {$want $winInf} *
        q!: * {мечта $winInf} *
        q!: * {$want $million} *
        q!: * {$want $jackpot} *
        q!: * надеюсь * ($something $winInf/на ($jackpot/победу)) *
        q!: * $waitPres1 (победу/победы) *
        q!: * {$when [же/ж/уже] мне повезет} *
        q!: * может {мне повезет} *
        q!: * принеси* * ~удача *
        q!: ($jackpot/$million) [$beFutSgPl3] (мой/моим) [$repeat<$emoji>]
        q!: {[$helloAll] $when я $winFutSg1 [$oneWord]} [$repeat<$emoji>]
        q!: * $when [же/ж] {уже я $winFutSg1} *
        q!: * $when (же/ж) я $winFutSg1 *
        q!: $comThanks [вам] за игру [$repeat<$emoji>]
        q!: $comThanks [вам] [за то] что вы есть [$repeat<$emoji>]
        intent!: /Lottery/IWantToWin
        a: Желаем Вам удачи и будущих побед.


    state: Scam
        # Лохотрон
        q!: * ($lohotron/$fraud) *
        q!: * {выигрывают * подставные} *
        q!: * ($ne ~честный/нечестн*/ничестн*) ~игра *
        q!: * $when $beFutSgPl3 ~честный (~игра/~розыгрыш) *
        q!: * у вас честные розыгрыш* *
        q!: * позорите *
        intent!: /Lottery/Scam
        a: «Столото» (www.stoloto.ru) — бренд крупнейшего распространителя всероссийских государственных лотерей, которые проводятся под государственным надзором Федеральной налоговой службы и на основании Распоряжений Правительства РФ в целях финансовой поддержки и развития физической культуры и спорта.\n\nОрганизаторами лотерей в рамках Федерального закона «О лотереях» выступают Минфин России и Минспорт России.\n\nКаждый желающий может посмотреть розыгрыши лотерей в прямом эфире или лично приехать в лотерейный центр «Столото» и своими глазами увидеть, как формируется выигрышная комбинация таких лотерей, как «Спортлото «4 из 20», «Спортлото «6 из 45», «Спортлото «7 из 49», «Зодиак», «Бинго-75», «Лото-Экспресс».\n\nВ соответствии со статьей 18 ФЗ «О лотереях» для розыгрыша призового фонда каждого тиража оператором лотереи создается тиражная комиссия. Она следит за ходом каждого розыгрыша и подтверждает его результаты подписанием официального тиражного протокола.


    state: ICantToWin
        # Не вариант выиграть
        q!: * {($cantPastPres/$ne вариант) $winInf} *
        q!: * {$nothing $winInfNe} *
        q!: * (у вас/$here) $winInfNe *
        q!: * $prize $comNo у вас *
        q!: * $nothing $ne (выигрываетс*/выигрываетьс*) *
        q!: * $winPresSn1Ne *
        q!: * (хрен/хер/фиг) [$here] [$comWhat] $winFutSg2 *
        q!: * $comWhere $comObsceneWord побед* *
        q!: * [вы] {($ne (даете/дают)/недаете/нидаете) [мне/людям] $winInf} *
        q!: * $winPastPres3 (одни и те же/только (свои/крупные города/армян*/[в/из/$with] (москв*/маскв*))/одна (москв*/маскв*)) *
        q!: * (одни и те же/($why * /только) (свои/крупные города/армян*/москвич*/(москв*/маскв*))/одна (москв*/маскв*)/богатые) * $winPastPres3 *
        q!: * ($winPresSg3/$winPresPl3) * только * (москв*/маскв*) *
        q!: * ($winPresSg3/$winPresPl3) * (москв*/маскв*) * $why *
        q!: * одни (армян*/москвич*/мосвич*/масквич*/масвич*) *
        q!: * $again {(москв*/маскв*) $winPastPerf} *
        q!: * $why * больш* $prize * в (москв*/маскв*) *
        q!: * $why из * $comNo победител* *
        q!: * своим (даете/дают) $winInf *
        q!: * куплен* $online $ticket $winPresPl3 *

        q!: * (помоги*/помож*) * $winInf *
        q!: * (помоги*/помож*) {[очень/сильн*] нужны $comMoney} *
        q!: * {[очень/сильн*] нужны $comMoney} (помоги*/помож*) *
        q!: * (помоги*/помож*) * {(погасить/закрыть) (ипотек*/[ипотеч*] ~кредит)} *
        q!: * (помоги*/помож*) * {стать (миллионер*/милионер*/~богатый/богач*)} *
        q!: * {$jackpot * сорвать} *
        q!: * подарите мне шанс *
        q!: * $prize поделим *
        q!: * (сделайте/сделаете/сделать) * $forTo я $winPastPerf *
        q!: * подыграйте *
        q!: * (дайт*/дай) * ~нормальный сумм* *
        q!: * (дайт*/дай/дадите/давайте) * $winInf *
        q!: [$helloAll] {давай денег}
        q!: * начнете (давать/довать) * $winInf *
        q!: * раз * {дали * $winInf} *
        q!: * какие $ticket * выбрать * $winInf *
        q!: * (есть/существуют) $li * $win $ticket *
        q!: [$helloAll] вероятность ($winInf/$prize)
        q!: * (~какой/каков*) [~процент/%] (~вероятность/~шанс) * ($winInf/на $prize) *
        q!: * (~какой/каков*) [~процент/%] (~вероятность/~шанс) (получить/сорвать) $jackpot *
        q!: * (~какой/каков*) (~процент/%) $prize *
        q!: * есть ~шанс $winInf *
        q!: * точно $winFutSg13 *
        q!: * точно * $possiblePredic $winInf *
        q!: * $possiblePredic {$winInf нормальн*} *
        q!: * ~какой $ticketAndLotteryAll * $buyInf * $winInf *

        q!: * {$how * $winInf} *
        q!: * ($whatToDoInf/$skolko * потратить) * $forTo * $winInf *
        q!: * $howMuch [мне] $comNeed проиграть $forTo $winInf *
        q!: * играю {$Number лет} дайте $comMoney *
        q!: * (фиг/невозможно) у вас стало $winInf *
        q!: * процент $win (упал/снизилс*/понизилс*/уменьшилс*) *
        q!: * $prize никогда $comNo *
        q!: * $ne одного крупн* $prize *
        intent!: /Lottery/ICantToWin
        a: Повлиять на результат розыгрыша невозможно. Тиражи наших лотерей проводятся с использованием специального оборудования, которое отвечает за случайность выпадения чисел и исключает какое-либо вмешательство в свою работу.\n\nМы никогда не знаем, как пройдет розыгрыш и кто станет победителем.\n\nБлагодаря современным технологиям Вы можете выбрать подходящий способ участия в лотереях, а также посмотреть розыгрыши лотерей в прямом эфире или лично приехать в единственный в мире лотерейный центр и своими глазами увидеть, как формируется выигрышная комбинация.\n\nОбращаем Ваше внимание на то, что мы работаем строго в соответствии с законодательством Российской Федерации. Вся наша деятельность регламентируется законом «О лотереях».


    state: IsItPossibleToWin
        # Реально ли выиграть
        q!: * {$possibly * $winInf} *
        q!: {$hereAll $winPastPres3} [$repeat<$emoji>]
        q!: * {($winPresPl3/выигрывать) вообще} *
        q!: {($generally/$really) $winPastPres3} [$repeat<$emoji>]
        q!: {(люди/что-нибудь) $winPastPres3} [$repeat<$emoji>]
        q!: * {россияне $winPastPres3} *
        q!: {$somebody $winPastPres3} [$repeat<$emoji>]
        q!: * {$hereAll ($generally/$really/хотя бы/хоть) $winPastPres3} *
        q!: * {(люди/что-нибудь/$somebody) ($generally/$really/хотя бы/хоть/$sometime) $winPastPres3} *
        q!: * кто $winPastPres3 есть *
        q!: * есть какие (нибудь/то) шансы (на $prize/$winInf) *
        q!: * {$hereAll (люди/что-нибудь/$somebody/$sometime) $winPastPres3} *
        q!: * больше $Number $rub ($winInfNe/$comNo $prize) *
        q!: * {$nobody [$hereAll] $winPresSn3Ne} *
        intent!: /Lottery/IsItPossibleToWin
        a: Благодаря всероссийским государственным лотереям каждую неделю в нашей стране появляется 15 новых миллионеров, ежедневно выигрывают свыше 200 тысяч билетов. Более миллиарда рублей выплачивается победителям лотерей ежемесячно.\n\nНа официальной странице сайта «Столото» есть раздел «Победители», перейдя по ссылке www.stoloto.ru/winners, Вы можете прочитать истории людей и разработать личную стратегию игры.


    state: LuckLeftMe
        # Везение меня покинуло
        q!: * $winInf так и *
        q!: * {($cantPastPres/$ne вариант) (так и) $winInf} *
        q!: * {$luck меня $leavePastSg3} *
        q!: * $comWhere $comMy $luck *
        q!: * {[вот] $again [я] (без $prize)} *
        q!: * все $ticket (без $prize) *
        q!: * $prize (шишь/мизер) *
        q!: * все равно $ne $winFutSg13 *
        q!: * $again $comMy $ticket ($ne выиграл*/невыиграл*/нивыиграл*) *
        q!: * (одни/постоянно) проигрыш* *
        q!: * ($ne одного/ниодного) $ticket $win *
        q!: * (больше/$only/вечно) (проигрыв*/проигрываеш*/продуваю/продуваеш*/продуеш*) *
        q!: * играю * {$prize $comNo} *
        q!: * ($ne везет/невезет) *
        q!: * и все мимо *
        q!: * везен* ($comNo/$zero) *
        q!: * {$comNo побед} *
        q!: * {($ne [~один] раз*/нираз*) [$nothing] $winPastPerfNe} *
        q!: * один хер * $winPastPerfNe *
        q!: * (постоян*/пастаян*/всегда/стабильно) (проигрыш*/проиграш*) *
        q!: * потратил* (свыше/бол*) * а $winPastPerf *
        q!: * столько $comMoney потратил* *
        q!: * {(проще/легче) * накопить} *
        q!: * (пол года/полгода) без ~победа *
        q!: * лет $oneWord играю *
        q!: * $skolko бы $ticket $ne купил* *
        q!: * $when я тоже $winFutSg13 *
        q!: * выиграеш* у вас *
        q!: * {тратим (в пустую/впустую)} *
        q!: * лучше [бы/б] хлеб* купил* *
        q!: * больше (вложил/вложила/потерял*/потярял*) *
        q!: * $skolko $comMoney (потерял*/потярял*/потерян*) *
        q!: * {(потерял*/потярял*) * веру} *
        q!: * (когда-нибуд*/когда нибуд*/когданибуд*) я увижу вы выиграли *
        intent!: /Lottery/LuckLeftMe
        a: Участие в лотерее нельзя рассматривать как источник дохода или выгодное вложение, где обязательно должна настать окупаемость затрат. Лотерея - это не банк.\n\nВо всем мире лотереи являются увлекательной формой досуга, семейной традицией, реальной возможностью в одночасье стать миллионером и изменить свою жизнь.\n\nВыигрыш в лотерею не зависит от количества купленных билетов и того, сколько лет Вы принимаете участие в лотерее.\n\nУчастие в лотерее не гарантирует выигрыш, но дает Вам уникальный шанс испытать удачу.


    #state: HowManyBarrelsWillRemainInABirthdayEvent
         #Сколько бочонков останется в тираже по случаю дня рождения?
        #q!: * {($skolko боч*) * $birthdayRL} *
        #q!: * {($skolko шаров) * $birthdayRL} *
        #q!: * {($skolko боч*) * $birthdayRL} *
        #q!: * {($skolko шаров) * $birthdayRL} *
        #q!: * {($skolko боч*) * $birthdayRL * $lotteryShow} *
        #q!: * {($skolko шаров) * $birthdayRL * $lotteryShow} *
        #q!: * {($skolko боч*) * 1358} *
        #q!: * {($skolko шаров) * 1358} *
        #a: Розыгрыш будет проведен до 88-го хода включительно, в мешке останется 2 бочонка.


    state: HowManyBarrelsWillRemainInNewYearEdition
        # Сколько бочонков останется в новогоднем тираже?
        q!: * {($skolko [$oneWord] (боч*/шаров)/до какого хода) * $newYear * $ticketRun} *
        q!: * {($skolko [$oneWord] (боч*/шаров)/до какого хода) * $newYear * @RL} *
        q!: * {($skolko [$oneWord] (боч*/шаров)/до какого хода) * $newYear * $lotteryShow} *
        q!: * {($skolko [$oneWord] (боч*/шаров)/до какого хода) * 1369} *
        q!: * ($skolko (боч*/шаров)) * (остане*/остатьс*/остатс*/остатц*/остац*/в мешке) *
        q!: * {((два/2) боч*) * остане*} *
        intent!: /Lottery/HowManyBarrelsWillRemainInNewYearEdition
        if: checkIfCurrentDateIsBefore("2021-01-03")
            a: По решению оператора лотереи ход, до которого проводится розыгрыш, может быть изменён перед началом проведения розыгрыша в зависимости от результатов всенародного голосования.
        else:
            script: Webim.switch();


    #state: WhenWillBirthdayRL
        # Когда трансляция тиража по случаю др Русского лото 1358?
        #q!: * {$when * (~трансляция/~передача/~эфир/~розыгрыш) * ($birthdayRL/1358)} *
        #q!: * {(какого числа) * (~трансляция/~передача/~эфир) * ($birthdayRL/1358)} *
        #q!: * {(какого числа) * ($birthdayRL/1358) * $lotteryShow} *
        #q!: * {(в какое время/когда) * [@RL] * ($birthdayRL/1358)} *
        #q!: * $when * (пройдет/будет/покажут/показывать) * ($birthdayRL/1358) * [@RL] *
        #q!: * {$when * ($birthdayRL/1358) * $lotteryShow * @RL} *
        #q!: * {$when * ($birthdayRL/1358) * @RL} *
        #q!: * {$when * ($birthdayRL/1358)} *
        #a: Трансляцию праздничного 1358-го тиража смотрите 18 октября в 8:20 на НТВ. Время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой.


    state: WillShowBeLiveOrNot
        # Прямой или непрямой эфир
        q!: * {$when * (~трансляция/~передача/~эфир/~розыгрыш) * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {(какого числа) * (~трансляция/~передача/~эфир/~розыгрыш) * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {(какого числа) * $lotteryShow * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {(в какое время/когда) * [@RL] * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * $when * [$beFutSgPl3] * (пройдет/будет/~показывать/покажут) * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49) *
        q!: * {$when * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49) * $lotteryShow} *

        q!: * {$when * [$beFutSgPl3] * (~показывать/покажут) * (~трансляция/~передача/~эфир/~розыгрыш/~шоу/~игра)}
        q!: * {~эфир * ~прямой} *
        q!: * {~эфир * ($ne ~прямой)} *
        q!: * {~эфир * ~непрямой} *
        q!: * {~трансляция * ~прямой} *
        q!: * {~трансляция * ($ne ~прямой)} *
        q!: * {~трансляция * ~непрямой} *
        q!: * {[$comWhere] * (~смотреть/*смотреть/глянуть/увидеть) * (~трансляция/~передача/~эфир/~розыгрыш/~шоу/~игра)} *
        q!: * {[$comWhere] * (~трансляция/~передача/~эфир/~розыгрыш/~шоу/~игра) * $online} *
        q!: * (~трансляция/~передача/~эфир/~розыгрыш/~шоу) * (~трансляция/~передача/~эфир/~розыгрыш/~шоу/~игра) *
        q!: * {[$comWhere] * (~смотреть/*смотреть/глянуть/увидеть) * $online} *


        q!: * {~эфир * ~прямой} * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49) *
        q!: * {$lotteryShow * [~эфир] * ~прямой} * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49) *
        q!: * $beFutSgPl3 * {~эфир * ~прямой} * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49) *
        q!: * $beFutSgPl3 * {~эфир * [~прямой] * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * ~какой * {~эфир * [~прямой] * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {~эфир * ~прямой * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {~эфир * ($ne ~прямой) * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {~трансляция * ~прямой * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {~трансляция * ($ne ~прямой) * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {~трансляция * ~непрямой * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {~трансляция * [~прямой] * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {~трансляция * [($ne ~прямой)] * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *
        q!: * {~трансляция * [~непрямой] * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49)} *


        if: $parseTree._RL
            a: Каждое воскресенье в 8:20 на телеканале НТВ транслируются лотереи Русское лото, Золотая подкова, Жилищная лотерея, Бинго-75 и 6 из 36 в телепередаче "У нас выигрывают" (время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой). Невозможно транслировать розыгрыш в прямом эфире для каждого часового пояса в одно время отдельно (передачу хотят посмотреть и жители дальних регионов, у них она должна быть также показана в 8:20), поэтому съемки программы проводятся в субботу вечером после закрытия продаж на текущий тираж.

        elseif: $parseTree._goldenShoe
            a: Каждое воскресенье в 8:20 на телеканале НТВ транслируются лотереи Русское лото, Золотая подкова, Жилищная лотерея, Бинго-75 и 6 из 36 в телепередаче "У нас выигрывают" (время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой). Невозможно транслировать розыгрыш в прямом эфире для каждого часового пояса в одно время отдельно (передачу хотят посмотреть и жители дальних регионов, у них она должна быть также показана в 8:20), поэтому съемки программы проводятся в субботу вечером после закрытия продаж на текущий тираж.

        elseif: $parseTree._housingLottery
            a: Каждое воскресенье в 8:20 на телеканале НТВ транслируются лотереи Русское лото, Золотая подкова, Жилищная лотерея, Бинго-75 и 6 из 36 в телепередаче "У нас выигрывают" (время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой). Невозможно транслировать розыгрыш в прямом эфире для каждого часового пояса в одно время отдельно (передачу хотят посмотреть и жители дальних регионов, у них она должна быть также показана в 8:20), поэтому съемки программы проводятся в субботу вечером после закрытия продаж на текущий тираж.

        elseif: $parseTree._bingo
            a: Каждое воскресенье в 8:20 на телеканале НТВ транслируются лотереи Русское лото, Золотая подкова, Жилищная лотерея, Бинго-75 и 6 из 36 в телепередаче "У нас выигрывают" (время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой). Невозможно транслировать розыгрыш в прямом эфире для каждого часового пояса в одно время отдельно (передачу хотят посмотреть и жители дальних регионов, у них она должна быть также показана в 8:20), поэтому съемки программы проводятся в субботу вечером после закрытия продаж на текущий тираж.

        elseif: $parseTree._6of36
            a: Каждое воскресенье в 8:20 на телеканале НТВ транслируются лотереи Русское лото, Золотая подкова, Жилищная лотерея, Бинго-75 и 6 из 36 в телепередаче "У нас выигрывают" (время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой). Невозможно транслировать розыгрыш в прямом эфире для каждого часового пояса в одно время отдельно (передачу хотят посмотреть и жители дальних регионов, у них она должна быть также показана в 8:20), поэтому съемки программы проводятся в субботу вечером после закрытия продаж на текущий тираж.

        elseif: $parseTree._6of45
            script: Webim.switch();
        elseif: $parseTree._matchball
            script: Webim.switch();
        elseif: $parseTree._5of36
            script: Webim.switch();
        elseif: $parseTree._4of20
            script: Webim.switch();
        elseif: $parseTree._zodiak
            script: Webim.switch();
        elseif: $parseTree._rapido
            script: Webim.switch();
        elseif: $parseTree._rapido20
            script: Webim.switch();
        elseif: $parseTree._12of24
            script: Webim.switch();
        elseif: $parseTree._duel
            script: Webim.switch();
        elseif: $parseTree._plusJoker
            script: Webim.switch();
        elseif: $parseTree._top3
            script: Webim.switch();
        elseif: $parseTree._keno
            script: Webim.switch();
        elseif: $parseTree._7of49
            script: Webim.switch();
        else:
            a: Какая лотерея Вас интересует?


        state: WhatShowYouNeed
            q: * (@RL/$goldenShoe/$housingLottery/$bingo/$6of36/$6of45/$matchball/$5of36/$4of20/$zodiak/$rapido/$rapido20/$12of24/$duel/$plusJoker/$top3/$keno/$7of49) *
            if: $parseTree._RL
                a: Каждое воскресенье в 8:20 на телеканале НТВ транслируются лотереи Русское лото, Золотая подкова, Жилищная лотерея, Бинго-75 и 6 из 36 в телепередаче "У нас выигрывают" (время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой). Невозможно транслировать розыгрыш в прямом эфире для каждого часового пояса в одно время отдельно (передачу хотят посмотреть и жители дальних регионов, у них она должна быть также показана в 8:20), поэтому съемки программы проводятся в субботу вечером после закрытия продаж на текущий тираж.

            elseif: $parseTree._goldenShoe
                a: Каждое воскресенье в 8:20 на телеканале НТВ транслируются лотереи Русское лото, Золотая подкова, Жилищная лотерея, Бинго-75 и 6 из 36 в телепередаче "У нас выигрывают" (время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой). Невозможно транслировать розыгрыш в прямом эфире для каждого часового пояса в одно время отдельно (передачу хотят посмотреть и жители дальних регионов, у них она должна быть также показана в 8:20), поэтому съемки программы проводятся в субботу вечером после закрытия продаж на текущий тираж.

            elseif: $parseTree._housingLottery
                a: Каждое воскресенье в 8:20 на телеканале НТВ транслируются лотереи Русское лото, Золотая подкова, Жилищная лотерея, Бинго-75 и 6 из 36 в телепередаче "У нас выигрывают" (время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой). Невозможно транслировать розыгрыш в прямом эфире для каждого часового пояса в одно время отдельно (передачу хотят посмотреть и жители дальних регионов, у них она должна быть также показана в 8:20), поэтому съемки программы проводятся в субботу вечером после закрытия продаж на текущий тираж.

            elseif: $parseTree._bingo
                a: Каждое воскресенье в 8:20 на телеканале НТВ транслируются лотереи Русское лото, Золотая подкова, Жилищная лотерея, Бинго-75 и 6 из 36 в телепередаче "У нас выигрывают" (время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой). Невозможно транслировать розыгрыш в прямом эфире для каждого часового пояса в одно время отдельно (передачу хотят посмотреть и жители дальних регионов, у них она должна быть также показана в 8:20), поэтому съемки программы проводятся в субботу вечером после закрытия продаж на текущий тираж.

            elseif: $parseTree._6of36
                a: Каждое воскресенье в 8:20 на телеканале НТВ транслируются лотереи Русское лото, Золотая подкова, Жилищная лотерея, Бинго-75 и 6 из 36 в телепередаче "У нас выигрывают" (время в Вашем регионе может отличаться от указанного. Следите за ТВ-программой). Невозможно транслировать розыгрыш в прямом эфире для каждого часового пояса в одно время отдельно (передачу хотят посмотреть и жители дальних регионов, у них она должна быть также показана в 8:20), поэтому съемки программы проводятся в субботу вечером после закрытия продаж на текущий тираж.

            elseif: $parseTree._6of45
                script: Webim.switch();
            elseif: $parseTree._matchball
                script: Webim.switch();
            elseif: $parseTree._5of36
                script: Webim.switch();
            elseif: $parseTree._4of20
                script: Webim.switch();
            elseif: $parseTree._zodiak
                script: Webim.switch();
            elseif: $parseTree._rapido
                script: Webim.switch();
            elseif: $parseTree._rapido20
                script: Webim.switch();
            elseif: $parseTree._12of24
                script: Webim.switch();
            elseif: $parseTree._duel
                script: Webim.switch();
            elseif: $parseTree._plusJoker
                script: Webim.switch();
            elseif: $parseTree._top3
                script: Webim.switch();
            elseif: $parseTree._keno
                script: Webim.switch();
            elseif: $parseTree._7of49
                script: Webim.switch();



    state: WhenWillNewYearEdition
        # Когда трансляция Новогоднего тиража?
        q!: * {($when/какого числа/какова числа/в какое время/~какой ~канал) * ($lotteryShow/~передача/телеперед*/~выпуск/телевыпуск*/~эфир/телеэфир*) * $newYear * [$bingoLotteries]} *
        q!: * [$bingoLotteries] * ($when/какого числа/какова числа/в какое время/~какой ~канал) * (пройдет/состои*/начне*) * $newYear * [$bingoLotteries] *

        q!: * {($when/какого числа/какова числа/в какое время/~какой ~канал) * ($lotteryShow/~передача/телеперед*/~выпуск/телевыпуск*/~эфир/телеэфир*/начне*) * $1369} *

        q!: * {($when/какого числа/какова числа/в какое время) * $newYear * нтв*} *

        q!: * {(в какое время/во $skolko/воскольк*/~какой ~канал) * ($bingoLotteries/~передача/телеперед*/~выпуск/телевыпуск*/~эфир/телеэфир*/$lotteryShow) * $januaryFirst} *

        intent!: /Lottery/WhenWillNewYearEdition
        #a: Телетрансляции розыгрышей лотерей «Русское лото», «Золотая подкова», «Жилищная лотерея», «Бинго-75» и «6 из 36» проводятся каждое воскресенье в 8:20 на телеканале НТВ, в телепередаче «У нас выигрывают». Время трансляций в Вашем регионе может отличаться от указанного. Следите за ТВ-программой.
        if: checkIfCurrentDateIsBefore("2021-01-03")
            if: $parseTree._RL || $parseTree._1369
                a: Трансляция новогоднего 1369 тиража лотереи «Русское лото» будет проходить на НТВ в прямом эфире для всей России 1 января 2021 года в 15:30 мск.
            else:
                a: Трансляция новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотая подкова», «Бинго-75» состоится 01.01.2021 в 8:20 мск на НТВ. Трансляция новогоднего тиража лотереи «Русское лото» состоится в прямом эфире 1 января 2021 года в 15:30 мск.
        else:
            script: Webim.switch();



    state: WillNewYearEditionBeLiveOrNot
        # Прямой или непрямой эфир тиража 1369
        q!: * {(~эфир/телеэфир*/~трансляция/телетрансляц*/~шоу/телешоу/~передача/телеперед*/~выпуск/телевыпуск*) * (~прямой/$ne ~прямой/~непрямой) * ($newYear/$1369)} *

        q!: * {(~эфир/телеэфир*/~трансляция/телетрансляц*/~шоу/телешоу/~передача/телеперед*/~выпуск/телевыпуск*) * (~прямой/$ne ~прямой/~непрямой) * @RL * $januaryFirst} *

        intent!: /Lottery/WillNewYearEditionBeLiveOrNot
        if: checkIfCurrentDateIsBefore("2021-01-09")
            a: Трансляция новогоднего 1369 тиража лотереи «Русское лото» будет проходить на НТВ в прямом эфире для всей России 1 января 2021 года в 15:30 мск.
        else:
            script: Webim.switch();


    state: MoscowTimeForNewYearEditionOrNot
        # время новогоднего розыгрыша московское или нет
        q!: * {($newYear/$1369) * (по какому времени)} *
        q!: * {(~эфир/телеэфир*/~трансляция/телетрансляц*/~шоу/телешоу/~передача/телеперед*/~выпуск/телевыпуск*) * (по (моск*/местн*/мск/какому) ~время)} *
        q!: * {~время * (моск*/мск/~местный) * ($newYear/$1369)} *

        intent!: /Lottery/MoscowTimeForNewYearEditionOrNot
        if: checkIfCurrentDateIsBefore("2021-01-09")
            a: Трансляция новогоднего 1369 тиража лотереи «Русское лото» будет проходить на НТВ в прямом эфире для всей России 1 января 2021 года в 15:30 мск.
        else:
            script: Webim.switch();


    state: WhenWillNewYearEveEdition
        # Когда будут предновогодние тиражи
        q!: * {($when/какого числа/в какое время) * ($lotteryShow/~передача/телеперед*/~выпуск/телевыпуск*/~эфир/телеэфир*) * $newYearEve * [$bingoLotteries]} *
        q!: * [$bingoLotteries] * ($when/какого числа/в какое время) * (пройдет/состои*/будет/будут) * $newYearEve * [$bingoLotteries] *

        q!: * {($when/какого числа/в какое время) * ($lotteryShow/~передача/телеперед*/~выпуск/телевыпуск*/~эфир/телеэфир*) * (500/278/422/1368)} *

        q!: * {(в какое время/во $skolko/воскольк*) * ($bingoLotteries/~передача/телеперед*/~выпуск/телевыпуск*/~эфир/телеэфир*$lotteryShow) * (26 декабр*/27 декабр*/25 декабр*/26 12/27 12/25 12)} *

        q!: * {(26 декабр*/27 декабр*/25 декабр*/26 12/27 12/25 12) * (будет/небудет/нибудет/состоит*/несостоит*/нисостоит*) * ($lotteryShow/~передача/телеперед*/~выпуск/телевыпуск*/~эфир/телеэфир*/$bingoLotteries/$newYearEve/500/278/422/1368)} *

        q!: * {($newYearEve/500/278/422/1368) * (перенесли/перенесен)} *
        q!: * {(делс*/делас*/делис*/подевал*) * ($newYearEve/500/278/422/1368) * [$ticketRun]} *
        q!: * {(делс*/делас*/делис*/подевал*) * ($ticketRun * (26 декабр*/27 декабр*/25 декабр*/26 12/27 12/25 12))} *

        intent!: /Lottery/WhenWillNewYearEveEdition
        if: checkIfCurrentDateIsBefore("2020-12-27 12:00")
            a: Трансляция предновогодних тиражей Бинго лотерей была перенесена. Трансляцию тиражей «Русского лото», «Жилищной лотереи», «6 из 36», «Золотая подкова», «Бинго-75» смотрите 25.12.2020 в 23:30 по местному времени. Ознакомьтесь, пожалуйста, с информацией на нашем сайте: https://www.stoloto.ru/press/news/2020/12/20/Izmeneniya-grafika-translyacij-TV-loterej
        else:
            script: Webim.switch();








    #state: WhatAreThePrizesOfTheNewYearEdition
        # Что будет разыграно в тираже 1316?
        #q!: * ($comWhat/$billion) $beFutSgPl3 (разыгран*/разыгрывать) * ($newYear/1316) *
        #q!: * {($comWhat разыгрывает*) * ($newYear/1316)} *
        #q!: * {($comWhat разыгрывают*) * ($newYear/1316)} *
        #q!: * {($comWhat могу выиграть) * ($newYear/1316)} *
        #q!: * {($comWhat $possiblePredic выиграть) * ($newYear/1316)} *
        #q!: * {~какой приз* * ($newYear/1316)} *
        #q!: * {(приз* ~фонд) * ($newYear/1316)} *
        #q!: * {(о призах) * ($newYear/1316)} *
        #intent!: /Lottery/WhatAreThePrizesOfTheNewYearEdition
        #a: В новогоднем тираже «Русского лото» будет гарантированно разыгран 1 миллиард рублей. Вы выигрываете Миллиард, если у Вас на пятнадцатом ходу все пятнадцать чисел одного из двух игровых полей билета (верхнего или нижнего) совпадут с номерами бочонков, извлеченных из мешка. Если Джекпот не будет разыгран, то Миллиард выиграет билет или билеты, в которых раньше других совпадут все 15 чисел в одном из полей. В прошлом году миллиард разделили двое победителей. Так что место первого лотерейного миллиардера пока свободно! Также в тираже разыгрывается от 100 призов по 1 миллиону рублей и тысячи денежных призов, останется 2 бочонка – выигрывает каждый второй билет!


    state: WhatDoesItMeanEverySecondWins
        # Что значит Выигрывает каждый второй билет?
        q!: * {(выигрывает/выигр*/побеж*/побед*/побеждает) * каждый * (второй/2 ой/2ой)} *
        q!: * каждый (второй/2 ой/2ой) $ticket *

        intent!: /Lottery/WhatDoesItMeanEverySecondWins
        if: checkIfCurrentDateIsBefore("2021-01-11")
            a: Фраза «Выигрывает каждый второй билет!» означает, что вероятность совпадения 30 чисел билета до 88-го хода (при общем количестве чисел в билете, равном 30, и общем количестве бочонков в мешке, равном 90) включительно лежит в диапазоне от 1 к 2,37 до 1 к 2,25.
        else:
            script: Webim.switch();



    #state: WhoCanWinABillion
        # Кто может выиграть миллиард?
        #q!: * кто * $winInf [1/2] $billion *
        #q!: * кто * $billion * $winInf *
        #q!: * {((один/1) (человек/участник)) * $billion * $winInf} *
        #q!: * {((два/2) (человека/участника)) * $billion * $winInf} *
        #q!: * {(только один/два могут/двое могут) * $billion * $winInf} *
        #q!: * {((один/1) (человек/участник)) * $billion * выиграет} *
        #q!: * {((два/2) (человека/участника)) * $billion * выиграют} *
        #q!: * {($skolko (человек/участников)) * $billion * $winInf} *
        #q!: * {(несколько (человек/участников)) * $billion * $winInf} *
        #q!: * {($skolko (человек/участников)) * $billion * выиграют} *
        #q!: * {(несколько (человек/участников)) * $billion * выиграют} *
        #q!: * {(только один/два могут/двое могут/несколько могут) * $billion * $winInf} *
        #q!: * {($skolko победителей) * [розыгрыш*] * $billion} *
        #q!: * {(несколько победителей) * [розыгрыш*] * $billion} *
        #q!: * {(один победитель) * розыгрыш* * $billion} *
        #q!: * {(двое победителей) * розыгрыш* * $billion} *
        #q!: * $skolko $ticket (может/могут) $winInf $billion *
        #intent!: /Lottery/WhoCanWinABillion
        #a: Миллиард выиграет билет или билеты, в которых раньше других совпадут все 15 чисел в одном из полей. Если победителей в этом туре будет несколько, то миллиард будет поделен на количество победителей.

    #state: WhatIsBillion
        # Что значит 1 млрд
        #q!: * $comWhat * (означает/значит) * $billion *
        #q!: * $comWhat * {$billion * ((будет/будит) разыгран)} *
        #q!: * $jackpot * $billion *
        #a: «1 000 000 000 ₽» указывает на минимальный гарантированный размер средств призового фонда, разыгрываемого в категории «Джекпот» в тираже № 1358 (дата розыгрыша: 17.10.2020.)

    #state: WillBeUpToMove88
        # Розыгрыш будет до 88 хода
        #q!: * {($lotteryShow/$ticketRun) * [$beFutSgPl3] * (88 ход*)} *
        #q!: * ($howMuch/$howMuch2) * {(ход*) * $beFutSgPl3} * [$lotteryShow] * $birthdayRL * [$ticketRun] *
        #q!: * $if * $nobody * ($ne/не*/ни*) * $jackpot *
        #a: Розыгрыш до 88-го хода включительно будет проведен, если на начало тиража № 1358 (розыгрыш 17.10.2020) будет накоплен суперприз в размере от 150 000 000 рублей или более, который не был разыгран в тираже ранее, и при розыгрыше не будет выявлен победитель в категории «Джекпот».

    #state: Car
        # Я участвую в акции с автомобилем (авто/автомобиль)
        #q!: * $when * [$beFutSgPl3] * ~розыгрыш * (авто*/тачк*) *
        #q!: * (~акция/акции) * (авто*/тачк*) *
        #a: На сайте www.stoloto.ru 19.10.2020 будут опубликованы новости о результатах Розыгрыша с указанием данных о победителе в виде зашифрованного номера телефона и региона.  Подробные условия акции здесь: https://www.stoloto.ru/files/documents/acton_26_y_RL.pdf


    #state: HowBillionWillBePlayed
        # Как будет разыгран 1 млрд
        #q!: * $how * {$billion * ((будет/будит) разыгран)} *
        #q!: * $billion * $how * ((будет/будит) разыгран) *
        #q!: * $how * {$billion * ((будет*/будит*) разыгрыват*)} *
        #q!: * $billion * $how * ((будет*/будит*) разыгрыват*) *
        #q!: * $how * {$billion * разыграете} *
        #q!: * $billion * $how * разыграете *
        #q!: * (правда/реально/серьезно) * {$billion * разыграете} *
        #intent!: /Lottery/HowBillionWillBePlayed
        #a: В новогоднем тираже «Русского лото» будет гарантированно разыгран миллиард рублей. Миллиард выиграет билет или билеты, в которых раньше других совпадут все 15 чисел в одном из полей. В прошлом году миллиард разделили двое победителей. Так что место первого лотерейного миллиардера пока свободно! Также в розыгрыше от 100 призов по 1 миллиону рублей и тысячи денежных призов, останется 2 бочонка - выигрывает каждый второй билет.


    state: HowBillionsWillBePlayed
        # Как будут разыграны 2 млрд
        q!: * $how * {$billion * ((будет*/будут/будит*) (разыгран*/распределен*)/(разыгран*/распределен*) (будет*/будут/будит*))} *
        q!: * $billion * $how * ((будет/будут/будит) (разыгран*/распределен*)/(разыгран*/распределен*) (будет*/будут/будит*)) *
        q!: * $how * {$billion * ((будет*/будут/будит*) (разыгрыва*/распределя*)/(разыгрыва*/распределя*) (будет*/будут/будит*))} *
        q!: * $billion * $how * ((будет*/будут/будит*) (разыгрыва*/распределя*)/(разыгрыва*/распределя*) (будет*/будут/будит*)) *
        q!: * $how * {$billion * (разыграете/распределите/разыграют/распределят)} *
        q!: * $billion * $how * (разыграете/распределите/разыграют/распределят) *

        q!: * (правда/реально/серьезно/в натуре/на самом деле/$ne (врете/обманываете)) * {$billion * (разыграете/распределите/разыграют/распределят)} *

        q!: * {(разыгрываем/разыграем/разыграете/разыграют/распределяем/распределим/распределите/распределят) * ($billion и бол*/(более/болше/больше) [$oneWord] $billion)} *

        q!: * $fromWhere * (взяли/возьмет*/возьмут*/возьмуц*/возмуц*/сформирует*/сформируец*) * (один/1/дополнительн*/другой/$comTwo) $billion *
        q!: * (один/1/дополнительн*/другой/$comTwo) $billion * $fromWhere * (взяли/возьмет*/возьмут*/возьмуц*/возмуц*/сформирует*/сформируец*) *
        q!: * $comWhere * (возьмет*/возьмут*/возьмуц*/возмуц*) * (один/1/дополнительн*/другой/$comTwo) $billion *
        q!: * (один/1/дополнительн*/другой/$comTwo) $billion * $comWhere * (возьмет*/возьмут*/возьмуц*/возмуц*) *

        q!: * {($how/за счет чего) * (сформирует*/сформируец*/буд* сформирован*) * (([еще] (один/1)/дополнительн*/другой/$comTwo) $billion)} *

        q!: * ((в ~случай/при) ~отсутствие $prize) * (в первой категории/$jackpot) *
        q!: * $if * $nobody * ($ne/не*/ни*) * $jackpot *

        q!: * (в каком случае/при каких условиях) * принудительн* розыгрыш* *
        q!: * (в каком случае/при каких условиях) * принудительн* * (разыграете/разыграют/распределите/распределят/буд* (разыгран*/распределен*)) *

        intent!: /Lottery/HowBillionsWillBePlayed
        if: checkIfCurrentDateIsBefore("2021-01-09")
            a: Фраза «Разыгрываем 2 миллиарда и более» обозначает общий размер средств, которые могут выиграть участники тиража № 1369. В случае отсутствия выигрышей в первой категории (Джекпот) тиража 1369 будет проведен принудительный розыгрыш всей суммы накопленного суперприза, перешедшего из тиража № 1368, путем его распределения между нижестоящими категориями.
        else:
            script: Webim.switch();


    state: IfJackpotIsPlayedBeforeNY
        # если джекпот буден разыгран до нового года
        q!: * $if * $jackpot * (до ($newYear/$1369/$januaryFirst/январ*)) *
        q!: * $if * {(кто-то/кто то/ктото) * $jackpot * 1368} *
        q!: * $if * $jackpot буд* разыгран* *
        q!: * $comWhat так* * $jackpot *
        intent!: /Lottery/IfJackpotIsPlayedBeforeNY
        if: checkIfCurrentDateIsBefore("2021-01-03")
            a: Итоги голосования не применяются, если будет разыгран приз в категории «Джекпот». Джекпот – это ситуация, когда на пятнадцатом ходу все пятнадцать чисел одного из двух игровых полей билета (верхнего или нижнего) совпадут с выпавшими в процессе розыгрыша числами.
        else:
            script: Webim.switch();


    state: WhereToFindVotingResults
        # Где посмотреть результаты народного голосования
        q!: $result * голосован*
        q!: * $comNo $result * голосован* *
        q!: * {($when/$comWhere) * [$seeInf] * $result * голосован*} *
        q!: * $how $seeInf $result * голосован* *
        q!: * {($tellImp/известны/*интерес*/$seeInf/$findOutInf/опублику*/опубликов*/объяв*) * $result * голосован*} *
        q!: * {($seeInf/$findOutInf) голосован*} *
        q!: * {((есть ли/какие) $result) * голосован*} *
        q!: * $comWhat ($with/$about) * голосован* *
        q!: * ($how/за $comWhat/какой вариант) * проголосовали *
        q!: * какой вариант * выбрали * зрители *
        q!: * $comWhat * (решили/выбрали) * зрители *
        intent!: /Lottery/WhereToFindVotingResults
        if: checkIfCurrentDateIsBefore("2021-01-11")
            a: Результаты будут объявлены 1 января в прямом эфире новогоднего розыгрыша «Русского лото» на НТВ, а также опубликованы на выберимиллиард.рф и stoloto.ru
        else:
            script: Webim.switch();











    #state: WhyThePrizeFundIsTwoBillion
        # Почему призовой фонд не 1 млрд, а 2 млрд
        #q!: * {[$why] * (призов* фонд*) * ($comTwo $billion)} *
        #q!: * {[$why] * (призов* фонд*) * (больше [чем] (~один/1) $billion)} *
        #q!: * {($comTwo $billion) $or (один/1)} *
        #q!: * {((один/1) $billion) $or $comTwo} *
        #q!: * {$why * разыгрывает* * ($comTwo $billion)} *
        #q!: * {$why * разыграете * ($comTwo $billion)} *
        #q!: * {$why * разыгрывает* * (больше [чем] (~один/1) $billion)} *
        #q!: * {$why * разыграете * (больше [чем] (~один/1) $billion)} *
        #intent!: /Lottery/WhyThePrizeFundIsTwoBillion
        #a: 2 млрд (2,5; 3 млрд) - это призовой фонд тиража 1316, т.е. сумма, полученная от продаж билетов на этот тираж. Из этой суммы будут выплачены выигрыши победителям данного тиража. А 1 миллиард будет сформирован из накопленного Джекпота и приза второго тура, сумма которого будет равна той сумме, которой недостаточно до миллиарда (например, Джекпот к началу новогоднего тиража 800 млн, значит приз второго тура будет 200 млн, итого выигрыш 1 миллиард).


    #state: HowWillAnotherBillionBeFormed
        # Откуда вы возьмете 1 миллиард?
        #q!: * $fromWhere * (возьмет*/сформирует*) * (один/1/дополнительн*/другой) $billion *
        #q!: * (один/1/дополнительн*/другой) $billion * $fromWhere * (возьмет*/сформирует*) *
        #q!: * $comWhere * возьмет* * (один/1/дополнительн*/другой) $billion *
        #q!: * (один/1/дополнительн*/другой) $billion * $comWhere * возьмет* *
        #q!: * ($how/за счет чего) сформирует* $billion *
        #q!: * {$how * сформирует* * (([еще] (один/1)/дополнительн*/другой) $billion)} *
        #q!: * {$how * ((будет/будит) сформирован) * (([еще] (один/1)/дополнительн*/другой) $billion)} *
        #q!: * {(за счет чего) * сформирует* * (([еще] (один/1)/дополнительн*/другой) $billion)} *
        #q!: * {(за счет чего) * ((будет/будит) сформирован) * (([еще] (один/1)/дополнительн*/другой) $billion)} *
        #intent!: /Lottery/HowWillAnotherBillionBeFormed
        #a: Миллиард будет сформирован за счет накопленного джекпота + приза второго тура.


    #state: WhyAreYouClaimingThatBillionWillBePlayed
        # Почему вы утверждаете, что 1 миллиард будет точно разыгран?
        #q!: * $billion (будет/будит) точно разыгран *
        #q!: * {$why * уверены * ($billion (будет/будит) разыгран)} *
        #q!: * {~уверенность * ($billion (будет/будит) разыгран)} *
        #q!: * {$why * уверены * (разыграете $billion)} *
        #q!: * {~уверенность * (разыграете $billion)} *
        #q!: * (если/вдруг) $billion ($ne (будет/будит)/небудет/небудит/нибудет/нибудит) разыгран * (джек пота/джек-пота/джекпота/джэк пота/джэк-пота/джэкпота) *
        #q!: * (если/вдруг) $billion ($ne (разыграют)/неразыграют/ниразыграют) * (джек пота/джек-пота/джекпота/джэк пота/джэк-пота/джэкпота) *
        #intent!: /Lottery/WhyAreYouClaimingThatBillionWillBePlayed
        #a: Если миллиард не будет разыгран в ходе розыгрыша Джекпота, то второй тур не остановится, пока не будет определен победитель (пока у кого-то из участников не закроется полностью одно из полей раньше других).


    #state: WhyWasOnlyOneBillionPlayed
        # Почему был разыгран 1 млрд., а обещали 2 млрд.
        #q!: * {$why * разыгран * ($only (1/один) $billion)} * 
        #q!: * {$why * разыграли * ($only (1/один) $billion)} * 
        #q!: * (разыгран/разыграли) * [$only] (1/один) $billion * (обещал*/обещан*) * (2/два) *
        #q!: * (разыгран/разыграли) * [$only] (1/один) (а/но/хотя) (обещал*/обещан*) * (2/два) $billion *
        #q!: * (обещал*/обещан*) * (2/два) $billion * (разыгран/разыграли) * [$only] (1/один) *
        #q!: * (обещал*/обещан*) * (2/два) (а/но) (разыгран/разыграли) * [$only] (1/один) $billion *
        #q!: * ($ne разыграл*/неразыграл*/$ne разыгран*/неразыгран*) * второй $billion *
        #q!: * второй $billion * ($ne разыграл*/неразыграл*/$ne разыгран*/неразыгран*) *
        #q!: * куда {дел* второй $billion} *
        #intent!: /Lottery/WhyWasOnlyOneBillionPlayed
        #a: 2 млрд (2,5; 3 млрд) - это призовой фонд тиража 1316, т.е. сумма, полученная от продаж билетов на этот тираж. Из этой суммы будут выплачены выигрыши победителям данного тиража. А 1 миллиард  сформирован из накопленного Джекпота и приза второго тура, сумма которого равна той сумме, которой недостаточно до миллиарда.


    state: IsItAPrivateLotteryOrNot
        # Это частная лотерея или государственная?
        q!: * {частн* $or государствен*} (игра/$lottery/контора) *
        q!: * (частн*/государствен*/$ne государствен*/негосударствен*) (игра/$lottery/контора) $or *
        q!: * {частн* $or госигра} *
        q!: * {частн* $or гослотерея} *
        q!: * (игра/$lottery/контора) [эта/ваша] {частн* $or государствен*} *
        q!: * (игра/$lottery/контора) [эта/ваша] {частн* $or $comNo} *
        q!: * (игра/$lottery/контора) [эта/ваша] {государствен* $or $comNo} *
        q!: * (врете/правда) * это государствен* (игра/$lottery/контора) *
        q!: [$helloAll] [$beginningWords] [$stoloto] это (частн*/государствен*/$ne государствен*/негосударствен*) (игра/$lottery) [$or $comNo]
        q!: * руководит (государств*/частн*) *
        intent!: /Lottery/IsItAPrivateLotteryOrNot
        a: Акционерное общество «Технологическая Компания «Центр» - частная компания-распространитель государственных лотерей. Наша компания объединяет все лотереи страны, организаторы которых - Министерство финансов РФ и Министерство спорта РФ. В правилах к каждой лотерее есть информация об ее организаторе. Также вся информация представлена в этом разделе: http://www.stoloto.ru/legal



































