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
		
		if(terreno.dimensoesInvalidas()) {
			MensagemErro.terrenoDimensoesInvalidas();
			s.close();
			return;
		}
		
		do {
			System.out.println("Digite a posição inicial da sonda e a sua direção (N, E, S, W)");
			int posicaoLarguraSonda = s.nextInt();
			int posicaoAlturaSonda = s.nextInt();
			char direcaoSonda = s.nextLine().charAt(1);
			
			Posicao posicaoSonda = new Posicao(posicaoLarguraSonda, posicaoAlturaSonda, new Direcao(direcaoSonda));
			if(!posicaoSonda.estaNaAreaDelimitada(terreno)) {
				MensagemErro.sondaForaTerreno();
				s.close();
				return;
			}
			
			System.out.println("Digite a sequência de comandos que a nave deverá realizar: ");
			String sequenciaMovimentosSonda = s.nextLine();
			
			sondas.add(new Posicao(posicaoLarguraSonda, posicaoAlturaSonda, new Direcao(direcaoSonda)));
			
			sequenciasMovimentos.add(new Movimento(sequenciaMovimentosSonda));
			
			
		}while(s.hasNextLine());
		
		if(sondas.size() == 1) {
			Posicao posicaoFinal = sequenciasMovimentos.get(0).movimentaSonda(sondas.get(0));
			if(!posicaoFinal.estaNaAreaDelimitada(terreno)) {
				MensagemErro.sondaForaTerreno();
				s.close();
				return;
			}
			System.out.println(posicaoFinal.getPosicaoLargura() + " " + posicaoFinal.getPosicaoAltura() + " " + Character.toUpperCase(posicaoFinal.getDirecao().retornaDirecaoValida()));

		}else {			
			for(int i = 0; i < sondas.size() - 1; i++) {
				Posicao posicaoFinal1 = sequenciasMovimentos.get(i).movimentaSonda(sondas.get(i));
				Posicao posicaoFinal2 = sequenciasMovimentos.get(i + 1).movimentaSonda(sondas.get(i + 1));
				
				if(posicaoFinal1.chocouComOutraSonda(posicaoFinal2)) {
					MensagemErro.sondaChocouComOutra();
					s.close();
					return;
				}
				System.out.println(posicaoFinal1.getPosicaoLargura() + " " + posicaoFinal1.getPosicaoAltura() + " " + Character.toUpperCase(posicaoFinal1.getDirecao().retornaDirecaoValida()));
				System.out.println(posicaoFinal2.getPosicaoLargura() + " " + posicaoFinal2.getPosicaoAltura() + " " + Character.toUpperCase(posicaoFinal2.getDirecao().retornaDirecaoValida()));


			}
		}
		
		
		s.close();
	}
}
