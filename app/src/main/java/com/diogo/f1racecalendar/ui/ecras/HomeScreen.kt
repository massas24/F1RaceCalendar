package com.diogo.f1racecalendar.ui.ecras

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.diogo.f1racecalendar.data.repositorio.RepositorisDeCorridas
import com.diogo.f1racecalendar.ui.componentes.CartaoCorrida

@Composable
fun HomeScreen(navController: NavController) {
    val listaCorridas = remember { RepositorisDeCorridas.buscarCorridas() }
    val contexto = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Calendário F1 2025",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(listaCorridas) { corrida ->
            CartaoCorrida(corrida = corrida, context = contexto)
        }
    }
}

