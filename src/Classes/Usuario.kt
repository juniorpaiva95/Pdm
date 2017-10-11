package Classes

class Usuario (var nome:String, var renda:Double){
    var corrupcao = arrayListOf<Corrupcao>();
    override fun toString(): String {
        return "Nome: ${this.nome}\nRenda: ${this.renda}\nCorrupção: ${corrupcao}"
    }
}

