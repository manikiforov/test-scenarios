require: number.sc

theme: /

    state: CatchAll || noContext = true
        q!: *
        a: Не понял

    state:
        e: два
        a: ваше число: ДВА

    state:
        e: $Number
        script:
            log($parseTree)
        a: ваше число: {{ $parseTree._Number }}