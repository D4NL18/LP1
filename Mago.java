/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;


public class Mago extends PersonagemComMana{
    
    private int manaM;
    
    public Mago(String nome) {
        super(nome);
        this.setVida(1);
        this.setRange(3);
        this.setMana(1);
        if(this.getNome()=="Dr. Estranho")this.setVisual("M1");
        else if(this.getNome()=="Toge Inumaki")this.setVisual("M2");
        
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
        this.setMana(getMana()+1);
    }
    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pAtacado,int x, int y){
        manaM = getMana();
        if(manaM == 2){
            if(this.getNome()=="Dr. Estranho")System.out.println(this.getNome()+" usou sua jóia do tempo para paralisar e atacar o inimigo: "+pAtacado.getNome());
            else if(this.getNome()=="Toge Inumaki")System.out.println(this.getNome()+" recitou sua palavra proibida e inflingou grandes danos em: "+pAtacado.getNome());
            pAtacado.setVida(pAtacado.getVida() - 6);
            if(pAtacado.getVida()!=0)System.out.println("Foi causado 6 de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
            else{
            System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
            tabu.remover(tabu, x, y);
        }
            this.setMana(0);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
