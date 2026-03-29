class BabyDragon : Card(
    name = "Baby Dragon",
    type = Type.TROOP,
    rarity = Rarity.EPIC,
    elixirCost = 4,
    damage = 194
), IDamageable, IFlyable
{
    override var hitpoints: Int = 1500

    override fun attack() {
        println("$name is attacking! it deals $damage damage!")
    }

    override fun getDamaged(damage: Int) {
        println("$name got damaged by $damage points!")
    }

    override fun fly() {
        println("$name is flying over arena!")
    }

    override fun levelUp() {
        damage += 19
        hitpoints += 135
        println("$name leveled up! Damage +19, Hitpoints +135")
    }
}