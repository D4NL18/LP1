package racobafoda.lp1;
import java.util.Scanner;

public class Tabuleiro {

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RESET = "\u001B[0m";
    
        public Tabuleiro(){
            
        }
            
        private int op;
        
        public Personagem[][] tabu = new Personagem[10][10];
        public Personagem[][] tabu2 = new Personagem[12][12];
        public Personagem[][] tabu3 = new Personagem[15][15];
       
       
	public int inserir(Tabuleiro t,Personagem personagem, int x, int y) {//Insere um personagem no campo
            
            if(t.descobreTabu(t)[x][y]==null){
                    t.descobreTabu(t)[x][y] = personagem;
                    t.descobreTabu(t)[x][y].setVisual(personagem.getVisual());
                    return 1;
                }else{
                    
                    return 0;
                }
	}
        
        public void remover(Tabuleiro t, int x, int y){
            
            if(t.descobreTabu(t)[x][y]!=null){
                t.descobreTabu(t)[x][y]=null;
                }else System.out.println("Deu erro no remover");
            
            
        }
	
	public void imprimir(Tabuleiro t) {//Imprime se algo for diferente de nulo, caso seja igual a nulo imprime um "."
            
            for(int i = 0; i<t.descobreTabu(t).length; i++) {
			for(int j = 0; j<t.descobreTabu(t).length; j++) {
                            if(j%2==0){
				if(t.descobreTabu(t)[i][j]==null){
                                    System.out.print(ANSI_BLACK_BACKGROUND+". "+ANSI_RESET);
                                }else{
                                    System.out.print(ANSI_BLACK_BACKGROUND+t.descobreTabu(t)[i][j].getVisual()+ANSI_RESET);
                                }
                            }else{
                                if(t.descobreTabu(t)[i][j]==null){
                                    System.out.print(ANSI_BLUE_BACKGROUND+". "+ANSI_RESET);
                                }else{
                                    System.out.print(ANSI_BLUE_BACKGROUND+t.descobreTabu(t)[i][j].getVisual()+ANSI_RESET);
                                }
                            }
			}
                        System.out.println();
		}
            

	}

        public void movimentar(Tabuleiro t,int x, int y){
            Scanner ler = new Scanner(System.in);
            int nx,ny;
            
            if(t.descobreTabu(t)[x][y]!=null) {
                    System.out.println("Digite para onde voc?? deseja mover a pe??a: ");
                    nx = ler.nextInt();
                    ny = ler.nextInt();
                    if((nx==x+1 || nx==x-1 || nx==x) && (ny==y-1 || ny==y+1 || ny==y)){
                        if(t.descobreTabu(t)[nx][ny]==null){
                        inserir(t,t.descobreTabu(t)[x][y],nx,ny);
                        remover(t,x,y);
                        }else{
                        System.out.println("N??o ?? poss??vel inserir uma pe??a nesse local, insira uma coordenada v??lida");
                        movimentar(t,x,y);
                        }
                    }else{
                        System.out.println("N??o ?? poss??vel inserir uma pe??a nesse local, insira uma coordenada v??lida");
                        movimentar(t,x,y);
                    }
                }else System.out.println("As coordenadas digitadas n??o s??o v??lidas, digite outra pe??a para mover");

        }
        
        
       public Personagem[][] descobreTabu(Tabuleiro tabu){//REtorna o tipo de tabuleiro que esta sendo usado
       int w=tabu.getOp();
       
       if(w==1)return tabu.tabu;
       else if(w==2)return tabu.tabu2;
       else return tabu.tabu3;
 
    }
       
     
       public void morrer(Tabuleiro t,int x,int y){
           remover(t,x,y);
       }
       
       
       
       
       
       
        public int getOp() {
            return op;
        }

        public void setOp(int op) {
            this.op = op;
        }
        
        
    
        
         
	
}
