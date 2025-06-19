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

        ),//alguns dos nomes dos Grande Prémios(GP) uns sao o pais outros a cidade depende
        Corrida("GP China", "23/03/2025", "07:00", "Xangai", "China", "https://maps.app.goo.gl/4TixQkK4PyUr4EWPA"),
        Corrida("GP Japão", "06/04/2025", "06:00", "Suzuka", "Japão", "https://maps.app.goo.gl/FNAhoKYTicaK8xxN7"),
        Corrida("GP Barém", "13/04/2025", "16:00", "Sakhir", "Barém", "https://maps.app.goo.gl/FUcZNPDBVhfMEEnA8"),
        Corrida("GP Arábia Saudita", "20/04/2025", "18:00", "Gidá", "Arábia Saudita", "https://maps.app.goo.gl/ovXz7xtGfbxaBCvK7"),
        Corrida("GP Miami", "04/05/2025", "21:00", "Miami", "EUA", "https://maps.app.goo.gl/sQttZb8UBx98DTpe7"),
        Corrida("GP Ímola", "18/05/2025", "14:00", "Ímola", "Itália", "https://maps.app.goo.gl/WBh52acx4NaqT8GXA"),
        Corrida("GP Mônaco", "25/05/2025", "14:00", "Mônaco", "Mõnaco", "https://maps.app.goo.gl/fAxPP9pPzd3PfBau6"),
        Corrida("GP Espanha", "01/06/2025", "14:00", "Barcelona", "Espanha", "https://maps.app.goo.gl/62uKgK1y9UDNcBxB8"),
        Corrida("GP Canadá", "15/06/2025", "19:00", "Montreal", "Canadá", "https://maps.app.goo.gl/QQzSPHMGhCSkoCFM7"),
        Corrida("GP Áustria", "29/06/2025", "14:00", "Spielberg", "Áustria", "https://maps.app.goo.gl/T7qnFRTdpsbWRy6R6"),
        Corrida("GP Grã-Bretanha", "06/07/2025", "15:00", "Silverstone", "Inglaterra", "https://maps.app.goo.gl/696T71YGxKFJurNc6"),
        Corrida("GP Bélgica", "27/07/2025", "14:00", "Stavelot", "Bélgica", "https://maps.app.goo.gl/duFuQmG1jhHc5uQBA"),
        Corrida("GP Hungria", "03/08/2025", "14:00", "Mogyoród", "Hungria", "https://maps.app.goo.gl/cvzPpFdkFt7XU5wK6"),
        Corrida("GP Países Baixos", "31/08/2025", "14:00", "Zandvoort", "Países Baixos", "https://maps.app.goo.gl/oP91PbufqCtJScZD7"),
        Corrida("GP Itália", "07/09/2025", "14:00", "Monza", "Itália", "https://maps.app.goo.gl/AjaJyPcuVGEhWMY96"),
        Corrida("GP Azerbaijão", "21/09/2025", "12:00", "Bacu", "Azerbaijão", "https://maps.app.goo.gl/x83qzaob1WwgPSBg8"),
        Corrida("GP Singapura", "05/10/2025", "13:00", "Singapura", "Singapura", "https://maps.app.goo.gl/Y12wX7DiEXnMY1pY6"),
        Corrida("GP Estados Unidos", "19/10/2025", "20:00", "Austin", "EUA", "https://maps.app.goo.gl/Zp2dzmL6vfayvaNN7"),
        Corrida("GP México", "26/10/2025", "20:00", "Cidade do México", "México", "https://maps.app.goo.gl/zH1hJLcQZ5YzSjzA7"),
        Corrida("GP São Paulo", "09/11/2025", "17:00", "São Paulo", "Brasil", "https://maps.app.goo.gl/38WMsyG8JW447rdGA"),
        Corrida("GP Las Vegas", "22/11/2025", "04:00", "Las Vegas", "EUA", "https://maps.app.goo.gl/gDwzRN1bn4RCq8pU6"),
        Corrida("GP Catar", "30/11/2025", "16:00", "Lusail", "Catar", "https://maps.app.goo.gl/Bnhh9FYZ6LogimaZ7"),
        Corrida("GP Abu Dhabi", "07/12/2025", "13:00", "Abu Dhabi", "EAU", "https://maps.app.goo.gl/i7mGdbddcyyEguRD7")
    )
}