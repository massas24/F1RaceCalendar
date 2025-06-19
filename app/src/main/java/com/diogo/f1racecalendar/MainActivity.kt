package com.diogo.f1racecalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.diogo.f1racecalendar.ui.ecras.HomeScreen
import com.diogo.f1racecalendar.ui.theme.F1RaceCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            F1RaceCalendarTheme {
                HomeScreen()
            }
        }
    }
}


