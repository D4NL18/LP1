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
       
       
	public int inserir(Personagem personagem, int x, int y) {
            if(getOp()==1){
                if(tabu[x][y]==null){
                    tabu[x][y] = personagem;
                    tabu[x][y].visual = personagem.visual;
                    return 1;
                }else{
                    System.out.println("Deu erro no inserir");
                    return 0;
                }
            }else if(getOp()==2){
                if(tabu2[x][y]==null){
                    tabu2[x][y] = personagem;
                    tabu2[x][y].visual = personagem.visual;
                    return 1;
                }else{
                    System.out.println("Deu erro no inserir");
                    return 0;
                }
            }else if(getOp()==3){
                if(tabu3[x][y]==null){
                    tabu3[x][y] = personagem;
                    tabu3[x][y].visual = personagem.visual;
                    return 1;
                }else{
                    System.out.println("Deu erro no inserir");
                    return 0;
                }
            }
            return 0;
	}
        
        public void remover(int x, int y){
            if(getOp()==1){
                if(tabu[x][y]!=null){
                tabu[x][y]=null;
                }else System.out.println("Deu erro no remover");
            }else if(getOp()==2){
                if(tabu2[x][y]!=null){
                tabu2[x][y]=null;
                }else System.out.println("Deu erro no remover");
            }else if(getOp()==3){
                if(tabu3[x][y]!=null){
                tabu3[x][y]=null;
                }else System.out.println("Deu erro no remover");
            }
            
        }
	
	public void imprimir() {
            if(getOp()==1){
                for(int i = 0; i<tabu.length; i++) {
			for(int j = 0; j<tabu.length; j++) {
				if(tabu[i][j]==null){
                                    System.out.print(". ");
                                }else{
                                    System.out.print(tabu[i][j].getVisual());
                                }
			}
                        System.out.println();
		}
            }else if(getOp()==2){
                for(int i = 0; i<tabu2.length; i++) {
			for(int j = 0; j<tabu2.length; j++) {
				if(tabu2[i][j]==null){
                                    System.out.print(". ");
                                }else{
                                    System.out.print(tabu2[i][j].getVisual());
                                }
			}
                        System.out.println();
		}
            }else if(getOp()==3){
                for(int i = 0; i<tabu3.length; i++) {
			for(int j = 0; j<tabu3.length; j++) {
				if(tabu3[i][j]==null){
                                    System.out.print(". ");
                                }else{
                                    System.out.print(tabu3[i][j].getVisual());
                                }
			}
                        System.out.println();
		}
            }
            
	}

        public void movimentar(int x, int y){
            Scanner ler = new Scanner(System.in);
            int nx,ny;
            if(getOp()==1){           
                if(tabu[x][y]!=null) {
                    System.out.println("Digite para onde você deseja mover a peça: ");
                    nx = ler.nextInt();
                    ny = ler.nextInt();
                    if((nx==x+1 || nx==x-1 || nx==x) && (ny==y-1 || ny==y+1 || ny==y)){
                        if(tabu[nx][ny]==null){
                        inserir(tabu[x][y],nx,ny);
                        remover(x,y);
                        }else{
                        System.out.println("Não é possível inserir uma peça nesse local, insira uma coordenada válida");
                        movimentar(x,y);
                        }
                    }else{
                        System.out.println("Não é possível inserir uma peça nesse local, insira uma coordenada válida");
                        movimentar(x,y);
                    }
                }else System.out.println("As coordenadas digitadas não são válidas, digite outra peça para mover");
                
            }else if(getOp()==2){      
                if(tabu2[x][y]!=null) {
                    System.out.println("Digite para onde você deseja mover a peça: ");
                    nx = ler.nextInt();
                    ny = ler.nextInt();
                    if((nx==x+1 || nx==x-1 || nx==x) && (ny==y-1 || ny==y+1 || ny==y)){
                        if(tabu2[nx][ny]==null){
                        inserir(tabu2[x][y],nx,ny);
                        remover(x,y);
                        }else{
                        System.out.println("Não é possível inserir uma peça nesse local, insira uma coordenada válida");
                        movimentar(x,y);
                        }
                    }else{
                        System.out.println("Não é possível inserir uma peça nesse local, insira uma coordenada válida");
                        movimentar(x,y);
                    }
                }else System.out.println("As coordenadas digitadas não são válidas, digite outra peça para mover");  
                
            }else if(getOp()==3){             
                if(tabu3[x][y]!=null) {
                    System.out.println("Digite para onde você deseja mover a peça: ");
                    nx = ler.nextInt();
                    ny = ler.nextInt();
                    if((nx==x+1 || nx==x-1 || nx==x) && (ny==y-1 || ny==y+1 || ny==y)){
                        if(tabu3[nx][ny]==null){
                        inserir(tabu3[x][y],nx,ny);
                        remover(x,y);
                        }else{
                        System.out.println("Não é possível inserir uma peça nesse local, insira uma coordenada válida");
                        movimentar(x,y);
                        }
                    }else{
                        System.out.println("Não é possível inserir uma peça nesse local, insira uma coordenada válida");
                        movimentar(x,y);
                    }

                }else System.out.println("As coordenadas digitadas não são válidas, digite outra peça para mover");
            }
            
        }
        
        
     
        public int getOp() {
            return op;
        }

        public void setOp(int op) {
            this.op = op;
        }
        
        
    
        
         
	
}
