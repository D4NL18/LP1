package racobafoda.lp1;

import javafx.scene.control.Alert;

public class Guerreiro extends Personagem {


	public Guerreiro(String nome) {
		super(nome);
		this.setVida(1);
		this.setDefesa(20);
		this.setRange(1);
		this.setDano(20);
		this.setItem(false);
		if (this.getNome().equals("Zoro")) {
			this.setVisual("G1");
		} else {
			this.setVisual("G2");
		}
	}

	@Override
	public void atacar(Tabuleiro tabu, Personagem pAtacado, int x, int y) {
		if (tabu.descobreTabu(tabu)[x][y] != null) {
			if (this.getNome().equals("Zoro")) {
				Alert beep = new Alert(Alert.AlertType.INFORMATION);
				beep.setTitle("Atacando...");
				beep.setContentText(this.getNome() + " cortou o seu inimigo " + pAtacado.getNome() + " com a Shusui");
				beep.show();
			} else {
				Alert beep = new Alert(Alert.AlertType.INFORMATION);
				beep.setTitle("Atacando...");
				beep.setContentText(this.getNome() + " cortou o seu inimigo " + pAtacado.getNome() + " com o Machado Leviata");
				beep.show();
			}
			pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa()) / 100));

			if (pAtacado.getVida() > 0) {
				Alert beep = new Alert(Alert.AlertType.INFORMATION);
				beep.setTitle("Atacando...");
				beep.setContentText("Foi causado " + this.getDano() + " de dano ao inimigo " + pAtacado.getNome() + " restando " + pAtacado.getVida() + " de vida");
				beep.show();
			} else {
				Alert beep = new Alert(Alert.AlertType.INFORMATION);
				beep.setTitle("Atacando...");
				beep.setContentText(this.getNome() + " causou dano suficiente para eliminar o inimigo!");
				beep.show();
				tabu.remover(tabu, x, y);
			}

			if (this.getItem()) {
				this.setItem(false);
				this.setDano(this.getDano() - 5);
			}
		}
	}

	@Override
	public void ataqEsp(Tabuleiro tabu, Personagem pAtacado, int x, int y) {
            int[] xPosReal = new int[8];
            int[] yPosReal = new int[8];
            
                if(x<=0){
                    int xPos[] = { x , x , x , x, x, x + 1, x + 1, x + 1 };
                    for(int w=0;w<xPos.length;w++){
                        xPosReal[w]=xPos[w];
                        
                    }
                }else if(x>=tabu.descobreTabu(tabu).length-1){
                    int xPos[] = { x - 1, x - 1, x - 1, x, x, x , x , x };
                    for(int w=0;w<xPos.length;w++){
                        xPosReal[w]=xPos[w];
                    }
                }else{
                        int xPos[] = { x - 1, x - 1, x - 1, x, x, x + 1, x + 1, x + 1 }; 
                        for(int w=0;w<xPos.length;w++){
                        xPosReal[w]=xPos[w];
 
                    }
                }
                    if(y<=0){
                        
                        int yPos[] = { y , y, y + 1, y , y + 1, y , y, y + 1 };
                        for(int w=0;w<yPos.length;w++){
                        yPosReal[w]=yPos[w];
                    }
                    }else if(y>=tabu.descobreTabu(tabu).length-1){
                        int yPos[] = { y - 1, y, y , y - 1, y , y - 1, y, y  };
                        for(int w=0;w<yPos.length;w++){
                        yPosReal[w]=yPos[w];
                    }
                    }else{
                        int yPos[] = { y - 1, y, y + 1, y - 1, y + 1, y - 1, y, y + 1 };
                        for(int w=0;w<yPos.length;w++){
                        yPosReal[w]=yPos[w];
                    }
                    
                }
		if (this.getNome().equals("Zoro")) {
			Alert beep = new Alert(Alert.AlertType.INFORMATION);
			beep.setTitle("Atacando...");
			beep.setContentText(this.getNome() + " usou o golpe Kokujo O Tatsumaki!");
			beep.show();
		} else {
			Alert beep = new Alert(Alert.AlertType.INFORMATION);
			beep.setTitle("Atacando...");
			beep.setContentText(this.getNome() + " usou a Furia Espartana!");
			beep.show();
		}
                
		for (int i = 0; i < 8; i++) {
			Personagem persoAtacked = tabu.descobreTabu(tabu)[xPosReal[i]][yPosReal[i]];
                        
                        int nProprio = Integer.parseInt(this.getVisual().substring(1));
                        int nInimigo=nProprio;
                        if(persoAtacked!=null && !(persoAtacked instanceof Obstaculo))nInimigo = Integer.parseInt(persoAtacked.getVisual().substring(1));
                        
			if (persoAtacked != null && nProprio != nInimigo) {
				persoAtacked
						.setVida(persoAtacked.getVida() - (this.getDano() * (100 - persoAtacked.getDefesa()) / 100));

				if (persoAtacked.getVida() > 0) {
					Alert beep = new Alert(Alert.AlertType.INFORMATION);
					beep.setTitle("Atacando...");
					beep.setContentText("Foi causado " + this.getDano() + " de dano ao inimigo " + persoAtacked.getNome() + " restando " + persoAtacked.getVida() + " de vida");
					beep.show();
				} else {
					Alert beep = new Alert(Alert.AlertType.INFORMATION);
					beep.setTitle("Atacando...");
					beep.setContentText(this.getNome() + " causou dano suficiente para eliminar o inimigo!");
					beep.show();
					tabu.remover(tabu, xPosReal[i], yPosReal[i]);
				}
			}
		}

		if (this.getItem()) {
			this.setItem(false);
			this.setDano(this.getDano() - 5);
		}
	}
}