require: inputNumber.sc
require: inputText.sc
require: operator.sc
require: confirmation.sc
require: inputDateTime.sc
require: inputFile.sc
require: inputPhoneNumber.sc
require: http.sc
require: sendSms.sc
#Этот импорт закомментирован для того, чтобы при прохождении тк на блоки не появлялось ошибки из-за неподключенной интеграции google.
#require: googleSheet.sc

theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.
        
    state: noMatch
        event!: noMatch
        a: Не понял.