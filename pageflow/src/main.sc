require: integration.js
    module = functions

theme: /

    init:
        bind("preProcess", function($context) {
            var $session = $context.session, $temp = $context.temp, $request = $context.request, $parseTree = $context.parseTree;
            checkButtonTransition();
            $session.noBackButton = false;
            $session.dontPushState = false;

            if ($request.data.targetState) {
                $temp.targetState  = $request.data.targetState;
            } else if ($session.lastActiveTime) {
                var interval = currentDate() - $session.lastActiveTime;
                if (interval > 120 * 60 * 1000 && !testMode()) {
                    $request.data.targetState = $temp.targetState || currentState();
                    $reactions.newSession( {message: $request.query, data: $request.data} );
                }
            }
        });

        bind("postProcess", function($context) {
            var $session = $context.session;
            var $temp = $context.temp;
            var $response = $context.response;
            var $client = $context.client;
            rememberLastState();
            if (!testMode() && !$temp.specialState) {
                services.updatePageInfo();
            }
            setMarkupMode("markdown");
            setFacebookMenuTitle();

            if (!$session.dontPushState) {
                pushBackState();
            }
            if (!$session.noBackButton) {
                pushBackButton();
            }

            $response.orgData = { 'firm': $client.FirmArr, 'number': $client.numberArr };

            $session.lastActiveTime = currentDate();
        });