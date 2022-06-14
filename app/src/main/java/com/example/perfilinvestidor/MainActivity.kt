package com.example.perfilinvestidor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonInit = findViewById<Button>(R.id.btnInit)
        val getName = findViewById<TextView>(R.id.lblName)


        buttonInit.setOnClickListener {

            val nome = getName.text

            //teste se o nome foi preenchido
            if(nome.isEmpty()){
                Toast.makeText(this, "Digite seu nome", Toast.LENGTH_LONG).show()
            }else{
                val initIntent = Intent(this, Questions::class.java)
                startActivity(initIntent)
            }
        }
    }
}

