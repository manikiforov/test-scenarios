require: all.sc
  module = common
require: patterns.sc
  module = common

theme: /

    state: Start
        q!: start
        a: Вы сказали и бот ответил: {{$parseTree.text}}

    state: CatchAll
        q!: *
        a: Скажите боту чтото осмысленное.
        
    state: Testmorphpy
        q!: parseM $AnyWord
        script:
            $temp.m = $nlp.parseMorph($parseTree.AnyWord[0].words);
        a: morph: {{JSON.stringify($temp.m)}}
        a: {{toPrettyString($parseTree.AnyWord)}}
        
    state: TestInflect
        q!: inflect $AnyWord
        script:
            $temp.m = $nlp.inflect($parseTree.AnyWord[0].words);
        a: morph: {{JSON.stringify($temp.m)}}
        a: {{toPrettyString($parseTree.AnyWord)}}
        
    state: TestConform
        q!: conform $AnyWord
        script:
            $temp.m = $nlp.conform($parseTree.AnyWord[0].words, 5);
        a: morph: {{JSON.stringify($temp.m)}}
        a: {{toPrettyString($parseTree.AnyWord)}}