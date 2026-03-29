enum class Rarity{
    COMMON, RARE, EPIC, LEGENDARY
}

enum class Type{
    TROOP, BUILDING, SPELL
}

abstract class Card(
    val name: String,
    val type: Type,
    val rarity: Rarity,
    val elixirCost: Int,
    var damage: Int
) {
    fun displayInfo() {
        println("Name: $name")
        println("Type: $type")
        println("Rarity: $rarity")
        println("Elixir Cost: $elixirCost")
    }

    abstract fun levelUp()
}