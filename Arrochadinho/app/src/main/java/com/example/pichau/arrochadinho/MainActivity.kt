package com.example.pichau.arrochadinho

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var btnMainChutar : Button
    lateinit var etMainChute : EditText
    val random = Random()
    val MINIMO = 1
    val MAXIMO = 99
    val randomNumber = rand(this.MINIMO, this.MAXIMO)
    var limiteInferior = MINIMO
    var limiteSuperior = MAXIMO

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botão de chute
        this.btnMainChutar = findViewById(R.id.btnMainChutar)
        this.btnMainChutar.setOnClickListener { onClick(it) }
        // Campo de chute
        this.etMainChute = findViewById(R.id.etMainChute)
    }

    fun onClick(view: View){
        val it = Intent(this, ResultadoActivity::class.java)
        Toast.makeText(this,  "Número sorteado: ${randomNumber.toString()}", Toast.LENGTH_SHORT).show()
        if (this.validarInput()){
            Toast.makeText(this, "Informe um chute válido!", Toast.LENGTH_SHORT).show()
        }
        else if (this.acertouONumero()){
            Toast.makeText(this, "Você PERDEU! Número sorteado: ${randomNumber.toString()}, Você chutou: ${this.etMainChute.text}", Toast.LENGTH_LONG).show()
        }
        else if (this.chuteForaDoIntervalo()) {
            Toast.makeText(this, "Você PERDEU! Chute fora do intervalo! Número sorteado: ${randomNumber.toString()}, Você chutou: ${this.etMainChute.text}", Toast.LENGTH_LONG).show()
        }
        else if (this.chutePertenceAoLimite()) {
            Toast.makeText(this, "Você PERDEU! Chute pertence ao limite! Número sorteado: ${randomNumber.toString()}, Você chutou: ${this.etMainChute.text}", Toast.LENGTH_LONG).show()
        }
        // Testes - Alterar Limite
        else if (this.chuteMenorQueOAdvinhado()) {
            Toast.makeText(this, "Limite Inferior Alterado: ${limiteInferior}!", Toast.LENGTH_LONG).show()
        }
        else if (this.chuteMaiorQueOAdvinhado()) {
            Toast.makeText(this, "Limite Superior Alterado: ${limiteSuperior}!", Toast.LENGTH_LONG).show()
        }
        // Teste acertou
        if (this.acertou()) {
            it.putExtra("RESULTADO", "Parabéns, você arrochou o número: ${randomNumber}!")
            Toast.makeText(this, "Parabéns, você arrochou o número: ${randomNumber}!", Toast.LENGTH_LONG).show()
            startActivity(it)
        }



    }

    // Validar
    fun validarInput () : Boolean {
        if (etMainChute.text.isNullOrBlank()){
            return true
        }
        return false
    }
    /*
    * Testes em caso de PERDER
    */
    fun acertouONumero () : Boolean {
        if(this.randomNumber == etMainChute.text.toString().toInt()){
            return true
        }
        return false
    }
    fun chuteForaDoIntervalo () : Boolean {
        if (etMainChute.text.toString().toInt() < limiteInferior || etMainChute.text.toString().toInt() > limiteSuperior){
            return true
        }
        return false
    }
    fun chutePertenceAoLimite () : Boolean {
        if(etMainChute.text.toString().toInt() == limiteInferior || etMainChute.text.toString().toInt() == limiteSuperior) {
            return true
        }
        return false
    }
    // Testes para Alterar o LIMITE
    fun chuteMenorQueOAdvinhado () : Boolean {
        if (etMainChute.text.toString().toInt() < randomNumber) {
            limiteInferior = etMainChute.text.toString().toInt()
            return true
        }
        return false
    }

    fun chuteMaiorQueOAdvinhado () : Boolean {
        if (etMainChute.text.toString().toInt() > randomNumber) {
            limiteSuperior = etMainChute.text.toString().toInt()
            return true
        }
        return false
    }

    // Ganhar
    fun acertou () : Boolean {
        if(this.limiteInferior == this.randomNumber- 1 && this.limiteSuperior == this.randomNumber+ 1){
            return true
        }
        return false
    }


}
