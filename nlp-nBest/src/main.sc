patterns:
    $Text = $nonEmptyGarbage || converter = function ($pt) { return $pt.text; }

init:
    // короткий псевдоним для функции вывода ответа
    $global.a = function (t) {
    $reactions.answer(JSON.stringify(t));
    };

theme: /

    state:
        q!: patterns $Text
        script:
            var res = $nlp.matchNBest($parseTree._Text, "/Patterns", 10)
            res.forEach(function(r) {
                $reactions.answer(r.clazz + " - " + r.score.toFixed(2));
            })

    state:
        q!: examples $Text
        script:
            var res = $nlp.matchNBest($parseTree._Text, "/Examples", 10)
            res.forEach(function(r) {
                $reactions.answer(r.clazz + " - " + r.score.toFixed(2));
            })

    state:
        q!: mixed $Text
        script:
            var res = $nlp.matchNBest($parseTree._Text, "/Mixed", 10)
            res.forEach(function(r) {
                $reactions.answer(r.clazz + " - " + r.score.toFixed(2));
            })
            
    state: matchPatterns
        q!: matchP
        script:
            $temp.m = $nlp.matchPatterns("test 1", ["test 1", "test 2"]);
        a:{{JSON.stringify($temp.m)}}
            
    state: matchExamples
        q!: matchE
        script:
            $temp.m = $nlp.matchExamples("раз раз", ["раз", "два", "три"]);
        a:{{JSON.stringify($temp.m)}}


#тестировать будем на фразах:
#раз два
#раз два три
theme: /Patterns

    state: 1
        q: * раз *

    state: 2
        q: * [раз] два *

    state: 3
        q: * [раз] [два] три *

theme: /Examples

    state: 1
        e: раз

    state: 2
        e: раз два

    state: 3
        e: раз два три

theme: /Mixed

    state: e1
        e: раз

    state: e2
        e: раз два

    state: e3
        e: раз два три

    state: q1
        q: * раз *

    state: q2
        q: * [раз] два *

    state: q3
        q: * [раз] [два] три *
