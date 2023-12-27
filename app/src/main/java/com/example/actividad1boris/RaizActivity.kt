package com.example.actividad1boris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlin.math.pow

class RaizActivity : AppCompatActivity() {

    // variables de calculo
    private lateinit var numRaiz:String
    private lateinit var valor:String
    //declaración de componentes
    private lateinit var btnRegresar: Button
    private lateinit var btnCalcular: Button
    private lateinit var edtNumRaiz:EditText
    private lateinit var edtValor:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raiz)
        initComponentes()
        initListener()
    }

    //Inicializar componentes
    private fun initComponentes(){
        btnCalcular=findViewById(R.id.btnCalcular)
        btnRegresar=findViewById(R.id.btnRegresar)
        edtNumRaiz=findViewById(R.id.edtNumRaiz)
        edtValor=findViewById(R.id.edtValor)
    }
    //Eventos
    private fun initListener(){
        // hacia atrás
        btnRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        btnCalcular.setOnClickListener{
            numRaiz=edtNumRaiz.text.toString()
            valor=edtValor.text.toString()
            val resul:Double = calcularExpo()
            val intent = Intent(this,ResultadoRaizActivity::class.java)
            intent.putExtra("Result",resul.toString())
            startActivity(intent)
        }
    }

    // Cálculo de la operación
    private fun calcularExpo(): Double {
        val raizDouble: Double = numRaiz.toDouble()
        val valorDouble: Double = valor.toDouble()
        val resultado:Double=valorDouble.pow(1.0 / raizDouble)
        Log.i("Resuesta","la respuesta es $resultado")
        return resultado
    }

}