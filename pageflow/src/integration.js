if (services){
    delete services;
}
var services = (function (){
    var api = {};
    if ($http == 'undefined'){
        print("$http is not defined, possible server is not supports it");
        return;
    }

    ///////////////////
    var config = {
        timeout: 10000
    };

    log("Connector started with config: " + JSON.stringify(config));
    
    api.updatePageInfo = function (){
        var $session = $jsapi.context().session, $temp = $jsapi.context().temp, $client = $jsapi.context().client, $response = $jsapi.context().response, $parseTree = $jsapi.context().parseTree, $request = $jsapi.context().request;
        $response.prevState = $session.prevState;
        $response.currentState = currentState();
        $response.prevPageName = $session.prevPageName;
        $response.pageName = $session.pageName;

        $session.prevState = currentState();
        $session.prevPageName = $session.pageName;
        $session.pageName = null;
    };
    
    return api;
})();