package com.example.actividad1boris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class MenuGeneralActivity : AppCompatActivity() {

    private lateinit var txtMensaje: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_general)

        initComponentes()
        mostrarMensaje()

    }

    private fun initComponentes(){
        txtMensaje=findViewById(R.id.txtMensaje)

    }
    private fun mostrarMensaje(){
        val texto:String=intent.extras?.getString("texto").orEmpty()
        if (texto.isNotEmpty()){
            txtMensaje.text="$texto, selecciona una operación por favor!"
        }
    }
}