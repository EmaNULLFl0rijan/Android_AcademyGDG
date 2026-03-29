class HogRider : Card(
    name = "Hog Rider",
    type = Type.TROOP,
    rarity = Rarity.RARE,
    elixirCost = 4,
    damage = 340
), IDamageable
{
    override var hitpoints: Int = 1800

    override fun attack() {
        println("$name is attacking! it deals $damage damage!")
    }

    override fun getDamaged(damage: Int) {
        println("$name got damaged by $damage points!")
    }

    override fun levelUp() {
        damage += 30
        hitpoints += 100
        println("$name leveled up! Damage +30, Hitpoints +100")
    }
}