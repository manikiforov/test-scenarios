require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём. или нет
    
    state: Hello
        intent!: /привет
        a: Привет приветa

    state: Bye
        intent!: /пока
        a: Пока покацфвфцв

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

