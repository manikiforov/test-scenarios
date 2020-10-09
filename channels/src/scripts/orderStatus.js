// получение информации о сессии
function getSessionParams() {
    var url = "https://api.tp.mvideo.ru/chat-session-manager/session/" + $.session.sessionId + "?userInfo=true&bonusInfo=true&userPromo=true&lastOrders=true";
    return $http.get(url)
}


// достаем телефон пользователя из информации по сессии (чтобы использовать его в дальнейшем для матчинга с номером телефона в заказе)
function getPhoneFromSessionParams(sessionParams) {
    if (((((sessionParams.data || {}).clientData || {}).UserInfo || {}).ResponseBody || {}).searchResult) {
        for (var i = 0; i < sessionParams.data.clientData.UserInfo.ResponseBody.searchResult.length; i++) {
            if (sessionParams.data.clientData.UserInfo.ResponseBody.searchResult[i].client && sessionParams.data.clientData.UserInfo.ResponseBody.searchResult[i].client.phone && sessionParams.data.clientData.UserInfo.ResponseBody.searchResult[i].client.phone != "" && sessionParams.data.clientData.UserInfo.ResponseBody.searchResult[i].client.phone != " ") {
                return sessionParams.data.clientData.UserInfo.ResponseBody.searchResult[i].client.phone;
            }
        }
        return undefined;
    } else {
        return undefined;
    }
}


// Получение последних заказов клиента по его id (функция не используется).
//function getLastOrders() {
//    var url = "https://api.tp.mvideo.ru/chat-session-manager/session/last-orders?crmId=" + $.session.userCrmId + "&orderCount=10";
//    return $http.get(url)
//}


// сопоставление id клиента (берется из информации по сессии) и id владельца заказа - для авторизованной ветки (случай, когда номера заказа нет в списке номеров заказов пользователя) - в ходе реализации решили, что не матчим, т.к. приходящие id не совпадали
//function matchCustomerId(res) {
//    if (((res.data.ResponseBody.order || {}).customerInfo || {}).id && res.data.ResponseBody.order.customerInfo.id == $.session.userCrmId) {
//        return true;
//    } else {
//        return false;
//    }
//}

// обработчик запросов про статус заказа (проверяет итерации, авторизацию, назвали-не назвали номер заказа в запросе)
function orderStatusHandler() {
    if ($.parseTree._orderNumber) {
        $.session.orderNumber = $.parseTree._orderNumber;

        if ($.session.authorization) {
            if ($.session.orderList && searchForOrderInOrderList($.session.sessionParams)) {
                $.temp.res = getOrderParams();
                if ($.temp.res.isOk) {
                    orderStatusTransition($.temp.res);
                } else {
                    checkErrors($.temp.res);
                }
            } else {
                $.temp.res = getOrderParams();
                if ($.temp.res.isOk) {
                    if (comparePhone($.temp.res)) {
                        orderStatusTransition($.temp.res);
                    } else {
                        $.session.orderParams = $.temp.res;
                        $.session.badPhone = true;
                        $reactions.transition("/OrderStatus/AskPhone")
                    }
                } else {
                    checkErrors($.temp.res);
                }
            }
        } else {
            $reactions.transition("/OrderStatus/AskPhone");
        }
    } else {
        if ($.session.authorization) {
            if ($.session.orderList) {
                if ($.session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders.length == 1) {
                    $reactions.transition("/OrderStatus/OnlyOneOrder");
                } else if ($.session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders.length == 2) {
                    $reactions.transition("/OrderStatus/TwoOrders");
                } else {
                    $reactions.transition("/OrderStatus/ThreeOrMoreOrders");
                }
            } else {
                $reactions.answer("Для вашего номера телефона заказы не найдены.");
                $reactions.transition("/OrderStatus/AskOrderNumber");
            }
        } else {
            $reactions.transition("/OrderStatus/AskOrderNumber");
        }
    }
}


// проверка, есть ли номера заказов в информации по сессии (для авторизованного пользователя)
function checkOrderList(sessionParams) {
    if (sessionParams.isOk && ((((sessionParams.data || {}).clientData || {}).UserLastOrders || {}).ResponseBody || {}).orders && sessionParams.data.clientData.UserLastOrders.ResponseBody.orders != []) {
        return true;
    } else {
        return false;
    }
}

