package bicca.lucas.agronutriapp.scene.info_form.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import bicca.lucas.agronutriapp.logic.InputType
import bicca.lucas.agronutriapp.logic.PlantEnum
import bicca.lucas.agronutriapp.logic.`object`.InfoForm

class InfoFormViewModel : ViewModel() {

    val currentStep = MutableLiveData<Int>()
    var totalSteps = 0
    val lastStep = MutableLiveData<Boolean>()
    var shouldShowErrors = false
    val shouldValidateToGoToNextScreen = MutableLiveData<Boolean>()
    val infoForm = InfoForm()

    init {
        currentStep.value = 0
    }

    // region --- SETUP ---
    fun populateInfosScreenOne(plant: PlantEnum, inputType: InputType) {
        infoForm.plant = plant
        infoForm.inputType = inputType
    }

    fun populateInfosScreenTwo(phWater: Double, ca: Double, mg: Double, alCmol: Double, hAl: Double, ctcEfetiva: Double) {
        infoForm.phWater = phWater
        infoForm.ca = ca
        infoForm.mg = mg
        infoForm.alCmol = alCmol
        infoForm.hAl = hAl
        infoForm.ctcEfetiva = ctcEfetiva
    }

    fun populateInfosScreenThree(alPercent: Double, bases: Double, indexSMP: Double) {
        infoForm.alPercent = alPercent
        infoForm.bases = bases
        infoForm.indexSMP = indexSMP
    }

    fun populateInfosScreenFour(mo: Double, clay: Double, kCmol: Double, texture: Double, s: Double,
                                kMg: Double, pMehlich: Double, ctc: Double) {
        infoForm.mo = mo
        infoForm.clay = clay
        infoForm.kCmol = kCmol
        infoForm.texture = texture
        infoForm.s = s
        infoForm.kMg = kMg
        infoForm.pMehlich = pMehlich
        infoForm.ctc = ctc
    }
    // endregion

    // region --- LISTENERS ---
    fun onNextClick() {
        shouldValidateToGoToNextScreen.value = true
    }

    fun goToNextScreen() {
        if (!shouldShowErrors) {
            currentStep.value?.let {
                if (it < (totalSteps - 1))
                    currentStep.value = it.plus(1)
                else
                    lastStep.value = true
            }
        }
    }

    fun onPreviousClick() {
        currentStep.value?.let {
            currentStep.value = it.minus(1)
            lastStep.value = false
        }
    }
    // endregion
}