theme: /Account

    state: HowToRegister
        # Как зарегистрироваться
        q!: [$helloAll] $registration
        q!: [$helloAll] {$want [я] $registerInfRefl} [в/на] [~сайт] [$stoloto]
        q!: [$helloAll] {могу [я] [$again] $registerInfRefl}
        q!: [$helloAll] $how $possiblePredic $registration
        q!: * {$how $doInf $registration} *
        q!: * завести новую $registration *
        q!: * $registration (~пользователь/~участник) *
        q!: [$helloAll] $registration на (~сайт/[~сайт] $stoloto)
        q!: * $registerInfRefl на (~сайт/[~сайт] $stoloto) *
        q!: * $registerInfRefl в ($stoloto/$gosloto) *
        q!: * ($how/$comWhere/$want) [я могу/могу/$possiblePredic/правильно/мне/$again] $registerInfRefl *
        q!: * $registerInfRefl ($how/$comWhere/$want) *
        q!: * $how {$makeInf $account} *
        q!: [$helloAll] [мне] $comNeed помощ* (при/в) $registration
        intent!: /Account/HowToRegister
        a: Для регистрации на сайте Вам необходимо перейти по ссылке http://www.stoloto.ru/registration в раздел «Регистрация».\n\nДалее заполните все необходимые поля, указав электронную почту, имя, пароль, номер телефона.\n\nОбязательно указывайте действующий адрес Вашей электронной почты и номер телефона.\nПароль Вам будет необходимо придумать и запомнить, так как в дальнейшем вход на сайт Вы будете осуществлять через него и электронный адрес, указанный при регистрации.\n\nОбращаем Ваше внимание на то, что номер телефона после прохождения регистрации изменить невозможно.\n\nПри выборе имени учитывайте, пожалуйста, следующие условия:\n\nРазрешены: латинские и кириллические буквы, буквы в любом сочетании с цифрами.\n\nЗапрещены: пробелы и специальные символы.\n\nЗатем внимательно ознакомьтесь с договором-офертой и примите его условия.\n\nС более подробной информацией Вы можете ознакомиться, пройдя по cсылке http://www.stoloto.ru/lottery/onlinesale#tag_how
        #script: $reactions.timeout({interval: 60, targetState: '/Timedout'});


    state: HowToBlockAccount
        # Как заблокировать ЛК?
        q!: * {($blockInf/$blockImpFut) * $accountAcc * [$makeInf]} *
        q!: * ($blockInf/$blockImpFut) * $accountAcc * $phoneAndNum *
        q!: * {обнулит* ([$comMy] $accountAcc)} *
        q!: * $blockIng [$comMy] [$oneWord] $accountGen *
        q!: * {($blockInf/$blockImpFut) $meGen} *
        q!: * {$blockInf себя} *
        q!: * $blockInf все свои страницы *
        q!: * {($blockInf/снять/$blockImpFut/$annulInf) * $registration} *
        q!: * ($blockInf/$blockImpFut) * данные [[с/из] [~база] [~ваш/~этот] сайта/отсюда/от сюда/$forever] [$how это сделать]
        q!: * ($blockInf/$blockImpFut) * данные (в/из) $stoloto [$how это сделать]
        q!: * $blockInf $stoloto *
        q!: * ($how */$want) (удалитьс*/удалитс*/удалиц*) *
        q!: ($how/$want) [мне] $leaveInf [и $rejectInf] {[$localEmail] [$localMobilePhoneNumber]}
        q!: * {$leaveInf * (сайт/$with [ваш*/эт*] (сайта/страницы)/[от] вас/отсюда/от сюда/$stoloto)} *
        q!: * выйти $with этого $accountGen *
        q!: * {$leaveInf * $forever} *
        q!: * полностью $leaveInf *
        q!: * $forTo * {$blockPast * $accountAcc} *
        q!: * $forTo * {$blockPast * $meGen} *
        q!: * $forTo * {$blockPast * $registration} *
        q!: * (аннулировать/анулировать) [$comMy] $accountAcc *
        q!: * [$comMy] $accountAcc (аннулировать/анулировать) *
        q!: * {($annulInf/$annulImp) * $accountAcc} * {$changePast * $phoneAndNum} *
        q!: * {$changePast * $phoneAndNum} * {($annulInf/$annulImp) * $accountAcc} *
        q!: * {($blockInf/$blockImpFut) * $accountAcc} * {$changePast * $phoneAndNum} *
        q!: * {$changePast * $phoneAndNum} * {($blockInf/$blockImpFut) * $accountAcc} *
        intent!: /Account/HowToBlockAccount
        a: В случае блокировки Вашего аккаунта и отзыва согласия на обработку персональных данных доступ к денежным средствам, бонусам и к неразыгранным квитанциям будет невозможен. Проверьте, пожалуйста, нет ли у Вас активных подписок на лотереи/ настроена ли функция автовыплаты в Кошелек. В случае принятия решения о блокировке кабинета, отключите их, пожалуйста. Обращаем Ваше внимание на то, что личный кабинет будет заблокирован без возможности восстановления. Если Вы принимаете решение о блокировке, то сообщите, пожалуйста, данные от Вашего личного кабинета, который требуется заблокировать: электронную почту и телефон. По возможности укажите причину удаления личного кабинета. Это поможет нам улучшить качество нашей работы.

        state: LocalCatchAll
            event: noMatch || fromState = /Account/HowToBlockAccount
            script: Webim.switch();

        state: ThisIsMyUserData
            q: * [$helloAll] {[$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script: Webim.switch();


    state: WhereToEnterRegistrationCode
        # Куда вводить код регистрации
        q!: * {$comWhere * $insertInf * $code * $registration} *
        q!: * {$comWhere * $insertInf * $numeral * $registration} *
        q!: * {куда * $insertInf * $code * $registration} *
        q!: * {куда * $insertInf * $numeral * $registration} *
        q!: * {куда * набрать * $code * $registration} *
        q!: * {куда * набирать * $code * $registration} *
        q!: * {(~какой (~место/граф*/~поле)) * $insertInf * $code * $registration} *
        q!: * {(~какой (~место/граф*/~поле)) * $insertInf * $numeral * $registration} *
        q!: * {$comWhere * $insertInf * $code * $registerInfRefl} *
        q!: * {куда * $insertInf * $code * $registerInfRefl} *
        q!: * {(~какой (~место/граф*/~поле)) * $insertInf * $code * $registerInfRefl} *
        q!: * (куда/$comWhere) $insertInf ($code/$numeral) [для] $confirmation $telephoneNumber *
        q!: * {$insertInf * $code} * {подтвердит* * $mail} *
        q!: * {подтвердит* * $mail} * {$insertInf * $code} *
        q!: * $whatToDoInf $with $code [для] $confirmation *
        # Как подтвердить почту
        # Не могу подтвердить почту
        q!: * {$how [мне] ([вам] подтвердит* [вам]) [$comMy] $mail} *
        q!: * {$comWhere [мне] подтвердит* [$comMy] $mail} *
        q!: * {$possiblePredic [мне] подтвердит* [$comMy] $mail} *
        q!: * {$how подтверждать [$comMy] $mail} *
        q!: [$helloAll] {[$cantPastPresAll] подтвердит* [$comMy] $mail}
        q!: * {могу подтвердит* [$comMy] $mail} *
        q!: * (помоги*/помож*/$cantPastPresAll) * {подтвердит* [$comMy] ([$oneWord] ($phoneAndNum/$mail))} *
        q!: * {подтвердит* [$comMy] $mail} * $cantPastPresAll *


        q!: * {($confirmPres3Ne [мне]) [$comMy] ($phoneAndNum/$mail)} *


        q: * {$comWhere * $insertInf * $code} * || fromState = /Account/HowToRegister
        q: * {куда * $insertInf * $code} * || fromState = /Account/HowToRegister
        q: * {(~какой (~место/граф*/~поле)) * $insertInf * $code} * || fromState = /Account/HowToRegister
        intent!: /Account/WhereToEnterRegistrationCode
        a: При регистрации на сайте Вы указываете адрес электронной почты и номер мобильного телефона. После нажатия на кнопку «Зарегистрироваться» на указанную почту поступит письмо. После перехода по ссылке из письма откроется форма для ввода кода из смс. Инструкцию по регистрации можно посмотреть по ссылке https://www.stoloto.ru/lottery/onlinesale?int=sitemap \n\nЕсли в процессе подтверждения почты у Вас возникли сложности, напишите нам, пожалуйста.

        state: SomeDifficulties
            # не высветилось окно
            q!: * ($confirmEmail/$confirmation) * $problemsWithEmailConfirmation *

            q!: * $comNo (~окно/окошк*) * $code [для] $confirmation *
            q!: * $registration * прох* по $link * (~окно/окошк*) *
            q!: * ($registration/$registerPresSg1) * $badLink *
            q!: * $badLink * ($registration/$registerPresSg1) *
            q!: * {($link * ($registration/$confirmation)) * ($activeNe/$openPres3Ne/$workPres3SgNe)} *
            q!: * $link * (переводит/выводит) * (форму/повторн*) [для] $confirmation *
            q!: * {(~переход/перешел/перешла/перехожу) * $link * $confirmation} * ($ne происход*/[$again] открывае*/сайт прос*/по-прежнему/по прежнему/попрежнему/все равно/$isWritten подтвердите/$ne пускает) *
            q!: * {(~переход/перешел/перешла/перехожу) * $link} * $mail $ne подтверждена *
            q!: * (нажимаю/нажимаем) подтвердить * $nothing *
            q!: * (проблема/$workPres3SgNe) * $confirmation * ($phoneAndNum/$mail) *

            q: * ($ne (высветил*/вылезл*)/невылезл*/невысветил*/отсутств*/$bePastNe) * (~окно/окошк*/~поле/~форма) *
            q: * (~окно/окошк*/~поле/~форма) * ($ne (высветил*/вылезл*)/невылезл*/невысветил*/отсутств*/$bePastNe) *
            q: * 404 *
            q: * {(~окно/окошк*/поля/~форма) [~такой] $comNo} *
            q: * {~страница ($existNeSg3/$comNo)} *
            q: * $ne выдает * (~окно/окошк*/~поле/страниц*/~форма) *
            q: * куда $insertInf $comNo *
            q: * {удалил* * $letter} *
            q: * {удалил* * $link} *
            q: * {случайно удалил*} *
            q: * {$activeNe * $link} *
            q: * (~форма/окно/окошк*/~поле/$link/страниц*) * ($openPres3Ne/$openPastNe) *
            q: * ($openPres3Ne/$openPastNe) * (~форма/окно/окошк*/~поле/$link/страниц*) *
            q: * (перебрасывает/перебрасывают/*кидывает/*кидывают/кидает/возвращает/выходит/перешел) * (на сайт/на глав* стран*) *
            q: * (на сайт/на глав* стран*) * (перебрасывает/перебрасывают/*кидывает/*кидывают/кидает/возвращает/выходит/перешел) *
            q: * (выскакивает/открывает*) * глав* страниц* *
            q: * попада* на глав* страницу *
            q: * появ* страница осн* сайта *
            q: * $difficulty *
            q: * $ne подтверждает* *
            q: * $comNo ~подтверждение *
            q: * {~подтверждение ($ne происход*)} *
            q: * $mail ($ne подтвержден*/неподтвержден*) *
            q: * ($ne подтвержда*/неподтвержда*) *
            q: * так и (делаю/*делал*) *
            q: * все *делал* по инстр* *
            q: * (помогите/$comNeed * помощь) *
            q: * (вых*/появ*/возник*/пиш*) * (ошибк*/проблем*) *
            q: * $nothing $ne (дало/выходит) *
            q: * сбой *
            q: ($cantPastPresAll/возникли/написал*/пишу [$youDat])
            q: * {(~сервер/~сервис) * $workPres3SgNe} *
            a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.

            state: GetUserData
                q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
                script: Webim.switch();

            state: GetUserEmail
                q: * [$helloAll] [$comMy] [$mail] $localEmail *
                script:
                    $session.usrEmail = $parseTree._localEmail;
                if: !$session.usrPhoneNumber
                    a: Укажите, пожалуйста, Ваш номер телефона.
                else:
                    script: Webim.switch();

            state: GetUserPhoneNumber
                q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
                script:
                    $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
                if: !$session.usrEmail
                    a: Укажите, пожалуйста, Вашу электронную почту.
                else:
                    script: Webim.switch();

        state: LocalCatchAll
            event: noMatch || fromState = /Account/WhereToEnterRegistrationCode
            script: Webim.switch();


    state: EmailNotReceived
        # Не пришло письмо
        q!: [$helloAll] {[я] $findPastPresNe $letter}
        q!: * {$cantPastPres * $receiveInf * $letter * $mail} *
        q!: * {$cantPastPres * $receiveInf * $link * $mail} *
        q!: * {$cantPastPres * $receiveInf * $confirmation * $mail} *
        q!: * {$cantPastPres * $findInf * $letter * $mail} *
        q!: * {$cantPastPres * $findInf * $link * $mail} *
        q!: * {$cantPastPres * $findInf * $confirmation * $mail} *
        q!: * {$cantPastPres * получить * ($letter/$link)} *

        q!: * {$smsComePastPresNe * $letter * [$mail]} *
        q!: * {$smsComePastPresNe * $link * [$mail]} * [получить] *
        q!: * {$smsComePastPresNe * $confirmation * $mail} *
        q!: * {$smsComePastPresNe * (запрос/~уведомление) * $mail} *
        q!: * {$sendPastPresNe * ($letter/$link)} *

        q!: * {$smsComePastPresNe * $sms * ((в/на/до) [$comMy] $mail)} *
        q!: * {$smsComePastPresNe $oneWord ((в/на) [$comMy] $mail)} *

        q!: * {$smsComePastPresNe * $mail * $nothing} *
        q!: [$helloAll] {$comNo ((в/на) $mail) $nothing} [$repeat<$emoji>]
        q!: * {$comNo * $letter * $mail} *
        q!: * {$comNo * $link * $mail} *

        q!: [$helloAll] {$smsComePastPerfNe $mail}
        q!: * {$comWhere * ($letter/$link)} *
        q!: * {$sendMeImp * ($letter/$link)} *
        q!: * $askYouAll * {($sendMeInfPerf/$duplicateInfPerf) * ($letter/$link)} *
        q!: * ($letter/$link) * {$askYouAll * ($sendMeInfPerf/$duplicateInfPerf)} *
        q!: * ($sendMeInfPerf/$duplicateInfPerf) * {($letter/$link) * $askYouAll} *
        q!: * так ($letter/$link) и $bePastNe *
        q!: * {$comNo [~ваш] ($letter/$link)} *
        q!: * {жду [~ваш] ($letter/$link)} *
        q!: * {$comNo (от вас) $letter} *
        q!: * {$comNo (от вас) $link} *
        q!: * {$howMuch * $waitInf * $letter} *
        q!: * {$howMuch * $waitInf * $link} *
        q!: * {$howLong * $waitInf * $letter} *
        q!: * {$howLong * $waitInf * $link} *
        q!: * {долго $bonusComePastPres $letter} *
        q!: * {долго $bonusComePastPres $link} *
        q!: [$helloAll] {($letter/$link) $smsComeFut} $or $comNo
        q!: [$helloAll] {($letter/$link) $waitInf} $or $comNo
        q!: * {$delay * $link} *
        q!: * {$delay * $letter} *

        # Хотел восстановить пароль, но письмо на почту не приходит
        q!: * {$askYouAll * ($sendMeInfPerf/$duplicateInfPerf) * $password} *
        q!: * {($smsComePastPresNe/$receivedNe) * ~инструкция} *
        q!: * {($smsComePastPresNe/$receivedNe) * $code * ((в/на) $mail)} *
        q!: * {($smsComePastPresNe/$receivedNe) * восстановление * ((в/на) $mail)} *
        q!: * {($smsComePastPresNe/$receivedNe) * $changeInf * $password} *
        q!: * {($smsComePastPresNe/$receivedNe) * $resetInfAll * $password} *
        q!: * {($smsComePastPresNe/$receivedNe) * $resetNoun * $password} *
        q!: * {($smsComePastPresNe/$receivedNe) * $changeNoun * $password} *
        q!: * {($smsComePastPresNe/$receivedNe) * $resetNoun * ~инструкция} *
        q!: * {$cantPastPres * $receiveInf * $password * [$toAccount]} *
        q!: * {($smsComePastPresNe/$receivedNe) * $password * $toAccount} *
        q!: * {($smsComePastPresNe/$receivedNe) * $password * ((в/на) $mail)} *
        q!: * {($smsComePastPresNe/$receivedNe) запрош* $password} *
        q!: * {$sendMeImp * (для $resetNoun)} *
        q!: * {(на (какой/какую) $mail) * ($sendPartPas/$sendPast) * $resetNoun} *
        q!: * $comNeed * $code * (для $resetNoun) *

        q!: * $resetPassword * $noLetter *
        q!: * $noLetter * $resetPassword * [$nelzya] *

        q!: {$comNo $letter и $password}
        q!: * {$cantPastPres * $resetPres * $password} *
        q!: * {$resetPresNe * $password} *
        q!: * {$password ($smsComePastPresNe/$receivedNe)} *
        q!: * запросил* * ($password/$code/~инструкция) * $resetNoun *
        q!: * $comWhere [$comMy] ($password/$code/~инструкция) * $resetNoun *
        q!: * $letter * $resetNoun * в ответ тишина *

        q: * ($resetPassword/$cantLogIn) * || fromState = /Phone/NoUnknownTypeCode

        intent!: /Account/EmailNotReceived
        if: $global.letterDeliveryIsAvailable
            a: Проверьте, пожалуйста, папку «Спам»/«Нежелательная почта», письмо может быть определено в нее. Вы можете добавить адрес mailer@stoloto.ru в адресную книгу для гарантированного получения наших писем без перенаправления их в папки нежелательной почты. Если письмо не поступило, сообщите, пожалуйста, данные, по которым проводили регистрацию: email и номер телефона.
        else:
            a: По техническим причинам письма по электронной почте с купленными билетами, подтверждением регистрации и прочие электронные сообщения от «Столото» доставляются с задержкой. Не волнуйтесь, очень скоро ситуация разрешится и все сообщения будут доставлены.

        #TODO!: ADD STATE TO GET QUERY TO SEND USER TO SMS-RELATED-STATE

        state: GetUserData || fromState = /Account/EmailNotReceived
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/EmailNotReceived
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/EmailNotReceived
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: LetterWasInSpam
            # нашел письмо в спаме
            q!: [$helloAll] {$letter [$aha] [ура] (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q!: [$helloAll] [$aha] {[$letter/все] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*/был*) (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q!: * $letter (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*/был*) (в $spamFolder) *
            q!: * (в $spamFolder) * и (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*/был*) *
            q!: [$helloAll] [все] {$comThanks $letter приш*} *
            q!: * (точно/действительно/правда) [пришло/висит/лежит/$findPastPres/был*/нашл*/нашел/оказал*/попал*] (в $spamFolder) *
            q!: [$aha] {$comThanks [оно/они] (в $spamFolder)}
            q!: {$comYes (в $spamFolder)}


            q: {[$letter] [$aha] [ура] [там и/туда и] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*/был*) [в $spamFolder] [$comThanks]} [$repeat<$emoji>]
            q: * $spamFolder (пришло/висит/лежит/$findPastPres/был*) *
            q: * ($letter/да/все) (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*) *
            q: * ($letter/да) ушло туда *
            q: * и нашлос* *
            a: Была рада Вам помочь.

        state: PasswordOrLetterDidntCome
            q!: [$helloAll] {$password $comNo}
            q!: * $password так и $smsComePastPresNe *
            q!: * $ne (на/в) $spamFolder *
            q!: * $ne $spamFolder $ne *
            q!: * {$spamFolder * (проверял*/проверил*)} *
            q!: * {(в $spamFolder) [$letter] $nothing} *
            q!: * $spamFolder * (пустой/пуста*/пуст) *
            q!: * $spamFolder * {нигде $comNo} *
            q!: * {нигде $comNo} * $spamFolder *
            q!: * {([$ne] (в $spamFolder)) [$letter] [$ne одного] $comNo} *
            q!: * $comNo * даже в $spamFolder *

            q!: * в $spamFolder $oneWord (тоже/то же) $comNo *
            q!: * {(в $spamFolder) [$letter] отсутству*} *
            q!: * {[$letter] (в $spamFolder) $smsComePastPresNe} *
            q!: * {[$letter] (в $spamFolder) $findPastPresNe} *
            q!: * {($comNo/$ne (идет/было)/неидет/небыло/$smsComePastPresNe) [мне] $letter} * (смотрел*/посмотрел*/проверил*) *
            q!: * (смотрел*/посмотрел*/проверил*) * {($comNo/$ne (идет/было)/неидет/небыло/$smsComePastPresNe) [мне] $letter} *
            q!: * {$comNo ([и] там) $letter} *
            q!: * $comNo нигде никак* $letter *
            q!: * $letter так и $comNo *
            q: $checkTicketPast
            q: * {[в $spamFolder] [$letter] ($nothing/$comNo)} *
            q: * {[$letter] [в $spamFolder] $smsComePastPresNe} *
            q: * {[$letter] [в $spamFolder] $findPastPresNe} *
            a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.


    state: RegistrationLetterDidntCome
        # Не пришло письмо для завершения регистрации
        q!: * {$cantPastPres * $receiveInf * $letter * $registration} *
        q!: * {$cantPastPres * $receiveInf * $link * $registration} *
        q!: * {$cantPastPres * $receiveInf * $confirmation * $registration} *
        q!: * {$cantPastPres * $findInf * $letter * $registration} *
        q!: * {$cantPastPres * $findInf * $link * $registration} *
        q!: * {$cantPastPres * $findInf * $confirmation * $registration} *

        q!: * {$cantPastPres * $registerInfRefl} *
        q!: * {$cantPastPres * $registration} *
        q!: * {$cantPastPres * $registerInf * $account} *
        q!: * {(помоги*/помож*) * $doInf * $registration} *
        q!: * {(помоги*/помож*/$how) * $finishInf * $registration} *
        q!: * {(помоги*/помож*) * $registerInfRefl} *

        q!: * {$smsComePastPresNe * $letter * $registration} *
        q!: * {$smsComePastPresNe * $link * $registration} *
        q!: * {$smsComePastPresNe * приглашение * $registration} *
        q!: * {$smsComePastPresNe * $confirmation * $registration} *
        q!: * {$smsComePastPresNe * $letter * $registerInfRefl} *
        q!: * {$smsComePastPresNe * $link * $registerInfRefl} *
        q!: * {$smsComePastPresNe * $confirmation * $registerInfRefl} *

        q!: * {$smsComePastPresNe * ($notification о $registration) * ((в/на) $mail)} *
        q!: * {$smsComePastPresNe * $sms * ((в/на) $mail) * $registration} *
        q!: * {$smsComePastPresNe $mail (для $registration)} *
        q!: * {$howLong * $letter * $registration} *
        q!: * {$howLong * $link * $registration} *
        q!: * {$howLong * $confirmation * $registration} *
        q!: * {$comNo * $letter * $registration} *
        q!: * {$comNo * $link * $registration} *

        q!: * {$comWhere * $letter * $registration} *
        q!: * {$comWhere * $link * $registration} *
        q!: * {$sendMeImp * $letter * $registration} *
        q!: * {$sendMeImp * $link * $registration} *
        q!: * {$askYouAll * $sendMeInfPerf * $letter * $registration} *
        q!: * {$askYouAll * $sendMeInfPerf * $link * $registration} *
        q!: * {$askYouAll * $duplicateInfPerf * $letter * $registration} *
        q!: * {$askYouAll * $duplicateInfPerf * $link * $registration} *

        q!: * {$howMuch * $waitInf * $letter * $registration} *
        q!: * {$howMuch * $waitInf * $link * $registration} *
        q!: * {$howLong * $waitInf * $letter * $registration} *
        q!: * {$howLong * $waitInf * $link * $registration} *
        q!: * {долго $bonusComePastPres $letter} * $registration *
        q!: * {долго $bonusComePastPres $link} * $registration *
        q!: * $registration * {долго $bonusComePastPres $letter} *
        q!: * $registration * {долго $bonusComePastPres $link} *

        q!: * {$delay * $link * $registration} *
        q!: * {$delay * $letter * $registration} *
        q!: * {$delay * $confirmation * $registration} *
        q!: * {$delay * $mail * $registration} *

        q!: * $confirmEmail * $noLetter *
        q!: * $noLetter * $confirmEmail *

        q: * {$smsComePastPresNe * $letter} * || fromState = /Account/WhereToEnterRegistrationCode
        q: * {$smsComePastPresNe * $link} * || fromState = /Account/WhereToEnterRegistrationCode
        q: * {$comNo $letter} * || fromState = /Account/WhereToEnterRegistrationCode
        q: * {$comNo $link} * || fromState = /Account/WhereToEnterRegistrationCode

        intent!: /Account/RegistrationLetterDidntCome
        if: $global.registrationLetterDeliveryIsAvailable
            a: Проверьте, пожалуйста, папку «Спам»/«Нежелательная почта», письмо может быть определено в нее. Вы можете добавить адрес mailer@stoloto.ru в адресную книгу для гарантированного получения наших писем без перенаправления их в папки нежелательной почты. Если письмо не поступило, сообщите, пожалуйста, данные, по которым проводили регистрацию: email и номер телефона.
        else:
            a: Спасибо, что сообщили о задержке. Мы уже работаем над возобновлением корректной работы системы рассылок.

        state: GetUserData || fromState = /Account/RegistrationLetterDidntCome
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/RegistrationLetterDidntCome
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/RegistrationLetterDidntCome
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: LetterWasInSpam
            # нашел письмо в спаме
            q: [$helloAll] {$letter [$aha] [ура] (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q: [$helloAll] [$aha] {[$letter/все] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*/был*) (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q: [$helloAll] [все] {$comThanks $letter приш*} *
            q: * (точно/действительно/правда) [пришло/висит/лежит/$findPastPres/был*/нашл*/нашел/оказал*/попал*] (в $spamFolder) *
            q: {[$letter] [$aha] [ура] [там и/туда и] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*/был*) [в $spamFolder] [$comThanks]} [$repeat<$emoji>]
            q: * $spamFolder (пришло/висит/лежит/$findPastPres/был*) *
            q: * ($letter/да/все) (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*) *
            q: * ($letter/да) ушло туда *
            a: Была рада Вам помочь.

        state: LetterDidntCome
            q: $checkTicketPast
            q: * {(в $spamFolder) [$letter] $nothing} *
            q: * {(в $spamFolder) [$letter] [$ne одного] $comNo} *
            q: * {(в $spamFolder) [$letter] отсутству*} *
            q: * {[$letter] (в $spamFolder) $smsComePastPresNe} *
            q: * {[$letter] (в $spamFolder) $findPastPresNe} *
            q: * {$comNo $letter} * (смотрел*/посмотрел*/проверил*) *
            q: * (смотрел*/посмотрел*/проверил*) * {$comNo $letter} *
            q: * {$comNo там $letter} *
            q: * $comNo нигде никак* $letter *
            q: * {[в $spamFolder] [$letter] ($nothing/$comNo)} *
            q: * {[$letter] [в $spamFolder] $smsComePastPresNe} *
            q: * {[$letter] [в $spamFolder] $findPastPresNe} *
            a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.


    state: ReceiptDidntCome
        # Не пришел чек об оплате билета
        q!: * получить ($receipt/~отчет о $buyN) *
        q!: * {(~отчет о $buyN) $smsComePastPresNe} *
        q!: * {$stopped $smsComeInf $receipt} *
        q!: * {$smsComePastPresNe $receipt ((об/о/по/после) $payment [за] [$ticket/$lottery/лото])} *
        q!: * {$receipt * $smsComePastPresNe * ((в/на) $mail)} *
        q!: * $receiveInf ($receipt/~отчет о $buyN) * куплен* *
        q!: * {$buyPastPres * ($ticket/$lottery/лото)} * {($how/$comWhere) $receiveInf $receipt} *
        q!: * {$payPast * ($ticket/$lottery/лото)} * {($how/$comWhere) $receiveInf $receipt} *
        q!: * {$buyPastPres * ($ticket/$lottery/лото)} * {$comWhere [$comMy] $receipt} *
        q!: * {$payPast * ($ticket/$lottery/лото)} * {$comWhere [$comMy] $receipt} *
        q!: * $buyPastPres * ($ticket/$lottery/лото) * {$receipt [(в/на) $mail]$smsComePastPresNe} *
        q!: * ($ticket/$lottery/лото) * $buyPastPres * {$receipt [(в/на) $mail]$smsComePastPresNe} *
        q!: * $payPast * ($ticket/$lottery/лото) * {$receipt [(в/на) $mail] $smsComePastPresNe} *
        q!: * ($ticket/$lottery/лото) * $payPast * {$receipt [(в/на) $mail] $smsComePastPresNe} *
        q!: * $comWhere * {$receipt * $buyN * $lottery} *
        q!: * $comWhere * {$receipt * $buyN * $ticket} *
        q!: * {$sendPastPresNe $receipt} *
        q!: * $comWhere ~остальной $receipt *
        q!: * $comNo $notification о приеме $bet *
        q!: * {$comNo инфо* ((о/по/про) $ticket) ((в/на) $mail)} *
        q!: * {$smsComePastPresNe * ($notification о (приеме $bet/$buyN))} *
        q!: * {$receipt * приходят * ($with задержкой)} *
        q!: [$helloAll] {$receipt $smsComeFut} $or $comNo
        q!: [$helloAll] {$receipt $waitInf} $or $comNo
        q!: * {долго $bonusComePastPres $receipt} *
        intent!: /Account/ReceiptDidntCome
        if: $global.receiptDeliveryIsAvailable
            a: Проверьте, пожалуйста, папку «Спам»/«Нежелательная почта», письмо может быть определено в нее. Вы можете добавить адрес mailer@stoloto.ru в адресную книгу для гарантированного получения наших писем без перенаправления их в папки нежелательной почты. Если письмо не поступило, сообщите, пожалуйста, данные, по которым проводили регистрацию: email и номер телефона.
        else:
            a: Спасибо, что информируете нас. Технические специалисты «Столото» уже работают над восстановлением работы сервиса. Надеемся, что в самое ближайшее время Вы сможете им воспользоваться.

        state: GetUserData || fromState = /Account/ReceiptDidntCome
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/ReceiptDidntCome
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/ReceiptDidntCome
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: LetterWasInSpam
            # нашел письмо в спаме
            q: [$helloAll] {$letter [$aha] [ура] (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q: [$helloAll] [$aha] {[$letter/все] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*/был*) (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q: [$helloAll] [все] {$comThanks $letter приш*} *
            q: * (точно/действительно/правда) [пришло/висит/лежит/$findPastPres/был*/нашл*/нашел/оказал*/попал*] (в $spamFolder) *
            q: {[$letter] [$aha] [ура] [там и/туда и] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*/был*) [в $spamFolder] [$comThanks]} [$repeat<$emoji>]
            q: * $spamFolder (пришло/висит/лежит/$findPastPres/был*) *
            q: * ($letter/да/все) (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказал*) *
            q: * ($letter/да) ушло туда *
            a: Была рада Вам помочь.

        state: ReceiptOrLetterDidntCome
            q: $checkTicketPast
            q: [$helloAll] {$receipt $comNo}
            q: * $receipt так и $smsComePastPresNe *
            q: * {(в $spamFolder) [$letter] $nothing} *
            q: * {(в $spamFolder) [$letter] [$ne одного] $comNo} *
            q: * {(в $spamFolder) [$letter] отсутству*} *
            q: * {[$letter] (в $spamFolder) $smsComePastPresNe} *
            q: * {[$letter] (в $spamFolder) $findPastPresNe} *
            q: * {$comNo $letter} * (смотрел*/посмотрел*/проверил*) *
            q: * (смотрел*/посмотрел*/проверил*) * {$comNo $letter} *
            q: * {$comNo там $letter} *
            q: * $comNo нигде никак* $letter *
            q: * {[в $spamFolder] [$letter] ($nothing/$comNo)} *
            q: * {[$letter] [в $spamFolder] $smsComePastPresNe} *
            q: * {[$letter] [в $spamFolder] $findPastPresNe} *
            a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.


    state: ScammersSendLetters
        # Мошенники рассылают письма
        q!: * (якобы/тип*) у меня $prize *
        q!: * отношение к (суперлото/(супер/super) лото) *
        q!: * {$tikTok * $prizeAll} *
        q!: * просят вперед * оплатить *
        q!: * в инстаграм* * проводите *
        q!: * мошен* рассылают $letter *
        q!: * работают от имени $stoloto *
        q!: * override *
        q!: * вы отправляете приглашение (в/на) $mail *
        q!: * (1000/тысяча) бесплатн* $ticket *
        q!: * написали $with (суперлото/(супер/super) лото) *
        q!: * $comWhat $oneWord (суперлото/(супер/super) лото) *
        q!: * (суперлото/(супер/super) лото) * $smsComePast *
        q!: * $smsComePast * (суперлото/(супер/super) лото) *
        q!: * {рассылк* * $ticket * (юбилейн* $ticketRun)} *
        q!: * {рассылк* * $ticket * ~юбилей} *
        q!: * {рассылк* * [$ticket] * (25 лет*)} *
        q!: * {дарите * $ticket * (25 лет*)} *
        q!: * {подарили * $ticket * (25 лет*)} *
        q!: * (государ* $lottery/аст) * (дарит/дарят/раздает/раздают) * $ticket *
        q!: * {$letter * $smsComePast} * (якобы/тип*) * дарите * $ticket *
        q!: * {$letter * $smsComePast} * что * {дарят * $ticket * ~юбилей} *
        q!: * {$letter * $smsComePast} * что * {дарите * $ticket * ~юбилей} *
        q!: * {$letter * $smsComePast} * что * {дарят * $ticket * (25 лет*)} *
        q!: * {$letter * $smsComePast} * что * {дарите * $ticket * (25 лет*)} *
        q!: * {$letter * $smsComePast} * что * {подарили * $ticket * @RL} *
        q!: * {$letter * $smsComePast} * {предложен * $ticket} *
        q!: * {~сообщение * $smsComePast} * {предложен * $ticket} *
        q!: * {~сообщение * $smsComePast} * (подарочн* $ticket) *
        q!: * {$letter * $smsComePastPres} * (якобы/тип*) от (вас/$stoloto/ваш* имени) *
        q!: * {$letter * $smsComePastPres} * от (вас/$stoloto/ваш* имени) (якобы/тип*) *
        q!: * {$letter * $smsComePastPres} * (якобы/тип*) * ($winPastPerf/$prize) *
        q!: * (якобы/тип*) * {подарили * $ticket} *
        q!: * @RL дарил* бесплат* $ticket *
        q!: * 1000 бесплат* $ticket в подарок *
        q!: * $link на {бесплат* подарочн*} розыгрыш* *
        q!: * {$smsComePast * (бесплатн* $ticket) * @RL} * это (правда/ваш сайт/имеет * отношение к вам/[очередн*] (развод/фикция/$lohotron/афер*/мошен*)) *
        q!: * {$smsComePast * (подарочн* $ticket) * @RL} * это (правда/ваш сайт/имеет * отношение к вам/[очередн*] (развод/фикция/$lohotron/афер*/мошен*)) *
        q!: * {$letter * $smsComePast} * подарочн* $ticket * *пошлин* *
        q!: * {(подарочн* $ticket) * (предлож* оплатить)} *
        q!: * $mail * {(подарочн* $ticket) * $smsComePast} * я $winPastPerf *
        q!: * {$letter * $smsComePast * (25 лет*)} * *пошлин* *
        q!: * {($winPastPerf/$prize) * (25 лет*)} * *пошлин* *
        q!: * [якобы] * ($winPastPerf/$prize) * [@RL] * [требуют/просят] * *пошлин* *
        q!: * {(требуют/просят) * *пошлин*} *
        q!: * $viber * ($winPastPerf/$prize) * *пошлин* *
        q!: * Заберите Ваш подарочный билет к юбилейному тиражу *
        q!: * {$smsComePast * $letterAll * $mail * (от @RL)} *
        q!: * {$smsComePast * (юбилейн* $ticket) * @RL} *
        q!: * {$smsComePastPres * $letterAll * (от мошен*)} *
        q!: * {$smsComePastPres * $letterAll * (от афер*)} *
        q!: * {$smsComePastPres * $letterAll * (сомнительн* содерж*)} *
        q!: * {$smsComePastPres * $letterAll * (со странн* $mail)} *
        q!: * @RL в честь юбилея дарит (бесплатн* [подарочн*] $ticket) *
        q!: * (25 лет*) * дарим * (бесплатн* [подарочн*] $ticket) *
        q!: * (25 лет*) * (раздавать/раздовать) * $ticket *
        q!: * {$distributePres3 * $ticket * (25 лет*)} *
        q!: * {$distributePres3 * $ticket * (юбилейн*)} *
        q!: * {$distributePres3 * (бесплатн* [подарочн*] $ticket [@RL])} *
        q!: * {подарил* * $ticket} * ($winPastPerf/$prize) * просят $bankCardAll *
        q!: * {~розыгрыш * @RL} * просят * $bankCardAll *
        q!: * {[подарил*] * [$ticket]} * ($winPastPerf/$prize) * $prizeSumScam [$rub] *
        q!: * {прислать * $ticket} * ($winPastPerf/$prize) * $prizeSumScam [$rub] *
        q!: * {$smsComePast * $ticket} * ($winPastPerf/$prize) * $prizeSumScam [$rub] *
        q!: * {~розыгрыш * @RL} * ($winPastPerf/$prize) * $prizeSumScam [$rub] *
        q!: * [$smsComePast] * [$letterAll] * {($winPastPerf/$prize) * RL} * $prizeSumScam [$rub] *
        q!: * {(это правда/$winPastPerf) * $prizeSumScam} *
        q!: * {$smsComePastPres * $letterAll * ($winPastPerf * $prizeSumScam)} *
        q!: * (проводил*/проводит*) * розыгрыш* * (25 лет*) *
        q!: * {$viber * $ticket * (в честь юбилея)} *
        q!: * {$viber * $ticket * (25 лет*)} *
        q!: * {$viber * (подарочн* $ticket)} *
        q!: * {$viber * (бесплатн* $ticket)} *
        q!: * {$viber * (от вас) * $letter} *
        q!: * {юбилейн* * ~розыгрыш * проводит*} *
        q!: * якобы ~розыгрыш [от] @RL *
        q!: * {$smsComePast $ticket} (как/якобы) подарочн* *
        q!: * $ticket $with (так называем*/якобы) подарочн* $ticket *
        # мне на почту пришло, это лохотрон?
        q!: * ($smsComePast/(на/в) [$comMy] $mail) * (это/наверн*/подозрев*) ($lohotron/$fraud) *

        intent!: /Account/ScammersSendLetters
        a: Данная информация не имеет отношения к «Столото». Подробнее с информацией о видах мошенничества по телефону и в интернете Вы можете ознакомиться, пройдя по ссылке http://www.stoloto.ru/warning-lottery-scam?int=faq .\n\nУточните, пожалуйста, адрес почты, с которого и на который поступило письмо.

        state: GetAnswer
            q: * {[$localEmail] * $localEmail} *
            event: noMatch
            script: Webim.switch();


    state: HowToResetPassword
        # Как восстановить пароль
        q!: $comMy $password
        q!: $comNeed восстановит* (доступ/доспуп)
        q!: * {вернуть * (доступ/доспуп)} *

        q!: * (забылпарол*/забылапарол*) *
        q!: * {$lostPast * $password} *
        q!: * {$forgetPastPres * $password * [$getPrizInf] * [$prizeAndSum]} *
        q!: * {$cantPastPres * вспомнить * $password} *
        q!: * $or {вспомнить $password} *
        q!: * {$cantPastPres настроит* $password} *
        q!: {$resetInf [$comMy] $account}
        q!: * {($cantPastPres/$want/могу/$comNeed/$how [мне]) $resetInf ([$comMy] ($account/$accountAcc))} *
        q!: * {$cantPastPres $resetInf $stoloto} *
        q!: * {$changeInf * $password} *
        q!: * {$changeImp * $password} *
        q!: * {$resetInfAll * $password} *
        q!: * {$resetImpAll * $password} *
        q!: * {$resetNoun * $password} *
        q!: * {$changeNoun * $password} *
        q!: * {$wrong $password} *
        q!: * $findOutInf $comMy $password *

        q!: * {$findOutInf * $password * ~вход} *
        q!: * {$comNeed * $password * ~вход} *
        q!: * $comNeed новый $password *
        q!: * {$receiveInf * $password * ~вход} *
        q!: * {$findOutInf * $password * $access} *
        q!: * {$comNeed * $password * $access} *
        q!: * {$receiveInf * $password * $access} *

        q!: * $how * $loginInf *
        q!: $loginInf (на (сайт/$stoloto/$accountAcc)/в ($stoloto/$accountAcc))
        q!: * $loginInf * {$password * ($ne (пускает/пропускает)/непускает/нипускает/непропускает/нипропускает)} *

        q!: * $cantLogIn * [$getPrizInf] * [$prizeAndSum] * [$getPrizInf] *
        q!: * [$getPrizInf] * [$prizeAndSum] * [$getPrizInf] * $cantLogIn *
        q!: * попасть [в/на] $account *
        q!: * ($how/$comNeed) попасть * (в/на) [$comMy] ($accountAcc/$stoloto/сайт) *

        q!: * ($again/$comNow) ($ne войти/невойти) *
        q!: * входить $ne стало *

        q!: * ($cantPastPres/$want/могу) * $resetInf * (вход/доступ) *

        q!: * {$comNeed * вход * ($account/$stoloto/~сайт)} *
        q!: * {$cantPastPres * вход * ~сайт} *

        q!: [$helloAll] {$comNo ~вход (в $account)}
        q!: [$helloAll] ($cantPastPres/$how) $resetInfAll $access

        q!: * {$comNeed * $access * $account} *
        q!: * {$comNo * $access * ((в/на) [$comMy] $accountAcc/к [$comMy] $account)} *
        q!: * {$resetInfAll * $access * $account} *
        q!: * {$resetImpAll * $access * $account} *
        q!: * {$resetNoun * $access * $account} *
        q!: * {получить * $access * $account} *

        intent!: /Account/HowToResetPassword
        # Проверка iF MOBILE пока не реализована на сторое Webim
        if: $session.location === 'default' || $session.location === 'premiumclub' || $session.location === 'autorised' || $session.location === 'notautorised' || $session.location === 'default' || $session.location === 'default_1'
            a: Если Вы не помните данные для входа в личный кабинет, то Вы можете воспользоваться функцией «Забыли пароль». Для того чтобы изменить пароль, пройдите, пожалуйста, по ссылке из письма, которое поступит на адрес электронной почты, указанный при регистрации личного кабинета, и введите новый пароль. В случае, если письмо не было Вам доставлено, проверьте, пожалуйста, папку «Спам» или «Нежелательная почта».
        else:
            a: Для восстановления пароля через мобильное приложение воспользуйтесь, пожалуйста, кнопкой «Забыли пароль». Далее в открывшемся поле введите Ваш адрес электронной почты, на который зарегистрирован Ваш кабинет, и нажмите «Сбросить пароль». На указанный Вами адрес электронной почты поступит письмо с кодом подтверждения. Данный код необходимо скопировать и вставить в открывшемся окне на странице нашего сайта. Далее введите Ваш новый пароль и нажмите «Изменить пароль». Обратите, пожалуйста, внимание, что иногда письма от Столото могут попадать в папку «Спам». Если при восстановлении пароля возникли сложности, напишите нам, пожалуйста.

        state: AlreadyTried || fromState = /Account/HowToResetPassword
            q: * $tryPast *
            q: уже
            q: * $cantPastPres *
            q: * $smsComePastPresNe *
            q: * $receivePastNe *
            q: * $findPastPresNe *
            q: * $helpPastPresNe *
            q: * $problem *
            q: * возникл* *
            script: Webim.switch();


    state: IForgotMyLogin
        # Я забыл свой логин
        q!: * {$forgetPastPres * $login} *
        intent!: /Account/IForgotMyLogin
        a: Логином является адрес электронной почты или номер телефона, который Вы указывали при регистрации.


    state: IForgotMyLoginAndPassword
        # Я забыл свой логин и пароль
        q!: * [$prizeAndSum] * [$getPrizInf] * [$prizeAndSum] * {$forgetPastPres * ([$ne] $login) * ([$ne] $password)} * [$prizeAndSum] * [$getPrizInf] * [$prizeAndSum] *

        q!: * $forgetPastPres [$comMy] данные [указан*] $duringRegistration *
        q!: * $wrong {$login (и/$or) $password} *
        q!: * ($resetInf/$resetNoun) {$login [и] $password} *
        q!: * {$login [и] $password} $resetInf *

        intent!: /Account/IForgotMyLoginAndPassword
        if: $session.location === 'default' || $session.location === 'premiumclub' || $session.location === 'autorised' || $session.location === 'notautorised' || $session.location === 'default' || $session.location === 'default_1'
            a: Логином является адрес электронной почты или номер телефона, который Вы указывали при регистрации.\n\nЕсли Вы не помните пароль для входа в личный кабинет, то Вы можете воспользоваться функцией «Забыли пароль». Для того чтобы изменить пароль, пройдите, пожалуйста, по ссылке из письма, которое поступит на адрес электронной почты, указанный при регистрации личного кабинета, и введите новый пароль. В случае, если письмо не было Вам доставлено, проверьте, пожалуйста, папку «Спам» или «Нежелательная почта».
        else:
            a: Логином является адрес электронной почты или номер телефона, который Вы указывали при регистрации.\n\nДля восстановления пароля через мобильное приложение воспользуйтесь, пожалуйста, кнопкой «Забыли пароль». Далее в открывшемся поле введите Ваш адрес электронной почты, на который зарегистрирован Ваш кабинет, и нажмите «Сбросить пароль». На указанный Вами адрес электронной почты поступит письмо с кодом подтверждения. Данный код необходимо скопировать и вставить в открывшемся окне на странице нашего сайта. Далее введите Ваш новый пароль и нажмите «Изменить пароль». Обратите, пожалуйста, внимание, что иногда письма от Столото могут попадать в папку «Спам». Если при восстановлении пароля возникли сложности, напишите нам, пожалуйста.


    state: StrangeConfirmationCode
        # Странный код подтверждения

        q!: * [$password/$resetNoun/попасть/$smsComePastPres] * ((много/множеств*/$quantity/набор/~куча) {букв и ($numeral/чисел)}/(множеств*/~куча/$quantity) (символ*/знаков)) * [$password/$resetNoun/попасть/$smsComePastPres] *
        q!: * $recoveryCode из $oneWord (символ*/знаков) *

        q!: * ($resetPassword/$password/попасть/$code/$letter/$link) * $characterSet *
        q!: * $characterSet * ($resetPassword/$password/$code/$letter/$link) *

        q!: * $resetPassword * {($code/$letter/$link) [такой/какой-то/какой то] $strange} *
        q!: * {$code [такой/какой-то/какой то] $strange} * $resetPassword *

        q!: * {$recoveryCode [такой/какой-то/какой то/слишк*] ($strange/большой)} *
        q!: * ($recoveryCode/$password) * (длинный/длиннющ*) *
        q!: * {$recoveryCode * ((~такой/~какой) ~формат)} *
        q!: * $code $confirmation * такой *
        q!: * {$recoveryCode * $smsComePastPres * ($wrong/$strange/белиберда)} *
        q!: * {$recoveryCode * ($ne (читает*/читаец*)/нечитает*/ничитает*/нечитаец*/ничитаец*)} *

        q!: * {[восстанавл*/востанавлив*/$resetPassword/$resetNoun/$password] * $smsComePastPres * $hieroglyph} *
        q!: * $hieroglyph * $password *

        q!: * {($instead ($code/$password) [для] $resetNoun) * $smsComePastPres} *

        q!: * (это/вот $comWhat) * $smsComePastPres * для ($resetNoun/$changeNoun) $password *

        q!: * (восстанавл*/востанавлив*/$resetPassword) * $smsComePastPres * $comWhat * $strange *
        q!: * (восстанавл*/востанавлив*/$resetPassword) * {(вот ($comWhat/это)) * $smsComePastPres} *

        q!: * какие * (~знак/символ*) * ($inputInf/набрать/набирать) * (восстанавл*/востанавлив*/$resetPassword/$resetNoun/$password) *
        q!: * (восстанавл*/востанавлив*/$resetPassword/$resetNoun/$password) * какие * (~знак/символ*) * ($inputInf/набрать/набирать) *

        q!: * какие (~знак/символ*) * должны быть * (восстанавл*/востанавлив*/$resetPassword/$resetNoun/$password) *
        q!: * (восстанавл*/востанавлив*/$resetPassword/$resetNoun/$password) * какие (~знак/символ*) * должны быть *

        q!: * Вы запросили операцию восстановления пароля * Код подтверждения для смены *

        # куда вводить код восстановления пароля
        q!: * $code * $resetNoun * $comWhat $with * $doInfLocal *
        q!: * {($comWhere/куда/~какой (~место/граф*/~поле)/$how) * ($inputInf/набрать/набирать) * ($code * $resetNoun)} *
        # забыла пароль, прислали пароль, как его ввести
        q!: * (восстанавл*/востанавлив*/$resetPassword/$resetNoun) * ($comWhere/куда/~какой (~место/граф*/~поле)/$how) * ($inputInf/набрать/набирать) *

        intent!: /Account/StrangeConfirmationCode
        a: При восстановлении пароля через мобильное приложение Вам поступит код. Код подтверждения при смене пароля представляет собой длинную последовательность цифр и букв. Скопируйте, пожалуйста, данный код и вставьте в открывшемся окне на странице нашего сайта. Далее введите Ваш новый пароль и нажмите «Изменить пароль».


    state: TroublesWithChangingPassword
        # пытаюсь сменить пароль, ввожу код - и ничего
        q!: * $resetPassword * {($code/$confirmation) * ($indicatePresSg1/$indicatePast)} * $nothing *
        q!: * {$recoveryCode2 * ($ne (считывает*/считываец*/проходит)/несчитывает*/нисчитывает*/несчитываец*/нисчитываец*/непроходит/нипроходит)} *

        # пытаюсь восстановить, ввожу код, пишут, что неверный код
        q!: * $resetPassword * ($indicatePresSg1/$indicatePast) * $isWritten * ($wrong/$incorrectly) *
        q!: * $resetPassword * $isWritten * {($wrong/$incorrectly) * ($code/$password)} *
        q!: * ($resetPassword/$cantLogIn) * (получен*/прислан*) ($code/$password) $wrong *
        q!: * ($resetPassword/$cantLogIn) * ($code/$password) * кот* * прислал* * $wrong *

        # Не могу ввести код подтверждения при смене пароля
        q!: * ($resetPassword/$cantLogIn) * {$cantPastPresAll * $inputInf * ($code/$confirmation)} *
        q!: * {$cantPastPresAll * $inputInf * ($code/$confirmation)} * ($resetPassword/$cantLogIn) *

        q!: * ($resetPassword/$cantLogIn) * {$inputPresSg3Ne * ($code/$confirmation)} *
        q!: * {$inputPresSg3Ne * ($code/$confirmation)} * ($resetPassword/$cantLogIn) *

        # Когда ввожу новый пароль не кликается кнопка Сменить пароль, т.е. последнее действие не совершается. Почему?
        q!: * {$button * ($resetPassword/$green) * $activeNe} *
        q!: * $resetPassword * нажмите на кнопк* * $nothing *
        q!: * {$resetPassword * $button * $cantPastPres} *

        # сменить пароль, нет кнопки
        q!: * $resetPassword * {$button ($comNo/$displayPresSg3Ne/отсутств*)} *
        q!: * {$button (($changeInf/$forgetPastPres) $password/$password ($changeInf/$forgetPastPres)) ($comNo/$displayPresSg3Ne/отсутств*)} *

        # Захожу восстановления пароля, пишет вам было отправлено 10 писем, обратитесь в службу поддержки, может в этом причина
        q!: * $resetPassword * (10/~десять) $letter *
        q!: * $resetPassword * ($limit/$quantity) [$oneWord] ~попытка *

        # Пытаюсь сменить пароль - не могу перейти по ссылке
        q!: * ($resetPassword/$enterInf) * ($badLink/(прохожу/проходим) (по/$via) $link) *
        q!: * ($badLink/(прохожу/проходим) (по/$via) $link) * ($resetPassword/$enterInf) *

        q!: * $resetPassword * (попадаю/попадаем) $ne туда *
        q!: * (попадаю/попадаем) $ne туда * $resetPassword *

        q!: * (по/$via) $link ($changeInf $password/$password $changeInf) * $but *
        q!: * $ne на страниц* $resetNoun $password *

        q!: * $resetPassword * $recoveryCode * ($openPastNe/$openPres3Ne) *


        # все равно не могу сменить пароль
        q!: * все (равно/ровно) * {$cantPastPresAll * ($resetInfAll/$changeInf) * $password} *
        q!: * {$cantPastPresAll * $inputInf * (~новый $password)} *

        q!: * $resetPassword * {(все (равно/ровно)) * $cantPastPresAll} *
        q!: * {$resetPassword * ((делаю/делаем/сделал*) [вроде] [бы] все как (*казано/*казал*/написано))} *
        q!: * {$resetPassword * (много раз)} *

        # пароль поменял, все равно не могу войти
        q!: * {$changePast * $password} * все (равно/ровно) *
        q!: * {$changePast * $password} * ($wrong $password/$password $wrong) *
        q!: * $indicatePresSg1 новый $password * ($wrong $password/$password $wrong/возвращае* [на/к] страниц*) *


        # страница восстановления пароля не работает
        q!: * {(($tab/~страница) $resetNoun) * $workPres3SgNe} *
        q!: * $resetPassword * {($tab/~страница) * $workPres3SgNe} *


        go!: /RegistrationData


    state: HowToChangeEmail
        # Как поменять почту
        q!: * {$changePast [$comMy/изнач*] $mail} *
        q!: * {$changePast * $mail * (на $localEmail)} *
        q!: * {$changePast $mail} * {$phoneAndNum * $former} *
        q!: * {$phoneAndNum * $former} * {$changePast $mail} *
        q!: * {$changeInf * $mail * (на номере)} *
        q!: [$helloAll] {$changeInfAll [$comMy] $mail}
        q!: [$helloAll] {[$how] ввести ~другой $mail}
        q!: * {$changeInfAll ([$comMy] $mail) (в [$comMy] $account)} *
        q!: * {$how [мне] ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {($changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} на сайте *
        q!: * {$want ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {$comWhere [мне] ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {([$how] $possiblePredicAll) [мне] [его] ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {(могу [$li] [я]) [сам*] ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {смогу [сам*] ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {$comNeed ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {($changeInfAll [$somehow]) $inLK $mail} *
        q!: * $changeInf [$comMy] $mail на (новый/новую) *
        q!: * {$cantPastPresAll $changeInfAll [$comMy] [устаревш*] $mail} *
        q!: * {$how [мне] $attachInf ($new $mail)} *
        q!: * {$want $attachInf ($new $mail)} *
        q!: * {$comWhere [мне] $attachInf ($new $mail)} *
        q!: * {$possiblePredicAll [мне] $attachInf ($new $mail)} *
        q!: * {могу [сам*] $attachInf ($new $mail)} *
        q!: * {смогу [сам*] $attachInf ($new $mail)} *
        q!: * {$comNeed $attachInf ($new $mail)} *
        q!: * {$cantPastPresAll $attachInf ($new $mail)} *
        q!: * {$changeNe $mail} *
        q!: указать $new $mail
        q!: * {$mail [мне/ко мне] (больше/уже) $belongPresSg3Ne} *
        q!: * (у меня/теперь) ~новый $mail * [$changeInfAll] [$comMy] [$mail] *
        q!: * (теперь/сейчас/уже) ~другой $mail * [$changeInfAll] [$comMy] [$mail] *
        q!: * $usedPresNe (больше/уже) (эту/этот/этой/этим) $mail *
        q!: * $mail * (больше/более) ($ne (доступн*/доступен/доступин/активн*/активен)/неактивн*/неактивен/недоступн*/недоступен/недоступин/нидоступн*/нидоступен/нидоступин/ниактивн*/ниактивен) *
        q!: * {$registerInf ($new $mail) (на [$oneWord] $phoneAndNum)} *

        q: * $mail * || fromState = /Account/HowToChangeData
        q: * $mail * || fromState = /Account/HowToChangeDataInLK
        intent!: /Account/HowToChangeEmail
        a: Изменить адрес электронной почты можно только на основной версии сайта www.stoloto.ru (вход осуществляется через браузер). Для изменения адреса почты, пожалуйста, войдите в раздел «Профиль» Вашего личного кабинета, далее «Анкета».\n\nШаги изменения следующие:\n- сначала вводите новый адрес почты, на который хотите произвести изменение (нельзя ввести адрес, который уже использован для другой регистрации на нашем сайте). На указанный Вами новый адрес высылается сообщение с ссылкой для подтверждения;\n- после перехода по ссылке (из сообщения, поступившего на новую почту) на номер телефона от личного кабинета высылается код подтверждения, его тут же нужно ввести в соответствующее поле, только после этого новый адрес вступит в силу.\n\nЕсли у Вас возникнут вопросы, напишите нам, пожалуйста.

        state: HowToResetPassword
            q: * {получить * $password} *
            q: * {$lostPast * $password} *
            q: * {$forgetPastPres * $password} *
            q: * {$cantPastPres * вспомнить * $password} *
            q: * {$cantPastPres настроит* $password} *
            q: * {$changeInf * $password} *
            q: * {$changeImp * $password} *
            q: * {$resetInfAll * $password} *
            q: * {$resetImpAll * $password} *
            q: * {$resetNoun * $password} *
            q: * {$changeNoun * $password} *
            q: * {$wrong $password} *
            q: * {$findOutInf * $password * ~вход} *
            q: * {$comNeed * $password * ~вход} *
            q: * {$receiveInf * $password * ~вход} *
            q: * {$findOutInf * $password * $access} *
            q: * {$comNeed * $password * $access} *
            q: * {$receiveInf * $password * $access} *
            q: * $how * $loginInf *
            q: * $cantLogIn *
            q: * $how попасть в $accountAcc *
            q: * {$comNeed * вход * $account} *
            q: * {$comNeed * вход * ~сайт} *
            q: * {$comNeed * вход * $stoloto} *
            q: * {$comNeed * $access * $account} *
            q: * {$comNo * $access * $account} *
            q: * {$resetInfAll * $access * $account} *
            q: * {$resetImpAll * $access * $account} *
            q: * {$resetNoun * $access * $account} *
            q: * {вернуть * (доступ/доспуп)} *
            go!: /Account/EmailChangeResetPassword


        state: IncorrectEmailAtRegistration
            q: * {$incorrectly * $indicatePast * $duringRegistration} *
            q: * {$wrong * $indicatePast * $duringRegistration} *
            q: * {$incorrectly * $indicatePartPas * $duringRegistration} *
            q: * {$wrong * $indicatePartPas * $duringRegistration} *
            go!: /Account/IncorrectEmailAtRegistration


    state: IncorrectEmailAtRegistration
        # Неправильно указал почту при регистрации
        q!: * {$changeImpAll * $mail * [на $localEmail]} *
        q!: * {$askYou $changeInfAll [$comMy] [устаревш*] $mail} *
        #q!: * {($correction/$changeNoun) * $mail} *
        q!: * {$changeInfAll * $mail * (для $registration/$forTo $registerInfRefl)} *
        q!: * {$changeInfAll * $mail * завершить * $registration} *
        q!: * {$changeInfAll * $mail * ~завершение * $registration} *
        q!: * {$changeNe * $mail * завершить * $registration} *
        q!: * {$changeNe * $mail * ~завершение * $registration} *
        q!: * {$changeInfAll * $mail * (~полный $registration)} *
        q!: * {$changeInfAll * $mail * ($wrong $duringRegistration)} *
        q!: * {$changeNe * $mail * ($wrong $duringRegistration)} *
        q!: * {$changeInfAll $mail $duringRegistration} *
        q!: * {$changeNe $mail $duringRegistration} *
        q!: * {($ne ~тот $mail) * $duringRegistration} *
        q!: * [$changeInfAll] * {$wrong [$indicatePast] $mail [я]} * [$changeInfAll] *
        q!: * [$changeInfAll] * {$wrong $indicatePartPas $mail [~окончание]} * [$changeInfAll] *
        q!: * [$changeInfAll] * {$wrong введен* $mail} * [$changeInfAll] *
        q!: * [$changeInfAll] * {ошибочн* введен* $mail} * [$changeInfAll] *
        q!: * {$incorrectly * $mail * $registration} *
        q!: * {$incorrectly * $indicatePartPas * $mail * $duringRegistration} *
        q!: * {$incorrectly * $mail * $registerPast3} *
        q!: * {($old $mail) * $registration} *
        q!: * {($old $mail) * $registerPast3} *
        q!: * [$changeInfAll] * {$incorrectly [$comMy] $mail $indicatePast [я]} * [$changeInfAll] *
        q!: * [$changeInfAll] * {$incorrectly [$comMy] $mail $indicatePartPas [~окончание]} * [$changeInfAll] *
        q!: * [$changeInfAll] * {$incorrectly [$comMy] введен* [~окончание] $mail} * [$changeInfAll] *
        q!: * {$makeAMistakePast * $mail * [$changeInfAll]} *
        q!: * {$mistake * $mail * [$changeInfAll]} *
        q!: * {~буква * $mail * [$changeInfAll]} *
        q!: * {$numeral * $mail * [$changeInfAll]} *
        q!: * $duringRegistration $makeAMistakePast на (одну/1) букву *

        q!: * [$changeInfAll] * (пропустил*/пропущен*) $oneWord в $mail * [$changeInfAll] *
        q!: * [$changeInfAll/$registerInfRefl] * {($ne ~тот) $mail} * [$changeInfAll/$registerInfRefl] *
        q!: * [$changeInfAll] * {$indicatePast * (нету $mail)} * [$changeInfAll] *
        q!: [$helloAll] [$comMy] $correct $mail $localEmail
        q!: [$helloAll] [$comMy] [$correct] $mail $localEmail а $ne $localEmail
        q!: [$helloAll] [$comMy] [$correct] $mail $ne $localEmail а $localEmail
        #q!: * {$mail [$localEmail] сменен} *
        q!: * $localEmail (актуальный/актуальная/правильный/правильная) $localEmail *
        q!: * $attachInf к $phoneAndNum $localMobilePhoneNumber $mail $localEmail *
        q!: * $phoneAndNum [$indicatePast] (верн*/правильн*) а $mail $comNo *
        q!: $mail ($ne подтвержден*/неподтвержден*) * $changeInfAll *
        q: * $mail * || fromState = /Account/HowToChangeDataAtRegistration
        intent!: /Account/IncorrectEmailAtRegistration
        a: Уточните, пожалуйста, номер телефона и адрес электронной почты, которые Вы указывали при регистрации, а также верный адрес почты, мы поможем Вам произвести замену.

        state: GetUserData || fromState = /Account/IncorrectEmailAtRegistration
            q: * [$helloAll] {[$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script: Webim.switch();


    state: EmailChangeResetPassword
        # Здравствуйте изменилась Почта, пароль можно восстановить по номеру телефона?
        q!: * другой способ [для] (восстановления/$resetInf) *
        q!: * {($resetInfAll/$resetNoun) * [$password] * ((другим/иным) способом/по другому/по-другому)} *

        q!: * [$how] * [$resetInfAll/$loginInf] * {[больше] [тоже] ($comNo/$havePresSg1Ne) $access ((к/ка/на) [указ*/эт*/той/ту/данн*] $mail)} * [$how] * [$resetInfAll/$loginInf] *

        q!: * {$cantPastPresAll $resetInf (доступ/доспуп/$accountAcc) ($by $mail)} *

        q!: * {$resetInf [доступ/доспуп/$accountAcc] $withoutEmail} *
        q!: * {$withoutEmail $possiblePredicAll} *
        q!: * {$withoutEmail * $resetInf} *
        q!: * {$loginInf * $withoutEmail} *
        q!: * $how сделать * $withoutEmail *
        q!: * {$password * $withoutEmail} *

        q!: * {($resetInfAll/$resetNoun) * ($by [$comMy] $mail) * $cantPastPres} *

        q!: * {($comNo/$havePresSg1Ne) [эт*/той/того] $mail (уже/больше)} *
        q!: * ($comNo/$havePresSg1Ne) (данной/данного/эт*) $mail $comNow *
        q!: * {($lostPast/утратил*) $access (к [эт*] $mail)} *
        q!: * $mail {(уже/давно) [т*]} удалил* *
        q!: * {$cantPastPresAll ($loginInf/попасть) ([$too] [и] (в/на) [$comMy] [т*] $mail)} *
        q!: * $mail давно ($other/$new/$comNo) *
        q!: * $mail ($other/$new) $comNow *
        q!: * {$other уже $mail} *
        q!: * у меня $other $mail *
        q!: * {$mail * ($ne актуальн*/неактуальн*/ниактуальн*)} *
        q!: * {$ownPres1Ne * $mail} *

        q!: * {($changeInf/переделать/переделайте) * $mail} * ($resetPassword/$cantLogIn) *

        q!: * $noAccessToEmail * ($resetPassword/$cantLogIn) *
        q!: * ($resetPassword/$cantLogIn) * $noAccessToEmail *

        q!: * {($password/$resetNoun) * (на $new $mail)} *
        q!: * $newMail * $resetPassword *
        q!: * $resetPassword * $newMail *
        q!: * {$changeInf * $mail * (($resetNoun/$changeNoun) $password)} *

        q!: * {$changeInf * $mail} * $resetPassword *
        q!: * $resetPassword * {$changeInf * $mail} *

        q!: * ($newMail/$noAccessToEmail) * {$how * $loginInf} *
        q!: * {$how * $loginInf} * ($newMail/$noAccessToEmail) *

        q!: * $newMail * ($cantLogIn/$comNeed $loginInf) *
        q!: * ($cantLogIn/$comNeed $loginInf) * $newMail *
        q!: * {$changePast $mail} * $how * $registerInfRefl *
        q!: * $newMail * {$sendMeImp * $sms * $code} *

        q!: * {$password * ($password к ней) * $lostPast} *

        q!: * указывал* $mail * {$access (к ней) ($comNo/$havePresSg1Ne)} * ($resetInfAll/$resetNoun/$resetPassword) *
        q!: * указывал* $mail * {(ей/ее) $usedPresNe} * ($resetInfAll/$resetNoun/$resetPassword) *

        q!: * {($forgetPastPres/$knowNe/$lostPast) * $password * (от [$comMy] $old $mail)} *
        q!: * {($forgetPastPres/$knowNe/$lostPast) * $password * ((от/к/для) [$comMy] $mail)} *
        q!: * {($forgetPastPres/$knowNe/$lostPast) $password (на [$comMy] $mail)} *
        q!: * ($forgetPastPres/$knowNe/$lostPast) $password [$comMy] $mail $forTo * $enterInf *

        q!: * (потерял*/утерял*) [$comMy] $mail * $resetInfAll [$comMy] ($password/аккаунт) *

        q!: * {$changeInf $mail} $forTo $loginInf * [$account] *
        q!: * $cantLogIn * {$changeInfAll * $mail} *
        q!: * $how * $loginInf * [$account] * {$changeInf * $mail} *

        q!: * $wrongEmail * ($cantLogIn/$resetPassword) *
        q!: * ($cantLogIn/$resetPassword) * $wrongEmail *

        q!: * {[$changeInf] * $password * ($ne на ~мой $mail)} *
        q!: * {[$changeInf] * $password * ($ne по $mail)} *
        q!: * $cantLogIn * ($ne на ~мой $mail) *

        q!: * {$resetInf * ($by [$comMy] $phoneAndNum)} *

        q!: * {$resetInf ($by [$comMy] $number)} *
        q!: * {$resetImp * (на [$comMy] $number)} *
        q!: * {$resetImpAll * $password * (на [$comMy] $number)} *

        q!: * {(зайти/$loginInf) * ($by [$comMy] $phoneAndNum)} *
        q!: * $by [$comMy] $telephoneNumber $nelzya *
        q!: * {вернуть * (доступ/доспуп) * ($by [$comMy] $phoneAndNum)} *
        q!: * $noAccessToEmail * ($resetInfAll/$sendMeImp/$possiblePredicAll) * (($by/на) ([$comMy] $phoneAndNum/$sms)) *
        q!: * $noAccessToEmail * (($by/на) ([$comMy] $phoneAndNum/$sms)) * ($resetInfAll/$sendMeImp/$possiblePredicAll) *

        q!: * {($resetInfAll/$sendMeImp/$possiblePredicAll) * $password * (($by/на) ([$comMy] $phoneAndNum/$sms))} *
        q!: * {($resetNoun $password) * (($by/на) [$comMy] $phoneAndNum)} *
        q!: * {($code * $resetNoun) * (($by/на) [$comMy] $phoneAndNum)} *

        q!: * {($resetInfAll/$sendMeImp/$possiblePredicAll) * ($code * $resetNoun) * (($by/на) [$comMy] $telephone)} *

        q!: * {$sendMeImp * (для $resetNoun) * (($by/на) [$comMy] $telephone)} *


        q!: * [$resetInfAll] * {($password/$code) * ($smsComePres/пришл*/пришел/$sendPres3) * (~другой $mail)} * [$resetInfAll] *
        q!: * [$resetInfAll] * {($password/$letter/~информация/$confirmation/$code) * ($smsComePres/пришл*/пришел/$sendPres3) * ($old $mail/$ne на ~мой $mail)} * [$resetInfAll] *

        q!: * восстановить * $accountAcc * $cantPastPres * (попасть/войти) * $mail *

        q: * $wrongEmail * || fromState = /Account/HowToResetPassword
        q: * $newMail * || fromState = /Account/HowToResetPassword
        q: * ~другой $mail * || fromState = /Account/HowToResetPassword
        q: * {$changePast $mail} * || fromState = /Account/HowToResetPassword
        q: * {$changePast * $mail * (на $localEmail)} * || fromState = /Account/HowToResetPassword
        q: * {*менен* * $mail} * || fromState = /Account/HowToResetPassword
        q: * {$cantPastPres $resetInfAll $mail} * || fromState = /Account/HowToResetPassword
        q: * {$mail (взломал*/взломан*)} * || fromState = /Account/HowToResetPassword
        q: * {$forgetPastPres * $mail} * || fromState = /Account/HowToResetPassword
        q: * {$comNo $mail} * || fromState = /Account/HowToResetPassword
        q: * {$mail * ~старый} * || fromState = /Account/HowToResetPassword
        q: * {($ne имею) ~доступ (к эт* $mail)} * || fromState = /Account/HowToResetPassword
        q: * $mail * удален* * || fromState = /Account/HowToResetPassword
        q: * {$availableNe * $mail} * || fromState = /Account/HowToResetPassword
        q: * там тоже $comNeed $password * || fromState = /Account/HowToResetPassword

        q: * $wrongEmail * || fromState = /Account/IForgotMyLoginAndPassword
        q: * $newMail * || fromState = /Account/IForgotMyLoginAndPassword
        q: * ~другой $mail * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$changePast $mail} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$changePast * $mail * (на $localEmail)} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {*менен* * $mail} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$cantPastPres $resetInfAll $mail} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$mail (взломал*/взломан*)} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$forgetPastPres * $mail} * || fromState = /Account/IForgotMyLoginAndPassword
        q: {$comNo $mail} || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$mail * ~старый} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {($ne имею) ~доступ (к эт* $mail)} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * $mail * удален* * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$availableNe * $mail} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * там тоже $comNeed $password * || fromState = /Account/IForgotMyLoginAndPassword

        intent!: /Account/EmailChangeResetPassword
        a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.

        state: GetUserData || fromState = /Account/EmailChangeResetPassword
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/EmailChangeResetPassword
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/EmailChangeResetPassword
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();


            state: DontRemember
                q: * $forgetPastPres *
                q: * {$comNo * $mail} *
                q: $comNo
                script: Webim.switch();


    state: SomeoneElsesEmailResetPassword
        # восстановить пароль, чужая почта
        q!: * ($resetPassword/$cantLogIn) * $someoneElsesEmail *
        q!: * $someoneElsesEmail * ($resetPassword/$cantLogIn) *
        q!: * указывает (~чужой/$ne (мой/мою/ту/тот)/$ne знаком*/незнаком*/низнаком*) [мне] $mail *
        q!: * {указан* ((~чужой/$ne (мой/мою/ту/тот)/$ne знаком*/незнаком*/низнаком*) [мне]) $mail} *
        go!: /RegistrationData


    state: WhatEmailDidIEnterDuringRegistration
        # Какую почту я вводил при регистрации?
        q!: * ~какой $mail * вводил* *
        q!: * [$localMobilePhoneNumber] * ~какой * $mail * {(проходил*/производил*/$indicatePast) * $registration} *
        q!: * ~какой * $mail * {(проходил*/производил*/$indicatePast) * $registration} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $findOutInf * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} *
        q!: * $findOutInf * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} * [$localMobilePhoneNumber] *
        q!: * $findOutInf * {$mail $tied ((к/за) ($telephone/$telephoneNumber) [$localMobilePhoneNumber])} *
        q!: * $findOutInf * {$mail $tied ((к/за) $localMobilePhoneNumber)} *
        q!: * [$localMobilePhoneNumber] * $knowNe * $mail * {(вводил*/проходил*/производил*) * $registration} *
        q!: * $knowNe * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $forgetPastPres * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} *
        q!: * $forgetPastPres * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} * [$localMobilePhoneNumber] *

        q!: * [$localMobilePhoneNumber] * ~какой * $mail * {$registered * ($account/я/страница)} *
        q!: * ~какой * $mail * {$registered * ($account/я/страница)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $findOutInf * $mail * {$registered * ($account/я/страница)} *
        q!: * $findOutInf * $mail * {$registered * ($account/я/страница)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $knowNe * $mail * {$registered * ($account/я/страница)} *
        q!: * $knowNe * $mail * {$registered * ($account/я/страница)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $forgetPastPres * $mail * {$registered * ($account/я/страница)} *
        q!: * $forgetPastPres * $mail * {$registered * ($account/я/страница)} * [$localMobilePhoneNumber] *
        q!: * $findOutInf $mail * {(указал*/указывал*/указан*/$indicatePast) * $duringRegistration} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $findOutInf $mail * {(указал*/указывал*/указан*/$indicatePast) * $duringRegistration} *
        q!: * [$localMobilePhoneNumber] * напомните * $mail ~который * {(указал*/указывал*/указан*/$indicatePast) * $duringRegistration} *
        q!: * напомните * $mail ~который * {(указал*/указывал*/указан*/$indicatePast) * $duringRegistration} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $forgetPastPres $mail * $duringRegistration * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * ~какой * $mail * {$registerPast3 * ($account/я)} *
        q!: * ~какой * $mail * {$registerPast3 * ($account/я)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $findOutInf * $mail * {$registerPast3 * ($account/я)} *
        q!: * $findOutInf * $mail * {$registerPast3 * ($account/я)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $knowNe * $mail * {$registerPast3 * ($account/я)} *
        q!: * $knowNe * $mail * {$registerPast3 * ($account/я)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $forgetPastPres * $mail * {$registerPast3 * ($account/я)} *
        q!: * $forgetPastPres * $mail * {$registerPast3 * ($account/я)} * [$localMobilePhoneNumber] *

        q!: * [$localMobilePhoneNumber] * ($forgetPastPres/$knowNe) * $mail * $registerPastRefl3 *
        q!: * ($forgetPastPres/$knowNe) * $mail * $registerPastRefl3 * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * {$forgetPastPres $mail} * [$localMobilePhoneNumber] *

        # Забыл пароль и почту
        q!: * $forgetPastPres [$comMy] {$mail и ($password [от [$comMy] $account])} *
        q!: * {$forgetPastPres [$comMy] $password} и [$comMy] $mail *
        q!: * {$forgetPastPres [$comMy] $password} [и] [$comMy] $mail $too *
        q!: * {$forgetPastPres [$comMy] $password} * и (учетную запись/учетку) *

        # почту ни пароль, ни адрес я не помню
        q!: * {($mail ($ne $password $ne ~адрес/$ne ~адрес $ne $password)) * $forgetPastPres} *

        q!: * $resetPassword * $forgotEmail *
        q!: * $forgotEmail * $resetPassword *

        q!: * $cantLogIn * $forgotEmail *
        q!: * $forgotEmail * $cantLogIn *

        q!: * (~новый $password) * $forgotEmail *
        q!: * $forgotEmail * (~новый $password) *


        q: * $forgotEmail * || fromState = /Account/HowToResetPassword
        q: * $forgotEmail * || fromState = /Account/IForgotMyLoginAndPassword

        intent!: /Account/WhatEmailDidIEnterDuringRegistration
        script:
            $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
        if: !$session.usrPhoneNumber
            a: Уточните, пожалуйста, номер телефона, с которым проводили регистрацию на сайте.
        else:
            script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/WhatEmailDidIEnterDuringRegistration
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script: Webim.switch();


    state: SuchEmailIsAlreadyRegistered
        # При регистрации пишут, что такая почта уже зарегистрирована
        q!: * $resetPassword * $mailAlreadyExists *

        q!: * ($registerInfRefl/$registerPastContReflSg3Ne/$registerPresSg1) * $mailAlreadyExists *

        q!: * [$isWritten/$registerInfRefl] * {$such $mail $yet $registeredAll} *
        q!: * $isWritten [что] $yet $registeredAll $account на $such $mail *
        q!: * $mail $isWritten [что] (~такой/токой) $registeredAll *

        q!: * $registerPastContReflSg3Ne * {$isWritten * $mail * $registered} *
        q!: * {$isWritten * $mail * $registered} * $registerPastContReflSg3Ne *

        q!: * $indicatePresSg1 * {$isWritten * $mail * $registered} *

        q!: * $registerPastContReflSg3Ne * {$isWritten * $mail * уже * (существует/есть)} *
        q!: * {$isWritten * $mail * уже * (существует/есть)} * $registerPastContReflSg3Ne *

        q!: * $indicatePresSg1 * {$isWritten * $mail * уже * (существует/есть)} *
        q!: * {[$such] $mail $yet $somebody $indicatePast $duringRegistration} *
        q!: * $mail $yet (кем-то/кем то) указан* $duringRegistration *
        q!: * $mail ([был*] использован*/использовал*) ~другой ~человек *
        q!: * $such $mail указан* как $registered *
        q!: * {$changeNe $mail} * $yet $registeredAll *
        q!: * (кто-то/кто то) $yet $existPresSg3 $with [эт*/так*/дан*] $mail *

        intent!: /Account/SuchEmailIsAlreadyRegistered
        a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.

        state: GetUserData || fromState = /Account/SuchEmailIsAlreadyRegistered
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/SuchEmailIsAlreadyRegistered
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/SuchEmailIsAlreadyRegistered
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();


    state: UserWithSuchDataAlreadyExists
        # Пользователь с такими данными уже есть в системе
        q!: * [$isWritten] * (такие/такой/такая/эти/этот/$comMy) {$phoneAndNum и ([$comMy] $mail)} [$yet] ($registeredAll/существуют/используют*) *
        q!: * $isWritten * (существует/существуют) [такие/такой/такая/эти/этот/$comMy]  {$phoneAndNum и ([$comMy] $mail)} *
        q!: * [$isWritten] * такие данные [$yet] ($registered/существуют/есть/используют*) *
        q!: * [$isWritten] * такой (пользователь/аккаунт) [$yet] $registeredAll * [$cantPastPresAll] *
        q!: * (кто-то/кто то) $yet $existPresSg3 $with [эт*/так*/дан*] (данными/{$mail и $phoneAndNum}) *
        intent!: /Account/UserWithSuchDataAlreadyExists
        a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.

        state: GetUserData || fromState = /Account/UserWithSuchDataAlreadyExists
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/UserWithSuchDataAlreadyExists
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/UserWithSuchDataAlreadyExists
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();


    state: HowToSetUpMailForwarding
        # Как настроить переадресацию писем?
        q!: * (настроит*/сделат*/произвести) * $mailForwarding
        q!: * $mailForwarding * (настроит*/сделат*/произвести)
        q!: * {настроит* * $mailForwarding * $mail} *
        q!: * {настроит* * $mailForwarding * $letter} *
        q!: * {сделат* * $mailForwarding * $mail} *
        q!: * {сделат* * $mailForwarding * $letter} *
        q!: * {произвести * $mailForwarding * $mail} *
        q!: * {произвести * $mailForwarding * $letter} *
        q!: * $comWhere * $mailForwarding *
        intent!: /Account/HowToSetUpMailForwarding
        a: Данную информацию Вы можете уточнить в службе поддержки Вашего почтового сервера.


    state: HowToChangeName
        # Как сменить имя
        # Как изменить фамилию
        q!: * {$changeInfImpAll * ~имя} *
        q!: * {$changeInfImpAll * ~фамилия} *
        q!: * {переделать * ~имя} *
        q!: * {переделать * ~фамилия} *
        q!: * {$incorrectly * $indicatePast * ~имя} *
        q!: * {$incorrectly * $indicatePast * ~фамилия} *
        q!: * {$changePast * ~фамилия} *
        q!: * $indicatePast $ne $comMy ~имя *
        q!: * $indicatePast $ne $comMy ~фамилия *
        q!: * $indicatePartPas ($ne $comMy/чужое) ~имя *
        q!: * $indicatePartPas ($ne $comMy/чужая) ~фамилия *
        q!: * ~фамилия $comMy а ~имя [отчество] ($ne $comMy/чужое) *
        q!: * я $ne $name (я/а) $name *
        q!: * меня зовут $ne $name (я/а) $name *
        q!: * $comMy ~имя $ne $name (я/а) $name *
        q: * (~имя/~фамилия) * || fromState = /Account/HowToChangeData
        q: * (~имя/~фамилия) * || fromState = /Account/HowToChangeDataInLK
        q: * (~имя/~фамилия) * || fromState = /Account/HowToChangeDataAtRegistration
        intent!: /Account/HowToChangeName
        a: Изменить имя можно только на основной версии сайта www.stoloto.ru (вход осуществляется через браузер). Для изменения имени, пожалуйста, войдите в Ваш личный кабинет и нажмите на «Редактировать данные».


    state: HowToChangeData
        # Как изменить данные
        q!: * {($changeInf/$editInf) [$comMy] данные} *
        intent!: /Account/HowToChangeData
        a: Уточните, пожалуйста, какие данные Вы хотите изменить?


    state: HowToChangeDataInLK
        # Как изменить данные в лк
        q!: * {($changeInf/$editInf) [$comMy] данные} * ($account/анкет*/$application/сайте/странице/настройках) *
        q!: * ($account/анкет*/$application/сайте/странице/настройках) * {($changeInf/$editInf) [$comMy] данные} *
        intent!: /Account/HowToChangeDataInLK
        a: Уточните, пожалуйста, какие данные Вы хотите изменить?


    state: HowToChangeDataAtRegistration
        # Как изменить данные при регистрации
        q!: * {($changeInf/$editInf) [$comMy] данные $duringRegistration} *
        intent!: /Account/HowToChangeDataAtRegistration
        a: Уточните, пожалуйста, какие данные Вы хотите изменить?


















