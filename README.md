# Perfil de Investidor


*Trabalho feito para faculdade de Analise e Desenvolvimento de sistemas.
Metodologia adaptada do questionário do Banco Paulista
*

Este programa é para analise de perfil de investidor através de um questionario, cada resposta vale pontos.

Para registrar as perguntas criei uma Classe Perguntas, criei uma constante onde é preenchido as perguntas criadas, e adicionada a um Array de Classe Perguntas para simular o banco de dados.

Para não ter repetições de Activity criei um unico fragment em que as perguntas são atualizadas conforme o usuario vai respondendo.

## Erros:

1 - Quando são apenas 3 perguntas, caso o Usuario tenha marcardo uma 4º anteriormente o botão mantem focado na pergunta 4. Os pontos não contam, porem é possivel prosseguir para a proxima pergunta.

