package bicca.lucas.agronutriapp.utils

fun Double?.orZero() = this ?: 0.0
fun Double?.withComma() = this.orZero().toString().replace(".", ",")