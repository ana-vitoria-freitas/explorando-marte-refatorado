package projetoSonda;

public class Terreno {
	private double altura;
	private double largura;
	
	public Terreno(int altura, int largura) {
		this.altura = altura;
		this.largura = largura;
	}

	public double getAltura() {
		return altura;
	}


	public double getLargura() {
		return largura;
	}
	
	public double getArea() {
		return altura * largura;
	}
	
	public boolean dimensoesInvalidas() {
		if(altura <= 0 || largura <= 0) {
			return true;
		}
		
		return false;
	}

	
	
}
