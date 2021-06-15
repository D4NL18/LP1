package racobafoda.lp1;

import javafx.scene.control.Alert;

public class Tank extends Personagem{
	
    
	boolean espTank = false;	
	
	
    public Tank(String nome) {
        super(nome);
        this.setVida(150);
        this.setDefesa(25);
        this.setRange(1);
        this.setDano(10);
        this.setItem(false);
        if(this.getNome()=="Red Riot")this.setVisual("T1");
        else if(this.getNome()=="Bulat")this.setVisual("T2");
    }
    @Override
    public void atacar(Tabuleiro tabu, Personagem pAtacado,int x, int y){
        this.setDefesa(25);

    	if(this.getItem() && this.getNome() == "Red Riot") {
            Alert beep = new Alert(Alert.AlertType.INFORMATION);
            beep.setTitle("Atacando...");
            beep.setContentText(this.getNome() + " Bebeu a Trigger, tornando-se mais resistente");
            beep.show();
        }
    	else if(this.getItem() && this.getNome() == "Bulat") {
            Alert beep = new Alert(Alert.AlertType.INFORMATION);
            beep.setTitle("Atacando...");
            beep.setContentText(this.getNome() + " ativou a incursio, tornando-se mais resistente");
            beep.show();
        }
    	
        if(this.getNome()=="Red Riot"){
            Alert beep = new Alert(Alert.AlertType.INFORMATION);
            beep.setTitle("Atacando...");
            beep.setContentText(this.getNome()+" encheu de porrada seu inimigo: "+pAtacado.getNome());
            beep.show();
        }
            else if(this.getNome()=="Bulat"){
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("Atacando...");
                beep.setContentText(this.getNome()+" deu uma espadada em seu inimigo: "+pAtacado.getNome() + ((this.getItem()) ? " com a incursio!" : ""));
                beep.show();
            }
            pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa())/100));
            if(pAtacado.getVida()>0){
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("Atacando...");
                beep.setContentText("Foi causado "+ (this.getDano() * (100 - pAtacado.getDefesa())/100) +" de dano ao inimigo "+pAtacado.getNome()+" ,restando "+pAtacado.getVida()+" de vida");
                beep.show();
            }
            else{
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("Atacando...");
                beep.setContentText(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                beep.show();
                tabu.remover(tabu, x, y);
            }
            
        }
        
    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pAtacado,int x, int y){
             
        	if(!espTank) {
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Usando Ataque Especial...");  
	        	this.setDefesa(100);
	        	beep.setContentText((this.getItem()) ? (this.getNome() + " guardou seu item para a proxima rodada\n") : "");
	        	if(this.getNome() == "Red Riot")beep.setContentText(this.getNome() + " ativou seu enrijecimento, tornando-se imortal ate realizar um ataque");
	        	else if(this.getNome() == "Bulat")beep.setContentText(this.getNome() + ": INCURSIOOOOOOOOOOOOOOOOOO\n"
	        	+ "Bulat transformou a sua incursio em uma armadura dourada, tornando-se imortal ate realizar um ataque");
	        	espTank = true;
                        beep.show();
        	}else{
                    Alert beep = new Alert(Alert.AlertType.INFORMATION);
                    beep.setTitle("Usando Ataque Especial...");  
                    beep.setContentText("Seu especial nao pode ser ativado duas vezes na mesma partida");
                    beep.show();
                }
        	
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
