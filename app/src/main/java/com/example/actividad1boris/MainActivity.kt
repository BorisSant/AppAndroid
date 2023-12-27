package com.example.actividad1boris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializamos componentes
        val btnIniciar= findViewById<Button>(R.id.btnIniciar)
        val edtNombre=findViewById<EditText>(R.id.edtNombre)

        //Eventos
        btnIniciar.setOnClickListener {
            //Redirige al menú de opciones para selección de operaciones
            val intent = Intent(this, MenuGeneralActivity::class.java)
            // Pasar el nombre que ingresa el usuario, esto con la finalidad de ganar mayor confianza con el usuario
            intent.putExtra("texto",edtNombre.text.toString())
            startActivity(intent)
        }

    }
}