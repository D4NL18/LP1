package racobafoda.lp1;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
                Magos m1 = new Magos("Dr. Estranho");
                Magos m2 = new Magos("Toge Inumaki");
                Scanner ler = new Scanner(System.in);
                System.out.println("Querido usuário, digite a opção de campo que você deseja:");
                System.out.println("1=10x10");
                System.out.println("2=12x12");
                System.out.println("3=15x15");
		int op = ler.nextInt();
		Tabuleiro tabu = new Tabuleiro(op);
                
            
                
                tabu.inserir(m1,1,1);
                tabu.inserir(m2,1,3);
                tabu.imprimir();
                tabu.movimentar(1, 1);
		tabu.imprimir();
	}

}
