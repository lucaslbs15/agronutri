package bicca.lucas.agronutriapp.logic.`object`

import bicca.lucas.agronutriapp.logic.InputType
import bicca.lucas.agronutriapp.logic.PlantEnum

class InfoForm {

    // region --- SCREEN ONE ---
    var plant: PlantEnum? = null
    var inputType: InputType? = null
    // endregion

    // region --- SCREEN TWO ---
    var phWater: Double? = null
    var ca: Double? = null
    var mg: Double? = null
    var alCmol: Double? = null
    var hAl: Double? = null
    var ctcEfetiva: Double? = null
    // endregion

    // region --- THREE ---
    var alPercent: Double? = null
    var bases: Double? = null
    var indexSMP: Double? = null
    // endregion

    // region --- FOUR ---
    var mo: Double? = null
    var clay: Double? = null
    var kCmol: Double? = null
    var texture: Double? = null
    var s: Double? = null
    var kMg: Double? = null
    var pMehlich: Double? = null
    var ctc: Double? = null
    // endregion
}