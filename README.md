# Explorando Marte: refatoração

O código acima é uma versão simples do que foi pedido [nesse desafio](https://gist.github.com/elo7-developer/1a40c96a5d062b69f02c).

## Classes

- Direção
  * Contém apenas o atributo ```direcao``` que representaria a orientação ```N,E,S,W```;
  * O método ```retornaDirecaoValida``` trata se o input do usuário é válido dentro das quatros orientações possíveis.
- Posição
  * Contém os atributos ```posicaoAltura, posicaoLargura e direcao``` que representam a sonda a abstraindo apenas pela sua posição;
  * Métodos getters e setters compõe essa classe;
  * Métodos ```estaNaAreaDelimitada, possuiPosicaoNegativa, chocouComOutraSonda``` servem para verificar se a sonda ultrapassou a área delimitada, se na movimentação alcançou uma posição negativa e se outra sonda está na mesma posição que a sonda atual, respectivamente.
- Terreno
  * 
- Movimento
- MensagemErro
- Main
