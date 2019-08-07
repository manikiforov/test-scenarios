require: /dictionaries/customerOrientationQuestions.csv
  name = customerOrientation
  var = $customerOrientation

require: /dictionaries/teamQuestions.csv
  name = teamQuestions
  var = $teamQuestions
  
require: /dictionaries/communication.csv
  name = communicationQuestions
  var = $communicationQuestions

require: /dictionaries/focus.csv
  name = focusQuestions
  var = $focusQuestions

require: /scripts/question.js

require: /scripts/zenflow.js

require: /scripts/base64.js

require: /scripts/md5.js

require: newSession.sc



init:
    Zenflow.init(); //сделать параметры со своего сайта доступными в виджете в объекте start
    
    $global.sendResultAPI = $injector.sendResultAPI;
    
    if (!$global.$converters) {
        $global.$converters = {};
    }

    $global.$converters
        .customerOrientationConverter = function(parseTree) {
            var id = parseTree.customerOrientation[0].value;
            return $customerOrientation[id].value;
        };

    $global.$converters
        .teamConverter = function(parseTree) {
            var id = parseTree.teamQuestions[0].value;
            return $teamQuestions[id].value;
        };

    $global.$converters
        .communicationConverter = function(parseTree) {
            var id = parseTree.communicationQuestions[0].value;
            return $communicationQuestions[id].value;
        };

    $global.$converters
        .focusConverter = function(parseTree) {
            var id = parseTree.focusQuestions[0].value;
            return $focusQuestions[id].value;
        };
        
    bind("preProcess", function($context) {
        var $session = $jsapi.context().session;
        //Нужен для CatchAll
        $session.lastState =  $context.contextPath;
    });
    
    //$jsapi.bind({
    //   type: "preMatch",
    //   handler: function($context)
    //        {if (!$context.request.query) {
    //            if($temp.complete){
    //                $context.temp.targetState = "/CV/Tell results/Refresh page";
    //            } else {         
    //                $context.temp.targetState = "/CV/Enter";
    //            }
    //        }
    //    },
    //   path: "/",
    //   name: "avoidNullUtterance"
   //});
   
patterns:
    $customerOrientation = $entity<customerOrientation> || converter = $converters.customerOrientationConverter
    $teamQuestions = $entity<teamQuestions> || converter = $converters.teamConverter
    $communicationQuestions = $entity<communicationQuestions> || converter = $converters.communicationConverter
    $focusQuestions = $entity<focusQuestions> || converter = $converters.focusConverter
    $Text = *
    
    
    
