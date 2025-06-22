package com.diogo.f1racecalendar.data.preferences

import androidx.datastore.preferences.core.booleanPreferencesKey

class ModoEscuro(private val context: Context) {
    companion object{
        val DARK_MODE_KEY = booleanPreferencesKey("modo escuro ativado")
    }


    val modoEscuroFlow: Flow<Boolean> = context.dataStore.data
        .map{preferences ->
            preferences[DARK_MODE_KEY] ?: false

        }
}