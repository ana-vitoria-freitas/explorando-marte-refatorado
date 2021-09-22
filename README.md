# Explorando Marte: refatoração

O código acima é uma versão simples do que foi pedido [nesse desafio](https://gist.github.com/elo7-developer/1a40c96a5d062b69f02c).

## Classes

- **Direção
  * Contém apenas o atributo ```direcao``` que representaria a orientação ```N,E,S,W```;
  * O método ```retornaDirecaoValida``` trata se o input do usuário é válido dentro das quatros orientações possíveis.
- **Posição
  * Contém os atributos ```posicaoAltura, posicaoLargura e direcao``` que representam a sonda a abstraindo apenas pela sua posição;
  * Métodos getters e setters compõe essa classe;
  * Métodos ```estaNaAreaDelimitada, possuiPosicaoNegativa, chocouComOutraSonda``` servem para verificar se a sonda ultrapassou a área delimitada, se na movimentação alcançou uma posição negativa e se outra sonda está na mesma posição que a sonda atual, respectivamente.
- **Terreno
  * Atributos ```altura e largura``` que representam as dimensões do terreno;
  * Métodos getters de altura, largura e área foram implementados;
  * Método de verificação se as dimensões do terreno são válidas.
- **Movimento
  * Atributo ```sequenciaMovimentos``` representa a String que contém a sequencia de passos que a sonda deverá executar;
  * Método ```retornaRotacaoMovimento``` é a base para a lógica implementada de movimentação da sonda;
  * Método ```moveNaDirecao``` serve para movimentar a sonda em uma unidade seja na largura ou altura, de acordo com a orientação (N,E,S,W);
  * Método ```movimentaSonda``` itera sobre a string que contém a sequência de movimentos e rotaciona ou movimenta a sonda em uma unidade, dependendo se o comando for ```L - rotaciona para a esquerda```, ```R - rotaciona para a direita``` ou ```M - movimenta em uma unidade segundo sua orientação```.
- **MensagemErro
  * Métodos ```sondaForaTerreno, sondaChocouComOutra, terrenoDimensoesInvalidas``` exibem na tela mensagens que indicam o que aconteceu durante a execução do código
- **Main
  * Executa o programa em si, o interrompendo caso ocorra alguma situação inesperada (essas são abordadas na classe MensagemErro) e imprime a posição de cada sonda segundo a sequencia de movimentos passada pelo usuário.
