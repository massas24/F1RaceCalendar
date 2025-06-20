package com.diogo.f1racecalendar.ui.ecras

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
            
        }
    }
}