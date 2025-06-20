package com.diogo.f1racecalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.diogo.f1racecalendar.ui.ecras.DetalhesCorridaScreen
import com.diogo.f1racecalendar.ui.ecras.HomeScreen
import com.diogo.f1racecalendar.ui.theme.F1RaceCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            F1RaceCalendarTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home"){
                    composable("home"){
                        HomeScreen(navController)
                    }

                    composable(
                        route = "detalhes/{nome}/{data}/{hora}/{localizacao}/{pais}",
                        arguments = listOf(
                            navArgument("nome"){ type = NavType.StringType },
                            navArgument("data"){ type = NavType.StringType },
                            navArgument("hora"){ type = NavType.StringType },
                            navArgument("localizacao"){ type = NavType.StringType },
                            navArgument("pais"){ type = NavType.StringType },
                        )
                    ){BackStackEntry ->
                        DetalhesCorridaScreen(
                            nome = backStackEntry.arguments?.getString("nome") ?: "",
                        )
                    }
                }
            }
        }
    }
}


