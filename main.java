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
    
    public static boolean validaAtaq(Personagem per,int x ,int y, int ax,int ay){
        
        int range=per.getRange();
            if(ax-x<=range || ay-y<=range) return true;
            else return false;
       
    }
    
   
    

	public static void main(String[] args) {
                int op,op2,escolha,tipoTabu,x,y;
                
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
		tipoTabu = ler.nextInt();
		Tabuleiro tabu = new Tabuleiro(tipoTabu);
                
                
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
                
                
                //TODO: BIG WHILE
                System.out.println("Querido usuário, digite as coordenadas da peça que você deseja executar a ação:");
                op=ler.nextInt();
                op2=ler.nextInt();
                //TODO: While com menu para caso o usuário execute algum erro
                //TODO: if()player1 && if()player2
                //TODO: validação das pecas de cada jogador
                escolha = menu();
                if(escolha==1){
                   System.out.println("Digite as coordenadas da peça que você deseja atacar");
                   x=ler.nextInt();
                   y=ler.nextInt();
                    if(tipoTabu==1){
                       if(validaAtaq(tabu.tabu[op][op2],op,op2,x,y) && tabu.tabu[x][y]!=null){
                           tabu.tabu[op][op2].atacar(tabu.tabu[x][y]);
                       }
                            
                    }else if(tipoTabu==2){
                        if(validaAtaq(tabu.tabu2[op][op2],op,op2,x,y) && tabu.tabu2[x][y]!=null){
                            tabu.tabu2[op][op2].atacar(tabu.tabu2[x][y]);
                        }
                            
                    }else if(tipoTabu==3){
                        if(validaAtaq(tabu.tabu3[op][op2],op,op2,x,y) && tabu.tabu3[x][y]!=null){
                            tabu.tabu3[op][op2].atacar(tabu.tabu3[x][y]);
                        }
                            
                    }
                    
                }else if(escolha==2){
                    System.out.println("Digite as coordenadas da peça que você deseja atacar");
                    x=ler.nextInt();
                    y=ler.nextInt();
                    if(tipoTabu==1){
                        if(validaAtaq(tabu.tabu[x][y],op,op2,x,y) && tabu.tabu[x][y]!=null){
                            tabu.tabu[op][op2].ataqEsp(tabu.tabu[x][y]);
                        }
                            
                    }else if(tipoTabu==2){
                        if(validaAtaq(tabu.tabu2[op][op2],op,op2,x,y) && tabu.tabu2[x][y]!=null){
                            tabu.tabu2[op][op2].ataqEsp(tabu.tabu2[x][y]);
                        }
                            
                    }else if(tipoTabu==3){
                        if(validaAtaq(tabu.tabu3[op][op2],op,op2,x,y) && tabu.tabu3[x][y]!=null){
                            tabu.tabu3[op][op2].ataqEsp(tabu.tabu3[x][y]);
                        }
                            
                    }
                }else if(escolha==3){
                    tabu.movimentar(op, op2);
                }
                tabu.imprimir();
                
                
               
                
                
       }

}


