require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём
        
    state: image1
        q!: image1
        script:
            $response.replies = []
            $response.replies.push( {
                type: "image",
                imageUrl: "https://248305.selcdn.ru/zenbot_dev_ca/telegram/kirill_yarulin/100015003-file_uploader-100015003-Cwo-602500161/JTM59X0yay.jpg",
                text: "описание изображения"      
            } )
            
    state: image2
        q!: image2
        script:
            $response.replies = []
            $response.replies.push( {
                type: "image",
                imageUrl: "https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png",
                text: "описание изображения"      
            } )
            
    state: image3
        q!: image3
        image: https://248305.selcdn.ru/zenbot_dev_ca/telegram/kirill_yarulin/100015003-file_uploader-100015003-Cwo-602500161/JTM59X0yay.jpg
        
    state: image4
        q!: image4
        image: https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png
        
    state:
        q!: чпоньк
        a: атата

    state: Hello
        intent!: /привет
        a: Привет привет!!!!cgfhcg

    state: Bye
        intent!: /пока
        a: Пока пока!!!!

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

