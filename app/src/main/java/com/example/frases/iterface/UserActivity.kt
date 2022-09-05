package com.example.frases.iterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.frases.infra.Constants
import com.example.frases.R
import com.example.frases.infra.SecuriryPreferences
import com.example.frases.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private var binding: ActivityUserBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        binding?.let { view ->
            setContentView(view.root)

            view.btmSave.setOnClickListener{
                handlesave()
            }
        }

        supportActionBar?.hide()
    }

    private fun handlesave() {
        val name = binding?.editUsuario?.text.toString().trim()
        if (name != "") {

            SecuriryPreferences(this).Storage(Constants.KEY.USER_NAME, name)

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Insira seu nome!", Toast.LENGTH_SHORT).show()
        }
    }
}