// проверка статуса после пост-запроса о параметрах номера заказа: если статус начинается на 4 или 5, считаем, что номер заказа в базе не найден, в ином случае перевод на оператора (вариант предусмотрен на случай непредвиденных ошибок или статусов)
function checkErrors(res) {
    if (res.status.toString()[0] == "5" || res.status.toString()[0] == "4") {
        orderIsNotFound();
    } else {
        $reactions.answer(ans.toOperator);
        switchToOperator();
    }
}

// поиск номера заказа, названного пользователем, в списке номеров заказов пользователя
function searchForOrderInOrderList(sessionParams) {
    for (var i = 0; i < sessionParams.data.clientData.UserLastOrders.ResponseBody.orders.length; i++) {
        if (sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[i].number == $.session.orderNumber) {
            return true;
        }
    }
    return false;
}


// получение параметров заказа по его номеру
function getOrderParams() {
    var url = "https://api.tp.mvideo.ru/chat-session-manager/session/order";
    return $http.post(url, {
        headers: {
            "accept": "application/json",
            "Content-Type": "application/json"
        },
        body: {
            "orderId": $.session.orderNumber
        }
    })
}


// преобразование номера телефона, введенного пользователем, в формат +7XXXXXXXXXX (т.к. такой формат приходит от апи и потом нужно будет сравнивать телефоны)
function getPhone(pt) {
    $.session.phone = pt._mobilePhoneNumberRus.replace(/[\–\-\s\(\)\n]/g, "");
    if ($.session.phone.length > 10) {
        if ($.session.phone[0] == "8") {
            $.session.phone = $.session.phone.replace($.session.phone[0], "+7");
        } else if ($.session.phone[0] == "7") {
            $.session.phone = "+" + $.session.phone;
        }
    } else {
        $.session.phone = "+7" + $.session.phone;
    }
}


// проверяем, соответствует ли номер телефона, введенный пользователем, номеру телефона из данных (м.б. равен н.т. либо покупателя, либо получателя заказа)
function comparePhone(res) {
    if (((res.data.ResponseBody.order || {}).customerInfo || {}).paramList) {
        for (var i = 0; i < res.data.ResponseBody.order.customerInfo.paramList.length; i++) {
            if (res.data.ResponseBody.order.customerInfo.paramList[i].key == "phone" && res.data.ResponseBody.order.customerInfo.paramList[i].value && res.data.ResponseBody.order.customerInfo.paramList[i].value != " ") {
                if (res.data.ResponseBody.order.customerInfo.paramList[i].value == $.session.phone) {
                    return true;
                }
            }
            if (res.data.ResponseBody.order.customerInfo.paramList[i].key == "secondaryPhone" && res.data.ResponseBody.order.customerInfo.paramList[i].value && res.data.ResponseBody.order.customerInfo.paramList[i].value != " ") {
                if (res.data.ResponseBody.order.customerInfo.paramList[i].value == $.session.phone) {
                    return true;
                }
            }
        }
    }

    if ((res.data.ResponseBody.order || {}).deliveryGroupList) {
        var deliveryGroupList = res.data.ResponseBody.order.deliveryGroupList;
        for (var i = 0; i < deliveryGroupList.length; i++) {
            if (deliveryGroupList[i].paramList) {
                for (var x = 0; x < deliveryGroupList[i].paramList.length; x++) {
                    if (deliveryGroupList[i].paramList[x].key && deliveryGroupList[i].paramList[x].key == "phone" && deliveryGroupList[i].paramList[x].value != " ") {
                        if (deliveryGroupList[i].paramList[x].value == $.session.phone) {
                            return true;
                        }
                    }
                }
            } else {
                return false;
            }

        }
        return false;
    } else {
        return false;
    }
}


