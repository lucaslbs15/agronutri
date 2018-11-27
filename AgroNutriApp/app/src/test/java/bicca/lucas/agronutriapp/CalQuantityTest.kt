package bicca.lucas.agronutriapp

import bicca.lucas.agronutriapp.logic.CalQuantity
import bicca.lucas.agronutriapp.logic.PhEnum
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class CalQuantityTest {

    lateinit var calQuantity: CalQuantity

    @Before
    fun setup() {
        calQuantity = CalQuantity()
    }

    @Test
    fun smp47And60PhWanted_isCorrect() {
        val tHa = calQuantity.bySMPAccordingPh(6.6, PhEnum.pH55)
        assertEquals(0.2, tHa, 0.01)
    }
}