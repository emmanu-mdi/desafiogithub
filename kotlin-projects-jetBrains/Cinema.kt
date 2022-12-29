package cinema

import kotlin.math.abs

fun printCinema (rows: Int, seatsNum: Int, seats: MutableList<MutableList<Char>>) {
    println("Cinema:")
    print(" ")
    for (i in 1..seatsNum) {
        print(" $i")
    }
    println()
    for (i in 1..rows) {
        print("$i ")
        for (j in 1..seatsNum) print(seats[i-1][j-1] + " ")
        println()
    }
}
var uPrice = 0

fun seatPrice(rows: Int, seatsNum: Int, rowNum: Int) {
    val room = rows * seatsNum
    val price: Int

    if (room > 60) {
        val frontHalf: Int = rows / 2
        if (rowNum > frontHalf) {
            price = 8
            println("Ticket price: $$price")
        } else {
            price = 10
            println("Ticket price: $$price")
        }
    } else {
        price = 10
        println("Ticket price: $$price")
    }
    uPrice = price
}

fun main() {
    println("Enter the number of rows:")
    val rows = abs(readln().toInt())
    println("Enter the number of seats in each row:")
    val seatsNum = abs(readln().toInt())
    val seat = 'S'
    val seats = MutableList(rows){MutableList(seatsNum){seat}}
    val parcialPrice = mutableListOf(0)

    var purchased = 0

    fun buyTicket () {
        try {
            println("\nEnter a row number:")
            var rowNum = readln().toInt()
            println("Enter a seat number in that row:")
            var userSeat = readln().toInt()

            if (seats[rowNum - 1][userSeat - 1] == 'S') {
                seatPrice(rows, seatsNum, rowNum)
                println()
                seats[rowNum - 1][userSeat - 1] = 'B'
                parcialPrice.add(uPrice)
            } else {
                do {
                    println("That ticket has already been purchased!")
                    println("\nEnter a row number:")
                    val rNum = readln().toInt()
                    println("Enter a seat number in that row:")
                    val uSeat = readln().toInt()
                    rowNum = rNum
                    userSeat = uSeat
                } while (seats[rowNum - 1][userSeat - 1] == 'B')
                seatPrice(rows, seatsNum, rowNum)
                println()
                seats[rowNum - 1][userSeat - 1] = 'B'
                parcialPrice.add(uPrice)
            }
        } catch (e: IndexOutOfBoundsException) {
                println("Wrong input!")
        }
    }

    fun cinemaStats(rows: Int, seatsNum: Int, purchased: Int) {
        val room = rows * seatsNum
        val percent: Double = purchased.toDouble() / room * 100
        val formatPercent = "%.2f".format(percent)
        val fullPrice = 10
        val salePrice = 8
        var income = fullPrice * room

        if (room > 60) {
            val frontHalf: Int = rows / 2 * seatsNum
            val backHalf: Int = (rows - rows / 2) * seatsNum
            income = frontHalf * fullPrice + backHalf * salePrice
        }
        println("Number of purchased tickets: $purchased")
        println("Percentage: $formatPercent%")
        println("Current income: $${parcialPrice.sum()}")
        println("Total income: $$income")
    }

    do {
        println("""
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit 
        """.trimIndent())
        val uChoice = readln().toInt()
        when (uChoice){
            1 -> printCinema(rows, seatsNum, seats)
            2 -> buyTicket()
            3 -> cinemaStats(rows, seatsNum, purchased)
        }
        if (uChoice == 2) {
            purchased ++
        }
    } while (uChoice != 0)
}

