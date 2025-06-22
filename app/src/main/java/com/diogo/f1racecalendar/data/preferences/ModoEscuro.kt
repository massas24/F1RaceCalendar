package com.diogo.f1racecalendar.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.edit

private val Context.dataStore by preferencesDataStore(name = "definições")

class ModoEscuro(private val context: Context) {
    companion object{
        val DARK_MODE_KEY = booleanPreferencesKey("modo escuro ativado")
    }


    val modoEscuroFlow: Flow<Boolean> = context.dataStore.data
        .map{preferences ->
            preferences[DARK_MODE_KEY] ?: false

        }

    suspend fun setModoEscuro(ativado: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[DARK_MODE_KEY] = ativado
        }
    }
}