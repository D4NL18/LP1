package racobafoda.lp1;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
public class main {
    static int cont1=1;
    static int cont2=1;
    public static int menu(Personagem per){
        
        System.out.println("Essa peca eh do tipo "+per.getClass().getSimpleName());
        Scanner es = new Scanner(System.in);
        
        if(per instanceof Mago){//se for um amigo tem menu especifico
        System.out.println("Querido usuario diga o que deseja fazer nessa rodada:");
        System.out.println("1-Atacar (+1 de mana)\n2-Ataque Especial (2 de mana)\n3-Mover\n4-Equipar Item\n");
        System.out.println("Quandidade de mana = "+((Mago)per).getMana());
        }else if(per instanceof Suporte){// se for sacerdote tem um menu especifico
        System.out.println("Querido usuario diga o que deseja fazer nessa rodada:");
        System.out.println("1-Curar (+1 de mana)\n2-Ataque Especial (2 de mana)\n3-Mover\n4-Equipar Item\n");
        System.out.println("Quandidade de mana = "+((Suporte)per).getMana());
        }
        else{
        System.out.println("Querido usuario diga o que deseja fazer nessa rodada:");
        System.out.println("1-Atacar\n2-Ataque Especial\n3-Mover\n4-Equipar Item");
        }
        
        
        int escolha = es.nextInt();
        return escolha;
    }
    
