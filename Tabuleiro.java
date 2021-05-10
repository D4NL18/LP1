package racobafoda.lp1;


public class Tabuleiro {

    
        public Tabuleiro(int tam){
            this.tam = tam;
        }
        private int tam=10;
        private Personagem[][] tabu = new Personagem[tam][tam];
       
        
	public void inserir(Personagem personagem, int x, int y) {
		tabu[x][y] = personagem;
                tabu[x][y].visual = personagem.visual;
	}
        
        public void remover(int x, int y){
            if(tabu[x][y]!=null){
                tabu[x][y]=null;
            }
        }

	
	public void imprimir() {
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
	}


       
        
        public int getTam() {
        return tam;
        }
        public void setTam(int tam) {
            this.tam = tam;
        }
    
        
         
	
}
