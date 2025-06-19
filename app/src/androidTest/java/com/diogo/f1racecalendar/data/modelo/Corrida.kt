package com.diogo.f1racecalendar.data.modelo

data class Corrida (
    val nome: String,
    val data: String,
    val hora: String,
    val localizacao: String,
    val pais: String,
    val mapaUrl: String
)
