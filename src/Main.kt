import Classes.*

fun main(args: Array<String>) {
    var lista = arrayListOf(
            "Sonegação de imposto",
            "Carteirinha falsa",
            "Compra de CNH",
            "Fazer hora no trabalho",
            "Pirataria",
            "Desrespeitando os outros",
            "Ganhando no troco",
            "Pagando um cafezinho",
            "Contrabando Gourmet",
            "Gatonet"
    );
    var usuarios = arrayListOf<Usuario>()
    var u1 = Usuario("Jose", 145.0)
    var u2 = Usuario("Pedro", 925.0)
    var u3 = Usuario("Maria", 5000.0)
    var u4 = Usuario("Diego", 50000.0)
    usuarios.add(u1)
    usuarios.add(u2)
    usuarios.add(u3)
    usuarios.add(u4)

    u1.corrupcao.add(Iniciante(lista[gerarNumeroAleatorio(lista.size - 1, 0)]))
    u1.corrupcao.add(Media(lista[gerarNumeroAleatorio(lista.size - 1, 0)], Tipo.ATIVO, 5000.0))
    u1.corrupcao.add(Avancada(lista[gerarNumeroAleatorio(lista.size - 1, 0)], Tipo.ATIVO, 9500.0, 5))
    u2.corrupcao.add(Avancada(lista[gerarNumeroAleatorio(lista.size - 1, 0)], Tipo.PASSIVO, 9000.0, 5))
    u3.corrupcao.add(Media(lista[gerarNumeroAleatorio(lista.size - 1, 0)], Tipo.SISTEMICA, 5000.0))

    for (u in usuarios) {
        println("Usuário: ${u.nome}\nCorrupções cometidas (${u.corrupcao.size}):")
        for (c in u.corrupcao){
            println("Tipo: ${c::class.simpleName} - Descrição: ${c.descricao}")
        }
        println()
    }
}
