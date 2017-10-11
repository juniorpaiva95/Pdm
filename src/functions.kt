import java.util.*

fun gerarNumeroAleatorio(max:Int, min:Int): Int {
    val random = Random()
    val randomNumber = random.nextInt(max + 1 - min) + min
    return randomNumber
}
