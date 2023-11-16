enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: MutableList<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario): String {
        
        if(inscritos.contains(usuario)) { return "Usuário já matriculado"}
        
        else {
            inscritos.add(usuario)
            return "Usuário matriculado!!"
        }
    }
}

fun main() {
    
    val conteudos: MutableList<ConteudoEducacional> = mutableListOf<ConteudoEducacional>()
    
    var course: ConteudoEducacional = ConteudoEducacional("Desenvolvimento Android - Layout",30,Nivel.BASICO)
    
    conteudos.add(course)
    
    course = ConteudoEducacional("Conceitos da Linguagem Kotlin",10,Nivel.BASICO)
    
    conteudos.add(course)
    
    course = ConteudoEducacional("Android Jetpack",nivel = Nivel.INTERMEDIARIO)
    
    conteudos.add(course)
    
    val formacao = Formacao("Desenvolvedor Android - Kotlin", conteudos)
    
    var result = formacao.matricular(Usuario("Andrey"))
    
    println(result)
    
    result = formacao.matricular(Usuario("Andrey"))
    
    println(result)
    
    result = formacao.matricular(Usuario("Carlos"))
    
    println(result) 
}
