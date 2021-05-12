package racobafoda.lp1;
import java.util.Scanner;
import java.util.Random;
public class main {
    
    public static int menu(Personagem per){
        System.out.println("Essa peça é do tipo "+per.getClass().getSimpleName());
        Scanner es = new Scanner(System.in);
        System.out.println("Querido usuário diga o que deseja fazer nessa rodada:");
        System.out.println("1-Atacar\n2-Ataque Especial\n3-Mover");
    
        if(per instanceof Magos){
           System.out.println("Quandidade de mana = "+((Magos)per).getMana());
        }
        
        
        int escolha = es.nextInt();
        return escolha;
    }
    
    public static boolean validaAtaq(Tabuleiro tabu,int x ,int y, int ax,int ay){
        int range;
            range=tabu.descobreTabu(tabu)[x][y].getRange();
            if(ax-x<=range || ay-y<=range) return true;
            return false;

    }
    
    public static void defineTurnoInicial(Player j1, Player j2){
        Random random = new Random();
        int sorteio = random.nextInt(2);
        if(sorteio==0){
            j1.setTurno(true);
            j2.setTurno(false);
            
        }else{
            j1.setTurno(false);
            j2.setTurno(true);
        }
    }
    
    public static boolean validaEsp(Personagem per){
         if(per instanceof Magos){
           if(((Magos) per).getMana()==3)return true;
           return false;
        }
         return false;
    }
    
//    public static boolean checarFimJogo(int quantTurnos){
//        
//        System.out.println("Qunatidade de turnos é " +quantTurnos);
//        //falta checar se todos os personagens de um player estão mortos
//        if(quantTurnos==15)return true ;
//        
//        return false;
//    }

	public static void main(String[] args) {
                int op,op2,escolha,tipoTabu,x,y,quantTurnos=13;
                
                
                Magos m1 = new Magos("Dr. Estranho");
                Magos m2 = new Magos("Toge Inumaki");
                Personagem[] listaPer = new Personagem[2];
                listaPer[0]=m1;
                listaPer[1]=m2;
                Scanner ler = new Scanner(System.in);
                Player j1 = new Player("Carlos", 1);
                Player j2 = new Player("Joao", 2);
                System.out.println("Querido usuário, digite a opção de campo que você deseja:");
                System.out.println("1=10x10");
                System.out.println("2=12x12");
                System.out.println("3=15x15");
		tipoTabu = ler.nextInt();
		Tabuleiro tabu = new Tabuleiro(tipoTabu);
                
                
                
                
                //FASE DE PREENCHIMENTO DO CAMPO
                for(int i=0;i<listaPer.length;i++){
                    System.out.println("Usuário digite as coordenadas da peça que você deseja colocar:");
                    tabu.imprimir(tabu);
                    op=ler.nextInt();
                    op2=ler.nextInt();
                    if(tabu.inserir(tabu,listaPer[i],op,op2)==1);
                    else{
                        System.out.println("Não é possível inserir uma peça nessa posição");
                        i--;
                    }
                }
                tabu.imprimir(tabu);
                
                
                
                //SORTEIO DA ORDEM DO JOGO
                defineTurnoInicial(j1,j2);
                
                
                
                
                
                
                //FASE DE AÇÕES
                while(quantTurnos!=20){
                    quantTurnos++;
                //TURNO J1
                while(j1.isTurno()){
                System.out.println("Querido usuário 1 digite as coordenadas da peça que você deseja executar a ação:");
                op=ler.nextInt();
                op2=ler.nextInt();
                
                if(j1.validaPeca(tabu,op,op2)){
                    
                escolha = menu(tabu.descobreTabu(tabu)[op][op2]);
                if(escolha==1){
                   System.out.println("Digite as coordenadas da peça que você deseja atacar");
                   x=ler.nextInt();
                   y=ler.nextInt();
                   
                       if(validaAtaq(tabu,op,op2,x,y) && tabu.descobreTabu(tabu)[x][y]!=null){
                          tabu.descobreTabu(tabu)[op][op2].atacar(tabu.descobreTabu(tabu)[x][y]);
                          
                           j1.trocaTurno(j1, j2);
                       }else{
                           System.out.println("Não é possível atacar essa peça, tente novamente");
                       }
                            
                       
                }else if(escolha==2){
                    if(validaEsp(tabu.descobreTabu(tabu)[op][op2])){
                    System.out.println("Digite as coordenadas da peça que você deseja atacar");
                    x=ler.nextInt();
                    y=ler.nextInt();
                    
                        if(validaAtaq(tabu,op,op2,x,y) && tabu.descobreTabu(tabu)[x][y]!=null){
                            tabu.descobreTabu(tabu)[op][op2].ataqEsp(tabu.descobreTabu(tabu)[x][y]);
                            j1.trocaTurno(j1, j2);
                        }else{
                            System.out.println("Não é possível atacar essa peça, tente novamente");
                        }
                    }else System.out.println("Você não pode usar o ataque especial no momento, tente novamente");
                          
                    
                }else if(escolha==3){
                    tabu.movimentar(tabu,op, op2);
                    j1.trocaTurno(j1, j2);
                }
                tabu.imprimir(tabu);

                    }//Fecha valida peca
                else System.out.println("Essa não é uma peça válida, tente novamente selecionando uma peça do seu time");
                
                
                
                
                
                //TURNO J2
                }while(j2.isTurno()){
                System.out.println("Querido usuário 2 digite as coordenadas da peça que você deseja executar a ação:");
                op=ler.nextInt();
                op2=ler.nextInt();
                
                if(j2.validaPeca(tabu,op,op2)){
         
              
                escolha = menu(tabu.descobreTabu(tabu)[op][op2]);
                if(escolha==1){
                   System.out.println("Digite as coordenadas da peça que você deseja atacar");
                   x=ler.nextInt();
                   y=ler.nextInt();
                   
                       if(validaAtaq(tabu,op,op2,x,y) && tabu.descobreTabu(tabu)[x][y]!=null){
                          tabu.descobreTabu(tabu)[op][op2].atacar(tabu.descobreTabu(tabu)[x][y]);
                           j1.trocaTurno(j1, j2);
                       }else{
                           System.out.println("Não é possível atacar essa peça, tente novamente");
                       }
                            
                       
                }else if(escolha==2){
                    if(validaEsp(tabu.descobreTabu(tabu)[op][op2])){
                    System.out.println("Digite as coordenadas da peça que você deseja atacar");
                    x=ler.nextInt();
                    y=ler.nextInt();
                    
                        if(validaAtaq(tabu,op,op2,x,y) && tabu.descobreTabu(tabu)[x][y]!=null){
                            tabu.descobreTabu(tabu)[op][op2].ataqEsp(tabu.descobreTabu(tabu)[x][y]);
                            j1.trocaTurno(j1, j2);
                        }else{
                            System.out.println("Não é possível atacar essa peça, tente novamente");
                        }
                    }else System.out.println("Você não pode usar o ataque especial no momento, tente novamente");
                            
                        
                }else if(escolha==3){
                    tabu.movimentar(tabu,op, op2);
                    j1.trocaTurno(j1, j2);
                }
                tabu.imprimir(tabu);

                    }//Fecha valida peca
                else System.out.println("Essa não é uma peça válida, tente novamente selecionando uma peça do seu time");
                }//Fecha turno j2
                }
                System.out.println("Jogo ACABOU");
                
                
        
        }//Fecha Main menor
       
     }//Fecha Main




