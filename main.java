package racobafoda.lp1;
public class main {

	public static void main(String[] args) {
		int tam = 10;
		Tabuleiro tabu = new Tabuleiro(tam);
                Magos m1 = new Magos("Dr. Estranho");
                Magos m2 = new Magos("Toge Inumaki");
            
                
                tabu.inserir(m1,1,1);
                tabu.inserir(m2,1,3);
                tabu.imprimir();
                tabu.remover(1,1);
                tabu.imprimir();
                tabu.remover(1,3);
                tabu.imprimir();
		
	}

}
