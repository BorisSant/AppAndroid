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

        val btnIniciar= findViewById<Button>(R.id.btnIniciar)
        val edtNombre=findViewById<EditText>(R.id.edtNombre)

        btnIniciar.setOnClickListener {
            val intent = Intent(this, MenuGeneralActivity::class.java)
            // Pasar el nombre que ingresa el usuario
            intent.putExtra("texto",edtNombre.text.toString())
            startActivity(intent)
        }

    }
}