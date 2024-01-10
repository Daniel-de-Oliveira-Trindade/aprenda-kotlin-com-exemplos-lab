// [Kotlin Playground para executar o codigo](https://pl.kotl.in/ynBtcL6e_)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Aluno(val nome: String)

data class ConteudoEducacional(var nome: String, val nivel: Nivel, val duracao: Int)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val matriculados = mutableListOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
        matriculados.addAll(alunos)
        println("Alunos matriculados na formação $nome:")
        alunos.forEach { println("- ${it.nome}") }
    }
}

fun main() {
    val aluno1 = Aluno("Felipe")
    val aluno2 = Aluno("Julia")
    val aluno3 = Aluno("Daniel")

    val conteudoKotlin1 = ConteudoEducacional("Introdução ao Kotlin",Nivel.BASICO,13)
    val conteudoKotlin2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin",Nivel.INTERMEDIARIO, 45)
    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO, listOf(conteudoKotlin1, conteudoKotlin2))
    
    formacaoKotlin.matricular(aluno1, aluno2, aluno3)
    
    val conteudoJava1 = ConteudoEducacional("Introdução ao Java",Nivel.BASICO,10)
    val conteudoJava2 = ConteudoEducacional("Programação Orientada a Objetos em Java e Instanciamento de classes",Nivel.AVANCADO, 60)
    val formacaoJava = Formacao("Formação Java", Nivel.INTERMEDIARIO, listOf(conteudoJava1, conteudoJava2))

    formacaoJava.matricular(aluno1,aluno3)
    
    println("Detalhes da $formacaoKotlin")
    println("Detalhes da $formacaoJava")
}
