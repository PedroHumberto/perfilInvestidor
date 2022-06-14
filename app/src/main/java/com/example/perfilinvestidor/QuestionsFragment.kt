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
import kotlinx.android.synthetic.main.fragment_questions.*
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


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_questions, container, false)

        val proximoBtn: Button = view.findViewById(R.id.btnProximo)


        var posicao = 1
        setPerguntas(view, posicao)



        var pontos = 0

        proximoBtn.setOnClickListener {

            val txtRes1 = view.findViewById<RadioButton>(R.id.txtRes1)
            val txtRes2 = view.findViewById<RadioButton>(R.id.txtRes2)
            val txtRes3 = view.findViewById<RadioButton>(R.id.txtRes3)
            val txtRes4 = view.findViewById<RadioButton>(R.id.txtRes4)
            val txtRes5 = view.findViewById<RadioButton>(R.id.txtRes5)

            //contagem de pontos
            pontos += setPontos(view, posicao)

            if(txtRes1.isChecked || txtRes2.isChecked || txtRes3.isChecked || txtRes4.isChecked || txtRes5.isChecked){
                posicao++

                if(posicao === 10){

                    val intentPerfil = Intent(activity, Perfil::class.java)

                    intentPerfil.putExtra("PONTOS", pontos)
                    startActivity(intentPerfil)
                }else{
                    setPerguntas(view, posicao)

                }
            }else{
                val msg = "Selecione uma opção"
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
            }
        }

        return view

    }

    //CARREGA A LISTA DE PERGUNTAS
    private fun setPerguntas(view: View, mPerguntasPosicao: Int) {
        mPerguntasLista = Constants.getPerguntas()

        val pergunta: Perguntas = mPerguntasLista[mPerguntasPosicao - 1]

        val txtPergunta: TextView = view.findViewById(R.id.txtPergunta)
        val res1: TextView = view.findViewById(R.id.txtRes1)
        val res2: TextView = view.findViewById(R.id.txtRes2)
        val res3: TextView = view.findViewById(R.id.txtRes3)
        val res4: TextView = view.findViewById(R.id.txtRes4)
        val res5: TextView = view.findViewById(R.id.txtRes5)

        txtPergunta.text = pergunta!!.pergunta

        res1.text = pergunta.res1
        res2.text = pergunta.res2
        res3.text = pergunta.res3
        res4.text = pergunta.res4
        res5.text = pergunta.res5


        //VERIFICA SE EXISTE A PERGUNTA
        val invisibleRadio4: RadioButton = view.findViewById(R.id.txtRes4)
        val invisibleRadio5: RadioButton = view.findViewById(R.id.txtRes5)

        if(pergunta.res4 === null){
            invisibleRadio4.visibility = View.INVISIBLE
            invisibleRadio5.visibility = View.INVISIBLE


        }
        else if(pergunta.res5 === null){
            invisibleRadio5.visibility = View.INVISIBLE
            invisibleRadio4.visibility = View.VISIBLE
        }else{
            invisibleRadio4.visibility = View.VISIBLE
            invisibleRadio5.visibility = View.VISIBLE
        }

    }
    private fun setPontos(view: View, mPerguntasPosicao: Int): Int {
        var pontos = 0
        mPerguntasLista = Constants.getPerguntas()

        val pergunta: Perguntas? = mPerguntasLista!![mPerguntasPosicao - 1]

        val btnRes1 = view.findViewById<RadioButton>(R.id.txtRes1)
        val btnRes2 = view.findViewById<RadioButton>(R.id.txtRes2)
        val btnRes3 = view.findViewById<RadioButton>(R.id.txtRes3)
        val btnRes4 = view.findViewById<RadioButton>(R.id.txtRes4)
        val btnRes5 = view.findViewById<RadioButton>(R.id.txtRes5)

        when(pergunta!!.id){
            1, 6, 7 -> {
                if(btnRes1.isChecked){
                    pontos += 0
                }else if (btnRes2.isChecked){
                    pontos += 2
                }else if (btnRes3.isChecked){
                    pontos += 3
                }else if (btnRes4.isChecked){
                    pontos += 4
                }
            }
            2-> {
                if(btnRes1.isChecked){
                    pontos += 0
                }else if (btnRes2.isChecked){
                    pontos += 2
                }else if (btnRes3.isChecked){
                    pontos += 4
                }else if (btnRes4.isChecked){
                    pontos += 5
                }

            }
            3, 8 -> {
                if(btnRes1.isChecked){
                    pontos += 0
                }else if (btnRes2.isChecked){
                    pontos += 1
                }else if (btnRes3.isChecked){
                    pontos += 2
                }else if (btnRes4.isChecked){
                    pontos += 4
                }

            }
            4,5 -> {
                if(btnRes1.isChecked){
                    pontos += 0
                }else if (btnRes2.isChecked){
                    pontos += 2
                }else if (btnRes3.isChecked){
                    pontos += 4
                }
            }
            9 -> {
                if(btnRes1.isChecked){
                    pontos += 0
                }else if (btnRes2.isChecked){
                    pontos += 1
                }else if (btnRes3.isChecked){
                    pontos += 2
                }else if (btnRes4.isChecked){
                    pontos += 4
                }
                else if (btnRes5.isChecked){
                    pontos += 5
                }
            }

        }
        return pontos

    }

}