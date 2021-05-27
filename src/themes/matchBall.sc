theme: /MatchBall


    state: WhereMyMatchBallTicketsDisappeared
        q!: * {$comNo * ($ticket/$lottery) * $matchball} *
        q!: * {$disappearPastPres * ($ticket/$lottery) * $matchball} *
        q!: * (куда/где) {$disappearPastPres * $ticket * $matchball} *
        q!: * {$disappearPastPres * $matchball} * (дальше/делать/~действие) *
        q!: * $comWhere * {$ticket * $matchball} *
        q!: * $comWhat * (случ*/произ*/проис*) * $matchball *
        q!: * {$problem * ~отображение * ($ticket * $matchball)} *
        q!: * {($ticket * $matchball) * ($ne (появил*/появлял*/появляет*/появляют*)/непоявил*/непоявлял*/непоявляет*/непоявляют*/нипоявил*/нипоявлял*/нипоявляет*/нипоявляют*/$displayPresPl3Ne/$displayPresSg3Ne/$displayPastNe)} *
        q!: * $waitInf * $ticket * (появил*/отобразил*/отразил*) * $matchball *
        q!: * $waitInf * $ticket * $matchball * (появил*/отобразил*/отразил*) *
        q!: * $matchball * $waitInf * $ticket * (появил*/отобразил*/отразил*) *
        q!: * $matchball * ($when/$howLong/долго) * {$ticket * (отражен/отражена/отражены/отображен/отображена/отображены/$displayFut3)} *
        q!: * ($when/$howLong/долго) * {($ticket * $matchball) * (отражен/отражена/отражены/отображен/отображена/отображены/$displayFut3)} *
        q!: * ($when/$howLong/долго) * {($ticket) * (отражен/отражена/отражены/отображен/отображена/отображены/$displayFut3)} * $matchball *
        q!: * [$matchball] * ($ticket * [$matchball]) * ($when/$howLong) * (отражен/отражена/отражены/отображен/отображена/отображены/$displayFut3) * [$matchball] *
        q!: * [$matchball] * $ticket * $matchball * (появил*/отображают*/отражают*/отобразил*/отразил*/отображены/отражены) (кроме/помимо/исключая) * [$matchball] *
        q!: * $matchball * (в [$comMy] $account) $ne одного $ticket *
        q!: * (в [$comMy] $account) $ne одного $ticket * $matchball *
        q!: * $matchball * $ne $ticketAll (в [$comMy] $account) *
        q!: * $ne $ticketAll (в [$comMy] $account) * $matchball *
        q!: * $matchball * {$comNo [$again] [$comMy] [куплен*/оплачен*/никак*] $ticket (в [$comMy] $account)} *
        q!: * {$comNo [$again] [$comMy] [куплен*/оплачен*/никак*] $ticket (в [$comMy] $account)} * $matchball *
        q!: * {(в [$comMy] $account) отсутств* ([куплен*/оплачен*/приобретен*/$comMy/$Number] $ticket) * $matchball} *
        q!: * {($ticket (все равно/там/[у меня] так и) $comNo) * $matchball} *
        q!: * $matchball * {([эт*] $ticket) ($comNo [там])} (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах/[$comMy] билеты/[$comMy] билетов/личк*) *
        q!: * {([эт*] $ticket) ($comNo [там])} (в/во) [раздел*/графе/вкладке] (куплен*/оплачен*/приобретен*/[$comMy] билетах/[$comMy] билеты/[$comMy] билетов/личк*) * $matchball *


        q!: * {($prizeAndSumAndWinTicket * $matchball/$matchball * $prizeAndSumAndWinTicket) * $ticket * $disappearPastPres} *
        q!: * [сообщен*] * {$prizeAndSumAndWinTicket * $matchball * $ticket} * $disappearPastPres *

        script: Webim.switch();
