package bicca.lucas.agronutriapp.logic

import bicca.lucas.agronutriapp.R

enum class PlantEnum(val phEnum: PhEnum, val stringId: Int) {

    NONE(PhEnum.noReference, R.string.empty_text),

    // region --- pH 6,5 ---
    ALFAFA(PhEnum.pH65, R.string.alfafa), ASPARGO(PhEnum.pH65, R.string.aspargo),
    MACIEIRA(PhEnum.pH65, R.string.macieira), OLIVEIRA(PhEnum.pH65, R.string.oliveira),
    PIRETRO(PhEnum.pH65, R.string.piretro),
    // endregion

    // region --- pH 6,0 ---
    ABACATEIRO(PhEnum.pH60, R.string.abacateiro), ABOBORA(PhEnum.pH60, R.string.abobora),
    ABOBRINHA(PhEnum.pH60, R.string.abobrinha), ALCACHOFRA(PhEnum.pH60, R.string.alcachofra),
    ALFACE(PhEnum.pH60, R.string.alface), ALHO(PhEnum.pH60, R.string.alho),
    ALMEIRAO(PhEnum.pH60, R.string.almeirao), AMEIXEIRA(PhEnum.pH60, R.string.ameixeira),
    AMENDOIM(PhEnum.pH60, R.string.amendoim), ARROZ_DE_SEQUEIRO(PhEnum.pH60, R.string.arroz_de_sequeiro),
    AVEIA(PhEnum.pH60, R.string.aveia), BANANEIRA(PhEnum.pH60, R.string.bananeira),
    BATATA_DOCE(PhEnum.pH60, R.string.batata_doce), BERINJELA(PhEnum.pH60, R.string.berinjela),
    BETERRABA(PhEnum.pH60, R.string.beterraba), BROCOLIS(PhEnum.pH60, R.string.brocolis),
    CANA_DE_ACUCAR(PhEnum.pH60, R.string.cana_de_acucar), CAMOMILA_60(PhEnum.pH60, R.string.camomila_ph60),
    CANOLA(PhEnum.pH60, R.string.canola), CAPIM_LIMAO(PhEnum.pH60, R.string.capim_limao),
    CAQUIZEIRO(PhEnum.pH60, R.string.caquizeiro), CEBOLA(PhEnum.pH60, R.string.cebola),
    CENOURA(PhEnum.pH60, R.string.cenoura), CENTEIO(PhEnum.pH60, R.string.centeio),
    CEVADA(PhEnum.pH60, R.string.cevada), CHICORIA(PhEnum.pH60, R.string.chicoria),
    CHUCHU(PhEnum.pH60, R.string.chuchu), CITROS(PhEnum.pH60, R.string.citros),
    CONSORCIACAO_DE_GRAMINEAS_E_LEGUMINOSAS_ESTACAO_FRIA(PhEnum.pH60, R.string.consorciacao_gramineas_leguminosas_estacao_fria),
    CONSORCIACAO_DE_GRAMINEAS_E_LEGUMINOSAS_ESTACAO_QUENTE(PhEnum.pH60, R.string.consorciacao_gramineas_leguminosas_estacao_quente),
    COUVE_FLOR(PhEnum.pH60, R.string.couve_flor), CRISANTEMO(PhEnum.pH60, R.string.crisantemo),
    ERVILHA(PhEnum.pH60, R.string.ervilha), ERVILHA_FORRAGEIRA(PhEnum.pH60, R.string.ervilha_forrageira),
    ERVILHACA(PhEnum.pH60, R.string.ervilhaca), ESTEVIA(PhEnum.pH60, R.string.estevia),
    FEIJAO(PhEnum.pH60, R.string.feijao), FIGUEIRA(PhEnum.pH60, R.string.figueira),
    GENGIBRE(PhEnum.pH60, R.string.gengibre), GIRASSOL(PhEnum.pH60, R.string.girassol),
    GRAMINEAS_FORRAGEIRAS_DE_ESTACAO_FRIA(PhEnum.pH60, R.string.gramineas_forrageiras_estacao_fria),
    GRAMINEAS_FORRAGEIRAS_DE_ESTACAO_QUENTE(PhEnum.pH60, R.string.gramineas_forrageiras_estacao_quente),
    HORTELA(PhEnum.pH60, R.string.hortela),
    LEGUMINOSAS_FORRAGEIRAS_DE_ESTACAO_FRIA(PhEnum.pH60, R.string.leguminosas_forrageiras_estacao_fria),
    LEGUMINOSAS_FORRAGEIRAS_DE_ESTACAO_QUENTE(PhEnum.pH60, R.string.leguminosas_forrageiras_estacao_quente),
    LINHO(PhEnum.pH60, R.string.linho), MILHO_PIPOCA(PhEnum.pH60, R.string.milho_pipoca),
    MORANGA(PhEnum.pH60, R.string.moranga), MORANGUEIRO(PhEnum.pH60, R.string.morangueiro),
    NABO(PhEnum.pH60, R.string.nabo), NABO_FORRAGEIRO(PhEnum.pH60, R.string.nabo_forrageiro),
    NECTARINEIRA(PhEnum.pH60, R.string.nectarineira), NOGUEIRA_PECA(PhEnum.pH60, R.string.nogueira_peca),
    PAINCO(PhEnum.pH60, R.string.painco), PALMA_ROSA(PhEnum.pH60, R.string.palma_rosa),
    PEPINO(PhEnum.pH60, R.string.pepino), PEREIRA(PhEnum.pH60, R.string.pereira),
    PESSEGUEIRO(PhEnum.pH60, R.string.pessegueiro), PIMENTAO(PhEnum.pH60, R.string.pimentao),
    QUIVIZEIRO(PhEnum.pH60, R.string.quivizeiro), RABANETE(PhEnum.pH60, R.string.rabanete),
    REPOLHO(PhEnum.pH60, R.string.repolho), ROSEIRA_DE_CORTE(PhEnum.pH60, R.string.roseira_corte),
    RUCULA(PhEnum.pH60, R.string.rucula), SOJA(PhEnum.pH60, R.string.soja),
    SORGO(PhEnum.pH60, R.string.sorgo), TABACO(PhEnum.pH60, R.string.tabaco),
    TOMATE(PhEnum.pH60, R.string.tomate), TREMOCO(PhEnum.pH60, R.string.tremoco),
    TRIGO(PhEnum.pH60, R.string.trigo), TRITICALE(PhEnum.pH60, R.string.triticale),
    URUCUM(PhEnum.pH60, R.string.urucum), VETIVER(PhEnum.pH60, R.string.vetiver),
    VIDEIRA(PhEnum.pH60, R.string.videira),
    // endregion

