package bicca.lucas.agronutriapp.scene.result

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.logic.CalQuantity
import bicca.lucas.agronutriapp.logic.Calculation
import bicca.lucas.agronutriapp.logic.InputType
import bicca.lucas.agronutriapp.logic.`object`.InfoForm
import bicca.lucas.agronutriapp.utils.orZero

class ViewResultViewModel(application: Application, val infoForm: InfoForm) : AndroidViewModel(application) {

    val inputTypeLabel = ObservableInt(infoForm.inputType?.nameId!!)
    val showLimingResult = ObservableBoolean(false)
    val showFertilizingResult = ObservableBoolean(false)
    val limingResult = ObservableField("")
    val limingByAreaResult = ObservableField("")
    val plantLabel = ObservableField(getApplication<Application>()
            .getString(R.string.view_result_plant,
                    getApplication<Application>().getString(infoForm.plant?.stringId!!)))

    init {
        infoForm.inputType?.let {
            when (it) {
                InputType.LIMING -> {
                    showLimingResult.set(true)
                    calculateByLiming()
                }
                InputType.FERTILIZING -> {
                    showFertilizingResult.set(true)
                    calculateByFertilizing()
                }
                else -> {
                    showLimingResult.set(false)
                    showFertilizingResult.set(false)
                }
            }
        }
    }

    private fun calculateByLiming() {
        infoForm.plant?.phEnum?.let {
            val result = Calculation.ncByPh(it, infoForm.mo.orZero(), infoForm.alCmol.orZero())
            limingResult.set(
                    getApplication<Application>()
                            .resources.getQuantityString(
                            R.plurals.view_result_quantity_liming, result.toInt(), result)
            )

            val totalLiming = CalQuantity().bySMPAccordingPh(infoForm.indexSMP.orZero(), it)

            val resultByArea = Calculation.adjustCalByAreaApplication(
                    result, infoForm.area.orZero(), infoForm.distance.orZero(), totalLiming
            )
            limingByAreaResult.set(getApplication<Application>()
                    .resources.getQuantityString(
                    R.plurals.view_result_quantity_liming, resultByArea.toInt(), resultByArea)
            )
        }
    }

    private fun calculateByFertilizing() {

    }
}