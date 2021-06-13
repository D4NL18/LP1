package racobafoda.lp1;

import javafx.scene.control.Alert;

public class Atirador extends Personagem {
    
    
    public Atirador(String nome) {
        super(nome);
        this.setVida(1);
        this.setDefesa(10);
        this.setRange(3);
        this.setDano(15);
        this.setItem(false);
        if(this.getNome()=="Legolas")this.setVisual("A1");
        else if(this.getNome()=="Cj")this.setVisual("A2");
        
    }
    
    @Override
    public void atacar(Tabuleiro tabu, Personagem pAtacado,int x, int y){
 
        if(!this.getItem()){
            
            if(this.getNome()=="Legolas"){
                
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("Atacando...");
                beep.setContentText(this.getNome()+" retira da sua aljava uma flecha "
                + "e com seu arco atira-a, ferindo "+pAtacado.getNome()+".");
                beep.show();
                

            }
            else if(this.getNome()=="Cj"){
                
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("Atacando...");
                beep.setContentText("Eu sou um maniaco com uma arma. "+this.getNome()+" atira em "+pAtacado.getNome());
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
    }
    
        
    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pAtacado,int x, int y){
	    this.setRange(4);
	    if(this.getNome() == "Legolas"){
                
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("Usando Ataque Especial...");  
                beep.setContentText(this.getNome() + " concentrou-se e com sua visao elfica pode enxergar alem das barreiras humanas e ataca "+pAtacado.getNome());
                
                
                pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa())/100));
                beep.show();
                this.setRange(3);
            }
            
	    else if(this.getNome() == "Cj"){
                
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("Usando Ataque Especial...");  
                beep.setContentText("Você quer um buraco na sua cabeça, otario! "+this.getNome()+" atira em "+pAtacado.getNome());
                
                
                pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa())/100));
                beep.show();
                this.setRange(3);
            }
	    

        	
    }
        
}

