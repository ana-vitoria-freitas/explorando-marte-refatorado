package projetoSonda;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		ArrayList<Posicao> sondas = new ArrayList<Posicao>();
		ArrayList<Movimento> sequenciasMovimentos = new ArrayList<Movimento>();
		
		
		System.out.println("Digite a largura e altura do terreno (separadas por espaço): ");
		int larguraTerreno = s.nextInt();
		int alturaTerreno = s.nextInt();
		
		Terreno terreno = new Terreno(alturaTerreno, larguraTerreno);
		
		do {
			System.out.println("Digite a posição inicial da sonda e a sua direção (N, E, S, W)");
			int posicaoLarguraSonda = s.nextInt();
			int posicaoAlturaSonda = s.nextInt();
			char direcaoSonda = s.nextLine().charAt(1);
			
			System.out.println("Digite a sequência de comandos que a nave deverá realizar: ");
			String sequenciaMovimentosSonda = s.nextLine();
			
			sondas.add(new Posicao(posicaoLarguraSonda, posicaoAlturaSonda, new Direcao(direcaoSonda)));
			
			sequenciasMovimentos.add(new Movimento(sequenciaMovimentosSonda));
			
			
		}while(s.hasNextLine());
		
		for(int i = 0; i < sondas.size(); i++) {
			Posicao posicaoFinal = sequenciasMovimentos.get(i).movimentaSonda(sondas.get(i));
			posicaoFinal.estaNaAreaDelimitada(terreno);
			System.out.println(posicaoFinal.getPosicaoLargura() + " " + posicaoFinal.getPosicaoAltura() + " " + Character.toUpperCase(posicaoFinal.getDirecao().retornaDirecaoValida()));
		}
		
		s.close();
	}
}
