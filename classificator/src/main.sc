theme: /

    state: OutOfScope
        eg!: Account.OutOfScope
        go!: /Switch

    state: Time
        eg!: Account.Time
        a: Вас интересует внутренний или межбанковский перевод?

        state: OtherBank
            eg!: Account.Time.OtherBank
            a: Переводы в сторонние Банки осуществляются только в рабочие дни, срок исполнения стандартный, составляет от 1 до 3 рабочих дней.
                При переводе со счёта другого банка срок осуществления перевода необходимо уточнить в Банке, через который был совершён перевод.

        state: Internal
            eg!: Account.Time.Internal
            a: Если запрос на перевод внутри своих счетов денежных средств поступил с понедельника по пятницу до 20:00 через личный кабинет, то данный запрос исполняется текущей датой. Если запрос поступил после указанного времени, запрос исполняется на следующий рабочий день.
                При переводе между своими счетами в разных валютах, конверсия до 16:00, в пятницу до 15:30 тек. днем, после этого времени — следующий рабочий день.

    state: Commission
        eg!: Account.Commission
        a: Вас интересует перевод на счет Юникредит или в другой банк?

        state: OtherBank
            eg!: Account.Commission.OtherBank
            a: Комиссия будет зависеть от способа перевода, выбранного Вами. Перевод с карты на карту по номеру карты будет облагаться комиссией 1,2% от суммы + 35 руб. Перевод со счёта или карты по реквизитам карты в стороннем банке (реквизиты, которые Вам потребуются — это номер счёта карты, ваше ФИО, БИК Банка, в котором открыта Ваша карта) через интернет-Банк будет облагаться комиссией 1% мин. 50 руб., макс. 1500 руб., через отделение банка — 1,5%, мин. 100 руб., макс. 2000 руб. Если речь идет о валютных переводах, через интернет-Банк сумма облагается комиссией 1%, мин. 25 долл. США, макс. 200 долл. США, через отделение банка — 1,5%, мин. 30 долл. США, макс. 250 долл. США.

        state: Internal
            eg!: Account.Commission.Internal
            a: За переводы внутри банка комиссия не взимается.
                При переводе со счёта другого банка комиссия зависит от тарифов Банка отправителя, с нашей стороны за входящий перевод комиссия не взимается.

    state: GiveMoneyBack
        eg!: Account.GiveMoneyBack
        a: Если Вы произвели перевод на счёт поставщика услуг, Вы можете обратиться к нему с заявлением о возврате оплаты. В случае необходимости, ЮниКредит Банк может предоставить выписку об операции.
            В противном случае, Вам необходимо обратиться в отделение Банка с паспортом и написать заявление о несогласии с операцией.

    state: CantDoTransfer
        eg!: Account.CantDoTransfer
        a: Так может произойти в случае, если Вы недавно вносили средства через банкомат или переводили по номеру карты из другого банка. Средства отображаются в доступном остатке моментально, но для переводов и прочих операций они станут доступны, когда поступят на счёт карты. При внесении денежных средств через банкомат на карту до 16:00 (в пятницу и предпраздничные дни до 15:20) сумма становится доступна для перевода на следующий рабочий день. При внесении денежных средств через банкомат на карту после 16:00 (в пятницу и предпраздничные дни после 15:20) сумма становится доступна для перевода через рабочий день. При переводах C2C сроки зависят от Банка-отправителя, как правило, занимают до 3 рабочих дней.

    state: FailTransfer
        eg!: Account.FailTransfer
        a: Если запрос на перевод внутри своих счетов денежных средств поступил с понедельника по пятницу до 20:00 через личный кабинет, то данный запрос исполняется текущей датой. Если запрос поступил после указанного времени, запрос исполняется на следующий рабочий день. 
            Переводы в сторонние Банки осуществляются только в рабочие дни, срок исполнения стандартный, составляет от 1 до 3 рабочих дней.
            При переводе со счёта другого банка срок осуществления перевода необходимо уточнить в Банке, через который был совершён перевод.
            Если прошло больше времени, то для выяснения причин необходима голосовая идентификация. Обратитесь, пожалуйста, по телефону горячей линии 8-800-700-10-20. Провести идентификацию в чате невозможно.

    state: TransferRefusal
        eg!: Account.TransferRefusal
        a: Для выяснения причин необходима голосовая идентификация. Обратитесь, пожалуйста, по телефону горячей линии 8-800-700-10-20.

    state: Limit
        eg!: Account.Limit 
        a: Лимиты на совершение переводов по номеру карты: одна операция не более 100 000 руб., в сутки — 300 000 руб., за 4 суток — 540 000 руб., в месяц — 1 500 000 руб. Ограничений на перевод по номеру счёта нет, ограничена сумма единовременной операции — 300 000 долларов. Лимита на перевод между собственными счетами нет. Если вы не превысили лимит, но перевод совершить не удается, возможно, вы недавно пополняли карту и средства ещё не доступны для перевода.
        
    state: Vocabulary1
        q!: * полютбюро *
        a: Попали в стейт политбюро
        
    state: Vocabulary2
        q!: * одежда *
        a: Попали в стейт одежда

    state: CatchAll || noContext = true
        q!: *
        a: Я не понял