theme: /CV

    state: Enter
        q!: тест
        #q!: *start *
        a: Здравствуйте! 👋
        script:
            QuestionService.init();
            $session.curAnswers = [];  //создать такое поле в questionService
            $reactions.timeout({interval: '3 seconds', targetState: '/CV/Enter/Intro1'});

        state: Intro1
            a: Представлюсь: я директор ресторана Макдоналдс 👱
            script:
                $reactions.timeout({interval: '3 seconds', targetState: '/CV/Enter/Intro2'});

        state: Intro2
            a: Прежде чем пригласить Вас на собеседование, я бы хотел узнать Вас получше.
            script:
                $reactions.timeout({interval: '3 seconds', targetState: '/CV/Enter/Intro3'});

        state: Intro3
            a: Я задам несколько вопросов, а Вам нужно просто выбрать наиболее близкий Вам вариант ответа, кликнув по нему. Хорошо?
            buttons:
                "Давай!👍"
            go: /CV/Customer orientation questionarie

    state: Customer orientation questionarie 
        q: * давай *
        script:
            log("id: " + $session.start.id + "; secretToken: " + "iIvqtaKVle8fjkMTC3otC4kL2nN7IyBN; forHash: " + $session.start.id + "iIvqtaKVle8fjkMTC3otC4kL2nN7IyBN; hash: " + md5($session.start.id + "iIvqtaKVle8fjkMTC3otC4kL2nN7IyBN"));
            $session.i = $session.i || 0;
        if: $session.i < 4
            script:
                $session.themeQuestionarie = "Customer orientation";
                QuestionService.generateQuestions($session.themeQuestionarie);
                $session.i++;
        elseif: $session.i == 4
            if: QuestionService.partWasRotated("Customer orientation")
                script:
                    QuestionService.generateQuestions($session.themeQuestionarie);
            else:
                script:
                    QuestionService.generateRotataionQuestion($customerOrientation);
            script:
                $session.i++;
        else:
            a: Интересно 🤔\nВозможно, в некоторых ситуациях я поступил бы так же… 
            script:
                $reactions.timeout({interval: '3 seconds', targetState: './Transition'});

        state: Transition
            a: Вы отлично справляетесь, давайте продолжим!
            buttons:
                "Да!👌"
            script:
                $session.i = 0;
            go: /CV/Team questionarie

    state: Team questionarie
        q: * да *
        script:
            $session.i = $session.i || 0;
        if: $session.i < 4
            script:
                $session.themeQuestionarie = "Team";
                QuestionService.generateQuestions($session.themeQuestionarie);
                $session.i++;
        elseif: $session.i == 4
            if: QuestionService.partWasRotated("Team")
                script:
                    QuestionService.generateQuestions($session.themeQuestionarie);
            else:
                script:
                    QuestionService.generateRotataionQuestion($teamQuestions);
            script:
                $session.i++;
        else:
            a: За разговорами время летит незаметно, правда?⏰
            script:
                $reactions.timeout({interval: '3 seconds', targetState: './Transition'});

        state: Transition
            a: Мы в Макдоналдс ценим открытое общение. И мне нравится с Вами беседовать!🙂
            buttons:
                "🙌Продолжаем!"
            script:
                $session.i = 0;
            go: /CV/Communication questionarie


    state: Communication questionarie 
        q: * продолжаем *
        script:
            $session.i = $session.i || 0;
        if: $session.i < 4
            script:
                $session.themeQuestionarie = "Communication";
                QuestionService.generateQuestions($session.themeQuestionarie);
                $session.i++;
        elseif: $session.i == 4
            if: QuestionService.partWasRotated("Communication")
                script:
                    QuestionService.generateQuestions($session.themeQuestionarie);
            else:
                script:
                    QuestionService.generateRotataionQuestion($communicationQuestions);
            script:
                $session.i++;
        else:
            a: Спасибо Вам за откровенность!🙏
            script:
                $reactions.timeout({interval: '3 seconds', targetState: './Transition'});

        state: Transition
            a: У меня осталось совсем немного вопросов… Я задам их, и Вы сможете вернуться к своим делам, хорошо?
            buttons:
                "Ок!👌"
            script:
                $session.i = 0;
            go: /CV/Focus questionarie
    

    state: Focus questionarie
        q: * ок *
        script:
            $session.i = $session.i || 0;
        if: $session.i < 4
            script:
                $session.themeQuestionarie = "Focus";
                QuestionService.generateQuestions($session.themeQuestionarie);
                $session.i++;
        elseif: $session.i == 4
            if: QuestionService.partWasRotated("Focus")
                script:
                    QuestionService.generateQuestions($session.themeQuestionarie);
            else:
                script:
                    QuestionService.generateRotataionQuestion($focusQuestions);
            script:
                $session.i++;
        else:
            script:
                $session.i = 0;
            go!: ../Check results


    state: Check results
        if: QuestionService.finalScoreBigEnough()
            if: $session.testResults.customerOrientationScore <= 6
                script:
                    $session.testResults.finalScore -= 15;
                go!: ../Tell results
            elseif: $session.testResults.customerOrientationScore >= 14
                script:
                    $session.i = 0;
                go!:../Ask other customer orientation questions
        else:
            go!: ../Tell results

                
    state: Ask other customer orientation questions
        script:
            $session.i = $session.i || 0;
        if: $session.i < 5
            script:
                $session.themeQuestionarie = "Customer orientation last";
                QuestionService.generateQuestions($session.themeQuestionarie);
                $session.i++;
        else:
            go!: ../Tell results
            
    state: Tell results
        script:
            $temp.success = QuestionService.sendTheResult($session.start.id, $session.secretToken, $session.testResults);
        if: $temp.success
        #a: Итоговый результат:\n балл за клиентоориентированность: {{$session.testResults.customerOrientationScore}} \nбалл за умение работать в команде: {{$session.testResults.teamScore}} \nбалл за навыки коммуникации: {{$session.testResults.communicationScore}} \nбалл за умение держать фокус: {{$session.testResults.focusScore}} \nобщий балл: {{$session.testResults.finalScore}}.
            a: Кажется, теперь я узнал Вас отлично!😊
            script:
                $temp.complete = true;
                $reactions.timeout({interval: '3 seconds', targetState: './Final1'});
        else:
            a: Что-то пошло не так, и я не смог отправить результаты в компанию. Попробуйте зайти на страницу и пройти тест позже.

        state: Final1
            a: Было очень приятно пообщаться, спасибо!
            script:
                $reactions.timeout({interval: '3 seconds', targetState: '../Final2'});

        state: Final2
            a: Надеюсь, мои вопросы напомнили Вам о знакомых ситуациях или просто развлекли.✌🏻✨🎉
            script:
                $reactions.timeout({interval: '3 seconds', targetState: '../Final3'});

        state: Final3
            a: При наличии в ресторане свободных вакансий, подходящих под Ваши временные возможности, мы с коллегами свяжемся с Вами в ближайшее время и расскажем о дальнейших шагах.
            script:
                $reactions.timeout({interval: '3 seconds', targetState: '../Final4'});

        state: Final4
            a: А пока Вы можете почитать о графике📋, рабочей униформе👕, корпоративной культуре 🎈и деталях работы. <div><script>window.parent.postMessage("anketa", "*");</script></div>
            buttons:
                "Узнать детали работы📋"
            
        
        state: Refresh page
            q: * узнать детали работы * || fromState = ../Final4, onlyThisState = true
            a: <div><script>window.parent.postMessage("complete", "*");</script></div>
        
    state: Get answer
        q: $Text || fromState = "/CV/Customer orientation questionarie"
        q: $Text || fromState = "/CV/Team questionarie"
        q: $Text || fromState = "/CV/Communication questionarie"
        q: $Text || fromState = "/CV/Focus questionarie"
        q: $Text || fromState = "/CV/Ask other customer orientation questions"
        script:
            $session.curAnswers = [];
            for (var i = 0; i < $session.currentQuestion.answers.length; i++){
                var bb = $session.currentQuestion.answers[i].text.replace(/[.,\/#%!\^\*;:{}=\_`~()]/g,"").toLowerCase().split(" ");
                var answerPattern = "* " + (bb[bb.length-3] + " " + bb[bb.length-2] + " " + bb[bb.length-1]).replace(/[.,\/#%!\^\*;:{}=\_`~()]/g,"").toLowerCase();
                $session.curAnswers.push(answerPattern);
            }
            var match = $nlp.matchPatterns($parseTree._Text.replace(/[.,\/#%!\^\*;:{}=\_`~()]/g,"").toLowerCase(), $session.curAnswers);
            if(match){
                var transformMatch = match.effectivePattern.toLowerCase();
                var index = $session.curAnswers.indexOf(transformMatch);
                $session.testResults.questionAnswerList.push({"question": $session.currentQuestion.question, "answer": $parseTree._Text, "score": parseInt($session.currentQuestion.answers[index].score)});
                
                $session.testResults.finalScore = $session.testResults.finalScore + parseInt($session.currentQuestion.answers[index].score);

                switch($session.themeQuestionarie){
                    case "Customer orientation":
                        $session.testResults.customerOrientationScore = $session.testResults.customerOrientationScore + parseInt($session.currentQuestion.answers[index].score);
                        $reactions.transition("/CV/Customer orientation questionarie");
                        break;

                    case "Team":
                        $session.testResults.teamScore = $session.testResults.teamScore + parseInt($session.currentQuestion.answers[index].score);
                        $reactions.transition("/CV/Team questionarie");
                        break;
                        
                    case "Communication":
                        $session.testResults.communicationScore = $session.testResults.communicationScore + parseInt($session.currentQuestion.answers[index].score);
                        $reactions.transition("/CV/Communication questionarie");
                        break;выбрать

                    case "Focus":
                        $session.testResults.focusScore = $session.testResults.focusScore + parseInt($session.currentQuestion.answers[index].score);
                        $reactions.transition("/CV/Focus questionarie");
                        break;

                    case "Customer orientation last":
                        $session.testResults.customerOrientationScore = $session.testResults.customerOrientationScore + parseInt($session.currentQuestion.answers[index].score);
                        $reactions.transition("/CV/Ask other customer orientation questions");
                        break;
                }       
            } else {
                $reactions.transition("/CV/CatchAll");
            }


    state: CatchAll
        q!: *
        random:
            a: Пожалуйста, выберите один из предложенных вариантов ответа.
            a: Вам нужно выбрать один из перечисленных вариантов ответа.
            a: Необходимо выбрать один из предложенных вариантов.
        a: {{$session.curQuestionAnswer}}
        go!: {{$session.lastState}}
        
        
    state: Error || noContext = true
        a: Кажется, что-то пошло не так. Попробуйте пройти тест еще раз чуть позже.