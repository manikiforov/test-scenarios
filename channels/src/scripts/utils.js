// перевод на оператора
function switchToOperator() {
    if (testMode() || $.request.channelType == "chatwidget") {
        $reactions.answer("Перевод на оператора и завершение диалога.");
    } else {
        $.response.replies = $.response.replies || [];
        $.response.replies
            .push({
                type:"switch",
                closeChatPhrases: ["/close", "вернуться в беседу с роботом"],
                firstMessage: $.session.history
        });
    }
}