package com.example.pichau.arrochadinho

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat.getExtras
import android.widget.TextView


class ResultadoActivity : AppCompatActivity() {
    lateinit var tvResultadoMsg : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

//        tvResultadoMsg = findViewById(R.id.tvResultadoMsg)
//        val it = Intent()
//
//        val bundle = it.extras
//
//        val txt = bundle.getString("RESULTADO")
//        tvResultadoMsg.setText(txt)

    }
}
