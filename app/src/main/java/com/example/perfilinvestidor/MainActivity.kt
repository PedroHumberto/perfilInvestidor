package com.example.perfilinvestidor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tp3.QuestionsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonInit = findViewById<Button>(R.id.btnInit)
        val getName = findViewById<TextView>(R.id.lblName)

        val aviso = findViewById<TextView>(R.id.log_aviso)

        buttonInit.setOnClickListener {

            val nome = getName.text

            //teste se o nome foi preenchido
            if(nome.isEmpty()){
                Toast.makeText(this, "Digite seu nome", Toast.LENGTH_LONG).show()
            }else{
                val initIntent = Intent(this, Questions::class.java)

                initIntent.putExtra("NOME_USUARIO", "Pedro")
                startActivity(initIntent)
            }
        }
    }
}

