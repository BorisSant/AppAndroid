package com.example.actividad1boris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoRaizActivity : AppCompatActivity() {

    private lateinit var btnRegresar: Button
    private lateinit var txtResultado: TextView
    private lateinit var txtOperacion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_raiz)
        initComponentes()
        recibirRespuesta()
        initListener()
    }
    private fun initComponentes(){
        txtResultado=findViewById(R.id.txtResultado)
        btnRegresar =findViewById(R.id.btnRegresar)
        txtOperacion=findViewById(R.id.txtOperacion)
    }
    private fun initListener(){
        btnRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun recibirRespuesta(){
        val respuesta:String=intent.extras?.getString("Result").orEmpty()
        if (respuesta.isNotEmpty()){
            txtOperacion.text="Operación exitosa!"
            txtResultado.text=respuesta
        }else{
            txtOperacion.text="Error al realizar la operación!"
        }
    }
}