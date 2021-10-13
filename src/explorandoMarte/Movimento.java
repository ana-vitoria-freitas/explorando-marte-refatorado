package explorandoMarte;

public class Movimento {
	String sequenciaMovimentos;
	
	public Movimento(String sequenciaMovimentos) {
		this.sequenciaMovimentos = sequenciaMovimentos.toLowerCase();
	}
	
	private String retornaRotacaoMovimento(Direcao d) {
		if (d.retornaDirecaoValida() == 'n') {
			return "nwse";
	    } else if (d.retornaDirecaoValida() == 'e') {
	    	return "enws";
	    } else if (d.retornaDirecaoValida() == 's') {
	        return "senw";
	    } else {
	        return "wsen";
	    }
	}
	
	
    private void moveNaDirecao(Posicao atual) {
        if (atual.getDirecao().retornaDirecaoValida() == 'n') {
        	
        	int posicaoAlturaAtual = atual.getPosicaoAltura();
            atual.setPosicaoAltura(posicaoAlturaAtual += 1);
            
        } else if (atual.getDirecao().retornaDirecaoValida() == 'e') {
        	
        	int posicaoLarguraAtual = atual.getPosicaoLargura();
        	atual.setPosicaoLargura(posicaoLarguraAtual += 1);
        	
        } else if (atual.getDirecao().retornaDirecaoValida() == 's') {
            
        	int posicaoAlturaAtual = atual.getPosicaoAltura();
            atual.setPosicaoAltura(posicaoAlturaAtual -= 1);
        	
        } else {
        	
        	int posicaoLarguraAtual = atual.getPosicaoLargura();
        	atual.setPosicaoLargura(posicaoLarguraAtual -= 1);
        }
    }
    
	
	public Posicao movimentaSonda(Posicao inicial) {
		int virarEsquerda = 0;
		int virarDireita = 0;
		int diferencaVirar = 0;
		String rotacao = retornaRotacaoMovimento(inicial.getDirecao());
		
		int posicaoLarguraFinal = inicial.getPosicaoLargura();
		int posicaoAlturaFinal = inicial.getPosicaoAltura();
		char direcaoFinal = inicial.getDirecao().retornaDirecaoValida();
		Posicao posicaoFinal = new Posicao(posicaoLarguraFinal, posicaoAlturaFinal, new Direcao(direcaoFinal));
		
		for(char c : sequenciaMovimentos.toCharArray()) {
			
			if(c == 'l') {
				virarEsquerda++;
			}else if(c == 'r') {
				virarDireita++;
			}else if(c == 'm') {
				moveNaDirecao(posicaoFinal);
			}else {
				throw new IllegalArgumentException("Movimento inesperado: " + c);
			}
			
			
			diferencaVirar = virarEsquerda - virarDireita;
			
			if(diferencaVirar >= 0) {
				direcaoFinal = rotacao.charAt(diferencaVirar % 4);
				posicaoFinal.setDirecao(new Direcao(direcaoFinal));
				
			}else if(diferencaVirar < -4) {
				direcaoFinal = rotacao.charAt((-1 * diferencaVirar) % 4);
				posicaoFinal.setDirecao(new Direcao(direcaoFinal));
				
			}else {
				direcaoFinal = rotacao.charAt((4 + diferencaVirar) % 4);
				posicaoFinal.setDirecao(new Direcao(direcaoFinal));
				
			}
		}
		
		return posicaoFinal;
		
	}
	
	

}