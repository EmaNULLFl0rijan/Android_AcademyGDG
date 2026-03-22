val productCode: Int = 3
val productPrice: Double = 299.99
val money: Double = 500.0
val productName: String = when (productCode) {
    1 -> "Voda"
    2 -> "Cola"
    3 -> "Kava"
    else -> "Nepoznat proizvod"
}

fun main() {
    println("Proizvod: $productName, Cijena: $productPrice, Novac: $money")
    if (money >= productPrice) {
        println("Možete kupiti $productName.")
    } else {
        println("Fali vam ${productPrice - money} eura za kupnju $productName.")
    }
}