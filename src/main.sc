require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём test

    state: Hello
        intent!: /привет
        a: Привет привет!!!!cgfhcg

    state: Bye
        intent!: /пока
        a: Пока пока!!!!

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

