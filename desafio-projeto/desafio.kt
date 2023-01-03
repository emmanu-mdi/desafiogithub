
// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuarious(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, private val nivel: Nivel,
                    var conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuarious>()

    fun matricular(usuario: Usuarious) {
        inscritos.add(usuario)
    }

    fun getInscritosFormacao(): List<Usuarious> {
            return inscritos
    }
}

fun main() {
    val usuario1 = Usuarious("Alexandre")
    val usuario2 = Usuarious("Danielle")
    val usuario3 = Usuarious("Paulo")
    val usuario4 = Usuarious("Emanuela")
    val usuario5 = Usuarious("Dario")
    val usuario6 = Usuarious("Aparecida")
    val usuario7 = Usuarious("Nildo")
    val usuario8 = Usuarious("Joana")
    val usuario9 = Usuarious("Pina")

    val conteudo1 = ConteudoEducacional("Arquitetura de softwares")
    val conteudo2 = ConteudoEducacional("Banco de dados")
    val conteudo3 = ConteudoEducacional("Lógica de programação", 30)
    val conteudo4 = ConteudoEducacional("Kotlin basics", 90)
    val conteudo5 = ConteudoEducacional("Kotlin advanced", 100)
    val conteudo6 = ConteudoEducacional("Kotlin OOP", 100)

    val formacao1 = Formacao("Introdução à programação", Nivel.BASICO, listOf(conteudo1, conteudo3))
    val formacao2 = Formacao("Kotlin basics", Nivel.INTERMEDIARIO, listOf(conteudo2, conteudo4))
    val formacao3 = Formacao("Kotlin advanced", Nivel.DIFICIL, listOf(conteudo5, conteudo6))

    formacao1.matricular(usuario7)
    formacao1.matricular(usuario8)
    formacao1.matricular(usuario9)
    formacao2.matricular(usuario4)
    formacao2.matricular(usuario5)
    formacao2.matricular(usuario6)
    formacao3.matricular(usuario1)
    formacao3.matricular(usuario2)
    formacao3.matricular(usuario3)

    println("Conteúdos do curso \"${formacao1.nome}\":")
    println("${formacao1.conteudos}")
    println("Usuários inscritos no Curso \"${formacao1.nome}\":")
    println(formacao1.getInscritosFormacao())
    println()
    println("Conteúdos do curso \"${formacao2.nome}\":")
    println("${formacao2.conteudos}")
    println("Usuários inscritos no Curso \"${formacao2.nome}\":")
    println(formacao2.getInscritosFormacao())
    println()
    println("Conteúdos do curso \"${formacao3.nome}\":")
    println("${formacao3.conteudos}")
    println("Usuários inscritos no Curso \"${formacao3.nome}\":")
    println(formacao3.getInscritosFormacao())
}