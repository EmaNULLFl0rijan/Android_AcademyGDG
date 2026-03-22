val steps = listOf(1000, 2000, 10000, 3000, 12000, 5000, 8000)

fun main() {
    var sum: Int = 0

    for(step in steps) {
        sum += step
    }

    println("Ukupan broj koraka: $sum")

    var index: Int = 0
    var first: Int = -1

    while(index < steps.size) {

        if(steps[index] > 10000){
           first = index + 1
           break
        }

        index++
    }

    if(first != -1)
    println("Prvi dan kada je broj koraka veći od 10000 je dan broj: $first")
}