package racobafoda.lp1;


public class Tabuleiro {

    
        public Tabuleiro(int op){
            this.op = op;
        }
        private int op;
        private Personagem[][] tabu = new Personagem[10][10];
        private Personagem[][] tabu2 = new Personagem[12][12];
        private Personagem[][] tabu3 = new Personagem[15][15];
       
	public void inserir(Personagem personagem, int x, int y) {
            if(op==1){
                if(tabu[x][y]==null){
                tabu[x][y] = personagem;
                tabu[x][y].visual = personagem.visual;
                }else System.out.println("Deu erro no inserir");
            }else if(op==2){
                if(tabu2[x][y]==null){
                tabu2[x][y] = personagem;
                tabu2[x][y].visual = personagem.visual;
                }else System.out.println("Deu erro no inserir");
            }else if(op==3){
                if(tabu3[x][y]==null){
                tabu3[x][y] = personagem;
                tabu3[x][y].visual = personagem.visual;
                }else System.out.println("Deu erro no inserir");
            }
            
		
	}
        
        public void remover(int x, int y){
            if(op==1){
                if(tabu[x][y]!=null){
                tabu[x][y]=null;
                }else System.out.println("Deu erro no remover");
            }else if(op==2){
                if(tabu2[x][y]!=null){
                tabu2[x][y]=null;
                }else System.out.println("Deu erro no remover");
            }else if(op==3){
                if(tabu3[x][y]!=null){
                tabu3[x][y]=null;
                }else System.out.println("Deu erro no remover");
            }
            
        }
	
	public void imprimir() {
            if(op==1){
                for(int i = 0; i<tabu.length; i++) {
			for(int j = 0; j<tabu.length; j++) {
				if(tabu[i][j]==null){//by dev pedrao
                                    System.out.print('.');
                                }else{
                                    System.out.print(tabu[i][j].getVisual());
                                }
			}
                        System.out.println();
		}
            }else if(op==2){
                for(int i = 0; i<tabu2.length; i++) {
			for(int j = 0; j<tabu2.length; j++) {
				if(tabu2[i][j]==null){//by dev pedrao
                                    System.out.print('.');
                                }else{
                                    System.out.print(tabu2[i][j].getVisual());
                                }
			}
                        System.out.println();
		}
            }else if(op==3){
                for(int i = 0; i<tabu3.length; i++) {
			for(int j = 0; j<tabu3.length; j++) {
				if(tabu3[i][j]==null){//by dev pedrao
                                    System.out.print('.');
                                }else{
                                    System.out.print(tabu3[i][j].getVisual());
                                }
			}
                        System.out.println();
		}
            }
	}


       
        
        
    
        
         
	
}
