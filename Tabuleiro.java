package racobafoda.lp1;
import java.util.Scanner;

public class Tabuleiro {

    

    
        public Tabuleiro(int op){
            this.op = op;
        }
            
        private int op;
        
        public Personagem[][] tabu = new Personagem[10][10];
        public Personagem[][] tabu2 = new Personagem[12][12];
        public Personagem[][] tabu3 = new Personagem[15][15];
       
       
	public int inserir(Tabuleiro t,Personagem personagem, int x, int y) {
            
            if(t.descobreTabu(t)[x][y]==null){
                    t.descobreTabu(t)[x][y] = personagem;
                    t.descobreTabu(t)[x][y].visual = personagem.visual;
                    return 1;
                }else{
                    System.out.println("Deu erro no inserir");
                    return 0;
                }
	}
        
        public void remover(Tabuleiro t, int x, int y){
            
            if(t.descobreTabu(t)[x][y]!=null){
                t.descobreTabu(t)[x][y]=null;
                }else System.out.println("Deu erro no remover");
            
            
        }
	
	public void imprimir(Tabuleiro t) {
            
            for(int i = 0; i<t.descobreTabu(t).length; i++) {
			for(int j = 0; j<t.descobreTabu(t).length; j++) {
				if(t.descobreTabu(t)[i][j]==null){
                                    System.out.print(". ");
                                }else{
                                    System.out.print(t.descobreTabu(t)[i][j].getVisual());
                                }
			}
                        System.out.println();
		}
            

	}

        public void movimentar(Tabuleiro t,int x, int y){
            Scanner ler = new Scanner(System.in);
            int nx,ny;
            
            if(t.descobreTabu(t)[x][y]!=null) {
                    System.out.println("Digite para onde você deseja mover a peça: ");
                    nx = ler.nextInt();
                    ny = ler.nextInt();
                    if((nx==x+1 || nx==x-1 || nx==x) && (ny==y-1 || ny==y+1 || ny==y)){
                        if(t.descobreTabu(t)[nx][ny]==null){
                        inserir(t,t.descobreTabu(t)[x][y],nx,ny);
                        remover(t,x,y);
                        }else{
                        System.out.println("Não é possível inserir uma peça nesse local, insira uma coordenada válida");
                        movimentar(t,x,y);
                        }
                    }else{
                        System.out.println("Não é possível inserir uma peça nesse local, insira uma coordenada válida");
                        movimentar(t,x,y);
                    }
                }else System.out.println("As coordenadas digitadas não são válidas, digite outra peça para mover");

        }
        
        
       public Personagem[][] descobreTabu(Tabuleiro tabu){
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
