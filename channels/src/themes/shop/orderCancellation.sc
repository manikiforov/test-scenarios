theme: /OrderCancellation


    state: HowToCancelTheOrder
        # Как отменить заказ
        q!: * [@orderNumber] * [*росьба/просба] ($cancelVInf/$cancelVImp/$cancelN/аннулировать/анулировать/аннулирование/анулирование/аннулируй*/анулируй*) {[$please] [$lets/$optNeedWantCan/прошу/просим] [$meDat/нам]} [$comMy/наш] ([$internet] ($orderN/$buyN)/~товар) * [@orderNumber] *

        q!: * [@orderNumber] * ($orderN/$buyN/~товар) [$comMy/наш] {[$please] [$lets/$optNeedWantCan/прошу/просим] [$meDat/нам]} ($cancelVInf/$cancelVImp/$cancelN/аннулировать/анулировать/аннулирование/анулирование/аннулируй*/анулируй*) * [@orderNumber] *

        q!: * @orderNumber * [*росьба/просба] ($cancelVInf/$cancelVImp/$cancelN/аннулировать/анулировать/аннулирование/анулирование/аннулируй*/анулируй*) *

        q!: * ($cancelVInf/$cancelVImp/$cancelN/аннулировать/анулировать/аннулирование/анулирование/аннулируй*/анулируй*) * @orderNumber *

        q!: * (отказатс*/отказатьс*/отказац*) от [$comMy] ($orderN/@orderNumber) *
        q!: * от [$comMy] ($orderN/@orderNumber) * (отказатс*/отказатьс*/отказац*) *
        q!: * $optHowNeedWantCan [его] $cancelVInf *

        intent!: /HowToCancelTheOrder
        script:
            $reactions.answer(ans.toOperator);
            switchToOperator();