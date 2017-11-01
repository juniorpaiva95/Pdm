package Classes

open class Media(
        override var descricao: String,
        open var tipo: Tipo,
        open var valor: Double) : Corrupcao(descricao) {
}