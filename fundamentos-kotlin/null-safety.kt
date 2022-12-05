/*
Per default le variabili in Kotlin non possono essere nulle. Per permettere questa possibilità bisogna aggiungere
il punto di domanda ? dopo il tipo.
 */

/*Un modo per gestire le uscite nulle. L'altro modo è con l'elvis operator */
fun describeString(maybeString: String?): String {              // 1
    if (maybeString != null && maybeString.length > 0) {        // 2
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"                           // 3
    }
}


fun main() {

    var neverNull: String = "This can't be null"            // 1    
    neverNull = null                                        // 2 da errore perché la string non può essere nulla
    
    var nullable: String? = "You can keep a null here"      // 3    
    nullable = null                                         // 4 ok, perché può essere nulla
    
    var inferredNonNull = "The compiler assumes non-null"   // 5 per inferenza la variabile non può essere nulla  
    inferredNonNull = null                                  // 6 perché è stata inizializzata. Da errore l'uscita
    
    fun strLength(notNull: String): Int {                   // 7 
        return notNull.length
    }    
    strLength(neverNull)                                    // 8 ok
    strLength(nullable)                                     // 9 errore

    fun strLength_1(str: String): Int {                     // 7bis se è nulla ritorna il valore 0 
        return str?.length ?: 0                             // elvis operator
    } 
    /*
    ELVIS OPERATOR in Kotlin:
    Instead of the first operand having to result in a boolean, it must result in an object reference. 
    If the resulting object reference is not null, it is returned. Otherwise the value of the second operand 
    (which may be null) is returned. If the second operand is null, the operator is also able to throw 
    an exception.
     */

    println(describeString(null))                           // 10 utilizza la funzione sopra

}