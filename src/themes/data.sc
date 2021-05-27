theme: /


    state: RegistrationData
        a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.


        state: GetUserData || fromState = /RegistrationData
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /RegistrationData
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /RegistrationData
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