// проверка различных условий в статусе заказа, по которым диалог может быть переведен на оператора до формирования конечного ответа по статусу заказа
function orderStatusTransition(res) {
    if (((res.data || {}).ResponseBody || {}).order) {
        if ((((res.data.ResponseBody.order || {}).basicInfo || {}).commonStatus || {}).description) {
            if (res.data.ResponseBody.order.basicInfo.commonStatus.description == "Завершен") {
                $.temp.orderStatus = "завершен";
                $reactions.answer(ans.orderStatus.orderIsCompletedOrCancelled);
                $.session.attempt++;
                $reactions.transition({value: "/Conversation/AnyMoreQuestions", deferred: true});
            } else if (res.data.ResponseBody.order.basicInfo.commonStatus.description == "Отменен") {
                $.temp.orderStatus = "отменен";
                $reactions.answer(ans.orderStatus.orderIsCompletedOrCancelled);
                $.session.attempt++;
                $reactions.transition({value: "/Conversation/AnyMoreQuestions", deferred: true});
            } else if ((((res.data.ResponseBody.order || {}).basicInfo || {}).fulfilmentStatus || {}).code && res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z008") {
                $reactions.answer(ans.toOperator);
                switchToOperator();
            } else if ((res.data.ResponseBody.order || {}).positionList &&  searchForMaterialValuesOrDcUuid(res.data.ResponseBody.order.positionList)) {
                $reactions.answer(ans.toOperator);
                switchToOperator();
            } else if ((res.data.ResponseBody.order || {}).deliveryGroupList) {
                if (searchForDigitalCodeInDeliveryGroupList(res.data.ResponseBody.order.deliveryGroupList)) {
                    $reactions.answer(ans.toOperator);
                    switchToOperator();
                } else {
                    if (searchForDeliveryDate(res.data.ResponseBody.order.deliveryGroupList)) {
                        if (checkIfDeliveryDateIsOld()) {
                            $reactions.answer(ans.toOperator);
                            switchToOperator();
                        } else {
                            orderStatusMessage(res);
                        }
                    } else {
                        orderStatusMessage(res);
                    }
                }
            } else {
                $reactions.answer(ans.noDataToOperator);
                switchToOperator();
            }
        } else {
            $reactions.answer(ans.noDataToOperator);
            switchToOperator();
        }

    } else {
        $reactions.answer(ans.noDataToOperator);
        switchToOperator();
    }
}


// поиск по PositionList: ищем 2 значения в material и ключа dc_uuid
function searchForMaterialValuesOrDcUuid(positionList) {
    for (var i = 0; i < positionList.length; i++) {
        if (positionList[i].material) {
            if (positionList[i].material == "6011732" || positionList[i].material == "6011654") {
            return true;
            }
        }

        if (positionList[i].paramList) {
            for (var x = 0; x < positionList[i].paramList.length; x++) {
                if (positionList[i].paramList[x].key && positionList[i].paramList[x].key == "dc_uuid") {
                    return true;
                }
            }
        }
    }
    return false;
}


// поиск ключа digitalCode в deliveryGroupList
function searchForDigitalCodeInDeliveryGroupList(deliveryGroupList) {
    for (var i = 0; i < deliveryGroupList.length; i++) {
        if (deliveryGroupList[i].digitalCode && deliveryGroupList[i].digitalCode != " ") {
            return true;
        }
    }
    return false;
}


// проверяем, пришла ли дата доставки, сохраняем значение, если пришла
function searchForDeliveryDate(deliveryGroupList) {
    for (var i = 0; i < deliveryGroupList.length; i++) {
        if (deliveryGroupList[i].paramList) {
            for (var x = 0; x < deliveryGroupList[i].paramList.length; x++) {

                if (deliveryGroupList[i].paramList[x].key && deliveryGroupList[i].paramList[x].key == "deliveryDate") {
                    $.temp.deliveryDate = deliveryGroupList[i].paramList[x].value;
                    if ($.temp.deliveryDate != " ") {
                        $.temp.deliveryDateForAnswer = moment($.temp.deliveryDate).locale("ru").format("LL");
                        return true;
                    }
                }
            }
        }
    }
    return false;
}


// проверяем, прошла ли дата (дата доставки)
function checkIfDeliveryDateIsOld() {
    var currentDate = moment().format();
    return moment($.temp.deliveryDate).isBefore(currentDate, "day");
}


