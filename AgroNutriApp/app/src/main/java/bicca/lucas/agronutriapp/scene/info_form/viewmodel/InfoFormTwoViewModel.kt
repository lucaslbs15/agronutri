package bicca.lucas.agronutriapp.scene.info_form.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField

class InfoFormTwoViewModel : ViewModel() {
    //pH Água; Ca (1); Mg (1); Al; H + Al; CTC efetiva

    // region --- ATRIBUTTES ---
    val phWater = ObservableField<String>("")
    val ca = ObservableField<String>("")
    val mg = ObservableField<String>("")
    val al = ObservableField<String>("")
    val hAl = ObservableField<String>("")
    val ctcEfetiva = ObservableField<String>("")
    // endregion

    // region --- ERROS ---
    val phWaterErrorMessage = ObservableField<String>("")
    val caErrorMessage = ObservableField<String>("")
    val mgErrorMessage = ObservableField<String>("")
    val alErrorMessage = ObservableField<String>("")
    val hAlErrorMessage = ObservableField<String>("")
    val ctcEfetivaErrorMessage = ObservableField<String>("")
    // endregion

    // region --- SHOW ERRORS ---
    val phWaterShowErrorMessage = ObservableBoolean(false)
    val caShowErrorMessage = ObservableBoolean(false)
    val mgShowErrorMessage = ObservableBoolean(false)
    val alShowErrorMessage = ObservableBoolean(false)
    val hAlShowErrorMessage = ObservableBoolean(false)
    val ctcEfetivaShowErrorMessage = ObservableBoolean(false)
    // endregion
}
