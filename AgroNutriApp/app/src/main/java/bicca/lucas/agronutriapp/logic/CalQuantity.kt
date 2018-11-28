package bicca.lucas.agronutriapp.logic

class CalQuantity {

    private val map = HashMap<Double, Array<Double>>(28)

    init {
        putMapValues()
    }

    private fun putMapValues() {
        map.put(4.4, arrayOf(15.0, 21.0, 29.0))
        map.put(4.5, arrayOf(12.5, 17.3, 24.0))
        map.put(4.6, arrayOf(10.9, 15.1, 20.0))
        map.put(4.7, arrayOf(9.6, 13.3, 17.5))
        map.put(4.8, arrayOf(8.5, 11.9, 15.7))
        map.put(4.9, arrayOf(7.7, 10.7, 14.2))
        map.put(5.0, arrayOf(6.6, 9.9, 13.3))
        map.put(5.1, arrayOf(6.0, 9.1, 12.3))
        map.put(5.2, arrayOf(5.3, 8.3, 11.3))
        map.put(5.3, arrayOf(4.8, 7.5, 10.4))
        map.put(5.4, arrayOf(4.2, 6.8, 9.5))
        map.put(5.5, arrayOf(3.7, 6.1, 8.6))
        map.put(5.6, arrayOf(3.2, 5.4, 7.8))
        map.put(5.7, arrayOf(2.8, 4.8, 7.0))
        map.put(5.8, arrayOf(2.3, 4.2, 6.3))
        map.put(5.9, arrayOf(2.0, 3.7, 5.6))
        map.put(6.0, arrayOf(1.6, 3.2, 4.9))
        map.put(6.1, arrayOf(1.3, 2.7, 4.3))
        map.put(6.2, arrayOf(1.0, 2.2, 3.7))
        map.put(6.3, arrayOf(0.8, 1.8, 3.1))
        map.put(6.4, arrayOf(0.6, 1.4, 2.6))
        map.put(6.5, arrayOf(0.4, 1.1, 2.1))
        map.put(6.6, arrayOf(0.2, 0.8, 1.6))
        map.put(6.7, arrayOf(0.0, 0.5, 1.2))
        map.put(6.8, arrayOf(0.0, 0.3, 0.8))
        map.put(6.9, arrayOf(0.0, 0.2, 0.5))
        map.put(7.0, arrayOf(0.0, 0.0, 0.2))
        map.put(7.1, arrayOf(0.0, 0.0, 0.0))

    }

    /**
     * Quantidades de calcário (PRNT 100%) necessárias para elevar o pH em água do solo da camada
     * de 0 a 20 cm, a 5,5, 6,0, 6,5 estimadas pelo índice SMP.
     * Valores retirados da tabela 5.2 (página 70)
     *
     * @param[indexSMP]
     * @param[ph]
     */
    fun bySMPAccordingPh(indexSMP: Double, ph: PhEnum) : Double {
        val tByHas = map.get(indexSMP)
        tByHas?.let {
            return when (ph) {
                PhEnum.pH55 -> tByHas[0]
                PhEnum.pH60 -> tByHas[1]
                PhEnum.pH65 -> tByHas[2]
                PhEnum.noReference -> 0.0
            }
        } ?: return 0.0
    }
}