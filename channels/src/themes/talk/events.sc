theme: /Events


    state: TimeLimit
        event!: timeLimit
        script:
            $reactions.answer(ans.toOperator);
            switchToOperator();


    state: LengthLimit
        event!: lengthLimit
        script:
            $reactions.answer(ans.toOperator);
            switchToOperator();


    state: FileReceived
        event!: fileEvent
        script:
            $reactions.answer(ans.toOperator);
            switchToOperator();


    state: NoMatch
        event!: noMatch
        script:
            var text = $parseTree.text;
            $temp.fixedText = $nlp.fixKeyboardLayout(text);
        if: $temp.fixedText
            script:
                var matchResults = $nlp.match($temp.fixedText, "/");
                if(matchResults){
                    $parseTree = matchResults.parseTree;
                    $temp.nextState = matchResults.targetState;
                    $reactions.transition($temp.nextState);
                } else {
                    $reactions.answer(ans.toOperator);
                    switchToOperator();
                }
        else:
            script:
                $reactions.answer(ans.toOperator);
                switchToOperator();
