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
        this.setVisual('M');
    }
    @Override
    public void atacar(Personagem pAtacado){
        System.out.println(this.getNome()+" Mandando a flecha no inimigo: "+pAtacado.getNome());
        pAtacado.setVida(pAtacado.getVida() - 3);
        this.setMana(getMana()+1);
    }
    @Override
    public void ataqEsp(Personagem pAtacado){
        manaM = getMana();
        if(manaM == 3){
            System.out.println(this.getNome()+" Mandando a flecha no inimigo: "+pAtacado.getNome());
            pAtacado.setVida(pAtacado.getVida() - 6);
            this.setMana(0);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
