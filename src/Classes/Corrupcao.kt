package Classes

open abstract class Corrupcao(open var descricao: String) {
    override fun toString(): String {
        return "${this.descricao}"
    }
}