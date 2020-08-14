require: inputNumber.sc
require: inputText.sc
require: operator.sc
require: confirmation.sc
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.
        
    state: noMatch
        event!: noMatch
        a: Не понял.