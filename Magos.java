/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;

public class Magos extends PersonagemComMana{
    
    private int manaM;
    
    public Magos(String nome) {
        super(nome);
        this.setVida(150);
        this.setRange(3);
        this.setMana(2);
        if(this.getNome()=="Dr. Estranho")this.setVisual("M1");
        else if(this.getNome()=="Toge Inumaki")this.setVisual("M2");
        
    }
    @Override
    public void atacar(Personagem pAtacado){
        if(this.getNome()=="Dr. Estranho")System.out.println(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua magia");
        else if(this.getNome()=="Toge Inumaki")System.out.println(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua magia");
        pAtacado.setVida(pAtacado.getVida() - 3 + pAtacado.getDefesa());
        this.setMana(getMana()+1);
    }
    @Override
    public void ataqEsp(Personagem pAtacado){
        manaM = getMana();
        if(manaM == 3){
            if(this.getNome()=="Dr. Estranho")System.out.println(this.getNome()+" usou sua jóia do tempo para paralisar a atacar o inimigo: "+pAtacado.getNome());
            else if(this.getNome()=="Toge Inumaki")System.out.println(this.getNome()+" recitou sua palavra proibida e inflingou grandes danos em: "+pAtacado.getNome());
            pAtacado.setVida(pAtacado.getVida() - 6);
            this.setMana(0);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
