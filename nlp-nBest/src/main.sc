theme: /
    
    state:
        q: *
        script:
            var res = $nlp.matchNBest($parseTree.text, "/", 10)
            res.forEach(function(r) {
                $reactions.answer(JSON.stringify(r));
            })
                
    state: 
        q!: привет*
        a: Спасибо за приветствие
        
    state:
        q!: пока*
        a: Спасибо за прощание