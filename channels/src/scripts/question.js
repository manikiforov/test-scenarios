var QuestionService = (function () {

    function init() {
        var $session = $jsapi.context().session;
        $session.i = 0;
        $session.secretToken = "iIvqtaKVle8fjkMTC3otC4kL2nN7IyBN";
        $session.testResults = {
            customerOrientationScore: 0,
            teamScore: 0,
            communicationScore: 0,
            focusScore: 0,
            finalScore: 0,
            questionAnswerList: []
        };

        $session.serviceInfo = {
            customerOrientationDict: {lengthDict: Object.keys($customerOrientation).length, usedQuestion:[]}, 
            teamDict: {lengthDict: Object.keys($teamQuestions).length, usedQuestion:[]},
            communicationDict: {lengthDict: Object.keys($communicationQuestions).length, usedQuestion:[]},
            focusDict: {lengthDict: Object.keys($focusQuestions).length, usedQuestion:[]}
        };
    }


    function generateQuestions(theme){
        var $session = $jsapi.context().session;

        switch(theme){
            case "Customer orientation":
                $session.curDict = $session.serviceInfo.customerOrientationDict;
                getQuestion($customerOrientation, $session.curDict);
                break;

            case "Team":
                $session.curDict = $session.serviceInfo.teamDict;
                getQuestion($teamQuestions, $session.curDict);
                break;
                
            case "Communication":
                $session.curDict = $session.serviceInfo.communicationDict;
                getQuestion($communicationQuestions, $session.curDict);
                break;

            case "Focus":
                $session.curDict = $session.serviceInfo.focusDict;
                getQuestion($focusQuestions, $session.curDict);
                break;
                
            case "Customer orientation last":
                $session.curDict = $session.serviceInfo.customerOrientationDict;
                getQuestion($customerOrientation, $session.curDict);
                break;
        }
    }

    function generateRandomIndex(usedQuestion){
        var $session = $jsapi.context().session;
        
        if($session.themeQuestionarie == "Customer orientation last"){
            var indexForLastPart = $reactions.random($session.serviceInfo.customerOrientationDict.lengthDict);
            var a = 1;
            while(usedQuestion.indexOf(indexForLastPart) > -1 && a < 6 ){
                indexForLastPart = $reactions.random($session.serviceInfo.customerOrientationDict.lengthDict);                
                a++;
            }
            return indexForLastPart;
        } else {
            var index = $reactions.random(6);
            var i = 1;
            while(usedQuestion.indexOf(index) > -1 && i < 6 ){
                index = $reactions.random(6);                
                i++;
            }
            return index;
        }

    }

    function getQuestion(dict, infoPlace){
        var $session = $jsapi.context().session;

        var index = generateRandomIndex(infoPlace.usedQuestion);
        
        $session.currentQuestion = dict[index].value;

        infoPlace.usedQuestion.push(index);

        $session.curQuestionAnswer = $session.currentQuestion.question + "\n\n";

        for (var i = 0; i < $session.currentQuestion.answers.length; i++){
            $session.curQuestionAnswer = $session.curQuestionAnswer + " * [" + $session.currentQuestion.answers[i].text + "]\n\n";
        }

        $reactions.answer($session.curQuestionAnswer);
    }
    
    function partWasRotated(theme){               //переписать нормально
        var $session = $jsapi.context().session;
        if($session.curDict.usedQuestion.indexOf(5) > -1){
            return true;
        }
        return false;
    }
    
    function generateRotataionQuestion(dict){           //переписать нормально
        var $session = $jsapi.context().session;
        $session.currentQuestion = dict[5].value;
        
        $session.curDict.usedQuestion.push(5);

        $session.curQuestionAnswer = $session.currentQuestion.question + "\n\n";

        for (var i = 0; i < $session.currentQuestion.answers.length; i++){
            $session.curQuestionAnswer = $session.curQuestionAnswer + " * [" + $session.currentQuestion.answers[i].text + "]\n\n";
        }

        $reactions.answer($session.curQuestionAnswer);
    }

    function finalScoreBigEnough(){
        var $session = $jsapi.context().session;
        if($session.testResults.finalScore >= 44){
            return true
        }
        return false;
    }
    
    function requestError(response, status) {
        var $temp = $jsapi.context().temp;
        log("ERROR: Failed to query API body: " + toPrettyString($temp.body) + ", status: " + status + ", data: " + toPrettyString(response));
        $reactions.transition("/CV/Error");
    }
    
    function sendTheResult(userID, secretToken, results){
        var $session = $jsapi.context().session;
        var $temp =  $jsapi.context().temp;
        var login = "root";
        var password = "test";
        var tokenmd5 = md5(userID + secretToken);
        //log("прям из этого-самого: id: " + userID + "; secretToken: " + secretToken + "; forHash: " + userID + secretToken + "; hash: " + tokenmd5);
        $temp.body = {
            id: userID,
            token: tokenmd5,
            customerfocus_score: results.customerOrientationScore,
            team_score: results.teamScore,
            communication_score: results.communicationScore,
            focus_score: results.focusScore,
            total_score: results.finalScore,
            debug: 1,
            questions: results.questionAnswerList
            
        };

        log("прям из этого-самого:" + toPrettyString($temp.body));
        return $http.post(sendResultAPI, {
            dataType: "json",
            method: "POST",
            body: $temp.body,
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Basic " + base64.encode(login + ":" + password)
            },
        }).then(function (data) {
            log(data);
            return data.success;
        }).catch(requestError);
    }

    return {
        init:init,
        generateQuestions:generateQuestions,
        getQuestion:getQuestion,
        partWasRotated:partWasRotated,
        generateRotataionQuestion:generateRotataionQuestion,
        finalScoreBigEnough:finalScoreBigEnough,
        sendTheResult:sendTheResult
    };

})();