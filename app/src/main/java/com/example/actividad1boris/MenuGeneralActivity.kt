package com.example.actividad1boris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class MenuGeneralActivity : AppCompatActivity() {

    // declaración de componentes
    private lateinit var txtMensaje: TextView
    private lateinit var btnExponente: Button
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

    // Inicializar componentes
    private fun initComponentes(){
        txtMensaje=findViewById(R.id.txtMensaje)
        btnExponente=findViewById(R.id.btnExponente)
        btnRaices=findViewById(R.id.btnRaices)
        btnNoticias=findViewById(R.id.btnNoticias)
        btnRegresar=findViewById(R.id.btnRegresar)
    }

    // Eventos
    private fun initListener(){
        btnExponente.setOnClickListener {
            Log.i("MENU --------- ","LANZAMOS EXPONENCIAL APP")
            navegarHaciaApp(ExponencialActivity::class.java)
        }
        btnRaices.setOnClickListener {
            Log.i("MENU --------- ","LANZAMOS RAICES APP")
            navegarHaciaApp(RaizActivity::class.java)
        }
        btnNoticias.setOnClickListener {
            Log.i("MENU --------- ","LANZAMOS NOTICIAS APP")
            navegarHaciaApp(NoticiasActivity::class.java)
        }

        // hacia atrás, retrocede a la pantalla anterior
        btnRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
    // Recibimos el nombre que ingresó el usuario y le mostramos un mensaje general de guía
    private fun mostrarMensaje(){
        val texto:String=intent.extras?.getString("texto").orEmpty()
        if (texto.isNotEmpty()){
            txtMensaje.text="$texto, selecciona una operación por favor!"
        }
    }

    // Redirección a una nueva pantalla segú la opción que seleccione el usuario
    fun navegarHaciaApp(clase:Class<*>){
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}