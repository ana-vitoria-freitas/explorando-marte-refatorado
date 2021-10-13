package explorandoMarte;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		ArrayList<Posicao> sondas = new ArrayList<Posicao>();
		ArrayList<Movimento> sequenciasMovimentos = new ArrayList<Movimento>();
		int quantidadeSondas = 0;
		
		
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
			
			Posicao posicaoSonda = new Posicao(posicaoLarguraSonda, posicaoAlturaSonda, new Direcao(direcaoSonda), quantidadeSondas);
			if(!posicaoSonda.estaNaAreaDelimitada(terreno)) {
				MensagemErro.sondaForaTerreno();
				s.close();
				return;
			}
			
			System.out.println("Digite a sequência de comandos que a nave deverá realizar: ");
			String sequenciaMovimentosSonda = s.nextLine();
			
			sondas.add(new Posicao(posicaoLarguraSonda, posicaoAlturaSonda, new Direcao(direcaoSonda)));
			
			sequenciasMovimentos.add(new Movimento(sequenciaMovimentosSonda));
			quantidadeSondas++;
			
		}while(s.hasNextLine());
		
		
		for(int i = 0; i < sondas.size(); i++) {
			Posicao posicaoFinal1 = sequenciasMovimentos.get(i).movimentaSonda(sondas.get(i));
			
			if(posicaoFinal1.existeColisao(sondas)) {
				MensagemErro.sondaChocouComOutra();
			}
			
				
			System.out.println(posicaoFinal1.getPosicaoLargura() + " " + posicaoFinal1.getPosicaoAltura() + " " + Character.toUpperCase(posicaoFinal1.getDirecao().retornaDirecaoValida()));

		}
		
		
		s.close();
	}
}