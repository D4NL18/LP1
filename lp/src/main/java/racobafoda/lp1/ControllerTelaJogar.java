package racobafoda.lp1;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.shape.*;

public class ControllerTelaJogar implements Initializable{
   static int cont1=1;
   static int cont2=1;
   static int quantTurnos=0;
   static int MAXTURNOS = 15;
   int tam=0;
   int cX=-1,cY=-1;
   
   @FXML ImageView imgFundo;
   @FXML ImageView imagemRep;
   @FXML Label teste;
   @FXML Label labelNome;
   @FXML Label labelVida;
   @FXML Label labelAtaq;
   @FXML Label labelDef;
   @FXML Label labelNomePlayer;
   @FXML  private AnchorPane OJOGO;
   @FXML private Label contadorTurnos;
    
   @Override
  public void initialize(URL url, ResourceBundle rb) {
       try {
           criaMapa();
           defineTurnoInicial(App.j1,App.j2);
           faseDePreenchimentoPedras(App.tabu,App.tabu.getOp(),App.pedra);
           espelhaTabuleiros(App.tabu);
           inserePecas(tam,App.listaPer,App.j1,App.j2,App.tabu);
           espelhaTabuleiros(App.tabu);
           infoPersonagens();
           App.j1.inicioArquivo(); 
           App.j2.inicioArquivo();
       } catch (IOException ex) {
           ex.printStackTrace();
       }
    }
   
  private void criaMapa() throws IOException {
        
        if(App.tabu.getOp() == 1) {
            tam=10;
            Image img = new Image(getClass().getResourceAsStream("fogo.jpg"));
            imgFundo.setImage(img);
            imgFundo.setFitWidth(600);
        }else if(App.tabu.getOp() == 2) {
            tam=12;
            Image img = new Image(getClass().getResourceAsStream("gelo.png"));
            imgFundo.setImage(img);
            imgFundo.setFitWidth(600);
       }else if(App.tabu.getOp() == 3){
            tam=15;
            Image img = new Image(getClass().getResourceAsStream("grama.jpg"));
            imgFundo.setImage(img);
            imgFundo.setFitWidth(600);
        }
        
        App.tabuleiro = new Rectangle[tam][tam];
        App.tabuleiroImagem = new ImageView[tam][tam];
        
        for(int i=0; i<tam; i++) {
            for(int j=0; j<tam; j++) {
                App.tabuleiro[i][j] = new Rectangle(j*600/tam, i*300/tam, 600/tam, 300/tam);
                App.tabuleiroImagem[i][j] = new ImageView();
                App.tabuleiroImagem[i][j].setFitHeight(300/tam);
                App.tabuleiroImagem[i][j].setFitWidth(600/tam);
                App.tabuleiroImagem[i][j].setX(j*600/tam);
                App.tabuleiroImagem[i][j].setY(i*300/tam);
                App.tabuleiroImagem[i][j].setLayoutX(0);
                App.tabuleiroImagem[i][j].setLayoutY(0);
                
                if((i%2==0 && j%2==0) || (i%2==1 && j%2==1)){
                App.tabuleiro[i][j].setStyle("-fx-fill : white;");
                App.tabuleiro[i][j].setOpacity(0.1);
            }else{
                App.tabuleiro[i][j].setStyle("-fx-fill : black;");
                App.tabuleiro[i][j].setOpacity(0.2);
                }
                OJOGO.getChildren().add(App.tabuleiro[i][j]);
                OJOGO.getChildren().add(App.tabuleiroImagem[i][j]);
            }
        }
       
        
        
    } 
 
