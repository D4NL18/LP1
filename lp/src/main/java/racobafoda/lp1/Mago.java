/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;

import javafx.scene.control.Alert;


public class Mago extends PersonagemComMana{
    
    private int manaM;
    
    public Mago(String nome) {
        super(nome);
        this.setVida(100);
        this.setDefesa(15);
        this.setRange(2);
        this.setMana(1);
        this.setDano(20);
        this.setItem(false);
        if(this.getNome()=="Dr. Estranho")this.setVisual("M1");
        else if(this.getNome()=="Toge Inumaki")this.setVisual("M2");
        
    }
    @Override
    public void atacar(Tabuleiro tabu, Personagem pAtacado,int x, int y){
        
        if(!this.getItem()){
            if(this.getNome()=="Dr. Estranho"){
                //System.out.println(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua magia");
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Atacando...");
                    beep.setContentText(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua magia");
                    beep.show();
            }
            else if(this.getNome()=="Toge Inumaki"){
                //System.out.println(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua palavra amaldiçoada de nivel 1");
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Atacando...");
                    beep.setContentText(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua palavra amaldiçoada de nivel 1\n+1 de mana");
                    beep.show();
            }
            //System.out.println("+1 de Mana"); JUNTEI AQUI NA LINHA DE CIMA
            pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa())/100));
            if(pAtacado.getVida()>0){
                //System.out.println("Foi causado "+ (this.getDano() * (100 - pAtacado.getDefesa())/100) +" de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Atacando...");
                    beep.setContentText("Foi causado "+ (this.getDano() * (100 - pAtacado.getDefesa())/100) +" de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
                    beep.show();
            }
            else{
                System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Atacando...");
                    beep.setContentText(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                    beep.show();
                tabu.remover(tabu, x, y);
                
            }
            this.setMana(getMana()+1);
        }else{
            if(this.getNome()=="Dr. Estranho"){
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Atacando...");
                    beep.setContentText(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" usando sua orbe");
                    beep.show();
            }
            else if(this.getNome()=="Toge Inumaki"){
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Atacando...");
                    beep.setContentText(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua palavra amaldiçoada de nivel 2\n+1 de mana");
                    beep.show();
            }
            
            pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa())/100));
            if(pAtacado.getVida()>0){
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Atacando...");
                    beep.setContentText("Foi causado " +(this.getDano() * (100 - pAtacado.getDefesa())/100)+ "de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
                    beep.show();
            }
            else{
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Atacando...");
                    beep.setContentText(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                    beep.show();
                tabu.remover(tabu, x, y);
            }
            this.setItem(false);
            this.setDano(this.getDano()-10);
            this.setMana(getMana()+1);
        }
    }
    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pAtacado,int x, int y){    
            
        if(!this.getItem()){
            manaM = getMana();
            if(manaM >= 2){
                if(this.getNome()=="Dr. Estranho"){
                    //System.out.println(this.getNome()+" usou sua joia do tempo para paralisar e atacar o inimigo: "+pAtacado.getNome());
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Usando Ataque Especial...");
                    beep.setContentText(this.getNome()+" usou sua joia do tempo para paralisar e atacar o inimigo: "+pAtacado.getNome());
                    beep.show();
                }
                else if(this.getNome()=="Toge Inumaki"){
                    //System.out.println(this.getNome()+" recitou sua palavra proibida e inflingou grandes danos em: "+pAtacado.getNome());
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Usando Ataque Especial...");
                    beep.setContentText(this.getNome()+" recitou sua palavra proibida e inflingou grandes danos em: "+pAtacado.getNome());
                    beep.show();
                }
                pAtacado.setVida(pAtacado.getVida() - (2*this.getDano()));
                if(pAtacado.getVida()>0){
                    //System.out.println("Foi causado "+(this.getDano() * (100 - pAtacado.getDefesa())/100)+" de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Usando Ataque Especial...");
                    beep.setContentText("Foi causado "+(this.getDano() * (100 - pAtacado.getDefesa())/100)+" de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
                    beep.show();
                }
                else{
                //System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Usando Ataque Especial...");
                    beep.setContentText(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                    beep.show();
                tabu.remover(tabu, x, y);
            }
                this.setMana(0);
            }
        }else{
            manaM = getMana();
            if(manaM == 2){
                if(this.getNome()=="Dr. Estranho"){
                    //System.out.println(this.getNome()+" usou sua joia do tempo amplificada pela orbe para viajar para o passado e atacar o inimigo: "+pAtacado.getNome()+" enquanto ainda era jovem");
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Usando Ataque Especial...");
                    beep.setContentText(this.getNome()+" usou sua joia do tempo amplificada pela orbe para viajar para o passado e atacar o inimigo: "+pAtacado.getNome()+" enquanto ainda era jovem");
                    beep.show();
                }
                else if(this.getNome()=="Toge Inumaki"){
                    //System.out.println(this.getNome()+" recitou sua palavra proibida mais poderosa e inflingou grandes danos nos orgaos do oponente "+pAtacado.getNome());
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Usando Ataque Especial...");
                    beep.setContentText(this.getNome()+" recitou sua palavra proibida mais poderosa e inflingou grandes danos nos orgaos do oponente "+pAtacado.getNome());
                    beep.show();
                }
                pAtacado.setVida(pAtacado.getVida() - (2*this.getDano() * (100 - pAtacado.getDefesa())/100));
                if(pAtacado.getVida()>0){
                    //System.out.println("Foi causado "+(this.getDano() * (100 - pAtacado.getDefesa())/100)+" de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Usando Ataque Especial...");
                    beep.setContentText("Foi causado "+(this.getDano() * (100 - pAtacado.getDefesa())/100)+" de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
                    beep.show();
                }
                else{
                //System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Usando Ataque Especial...");
                    beep.setContentText(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                    beep.show();
                tabu.remover(tabu, x, y);
            }
                this.setItem(false);
                this.setDano(this.getDano()-10);
                this.setMana(0);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
