package racobafoda.lp1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;


public class ControllerVitoria {
    
     
  public void initialize(URL url, ResourceBundle rb) throws IOException {
      
    }
    
    @FXML
    private void IrParaMenu() throws IOException {
      Alert beep = new Alert(Alert.AlertType.INFORMATION);
            beep.setTitle("Inventario Armazenado");
            beep.setContentText("Os inventarios dos jogadores serão armazenados para futuras batalhas.");
            beep.show();
      App.j1.inicioArquivo(); 
      App.j2.inicioArquivo();
      App.j1.fimArquivo();
      App.j2.fimArquivo();
      App.setRoot("menu");
    }
}
