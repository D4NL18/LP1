package racobafoda.lp1;
import java.util.Scanner;
public class main {
    
    public static int menu(){
        Scanner es = new Scanner(System.in);
        System.out.println("Querido usuário diga o que deseja fazer nessa rodada:");
        System.out.println("1-Atacar\n2-Ataque Especial\n3-Mover");
        int escolha = es.nextInt();
        return escolha;
    }
    

	public static void main(String[] args) {
                int op,op2,escolha;
                Magos m1 = new Magos("Dr. Estranho");
                Magos m2 = new Magos("Toge Inumaki");
                Personagem[] listaPer = new Personagem[2];
                listaPer[0]=m1;
                listaPer[1]=m2;
                Scanner ler = new Scanner(System.in);
                System.out.println("Querido usuário, digite a opção de campo que você deseja:");
                System.out.println("1=10x10");
                System.out.println("2=12x12");
                System.out.println("3=15x15");
		op = ler.nextInt();
		Tabuleiro tabu = new Tabuleiro(op);
                
            
                for(int i=0;i<listaPer.length;i++){
                    System.out.println("Usuário digite as coordenadas da peça que você deseja colocar:");
                    tabu.imprimir();
                    op=ler.nextInt();
                    op2=ler.nextInt();
                    if(tabu.inserir(listaPer[i],op,op2)==1);
                    else{
                        System.out.println("Não é possível inserir uma peça nessa posição");
                        i--;
                    }
                }
                tabu.imprimir();
                
                //botar um while aqui para acabar o jogo
                System.out.println("Querido usuário, digite as coordenadas da peça que você deseja executar a ação:");
                op=ler.nextInt();
                op2=ler.nextInt();
                escolha = menu();
                if(escolha==1){
                    tabu.tabu[op][op2].atacar(m2);
                }else if(escolha==2){
                    tabu.tabu[op][op2].ataqEsp(m2);
                }else if(escolha==3){
                    tabu.movimentar(op, op2);
                }
                tabu.imprimir();
                
                
                
                
       }

}


