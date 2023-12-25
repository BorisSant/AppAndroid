package com.example.actividad1boris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.slider.RangeSlider
import kotlin.math.pow

class ExponencialActivity : AppCompatActivity() {

    // variables de calculo
    private var exponente:Int=2
    private lateinit var base:String

    // Componentes
    private lateinit var txtExponente: TextView
    private lateinit var rngExponente: RangeSlider
    private lateinit var edtNumeroBase: EditText
    private lateinit var btnRegresar: Button
    private lateinit var btnCalcular: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exponencial)
        initComponentes()
        initListener()
    }


    private fun initComponentes(){
        txtExponente=findViewById(R.id.txtExponente)
        txtExponente.text="${exponente.toString()}"
        rngExponente=findViewById(R.id.rngExponente)
        edtNumeroBase=findViewById(R.id.edtNumeroBase)
        btnRegresar=findViewById(R.id.btnRegresar)
        btnCalcular=findViewById(R.id.btnCalcular)
    }

    private fun initListener(){

        rngExponente.addOnChangeListener { slider, value, fromUser ->
            exponente=value.toInt()
            txtExponente.text="${exponente.toString()}"
        }
        //Calculo del exponente
        btnCalcular.setOnClickListener{
            base=edtNumeroBase.text.toString()

            val resul:Double = calcularExpo()
            val resulInt:Int=resul.toInt()
            val intent = Intent(this,ResultadoExponencialActivity::class.java)
            intent.putExtra("Resultado",resulInt.toString())
            startActivity(intent)
        }

        // hacia atrás
        btnRegresar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }


    private fun calcularExpo(): Double {
        val baseDouble: Double = base.toDouble()
        val exponenteDouble: Double = exponente.toDouble()
        val resultado=Math.pow(baseDouble,exponenteDouble)
        return resultado
    }


}