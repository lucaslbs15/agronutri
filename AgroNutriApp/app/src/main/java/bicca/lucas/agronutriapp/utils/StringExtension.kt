package bicca.lucas.agronutriapp.utils

fun String.toFormattedDouble(): Double? {
    val valueConverted = this.replace(",", ".")
    return valueConverted.toDoubleOrNull()
}
