
public class main {

	public static void main(String[] args) {
		int tam = 10;
		Tabuleiro[][] tabuleiro = new Tabuleiro[tam][tam];
		
		tabuleiro.preencher(10, tabuleiro);
		tabuleiro.imprimir(10, tabuleiro);
	}

}
