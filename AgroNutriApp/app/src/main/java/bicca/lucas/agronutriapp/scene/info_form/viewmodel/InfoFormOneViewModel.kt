package bicca.lucas.agronutriapp.scene.info_form.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.logic.InputType
import bicca.lucas.agronutriapp.logic.PlantEnum

class InfoFormOneViewModel : ViewModel() {

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
    val plantErrorMessageId = ObservableInt(R.string.form_one_fragment_plant_edit_text_error)
    val plantShowErrorMessage = ObservableBoolean(false)
    val plantHelperTextEnabled = ObservableBoolean(false)
    val plantHelperTextId = ObservableInt(R.string.form_one_fragment_plant_edit_text_helper)

    val inputTypeId = ObservableInt(R.string.empty_text)
    val inputTypeErrorMessageId = ObservableInt(R.string.form_one_fragment_input_type_text_error)
    val inputTypeShowErrorMessage = ObservableBoolean(false)
    val inputTypeShowHelperText = ObservableBoolean(false)
    val inputTypeHelperTextId = ObservableInt(R.string.form_one_fragment_input_type_edit_text_helper)
    // endregion

    // region --- VALIDATION ---
    fun shouldShowErrors() : Boolean {
        return shouldShowPlantError() || shouldShowInputTypeError()
    }

    private fun shouldShowPlantError() : Boolean {
        plant.get().isNullOrBlank().let {
            plantShowErrorMessage.set(it)
            if (plantShowErrorMessage.get())
                plantErrorMessageId.set(R.string.form_one_fragment_plant_edit_text_error)
            else
                plantErrorMessageId.set(R.string.empty_text)
        }
        return plantShowErrorMessage.get()
    }

    private fun shouldShowInputTypeError() : Boolean {
        inputTypeShowErrorMessage.set(inputTypeSelected == InputType.NONE)
        if (inputTypeShowErrorMessage.get())
            inputTypeErrorMessageId.set(R.string.form_one_fragment_input_type_text_error)
        else
            inputTypeErrorMessageId.set(R.string.empty_text)
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
    }
}
