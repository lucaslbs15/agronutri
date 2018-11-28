package bicca.lucas.agronutriapp

import bicca.lucas.agronutriapp.logic.Calculation
import bicca.lucas.agronutriapp.logic.PlantEnum
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculationTest {

    @Test
    fun nc_isCorrect() {
        val nc = Calculation.nc(3.8, 2.7, 2.9)
        assertEquals(0.0319, nc, 0.2)
    }

    @Test
    fun pH55_isCorrect() {
        val plant = PlantEnum.ERVA_DOCE
        val ncPh55 = Calculation.ncByPh(plant.phEnum, 1.5, 1.5)
        assertEquals(2.9, ncPh55, 0.2)
    }

    @Test
    fun pH60_isCorrect() {
        val plant = PlantEnum.ABACATEIRO
        val ncPh60 = Calculation.ncByPh(plant.phEnum, 1.5, 1.5)
        assertEquals(4.3, ncPh60, 0.2)
    }

    @Test
    fun pH65_isCorrect() {
        val plant = PlantEnum.OLIVEIRA
        val ncPh65 = Calculation.ncByPh(plant.phEnum, 1.5, 1.5)
        assertEquals(5.7, ncPh65, 0.2)
    }

    @Test
    fun adjustCal_isCorrect() {
        val adjustCal = Calculation.adjustCalByAreaApplication(4.0, 4.0, 2.0, 10.0)
        assertEquals(80.0, adjustCal, 0.2)
    }

}