package me.emanuela.code

fun printMessage(message: String): Unit {                               // 1 uma função que tem um parâmetro message do tipo string e que não retorna nada 
    println(message)                                                    // qunando a função não retorna nada pode deixar vazio ou colocar Unit = un retorno qualquer
}
fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // 2 função que recebe 2 parâmetros do tipo String e o segundo é um valor padrão = "Info", caso não especifique outro valor
    println("[$prefix] $message")                                       // interpolação de string = utilizar uma variável dentro duma String literal
}

fun sum(x: Int, y: Int): Int {                                          // 3 função que retorna um inteiro
    return x + y
}

fun multiply(x: Int, y: Int) = x * y                                    // 4 função inline = definida em 1 linha

fun main() {
    printMessage("Hello")                                               // 5 função principal que executa              
    printMessageWithPrefix("Hello", "Log")                              // 6 todas as outras
    printMessageWithPrefix("Hello")                                     // 7
    printMessageWithPrefix(prefix = "Log", message = "Hello")           // 8 posso chamar os parâmetros nomeando-os e invertendo-os
    println(sum(1, 2))                                                  // 9
    println(multiply(2, 4))                                             // 10

/*hierarquia: a função main pode conter outras funções que estarão disponível só dentro dela */

/*
Functions with vararg Parameters
Vararg recebe quandos parâmetros eu quiser desde que respeitem o tipo declarado
 */
    fun printAll(vararg messages: String) {                            // 1 
        for (m in messages) println(m)
    }
    printAll("Hello", "Hallo", "Salut", "Hola", "你好")                 // 2 trata os strings como array
    
    fun printAllWithPrefix(vararg messages: String, prefix: String) {  // 3
        for (m in messages) println(prefix + m)
    }
    printAllWithPrefix(
            "Hello", "Hallo", "Salut", "Hola", "你好",
            prefix = "Greeting: "                                          // 4
    )

    fun log(vararg entries: String) {
        printAll(*entries)          // Se una funzione ne chiama un'altra che é anch'essa un vararg bisogna specificarla con l'asterisco davanti
    }                               
    
}



