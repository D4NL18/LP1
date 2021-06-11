package racobafoda.lp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import java.io.IOException;
import javafx.scene.image.ImageView;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Mago m1 = new Mago("Dr. Estranho");
    public static Mago m2 = new Mago("Toge Inumaki");
    public static Tank t1 = new Tank("Red Riot");
    public static Tank t2 = new Tank("Bulat");
    public static Suporte s1 = new Suporte("Tsunade");
    public static Suporte s2 = new Suporte("Sage");
    public static Atirador a1 = new Atirador("Legolas");
    public static Atirador a2 = new Atirador("Cj");
    public static  Guerreiro g1 = new Guerreiro("Zoro");
    public static Guerreiro g2 = new Guerreiro("Kratos");
    public static Obstaculo pedra = new Obstaculo();
    public static Personagem[] listaPer = new Personagem[10];
    public static Player j1 = new Player("Jogador 1", 1);
    public static Player j2 = new Player("Jogador 2", 2);
    public static Tabuleiro tabu = new Tabuleiro();
    
    private static Scene scene;
    public static Rectangle[][] tabuleiro;
    public static ImageView[][] tabuleiroImagem;
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menu"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
        

        
        
    public static void main(String[] args) {
        listaPer[0]=m1;
        listaPer[1]=m2;
        listaPer[2]=t1;
        listaPer[3]=t2;
        listaPer[4]=s1;
        listaPer[5]=s2;
        listaPer[6]=a1;
        listaPer[7]=a2;
        listaPer[8]=g1;
        listaPer[9]=g2;
        
        
        launch();
    }

}