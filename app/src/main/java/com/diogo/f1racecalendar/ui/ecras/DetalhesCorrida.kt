package com.diogo.f1racecalendar.ui.ecras

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesCorridaScreen(
    nome: String,
    data: String,
    hora: String,
    localizacao: String,
    pais: String
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detalhes da Corrida") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(text = nome, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "📅 Data: $data")
            Text(text = "🕒 Hora: $hora")
            Text(text = "📍 Local: $localizacao")
            Text(text = "🏁 País: $pais")
        }
    }
}