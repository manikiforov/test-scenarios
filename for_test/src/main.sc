init:
    bind("onAnyError", function($context) {
            if ($context.exception.message) {
                $reactions.answer($context.exception.message);
            }
        });
theme: /

    state:
        q: * start
        script:
            $http.get('http://localhost:9999/long-get')
            .then(function (data, status, response) {
                $response.data = data;
                $response.status = status;
                $response.response = response;
                $reactions.answer('success');
            }).catch(function (response, status, error) {
                $response.response = response;
                $response.status = status;
                $response.error = error;
                $reactions.answer('failed');
            });