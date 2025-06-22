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
import androidx.compose.material3.IconButton
import androidx.navigation.NavController
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import androidx.compose.foundation.layout.* // Manter se precisar de algo específico, mas já tem Column, Spacer, etc.
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import android.content.Intent
import android.provider.CalendarContract
import android.net.Uri
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesCorridaScreen(
    navController: NavController,
    nome: String,
    data: String,
    hora: String,
    localizacao: String,
    pais: String,
    mapaUrl: String
) {
    val nomeDecoded = URLDecoder.decode(nome, StandardCharsets.UTF_8.toString())
    val dataDecoded = URLDecoder.decode(data, StandardCharsets.UTF_8.toString())
    val horaDecoded = URLDecoder.decode(hora, StandardCharsets.UTF_8.toString())
    val localizacaoDecoded = URLDecoder.decode(localizacao, StandardCharsets.UTF_8.toString())
    val paisDecoded = URLDecoder.decode(pais, StandardCharsets.UTF_8.toString())
    val mapaUrlDecoded = URLDecoder.decode(mapaUrl, StandardCharsets.UTF_8.toString())

    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detalhes da Corrida") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(text = nomeDecoded, style = MaterialTheme.typography.headlineMedium) // CORRIGIDO AQUI
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "📅 Data: $dataDecoded")
            Text(text = "🕒 Hora: $horaDecoded")
            Text(text = "📍 Local: $localizacaoDecoded")
            Text(text = "🏁 País: $paisDecoded")
            Spacer(modifier = Modifier.height(24.dp))

            //butao Adicionar Calendario
            Button(onClick = {
                adicionarEventoAoCalendario(context, nomeDecoded, dataDecoded, horaDecoded, localizacaoDecoded)
            }) {
                Text("Adicionar ao Calendário")
            }

            Spacer(modifier = Modifier.height(12.dp))

            //Botao ver no mapa
            Button(onClick = {
                abrirMapa(context, mapaUrlDecoded)
            }) {
                Text("Ver no mapa")
            }
        }
    }
}

fun adicionarEventoAoCalendario(context: Context, titulo: String, data: String, hora: String, local: String) {
    try {
        val partesData = data.split("/")
        val partesHora = hora.split(":")

        if (partesData.size == 3 && partesHora.size == 2) {
            val dia = partesData[0].toInt()
            val mes = partesData[1].toInt() - 1 // Mês é baseado em 0 (Janeiro = 0)
            val ano = partesData[2].toInt()

            val horaInt = partesHora[0].toInt()
            val minutoInt = partesHora[1].toInt()

            val inicio = Calendar.getInstance()
            inicio.set(ano, mes, dia, horaInt, minutoInt)

            val intent = Intent(Intent.ACTION_INSERT).apply {
                setData(CalendarContract.Events.CONTENT_URI)
                putExtra(CalendarContract.Events.TITLE, titulo)
                putExtra(CalendarContract.Events.EVENT_LOCATION, local)
                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, inicio.timeInMillis)
                // Assumindo que uma corrida dura cerca de 2 horas. Pode ajustar se tiver dados mais precisos.
                putExtra(
                    CalendarContract.EXTRA_EVENT_END_TIME,
                    inicio.timeInMillis + 2 * 60 * 60 * 1000
                ) // 2h em milissegundos
            }

            context.startActivity(intent)
        } else {
            // Opcional: mostrar um Toast ao utilizador se o formato da data/hora for inválido
            // Toast.makeText(context, "Erro: Formato de data/hora inválido", Toast.LENGTH_SHORT).show()
        }
    } catch (e: Exception) {
        e.printStackTrace()
        // Opcional: mostrar um Toast ao utilizador se houver um erro
        // Toast.makeText(context, "Erro ao adicionar evento ao calendário: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
    }
}

fun abrirMapa(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
        // Opcional: mostrar um Toast ao utilizador se o mapa não puder ser aberto
        // Toast.makeText(context, "Não foi possível abrir o mapa. Verifique se tem uma aplicação de mapas instalada.", Toast.LENGTH_LONG).show()
    }
}