    public static boolean validaAtaq(Tabuleiro tabu,int op ,int op2, int x,int y){
        int range;
        if(tabu.descobreTabu(tabu)[x][y]!=null){ //valida se o modulo da diferenca entre a posição do inimigo e da peca que vai atacar ta dentro do range da peca que vai atacar
            range=tabu.descobreTabu(tabu)[x][y].getRange();
            if(Math.abs(x-op)<=range || Math.abs(y-op2)<=range) return true;
        }
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
    
    public static boolean validaEsp(Personagem per){//Validacao dos pre requisitos do ataque especial de algumas classes
        if(per instanceof Mago){
           if(((Mago) per).getMana()==2)return true;
           return false;
        }
        if(per instanceof Suporte){
            if(((Suporte) per).getMana()==2)return true;
            return false;
         }
         if(per instanceof Atirador){
             if(((Atirador) per).getRange()==3){
                 per.setRange(4);
                 return true;
             }
             return false;
         }
         return true;
    }
    
    public static boolean checarFimJogo(Tabuleiro tabu){//checa a quantidade de pecas que terminam com 1 ou 2 no campo, e soma um contador referente a cada peca.
        
        
        for(int i=0;i<tabu.descobreTabu(tabu).length;i++){
            for(int j=0;j<tabu.descobreTabu(tabu).length;j++){
                if(tabu.descobreTabu(tabu)[i][j]!=null && !(tabu.descobreTabu(tabu)[i][j] instanceof Obstaculo)) {
                    if(Integer.parseInt(tabu.descobreTabu(tabu)[i][j].getVisual().substring(1))==1) cont1++;
                    else if(Integer.parseInt(tabu.descobreTabu(tabu)[i][j].getVisual().substring(1))==2) cont2++;
                }
            }
        }
        if(cont1==0 || cont2==0){
            if(cont1==0)System.out.println("O jogador 2 ganhou o jogo");
            else if(cont2==0)System.out.println("O jogador 1 ganhou o jogo");
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

    public static void faseDePreenchimentoPedras(Tabuleiro tabu,int tipoTabu, Personagem pedra){
        tabu.inserir(tabu, pedra, 2, 2);
                    tabu.inserir(tabu, pedra, 2, 3);
                    if(tipoTabu==1){
                    tabu.inserir(tabu, pedra, 7, 6);
                    tabu.inserir(tabu, pedra, 7, 7);
                    }else if(tipoTabu==2){
                    tabu.inserir(tabu, pedra, 3, 2);
                    tabu.inserir(tabu, pedra, 3, 3);
                    tabu.inserir(tabu, pedra, 9, 9);
                    tabu.inserir(tabu, pedra, 9, 8);
                    tabu.inserir(tabu, pedra, 8, 8);
                    tabu.inserir(tabu, pedra, 8, 9);
                    }else if(tipoTabu==3){
                    tabu.inserir(tabu, pedra, 3, 2);
                    tabu.inserir(tabu, pedra, 3, 3);
                    tabu.inserir(tabu, pedra, 6, 6);
                    tabu.inserir(tabu, pedra, 6, 7);
                    tabu.inserir(tabu, pedra, 6, 8);
                    tabu.inserir(tabu, pedra, 7, 6);
                    tabu.inserir(tabu, pedra, 7, 7);
                    tabu.inserir(tabu, pedra, 7, 8);
                    tabu.inserir(tabu, pedra, 8, 6);
                    tabu.inserir(tabu, pedra, 8, 7);
                    tabu.inserir(tabu, pedra, 8, 8);
                    tabu.inserir(tabu, pedra, 12, 12);
                    tabu.inserir(tabu, pedra, 12, 11);
                    tabu.inserir(tabu, pedra, 11, 11);
                    tabu.inserir(tabu, pedra, 11, 12);
                    }
    }
   
    public static void equipaItemClasse(Player j1,Player j2, int escolha, Tabuleiro tabu, int op, int op2){
        //Pega a classe do personagem selecionado e compara com a do item, se for igual ele equipa o item
        
                    if(j1.inventario[escolha] instanceof ItemGuerreiro && tabu.descobreTabu(tabu)[op][op2] instanceof Guerreiro){
                             System.out.println("Item Equipado!");
                             j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                             j1.trocaTurno(j1, j2);
                    }else if(j1.inventario[escolha] instanceof ItemMago && tabu.descobreTabu(tabu)[op][op2] instanceof Mago){
                             System.out.println("Item Equipado!");
                             j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                             j1.trocaTurno(j1, j2);
                    }else if(j1.inventario[escolha] instanceof ItemTank && tabu.descobreTabu(tabu)[op][op2] instanceof Tank){
                             System.out.println("Item Equipado!");    
                             j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                             j1.trocaTurno(j1, j2);
                    }else if(j1.inventario[escolha] instanceof ItemSuporte && tabu.descobreTabu(tabu)[op][op2] instanceof Suporte){
                        System.out.println("Item Equipado!");   
                             j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                             j1.trocaTurno(j1, j2);
                    }else if(j1.inventario[escolha] instanceof ItemGenerico){
                        System.out.println("Item Equipado!");    
                             j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                             j1.trocaTurno(j1, j2);
                    }else if(j1.inventario[escolha] instanceof itemAtirador && tabu.descobreTabu(tabu)[op][op2] instanceof Atirador){
                            System.out.println("Item Equipado!");    
                            j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                            j1.trocaTurno(j1, j2);
                    }else{
                        System.out.println("Nao eh possi­vel equipar esse item, pois ele nao eh da classe do personagem selecionado, tente novamente");
                    }                   
                        
    }
	
    public static void main(String[] args) throws IOException {
                int op,op2,escolha,tipoTabu,x,y,quantTurnos=0;
                
                
                Mago m1 = new Mago("Dr. Estranho");
                Mago m2 = new Mago("Toge Inumaki");
                Tank t1 = new Tank("Red Riot");
                Tank t2 = new Tank("Bulat");
                Suporte s1 = new Suporte("Tsunade");
                Suporte s2 = new Suporte("Sage");
                Atirador a1 = new Atirador("Legolas");
                Atirador a2 = new Atirador("Cj");
                Guerreiro g1 = new Guerreiro("Zoro");
                Guerreiro g2 = new Guerreiro("Kratos");
                Personagem[] listaPer = new Personagem[10];
                listaPer[0]=m1;
                listaPer[1]=m2;
                listaPer[2]=t1;
                listaPer[3]=t2;
                listaPer[4]=s1;
                listaPer[5]=s2;
                listaPer[6]=a1;
                listaPer[7]=a2;
                listaPer[8]=g1;
                listaPer[9]=g2;
         
                Obstaculo pedra = new Obstaculo();
                Scanner ler = new Scanner(System.in);
                System.out.println("Querido usuario 1 digite seu nome:");
                String nome = ler.nextLine();
                Player j1 = new Player(nome, 1);
                System.out.println("Querido usuario 2 digite seu nome:");
                nome = ler.nextLine();
                Player j2 = new Player(nome, 2);
                System.out.println("Querido usuario, digite a opcao de campo que voce deseja:");
                System.out.println("1=10x10");
                System.out.println("2=12x12");
                System.out.println("3=15x15");
		tipoTabu = ler.nextInt();
		Tabuleiro tabu = new Tabuleiro(tipoTabu);
                
                //RECEBIMENTO DE ITENS DO ARQUIVO PARA O PLAYER
                j1.inicioArquivo(); 
                j2.inicioArquivo();
                
                
                
                
                //SORTEIO DA ORDEM DO JOGO
                defineTurnoInicial(j1,j2);
                
                
                //FASE DE PREENCHIMENTO DO CAMPO
                faseDePreenchimentoPedras(tabu,tipoTabu,pedra);
                for(int i=0;i<listaPer.length;i++){//insere a lista de personagens sempre na mesma ordem no campo
                    
                    if(j1.isTurno()){
                        if(i%2==0){
                            System.out.println("Usuario "+j2.getNome() +" digite as coordenadas da peca "+listaPer[i].getClass().getSimpleName() +" que voceª deseja colocar:");
                        }else {
                            System.out.println("Usuario "+j1.getNome() +" digite as coordenadas da peca "+listaPer[i].getClass().getSimpleName() +" que voceª deseja colocar:");
                        }
                    }else{
                        if(i%2==0){
                            System.out.println("Usuario "+j1.getNome() +" digite as coordenadas da peca "+listaPer[i].getClass().getSimpleName() +" que voceª deseja colocar:");
                        }else {
                            System.out.println("Usuario "+j2.getNome() +" digite as coordenadas da peca "+listaPer[i].getClass().getSimpleName() +" que voceª deseja colocar:");
                        }
                    }
                    tabu.imprimir(tabu);
                    op=ler.nextInt();
                    op2=ler.nextInt();
                    if(j1.isTurno()){
                        if(i%2==0){
                            if(tabu.inserir(tabu,listaPer[i+1],op,op2)==1);
                            else{
                                System.out.println("Nao eh possi­vel inserir uma peca nessa posicao");
                                 i--;
                            }
                        }else {
                            if(tabu.inserir(tabu,listaPer[i-1],op,op2)==1);
                            else{
                                System.out.println("Nao eh possi­vel inserir uma peca nessa posicao");
                                 i--;
                            }
                        }
                    }else{
                        if(i%2!=0){
                            if(tabu.inserir(tabu,listaPer[i],op,op2)==1);
                            else{
                                System.out.println("Nao eh possi­vel inserir uma peca nessa posicao");
                                 i--;
                            }
                        }else {
                            if(tabu.inserir(tabu,listaPer[i],op,op2)==1);
                            else{
                                System.out.println("Nao eh possi­vel inserir uma peca nessa posicao");
                                 i--;
                            }
                        }
                    }
                }
                
                tabu.imprimir(tabu);
                
                
                
              
                
                
                
                //FASE DE ACOES
                while(!checarFimJogo(tabu) && quantTurnos<2){ //checa a existencia de alguma peca no campo e valida a quantidade de turnos atual
                    
                    quantTurnos++;
                //TURNO J1
                if(checarFimJogo(tabu))break;
                
                while(j1.isTurno()){
                System.out.println("Querido "+ j1.getNome()+ " digite as coordenadas da peca que voce deseja executar a acao:");
                op=ler.nextInt();
                op2=ler.nextInt();
                
                if(j1.validaPeca(tabu,op,op2)){//Valida se a peca selecionada eh a do proprio Player, para isso a funcao valida peca olha se a substring da (segue abaixo)
                                                //posicao 1 do atributo "visual" de cada peca eh igual ao numero do player
                escolha = menu(tabu.descobreTabu(tabu)[op][op2]);
                if(escolha==1){//Selecionado Ataque
                   System.out.println("Digite as coordenadas da peca que voce deseja atacar");
                   x=ler.nextInt();
                   y=ler.nextInt();
                   
                       if(validaAtaq(tabu,op,op2,x,y) && tabu.descobreTabu(tabu)[x][y]!=null){//validaAtaq vê se a pessoa esta dentro do range do atacante e (continua abaixo)
                          tabu.descobreTabu(tabu)[op][op2].atacar(tabu,tabu.descobreTabu(tabu)[x][y],x,y);//tabu.descobre(Tabu)=tipo do tabuleiro e essa mesma variavel com uma posicao [x][y] retorna o personagem daquela posicao, nesse caso o atacado
                          if(tabu.descobreTabu(tabu)[x][y]==null){//Checou se apos o ataque o inimigo foi eliminado
                              System.out.println("Voce conseguiu uma recompensa por eliminar o inimigo");
                              j1.guardaItem(j1.sorteiaItem());//Sorteia um item aleatorio como recompensa e armazena no inventario do player
                              System.out.println("Agora seu inventario eh:");
                              j1.mostraInventario();
                          }
                           j1.trocaTurno(j1, j2);//Troca turno permite ao outro usuario jogar agora, e esta sendo usado como a validacao de um turno interiramente correto
                       }else{
                           System.out.println("Nao eh possivel atacar essa pca, tente novamente");
                       }
                            
                       //0-Armadura
                       //1-Orbe
                }else if(escolha==2){//Selecionado Ataque Especial
                    if(validaEsp(tabu.descobreTabu(tabu)[op][op2])){//Faz uma validacao especifica dos prerequisitos para usar o ataque especial de determinadas pecas caso exista
                    System.out.println("Digite as coordenadas da peca que voceª deseja atacar");
                    x=ler.nextInt();
                    y=ler.nextInt();
                    
                        if(validaAtaq(tabu,op,op2,x,y) && tabu.descobreTabu(tabu)[x][y]!=null){//valida o ataque igual no ataque normal
                            if(tabu.descobreTabu(tabu)[op][op2] instanceof Guerreiro){
                                tabu.descobreTabu(tabu)[op][op2].ataqEsp(tabu,tabu.descobreTabu(tabu)[x][y],op,op2);
                            } else{
                                tabu.descobreTabu(tabu)[op][op2].ataqEsp(tabu,tabu.descobreTabu(tabu)[x][y],x,y);
                            }
                            if(tabu.descobreTabu(tabu)[x][y]==null){
                              System.out.println("Voceª conseguiu uma recompensa por eliminar um inimigo");
                              j1.guardaItem(j1.sorteiaItem());
                              System.out.println("Agora seu inventario eh:");
                              j1.mostraInventario();
                            } 
                            j1.trocaTurno(j1, j2);
                        }else{
                            System.out.println("Nao eh possi­vel atacar essa peca, tente novamente");
                        }
                    }else System.out.println("Voce nao pode usar o ataque especial no momento, tente novamente");
                          
                    
                }else if(escolha==3){//Selecionado Movimento
                    tabu.movimentar(tabu,op, op2);//Movimenta uma peca do tabuleiro 
                    j1.trocaTurno(j1, j2);
                }else if(escolha==4){//Selecionado Equipar Item
                    if(j1.inventario[0]!=null){//Caso exista algo dentro do inventario ele segue
                    System.out.println("Selecione o item que voceª deseja equipar:");
                    j1.mostraInventario();
                    escolha=ler.nextInt();
                    equipaItemClasse(j1,j2,escolha,tabu,op,op2);//Escrevi o que a funcao faz dentro dela
                    }else{
                        System.out.println("Voce nao possui itens no inventario, selecione outra opcao");
                    }
                }
                tabu.imprimir(tabu);

                    }//Fecha valida peca
                else System.out.println("Essa nao eh uma peca valida, tente novamente selecionando uma peca do seu time");
                
                
                
                
                
                //TURNO J2
                //a mesma documentacao do J1 (player 1)
                }
                if(checarFimJogo(tabu))break;
                while(j2.isTurno()){
                System.out.println("Querido "+j2.getNome()+" digite as coordenadas da peca que voceª deseja executar a acao:");
                op=ler.nextInt();
                op2=ler.nextInt();
                
                if(j2.validaPeca(tabu,op,op2)){
         
              
                escolha = menu(tabu.descobreTabu(tabu)[op][op2]);
                if(escolha==1){
                   System.out.println("Digite as coordenadas da pecaa que voce deseja atacar");
                   x=ler.nextInt();
                   y=ler.nextInt();
                   
                       if(validaAtaq(tabu,op,op2,x,y) && tabu.descobreTabu(tabu)[x][y]!=null){
                          tabu.descobreTabu(tabu)[op][op2].atacar(tabu,tabu.descobreTabu(tabu)[x][y],x,y);
                          if(tabu.descobreTabu(tabu)[x][y]==null){
                              System.out.println("Voce conseguiu uma recompensa por eliminar o inimigo");
                              j2.guardaItem(j2.sorteiaItem());
                              System.out.println("Agora seu inventario eh:");
                              j2.mostraInventario();
                          }
                           j1.trocaTurno(j1, j2);
                       }else{
                           System.out.println("Nao eh possi­vel atacar essa peca, tente novamente");
                       }
                            
                       
                }else if(escolha==2){
                    if(validaEsp(tabu.descobreTabu(tabu)[op][op2])){
                    System.out.println("Digite as coordenadas da peca que voce deseja atacar");
                    x=ler.nextInt();
                    y=ler.nextInt();
                    
                        if(validaAtaq(tabu,op,op2,x,y) && tabu.descobreTabu(tabu)[x][y]!=null){
                           if(tabu.descobreTabu(tabu)[op][op2] instanceof Guerreiro){
                                tabu.descobreTabu(tabu)[op][op2].ataqEsp(tabu,tabu.descobreTabu(tabu)[x][y],op,op2);
                            } else{
                                tabu.descobreTabu(tabu)[op][op2].ataqEsp(tabu,tabu.descobreTabu(tabu)[x][y],x,y);
                            }
                            if(tabu.descobreTabu(tabu)[x][y]==null){
                              System.out.println("Voce conseguiu uma recompensa por eliminar um inimigo");
                              j2.guardaItem(j2.sorteiaItem());
                              System.out.println("Agora seu inventario eh:");
                              j2.mostraInventario();
                          }
                            j1.trocaTurno(j1, j2);
                        }else{
                            System.out.println("Nao eh possi­vel atacar essa peca, tente novamente");
                        }
                    }else System.out.println("Voce nao pode usar o ataque especial no momento, tente novamente");
                            
                        
                }else if(escolha==3){
                    tabu.movimentar(tabu,op, op2);
                    j2.trocaTurno(j1, j2);
                }else if(escolha==4){
                    if(j2.inventario[0]!=null){
                    System.out.println("Selecione o item que voce deseja equipar:");
                    j2.mostraInventario();
                    escolha=ler.nextInt();
                    equipaItemClasse(j2,j1,escolha,tabu,op,op2);
                    }else{
                        System.out.println("Voce nÃ£o possui itens no inventario, selecione outra opcao");
                    }
                }
                tabu.imprimir(tabu);

                    }//Fecha valida peca
                else System.out.println("Essa nao eh uma peca vÃalida, tente novamente selecionando uma peca do seu time");
                }//Fecha turno j2
                }
                
                
                j1.fimArquivo();
                j2.fimArquivo();
                System.out.println("O inventario de cada jogador foi armazenado para uma futura batalha!");
                
                
                
        
        }//Fecha Main menor
       
     }//Fecha Main





