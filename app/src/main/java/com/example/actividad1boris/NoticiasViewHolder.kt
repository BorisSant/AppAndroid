package com.example.actividad1boris

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticiasViewHolder(view: View):RecyclerView.ViewHolder(view){

    // Inicializa el componente y accede mediante su id
    private val txtNoticia: TextView =view.findViewById(R.id.txtNoticia)

    // agrega el dato deseado al componente que muestra en pantalla al usuario
    fun render(noticia:Noticia){
        txtNoticia.text = noticia.noticia
    }

}