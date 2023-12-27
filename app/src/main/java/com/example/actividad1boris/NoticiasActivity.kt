package com.example.actividad1boris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NoticiasActivity : AppCompatActivity() {

    //Recycler de noticias
    private lateinit var rvNoticias: RecyclerView
    private lateinit var noticiasAdapter: NoticiasAdapter

    //Lista
    private val noticiasInit= mutableListOf<Noticia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        //Inicializar componentes
        initComponent()
        // Inicializar el RecyclerView
        initUI()
        //Realizamos la peticion a nuestra API de noticias
        getNoticias()
    }

    // Inicializar componentes
    private fun initComponent(){
        rvNoticias = findViewById(R.id.rvNoticias)
    }

    //Incializacion de RecyclerViews
    private fun initUI(){
        noticiasAdapter = NoticiasAdapter(noticiasInit)
        rvNoticias.layoutManager = LinearLayoutManager(this)
        rvNoticias.adapter=noticiasAdapter
    }

    //Funcion de peticion contra APIRestFull
    private fun getNoticiasRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.3.16:3000/") // tiene que ir la dirección ipv4
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun getNoticias(){
        CoroutineScope(Dispatchers.IO).launch{
            val peticion = getNoticiasRetrofit().create(ApiService::class.java).getNoticias("data")
            val noticiasResponse: NoticiaResponse? = peticion.body()
            runOnUiThread{
                if(peticion.isSuccessful){
                    Log.i("NOTICIAS","--------- EXITO")
                    //Relleno los datos desde la respuesta
                    val noticiasData=noticiasResponse?.noticias?:emptyList()
                    //Borro datos del RecyclerView
                    noticiasInit.clear()
                    noticiasInit.addAll(noticiasData)
                    //Repinta RecyclerView
                    noticiasAdapter.notifyDataSetChanged()
                }else{
                    Log.i("NOTICIAS","--------- ERROR")
                }
            }
        }
    }

}