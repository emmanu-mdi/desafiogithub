package machine

class CoffeeMachine(private var mAmount: Int = 550, private var mWater: Int = 400,
                    private var mMilk: Int = 540, private var mBeans: Int = 120, private var mCups: Int = 9) {

    fun printMStatus (mWater:Int, mMilk:Int, mBeans:Int, mAmount:Int, mCups:Int) {
        println("""
        
        The coffee machine has:
        $mWater ml of water
        $mMilk ml of milk
        $mBeans g of coffee beans
        $mCups disposable cups
        $$mAmount of money
        
    """.trimIndent())
    }
    fun fillMachine() {
        println("Write how many ml of water you want to add:")
        val addWater = readln().toInt()
        println("Write how many ml of milk you want to add:")
        val addMilk = readln().toInt()
        println("Write how many grams of coffee beans the coffee you want to add:")
        val addBeans = readln().toInt()
        println("Write how many disposable cups you want to add:")
        val addCups = readln().toInt()
        mWater += addWater
        mMilk += addMilk
        mBeans += addBeans
        mCups += addCups
    }

    fun takeMoney() {
        println("I gave you $$mAmount")
        mAmount = 0
    }

    fun setValues(water:Int, milk:Int, beans:Int, amount:Int) {
        if (mWater >= water && mMilk >= milk && mBeans >= beans && mCups > 0) {
            mWater -= water
            mMilk -= milk
            mBeans -= beans
            mCups--
            mAmount += amount
            println("I have enough resources, making you a coffee!")
        } else {
            when {
                mWater < water -> println("Sorry, not enough water!")
                mMilk < milk -> println("Sorry, not enough milk!")
                mBeans < beans -> println("Sorry, not enough coffee beans!")
                mCups == 0 -> println("Sorry, not enough disposable cups!")

            }
        }
    }

    fun buyChoice(drinkChoice: String) {
        when(drinkChoice) {
            "1" -> setValues(250,0,16,4)
            "2" -> setValues(350,75,20,7)
            "3" -> setValues(200,100,12,6)
            "back" -> {
                println("Write action (buy, fill, take, remaining, exit):")
                mainChoice(actionChoice = readln())
            }
        }
    }

    fun mainChoice (actionChoice:String) {
        when(actionChoice) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu::")
                val drinkChoice = readln()
                buyChoice(drinkChoice)
            }
            "fill" -> fillMachine()
            "take" -> takeMoney()
            "remaining" -> printMStatus(mWater, mMilk, mBeans, mAmount, mCups)
        }
    }

}