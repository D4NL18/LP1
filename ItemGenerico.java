/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;


public class ItemGenerico extends Item{
    public ItemGenerico(){
        this.setNome("Poção de cura");
    }
    
    @Override
    public void equipar(Personagem per){
        per.setVida(per.getVida()+15);
    } 
}
