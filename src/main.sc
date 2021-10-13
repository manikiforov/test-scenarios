# Enable basic functions and patterns from zb-common
require: common.js
    module = common
require: patterns.sc
    module = common
require: text/text.sc
    module = common
require: number/number.sc
    module = common
require: number/number.sc
    module = common
require: dateTime/dateTime.sc
    module = common

# Enable Slot-Filling handling
require: slotfilling/slotFilling.sc
    module = sys.zb-common

# Enable newSession handling
require: newSessionOnStart/newSession.sc
    module = common
    injector = { newSessionStartState: "/Welcome", newSessionTimeout: 120 }

theme: /

    state: Welcome
        a: Начнём!

    state: WorkHours
        intent!: /WorkHours
        a: Мы работаем с 9 до 18

    state: Location
        intent!: /Location
        a: Мы находимся на Малом ПС д.5

    # Обрабатываем все интенты с ответами одним стейтом
    state: Match
        event!: match
        a: {{ $context.intent.answer }}

    state: CatchAll || noContext = true
        event!: noMatch
        a: Не понял
    
