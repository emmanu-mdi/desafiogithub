fun someCondition() = true

fun main() {

    var a: String = "initial"  // 1 variabile mutabile, posso riattrubuire il valore
    println(a)
    val b: Int = 1             // 2 variabile immutabile, non posso cambiare il valore
    val c = 3                  // 3 inferenza del tipo tipoca di Ktlin, quando il tipo non è specificato

    var e: Int  // 4
    println(e)  // 5 errore perché la variabile non è stata inizializzata

    
    /* usa la funzione sopra */
    val d: Int  // 6
    
    if (someCondition()) {
        d = 1   // 7
    } else {
        d = 2   // 8
    }
    
    println(d) // 9



}