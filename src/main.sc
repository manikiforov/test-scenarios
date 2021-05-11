require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём!3332
        
        
        
    state: image1
        q!: jpgo
        script:
            $response.replies = []
            $response.replies.push( {
                type: "image",
                imageUrl: "https://248305.selcdn.ru/zenbot_dev_ca/telegram/kirill_yarulin/100015003-file_uploader-100015003-Cwo-602500161/JTM59X0yay.jpg",
                text: "описание изображения.jpg"      
            } )
            
    state: image2
        q!: pngo
        script:
            $response.replies = []
            $response.replies.push( {
                type: "image",
                imageUrl: "https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png",
                text: "описание изображения.png"      
            } )
            
    state: image3
        q!: jpg
        image: https://248305.selcdn.ru/zenbot_dev_ca/telegram/kirill_yarulin/100015003-file_uploader-100015003-Cwo-602500161/JTM59X0yay.jpg
        
    state: image4
        q!: png
        image: https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png
        
    state:
        q!: чпоньк
        a: атата
        
    state:
        q!: шпуньк
        a: ататата    

    state: Hello
        intent!: /привет
        a: Привет-привет!

    state: Bye
        intent!: /пока
        a: Пока-пока!

    state: NoMatch
        intent!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

