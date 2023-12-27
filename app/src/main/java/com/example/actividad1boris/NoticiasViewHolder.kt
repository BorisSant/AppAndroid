package com.example.actividad1boris

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticiasViewHolder(view: View):RecyclerView.ViewHolder(view){

    private val txtNoticia: TextView =view.findViewById(R.id.txtNoticia)

    fun render(noticia:Noticia){
        txtNoticia.text = noticia.noticia
    }

}