/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;

/**
 *
 * @author Bruno
 */
public class ItemMago extends Item{
    private int dano=10;
    
    public ItemMago(){
        this.setNome("Orbe");
    }
    
    
    @Override
    public void equipar(Personagem per){
        per.setItem(true);
        per.setDano(per.getDano()+this.getDano());
    }

    public int getDano() {
        return dano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }
    
}
