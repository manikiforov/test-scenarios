function pageName(name) {
    var $session = $jsapi.context().session;
    $session.pageName = name;
}

function rememberLastState() {
    var $session = $jsapi.context().session;
    $session.lastState = currentState();
    log("REMEMBER LAST STATE: " + $session.lastState)
}