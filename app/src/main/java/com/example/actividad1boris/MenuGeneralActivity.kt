package com.example.actividad1boris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class MenuGeneralActivity : AppCompatActivity() {

    private lateinit var txtMensaje: TextView
    private lateinit var btnExponente: Button
    private lateinit var btnConversion: Button
    private lateinit var btnRaices: Button
    private lateinit var btnNoticias: Button
    private lateinit var btnRegresar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_general)

        initComponentes()
        mostrarMensaje()
        initListener()

    }

    private fun initComponentes(){
        txtMensaje=findViewById(R.id.txtMensaje)
        btnExponente=findViewById(R.id.btnExponente)
        btnConversion=findViewById(R.id.btnConversion)
        btnRaices=findViewById(R.id.btnRaices)
        btnNoticias=findViewById(R.id.btnNoticias)
        btnRegresar=findViewById(R.id.btnRegresar)
    }

    private fun initListener(){
        btnExponente.setOnClickListener {
            Log.i("MENU --------- ","LANZAMOS EXPONENCIAL APP")
            navegarHaciaApp(ExponencialActivity::class.java)
        }
        btnRaices.setOnClickListener {
            Log.i("MENU --------- ","LANZAMOS RAICES APP")
            navegarHaciaApp(RaizActivity::class.java)
        }

        // hacia atrás
        btnRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
    private fun mostrarMensaje(){
        val texto:String=intent.extras?.getString("texto").orEmpty()
        if (texto.isNotEmpty()){
            txtMensaje.text="$texto, selecciona una operación por favor!"
        }
    }

    fun navegarHaciaApp(clase:Class<*>){
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}