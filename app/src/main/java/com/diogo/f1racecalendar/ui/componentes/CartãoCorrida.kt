package com.diogo.f1racecalendar.ui.componentes

import android.content.Context
import android.content.Intent
import android.net.Uri // Manter se for usar Uri em algum outro lugar do Card
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diogo.f1racecalendar.data.modelo.Corrida

@Composable
fun CartaoCorrida(corrida: Corrida, context: Context, aoClicar: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { aoClicar() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = corrida.nome, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Data: ${corrida.data} às ${corrida.hora}")
            Text(text = "Local: ${corrida.localizacao}, ${corrida.pais}")
        }
    }
}

// REMOVIDA: A função abrirMapa privada não está a ser utilizada aqui.
// private fun abrirMapa(context: Context, url: String) {
//     try {
//         val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//         context.startActivity(intent)
//     } catch (e: Exception) {
//         e.printStackTrace()
//         //mensagem de erro
//     }
// }