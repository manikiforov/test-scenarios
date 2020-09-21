theme: /AboutBot

    state: WhatAreYourSkills
        # что ты умеешь
        q!: * {($comWhat/$something) * ($botAll/$youNom/$botName) * ($canPresFut2/$canPres3/$beAbleVPres2/умеет/уммет/знает/знаеш*/знаиш*)} *
        q!: * (о/про) свои возможност* *
        q!: * возможности ($botAll/$botName) *
        q!: * $with чем можеш* *

        # что умеешь?
        q!: * $what {[$interjections/в (принципе/целом)/по сути] [$doVInf] [$else]} ($canPres2/умееш*/знаеш*/знаиш*) *

        # ты вообще способен на что-нибудь
        q!: * {((на/под) ($what/$something)) * ($botAll/$youNom/$botName) * (*программирован*/*програмирован*/*дрессирован*/*дресирован*/способен*/способн*/заточен*)} *

        # в чем твоя супер сила
        q!: * {($skill/[супер] ($possibility/~сила)) * ($botAll/$botName/$your/(у/в) ($youGenAcc/$youDat))} *

        # какие навыки доступны
        q!: * $which * {($skill/~функционал) * ($available/имеете/предоставляете/обеспечиваете/$canPresFut2 (предоставить/обеспечить))} *
        q!: * $which [$oneWord] (у тебя/у вас/увас) * ($skill/~функционал) *
        q!: * ($skill/~функционал) * $which * ($available/имеете/предоставляете/обеспечиваете/$canPresFut2 (предоставить/обеспечить)) *
        q!: * ($available/имеете/предоставляете/обеспечиваете/$canPresFut2 (предоставить/обеспечить)) * $which * ($skill/~функционал) *

        # бот какой функционал имеет
        q!: * $which * {($skill/$servicePl/~функционал) * ($botAll/$botName) * (имеет/есть/предоставляет/обеспечивает/$canPres3 (предоставить/обеспечить))} *
        q!: * ($skill/$servicePl/~функционал) * $which * {($botAll/$botName) * (имеет/есть/предоставляет/обеспечивает/$canPres3 (предоставить/обеспечить))} *
        q!: * ($botAll/$botName) * {$which * ($skill/$servicePl/~функционал) * (имеет/есть/предоставляет/обеспечивает/$canPres3 (предоставить/обеспечить))} *

        # зачем ты нужен
        q!: * ($whatFor/кому) {[$else] [$interjections/в (принципе/целом)/по сути] ($botAll/$youNom/$botName)} (нужен/нуен/нужн/нужин/нужна/нужны) *
        q!: * ($whatFor/кому) {[$else] [$interjections/в (принципе/целом)/по сути] (нужен/нуен/нужн/нужин/нужна/нужны)} ($botAll/$youNom/$botName) *
        q!: * ($botAll/$youNom/$botName) {[$else] [$interjections/в (принципе/целом)/по сути] (нужен/нуен/нужн/нужин/нужна/нужны)} ($whatFor/кому) *
        q!: * ($botAll/$youNom/$botName) {[$else] [$interjections/в (принципе/целом)/по сути] ($whatFor/кому)} (нужен/нуен/нужн/нужин/нужна/нужны) *
        q!: * (нужен/нуен/нужн/нужин/нужна/нужны) {[$else] [$interjections/в (принципе/целом)/по сути] ($whatFor/кому)} ($botAll/$youNom/$botName) *
        q!: * (нужен/нуен/нужн/нужин/нужна/нужны) {[$else] [$interjections/в (принципе/целом)/по сути] ($botAll/$youNom/$botName)} ($whatFor/кому) *

        # какие вопросы тебе можно задавать
        q!: * {($which вопрос*) * ($canPresFutSg1/$possiblePredic) * (задавать/задать/спрашивать/спросить)} *
        q!: * (о чем/про $comWhat) * $possiblePredic * (спрашивать/спросить) *

        # в чем ты хорош
        q!: * {((в/к) (чем/чему)) $youNom (хорош*/умелы*/способн*)} *
        q!: * чем [мне/нам] [$botAll/$youNom/$botName] ($canPresFut2/$canPres3/$beAbleVPres2) * помоч* *
        intent!: /WhatAreYourSkills
        a: Я могу проконсультировать вас по вопросам, связанным с заказами, ассортиментом и покупками.