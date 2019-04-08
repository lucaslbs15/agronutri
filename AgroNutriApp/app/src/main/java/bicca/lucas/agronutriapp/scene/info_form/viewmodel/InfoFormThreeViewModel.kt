package bicca.lucas.agronutriapp.scene.info_form.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.logic.`object`.InfoForm
import bicca.lucas.agronutriapp.utils.orZero
import bicca.lucas.agronutriapp.utils.toFormattedDouble

class InfoFormThreeViewModel(application: Application) : AndroidViewModel(application) {

    //Al; Bases; Índice SMP
    // region --- ATTRIBUTES ---
    val al = ObservableField<String>("")
    val bases = ObservableField<String>("")
    val indexSMP = ObservableField<String>("")
    // endregion

    // region --- ERRORS ---
    val alErrorMessage = ObservableField<String>("")
    val basesErrorMessage = ObservableField<String>("")
    val indexSMPErrorMessage = ObservableField<String>("")
    // endregion

    // region --- SHOW ERRORS ---
    val alShowErrorMessage = ObservableBoolean(false)
    val basesShowErrorMessage = ObservableBoolean(false)
    val indexSMPShowErrorMessage = ObservableBoolean(false)
    // endregion

    // region --- POPULATE VALUES ---
    fun getValues(): InfoForm {
        return InfoForm().apply {
            alPercent = al.get()?.toFormattedDouble()
            bases = this@InfoFormThreeViewModel.bases.get()?.toFormattedDouble()
            indexSMP = this@InfoFormThreeViewModel.indexSMP.get()?.toFormattedDouble()
        }
    }

    fun setValues(values: InfoForm) {
        al.set(values.alPercent.orZero().toString())
        bases.set(values.bases.orZero().toString())
        indexSMP.set(values.indexSMP.orZero().toString())
    }
    // endregion

    // region --- VALIDATIONS ---
    fun shouldShowErrors(): Boolean {
        val shouldShowAlError = shouldShowAlError()
        val shouldShowBasesError = shouldShowBasesError()
        val shouldShowIndexSMPError = shouldShowIndexSMPError()
        return shouldShowAlError || shouldShowBasesError || shouldShowIndexSMPError
    }

    private fun shouldShowAlError(): Boolean {
        alShowErrorMessage.set(al.get().isNullOrBlank() || al.get().isNullOrEmpty())
        if (alShowErrorMessage.get())
            alErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            alErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return alShowErrorMessage.get()
    }

    private fun shouldShowBasesError(): Boolean {
        basesShowErrorMessage.set(bases.get().isNullOrEmpty() || bases.get().isNullOrBlank())
        if (basesShowErrorMessage.get())
            basesErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            basesErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return basesShowErrorMessage.get()
    }

    private fun shouldShowIndexSMPError(): Boolean {
        indexSMPShowErrorMessage.set(indexSMP.get().isNullOrEmpty() || indexSMP.get().isNullOrBlank())
        if (indexSMPShowErrorMessage.get())
            indexSMPErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            indexSMPErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return indexSMPShowErrorMessage.get()
    }
    // endregion
}
