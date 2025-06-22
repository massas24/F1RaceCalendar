package com.diogo.f1racecalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.diogo.f1racecalendar.data.preferences.ModoEscuro
import com.diogo.f1racecalendar.ui.ecras.DetalhesCorridaScreen
import com.diogo.f1racecalendar.ui.ecras.HomeScreen
import com.diogo.f1racecalendar.ui.theme.F1RaceCalendarTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var temaCor: ModoEscuro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        temaCor = ModoEscuro(applicationContext)

        setContent {
            var modoEscuroAtivado by remember { mutableStateOf(false) }

            // Carrega o valor inicial do modo escuro do DataStore
            LaunchedEffect(Unit) {
                modoEscuroAtivado = temaCor.modoEscuroFlow.first()
            }

            F1RaceCalendarTheme(darkTheme = modoEscuroAtivado) {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            navController = navController,
                            darkMode = modoEscuroAtivado,
                            onToggleTheme = { ativado ->
                                modoEscuroAtivado = ativado
                                lifecycleScope.launch {
                                    temaCor.setModoEscuro(ativado)
                                }
                            }
                        )
                    }

                    composable(
                        route = "detalhes/{nome}/{data}/{hora}/{localizacao}/{pais}/{mapaUrl}",
                        arguments = listOf(
                            navArgument("nome") { type = NavType.StringType },
                            navArgument("data") { type = NavType.StringType },
                            navArgument("hora") { type = NavType.StringType },
                            navArgument("localizacao") { type = NavType.StringType },
                            navArgument("pais") { type = NavType.StringType },
                            navArgument("mapaUrl") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        DetalhesCorridaScreen(
                            navController = navController,
                            nome = backStackEntry.arguments?.getString("nome") ?: "",
                            data = backStackEntry.arguments?.getString("data") ?: "",
                            hora = backStackEntry.arguments?.getString("hora") ?: "",
                            localizacao = backStackEntry.arguments?.getString("localizacao") ?: "",
                            pais = backStackEntry.arguments?.getString("pais") ?: "",
                            mapaUrl = backStackEntry.arguments?.getString("mapaUrl") ?: ""
                        )
                    }
                }
            }
        }
    }
}
