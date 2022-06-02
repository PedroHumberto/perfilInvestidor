package com.example.tp3


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.perfilinvestidor.Perfil
import com.example.perfilinvestidor.R
import model.Perguntas


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionsFragment : Fragment() {


    private var mPerguntasLista: ArrayList<Perguntas> = Constants.getPerguntas()

    private var mPerguntaSelecionada: Int = 0

   @RequiresApi(Build.VERSION_CODES.O)
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

       var view = inflater.inflate(R.layout.fragment_questions, container, false)

       val proximoBtn: Button = view.findViewById(R.id.btnProximo)

       val contagem = view.findViewById<TextView>(R.id.contagem)


       setPerguntas(view, 1)

       var posicao = 1

       var pontos = 0
       proximoBtn.setOnClickListener {

           val txtRes1 = view.findViewById<RadioButton>(R.id.txtRes1)
           val txtRes2 = view.findViewById<RadioButton>(R.id.txtRes2)
           val txtRes3 = view.findViewById<RadioButton>(R.id.txtRes3)
           val txtRes4 = view.findViewById<RadioButton>(R.id.txtRes4)

           //contagem de pontos
           if(txtRes1.isChecked){
               pontos += 1
           }else if (txtRes2.isChecked){
               pontos += 2
           }else if (txtRes3.isChecked){
               pontos += 3
           }else if (txtRes4.isChecked){
               pontos += 4
           }

           if(txtRes1.isChecked || txtRes2.isChecked || txtRes3.isChecked || txtRes4.isChecked){
               posicao++

               if(posicao === 8){

                   val intentPerfil = Intent(activity, Perfil::class.java)

                   intentPerfil.putExtra("PONTOS", pontos)
                   startActivity(intentPerfil)
               }else{
                   setPerguntas(view, posicao)
                   contagem.text = "$pontos"
               }
           }else{
               var msg = "Selecione uma opção"
               Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
           }

       }


       return view


   }


    private fun setPerguntas(view: View, mPerguntasPosicao: Int) {
        mPerguntasLista = Constants.getPerguntas()

        val pergunta: Perguntas? = mPerguntasLista!![mPerguntasPosicao - 1]

        val txtPergunta: TextView = view.findViewById(R.id.txtPergunta)
        val res1: TextView = view.findViewById(R.id.txtRes1)
        val res2: TextView = view.findViewById(R.id.txtRes2)
        val res3: TextView = view.findViewById(R.id.txtRes3)
        val res4: TextView = view.findViewById(R.id.txtRes4)

        txtPergunta.text = pergunta!!.pergunta

        val invisibleRadio3: RadioButton = view.findViewById(R.id.txtRes3)
        val invisibleRadio4: RadioButton = view.findViewById(R.id.txtRes4)


            res1.text = pergunta.res1
            res2.text = pergunta.res2
            res3.text = pergunta.res3
            res4.text = pergunta.res4

        if(pergunta.res3 === null){
            invisibleRadio3.visibility = View.INVISIBLE
            invisibleRadio4.visibility = View.INVISIBLE
        }
        else if(pergunta.res4 === null){
            invisibleRadio4.visibility = View.INVISIBLE
        }



    }




}