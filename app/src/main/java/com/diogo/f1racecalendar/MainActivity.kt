package com.diogo.f1racecalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavType
import androidx.navigation.compose.*

import com.diogo.f1racecalendar.ui.ecras.DetalhesCorridaScreen
import com.diogo.f1racecalendar.ui.ecras.HomeScreen
import com.diogo.f1racecalendar.ui.theme.F1RaceCalendarTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.diogo.f1racecalendar.data.preferences.ModoEscuro
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val temaCor = ModoEscuro(applicationContext)

        lifecycleScope.launch {
            val eModoEscuro = temaCor.modoEscuroFlow.first()

            setContent {
                var modoEscuroAtivado by remember { mutableStateOf(eModoEscuro) }

                F1RaceCalendarTheme (darkTheme = modoEscuroAtivado){
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "home"){
                        composable ("home"){
                            HomeScreen(
                                navController = navController,
                                
                            )
                        }
                    }
                }
            }
        }

        setContent {
            F1RaceCalendarTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(navController)
                    }

                    composable(
                        route = "detalhes/{nome}/{data}/{hora}/{localizacao}/{pais}/{mapaUrl}",
                        arguments = listOf(
                            navArgument("nome") { type = NavType.StringType },
                            navArgument("data") { type = NavType.StringType },
                            navArgument("hora") { type = NavType.StringType },
                            navArgument("localizacao") { type = NavType.StringType },
                            navArgument("pais") { type = NavType.StringType },
                            navArgument("mapaUrl"){type = NavType.StringType}
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


