/* Generics sono
Avere una certa flessibilità nella tipizzazione, cioè nel definire il tipo di variabili...
Si usa tanto nelle collezioni, liste, mappe. Dichiari di avere una lista... di un determinato tipo
Le classi e le funzioni generiche aumentano la riusabilità del codice incapsulando la logica comune 
che è indipendente da un particolare tipo generico, come la logica all'interno di un List<T> è indipendente 
da ciò che è T.
 */

/*
Classi generiche
 */

 class MutableStack<E>(vararg items: E) {    // batteria che cambia          
    /* 1 una classe come creazione di una batteria di elementi 
    dove l'ultimo che entra è il primo ad uscire. Metodi importanti in questa classe sono push, pop e peek 
    <E> può essere qualsiasi cosa, qualsiasi tipo 
    è un parametro generico della classe. Questa classe riceve un array di E*/

  private val elements = items.toMutableList() //proprietà degli elementi che vengono convertiti in lista mutabile

    /*Usa serie di funzioni utili che ogni batteria dovrebbe avere */
  fun push(element: E) = elements.add(element)        // 2 riceve un elemento E e lo aggiunge alla lista

  fun peek(): E = elements.last()                     // 3 prendere l'ultimo, senza rimuoverlo

  fun pop(): E = elements.removeAt(elements.size - 1) // 4 prende l'ultimo elemento ma lo rimuove

  fun isEmpty() = elements.isEmpty() // funzione che verifica se è vuoto

  fun size() = elements.size        // restituisce la misura dell'elemento

  override fun toString() = "MutableStack(${elements.joinToString()})" // sovrascrive e converte in testo la batteria
}

fun main() {
  val stack = MutableStack(0.62, 3.14, 2.7) // inizia una istanza della classe creata sopra con alcuni elementi
  stack.push(9.87) // ne aggiunge ancora uno
  println(stack) // stampa gli elementi di stack

  println("peek(): ${stack.peek()}") // test del metodo peek: prende l'ultimo elemento della batteria, quello che sta sopra
  println(stack)

/* loop nella batteria fino a rimuovere tutti gli elementi */
  for (i in 1..stack.size()) {
    println("pop(): ${stack.pop()}")
    println(stack)
  }
}

/*
Funzioni generiche
È inoltre possibile generare funzioni se la loro logica è indipendente da un tipo specifico
 */

 class MutableStack<E>(vararg items: E) {              // 1
  private val elements = items.toMutableList()
  fun push(element: E) = elements.add(element)        // 2
  fun peek(): E = elements.last()                     // 3
  fun pop(): E = elements.removeAt(elements.size - 1)
  fun isEmpty() = elements.isEmpty()
  fun size() = elements.size
  override fun toString() = "MutableStack(${elements.joinToString()})"
}


fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)
/*funzione con parametro generico <E>, quando questa funzione viene chiamata se ne crea
una nuova MutableStack con un vararg di elements (costruttore della classe sopra) */

fun main() {
  val stack = mutableStackOf(0.62, 3.14, 2.7)
  println(stack)
}