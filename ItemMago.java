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
    
    public ItemMago(String nome){
        super(nome);
    }
    
    @Override
    public void equipar(Personagem per){
        per.setItem(true);
    }
    
}
