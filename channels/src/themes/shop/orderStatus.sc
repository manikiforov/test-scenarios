theme: /OrderStatus


    state: OrderStatus
        # Где находится мой заказ?
        q!: * [@orderNumber] * (($what $with/$where) {[точно/точна] [находится/находиться/находятся]}/$when [будет]) [$with] {[$interjections] [$comMy/наш*] [$status]} ([$internet] ($orderN/$buyN)/~товар/~вещь) * [@orderNumber] *
        q!: * [@orderNumber] * ($orderN/$buyN/~товар/~вещь) {[$interjections] [$comMy/наш*] [$status]} ({[точно/точна] [находится/находятся]} ($what/$where)/[будет] $when) * [@orderNumber] *

        q!: * [@orderNumber] * куда * прибыл* * $orderN * [@orderNumber] *
        q!: * {@orderNumber * куда * прибыл*} *

        q!: * [@orderNumber] * {(($how/$what) ([там/тут] ([за] (дела/делиш*))/там/тут)) ((у/$with) {[$interjections] [$status] [$comMy/наш*]} ([$internet] ($orderN/$buyN)/~товар/~вещь))} * [@orderNumber] *

        q!: {[$helloAll] [$beginningWords] [$interjections]} [@orderNumber] {$which (([у] [$comMy/наш*]) ([$internet] ($orderN/$buyN)/~товар/~вещь)) $status} * [@orderNumber] *
        q!: {[$helloAll] [$beginningWords] [$interjections]} [@orderNumber] (($canPresFut2/можно) (узнать/получить/сообщить)/пришли*/дай*/напиши*/скажи*/сообщи*) [$meDat/нам] [$comMy/наш*] $status [$comMy/наш] ([$internet] ($orderN/$buyN)/~товар) * [@orderNumber] *
        q!: {[$helloAll] [$beginningWords] [$interjections]} [@orderNumber] (($canPresFut2/можно) (узнать/получить/сообщить)/пришли*/дай*/напиши*/скажи*/сообщи*) [$meDat/нам] [$comMy/наш*] ([$internet] ($orderN/$buyN)/~товар) [$comMy/наш] $status * [@orderNumber] *
        q!: {[$helloAll] [$beginningWords] [$interjections]} [@orderNumber] {[(($canPresFut2/можно) (узнать/получить/сообщить)/пришли*/дай*/напиши*/скажи*/сообщи*)] [$meDat/нам] {$status [$comMy/наш*] ([$internet] ($orderN/$buyN)/~товар)}} * [@orderNumber] *
        q!: * [@orderNumber] * {($when/$whenInWhatDay) * (получу/получим/доставят/доставит*/доставлен/привезут/превизут/привезет*/превезет*/привизет*/привезти/превезти/привизти/привезен*/превезен*/привизен*/поступит/отправлен) * ([$internet] ($orderN/$buyN)/~товар/~вещь/его)} * [@orderNumber] *

        q!: * [@orderNumber] * {($ne (изменился/изминился/изменяется/изминяется/поменялся/поминялся/менялся/минялся/меняется/миняется)) ({$status [$comMy/наш*]} ([$internet] ($orderN/$buyN)/~товар))} * [@orderNumber] *
        q!: * [@orderNumber] * {($ne (изменился/изминился/изменяется/изминяется/поменялся/поминялся/менялся/минялся/меняется/миняется)) ({([$internet] ($orderN/$buyN)/~товар) [$comMy/наш*]} $status)} * [@orderNumber] *

        q!: * $status [$comMy/наш*] @orderNumber *
        q!: * [@orderNumber] * {$possiblePredicAll $status} * [@orderNumber] *
        q!: * [@orderNumber] * $status [$comMy/наш*] ($orderN/$buyN/~товар/~вещь) * [@orderNumber] *
        q!: * [@orderNumber] * ($orderN/$buyN/~товар/~вещь) [$comMy/наш*] $status * [@orderNumber] *
        q!: {[$helloAll] [$beginningWords] [$interjections]} [@orderNumber] (идет/в пути) [$li] [$comMy/наш*] ($delivery/~товар/~покупка) * [@orderNumber] *
        q!: {[$helloAll] [$beginningWords] [$interjections]} [$oneWord] [@orderNumber] [$oneWord] (идет/в пути) [$li] [$comMy/наш*] ($delivery/~товар/~покупка) * [@orderNumber] *

        q!: * [@orderNumber] * $location [$comMy/наш*] ($orderN/~товар/~вещь/~покупка) * [@orderNumber] *
        q!: * [@orderNumber] * ($orderN/~товар/~вещь/~покупка) [$comMy/наш*] $location * [@orderNumber] *

        q!: * [@orderNumber] * $when [$oneWord] ($waitInf/$waitPresRefl3) [$oneWord] [$comMy/наш*] (~курьер/$delivery/его/$orderN/@orderNumber) * [@orderNumber] *
        q!: * [@orderNumber] * $when [$oneWord] [$comMy/наш*] (~курьер/$delivery/его/$orderN/@orderNumber) [$oneWord] ($waitInf/$waitPresRefl3) * [@orderNumber] *
        q!: * [@orderNumber] * (~курьер/$delivery/его/$orderN/@orderNumber) [$oneWord] ($waitInf/$waitPresRefl3) [$oneWord] $when * [@orderNumber] *
        q!: * [@orderNumber] * (~курьер/$delivery/его/$orderN/@orderNumber) [$oneWord] $when [$oneWord] ($waitInf/$waitPresRefl3) * [@orderNumber] *
        q!: * [@orderNumber] * ($waitInf/$waitPresRefl3) [$oneWord] [$comMy/наш*] (~курьер/$delivery/его/$orderN/@orderNumber) [$oneWord] $when * [@orderNumber] *
        q!: * [@orderNumber] * ($waitInf/$waitPresRefl3) [$oneWord] $when [$oneWord] [$comMy/наш*] (~курьер/$delivery/его/$orderN/@orderNumber) * [@orderNumber] *

        q!: * [@orderNumber] * {$when $beFut3 (~курьер/$delivery)} * [@orderNumber] *
        q!: * $when $beFut3 @orderNumber *
        q!: * [@orderNumber] * $when [$oneWord] (собирут/соберет*/соберут/собирет*/составят/составит*/саставят/саставит*) [$comMy/наш*] ((~товар/$orderN/~покупка)/его) * [@orderNumber] *
        q!: * [@orderNumber] * $when [$oneWord] (~товар/$orderN/~покупка/его) [$comMy/наш*] [$oneWord] (собирут/соберет*/соберут/собирет*/составят/составит*/саставят/саставит*) * [@orderNumber] *
        q!: * [@orderNumber] * (~товар/$orderN/~покупка/его) [$comMy/наш*] [$oneWord] (собирут/соберет*/соберут/собирет*/составят/составит*/саставят/саставит*) [$oneWord] $when * [@orderNumber] *
        q!: * [@orderNumber] * (~товар/$orderN/~покупка/его) [$comMy/наш*] [$oneWord] $when [$oneWord] (собирут/соберет*/соберут/собирет*/составят/составит*/саставят/саставит*) * [@orderNumber] *
        q!: * [@orderNumber] * (собирут/соберет*/соберут/собирет*/составят/составит*/саставят/саставит*)  [$comMy/наш*] (~товар/$orderN/~покупка/его) [$oneWord] $when * [@orderNumber] *
        q!: * (собирут/соберет*/соберут/собирет*/составят/составит*/саставят/саставит*) * [@orderNumber] * (~товар/$orderN/~покупка/его) [$oneWord] $when
        q!: * [@orderNumber] * (собирут/соберет*/соберут/собирет*/составят/составит*/саставят/саставит*)  [$oneWord] $when [$comMy/наш*] (~товар/$orderN/~покупка/его) * [@orderNumber] *

        q!: * [@orderNumber] * {(ожидал*/ждал*) [$oneWord] $delivery} * $nobody [$withMe] $callPastNe * [@orderNumber] *
        q!: * [@orderNumber] * {(ожидал*/ждал*) [$oneWord] $delivery} * $callPastNe [$withMe] $nobody * [@orderNumber] *

        q!: * [@orderNumber] * {($today/завтр*) [$oneWord] $delivery} * [@orderNumber] * $callPastNe * [@orderNumber] *

        q!: * [@orderNumber] * (~дата/~число/~день) [$oneWord] $delivery [уже/вроде/должен] [$oneWord] ($today/завтр*) * {$callPastNe [$withMe] $nobody} * [@orderNumber] *
        q!: * (~дата/~число/~день) [$oneWord] $delivery * [@orderNumber] * ($today/завтр*) * {$callPastNe [$withMe] $nobody} *

        q!: * [@orderNumber] * {($today/завтр*) ((~дата/~число/~день) [$oneWord]) $delivery} * {$callPastNe [$withMe] $nobody} * [@orderNumber] *
        q!: * {($today/завтр*) ((~дата/~число/~день) [$oneWord]) $delivery} * [@orderNumber] * {$callPastNe [$withMe] $nobody} *

        q!: * [@orderNumber] * {$callPastNe [$withMe] $nobody} * {($today/завтр*) ((~дата/~число/~день) [$oneWord]) $delivery} * [@orderNumber] *
        q!: * {$callPastNe [$withMe] $nobody} * [@orderNumber] * {($today/завтр*) ((~дата/~число/~день) [$oneWord]) $delivery} *

        q!: * по [$comMy/наш*] ($orderN/~товар/~покупка/$delivery) * $nobody $callPastNe *

        q!: * [@orderNumber] * (пришел/пришол/поступил/паступил/приехал/привезли/превезли) $li [$comMy/наш*] ($orderN/~товар/~покупка) * [@orderNumber] *

        q!: * [@orderNumber] * ($orderN/~товар/~покупка) [$oneWord] [$oneWord] (пришел/пришол/поступил/паступил/приехал/привезли/превезли) $li * [@orderNumber] *

        q!: * [@orderNumber] * ($ne (пойму/знаю/понимаю/понимаем)/нет инф*) * (куда/$where) [$oneWord] (доставлен*/доставят/доставит/прибудет/приедет/приедут/придет/придут/прийдет/прийдут/привезут) [$oneWord] [$oneWord] ($orderN/~товар/~покупка/~вещи) * [@orderNumber] *
        q!: * ($ne (пойму/знаю/понимаю/понимаем)/нет инф*) * [@orderNumber] * (куда/$where) [$oneWord] (доставлен*/доставят/доставит/прибудет/приедет/приедут/придет/придут/прийдет/прийдут/привезут) [$oneWord] [$oneWord] ($orderN/~товар/~покупка/~вещи) *

        q!: * [@orderNumber] * (куда/$where) [$oneWord] (доставлен*/доставят/доставит/прибудет/приедет/приедут/придет/придут/прийдет/прийдут/привезут) [$oneWord] [$oneWord] ($orderN/~товар/~покупка/~вещи) * ($ne (пойму/знаю/понимаю/понимаем)/нет инф*) * [@orderNumber] *
        q!: * (куда/$where) [$oneWord] (доставлен*/доставят/доставит/прибудет/приедет/приедут/придет/придут/прийдет/прийдут/привезут) [$oneWord] [$oneWord] ($orderN/~товар/~покупка/~вещи) * [@orderNumber] * ($ne (пойму/знаю/понимаю/понимаем)/нет инф*) *

        q!: * [@orderNumber] * ~способ $delivery [я/мы] [$oneWord] (выбрал*/выбирал*/выберал*/оформил*/оформлял*) * [@orderNumber] *

        q!: * [@orderNumber] * (выбрал*/выбирал*/выберал*/оформил*/оформлял*) [я/мы] [$oneWord] ~способ $delivery * [@orderNumber] *

        q!: * [@orderNumber] * $where [$oneWord] [$comMy/наш*] ($orderN/~товар/~посылка/$delivery) * [@orderNumber] *

        q!: * [@orderNumber] * $orderN [до сих пор/досих пор/до сихпор/досихпор/все [еще]] ((нет/никако*)/не (поступал/поступил/доставили)/непоступал/непоступил/недоставили) * [@orderNumber] *

        q!: * [@orderNumber] * ((нет/никако*) [(~сообщение/инф*) (о/об/по/про)]/не (поступал/поступил/доставили)/непоступал/непоступил/недоставили) [до сих пор/досих пор/до сихпор/досихпор/все [еще]] [$comMy/наш*] $orderN * [@orderNumber] *

        q!: * [@orderNumber] * (нет/никако*/не поступало/непоступало/не поступило/непоступило [никако*]) {(~сообщение/инф*) [до сих пор/досих пор/до сихпор/досихпор/все [еще]]} (о/об/по/про) [$comMy/наш*] $delivery * [@orderNumber] *

        q!: * [@orderNumber] * $skolko {[$oneWord] [$meDat/нам] $waitInf} ($comMy/наш*) ($delivery/$orderN) * [@orderNumber] *
        q!: * [@orderNumber] * ($delivery/$orderN) {$skolko {[$oneWord] [$meDat/нам] $waitInf}} * [@orderNumber] *

        q!: * [@orderNumber] * детал* ($comMy/моего/наш*) $orderN * [@orderNumber] *

        q!: * [@orderNumber] * {(так и (нет/не было)) [$oneWord] ($orderN/~посылка)} * [@orderNumber] *

        q!: * [@orderNumber] * (уточни*/узнать/проверить/узнай*/проверь*) ~статус [$comMy/наш*] ($orderN/$delivery/~посылка) * [@orderNumber] *

        q!: * [@orderNumber] * (прошу/просим) (уточни*/узнать/проверить/узнай*/проверь*) ~статус [$comMy/наш*] ($orderN/$delivery/~посылка) * [@orderNumber] *

        q!: * [@orderNumber] * ($orderN/$delivery/~посылка) [прошу/просим] (уточни*/узнать/проверить/узнай*/проверь*) [$oneWord] ~статус * [@orderNumber] *

        q!: * [@orderNumber] * (отменен*/отменили/отминен*/отминили) $li [$comMy/наш*] $orderN * [@orderNumber] *
        q!: * [@orderNumber] * $orderN [$comMy/наш*] (отменен*/отменили/отминен*/отминили) $li * [@orderNumber] *

        q!: * [@orderNumber] * (прошла/состоялась/произвел*/произошл*) $li ~отмена * [@orderNumber] *
        q!: * [@orderNumber] * ~отмена [[$comMy/наш*] $orderN] (прошла/состоялась/произвел*/произошл*) $li * [@orderNumber] *

        q!: * [@orderNumber] * (просил* отменить/отменял*) * [@orderNumber] * (отменен*/отменили/отминен*/отминили) $li [$comMy/наш*] $orderN * [@orderNumber] *

        q!: * [@orderNumber] * (просил* отменить/отменял*) * [@orderNumber] * (прошла/состоялась/произвел*/произошл*) $li ~отмена * [@orderNumber] *
        q!: * [@orderNumber] * (просил* отменить/отменял*) * [@orderNumber] * ~отмена [[$comMy/наш*] $orderN] (прошла/состоялась/произвел*/произошл*) $li * [@orderNumber] *

        q!: * [@orderNumber] * (уточни*/узнать/проверить/узнай*/проверь*) (~информация/~инф*) (по/$about) [отмене/~отмена] [$comMy/наш*] $orderN * [@orderNumber] *

        q!: * [@orderNumber] * $how [$meDat/нам] (уточни*/узнать/проверить/узнай*/проверь*) ((~информация/~инф*) (по/о/об) отмене/~отмена) [$comMy/наш*] $orderN * [@orderNumber] *

        q!: * [@orderNumber] * (прошу/просим) [$meDat/$meGenAcc/нас] (уведомить/проинформировать/уведамить/праинфармировать/проинфармировать/доложить) [$meDat/$meGenAcc/нас] (о/об/про) {[~дата] [~время/~срок] [$oneWord]} ($delivery/$orderN/~посылка) * [@orderNumber] *
        q!: * (прошу/просим) [$meDat/$meGenAcc/нас] (уведомить/проинформировать/уведамить/праинфармировать/проинфармировать/доложить) [$meDat/$meGenAcc/нас] * [@orderNumber] * (о/об/про) {[~дата] [~время/~срок] [$oneWord]} ($delivery/$orderN/~посылка) *
        q!: * (уведомить/проинформировать/уведамить/праинфармировать/проинфармировать/доложить) [$meDat/$meGenAcc/нас] (прошу/просим) [$meDat/$meGenAcc/нас] * [@orderNumber] * (о/об/про) {[~дата] [~время/~срок] [$oneWord]} ($delivery/$orderN/~посылка) *
        q!: * [@orderNumber] * (уведомить/проинформировать/уведамить/праинфармировать/проинфармировать/доложить) [$meDat/$meGenAcc/нас] (прошу/просим) [$meDat/$meGenAcc/нас] (о/об/про) {[~дата] [~время/~срок] [$oneWord]} ($delivery/$orderN/~посылка) * [@orderNumber] *
        q!: * [@orderNumber] * (о/об/про) {[~дата] [~время/~срок] [$oneWord]} ($delivery/$orderN/~посылка) [$oneWord] [$oneWord] {(прошу/просим) [$meDat/$meGenAcc/нас] (уведомить/проинформировать/уведамить/праинфармировать/проинфармировать/доложить)} [$meDat/$meGenAcc/нас] * [@orderNumber] *
        q!: * (о/об/про) {[~дата] [~время/~срок] [$oneWord]} ($delivery/$orderN/~посылка) * [@orderNumber] * {(прошу/просим) [$meDat/$meGenAcc/нас] (уведомить/проинформировать/уведамить/праинфармировать/проинфармировать/доложить)} *

        q!: * [@orderNumber] * $orderN * [@orderNumber] * в обработке * [@orderNumber] *
        q!: * @orderNumber * в обработке *

        # Заказ не привезли
        q!: * [@orderNumber] * ($delivery/$orderN/~посылка) * [@orderNumber] * ($ne (пришл*/пришел/приходил*/достав*/привозил*/привез*/довез*)/непришл*/нипришл*/непришел/нипришел/неприходил*/ниприходил*/недостав*/нидостав*/непривозил*/нипривозил*/непривез*/нипривез*/недовез*/нидовез*) * [@orderNumber] *
        q!: * [@orderNumber] * ($ne (пришл*/пришел/приходил*/достав*/привозил*/привез*/довез*)/непришл*/нипришл*/непришел/нипришел/неприходил*/ниприходил*/недостав*/нидостав*/непривозил*/нипривозил*/непривез*/нипривез*/недовез*/нидовез*) * ($delivery/$orderN/~посылка) * [@orderNumber] *

        # могу ли я узнать был ли отменен мой заказ
        q!: {[$helloAll] [$beginningWords] [$interjections]} [{[$optHowNeedWantCan/просьба/просба] [узнать/спросить/спрасить/уточнить/утачнить/проверить/праверить]}/скажи*/уточни*/проверь*/посмотри*/подскажи*/падскажи*] [информаци*] [$meDat] ({[был/были] [$li] (отменен*/отминен*/анулирован*/аннулирован*/снят)}/отменился [$li]/отминился [$li]) [$comMy/наш] ($internet ($orderN/$buyN)/~товар) * [@orderNumber] *

        q!: {[$helloAll] [$beginningWords] [$interjections]} [{[$optHowNeedWantCan/просьба/просба] [узнать/спросить/спрасить/уточнить/утачнить/проверить/праверить]}/скажи*/уточни*/проверь*/посмотри*/подскажи*/падскажи*] [информаци*] [$meDat] {[$comMy/наш] ($internet ($orderN/$buyN)/~товар)} [@orderNumber] ({[был/были] [$li] (отменен*/отминен*/анулирован*/аннулирован*/снят)}/отменился/отминился) * [@orderNumber] *

        q!: {[$helloAll] [$beginningWords] [$interjections]} [{[$optHowNeedWantCan/просьба/просба] [узнать/спросить/спрасить/уточнить/утачнить/проверить/праверить]}/скажи*/уточни*/проверь*/посмотри*/подскажи*/падскажи*] [информаци*] [$meDat] {[$comMy/наш] ($internet ($orderN/$buyN)/~товар)} [@orderNumber] {((прошла/прашла/произошла/праизошла/произашла/праизашла/состоялась/састоялась/прошло/прашло/произошло/праизошло/произашло/праизашло/состоялось/састоялось) [$li]) (отмена/аннулирование/анулирование/снятие)} * [@orderNumber] *

        q!: {[$helloAll] [$beginningWords] [$interjections]} [{[$optHowNeedWantCan/просьба/просба] [узнать/спросить/спрасить/уточнить/утачнить/проверить/праверить]}/скажи*/уточни*/проверь*/посмотри*/подскажи*/падскажи*] [информаци*] [$meDat] {((прошла/прашла/произошла/праизошла/произашла/праизашла/состоялась/састоялась/прошло/прашло/произошло/праизошло/произашло/праизашло/состоялось/састоялось) [$li]) (отмена/аннулирование/анулирование/снятие)} [$comMy/наш] ($internet ($orderN/$buyN)/~товар) * [@orderNumber] *

        q!: {[$helloAll] [$beginningWords] [$interjections]} [{[$optHowNeedWantCan/просьба/просба] [узнать/спросить/спрасить/уточнить/утачнить/проверить/праверить]}/скажи*/уточни*/проверь*/посмотри*/подскажи*/падскажи*] [информаци*] [$meDat] [вы] {[$comMy/наш] ($internet ($orderN/$buyN)/~товар)} [@orderNumber] [вы] (отменили/отминили/отменяли/отминяли/аннулировали/анулировали) * [@orderNumber] *

        q!: {[$helloAll] [$beginningWords] [$interjections]} [{[$optHowNeedWantCan/просьба/просба] [узнать/спросить/спрасить/уточнить/утачнить/проверить/праверить]}/скажи*/уточни*/проверь*/посмотри*/подскажи*/падскажи*] [информаци*] [$meDat] [вы] (отменили/отминили/отменяли/отминяли/аннулировали/анулировали) [$li] [вы] [$comMy/наш] ($internet ($orderN/$buyN)/~товар) * [@orderNumber] *

        # Когда будет собран мой интернет заказ
        q!: * [@orderNumber] * $when [$interjections] {[$meDat] ($internet ($orderN/$buyN)/~товар) [$comMy/наш*]} [@orderNumber] ({будет (собран*/упакован*/упокован*/составлен*/саставлен*/отправлен*/отправлин*/доставлен*/даставлен*)}/соберут/собирут/упакуют/упокуют/составят/саставят/отправят/доставят/{$waitInf ($delivery/отправдение)}/{вы (соберете/собирете/упакуете/упокуете/составите/саставите/отправите/доставите)}/поступит/паступит) * [@orderNumber] *

        q!: * [@orderNumber] * $when {[$interjections] [$meDat]} ({будет (собран*/упакован*/упокован*/составлен*/саставлен*/отправлен*/отправлин*/доставлен*/даставлен*)}/соберут/собирут/упакуют/упокуют/составят/саставят/отправят/доставят/{$waitInf ($delivery/отправдение)}/{вы (соберете/собирете/упакуете/упокуете/составите/саставите/отправите/доставите)}/поступит/паступит) [$comMy/наш*] ($internet ($orderN/$buyN)/~товар) * [@orderNumber] *

        q!: * [@orderNumber] * ({будет (собран*/упакован*/упокован*/составлен*/саставлен*/отправлен*/отправлин*/доставлен*/даставлен*)}/соберут/собирут/упакуют/упокуют/составят/саставят/отправят/доставят/{$waitInf ($delivery/отправдение)}/{вы (соберете/собирете/упакуете/упокуете/составите/саставите/отправите/доставите)}/поступит/паступит) {[$meDat] [$comMy/наш*] ($internet ($orderN/$buyN)/~товар)} [@orderNumber] [$interjections] $when * [@orderNumber] *

        q!: * [@orderNumber] * ({будет (собран*/упакован*/упокован*/составлен*/саставлен*/отправлен*/отправлин*/доставлен*/даставлен*)}/соберут/собирут/упакуют/упокуют/составят/саставят/отправят/доставят/{$waitInf ($delivery/отправдение)}/{вы (соберете/собирете/упакуете/упокуете/составите/саставите/отправите/доставите)}/поступит/паступит) {[$meDat] $when [$interjections]} [$comMy/наш*] ($internet ($orderN/$buyN)/~товар) * [@orderNumber] *

        # Узнать дату доставки
        q!: [@orderNumber] {[$helloAll] [$beginningWords] [$interjections]} [{[$optHowNeedWantCan/просьба] [узнать/спросить/спрасить/уточнить/утачнить/проверить/праверить]}/скажи*/уточни*/проверь*/посмотри*/подскажи*/падскажи*] [информаци*] [по/о/об] [точн*/конкретн*/канкретн*] (~дата/~день/~время/~срок) ([$comMy/наш*] $delivery) [[$comMy/наш*] ([$internet] ($orderN/$buyN)/~товар/~вещь)] [@orderNumber]

        q!: [@orderNumber] {[$helloAll] [$beginningWords] [$interjections]} [$which/$what по] [информаци*] [по/о/об] [точн*/конкретн*/канкретн*] (~дата/~день/~время/~срок) ([$comMy/наш*] $delivery) [[$comMy/наш*] ([$internet] ($orderN/$buyN)/~товар/~вещь)] [@orderNumber] [{[$optHowNeedWantCan/просьба] [узнать/спросить/спрасить/уточнить/утачнить/проверить/праверить]}/скажи*/уточни*/проверь*/посмотри*/подскажи*/падскажи*] [@orderNumber]

        q!: [@orderNumber] {[$helloAll] [$beginningWords] [$interjections]} [информаци*] [по/о/об] [точн*/конкретн*/канкретн*] (~дата/~день/~время/~срок) [$comMy/наш*] $delivery [[$comMy/наш*] ([$internet] ($orderN/$buyN)/~товар/~вещь)] [@orderNumber] (нет/нету/отсутствует/$ne (знаю/знаем/помню/помним/нахожу/находим/имею/имеем/получил*/пришел/пришл*/отправили)/($canPres3/$canPresFutSg1/$canPresFutPl1) (знать/*помнить/найти/отыскать/отследить/отслидить)) * [@orderNumber] *

        q!: * [@orderNumber] * (нет/нету/отсутствует/$ne (знаю/знаем/помню/помним/нахожу/находим/имею/имеем/получил*/пришел/пришл*/отправили)/($canPres3/$canPresFutSg1/$canPresFutPl1) (знать/*помнить/найти/отыскать/отследить/отслидить)) [информаци*] [по/о/об] [точн*/конкретн*/канкретн*] (~дата/~день/~время/~срок) [$comMy/наш*] $delivery [[$comMy/наш*] ([$internet] ($orderN/$buyN)/~товар/~вещь)] [@orderNumber]

        # когда могу получить заказ?
        q!: * [@orderNumber] * $when * получить * ([$internet] ($orderN/$buyN)/~товар/~вещь) * [@orderNumber] *
        q!: * $when * получить @orderNumber *
        q!: * [@orderNumber] * ($possiblePredic/$canPresFutSg1/$canPresFutPl1) * $today * {([$internet] ($orderN/$buyN)/~товар/~вещь) [$comMy/наш*/@orderNumber] (получить/получит)} * [@orderNumber] *
        q!: * [@orderNumber] * ($possiblePredic/$canPresFutSg1/$canPresFutPl1) * {([$internet] ($orderN/$buyN)/~товар/~вещь) [$comMy/наш*/@orderNumber] (получить/получит)} * [@orderNumber] * $today * [@orderNumber] *
        q!: * [@orderNumber] * ([$internet] ($orderN/$buyN)) * [@orderNumber] * ($possiblePredic/$canPresFutSg1/$canPresFutPl1) * {$today забрать} * [@orderNumber] *
        q!: * [@orderNumber] * ([$internet] ($orderN/$buyN)) * [@orderNumber] * $when * забрать * [@orderNumber] *

        q!: * [@orderNumber] * доставка со склада * уже $oneWord день * [@orderNumber] *

        q: * ~другой [$internet] $orderN * || fromState = "/Conversation/AnyMoreQuestions"

        intent!: /OrderStatus
        script:
            if ($session.attempt) {
                if ($session.attempt < 2) {
                    orderStatusHandler();
                } else {
                    $reactions.answer(ans.toOperator);
                    switchToOperator();
                }
            } else {
                $session.attempt = 0;
                if ($session.authorization) {
                    $session.sessionId = $request.rawRequest.sessionId;
                    $session.sessionParams = getSessionParams();
                    $session.orderList = checkOrderList($session.sessionParams);
                    $session.phone = getPhoneFromSessionParams($session.sessionParams);
                }
                orderStatusHandler();
            }


    state: AskOrderNumber
        a: Уточните, пожалуйста, номер заказа, по которому вы хотели бы получить информацию.


        state: WhereToFind
            # где найти номер заказа
            q: * (где|в каком месте|откуда|как) * (найти|узнать|получить) [номер] [заказа]
            script:
                $reactions.answer("Номер заказа вы можете найти в личном кабинете или в SMS-сообщении о заказе от отправителя M.Video");


        state: GetOrderNumber
            q: * @orderNumber *
            script:
                $session.orderNumber = $parseTree._orderNumber;
                if ($session.authorization) {
                    if ($session.notFound) {
                        if ($session.orderList && searchForOrderInOrderList($session.sessionParams)) {
                            $temp.res = getOrderParams();
                            if ($temp.res.isOk) {
                                orderStatusTransition($temp.res);
                            } else {
                                checkErrors($temp.res);
                            }
                        } else {
                            $temp.res = getOrderParams();
                            if ($temp.res.isOk) {
                                if (comparePhone($temp.res)) {
                                    orderStatusTransition($temp.res);
                                } else {
                                    $session.orderParams = $temp.res;
                                    $session.badPhone = true;
                                    $reactions.transition("/OrderStatus/AskPhone");
                                }
                            } else {
                                checkErrors($temp.res);
                            }
                        }
                    } else {
                        $temp.res = getOrderParams();
                        if ($temp.res.isOk) {
                            if (comparePhone($temp.res)) {
                                orderStatusTransition($temp.res);
                            } else {
                                $session.orderParams = $temp.res;
                                $session.badPhone = true;
                                $reactions.transition("/OrderStatus/AskPhone");
                            }
                        } else {
                            checkErrors($temp.res);
                        }
                    }
                } else {
                    if ($session.notFound) {
                        $temp.res = getOrderParams();
                        if ($temp.res.isOk) {
                            if (comparePhone($temp.res)) {
                                orderStatusTransition($temp.res);
                            } else {
                                $session.orderParams = $temp.res;
                                $session.badPhone = true;
                                $reactions.answer(ans.badPhone);
                                $reactions.transition("/OrderStatus/AskPhone");
                            }
                        } else {
                            checkErrors($temp.res);
                        }
                    } else {
                        $reactions.transition("/OrderStatus/AskPhone");
                    }
                }


        state: NoMatch
            event: noMatch
            if: $session.score
                script:
                    $reactions.answer(ans.toOperator);
                    switchToOperator();
            else:
                script:
                    $reactions.answer(ans.incorrectOrderNumber);
                    $session.score = true;


    state: AskPhone
        script:
            $reactions.answer(ans.askPhone);


        state: GetPhone
            q: * $mobilePhoneNumberRus *
            script:
                getPhone($parseTree);
                if ($session.authorization) {
                    if (comparePhone($session.orderParams)) {
                        orderStatusTransition($session.orderParams);
                    } else {
                        if ($session.badPhone) {
                            $session.badPhone = false;
                            $reactions.answer(ans.toOperator);
                            switchToOperator();
                        } else {
                            $session.badPhone = true;
                            $reactions.answer(ans.badPhone);
                            $reactions.answer(ans.askPhone);
                        }
                    }
                } else {
                    if ($session.badPhone) {
                        if (comparePhone($session.orderParams)) {
                            orderStatusTransition($session.orderParams);
                        } else {
                            $session.badPhone = false;
                            $reactions.answer(ans.toOperator);
                            switchToOperator();
                        }
                    } else {
                        $temp.res = getOrderParams();
                        if ($temp.res.isOk) {
                            if (comparePhone($temp.res)) {
                                orderStatusTransition($temp.res);
                            } else {
                                $session.orderParams = $temp.res;
                                $session.badPhone = true;
                                $reactions.answer(ans.badPhone);
                                $reactions.answer(ans.askPhone);
                            }
                        } else {
                            checkErrors($temp.res);
                        }
                    }
                }


        state: NoMatch
            event: noMatch
            if: $session.score2
                script:
                    $reactions.answer(ans.toOperator);
                    switchToOperator();
            else:
                a: Номер телефона не распознан. Пожалуйста, введите 10 цифр номера телефона.
                script:
                    $session.score2 = true;


    state: OnlyOneOrder
        # у клиента только один номер в списке заказов
        a: Пожалуйста, введите номер интересующего вас заказа. Или вас интересует заказ {{$session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[0].number}}?


        state: Yes
        # авторизован, назвал номер из своего списка
            q: * $comYes *
            q: * {(он/этот) [и] интересует} *
            q: * именно (он/этот) *
            q: * это он *
            q: (именно/[все/абсолютно] (верно/правильно))
            script:
                $session.orderNumber = $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[0].number;
                $temp.res = getOrderParams();
                if ($temp.res.isOk) {
                    orderStatusTransition($temp.res);
                } else {
                    checkErrors($temp.res);
                }


        state: GetOrderNumber
            q: * @orderNumber *
            script:
                if ($parseTree._orderNumber == $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[0].number) {
                    $reactions.transition("/OrderStatus/OnlyOneOrder/Yes");
                } else {
                    $session.orderNumber = $parseTree._orderNumber;
                    $temp.res = getOrderParams();
                    if ($temp.res.isOk) {
                        if (comparePhone($temp.res)) {
                            orderStatusTransition($temp.res);
                        } else {
                            $session.orderParams = $temp.res;
                            $session.badPhone = true;
                            $reactions.transition("/OrderStatus/AskPhone")
                        }
                    } else {
                        checkErrors($temp.res);
                    }
                }


        state: NoMatch
            event: noMatch
            if: $session.score3
                script:
                    $reactions.answer(ans.toOperator);
                    switchToOperator();
            else:
                script:
                    $reactions.answer(ans.incorrectOrderNumber);
                    $session.score3 = true;


    state: TwoOrders
        # у клиента в списке 2 номера заказа
        script:
            $temp.orders = $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders.map(function (o) { return {number: o.number, date: o.creationTime, cost: o.amount}});
            $reactions.answer("Пожалуйста, введите номер интересующего вас заказа или выберите заказ из списка:\n1. № {{$temp.orders[0].number}} от {{$temp.orders[0].date}} на сумму {{$temp.orders[0].cost}}.\n2. № {{$temp.orders[1].number}} от {{$temp.orders[1].date}} на сумму {{$temp.orders[1].cost}}.");


        state: GetNumber
            # первый
            q: * $firstOrder *
            # второй
            q: * ($secondOrder/$last) *
            script:
                if ($parseTree._firstOrder) {
                    $session.orderNumber = $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[0].number;
                } else {
                    $session.orderNumber = $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[1].number;
                }
                $temp.res = getOrderParams();
                if ($temp.res.isOk) {
                    orderStatusTransition($temp.res);
                } else {
                    checkErrors($temp.res);
                }


        state: GetOrderNumber
            q: * @orderNumber *
            script:
                $session.orderNumber = $parseTree._orderNumber;
                if ($session.orderNumber == $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[0].number || $session.orderNumber == $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[1].number) {
                    $temp.res = getOrderParams();
                    if ($temp.res.isOk) {
                        orderStatusTransition($temp.res);
                    } else {
                        checkErrors($temp.res);
                    }
                } else {
                    $temp.res = getOrderParams();
                    if ($temp.res.isOk) {
                        if (comparePhone($temp.res)) {
                            orderStatusTransition($temp.res);
                        } else {
                            $session.orderParams = $temp.res;
                            $session.badPhone = true;
                            $reactions.transition("/OrderStatus/AskPhone")
                        }
                    } else {
                        checkErrors($temp.res);
                    }
                }


        state: NoMatch
            event: noMatch
            if: $session.score4
                script:
                    $reactions.answer(ans.toOperator);
                    switchToOperator();
            else:
                script:
                    $reactions.answer(ans.incorrectOrderNumber);
                    $session.score4 = true;



    state: ThreeOrMoreOrders
        # у клиента в списке больше, чем 2 номера заказа
        script:
            $temp.orders = $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders.map(function (o) { return {number: o.number, date: o.creationTime, cost: o.amount}});
            $reactions.answer("Пожалуйста, введите номер интересующего вас заказа или выберите заказ из списка:\n1. № {{$temp.orders[0].number}} от {{$temp.orders[0].date}} на сумму {{$temp.orders[0].cost}}.\n2. № {{$temp.orders[1].number}} от {{$temp.orders[1].date}} на сумму {{$temp.orders[1].cost}}.\n3. № {{$temp.orders[2].number}} от {{$temp.orders[2].date}} на сумму {{$temp.orders[2].cost}}.");


        state: GetNumber
            # первый
            q: * $firstOrder *
            # второй
            q: * ($secondOrder/$penultimate) *
            # третий
            q: * ($thirdOrder/$last) *
            script:
                if ($parseTree._firstOrder) {
                    $session.orderNumber = $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[0].number;
                } else if ($parseTree._secondOrder || $parseTree._penultimate) {
                    $session.orderNumber = $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[1].number;
                } else {
                    $session.orderNumber = $session.sessionParams.data.clientData.UserLastOrders.ResponseBody.orders[2].number;
                }
                $temp.res = getOrderParams();
                if ($temp.res.isOk) {
                    orderStatusTransition($temp.res);
                } else {
                    checkErrors($temp.res);
                }


        state: GetOrderNumber
            q: * @orderNumber *
            script:
                $session.orderNumber = $parseTree._orderNumber;
                if (searchForOrderInOrderList($session.sessionParams)) {
                    $temp.res = getOrderParams();
                    if ($temp.res.isOk) {
                        orderStatusTransition($temp.res);
                    } else {
                        checkErrors($temp.res);
                    }

                } else {
                    $temp.res = getOrderParams();
                    if ($temp.res.isOk) {
                        if (comparePhone($temp.res)) {
                            orderStatusTransition($temp.res);
                        } else {
                            $session.orderParams = $temp.res;
                            $session.badPhone = true;
                            $reactions.transition("/OrderStatus/AskPhone")
                        }
                    } else {
                        checkErrors($temp.res);
                    }
                }


        state: NoMatch
            event: noMatch
            if: $session.score5
                script:
                    $reactions.answer(ans.toOperator);
                    switchToOperator();
            else:
                script:
                    $reactions.answer(ans.incorrectOrderNumber);
                    $session.score5 = true;

