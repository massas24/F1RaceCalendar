package com.diogo.f1racecalendar.ui.ecras

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height // Added import for height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Switch // Added import for Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.diogo.f1racecalendar.data.preferences.ModoEscuro
import com.diogo.f1racecalendar.data.repositorio.RepositorisDeCorridas
import com.diogo.f1racecalendar.ui.componentes.CartaoCorrida
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun HomeScreen(navController: NavController, isDarkModeEnabled: Boolean, onToggleTheme: (Boolean) -> Unit) { // Changed parameter name
    val listaCorridas = remember { RepositorisDeCorridas.buscarCorridas() }
    val contexto = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Planeador Pit Lane",
                style = MaterialTheme.typography.headlineMedium
            )
            Switch(
                checked = isDarkModeEnabled, // Using the correct parameter
                onCheckedChange = { onToggleTheme(it) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

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
                CartaoCorrida(corrida = corrida, context = contexto) {
                    val nomeEncoded = URLEncoder.encode(corrida.nome, StandardCharsets.UTF_8.toString())
                    val dataEncoded = URLEncoder.encode(corrida.data, StandardCharsets.UTF_8.toString())
                    val horaEncoded = URLEncoder.encode(corrida.hora, StandardCharsets.UTF_8.toString())
                    val localizacaoEncoded = URLEncoder.encode(corrida.localizacao, StandardCharsets.UTF_8.toString())
                    val paisEncoded = URLEncoder.encode(corrida.pais, StandardCharsets.UTF_8.toString())
                    val mapaUrlEncoded = URLEncoder.encode(corrida.mapaUrl, StandardCharsets.UTF_8.toString())


                    navController.navigate(
                        "detalhes/$nomeEncoded/$dataEncoded/$horaEncoded/$localizacaoEncoded/$paisEncoded/$mapaUrlEncoded"
                    )
                }
            }
        }
    }
}