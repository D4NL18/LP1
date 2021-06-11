/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;

import javafx.scene.control.Alert;

public class Suporte extends PersonagemComMana{
    
    
        
    public Suporte(String nome) {
        super(nome);
        this.setVida(1);
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
        
            Alert beep = new Alert(Alert.AlertType.INFORMATION);
            beep.setTitle("Curando...");
            beep.setContentText(this.getNome()+" curou o personagem: "+pCurado.getNome() + ((this.getItem()) ? " com seu boost ativado" : ""));
            beep.show();
            pCurado.setVida(pCurado.getVida() + this.getDano());
            beep.setContentText("Foi dado "+ this.getDano() +" de vida ao personagem "+pCurado.getNome()+" ,restando "+pCurado.getVida()+" de vida");
            beep.show();
            this.setMana(getMana()+1);
            beep.setContentText("+1 de Mana");
            beep.show();
            beep.setContentText(this.getNome() + " agora possui " + this.getMana() + " de mana");
            beep.show();
            
            if(this.getItem()) {
            this.setItem(false);
            this.setDano(this.getDano()-15);
        }
    }
    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pCurado,int x, int y){    
        if (this.getMana() == 2) {
            Alert beep = new Alert(Alert.AlertType.INFORMATION);
            beep.setTitle("Curando...");
            beep.setTitle("Curando para vida máxima...");
	        beep.setContentText(this.getNome()+" curou o personagem com seu especial, deixando-o com vida maxima novamente! Personagem curado: "+pCurado.getNome() + ((this.getItem()) ? " \n" + this.getNome() + "guardou seu boost para a proxima rodada" : ""));
                beep.show();
	        pCurado.setVida(pCurado.getVida() + this.getDano());
	        beep.setContentText(pCurado.getNome() + " agora possui " + this.getVida() + " de vida");
                beep.show();
	        this.setMana(0);
	        beep.setContentText(this.getNome() + " agora possui" + this.getMana() + " de mana");
                beep.show();
        }
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
