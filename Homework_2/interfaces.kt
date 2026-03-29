interface IFlyable{
    fun fly()
}

interface ICastable{
    fun cast()
}

interface IDamageable{
    var hitpoints: Int

    fun getDamaged(damage: Int)
    fun attack()
}