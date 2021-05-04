
public class Tabuleiro {
	private Personagem peca;
	public char visual;
	
	public void inserir(Personagem personagem, int x, int y, Tabuleiro[][] tabuleiro) {
		tabuleiro[x][y].setPeca(personagem);
	}

	public void preencher(int tam, Tabuleiro[][] tabuleiro) {
			for(int i = 0; i<tam; i++) {
				for(int j = 0; j<tam; j++) {
					tabuleiro[i][j].visual = '.';
				}
			}
		
	}
	
	public void imprimir(int tam, Tabuleiro[][] tabuleiro) {
		for(int i = 0; i<tam; i++) {
			for(int j = 0; j<tam; j++) {
				System.out.println(tabuleiro[i][j].visual);
			}
		}
		
	}
	

	public Personagem getPeca() {
		return peca;
	}

	public void setPeca(Personagem peca) {
		this.peca = peca;
	}

	
}