    // region --- pH 5,5 ---
    ALFAVACA(PhEnum.pH55, R.string.alfafa), AMOREIRA_PRETA(PhEnum.pH55, R.string.amoreira_preta),
    ARROZ_IRRIGADO_SOLO_SECO(PhEnum.pH55, R.string.arroz_irrigado_sistema_semeadura_solo_seco),
    BATATA(PhEnum.pH55, R.string.batata), CALENDULA(PhEnum.pH55, R.string.calendula),
    CAMOMILA_55(PhEnum.pH55, R.string.camomila_ph55), CARDAMOMO(PhEnum.pH55, R.string.cardamomo),
    CARQUEJA(PhEnum.pH55, R.string.carqueja), CHA(PhEnum.pH55, R.string.cha),
    CITROLENA_DE_JAVA(PhEnum.pH55, R.string.citronela_de_java), COENTRO(PhEnum.pH55, R.string.coentro),
    CURCUMA(PhEnum.pH55, R.string.curcuma), ERVA_DOCE(PhEnum.pH55, R.string.erva_doce),
    FUNCHO(PhEnum.pH55, R.string.funcho), GUACO(PhEnum.pH55, R.string.guaco),
    MANJERICAO(PhEnum.pH55, R.string.manjericao), MIRTILO(PhEnum.pH55, R.string.mirtilo),
    PALMEIRA_JUCARA(PhEnum.pH55, R.string.palmeira_jucara), PALMEIRA_REAL(PhEnum.pH55, R.string.palmeira_real),
    PUPUNHEIRA(PhEnum.pH55, R.string.pupunheira), SALSA(PhEnum.pH55, R.string.salsa),
    // endregion

    // region --- sem pH de referência
    ARROZ_PRE_GERMINADO(PhEnum.noReference, R.string.arroz_irrigado_sistem_pregerminado_transplante_mudas),
    ARAUCARIA(PhEnum.noReference, R.string.araucaria), ACACIA_NEGRA(PhEnum.noReference, R.string.acacia_negra),
    BRACATINGA(PhEnum.noReference, R.string.bracatinga), CEDRO_AUSTRALIANO(PhEnum.noReference, R.string.cedro_australiano),
    ERVA_MATE(PhEnum.noReference, R.string.erva_mate), EUCALIPTO(PhEnum.noReference, R.string.eucalipto),
    PINUS(PhEnum.noReference, R.string.pinus), MANDIOCA(PhEnum.noReference, R.string.mandioca),
    PASTAGEM_NATURAL(PhEnum.noReference, R.string.pastagem_natural)
    // endregion
}