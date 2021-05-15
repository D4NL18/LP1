package racobafoda.lp1;
public class Tank extends Personagem{
	
	boolean espTank = false;
	
	//=================================================================================
	//																				 ||
	//							DEIXAR NO FINAL DA MAIN                              ||
	// 																				 ||
	//OBS:                 if(t1.espTank) t1.setDefesa(25);                          ||
   // 					   else if(t2.espTank) t2.setDefesa(25);                     ||
   //																				 ||
   //==================================================================================
	
	
	
    public Tank(String nome) {
        super(nome);
        this.setVida(150);
        this.setDefesa(25);
        this.setRange(1);
        this.setDano(10);
        this.setItem(false);
        if(this.getNome()=="Red Riot")this.setVisual("T1");
        else if(this.getNome()=="Bulat")this.setVisual("T2");
    }
    @Override
    public void atacar(Tabuleiro tabu, Personagem pAtacado,int x, int y){
        	
    	if(this.getItem() && this.getNome() == "Red Riot") System.out.println(this.getNome() + " Bebeu a Trigger, tornando-se mais resistente");
    	else if(this.getItem() && this.getNome() == "Bulat") System.out.println(this.getNome() + " ativou a incursio, tornando-se mais resistente");
    	
            if(this.getNome()=="Red Riot")System.out.println(this.getNome()+" encheu de porrada seu inimigo: "+pAtacado.getNome());
            else if(this.getNome()=="Bulat")System.out.println(this.getNome()+" deu uma espadada em seu inimigo: "+pAtacado.getNome() + ((this.getItem()) ? " com a incursio!" : ""));
            pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa())/100));
            if(pAtacado.getVida()>0)System.out.println("Foi causado "+ (this.getDano() * (100 - pAtacado.getDefesa())/100) +" de dano ao inimigo "+pAtacado.getNome()+" ,restando "+pAtacado.getVida()+" de vida");
            else{
                System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                tabu.remover(tabu, x, y);
            }
        }
        
    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pAtacado,int x, int y){
        	if(!espTank) {
	        	this.setDefesa(100);
	        	if(this.getNome() == "Red Riot")System.out.println(this.getNome() + " ativou seu enrijecimento, tornando-se imortal por 1 rodada");
	        	else if(this.getNome() == "Bulat")System.out.println(this.getNome() + "INCURSIOOOOOOOOOOOOOOOOOO\n"
	        	+ "Bulat transformou a sua incursio em uma armadura dourada, tornando-se imortal por 1 rodada");
	        	espTank = true;
        	}
        	
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
