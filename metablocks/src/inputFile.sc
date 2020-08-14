theme: /
    state: toInputFile
        q!: inputFile
        go!: /InputFile

    state: InputFile
        InputFile:
            prompt = Прикрепите файл
            varName = file
            then = /newNode_fileSent
            errorState = /newNode_errorFile
            actions = []

    state: newNode_fileSent
        a: Файл успешно загружен - {{$session.file}}

    state: newNode_errorFile
        a: Ошибка загрузки файла