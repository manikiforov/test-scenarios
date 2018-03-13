function pageName(name) {
    var $session = $jsapi.context().session;
    $session.pageName = name;
}