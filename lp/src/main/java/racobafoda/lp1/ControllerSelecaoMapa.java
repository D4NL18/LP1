package racobafoda.lp1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerSelecaoMapa {
    
    @FXML
    ImageView mapaFogo;
    @FXML
    ImageView mapaGelo;
    @FXML
    ImageView mapaGrama;
    @FXML
    TextField NomeJogador1;
    @FXML
    TextField NomeJogador2;
    
    
        @FXML
        private void IrParaMenu() throws IOException {
        App.setRoot("menu");
    }
         @FXML
        private void IrParaJogar() throws IOException {
        App.setRoot("TelaJogar");
    }
        @FXML
        private void SelecionarMapaFogo() throws IOException {
        App.tabu.setOp(1);
    }
        @FXML
        private void SelecionarMapaGelo() throws IOException {
        App.tabu.setOp(2);
    }
        @FXML
        private void SelecionarMapaGrama() throws IOException {
        App.tabu.setOp(3);
        
    }
        @FXML
        private void AlterarNome() throws IOException {
            App.j1.setNome(NomeJogador1.getText());
            App.j2.setNome(NomeJogador2.getText());
            
        
    }

        
}
