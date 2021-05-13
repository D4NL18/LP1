package racobafoda.lp1;
public class Tank extends Personagem{
	
	private boolean espTank = false;
    
    public Tank(String nome) {
        super(nome);
        this.setVida(1);
        this.setRange(1);
        if(this.getNome()=="A")this.setVisual("T1");
        else if(this.getNome()=="B")this.setVisual("T2");
    }
    @Override
    public void atacar(Tabuleiro tabu, Personagem pAtacado,int x, int y){
        
        if(this.getNome()=="Dr. Estranho")System.out.println(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua magia");
        else if(this.getNome()=="Toge Inumaki")System.out.println(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua palavra amaldiçoada de nivel 1");
        pAtacado.setVida(pAtacado.getVida() - 3 + pAtacado.getDefesa());
        if(pAtacado.getVida()>0)System.out.println("Foi causado 3 de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
        else{
            System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
            tabu.remover(tabu, x, y);
        }
        
    }
    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pAtacado,int x, int y){
        
        
            if(this.getNome()=="Dr. Estranho")System.out.println(this.getNome()+" usou sua jóia do tempo para paralisar e atacar o inimigo: "+pAtacado.getNome());
            else if(this.getNome()=="Toge Inumaki")System.out.println(this.getNome()+" recitou sua palavra proibida e inflingou grandes danos em: "+pAtacado.getNome());
            pAtacado.setVida(pAtacado.getVida() - 6);
            if(pAtacado.getVida()!=0)System.out.println("Foi causado 6 de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
            else{
            System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
            tabu.remover(tabu, x, y);
        }
           
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
