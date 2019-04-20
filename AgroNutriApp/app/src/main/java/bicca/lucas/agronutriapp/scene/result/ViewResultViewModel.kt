package bicca.lucas.agronutriapp.scene.result

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean

class ViewResultViewModel : ViewModel() {

    val showLimingResult = ObservableBoolean(false)
    val showFertilizingResult = ObservableBoolean(false)

}