// проверяем условия и выводим конечное сообщение о статусе заказа
function orderStatusMessage(res) {
    if ((((res.data.ResponseBody.order || {}).basicInfo || {}).commonStatus || {}).code && (((res.data.ResponseBody.order || {}).basicInfo || {}).fulfilmentStatus || {}).code) {

        if (checkPaymentMethodStatus(res)) {
            if (searchForDeliveryHandoverType(res)) {
                if ($.temp.handoverType == "PICKUP" && $.temp.paymentCode || $.temp.handoverType == "Самовывоз" && $.temp.paymentCode) {
                    if (res.data.ResponseBody.order.basicInfo.commonStatus.code == "E0006" && res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z013") {
                        if ($.temp.paymentCode == "Z005") {
                            if (searchForEndReserveDate(res)) {
                                $reactions.answer("Хорошие новости! Банк предварительно одобрил кредитную заявку по вашему заказу {{$session.orderNumber}}. Для подписания кредитного договора и получения заказа ждем вас в магазине до {{$temp.endReserveDate}} включительно. Кредитный специалист работает до 21:00, но оформление может занять некоторое время, поэтому просим вас прийти заранее.");
                            } else {
                                $reactions.answer("Хорошие новости! Банк предварительно одобрил кредитную заявку по вашему заказу {{$session.orderNumber}}. Для подписания кредитного договора и получения заказа ждем вас в магазине.");
                            }
                            $.session.attempt++;
                            $reactions.transition("/Conversation/AnyMoreQuestions");
                        } else if ($.temp.paymentCode == "Z014") {
                            if (searchForEndReserveDate(res)) {
                                $reactions.answer("Хорошие новости! Банк предварительно одобрил кредитную заявку по вашему заказу {{$session.orderNumber}}. Для завершения оформления кредита и получения заказа ждем вас в магазине до {{$temp.endReserveDate}} включительно. Кредитный специалист работает до 21:00, но оформление может занять некоторое время, поэтому просим вас прийти заранее.");
                            } else {
                                $reactions.answer("Хорошие новости! Банк предварительно одобрил кредитную заявку по вашему заказу {{$session.orderNumber}}. Для завершения оформления кредита и получения заказа ждем вас в магазине.");
                            }
                            $.session.attempt++;
                            $reactions.transition("/Conversation/AnyMoreQuestions");
                        } else {
                            $reactions.answer(ans.noDataToOperator);
                            switchToOperator();
                        }
                    } else if (res.data.ResponseBody.order.basicInfo.commonStatus.code == "E0004" && res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z009") {
                        if ($.temp.paymentCode == "Z012") {
                            $reactions.answer("Банк предварительно одобрил кредитную заявку по вашему заказу {{$session.orderNumber}}, и сейчас она находится на рассмотрении в банке. Сотрудник банка может позвонить вам для уточнения деталей. Отслеживать статус своего заказа вы можете в вашем Личном кабинете на сайте М.Видео.ру.");
                            $.session.attempt++;
                            $reactions.transition("/Conversation/AnyMoreQuestions");
                        } else if ($.temp.paymentCode == "Z005" || $.temp.paymentCode == "Z014") {
                            if ($.temp.deliveryDateForAnswer) {
                                $reactions.answer(ans.orderStatus.bankApprovedTheLoan.v1);
                            } else {
                                $reactions.answer(ans.orderStatus.bankApprovedTheLoan.v2);
                            }
                            $.session.attempt++;
                            $reactions.transition("/Conversation/AnyMoreQuestions");
                        } else {
                            $reactions.answer(ans.noDataToOperator);
                            switchToOperator();
                            }
                    } else if (res.data.ResponseBody.order.basicInfo.commonStatus.code == "E0003") {
                        if (res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z004" && $.temp.paymentCode == "Z010") {
                            $reactions.answer("Хорошие новости! Банк предварительно одобрил кредитную заявку по вашему заказу {{$session.orderNumber}}. Пожалуйста, подтвердите дальнейшее рассмотрение заявки в вашем Личном кабинете на сайте М. Видео.ру. Там же вы можете отслеживать статус своего заказа.");
                            $.session.attempt++;
                            $reactions.transition("/Conversation/AnyMoreQuestions");
                        } else if (res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z025" && $.temp.paymentCode == "Z014") {
                            if ($.temp.deliveryDateForAnswer) {
                                $reactions.answer(ans.orderStatus.bankApprovedTheLoan.v1);
                            } else {
                                $reactions.answer(ans.orderStatus.bankApprovedTheLoan.v2);
                            }
                            $.session.attempt++;
                            $reactions.transition("/Conversation/AnyMoreQuestions");
                        } else {
                            $reactions.answer(ans.noDataToOperator);
                            switchToOperator();
                            }
                    } else {
                        $reactions.answer(ans.noDataToOperator);
                        switchToOperator();
                    }
                } else {
                    $reactions.answer(ans.noDataToOperator);
                    switchToOperator();
                }
            } else {
                $reactions.answer(ans.noDataToOperator);
                switchToOperator();
            }
        } else {
            if (res.data.ResponseBody.order.basicInfo.commonStatus.code == "E0002" && res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z003") {
                $reactions.answer("Ваш заказ {{$session.orderNumber}} успешно создан и находится в обработке.");
                $.session.attempt++;
                $reactions.transition("/Conversation/AnyMoreQuestions");
            } else {
                if (searchForDeliveryHandoverType(res)) {
                    if ($.temp.handoverType == "PICKUP" || $.temp.handoverType == "Самовывоз") {
                        if (res.data.ResponseBody.order.basicInfo.commonStatus.code == "E0003" && res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z007") {
                            if ($.temp.deliveryDateForAnswer) {
                                $reactions.answer(ans.orderStatus.orderIsBeingProcessed.v1);
                            } else {
                                $reactions.answer(ans.orderStatus.orderIsBeingProcessed.v2);
                            }
                            $.session.attempt++;
                            $reactions.transition("/Conversation/AnyMoreQuestions");
                        } else if (res.data.ResponseBody.order.basicInfo.commonStatus.code == "E0004") {
                            if (res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z012" || res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z009") {
                                if ($.temp.deliveryDateForAnswer) {
                                    $reactions.answer(ans.orderStatus.orderIsBeingProcessed.v1);
                                } else {
                                    $reactions.answer(ans.orderStatus.orderIsBeingProcessed.v2);
                                }
                                $.session.attempt++;
                                $reactions.transition("/Conversation/AnyMoreQuestions");
                            } else {
                                $reactions.answer(ans.noDataToOperator);
                                switchToOperator();
                            }
                        } else if (res.data.ResponseBody.order.basicInfo.commonStatus.code == "E0006" && res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z013") {
                            if (searchForEndReserveDate(res)) {
                                $reactions.answer("Ваш заказ {{$session.orderNumber}} готов к выдаче. Обратитесь в магазин для его получения до {{$temp.endReserveDate}} включительно.");
                            } else {
                                $reactions.answer("Ваш заказ {{$session.orderNumber}} готов к выдаче. Обратитесь в магазин для его получения.");
                            }
                            $.session.attempt++;
                            $reactions.transition("/Conversation/AnyMoreQuestions");
                        } else {
                            $reactions.answer(ans.noDataToOperator);
                            switchToOperator();
                        }

                    } else if ($.temp.handoverType == "COURIER" || $.temp.handoverType.includes("Доставк") || $.temp.handoverType.includes("доставк")) {
                        if (res.data.ResponseBody.order.basicInfo.commonStatus.code == "E0005") {
                            if (res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z016" || res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z017" || res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z018") {
                                if ($.temp.deliveryDateForAnswer) {
                                    $reactions.answer("Ваш заказ {{$session.orderNumber}} передан курьеру, вам позвонят {{$temp.deliveryDateForAnswer}} за час до доставки.");
                                } else {
                                    $reactions.answer("Ваш заказ {{$session.orderNumber}} передан курьеру, вам позвонят за час до доставки.");
                                }
                                $.session.attempt++;
                                $reactions.transition("/Conversation/AnyMoreQuestions");

                            } else if (res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z014") {
                                if ($.temp.deliveryDateForAnswer) {
                                    $reactions.answer(ans.orderStatus.orderIsConfirmed.v1);
                                } else {
                                    $reactions.answer(ans.orderStatus.orderIsConfirmed.v2);
                                }
                                $.session.attempt++;
                                $reactions.transition("/Conversation/AnyMoreQuestions");
                            } else {
                                $reactions.answer(ans.noDataToOperator);
                                switchToOperator();
                            }
                        } else if (res.data.ResponseBody.order.basicInfo.commonStatus.code == "E0003" && res.data.ResponseBody.order.basicInfo.fulfilmentStatus.code == "Z025") {
                            if ($.temp.deliveryDateForAnswer) {
                                $reactions.answer(ans.orderStatus.orderIsConfirmed.v1);
                            } else {
                                $reactions.answer(ans.orderStatus.orderIsConfirmed.v2);
                            }
                            $.session.attempt++;
                            $reactions.transition("/Conversation/AnyMoreQuestions");
                        } else {
                            $reactions.answer(ans.noDataToOperator);
                            switchToOperator();
                        }
                    } else {
                        $reactions.answer(ans.noDataToOperator);
                        switchToOperator();
                    }

                } else {
                    $reactions.answer(ans.noDataToOperator);
                    switchToOperator();
                }
            }
        }

    } else {
        $reactions.answer(ans.noDataToOperator);
        switchToOperator();
    }
}


