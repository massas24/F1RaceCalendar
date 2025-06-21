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
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import android.content.Intent
import android.provider.CalendarContract
import android.net.Uri
import android.content.Context
import androidx.compose.ui.platform.LocalContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesCorridaScreen(
    navController: NavController,
    nome: String,
    data: String,
    hora: String,
    localizacao: String,
    pais: String
) {
    val nomeDecoded = URLDecoder.decode(nome, StandardCharsets.UTF_8.toString())
    val dataDecoded = URLDecoder.decode(data, StandardCharsets.UTF_8.toString())
    val horaDecoded = URLDecoder.decode(hora, StandardCharsets.UTF_8.toString())
    val localizacaoDecoded = URLDecoder.decode(localizacao, StandardCharsets.UTF_8.toString())
    val paisDecoded = URLDecoder.decode(pais, StandardCharsets.UTF_8.toString())
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
            Text(text = nome, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "📅 Data: $dataDecoded")
            Text(text = "🕒 Hora: $horaDecoded")
            Text(text = "📍 Local: $localizacaoDecoded")
            Text(text = "🏁 País: $paisDecoded")
            Spacer(modifier = Modifier.height(24.dp))

            Button
        }
    }
}


fun abrirMapa(context: Context, localizacao: String, pais: String) {
    val uri = Uri.parse("geo:0,0?q=${Uri.encode("$localizacao, $pais")}")
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.setPackage("com.google.android.apps.maps")
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}