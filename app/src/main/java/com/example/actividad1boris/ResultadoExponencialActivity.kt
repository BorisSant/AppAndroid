package com.example.actividad1boris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoExponencialActivity : AppCompatActivity() {

    // declaración de componentes
    private lateinit var btnRegresar: Button
    private lateinit var txtResultado: TextView
    private lateinit var txtOperacion:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_exponencial)
        initComponentes()
        recibirRespuesta()
        initListener()
    }


    // Inicialización de componentes
    private fun initComponentes(){
        txtResultado=findViewById(R.id.txtResultado)
        btnRegresar =findViewById(R.id.btnRegresar)
        txtOperacion=findViewById(R.id.txtOperacion)
    }

    //Eventos
    private fun initListener(){
        btnRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    // Mostrar respuesta obtenida
    private fun recibirRespuesta(){
        val respuesta:String=intent.extras?.getString("Resultado").orEmpty()
        if (respuesta.isNotEmpty()){
            txtOperacion.text="Operación exitosa!"
            txtResultado.text=respuesta
        }
    }


}