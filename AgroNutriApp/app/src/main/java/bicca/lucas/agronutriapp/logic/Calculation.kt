package bicca.lucas.agronutriapp.logic

class Calculation {

    companion object {

        /**
         * Ao se optar pelo estabelecimento da dose de calcário pelo método da saturação
         * por bases, a partir dos dados constantes nos laudos de análise de solo (V% e CTCpH7,0)
         * e do V% considerando o pH de referência do grupo de culturas de interesse, esta
         * equação define a dose de calcário. (página 71)
         *
         * @param[v1] V1 = saturação por bases desejadas (65, 75 ou 85%)
         * @param[v2] V2 = saturação por bases do solo, expressa no laudo de análise
         * @param[ctcPh7] = CTCpH7,0 = capacidade de troca de cátions estimada a pH 7,0 (CTCpH7,0)
         */
        fun nc(v1: Double, v2: Double, ctcPh7: Double) = ((v1 - v2) / 100) * ctcPh7

        fun ncByPh(pH: PhEnum, mo: Double, al: Double) = when (pH) {
            PhEnum.pH55 -> ncByPh55(mo, al)
            PhEnum.pH60 -> ncByPh60(mo, al)
            PhEnum.pH65 -> ncByPh65(mo, al)
            PhEnum.noReference -> 0.0
        }

        /**
         * Equação polinomial que leva em conta o teor da matéria e de alumínio trocável
         * para definir a dose de calcário. Utilizado especificamente nos casos de solos
         * com baixo poder tampão (arenosos e/ou pobres de matéria orgância, geralmente
         * com índice SMP maior que 6,3) o índice SMP pode subestimar a acidez potencial e,
         * consequentemente, indicar uma dose de calcário insuficiente para elevar o pH até
         * o valor desejado. (página 72)
         *
         * @param[mo] teor de matéria orgânica, em porcentagem
         * @param[al] alumínio trocável do solo, em cmolc/dm3.
         *
         * @return NC pH 5,5 - Em que: NC = necessidade de calcário (PRNT 100%), em t/ha,
         * para corrigir a camada de 0 a 20 cm aos pH de referência de 5,5
         */
        private fun ncByPh55(mo: Double, al: Double) = ((0.480 * mo) + (1.937 * al)) - 0.653

        /**
         * Equação polinomial que leva em conta o teor da matéria e de alumínio trocável
         * para definir a dose de calcário. Utilizado especificamente nos casos de solos
         * com baixo poder tampão (arenosos e/ou pobres de matéria orgância, geralmente
         * com índice SMP maior que 6,3) o índice SMP pode subestimar a acidez potencial e,
         * consequentemente, indicar uma dose de calcário insuficiente para elevar o pH até
         * o valor desejado. (página 72)
         *
         * @param[mo] teor de matéria orgânica, em porcentagem
         * @param[al] alumínio trocável do solo, em cmolc/dm3.
         *
         * @return NC pH 6,0 - Em que: NC = necessidade de calcário (PRNT 100%), em t/ha,
         * para corrigir a camada de 0 a 20 cm aos pH de referência de 6,0
         */
        private fun ncByPh60(mo: Double, al: Double) =  ((0.805 * mo) + (2.435 * al)) - 0.516

        /**
         * Equação polinomial que leva em conta o teor da matéria e de alumínio trocável
         * para definir a dose de calcário. Utilizado especificamente nos casos de solos
         * com baixo poder tampão (arenosos e/ou pobres de matéria orgância, geralmente
         * com índice SMP maior que 6,3) o índice SMP pode subestimar a acidez potencial e,
         * consequentemente, indicar uma dose de calcário insuficiente para elevar o pH até
         * o valor desejado. (página 72)
         *
         * @param[mo] teor de matéria orgânica, em porcentagem
         * @param[al] alumínio trocável do solo, em cmolc/dm3.
         *
         * @return NC pH 6,5 - Em que: NC = necessidade de calcário (PRNT 100%), em t/ha,
         * para corrigir a camada de 0 a 20 cm aos pH de referência de 6,5
         */
        private fun ncByPh65(mo: Double, al: Double) = ((1.193 * mo) + (2.713 * al)) - 0.122

        /**
         * Mesmo para as culturas perenes com grande espaçamento entre linhas, o mais
         * recomendado é a aplicação do corretivo da acidez na área total, até porque
         * é possível cultivar espécies anuais ou semiperenes nas entrelinhas,
         * especialmente, durante a formação do pomar ou da floresta. Opcionalmente,
         * a aplicação de calcário pode se restringir apenas a faixa de plantio e sua
         * incorporação até 20 cm de profundidade, com o ajuste correspondente da dose
         * em função da área de aplicação.
         *
         * (página 84)
         *
         * @param[nc] NC = necessidade de calcário para a cultura (t/ha)
         * @param[lfa] LFA = largura da faixa de aplicação do calcário (m)
         * @param[dlp] DLP = distância entre as linhas de plantio (m)
         * @param[prnt] PRNT = poder relativo de neutralização total do calcário (%)
         * @return DC = dose de calcário (t/ha)
         */
        fun adjustCalByAreaApplication(
                nc: Double, lfa: Double, dlp: Double, prnt: Double
        ) = nc * (lfa / dlp) * (100 / prnt)
    }
}