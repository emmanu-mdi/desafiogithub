class Customer                                 
// 1 header e body della classe sono opzionali, questo è un costruttore standard

class Contact(val id: Int, var email: String)   
// 2 costruttore personalizzato attraverso 2 parametri

fun main() {

    val customer = Customer()                   // 3 crea un'istanza della classe customer
    
    val contact = Contact(1, "mary@gmail.com")  // 4 crea un'istanza della classe contact con i parametri richiesti

    println(contact.id)                         // 5 richiama l'id dell'istanza contact
    contact.email = "jane@gmail.com"            // 6 aggiorna l'email dell'istanza contact
    println(contact.email)
}