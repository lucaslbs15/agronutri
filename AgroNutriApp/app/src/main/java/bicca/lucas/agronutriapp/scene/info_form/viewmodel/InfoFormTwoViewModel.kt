package bicca.lucas.agronutriapp.scene.info_form.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.util.Log
import bicca.lucas.agronutriapp.R
import bicca.lucas.agronutriapp.logic.`object`.InfoForm
import bicca.lucas.agronutriapp.utils.orZero
import bicca.lucas.agronutriapp.utils.toFormattedDouble

class InfoFormTwoViewModel(application: Application) : AndroidViewModel(application) {

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

    // region --- POPULATE VALUES ---
    fun getValues(): InfoForm {
        return InfoForm().apply {
            phWater = this@InfoFormTwoViewModel.phWater.get()?.toFormattedDouble()
            ca = this@InfoFormTwoViewModel.ca.get()?.toFormattedDouble()
            mg = this@InfoFormTwoViewModel.mg.get()?.toFormattedDouble()
            alCmol = this@InfoFormTwoViewModel.al.get()?.toFormattedDouble()
            hAl = this@InfoFormTwoViewModel.hAl.get()?.toFormattedDouble()
            ctcEfetiva = this@InfoFormTwoViewModel.ctcEfetiva.get()?.toFormattedDouble()
        }
    }

    fun setValues(values: InfoForm) {
        phWater.set(values.phWater.orZero().toString())
        ca.set(values.ca.orZero().toString())
        mg.set(values.mg.orZero().toString())
        al.set(values.alCmol.orZero().toString())
        hAl.set(values.hAl.orZero().toString())
        ctcEfetiva.set(values.ctcEfetiva.orZero().toString())
    }
    // endregion

    // region --- VALIDATIONS ---
    fun shouldShowErros(): Boolean {
        val shouldShowPhWaterError = shouldShowPhWaterError()
        val shouldShowCaError = shouldShowCaError()
        val shouldShowMgError = shouldShowMgError()
        val shouldShowAlError = shouldShowAlError()
        val shouldShowHAlError = shouldShowHAlError()
        val shouldShowCtcError = shouldShowCtcError()
        return shouldShowPhWaterError || shouldShowCaError || shouldShowMgError ||
                shouldShowAlError || shouldShowHAlError || shouldShowCtcError
    }

    private fun shouldShowPhWaterError(): Boolean {
        phWaterShowErrorMessage.set(phWater.get().isNullOrEmpty() || phWater.get().isNullOrBlank())
        if (phWaterShowErrorMessage.get())
            phWaterErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            phWaterErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return phWaterShowErrorMessage.get()
    }

    private fun shouldShowCaError(): Boolean {
        caShowErrorMessage.set(ca.get().isNullOrEmpty() || ca.get().isNullOrBlank())
        if (caShowErrorMessage.get())
            caErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            caErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return caShowErrorMessage.get()
    }

    private fun shouldShowMgError(): Boolean {
        mgShowErrorMessage.set(mg.get().isNullOrEmpty() || mg.get().isNullOrBlank())
        if (mgShowErrorMessage.get())
            mgErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            mgErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return mgShowErrorMessage.get()
    }

    private fun shouldShowAlError(): Boolean {
        alShowErrorMessage.set(al.get().isNullOrEmpty() || al.get().isNullOrBlank())
        if (alShowErrorMessage.get())
            alErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            alErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return alShowErrorMessage.get()
    }

    private fun shouldShowHAlError(): Boolean {
        hAlShowErrorMessage.set(hAl.get().isNullOrEmpty() || hAl.get().isNullOrBlank())
        if (hAlShowErrorMessage.get())
            hAlErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            hAlErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return hAlShowErrorMessage.get()
    }

    private fun shouldShowCtcError(): Boolean {
        ctcEfetivaShowErrorMessage.set(ctcEfetiva.get().isNullOrEmpty() || ctcEfetiva.get().isNullOrBlank())
        if (ctcEfetivaShowErrorMessage.get())
            ctcEfetivaErrorMessage.set(getApplication<Application>().getString(R.string.form_two_fragment_default_error_message))
        else
            ctcEfetivaErrorMessage.set(getApplication<Application>().getString(R.string.empty_text))
        return ctcEfetivaShowErrorMessage.get()
    }
    // endregion
}
