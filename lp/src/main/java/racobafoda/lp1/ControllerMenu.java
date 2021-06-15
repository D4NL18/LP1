package racobafoda.lp1;

import java.io.IOException;
import javafx.fxml.FXML;

public class ControllerMenu {
    
    @FXML
    private void IrParaRegras() throws IOException {
        App.setRoot("Regras");
    }
    
     @FXML
    private void IrParaJogar() throws IOException {
        App.setRoot("SelecaoMapa");
    }
    @FXML
    private void FecharGame() throws IOException {
        System.exit(0);
    }
}
