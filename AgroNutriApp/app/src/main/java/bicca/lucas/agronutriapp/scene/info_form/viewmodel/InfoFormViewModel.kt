package bicca.lucas.agronutriapp.scene.info_form.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class InfoFormViewModel : ViewModel() {

    val currentStep = MutableLiveData<Int>()
    var totalSteps = 0
    val lastStep = MutableLiveData<Boolean>()
    var shouldShowErrors = false
    val shouldValidateToGoToNextScreen = MutableLiveData<Boolean>()

    init {
        currentStep.value = 0
    }

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