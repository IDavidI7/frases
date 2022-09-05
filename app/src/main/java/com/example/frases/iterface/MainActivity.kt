package com.example.frases.iterface

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.frases.R
import com.example.frases.infra.Constants
import com.example.frases.infra.SecuriryPreferences
import com.example.frases.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var tipoFrase: String = "bola"

    private lateinit var binding: ActivityMainBinding
    var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        nameUser()

        initfilter()

        binding.bmtNewFrase.setOnClickListener {
            when (tipoFrase) {
                "bola" -> binding.frase.text = listabola()
                "fut" -> binding.frase.text = listadofut()
                else -> binding.frase.text = listafeliz()
            }
        }
        binding.imagemBola.setOnClickListener(this)
        binding.imagemBolafut.setOnClickListener(this)
        binding.imagemRostoFeliz.setOnClickListener(this)
    }

    fun listadofut(): String {
        val list = listOf<String>("Neymar", "Pele", "Messi", "CR7", "Antony", "Vitor Roch", "David willian")
        return list.random()
    }

    fun listafeliz(): String {
        val list = listOf<String>("sorrizo", "felicidade", "alegria", "dirigir uma Mclaren")
        return list.random()
    }

    fun listabola(): String {
        val list = listOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        return list.random()
    }

    override fun onClick(view: View) {


        if (view.id == R.id.bmt_newFrase) {
            contador = contador + 1
            binding.frase.text = contador.toString()
        } else if (view.id in listOf(
                R.id.imagem_bola,
                R.id.imagem_rosto_feliz,
                R.id.imagem_bolafut
            )
        ) {
            filtro(view.id)
        }
    }

    @SuppressLint("SetTextI18n")
    fun nameUser() {
        val nome = SecuriryPreferences(this).getstorage(Constants.KEY.USER_NAME)
        binding.usuario.text = "Olá, $nome"
    }

    fun initfilter() {
        binding.imagemBola.setColorFilter(ContextCompat.getColor(this, R.color.white))
    }

    fun filtro(id: Int) {
        binding.imagemBola.setColorFilter(ContextCompat.getColor(this, R.color.cor_icon))
        binding.imagemBolafut.setColorFilter(ContextCompat.getColor(this, R.color.cor_icon))
        binding.imagemRostoFeliz.setColorFilter(ContextCompat.getColor(this, R.color.cor_icon))

        if (id == R.id.imagem_bola) {
            binding.imagemBola.setColorFilter(ContextCompat.getColor(this, R.color.white))
            tipoFrase = "bola"
        } else if (id == R.id.imagem_bolafut) {
            binding.imagemBolafut.setColorFilter(ContextCompat.getColor(this, R.color.white))
            tipoFrase = "fut"
        } else if (id == R.id.imagem_rosto_feliz) {
            binding.imagemRostoFeliz.setColorFilter(ContextCompat.getColor(this, R.color.white))
            tipoFrase = "feliz"
        }
    }

}