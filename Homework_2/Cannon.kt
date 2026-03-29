class Cannon : Card(
    name = "Cannon",
    type = Type.BUILDING,
    rarity = Rarity.COMMON,
    elixirCost = 3,
    damage = 256
), IDamageable
{
    override var hitpoints: Int = 994

    override fun attack() {
        println("$name is attacking! it deals $damage damage!")
    }

    override fun getDamaged(damage: Int) {
        println("$name got damaged by $damage points!")
    }

    override fun levelUp() {
        damage += 25
        hitpoints += 97
        println("$name leveled up! Damage +25, Hitpoints +97")
    }
}