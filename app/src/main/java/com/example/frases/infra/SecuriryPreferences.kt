package com.example.frases.infra

import android.content.Context
import android.content.SharedPreferences

class SecuriryPreferences(context: Context) {
    private var seguranca: SharedPreferences =
        context.getSharedPreferences("Frases", Context.MODE_PRIVATE)

    fun Storage(chave: String, str: String) {
        seguranca.edit().putString(chave, str).apply()
    }

    fun getstorage(chave: String): String {
        return seguranca.getString(chave, "") ?: ""
    }
}