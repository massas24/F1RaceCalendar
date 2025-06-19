package com.diogo.f1racecalendar.data.repositorio

import com.diogo.f1racecalendar.data.modelo.Corrida


object RepositorisDeCorridas {
    fun buscarCorridas(): List<Corrida> = listOf(
        Corrida( //pus o nome das variaveis so no primeiro para ver
            nome = "GP da Austrália ",
            data = "16/03/2025",
            hora = "04:00(hora portugal)",
            localizacao = "Melbourne",
            pais = "Austrália",
            mapaUrl = "https://maps.app.goo.gl/nujCfX6pvP1UBca68",

        ),
        Corrida("GP China", "", "", "", "China", ""),
        Corrida("GP Japão", "", "", "", "Japão", ""),
        Corrida("GP Barém", "", "", "", "Barém", ""),
        Corrida("GP Arábia Saudita", "", "", "", "Arábia Saudita", ""),
        Corrida("GP Miami", "", "", "", "ESA", ""),
        Corrida("GP Ímola", "", "", "", "Itália", ""),
        Corrida("GP Mônaco", "", "", "", "Mõnaco", ""),
        Corrida("GP Espanha", "", "", "", "Espanha", ""),
        Corrida("GP Canadá", "", "", "", "Canadá", ""),
        Corrida("GP Áustria", "", "", "", "Áustria", ""),
        Corrida("GP Grã-Bretanha", "", "", "", "Inglaterra", ""),
        Corrida("GP Bélgica", "", "", "", "Bélgica", ""),
        Corrida("GP Hungria", "", "", "", "Hungria", ""),
        Corrida("GP Países Baixos", "", "", "", "Países Baixos", ""),
        Corrida("GP Itália", "", "", "", "Itália", ""),
        Corrida("GP Azerbaijão", "", "", "", "Azerbaijão", ""),
        Corrida("GP Singapura", "", "", "", "Singapura", ""),
        Corrida("GP Estados Unidos", "", "", "", "EUA", ""),
        Corrida("GP México", "", "", "", "México", ""),
        Corrida("GP São Paulo", "", "", "", "Brasil", ""),
        Corrida("GP Las Vegas", "", "", "", "EUA", ""),
        Corrida("GP Catar", "", "", "", "Catar", ""),
        Corrida("GP Abu Dhabi", "", "", "", "EAU", "")
    )
}