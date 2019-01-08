package bicca.lucas.agronutriapp.scene.info_form.viewmodel

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean
import android.databinding.ObservableField

class InfoFormFourViewModel : ViewModel() {

    // region --- ATTRIBUTES ---
    //% MO (2); % Argila (2); K (1); Textura; S (3); K (3); P-Mehlich (3); CTC pH7 (1);
    val mo = ObservableField<String>("")
    val clay = ObservableField<String>("")
    val kMol = ObservableField<String>("")
    val texture = ObservableField<String>("")
    val s = ObservableField<String>("")
    val kMg = ObservableField<String>("")
    val pMehlich = ObservableField<String>("")
    val ctc = ObservableField<String>("")
    // endregion

    // region --- ERRORS ---
    val moErrorMessage = ObservableField<String>("")
    val clayErrorMessage = ObservableField<String>("")
    val kMolErrorMessage = ObservableField<String>("")
    val textureErrorMessage = ObservableField<String>("")
    val sErrorMessage = ObservableField<String>("")
    val kMgErrorMessage = ObservableField<String>("")
    val pMehlichErrorMessage = ObservableField<String>("")
    val ctcErrorMessage = ObservableField<String>("")
    // endregion

    // region --- SHOW ERRORS ---
    val moShowErrorMessage = ObservableBoolean(false)
    val clayShowErrorMessage = ObservableBoolean(false)
    val kMolShowErrorMessage = ObservableBoolean(false)
    val textureShowErrorMessage = ObservableBoolean(false)
    val sShowErrorMessage = ObservableBoolean(false)
    val kMgShowErrorMessage = ObservableBoolean(false)
    val pMehlichShowErrorMessage = ObservableBoolean(false)
    val ctcShowErrorMessage = ObservableBoolean(false)
    // endregion
}
