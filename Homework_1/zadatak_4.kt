
fun main() {
    var name = "John_Doe123 "
    var pName = prepareName(name)

    if(isValidName(pName))
    println("$name je valjano ime.")
    else
    println("$name nije valjano ime.")
}

fun prepareName(name: String): String {
    return name.trim().lowercase()
}

fun isValidName(name: String): Boolean {
    if(name.length < 5 || name.length > 15
       || !name.first().isLetter()
       || !name.all{ it.isLetterOrDigit() || it == '_' }
       || name.contains(" ")
    )
        return false
    return true
}