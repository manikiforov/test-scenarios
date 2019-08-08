function getCaller() {
    var $context = $jsapi.context();

    // для нагрузочного тестирования бота
    if ($context.request.channelType == 'chatapi') {
        return $context.request.rawRequest.clientId;
    }
    
    // для основного использования
    var caller = $dialer.getCaller();
    
    if (!caller) {
        // для тестов
        return "+79217774126";
    }
    
    return caller;
}

function hangUp() {
    $dialer.hangUp('(Бот повесил трубку)')
}