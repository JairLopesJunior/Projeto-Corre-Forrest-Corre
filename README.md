# Projeto-Corre-Forrest-Corre

As corridas e caminhadas são capazes de unir centenas (e até milhares!) de pessoas em torno da prática
esportiva. E não são só os atletas profissionais que participam deste evento!
Crianças, idosos e pessoas que não praticam atividades físicas também são super bem-vindas e participam
desse tipo de atividade. Pensando nisso, nosso projeto “Corre, Forrest Corre”, vamos criar um sistema para
gerenciar um evento de corrida.
Inscrição dos corredores

1) Criar uma estrutura que armazene um número de inscrição, nome, CPF, número da camiseta (P, M, G, GG,
XG, XGG) , opção de prova e se a inscrição está efetivada. Como opção de prova, o corredor pode se
cadastrar em uma das seguintes categorias: (2 pontos)
• Kids : Somente crianças até dez anos. Corrida de 100 metros.
• Caminhada 5K : Somente atletas que não querem correr, apenas caminhar 5 km.
• Corrida 5K : Corredores com um pulmão normal que corre 5 km.
• Corrida 10K : Corredores com um pulmão treinado que corre 10 km.
• Corrida 21K : Corredores com um pulmão que o prof Orlando nunca terá, o pessoal de 21 km.
2) Permitir editar todos os dados a partir do número da inscrição. (2 pontos)
Armazenar o dados
3) O programa deve gravar e ler os dados de todos os corredores em arquivo-texto com os nomes (2 pontos)
kids.txt
caminhada5k.txt
corrida5k.txt
corrida10k.txt corrida21k.txt
Validar a inscrição e listar quantas medalhas serão necessárias
4) Crie uma função para validar as inscrições, ou seja, informar quais atletas pagaram para correr. (1 ponto)
5) Crie uma função que descubra quantos atletas estão inscritos em cada categoria. Neste tipo de evento,
todos os participantes ganham uma medalha. MAS, somente participa do evento e ganha medalha os atletas
que pagarem a inscrição ( inscrição efetivada) (1 ponto)
As camisetas
6) Os corredores retiram um kit antes da largada com a camiseta do evento. Baseado nas estruturas dos
requisitos 1 e 2, e somente os que pagarem a inscrição, crie uma função que mostre o número de camisetas
necessárias por tamanho. (2 pontos)
Exemplo de saída da função:

P:
M:
G:
GG:
95 camisetas
115 camisetas
107 camisetas
89 camisetas
