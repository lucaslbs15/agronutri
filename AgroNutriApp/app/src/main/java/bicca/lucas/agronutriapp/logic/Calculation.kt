package bicca.lucas.agronutriapp.logic

class Calculation {

    companion object {

        /**
         * Ajuste correspondente da dose em função da área de aplicação.
         *
         * DC (t/ha) = NC x (LFA/DLP) X (100/PRNT)
         * Em que: DC = dose de calcário (t/ha);
         * NC = necessidade de calcário para a cultura (t/ha)
         * LFA = largura da faixa de aplicação do calcário (m)
         * DLP = distância entre as linhas de plantio (m)
         * PRNT = poder relativo de neutralização total do calcário (%)
         *
         * @param[nc]
         * @param[lfa]
         * @param[dlp]
         * @param[prnt]
         * @return DC = dose de calcário (t/ha)
         */
        fun adjustCalByAreaApplication(
                nc: Double, lfa: Double, dlp: Double, prnt: Double
        ) = nc * (lfa / dlp) * (100 / prnt)

    }
}