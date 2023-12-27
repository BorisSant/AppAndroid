package com.example.actividad1boris

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoticiasAdapter(private val noticias:List<Noticia>):RecyclerView.Adapter<NoticiasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_noticia,parent,false)
        return NoticiasViewHolder(view)
    }

    override fun getItemCount()= noticias.size

    override fun onBindViewHolder(holder: NoticiasViewHolder, position: Int) {
        holder.render(noticias[position])
    }

}