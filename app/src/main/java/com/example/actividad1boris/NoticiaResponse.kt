package com.example.actividad1boris

import com.google.gson.annotations.SerializedName

// Formato de respuesta esperada
data class NoticiaResponse(@SerializedName("noticias") var noticias:List<Noticia>)
