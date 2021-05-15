/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;


public class Suporte extends PersonagemComMana{
        
    public Suporte(String nome) {
        super(nome);
        this.setVida(80);
        this.setDefesa(10);
        this.setRange(2);
        this.setMana(1);
        this.setDano(25);
        this.setItem(false);
        if(this.getNome()=="Tsunade")this.setVisual("S1");
        else if(this.getNome()=="Sage")this.setVisual("S2");
        
    }
    @Override
    public void atacar(Tabuleiro tabu, Personagem pCurado,int x, int y){
        
            System.out.println(this.getNome()+" curou o personagem: "+pCurado.getNome() + ((this.getItem()) ? " com seu boost ativado" : ""));
            pCurado.setVida(pCurado.getVida() + this.getDano());
            System.out.println("Foi dado "+ this.getDano() +" de vida ao personagem "+pCurado.getNome()+" ,restando "+pCurado.getVida()+" de vida");
            this.setMana(getMana()+1);
            System.out.println("+1 de Mana");
            System.out.println(this.getNome() + " agora possui" + this.getMana() + " de mana");
            
            if(this.getItem()) {
            this.setItem(false);
            this.setDano(this.getDano()-15);
        }
    }
    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pCurado,int x, int y){    
        if (this.getMana() == 2) {
	        System.out.println(this.getNome()+" curou o personagem com seu especial, deixando-o com vida máxima novamente!: "+pCurado.getNome() + ((this.getItem()) ? " \n" + this.getNome() + "guardou seu boost para a próxima rodada" : ""));
	        pCurado.setVida(pCurado.getVida() + this.getDano());
	        System.out.println(pCurado.getNome() + " agora possui " + this.getVida() + " de vida");
	        this.setMana(0);
	        System.out.println(this.getNome() + " agora possui" + this.getMana() + " de mana");
        }
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
