require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        a: Привет приветушки

    state: Bye
        intent!: /пока
        a: Пока пока1

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

