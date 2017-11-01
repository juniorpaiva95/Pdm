package Classes

class Avancada(
        override var descricao: String,
        override var tipo: Tipo,
        override var valor: Double,
        var frequencia: Int) : Media(descricao, tipo, valor) {
}