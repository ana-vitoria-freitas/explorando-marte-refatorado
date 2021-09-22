package projetoSonda;

public class Posicao {
	private int posicaoLargura;
	private int posicaoAltura;
	private Direcao direcao;
	
	public Posicao(int posicaoLargura, int posicaoAltura, Direcao direcao) {
		this.posicaoLargura = posicaoLargura;
		this.posicaoAltura = posicaoAltura;
		this.direcao = direcao;
	}
	
	public int getPosicaoLargura() {
		return posicaoLargura;
	}

	public int getPosicaoAltura() {
		return posicaoAltura;
	}
	
	public Direcao getDirecao() {
		return direcao;
	}
	
	public void setPosicaoLargura(int posicaoLargura) {
		this.posicaoLargura = posicaoLargura;
	}

	public void setPosicaoAltura(int posicaoAltura) {
		this.posicaoAltura = posicaoAltura;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public boolean estaNaAreaDelimitada(Terreno t) {
		if(posicaoLargura > t.getLargura() || posicaoAltura > t.getAltura()) {
			return false;
		}
		return true;
	}
	
	public boolean possuiPosicaoNegativa() {
		if(posicaoAltura < 0 || posicaoLargura < 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean chocouComOutraSonda(Posicao outraSonda) {
		if(posicaoAltura == outraSonda.getPosicaoAltura() && posicaoLargura == outraSonda.getPosicaoLargura()) {
			return true;
		}
		
		return false;
	}

	
	
}
