package bicca.lucas.agronutriapp.scene.info_form.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.logic.InputType
import bicca.lucas.agronutriapp.logic.PlantEnum

class InfoFormOneViewModel(application: Application) : AndroidViewModel(application) {

    // region --- ATTRIBUTES ---
    val showInputTypeOptions = MutableLiveData<Boolean>()
    val showPlantOptions = MutableLiveData<Boolean>()
    private var inputTypeSelected: InputType = InputType.NONE
    private val plants: Array<PlantEnum> by lazy {
        PlantEnum.values()
    }

    val plant = ObservableField<String>("")
    val plantId = ObservableInt(R.string.empty_text)
    private var plantSelected: PlantEnum = PlantEnum.NONE
    val plantErrorMessage = ObservableField<String>(" ")
    val plantShowErrorMessage = ObservableBoolean(false)
    val plantHelperTextEnabled = ObservableBoolean(false)
    val plantHelperTextId = ObservableInt(R.string.form_one_fragment_plant_edit_text_helper)

    val inputTypeId = ObservableInt(R.string.empty_text)
    val inputTypeErrorMessage = ObservableField<String>("")
    val inputTypeShowErrorMessage = ObservableBoolean(false)
    val inputTypeShowHelperText = ObservableBoolean(false)
    val inputTypeHelperTextId = ObservableInt(R.string.form_one_fragment_input_type_edit_text_helper)
    // endregion

    // region --- VALIDATION ---
    fun shouldShowErrors() : Boolean {
        val shouldShowPlantError = shouldShowPlantError()
        val shouldShowInputTypeError = shouldShowInputTypeError()
        return shouldShowPlantError || shouldShowInputTypeError
    }

    private fun shouldShowPlantError() : Boolean {
        plantShowErrorMessage.set(plantSelected == PlantEnum.NONE)
        if (plantShowErrorMessage.get())
            plantErrorMessage.set(getApplication<Application>().getString(R.string.form_one_fragment_plant_edit_text_error))
        else
            plantErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return plantShowErrorMessage.get()
    }

    private fun shouldShowInputTypeError() : Boolean {
        inputTypeShowErrorMessage.set(inputTypeSelected == InputType.NONE)
        if (inputTypeShowErrorMessage.get())
            inputTypeErrorMessage.set(getApplication<Application>().getString(R.string.form_one_fragment_input_type_text_error))
        else
            inputTypeErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return inputTypeShowErrorMessage.get()
    }
    // endregion

    // region --- LISTENER ---
    fun onInputTypeChanged(isChecked: Boolean, inputType: InputType) {
        if (isChecked) {
            inputTypeSelected = inputType
            inputTypeId.set(inputTypeSelected.nameId)
            showInputTypeOptions.value = false
        }
    }
    //region

    fun getPlants() : ArrayList<PlantEnum> {
        val plants = ArrayList<PlantEnum>()
        this.plants.forEach {
            plants.add(it)
        }
        return plants
    }

    fun updatePlantSelected(plantEnum: PlantEnum) {
        plantSelected = plantEnum
        plantId.set(plantSelected.stringId)
        showPlantOptions.value = false
    }
}
