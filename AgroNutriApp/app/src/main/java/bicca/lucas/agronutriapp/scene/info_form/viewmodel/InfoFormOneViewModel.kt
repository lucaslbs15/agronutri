package bicca.lucas.agronutriapp.scene.info_form.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.logic.InputType
import bicca.lucas.agronutriapp.logic.PlantEnum

class InfoFormOneViewModel : ViewModel() {

    var inputTypeSelected: InputType = InputType.NONE

    // region --- ATTRIBUTES ---
    val plants: Array<PlantEnum> by lazy {
        PlantEnum.values()
    }

    val plant = ObservableField<String>("")
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
    private fun shouldShowPlantError() {
        plant.get().isNullOrBlank().let {
            plantShowErrorMessage.set(it)
            if (plantShowErrorMessage.get())
                plantErrorMessageId.set(R.string.form_one_fragment_plant_edit_text_error)
            else
                plantErrorMessageId.set(R.string.empty_text)
        }
    }

    private fun shouldShowInputTypeError() {
        inputTypeShowErrorMessage.set(inputTypeSelected == InputType.NONE)
        if (inputTypeShowErrorMessage.get())
            inputTypeErrorMessageId.set(R.string.form_one_fragment_input_type_text_error)
        else
            inputTypeErrorMessageId.set(R.string.empty_text)
    }
    // endregion

    // region --- LISTENER ---
    fun onInputTypeChanged(isChecked: Boolean, inputType: InputType) {
        if (isChecked) {
            inputTypeSelected = inputType
            inputTypeId.set(inputTypeSelected.nameId)
        }
    }
    //region
}
