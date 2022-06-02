package com.example.tp3

import model.Perguntas

object Constants {


    fun getPerguntas(): ArrayList<Perguntas> {
        val listaPerguntas = ArrayList<Perguntas>()

        val q1 = Perguntas(
            1,
            "Por quanto tempo você pretende deixar seu dinheiro investido?",
            "Menos de 6 meses",
            "Entre 6 meses e 1 ano",
            "Entre 1 ano e 3 anos",
            "Acima de 3 anos",
        )
        listaPerguntas.add(q1)


        val q2 = Perguntas(
            2,
            "Qual o objetivo desse investimento?",
            "Preservação do capital para não perder valor ao longo do tempo, assumindo baixos riscos de perdas",
            "Aumento gradual do capital ao longo do tempo, assumindo riscos moderados",
            "Aumento do capital acima da taxa de retorno média do mercado, mesmo que isso implique assumir riscos de perdas elevadas",
            "Obter no curto prazo retornos elevados e significativamente  acima da taxa de retorno média do mercado, assumindo riscos elevados",
        )
        listaPerguntas.add(q2)

        val q3 = Perguntas(
            3,
            "Qual das alternativas melhor classifica sua formação e experiência com o mercado financeiro?",
            "Não possuo formação acadêmica ou conhecimento do mercado financeiro",
            "Possuo formação acadêmica na área financeira, mas não tenho experiência com o mercado financeiro",
            "Possuo formação acadêmica em outra área, mas possuo conhecimento do mercado financeiro",
            "Possuo formação acadêmica na área financeira ou pleno conhecimento do mercado financeiro",
        )
        listaPerguntas.add(q3)

        val q4 = Perguntas(
            4,
            ". Considerando seus rendimentos regulares, qual a porcentagem você pretende reservar para aplicações financeiras?",
            "No máximo 25%",
            "Entre 25,01 e 50%",
            "Acima de 50%",
            null,
        )
        listaPerguntas.add(q4)

        val q5 = Perguntas(
            5,
            "Caso as suas aplicações sofressem uma queda superior a 30%, o que você faria? ",
            "Resgataria toda a aplicação e aplicaria na poupança",
            "Manteria aplicação aguardando uma melhora do mercado ",
            "Aumentaria a aplicação para aproveitar as oportunidades do mercado",
            null,
        )
        listaPerguntas.add(q5)

        val q6 = Perguntas(
            6,
            "Como está distribuído o seu patrimônio?",
            "Meu patrimônio não está aplicado ou está todo aplicado em renda fixa e/ou imóveis ",
            "Menos de 25% em renda variável e o restante em renda fixa e/ou imóveis",
            "Entre 25,01 e 50% aplicado em renda variável e o restante em renda fixa e/ou imóveis",
            "Acima de 50% em renda variável",
        )
        listaPerguntas.add(q6)

        val q7 = Perguntas(
            7,
            "7. Em relação as aplicações e rendimentos, em qual dessas situações você se enquadra? ",
            "Conto com o rendimento dessas aplicações para complementar minha renda mensal ",
            "Eventualmente posso resgatar parte das aplicações para fazer frente aos meus gastos. Contudo, não tenho intenção de resgatar no curto prazo e pretendo fazer aplicações regulares",
            "Não tenho intenção de resgatar no curto prazo, mas não pretendo realizar novas aplicações",
            "Não tenho intenção de resgatar no curto prazo e ainda pretendo fazer aplicações regulares",
        )
        listaPerguntas.add(q7)



        return listaPerguntas
    }
}