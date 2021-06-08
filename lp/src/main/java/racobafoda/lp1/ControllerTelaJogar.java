package racobafoda.lp1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.shape.*;

public class ControllerTelaJogar {
    
   @FXML
   ImageView imgFundo;
    
   @FXML
   private void CriaMapa() throws IOException{
        int tam=0;
        
        if(App.tabu.getOp() == 1) {
            tam=10;
            Image img = new Image(getClass().getResourceAsStream(""));
            imgFundo.setImage(img);
        }else if(App.tabu.getOp() == 2) {
            tam=12;
       }else if(App.tabu.getOp() == 3){
            tam=15;
        }
        
        for(int i=0; i<tam; i++) {
            for(int j=0; j<tam; j++) {
                App.tabuleiro[i][j] = new Rectangle(j*600/tam, i*300/tam, 600/tam, 300/tam);
            }
        }
        //App.tabuleiro.getChildren.add();
    }
   
   @FXML
   private void InserirTabu() {
      Personagem[] listaPer = new Personagem[10];
                listaPer[0]=App.m1;
                listaPer[1]=App.m2;
                listaPer[2]=App.t1;
                listaPer[3]=App.t2;
                listaPer[4]=App.s1;
                listaPer[5]=App.s2;
                listaPer[6]=App.a1;
                listaPer[7]=App.a2;
                listaPer[8]=App.g1;
                listaPer[9]=App.g2;
   }
   
}
