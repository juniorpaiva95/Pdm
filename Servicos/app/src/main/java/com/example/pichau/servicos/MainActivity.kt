package com.example.pichau.servicos

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.graphics.Bitmap
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    lateinit var btnMainCamera : Button
    lateinit var imgMainImagem : ImageView
    val REQUESTCODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainCamera = findViewById(R.id.btnMainCamera)
        imgMainImagem = findViewById(R.id.imgMainImagem)
        btnMainCamera.setOnClickListener({camera(it)})
    }

    fun camera(view : View) {
        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(it, REQUESTCODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == REQUESTCODE) {
            if(resultCode == Activity.RESULT_OK) {
                Toast.makeText(applicationContext, "Teste", Toast.LENGTH_SHORT)
            } else {
                Toast.makeText(applicationContext, "Testeasd", Toast.LENGTH_SHORT)
            }
        }
    }
}
