package com.example.perfilinvestidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        var resultado = findViewById<TextView>(R.id.txt_resultado)

        var pontos = intent.extras?.getInt("PONTOS")



        resultado.text = perfilInvestidor(pontos!!)
        resultado.textSize = 26f

    }

    private fun perfilInvestidor(pontos: Int): String? {
        var meuPerfil: String? = null
        if(pontos!! <= 12){
          meuPerfil = "Seu perfil é Conservador"
        }
        else if(pontos!! > 12 && pontos!! <= 29){
            meuPerfil = "Seu Perfil é Moderado"
        }
        else if(pontos!! >= 30){
            meuPerfil = "Seu Perfil é Arrojado"
        }
        return meuPerfil
    }
}


