package com.diogo.f1racecalendar.ui.componentes

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diogo.f1racecalendar.data.modelo.Corrida
import android.content.Intent
import android.net.Uri

@Composable
fun CartaoCorrida(corrida: Corrida, context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { abrirMapa(context, corrida.mapaUrl) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = corrida.nome,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Data: ${corrida.data} às ${corrida.hora}")
            Text(text = "Local: ${corrida.localizacao}, ${corrida.pais}")
        }
    }
}

private fun abrirMapa(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
        //mensagem de erro
    }
}