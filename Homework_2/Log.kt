class Log : Card(
    name = "Log",
    type = Type.SPELL,
    rarity = Rarity.LEGENDARY,
    elixirCost = 2,
    damage = 244
), ICastable
{
    override fun cast() {
        println("$name is causing damage in an area!")
    }

    override fun levelUp() {
        damage += 24
        println("$name leveled up! Damage +24")
    }
}