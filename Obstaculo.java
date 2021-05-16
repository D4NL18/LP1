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
public class Obstaculo extends Personagem{

    public Obstaculo() {
        super("Pedra");
        this.setVisual("@ ");
        this.setVida(1);
        this.setDefesa(100);
    }

    @Override
    public void atacar(Tabuleiro tabu, Personagem pAtacado, int x, int y) {
        System.out.println("Faz nada nao");
    }

    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pAtacado, int x, int y) {
        System.out.println("Faz nada nao");
    }
    
}
