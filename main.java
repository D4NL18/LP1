package racobafoda.lp1;
import java.util.Scanner;
import java.util.Random;
public class main {
    static int cont1=1;
    static int cont2=1;
    public static int menu(Personagem per){
        
        System.out.println("Essa peça é do tipo "+per.getClass().getSimpleName());
        Scanner es = new Scanner(System.in);
        
        if(per instanceof Mago){
        System.out.println("Querido usuário diga o que deseja fazer nessa rodada:");
        System.out.println("1-Atacar (+1 de mana)\n2-Ataque Especial (2 de mana)\n3-Mover\n4-Equipar Item\n");
        System.out.println("Quandidade de mana = "+((Mago)per).getMana());
        }
        else{
        System.out.println("Querido usuário diga o que deseja fazer nessa rodada:");
        System.out.println("1-Atacar\n2-Ataque Especial\n3-Mover\n4-Equipar Item");
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
         if(per instanceof Mago){
           if(((Mago) per).getMana()==2)return true;
           return false;
        }
         return true;
    }
    
    public static boolean checarFimJogo(Tabuleiro tabu){
        
        
        for(int i=0;i<tabu.descobreTabu(tabu).length;i++){
            for(int j=0;j<tabu.descobreTabu(tabu).length;j++){
                if(tabu.descobreTabu(tabu)[i][j]!=null){
                    if(Integer.parseInt(tabu.descobreTabu(tabu)[i][j].getVisual().substring(1))==1) cont1++;
                    else if(Integer.parseInt(tabu.descobreTabu(tabu)[i][j].getVisual().substring(1))==2) cont2++;
                }
            }
        }
        if(cont1==0 || cont2==0){
            cont1=0;
            cont2=0;
            return true;
        }
        else{
            cont1=0;
            cont2=0;
            return false;
        }
    }

    /*public static Item sorteiaItem(Player j){
        Random random = new Random();
        int rand = random.nextInt(10);
        
        if(rand<5){
          ItemGenerico item= new ItemGenerico() ;
          return item;
            
        }else if(rand==5) {
          ItemMago item= new ItemMago() ;
          return item;
        
        }else if (rand==6) {
          ItemTank item= new ItemTank() ;
          return item;
       
            
         }else if(rand==7) {
         ItemGuerreiro item= new ItemGuerreiro() ;
         return item;
    
            
        }else if(rand==8) {
         ItemAtirador item= new ItemAtirador() ;
         return item;
        
            
        }else {
          ItemSuporte item= new ItemSuporte() ;
          return item;
        }
        
    }*/
	public static void main(String[] args) {
                int op,op2,escolha,tipoTabu,x,y,quantTurnos=0;
                
                
                Mago m1 = new Mago("Dr. Estranho");
                Mago m2 = new Mago("Toge Inumaki");
                ItemMago orbe = new ItemMago();
                Tank t1 = new Tank("Red Riot");
                Tank t2 = new Tank("Bulat");
                Personagem[] listaPer = new Personagem[4];
                listaPer[0]=m1;
                listaPer[1]=m2;
                listaPer[2]=t1;
                listaPer[3]=t2;
                Scanner ler = new Scanner(System.in);
                Player j1 = new Player("JOGADOR 1", 1);
                Player j2 = new Player("JOGADOR 2", 2);
                System.out.println("Querido usuário, digite a opção de campo que você deseja:");
                System.out.println("1=10x10");
                System.out.println("2=12x12");
                System.out.println("3=15x15");
		tipoTabu = ler.nextInt();
		Tabuleiro tabu = new Tabuleiro(tipoTabu);
                
                //SORTEIO DA ORDEM DO JOGO
                defineTurnoInicial(j1,j2);
                
                
                
                
                //FASE DE PREENCHIMENTO DO CAMPO
                for(int i=0;i<listaPer.length;i++){
                    if(j1.isTurno()){
                        if(i%2==0){
                            System.out.println("Usuário "+j2.getNome() +" digite as coordenadas da peça "+listaPer[i].getClass().getSimpleName() +" que você deseja colocar:");
                        }else {
                            System.out.println("Usuário "+j1.getNome() +" digite as coordenadas da peça "+listaPer[i].getClass().getSimpleName() +" que você deseja colocar:");
                        }
                    }else{
                        if(i%2==0){
                            System.out.println("Usuário "+j1.getNome() +" digite as coordenadas da peça "+listaPer[i].getClass().getSimpleName() +" que você deseja colocar:");
                        }else {
                            System.out.println("Usuário "+j2.getNome() +" digite as coordenadas da peça "+listaPer[i].getClass().getSimpleName() +" que você deseja colocar:");
                        }
                    }
                    tabu.imprimir(tabu);
                    op=ler.nextInt();
                    op2=ler.nextInt();
                    if(j1.isTurno()){
                        if(i%2==0){
                            if(tabu.inserir(tabu,listaPer[i+1],op,op2)==1);
                            else{
                                System.out.println("Não é possível inserir uma peça nessa posição");
                                 i--;
                            }
                        }else {
                            if(tabu.inserir(tabu,listaPer[i-1],op,op2)==1);
                            else{
                                System.out.println("Não é possível inserir uma peça nessa posição");
                                 i--;
                            }
                        }
                    }else{
                        if(i%2!=0){
                            if(tabu.inserir(tabu,listaPer[i],op,op2)==1);
                            else{
                                System.out.println("Não é possível inserir uma peça nessa posição");
                                 i--;
                            }
                        }else {
                            if(tabu.inserir(tabu,listaPer[i],op,op2)==1);
                            else{
                                System.out.println("Não é possível inserir uma peça nessa posição");
                                 i--;
                            }
                        }
                    }
                }
                
                tabu.imprimir(tabu);
                
                
                
              
                
                
                
                //FASE DE AÇÕES
                while(!checarFimJogo(tabu) && quantTurnos<20){
                    quantTurnos++;
                //TURNO J1
                if(checarFimJogo(tabu))break;
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
                          tabu.descobreTabu(tabu)[op][op2].atacar(tabu,tabu.descobreTabu(tabu)[x][y],x,y);
                          
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
                            if(tabu.descobreTabu(tabu)[op][op2] instanceof Guerreiro){
                                tabu.descobreTabu(tabu)[op][op2].ataqEsp(tabu,tabu.descobreTabu(tabu)[x][y],op,op2);
                            } else{
                                tabu.descobreTabu(tabu)[op][op2].ataqEsp(tabu,tabu.descobreTabu(tabu)[x][y],x,y);
                            }
                            j1.trocaTurno(j1, j2);
                        }else{
                            System.out.println("Não é possível atacar essa peça, tente novamente");
                        }
                    }else System.out.println("Você não pode usar o ataque especial no momento, tente novamente");
                          
                    
                }else if(escolha==3){
                    tabu.movimentar(tabu,op, op2);
                    j1.trocaTurno(j1, j2);
                }else if(escolha==4){
                    if(j1.inventario[0]!=null){
                    System.out.println("Selecione o item que você deseja equipar:");
                    j1.mostraInventario();
                    }else{
                        System.out.println("Você não possui itens no inventário, selecione outra opção");
                    }
                }
                tabu.imprimir(tabu);

                    }//Fecha valida peca
                else System.out.println("Essa não é uma peça válida, tente novamente selecionando uma peça do seu time");
                
                
                
                
                
                //TURNO J2
                
                }
                if(checarFimJogo(tabu))break;
                while(j2.isTurno()){
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
                          tabu.descobreTabu(tabu)[op][op2].atacar(tabu,tabu.descobreTabu(tabu)[x][y],x,y);
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
                            tabu.descobreTabu(tabu)[op][op2].ataqEsp(tabu,tabu.descobreTabu(tabu)[x][y],x,y);
                            j1.trocaTurno(j1, j2);
                        }else{
                            System.out.println("Não é possível atacar essa peça, tente novamente");
                        }
                    }else System.out.println("Você não pode usar o ataque especial no momento, tente novamente");
                            
                        
                }else if(escolha==3){
                    tabu.movimentar(tabu,op, op2);
                    j2.trocaTurno(j1, j2);
                }else if(escolha==4){
                    if(j2.inventario[0]!=null){
                    System.out.println("Selecione o item que você deseja equipar:");
                    j2.mostraInventario();
                    }else{
                        System.out.println("Você não possui itens no inventário, selecione outra opção");
                    }
                }
                tabu.imprimir(tabu);

                    }//Fecha valida peca
                else System.out.println("Essa não é uma peça válida, tente novamente selecionando uma peça do seu time");
                }//Fecha turno j2
                }
                
                System.out.println("Jogo ACABOU");
                
                
        
        }//Fecha Main menor
       
     }//Fecha Main




