package bicca.lucas.agronutriapp.scene.info_form.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.logic.`object`.InfoForm
import bicca.lucas.agronutriapp.utils.orZero
import bicca.lucas.agronutriapp.utils.toFormattedDouble

class InfoFormFourViewModel(application: Application) : AndroidViewModel(application) {

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

    // region --- POPULATE VALUES ---
    fun getValues(): InfoForm {
        return InfoForm().apply {
            mo = this@InfoFormFourViewModel.mo.get()?.toFormattedDouble()
            clay = this@InfoFormFourViewModel.clay.get()?.toFormattedDouble()
            kCmol = this@InfoFormFourViewModel.kMol.get()?.toFormattedDouble()
            texture = this@InfoFormFourViewModel.texture.get()?.toFormattedDouble()
            s = this@InfoFormFourViewModel.s.get()?.toFormattedDouble()
            kMg = this@InfoFormFourViewModel.kMg.get()?.toFormattedDouble()
            pMehlich = this@InfoFormFourViewModel.pMehlich.get()?.toFormattedDouble()
            ctc = this@InfoFormFourViewModel.ctc.get()?.toFormattedDouble()
        }
    }

    fun setValues(values: InfoForm) {
        mo.set(values.mo.orZero().toString())
        clay.set(values.clay.orZero().toString())
        kMol.set(values.kCmol.orZero().toString())
        texture.set(values.texture.orZero().toString())
        s.set(values.s.orZero().toString())
        kMg.set(values.kMg.orZero().toString())
        pMehlich.set(values.pMehlich.orZero().toString())
        ctc.set(values.ctc.orZero().toString())
    }
    // endregion

    // region --- VALIDATIONS ---
    fun shouldShowErrors(): Boolean {
        val shouldShowMoError = shouldShowMoError()
        val shouldShowClayError = shouldShowClayError()
        val shouldShowKMolError = shouldShowKMolError()
        val shouldShowTextureError = shouldShowTextureError()
        val shouldShowSError = shouldShowSError()
        val shouldShowKMgError = shouldShowKMgError()
        val shouldShowPMehlichError = shouldShowPMehlichError()
        val shouldShowCtcError = shouldShowCtcError()
        return shouldShowMoError || shouldShowClayError || shouldShowKMolError
                || shouldShowTextureError || shouldShowSError || shouldShowKMgError ||
                shouldShowPMehlichError || shouldShowCtcError
    }

    private fun shouldShowMoError(): Boolean {
        moShowErrorMessage.set(mo.get().isNullOrEmpty() || mo.get().isNullOrBlank())
        if (moShowErrorMessage.get())
            moErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            moErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return moShowErrorMessage.get()
    }

    private fun shouldShowClayError(): Boolean {
        clayShowErrorMessage.set(clay.get().isNullOrEmpty() || clay.get().isNullOrBlank())
        if (clayShowErrorMessage.get())
            clayErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            clayErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return clayShowErrorMessage.get()
    }

    private fun shouldShowKMolError(): Boolean {
        kMolShowErrorMessage.set(kMol.get().isNullOrEmpty() || kMol.get().isNullOrBlank())
        if (kMolShowErrorMessage.get())
            kMolErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            kMolErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return kMolShowErrorMessage.get()
    }

    private fun shouldShowTextureError(): Boolean {
        textureShowErrorMessage.set(texture.get().isNullOrEmpty() || texture.get().isNullOrBlank())
        if (textureShowErrorMessage.get())
            textureErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            textureErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return textureShowErrorMessage.get()
    }

    private fun shouldShowSError(): Boolean {
        sShowErrorMessage.set(s.get().isNullOrEmpty() || s.get().isNullOrBlank())
        if (sShowErrorMessage.get())
            sErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            sErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return sShowErrorMessage.get()
    }

    private fun shouldShowKMgError(): Boolean {
        kMgShowErrorMessage.set(kMg.get().isNullOrEmpty() || kMg.get().isNullOrBlank())
        if (kMgShowErrorMessage.get())
            kMgErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            kMgErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return kMgShowErrorMessage.get()
    }

    private fun shouldShowPMehlichError(): Boolean {
        pMehlichShowErrorMessage.set(pMehlich.get().isNullOrEmpty() || pMehlich.get().isNullOrBlank())
        if (pMehlichShowErrorMessage.get())
            pMehlichErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            pMehlichErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return pMehlichShowErrorMessage.get()
    }

    private fun shouldShowCtcError(): Boolean {
        ctcShowErrorMessage.set(ctc.get().isNullOrEmpty() || ctc.get().isNullOrBlank())
        if (ctcShowErrorMessage.get())
            ctcErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            ctcErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return ctcShowErrorMessage.get()
    }
    // endregion
}