// проверка Payment Method: если пришел, должен быть равен credit
function checkPaymentMethodStatus(res) {
    if ((res.data.ResponseBody.order || {}).paymentMeanList) {
        for (var i = 0; i < res.data.ResponseBody.order.paymentMeanList.length; i++) {
            if (res.data.ResponseBody.order.paymentMeanList[i].method && res.data.ResponseBody.order.paymentMeanList[i].method == "credit") {

                if (res.data.ResponseBody.order.paymentMeanList[i].code && res.data.ResponseBody.order.paymentMeanList[i].code != " ") {
                    $.temp.paymentCode = res.data.ResponseBody.order.paymentMeanList[i].code;

                } else {
                    $.temp.paymentCode = false;
                }

                return true;
            }

        }
        return false;

    } else {
        return false;
    }
}


// поиск HandoverType (в HandoverType записывает либо значение handoverType из deliveryGroupList, либо materialName из positionList)
function searchForDeliveryHandoverType(res) {
    if ((res.data.ResponseBody.order || {}).deliveryGroupList){
        for (var i = 0; i < res.data.ResponseBody.order.deliveryGroupList.length; i++) {
            if (res.data.ResponseBody.order.deliveryGroupList[i].handoverType && res.data.ResponseBody.order.deliveryGroupList[i].handoverType != " ") {
                $.temp.handoverType = res.data.ResponseBody.order.deliveryGroupList[i].handoverType;
                return true;
            }
        }

        for (var i = 0; i < res.data.ResponseBody.order.deliveryGroupList.length; i++) {
            if (res.data.ResponseBody.order.deliveryGroupList[i].deliveryPositionId && res.data.ResponseBody.order.deliveryGroupList[i].deliveryPositionId != " ") {
                if ((res.data.ResponseBody.order || {}).positionList) {
                    for (var x = 0; x < res.data.ResponseBody.order.positionList.length; x++) {
                        if (res.data.ResponseBody.order.positionList[x].positionId && res.data.ResponseBody.order.positionList[x].positionId == res.data.ResponseBody.order.deliveryGroupList[i].deliveryPositionId) {
                            if (res.data.ResponseBody.order.positionList[x].materialName && res.data.ResponseBody.order.positionList[x].materialName != " ") {
                                $.temp.handoverType = res.data.ResponseBody.order.positionList[x].materialName;
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    } else {
        return false;
    }
}


// поиск EndReserveDate
function searchForEndReserveDate(res) {
    if ((res.data.ResponseBody.order || {}).deliveryGroupList) {
        for (var i = 0; i < res.data.ResponseBody.order.deliveryGroupList.length; i++) {
            if (res.data.ResponseBody.order.deliveryGroupList[i].paramList) {
                for (var x = 0; x < res.data.ResponseBody.order.deliveryGroupList[i].paramList.length; x++) {

                    if (res.data.ResponseBody.order.deliveryGroupList[i].paramList[x].key && res.data.ResponseBody.order.deliveryGroupList[i].paramList[x].key == "endReserveDate") {
                        $.temp.endReserveDate = res.data.ResponseBody.order.deliveryGroupList[i].paramList[x].value;
                        if ($.temp.endReserveDate != " ") {
                            $.temp.endReserveDate = moment($.temp.endReserveDate).locale("ru").format("LL");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    } else {
        return false;
    }
}

// функция отвечает за логику, если номер заказа не найден в базе данных мвидео: не найден, повторно не найден
function orderIsNotFound() {
    if ($.session.notFound) {
        $reactions.answer(ans.toOperator);
        switchToOperator();
    } else {
        $.session.notFound = true;
        $reactions.answer("Такого заказа нет в системе. Для продолжения укажите номер заказа, информацию по которому вы хотели бы получить.");
        $reactions.transition({value: "/OrderStatus/AskOrderNumber", deferred: true});
    }
}






















