package com.example.perfilinvestidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        var nome = findViewById<TextView>(R.id.text_nome)
        var resultado = findViewById<TextView>(R.id.txt_resultado)
        var perfil = intent.extras?.getString("NOME_USUARIO")
        var pontos = intent.extras?.getInt("PONTOS")

        nome.text = "Bem Vindo ${perfil}"


        if(pontos === 7){

            resultado.text = "parabens"


        }




    }
}


