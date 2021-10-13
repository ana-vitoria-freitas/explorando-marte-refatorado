package explorandoMarte;

public class Direcao {
	private char direcao;
	
	public Direcao(char direcao) {
		this.direcao = Character.toLowerCase(direcao);
	}
	
    public char retornaDirecaoValida() {
        if (direcao == 'n') {
            return 'n';
        } else if (direcao == 'e') {
            return 'e';
        } else if (direcao == 's') {
            return 's';
        } else if (direcao == 'w') {
            return 'w';
        } else {
            throw new RuntimeException();
        }
    }
	
}