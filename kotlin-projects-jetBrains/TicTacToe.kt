package tictactoe

val game = MutableList(9) {' '}
val grid = mutableListOf(
    mutableListOf(game[0], game[1], game[2]),
    mutableListOf(game[3], game[4], game[5]),
    mutableListOf(game[6], game[7], game[8])
)

fun xWins(grid: MutableList<MutableList<Char>>): Boolean {
    return (grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X' ||
            grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X' ||
            grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X' ||
            grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X' ||
            grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X' ||
            grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X' ||
            grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X' ||
            grid[2][0] == 'X' && grid[1][1] == 'X' && grid[0][2] == 'X')
}

fun oWins(grid: MutableList<MutableList<Char>>): Boolean {
    return (grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O' ||
            grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O' ||
            grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O' ||
            grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O' ||
            grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O' ||
            grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O' ||
            grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O' ||
            grid[2][0] == 'O' && grid[1][1] == 'O' && grid[0][2] == 'O')
}

fun hasEmptyCell(grid: MutableList<MutableList<Char>>): Boolean {
    return grid.fold(0) { acc: Int, strings: MutableList<Char> ->
        acc + strings.filter { it == ' ' }.size
    } > 0
}

fun printGrid (grid: MutableList<MutableList<Char>>) {
    val dashes = "-".repeat(9)
    println(dashes)
    for (i in grid) {
        print("| ")
        for (j in i) {
            print("$j ")
        }
        println("|")
    }
    println(dashes)
}

fun play (player: Int, symbol: Char) {
    while (true) {
        print("Player $player, enter the coordinates for $symbol: ")
        val user = readln().split(" ")
        val line = user[0].toIntOrNull()
        val col = user[1].toIntOrNull()

        if (line == null || col == null || user.size != 2) {
            println("You should enter numbers!")
        } else {
            if (line > 3 || line < 1 || col > 3 || col < 1) {
                println("Coordinates should be from 1 to 3!")
            } else if (grid[line - 1][col - 1] != ' ') {
                println("This cell is occupied! Choose another one!")
            } else if (grid[line -1][col -1] == ' '){
                grid[line -1][col -1] = symbol
                break
            }
        }
    }
}

fun main() {
    var gameOver = false
    var player = 1
    var symbol = 'X'

    do {
        printGrid(grid)
        if (xWins(grid)) {
            println("X wins")
            gameOver = true
        } else if (oWins(grid)) {
            println("O wins")
            gameOver = true
        } else {
            if (hasEmptyCell(grid)) {
                play(player, symbol)
                player = if (player == 1) 2 else 1
                symbol = if (symbol == 'X') 'O' else 'X'
            } else if (!xWins(grid) && !oWins(grid)){
                println("Draw")
                gameOver = true
            }
        }
    } while (!gameOver)
}

