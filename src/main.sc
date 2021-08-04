require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём. или нет или да
    
    state: Hello
        intent!: /привет
        a: Привет привет!!!hehehe

    state: Bye
        intent!: /пока
        a: Пока!!!!!

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

