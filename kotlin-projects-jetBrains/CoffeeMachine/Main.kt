package machine

fun main() {
    val coffeeMachine = CoffeeMachine()
    do {
        println("Write action (buy, fill, take, remaining, exit):")
        val actionChoice = readln()
        coffeeMachine.mainChoice(actionChoice)
    } while (actionChoice != "exit")
}

