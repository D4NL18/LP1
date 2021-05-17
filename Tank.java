package racobafoda.lp1;
public class Tank extends Personagem{
	
	boolean espTank = false;	
	
	
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
        this.setDefesa(25);
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
	        	System.out.print((this.getItem()) ? (this.getNome() + " guardou seu item para a proxima rodada\n") : "");
	        	if(this.getNome() == "Red Riot")System.out.println(this.getNome() + " ativou seu enrijecimento, tornando-se imortal até realizar um ataque");
	        	else if(this.getNome() == "Bulat")System.out.println(this.getNome() + "INCURSIOOOOOOOOOOOOOOOOOO\n"
	        	+ "Bulat transformou a sua incursio em uma armadura dourada, tornando-se imortal até realizar um ataque");
	        	espTank = true;
        	}else{
                    System.out.println("Seu especial não pode ser ativado duas vezes na mesma partida");
                }
        	
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
