package bicca.lucas.agronutriapp.logic.`object`

import android.os.Parcel
import android.os.Parcelable
import bicca.lucas.agronutriapp.logic.InputType
import bicca.lucas.agronutriapp.logic.PlantEnum
import bicca.lucas.agronutriapp.utils.orZero

class InfoForm() : Parcelable {

    // region --- SCREEN ONE ---
    var plant: PlantEnum? = null
    var inputType: InputType? = null
    var area: Double? = null
    var distance: Double? = null
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

    constructor(parcel: Parcel) : this() {
        parcel.run {
            // region --- READ PARCEL SCREEN ONE ---
            plant = PlantEnum.valueOf(readString())
            inputType = InputType.valueOf(readString())
            area = readDouble()
            distance = readDouble()
            // endregion

            // region --- READ PARCEL SCREEN TWO ---
            phWater = readDouble()
            ca = readDouble()
            mg = readDouble()
            alCmol = readDouble()
            hAl = readDouble()
            ctcEfetiva = readDouble()
            // endregion

            // region --- READ PARCEL SCREEN THREE ---
            alPercent = readDouble()
            bases = readDouble()
            indexSMP = readDouble()
            // endregion

            // region --- READ PARCEL SCREEN FOUR ---
            mo = readDouble()
            clay = readDouble()
            kCmol = readDouble()
            texture = readDouble()
            s = readDouble()
            kMg = readDouble()
            pMehlich = readDouble()
            ctc = readDouble()
            // endregion
        }
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.apply {
            // region --- WRITE PARCEL SCREEN ONE ---
            writeString(plant?.name)
            writeString(inputType?.name)
            writeDouble(area.orZero())
            writeDouble(distance.orZero())
            // endregion

            // region --- WRITE PARCEL SCREEN TWO ---
            writeDouble(phWater.orZero())
            writeDouble(ca.orZero())
            writeDouble(mg.orZero())
            writeDouble(alCmol.orZero())
            writeDouble(hAl.orZero())
            writeDouble(ctcEfetiva.orZero())
            // endregion

            // region --- WRITE PARCEL SCREEN THREE ---
            writeDouble(alPercent.orZero())
            writeDouble(bases.orZero())
            writeDouble(indexSMP.orZero())
            // endregion

            // region --- WRITE PARCEL SCREEN FOUR ---
            writeDouble(mo.orZero())
            writeDouble(clay.orZero())
            writeDouble(kCmol.orZero())
            writeDouble(texture.orZero())
            writeDouble(s.orZero())
            writeDouble(kMg.orZero())
            writeDouble(pMehlich.orZero())
            writeDouble(ctc.orZero())
            // endregion
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InfoForm> {

        override fun createFromParcel(source: Parcel): InfoForm {
            return InfoForm(source)
        }

        override fun newArray(size: Int): Array<InfoForm?> {
            return arrayOfNulls(size)
        }

    }
}