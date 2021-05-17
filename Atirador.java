package racobafoda.lp1;


public class Atirador extends Personagem {
    
    private boolean espAtirador = false;
    
    public Atirador(String nome) {
        super(nome);
        this.setVida(100);
        this.setDefesa(10);
        this.setRange(3);
        this.setDano(15);
        this.setItem(false);
        if(this.getNome()=="Legolas")this.setVisual("A1");
        else if(this.getNome()=="Cj")this.setVisual("A2");
        
    }
    
    @Override
    public void atacar(Tabuleiro tabu, Personagem pAtacado,int x, int y){
 
        if(!this.getItem()){
            
            if(this.getNome()=="Legolas"){
                System.out.println(this.getNome()+" retira da sua aljava uma flecha"
                + "e com seu arco atira-a, ferindo "+pAtacado.getNome()+".");
            }
            else if(this.getNome()=="Cj"){
                System.out.println("Eu sou um maníaco com uma arma. "+this.getNome()+" atira em "+pAtacado.getNome());
            }
              
            pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa())/100));

            if(pAtacado.getVida()>0)System.out.println("Foi causado "+ (this.getDano() * (100 - pAtacado.getDefesa())/100) +" de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
            
            else{
                System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                tabu.remover(tabu, x, y);
            }
            
        }
    }
    
        
    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pAtacado,int x, int y){
	    this.setRange(4);
	    if(this.getNome() == "Legolas"){
                System.out.println(this.getNome() + " concentrou-se e com sua visão élfica pode enxergar além das barreiras humanas e ataca "+pAtacado.getNome());
                pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa())/100));
                this.setRange(3);
            }
            
	    else if(this.getNome() == "Cj"){
                System.out.println("Você quer um buraco na sua cabeça, otário! "+this.getNome()+" atira em "+pAtacado.getNome());
                pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa())/100));
                this.setRange(3);
            }
	    

        	
    }
        
}