  private void infoPersonagens()throws IOException{
      Label labelMana = new Label();
      if(cX==-1 || cY==-1){
        imagemRep.setImage(null);
        labelNome.setText("Nome: ");
        labelVida.setText("Vida: ");
        labelAtaq.setText("Ataque: ");
        labelDef.setText("Defesa: ");
         
        
        
      }else{
        imagemRep.setImage(App.tabuleiroImagem[cX][cY].getImage());
        if(App.tabu.descobreTabu(App.tabu)[cX][cY] instanceof Mago){
        labelNome.setText("Nome: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getNome());
        labelVida.setText("Vida: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getVida());
        labelAtaq.setText("Ataque: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getDano());
        labelDef.setText("Defesa: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getDefesa());
        
        labelMana.setText("Mana: "+((Mago)App.tabu.descobreTabu(App.tabu)[cX][cY]).getMana());
        labelMana.setLayoutX(300);
        labelMana.setLayoutY(310);
        labelMana.setStyle("-fx-background-color:white");
        OJOGO.getChildren().add(labelMana);
        
        }else if(App.tabu.descobreTabu(App.tabu)[cX][cY] instanceof Suporte){
        labelNome.setText("Nome: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getNome());
        labelVida.setText("Vida: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getVida());
        labelAtaq.setText("Ataque: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getDano());
        labelDef.setText("Defesa: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getDefesa());
        
        labelMana.setText("Mana: "+((Suporte)App.tabu.descobreTabu(App.tabu)[cX][cY]).getMana());
        labelMana.setLayoutX(300);
        labelMana.setLayoutY(310);
        labelMana.setStyle("-fx-background-color:white");
        OJOGO.getChildren().add(labelMana);
        
        }else{
        labelNome.setText("Nome: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getNome());
        labelVida.setText("Vida: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getVida());
        labelAtaq.setText("Ataque: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getDano());
        labelDef.setText("Defesa: "+App.tabu.descobreTabu(App.tabu)[cX][cY].getDefesa());
        }
     }
     if(App.j1.isTurno()){
     labelNomePlayer.setText("Turno de: "+App.j1.getNome());
     }else {
         labelNomePlayer.setText("Turno de: "+App.j2.getNome());
     }
    
  }
   
 @FXML
  private void ataque()throws IOException{
      TextInputDialog pegarX = new TextInputDialog();
      pegarX.setTitle("Pegando as coordenadas X:");
      pegarX.setHeaderText("Me de a posição vertical da peca que voce deseja atacar: ");
      pegarX.setContentText("Valor: ");
      pegarX.showAndWait();
      int op = Integer.parseInt(pegarX.getResult(), 10);
      TextInputDialog pegarY = new TextInputDialog();
      pegarY.setTitle("Pegando as coordenadas X da peca que deseja executar a acao:");
      pegarY.setHeaderText("Me de a posição horizontal da peca que voce deseja atacar: ");
      pegarY.setContentText("Valor: ");
      pegarY.showAndWait();
      int op2 = Integer.parseInt(pegarY.getResult(), 10);
      if(validaAtaq(App.tabu,cX,cY,op,op2) && App.tabu.descobreTabu(App.tabu)[op][op2]!=null){
      App.tabu.descobreTabu(App.tabu)[cX][cY].atacar(App.tabu,App.tabu.descobreTabu(App.tabu)[op][op2],op,op2);
      if(App.tabu.descobreTabu(App.tabu)[op][op2]==null){
        if(App.j1.isTurno()){
           Alert beep = new Alert(Alert.AlertType.INFORMATION);
           beep.setTitle("Recompensa de batalha");
           beep.setContentText("Voce conseguiu uma recompensa por eliminar o inimigo");
           beep.show();
            App.j1.guardaItem(App.j1.sorteiaItem());
        }
        else if(App.j2.isTurno()){
           Alert beep = new Alert(Alert.AlertType.INFORMATION);
           beep.setTitle("Recompensa de batalha");
           beep.setContentText("Voce conseguiu uma recompensa por eliminar o inimigo");
           beep.show();
            App.j2.guardaItem(App.j2.sorteiaItem());
        }
      }
      App.j1.trocaTurno(App.j1, App.j2);
      espelhaTabuleiros(App.tabu);
      quantTurnos++;
      contadorTurnos.setText("Turno: "+quantTurnos);
      }else{
           Alert beep = new Alert(Alert.AlertType.ERROR);
           beep.setTitle("Erro");
           beep.setContentText("Nao eh possivel atacar essa pca, tente novamente");
           beep.show();
        }
     cX=-1;
     cY=-1;
     infoPersonagens();
     if(checarFimJogo(App.tabu) || quantTurnos==15){
         if(quantTurnos==MAXTURNOS){
             desempatar(App.tabu);
         }
         App.setRoot("Vitoria");
     }
  }
  
  @FXML
  private void ataqEsp()throws IOException{
     TextInputDialog pegarX = new TextInputDialog();
      pegarX.setTitle("Pegando as coordenadas X:");
      pegarX.setHeaderText("Me de a posição vertical da peca que voce deseja usar seu ataque especial: ");
      pegarX.setContentText("Valor: ");
      pegarX.showAndWait();
      int op = Integer.parseInt(pegarX.getResult(), 10);
      TextInputDialog pegarY = new TextInputDialog();
      pegarY.setTitle("Pegando as coordenadas X da peca que deseja executar a acao:");
      pegarY.setHeaderText("Me de a posição horizontal da peca que voce deseja usar seu ataque especial: ");
      pegarY.setContentText("Valor: ");
      pegarY.showAndWait();
      int op2 = Integer.parseInt(pegarY.getResult(), 10);
      if(validaEsp(App.tabu.descobreTabu(App.tabu)[cX][cY])){
        if(validaAtaq(App.tabu,cX,cY,op,op2) && App.tabu.descobreTabu(App.tabu)[op][op2]!=null){
        App.tabu.descobreTabu(App.tabu)[cX][cY].ataqEsp(App.tabu,App.tabu.descobreTabu(App.tabu)[op][op2],op,op2);
        App.j1.trocaTurno(App.j1, App.j2);
        espelhaTabuleiros(App.tabu);
        quantTurnos++;
        contadorTurnos.setText("Turno: "+quantTurnos);
        }else{
            Alert beep = new Alert(Alert.AlertType.ERROR);
            beep.setTitle("Erro");
            beep.setContentText("Nao eh possivel atacar essa peca, tente novamente");
            beep.show();
          }
      }else{
          Alert beep = new Alert(Alert.AlertType.ERROR);
          beep.setTitle("Voce nao pode usar o ataque especial no momento, tente novamente");
          beep.setContentText("Nao eh possivel atacar essa peca, tente novamente");
          beep.show();
      }
     cX=-1;
     cY=-1;
     infoPersonagens();
     if(checarFimJogo(App.tabu) || quantTurnos==15){
         if(quantTurnos==MAXTURNOS){
             desempatar(App.tabu);
         }
         App.setRoot("Vitoria");
     }
  }
 
  @FXML
  private void mover()throws IOException{
      
     if(App.tabu.descobreTabu(App.tabu)[cX][cY]!=null) {
                TextInputDialog pegarX = new TextInputDialog();
                pegarX.setTitle("Pegando as coordenadas X:");
                pegarX.setHeaderText("Me de a posição vertical para onde voce deseja mover a peca: ");
                pegarX.setContentText("Valor: ");
                pegarX.showAndWait();
                int op = Integer.parseInt(pegarX.getResult(), 10);
                TextInputDialog pegarY = new TextInputDialog();
                pegarY.setTitle("Pegando as coordenadas X da peca que deseja executar a acao:");
                pegarY.setHeaderText("Me de a posição horizontal para onde voce deseja mover a peca: ");
                pegarY.setContentText("Valor: ");
                pegarY.showAndWait();
                int op2 = Integer.parseInt(pegarY.getResult(), 10);
                
                
                    if((op==cX+1 || op==cX-1 || op==cX) && (op2==cY-1 || op2==cY+1 || op2==cY)){
                        if(App.tabu.descobreTabu(App.tabu)[op][op2]==null){
                        App.tabu.inserir(App.tabu,App.tabu.descobreTabu(App.tabu)[cX][cY],op,op2);
                        App.tabu.remover(App.tabu,cX,cY);
                        espelhaTabuleiros(App.tabu);
                        quantTurnos++;
                        contadorTurnos.setText("Turno: "+quantTurnos);
                        App.j1.trocaTurno(App.j1, App.j2);
                        }else{
                            Alert beep = new Alert(Alert.AlertType.ERROR);
                            beep.setTitle("Erro");
                            beep.setContentText("Não é possível inserir uma peça nesse local, insira uma coordenada válida");
                            beep.show();
                        }
                    }else{
                        Alert beep = new Alert(Alert.AlertType.ERROR);
                            beep.setTitle("Erro");
                            beep.setContentText("Não é possível inserir uma peça nesse local, insira uma coordenada válida");
                            beep.show();
                        
                    }
                }else{
                            Alert beep = new Alert(Alert.AlertType.ERROR);
                            beep.setTitle("Erro");
                            beep.setContentText("As coordenadas digitadas não são válidas, digite outra peça para mover");
                            beep.show();
     }
     cX=-1;
     cY=-1;
     infoPersonagens();
     if(checarFimJogo(App.tabu) || quantTurnos==15){
         if(quantTurnos==MAXTURNOS){
             desempatar(App.tabu);
         }
         App.setRoot("Vitoria");
     }
  }
  
  @FXML
  private void equiparItem()throws IOException{
       if(App.j1.isTurno()){
           if(App.j1.inventario[0]!=null){
                TextInputDialog pegarX = new TextInputDialog();
                pegarX.setTitle("Escolha de Item");
                pegarX.setHeaderText(App.j1.getNome()+" digite o indice do item que deseja equipar: \n"+App.j1.mostraInventario());
                pegarX.setContentText("Indice: ");
                pegarX.showAndWait();
                int op = Integer.parseInt(pegarX.getResult(), 10);
           }else{
                            Alert beep = new Alert(Alert.AlertType.ERROR);
                            beep.setTitle("Erro");
                            beep.setContentText("O inventario esta vazio, escolha outra acao");
                            beep.show();
                    }
        
       
      }else{
           if(App.j2.inventario[0]!=null){
                TextInputDialog pegarX = new TextInputDialog();
                pegarX.setTitle("Escolha de Item");
                pegarX.setHeaderText(App.j2.getNome()+" digite o indice do item que deseja equipar: \n"+App.j2.mostraInventario());
                pegarX.setContentText("Indice: ");
                pegarX.showAndWait();
                int op = Integer.parseInt(pegarX.getResult(), 10);
            }else{
                            Alert beep = new Alert(Alert.AlertType.ERROR);
                            beep.setTitle("Erro");
                            beep.setContentText("O inventario esta vazio, escolha outra acao");
                            beep.show();
           }
       
        
      }
     
  }
  
  private void faseDePreenchimentoPedras(Tabuleiro tabu,int tipoTabu, Personagem pedra){
                    tabu.inserir(tabu, pedra, 2, 2);
                    tabu.inserir(tabu, pedra, 2, 3);
                    if(tipoTabu==1){
                    tabu.inserir(tabu, pedra, 7, 6);
                    tabu.inserir(tabu, pedra, 7, 7);
                    }else if(tipoTabu==2){
                    tabu.inserir(tabu, pedra, 3, 2);
                    tabu.inserir(tabu, pedra, 3, 3);
                    tabu.inserir(tabu, pedra, 9, 9);
                    tabu.inserir(tabu, pedra, 9, 8);
                    tabu.inserir(tabu, pedra, 8, 8);
                    tabu.inserir(tabu, pedra, 8, 9);
                    }else if(tipoTabu==3){
                    tabu.inserir(tabu, pedra, 3, 2);
                    tabu.inserir(tabu, pedra, 3, 3);
                    tabu.inserir(tabu, pedra, 6, 6);
                    tabu.inserir(tabu, pedra, 6, 7);
                    tabu.inserir(tabu, pedra, 6, 8);
                    tabu.inserir(tabu, pedra, 7, 6);
                    tabu.inserir(tabu, pedra, 7, 7);
                    tabu.inserir(tabu, pedra, 7, 8);
                    tabu.inserir(tabu, pedra, 8, 6);
                    tabu.inserir(tabu, pedra, 8, 7);
                    tabu.inserir(tabu, pedra, 8, 8);
                    tabu.inserir(tabu, pedra, 12, 12);
                    tabu.inserir(tabu, pedra, 12, 11);
                    tabu.inserir(tabu, pedra, 11, 11);
                    tabu.inserir(tabu, pedra, 11, 12);
                    }
    }
  
  public void defineTurnoInicial(Player j1, Player j2){
        Random random = new Random();
        int sorteio = random.nextInt(2);
        if(sorteio==0){
            j1.setTurno(true);
            j2.setTurno(false);
            
        }else{
            j1.setTurno(false);
            j2.setTurno(true);
        }
    }
  
  public void espelhaTabuleiros(Tabuleiro t){
      
            for(int i = 0; i<t.descobreTabu(t).length; i++) {
			for(int j = 0; j<t.descobreTabu(t).length; j++) {
                            
				if(t.descobreTabu(t)[i][j]!=null){
                                    if(t.descobreTabu(t)[i][j].getVisual()=="@ "){
                                        Image img = new Image(getClass().getResourceAsStream("pedra.png"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                        
                                    } else if(t.descobreTabu(t)[i][j].getVisual()=="M1"){
                                        Image img = new Image(getClass().getResourceAsStream("drEstranhoBase.png"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                        
                                    } else if(t.descobreTabu(t)[i][j].getVisual()=="M2"){
                                        Image img = new Image(getClass().getResourceAsStream("Inumaki.Toge.full.3009265.png"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                        
                                    }else if(t.descobreTabu(t)[i][j].getVisual()=="T1"){
                                        Image img = new Image(getClass().getResourceAsStream("redriot.png"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                        
                                    }else if(t.descobreTabu(t)[i][j].getVisual()=="T2"){
                                        Image img = new Image(getClass().getResourceAsStream("bulat.png"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                        
                                    }else if(t.descobreTabu(t)[i][j].getVisual()=="G1"){
                                        Image img = new Image(getClass().getResourceAsStream("drEstranhoBase.jpg"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                        
                                    }else if(t.descobreTabu(t)[i][j].getVisual()=="G2"){
                                        Image img = new Image(getClass().getResourceAsStream("drEstranhoBase.jpg"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                        
                                    }else if(t.descobreTabu(t)[i][j].getVisual()=="A1"){
                                        Image img = new Image(getClass().getResourceAsStream("drEstranhoBase.jpg"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                        
                                    }else if(t.descobreTabu(t)[i][j].getVisual()=="A2"){
                                        Image img = new Image(getClass().getResourceAsStream("drEstranhoBase.jpg"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                        
                                    }else if(t.descobreTabu(t)[i][j].getVisual()=="S1"){
                                        Image img = new Image(getClass().getResourceAsStream("tsunade.png"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                        
                                    }else if(t.descobreTabu(t)[i][j].getVisual()=="S2"){
                                        Image img = new Image(getClass().getResourceAsStream("sage.png"));
                                        
                                        App.tabuleiroImagem[i][j].setImage(img);
                                        App.tabuleiroImagem[i][j].setPreserveRatio(false);
                                    
                                    }
                                    
                                }else if (t.descobreTabu(t)[i][j]==null){
                                        App.tabuleiroImagem[i][j].setImage(null);
                                       
                                        
                                }
                                
                            
			}
                       
            }
  }
  
  @FXML
  private void inserePecas(int tam, Personagem[] listaPer, Player j1, Player j2, Tabuleiro tabu){
        
      for (int i=0;i<2;i++){
          
        TextInputDialog pegarX = new TextInputDialog();
        pegarX.setTitle("Pegando as coordenadas de valor X na matriz");
        pegarX.setHeaderText("Me de a posição vertical do personagem "+listaPer[i].getClass().getSimpleName() + " a ser inserido");
        pegarX.setContentText("Valor: ");
        pegarX.showAndWait();
        int op = Integer.parseInt(pegarX.getResult(), 10);
        TextInputDialog pegarY = new TextInputDialog();
        pegarY.setTitle("Pegando as coordenadas de valor Y na matriz");
        pegarY.setHeaderText("Me de a posição horizontal do personagem "+listaPer[i].getClass().getSimpleName() + " a ser inserido");
        pegarY.setContentText("Valor: ");
        pegarY.showAndWait();
        int op2 = Integer.parseInt(pegarY.getResult(), 10);
      
          if(j1.isTurno()){
                        if(i%2==0){
                            if(tabu.inserir(tabu,listaPer[i+1],op,op2)==1);
                            else{
                                //System.out.println("Nao eh possi­vel inserir uma peca nessa posicao");
                            Alert beep = new Alert(Alert.AlertType.ERROR);
                            beep.setTitle("Erro");
                            beep.setContentText("Nao eh possi­vel inserir uma peca nessa posicao");
                            beep.show();
                                 i--;
                            }
                        }else {
                            if(tabu.inserir(tabu,listaPer[i-1],op,op2)==1);
                            else{
                                //System.out.println("Nao eh possi­vel inserir uma peca nessa posicao");
                            Alert beep = new Alert(Alert.AlertType.ERROR);
                            beep.setTitle("Erro");
                            beep.setContentText("Nao eh possi­vel inserir uma peca nessa posicao");
                            beep.show();
                                 i--;
                            }
      }
          }
          else{
                        if(i%2!=0){
                            if(tabu.inserir(tabu,listaPer[i],op,op2)==1);
                            else{
                                //System.out.println("Nao eh possi­vel inserir uma peca nessa posicao");
                            Alert beep = new Alert(Alert.AlertType.ERROR);
                            beep.setTitle("Erro");
                            beep.setContentText("Nao eh possi­vel inserir uma peca nessa posicao");
                            beep.show();
                                 i--;
                            }
                        }else {
                            if(tabu.inserir(tabu,listaPer[i],op,op2)==1);
                            else{
                                //System.out.println("Nao eh possi­vel inserir uma peca nessa posicao");
                                Alert beep = new Alert(Alert.AlertType.ERROR);
                            beep.setTitle("Erro");
                            beep.setContentText("Nao eh possi­vel inserir uma peca nessa posicao");
                            beep.show();
                                 i--;
                            }
                        }
              }
  }
  
  
  }
  
  private boolean validaAtaq(Tabuleiro tabu,int op ,int op2, int x,int y){
        int range;
        if(tabu.descobreTabu(tabu)[x][y]!=null){
            range=tabu.descobreTabu(tabu)[x][y].getRange();
            if(Math.abs(x-op)<=range || Math.abs(y-op2)<=range) return true;
        }
            return false;

    }
  
  @FXML
  private void escolhePeca()throws IOException{
      if(App.j1.isTurno()){
       TextInputDialog pegarX = new TextInputDialog();
       pegarX.setTitle("Pegando as coordenadas X da peca que deseja executar a acao:");
       pegarX.setHeaderText(App.j1.getNome()+" me de a posição vertical do personagem que voce deseja executar uma acao: ");
       pegarX.setContentText("Valor: ");
       pegarX.showAndWait();
       int op = Integer.parseInt(pegarX.getResult(), 10);
       TextInputDialog pegarY = new TextInputDialog();
       pegarY.setTitle("Pegando as coordenadas Y da peca que deseja executar a acao:");
       pegarY.setHeaderText(App.j1.getNome()+" me de a posição horizontal do personagem que voce deseja executar uma acao: ");
       pegarY.setContentText("Valor: ");
       pegarY.showAndWait();
       int op2 = Integer.parseInt(pegarY.getResult(), 10);
        if(App.j1.validaPeca(App.tabu, op, op2)){
        cX=op;
        cY=op2;
        infoPersonagens();
        }else{
         Alert beep = new Alert(Alert.AlertType.ERROR);
         beep.setTitle("Erro");
         beep.setContentText("Essa nao eh uma peca valida, tente novamente selecionando uma peca do seu time");
         beep.show();
        }
       
      }else{
        TextInputDialog pegarX = new TextInputDialog();
        pegarX.setTitle("Pegando as coordenadas X da peca que deseja executar a acao:");
        pegarX.setHeaderText(App.j2.getNome()+" me de a posição vertical do personagem que voce deseja executar uma acao: ");
        pegarX.setContentText("Valor: ");
        pegarX.showAndWait();
        int op = Integer.parseInt(pegarX.getResult(), 10);
        TextInputDialog pegarY = new TextInputDialog();
        pegarY.setTitle("Pegando as coordenadas Y da peca que deseja executar a acao:");
        pegarY.setHeaderText(App.j2.getNome()+" me de a posição horizontal do personagem que voce deseja executar uma acao: ");
        pegarY.setContentText("Valor: ");
        pegarY.showAndWait();
        int op2 = Integer.parseInt(pegarY.getResult(), 10);
        if(App.j2.validaPeca(App.tabu, op, op2)){
        cX=op;
        cY=op2;
        imagemRep.setImage(App.tabuleiroImagem[op][op2].getImage());
        infoPersonagens();
        }else{
         Alert beep = new Alert(Alert.AlertType.ERROR);
         beep.setTitle("Erro");
         beep.setContentText("Essa nao eh uma peca valida, tente novamente selecionando uma peca do seu time");
         beep.show();
        }
      }
       
       
  }
  
  public static boolean validaEsp(Personagem per){
        if(per instanceof Mago){
           if(((Mago) per).getMana()==2)return true;
           return false;
        }
        if(per instanceof Suporte){
            if(((Suporte) per).getMana()==2)return true;
            return false;
         }
         if(per instanceof Atirador){
             if(((Atirador) per).getRange()==3){
                 per.setRange(4);
                 return true;
             }
             return false;
         }
         return true;
    }
  
  public static boolean checarFimJogo(Tabuleiro tabu){
        
        
        for(int i=0;i<tabu.descobreTabu(tabu).length;i++){
            for(int j=0;j<tabu.descobreTabu(tabu).length;j++){
                if(tabu.descobreTabu(tabu)[i][j]!=null && !(tabu.descobreTabu(tabu)[i][j] instanceof Obstaculo)) {
                    if(Integer.parseInt(tabu.descobreTabu(tabu)[i][j].getVisual().substring(1))==1) cont1++;
                    else if(Integer.parseInt(tabu.descobreTabu(tabu)[i][j].getVisual().substring(1))==2) cont2++;
                }
            }
        }
        if(cont1==0 || cont2==0){
            if(cont1==0){
               
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("PARABENS");
                beep.setContentText("O jogador 2 ganhou o jogo!");
                beep.show();
            }
            else if(cont2==0){
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("PARABENS");
                beep.setContentText("O jogador 1 ganhou o jogo!");
                beep.show();
            }
            cont1=0;
            cont2=0;
            
            return true;
        }
        else{
            cont1=0;
            cont2=0;
            return false;
        }
    }

  public static void desempatar(Tabuleiro tabu){
        
        
        for(int i=0;i<tabu.descobreTabu(tabu).length;i++){
            for(int j=0;j<tabu.descobreTabu(tabu).length;j++){
                if(tabu.descobreTabu(tabu)[i][j]!=null && !(tabu.descobreTabu(tabu)[i][j] instanceof Obstaculo)) {
                    if(Integer.parseInt(tabu.descobreTabu(tabu)[i][j].getVisual().substring(1))==1) cont1++;
                    else if(Integer.parseInt(tabu.descobreTabu(tabu)[i][j].getVisual().substring(1))==2) cont2++;
                }
            }
        }
        if(cont1>cont2){
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("PARABENS");
                beep.setContentText("Jogador 1 ganhou a partida por possuir mais pecas em campo");
                beep.show();
        }
        else if(cont2>cont1){
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("PARABENS");
                beep.setContentText("Jogador 2 ganhou a partida por possuir mais pecas em campo");
                beep.show();
        }
        else{
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                beep.setTitle("Ue");
                beep.setContentText("Ambos os jogadores possuem o mesmo numero de pecas, EMPATE");
                beep.show();
        }
    }

   public static void equipaItemClasse(Player j1,Player j2, int escolha, Tabuleiro tabu, int op, int op2){
                Alert beep = new Alert(Alert.AlertType.INFORMATION);
                
                    if(j1.inventario[escolha] instanceof ItemGuerreiro && tabu.descobreTabu(tabu)[op][op2] instanceof Guerreiro){
                                beep.setTitle("Equipando Item");
                                beep.setContentText("Item Equipado!");
                                beep.show();
                             j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                             j1.apagaItem(j1.inventario[escolha]);
                             j1.trocaTurno(j1, j2);
                    }else if(j1.inventario[escolha] instanceof ItemMago && tabu.descobreTabu(tabu)[op][op2] instanceof Mago){
                                beep.setTitle("Equipando Item");
                                beep.setContentText("Item Equipado!");
                                beep.show();
                             j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                             j1.apagaItem(j1.inventario[escolha]);
                             j1.trocaTurno(j1, j2);
                    }else if(j1.inventario[escolha] instanceof ItemTank && tabu.descobreTabu(tabu)[op][op2] instanceof Tank){
                                beep.setTitle("Equipando Item");
                                beep.setContentText("Item Equipado!");
                                beep.show(); 
                             j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                             j1.apagaItem(j1.inventario[escolha]);
                             j1.trocaTurno(j1, j2);
                    }else if(j1.inventario[escolha] instanceof ItemSuporte && tabu.descobreTabu(tabu)[op][op2] instanceof Suporte){
                                beep.setTitle("Equipando Item");
                                beep.setContentText("Item Equipado!");
                                beep.show();   
                             j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                             j1.apagaItem(j1.inventario[escolha]);
                             j1.trocaTurno(j1, j2);
                    }else if(j1.inventario[escolha] instanceof ItemGenerico){
                                beep.setTitle("Equipando Item");
                                beep.setContentText("Item Equipado!");
                                beep.show();   
                             j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                             j1.apagaItem(j1.inventario[escolha]);
                             j1.trocaTurno(j1, j2);
                    }else if(j1.inventario[escolha] instanceof itemAtirador && tabu.descobreTabu(tabu)[op][op2] instanceof Atirador){
                                beep.setTitle("Equipando Item");
                                beep.setContentText("Item Equipado!");
                                beep.show();    
                            j1.inventario[escolha].equipar(tabu.descobreTabu(tabu)[op][op2]);
                            j1.apagaItem(j1.inventario[escolha]);
                            j1.trocaTurno(j1, j2);
                    }else{
                                Alert beep1 = new Alert(Alert.AlertType.ERROR);
                                beep1.setTitle("Erro");
                                beep1.setContentText("Nao eh possi­vel equipar esse item, pois ele nao eh da classe do personagem selecionado, tente novamente");
                                beep1.show();
                    }                   
                        
    }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


}
