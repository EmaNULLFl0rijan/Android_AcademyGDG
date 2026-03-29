//Clash Royale

fun calculatePushDamage(deck: List<Card>): Int {
    return deck.sumOf { it.damage }
}

fun filterDeck(deck: List<Card>, condition: (Card) -> Boolean): List<Card> {
    return deck.filter(condition)
}


fun main(){
    var myDeck = listOf<Card>(HogRider(), Log(), BabyDragon(), Cannon())

    println("First card is ${myDeck.first().name}")
    println("You have ${myDeck.size} cards in your deck:")

    myDeck.forEach { card ->
        println(card.name)
    }

    myDeck.forEach { card ->
        card.levelUp()
    }

    val pushDamage = calculatePushDamage(myDeck)
    println("Max damage per hit of that push is: $pushDamage")

    val under4ElixirDeck = filterDeck(myDeck, {it.elixirCost<4})
    println("Max damage of cheap push is: ${calculatePushDamage(under4ElixirDeck)}")
}

