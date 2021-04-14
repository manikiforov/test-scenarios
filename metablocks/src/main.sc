require: inputNumber.sc
require: inputText.sc
require: operator.sc
require: confirmation.sc
require: inputDateTime.sc
require: inputFile.sc
require: inputPhoneNumber.sc
require: http.sc
require: sendSms.sc
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.
        
    state: noMatch
        event!: noMatch
        a: Не понял.