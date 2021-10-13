package explorandoMarte;

import java.util.ArrayList;

public class Posicao {
	private int posicaoLargura;
	private int posicaoAltura;
	private Direcao direcao;
	private int posicaoArraySondas;
	
	public Posicao(int posicaoLargura, int posicaoAltura, Direcao direcao) {
		this.posicaoLargura = posicaoLargura;
		this.posicaoAltura = posicaoAltura;
		this.direcao = direcao;
	}
	
	public Posicao(int posicaoLargura, int posicaoAltura, Direcao direcao, int posicaoArraySondas) {
		this.posicaoLargura = posicaoLargura;
		this.posicaoAltura = posicaoAltura;
		this.direcao = direcao;
		this.posicaoArraySondas = posicaoArraySondas;
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
	
	private boolean chocouComOutraSonda(Posicao outraSonda) {
		if(posicaoAltura == outraSonda.getPosicaoAltura() && posicaoLargura == outraSonda.getPosicaoLargura()) {
			return true;
		}
		
		return false;
	}
	
	public boolean existeColisao(ArrayList<Posicao> posicoesSondas) {
		for(int i = posicaoArraySondas - 1; i >= 0; i--) {
			if(chocouComOutraSonda(posicoesSondas.get(i))) {
				return true;
			}
		}
		return false;
	}
	

	
	
}