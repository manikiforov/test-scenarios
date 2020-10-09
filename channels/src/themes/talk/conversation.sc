theme: /Conversation


    state: Hello || noContext = true
        # Здравствуйте
        q!: $helloAll [уважаем*] [[служб*] [поддержк*/подержк*]/$botAll/$botName]
        q!: {$repeat<$helloAll> [$repeat<$emoji>]}
        q!: $helloAll [$botAll/$botName] [и] $with [наступ*] (нг/нов* [вас] год*/праздник*/праздничк*/рождеств*/крещ*/маслен*/днем защитника отечества/23 февр*) [$repeat<$emoji>]
        q!: {$helloAll [$youDat] [$alica/$mvideo/$operator]} [$repeat<$emoji>]
        intent!: /Hello
        script:
            $reactions.answer(ans.hello);


    state: AreYouHere || noContext = true
        # ты здесь или как
        # Вы ещё на связи?
        q!: * $youAll {[$interjections] [$nowSyns/$else] ([$ne] ($here/$onlineLoc/там/на сайте))} [или ($ne/нет/как)] [$botAll/$botName/$alica/$mvideo] [$repeat<$emoji>]
        q!: * [$ne] ($here/$onlineLoc/на сайте) $youAll [$botAll/$botName/$alica/$mvideo] [$repeat<$emoji>]
        # Вы онлайн?
        q!: [$helloAll] [$botAll/$botName/$mvideo] [$alica/ау] {[$beginningWords] [$interjections] [$kyky]} {($youAll) [$nowSyns/$still/$else] $online} [$botAll/$botName/$mvideo] [$repeat<$emoji>]
        # ты где
        q!: {[$beginningWords] [$interjections] [$kyky]} {($youAll) [$interjections] $where} [$botAll/$botName/$mvideo] [$repeat<$emoji>]
        q!: {[$beginningWords] [$interjections] [$kyky]} {есть $who [$here/на связи/там]}
        q!: * {есть $somebody [$here/на связи/там]} *
        q!: * есть ($who/$somebody) живой *
        q!: ($who/$somebody) ($here/$onlineLoc/$online) [$repeat<$emoji>]
        q!: {[$beginningWords] [$interjections] ($kyky/ку/ау/ауу/аууу*/ии/иии/ииии/иииии)}
        q!: {($allo/ау) [гараж/$alica/$operator/$botAll/$botName/$mvideo]} [$repeat<$emoji>]

        q!: {[$allo] $kyky [$repeat<$emoji>]}
        q!: (тук тук/стук стук/туктук) [$repeat<$emoji>]
        q!: [$youNom] $ne (спите/спишь/спиш) [$repeat<$emoji>]
        q!: $allo [$repeat<$emoji>]
        q!: {($alica/$botName/$mvideo) [$repeat<$emoji>]}
        q!: * [$youAll] {$canPres2 говорить} *
        intent!: /AreYouHere
        script:
            $reactions.answer(ans.hello);


    state: Bye || noContext = true
        # До свидания
        q!: {[$aha] [$goodAll] [$comThanks] $comBye [$repeat<$emoji>]} [$botAll/$botName/$mvideo]
        q!: $comThanks и $comBye [$repeat<$emoji>] [$botAll/$botName/$mvideo]
        intent!: /Bye
        script:
            $reactions.answer(ans.bye);


    state: Thanks || noContext = true
        # Спасибо
        q!: $comThanks [$comThanks] [$helloAll] [$repeat<$emoji>]
        q!: [$beginningWords] {$comThanks [$repeat<$emoji>]}
        q!: [$beginningWords] {$comThanks $goodLuck} [$repeat<$emoji>]
        q!: [$aha] $goodAll $repeat<$emoji> $comThanks $repeat<$emoji>
        q!: [$beginningWords] {[$aha] [$goodAll] $comThanks} [$sorry] [$repeat<$emoji>]
        q!: {$repeat<$goodAll> $comThanks} [$repeat<$emoji>]
        q!: [$helloAll] {[$mvideo/$alica/$botName] $comThanks [$goodAll] [$haveAGoodDay]} [$repeat<$emoji>]
        q!: {[$youNom/$mvideo/$botName] $super ($comThanks/$goodAll) [$goodAll]} [$repeat<$emoji>]
        q!: [$aha/$helloAll] {[$comNow/уже/$atLast] все $comGood [$comThanks]} *
        q!: [$aha] [вот] {[$comNow/уже/$atLast] [все] ($clear/быстро) [$comThanks]} [$repeat<$emoji>]

        q!: [$beginningWords] [$aha] $comThanks [$iSgPl] [$comNow/уже/$atLast] [все] [$comNow/уже/$atLast] [удачно/успешно] (отправил*/увидел*/решил*/сделал*/понял*/справил*/$transferPast/наладил*/разрешил*/появил*/зашел/зашл*/вошел/вошл*/$registerPast3/$seeIntoPast/выяснил*/заработал*/сработал*/вывел*/$bonusComePastPres/скачал*/оплатил*/обновилис*/кажетс* есть/перешли/успешно/нашел*/нашл*) *
        q!: [$beginningWords] [$aha] $comThanks [$iSgPl] [$comNow/уже/$atLast] [все] [$comNow/уже/$atLast] [удачно/успешно] получил*
        q!: [$beginningWords] [$helloAll] [$sorry] [$aha] [$iSgPl] [$comNow/уже/$atLast] [все] [$comNow/уже/$atLast] [удачно/успешно] (отправил*/увидел*/решил*/сделал*/[это] понял*/справил*/$transferPast/наладил*/разрешил*/появил*/получил*/зашел/зашл*/вошел/вошл*/$registerPast3/$seeIntoPast/выяснил*/заработал*/сработал*/$bonusComePastPres [$with] [опоздан*/задерж*]/скачал*/оплатил*/(нашел/нашл*) [и сделал*]/пополнил*/вижу/перешли) $comThanks [$sorry] [$holidays] [$comBye]
        q!: [$beginningWords] [$helloAll] [$aha] [$iSgPl] [$comNow/уже/$atLast] [все] [$comNow/уже/$atLast] [удачно/успешно] (отправил*/увидел*/решил*/сделал*/[это] понял*/справил*/$transferPast/наладил*/разрешил*/появил*/получил*/зашел/зашл*/вошел/вошл*/$registerPast3/$seeIntoPast/выяснил*/заработал*/$bonusComePastPres/скачал*/оплатил*/пополнил*) $sorry
        q!: * все [я/мы] $seeIntoPast *
        q!: [$aha] {[$goodAll] [$comNow/уже/$atLast] [я] [вас] понял* [$comThanks]} [$repeat<$emoji>]
        q!: [$sorry] [$aha] {[$goodAll] [$comNow/уже/$atLast] [$iSgPl] [$with/$v] [всем/[возникш*] $problem] $seeIntoPast [$comThanks]} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] [$comThanks] [я] $considerFutSgPl1} *
        q!: [$aha] {[$goodAll] [$comThanks] [$youNom] [мне] [очень] помогл*} [$repeat<$emoji>]
        q!: {принято $comThanks}
        q!: [$helloAll] $comThanks [$youDat] [за то] что [$youNom] (помогли/решили [$comMy] [~вопрос/~проблема]) *
        q!: $comThanks [я] так и (думала/есть)
        q!: $comThanks $with уважением *
        q!: [я] так и (*думала/есть) $comThanks
        q!: $comThanks а то я *
        q!: $comThanks [я] ($ne знал*/незнал*/низнал*) *
        q!: {$comThanks ($problem исчерпан*)}
        q!: $comThanks все [очень/предельно] (подробно/$clear/доступно)
        q!: [$aha] {[$goodAll] [$comThanks] [я] (так и сделаю)} [$repeat<$emoji>]

        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast/тогда/пока что/пока] (все [в] порядке)} *
        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast] [у меня] [все] (получилос*/удалос*)} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast] [у меня] [все] (работает/заработало)} [$repeat<$emoji>]

        q!: * $comThanks * (~вопрос/~проблема) [$comNow/уже/$atLast] (решил*/решен/решена) *
        q!: * (~вопрос/~проблема) [$comNow/уже/$atLast] (решил*/решен/решена) * $comThanks *

        q!: [$aha] {[$goodAll] $comThanks [все] [$comNow/уже/$atLast] (исправил*)} [$repeat<$emoji>]

        q!: {[$aha] [$goodAll] $comThanks [я] [$comNow/уже/$atLast] (нашл*/нашел*) [все]} [$repeat<$emoji>]

        q!: {$repeat<$comThanks> [$goodAll]} [и] [вас] $holidays *
        q!: {$repeat<$comThanks> [$goodAll]} [и] ($with наступ*/удачи/счастья и здоровья) *
        q!: {$repeat<$comThanks> [$goodAll]} (так и (сделаю/сделаем)/обязательно $beFutSgPl1/сразу бы так) *
        q!: {$comThanks напишу}
        q!: 👍
        intent!: /Thanks
        script:
            $reactions.answer(ans.bye);


    state: Good || noContext = true
        # Хорошо, ок
        q!: {[$repeat<$beginningWords>] $repeat<$goodAll> [$repeat<$emoji>]}
        script:
            $reactions.answer(ans.bye);


    state: Negative
        # Негатив, ругательства, недовольство ботом

        #  а пошел ка ты баран
        q!: {[$beginningWords] [$interjections] ([$botAll/$botName] [$swearingNoun])} {([$ne] $goPastPerfRude [ка] [б/бы]) [$youAll]} {[$botAll/$botName] [$swearingNoun]}
        # а не пошел бы ты в
        q!: {[$beginningWords] [$interjections] ([*ый] [$botAll/$botName] [$swearingNoun])} {([$ne] $goPastPerfRude [ка] [б/бы]) [$youAll]} $fuckOffDestination {[$interjections] ([*ый] [$botAll/$botName] [$swearingNoun])}
        # шел бы ты тупой бот
        # шел бы ты на хуй
        q!: {[$beginningWords] [$interjections] ([*ый] [$botAll/$botName] [$swearingNoun])} {($goPastImperfRude [б/бы]) $youAll} {[$interjections] [в/на/н/к/ко] ([*ый] [$botAll/$botName] [$swearingNoun])}
        q!: {[$beginningWords] [$interjections] ([*ый] [$botAll/$botName] [$swearingNoun])} {($goPastImperfRude [б/бы]) $youAll} {[$interjections] $fuckOffDestination ([*ый] [$botAll/$botName] [$swearingNoun])}
        # да иди ты
        # иди ты на
        # да свали ты на
        q!: {[$beginningWords] [$interjections] ([*ый] [$botAll/$botName] [$swearingNoun])} $goImpRude [ка] [$youAll] {[$interjections] [в/на/н/к/ко] ([*ый] [*ый] [$botAll/$botName])}
        q!: {[$beginningWords] [$interjections] ([*ый] [$botAll/$botName] [$swearingNoun])} $goImpRude [ка] [$youAll] $fuckOffDestination {[$interjections] ([*ый] [$botAll/$botName] [$swearingNoun])}
        # на хер ты мне сдался
        q!: * (нафик/нафек/нафиг/нафег/на фик/на фиг/нахуй/на хуй/нахер/на хер) [$interjections] $youAll * (сдался/дался/сдалась/далась/нужен/нжен/нуден/нуен/нужна) *
        q!: * $youAll [$meDat] [$interjections] (нафик/нафек/нафиг/нафег/на фик/на фиг/нахуй/на хуй/нахер/на хер) * (сдался/дался/сдалась/далась/нужен/нжен/нуден/нуен/нужна) *
        # блин
        # бля
        q!: [$beginningWords] [$interjections] {$repeat<$damnLight> [$repeat<$damnHard>]} {[$interjections] [$botAll/$botName]}
        q!: [$beginningWords] [$interjections] {$repeat<$damnHard>} {[$interjections] [$botAll/$botName]}
        # Ты глупый
        q!: {[$mvideo] [$youNom] $stupid}
        q!: вот $youNom $stupid
        q!: * {$botAll [$oneWord] $stupid} *
        q!: $beginningWords $stupid [же] $youNom
        q!: * {$youNom $nothing $canPresSg2Ne} *
        q!: * {$botAll $nothing $canPresSg3Ne} *
        # Ругательства
        q!: {[$mvideo] [$youNom] $negative} [$oneWord]
        q!: {[$mvideo] $obsceneWord [$strictYou]} [$oneWord]
        q!: вот $youNom ($negative/$obsceneWord) [$oneWord]
        q!: $beginningWords ($negative/$obsceneWord) [же] $youNom [$oneWord]
        q!: [да] $youNom {уже $irritatePast3}
        q!: [да] $youNom {меня $irritatePast3 [уже]}
        q!: * {меня * $irritatePres3 * $botAll} *
        q!: [да] $irritatePres2
        q!: [да] $youNom {меня [уже] $irritatePres2}

        q!: * (издеваетес*/издеваеш*/*издеват*/*издевац*/издевк*) *
        q!: * (унижатьс*/унижатс*/унижац*) *

        q!: [$beginningWords] [$interjections] [$oneWord] {[$oneWord] ($damnLight/$damnHard/$negative)} [$oneWord]

        intent!: /Negative
        script:
            $reactions.answer(ans.sorry);


    state: AnyMoreQuestions
        a: Уточните, пожалуйста, у вас еще остались вопросы?


        state: Yes
            q: * $comYes *
            q: * остал* *
            q: [$helloAll] [$operator] [я/мне] [$oneWord] [бы] [$oneWord] ($findOutInf/спросит/спросить/знать) [у] [$youGenAcc]
            q: [$helloAll] [$operator] [$comYes] (есть/имеет*/у меня/$possiblePredicAll) [к] [$oneWord] [$youDat] [$Number] вопрос* [о/по/про/по поводу] [$comMy] [$oneWord]
            q: [$helloAll] [$operator] [$comYes] (есть/имеет*/у меня) [$oneWord] проблем*
            q: {[$helloAll] (могу/$possiblePredicAll/$comWant) [я] [$youDat] вопрос задать}
            q: [$helloAll] [$operator] {[мне] $comNeed [ваш*] (~информация/~подсказка/~помощь/~совет/~консультация)} [о/по/про/по поводу] [$comMy] [$oneWord]
            q: * у меня * вопрос * $comNeed [$oneWord] (~информация/~подсказка/~помощь/~совет/~консультация)
            q: {[$helloAll] [$please] *скажи* [мне]}
            q: {[$helloAll] [$please] (може*/[$ne] могли бы) [$youNom] [мне] (помочь/(ответить/дать ответ) [на вопрос])} [о/по/про/по поводу] [$comMy] [$oneWord]
            q: {[$helloAll] [$please] помоги* [мне] [понять/разобрат*/*решить/порешать]} [о/по/про/по поводу] [$comMy] [$oneWord]
            q: [$helloAll] [$sorry] ~вопрос есть
            q: [$helloAll] [я к вам] [по/$with/по поводу] {~такой (~вопрос/~проблема)}
            q: [$helloAll] {таков* (~вопрос/~проблема)}
            q: [$helloAll] проблема $with $oneWord
            q: [$helloAll] [$oneWord] $comNeed [$oneWord] решить (~вопрос/~проблема)
            a: Что вас интересует?


        state: No
            q: не
            q: * $comNo *
            q: * ($ne остал*/неостал*/ниостал*) *
            q: [$comThanks] $ne $comNeed [$comThanks]
            q: * уже (помог/помогли/ответили) *
            q: * {все $comGood} *
            q: * {([никак*] ~вопрос) ([больше] $comNo)} *
            q: * (~вопрос/~проблема) (больше/пока [что]/покуда/уже/вроде [бы]) $comNo *
            q: * (больше/пока [что]/уже/вроде [бы]) $comNo проблем *
            q: * $comNo (больше/пока [что]/покуда/уже/вроде [бы]) [никак*] (~вопрос/~проблема) *
            q: * ~вопрос (снят/снимаю/снимает*/решен/решил*/разрешен/разрешил*/порешал*) *
            q: * ~проблема (решена/решены/разрешены/разрешил*/порешал*/решилас*/решилис*) *
            q: * {(если что) * обращусь} *
            q: [$comThanks] (это/пока) все [$repeat<$emoji>]
            q: * (ничем/$ne чем) *
            q: * (ничего/$ne чего) * ($ne $comNeed) *
            q: * ($ne $comNeed) * (ничего/$ne чего) *
            q: * пока (ничего/$ne чего) *
            q: $comThanks (ничего/$ne чего/это все) *
            a: Рада была подсказать.






