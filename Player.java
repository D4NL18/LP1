/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;



import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
public class Player {

  
    
    public Item[] inventario = new Item[10];
    private String nome;
    private int numero;
    private boolean turno;
    
    
    public static Item sorteiaItem(){
        Random random = new Random();
        int rand = random.nextInt(10);
        
        if(rand<5){
          ItemGenerico item= new ItemGenerico() ;
          return item;
            
        }else if(rand==5) {
          ItemMago item= new ItemMago() ;
          return item;
        
        }else if (rand==6) {
          ItemTank item= new ItemTank() ;
          return item;
       
            
         }else if(rand==7) {
         ItemGuerreiro item= new ItemGuerreiro() ;
         return item;
    
            
        }/*else if(rand==8) {
         ItemAtirador item= new ItemAtirador() ;
         return item;
        
            
        }*/else {
          ItemSuporte item= new ItemSuporte() ;
          return item;
        }
        
    }
    
    
    
    public void mostraInventario(){
        for (int i=0;i<this.inventario.length;i++){
            if(this.inventario[i]!=null){
            System.out.println(i+"- "+this.inventario[i].getNome());
            }
        }
    }
    
    public boolean validaPeca(Tabuleiro tabu,int x,int y){
       if(tabu.descobreTabu(tabu)[x][y]!=null){
        int n = Integer.parseInt(tabu.descobreTabu(tabu)[x][y].getVisual().substring(1));
        if(n==numero)return true;
       }
        return false;
    }
          
    
    public void trocaTurno(Player j1, Player j2){
        if(j1.isTurno()){
            j1.setTurno(false);
            j2.setTurno(true);
        }else if(j2.isTurno()){
            j2.setTurno(false);
            j1.setTurno(true);
        }
    }
    
    
    public boolean isTurno() {
        return turno;
    }

   
    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    public String getNome() {
        return nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public Player(String nome, int numero){
        this.nome = nome;
        this.numero = numero;
    }
    
    public void guardaItem(Item item){
        for(int i=0;i<this.inventario.length;i++){
            if(this.inventario[i]==null){
                this.inventario[i]=item;
                break;
            }
            
        }
    }
    
    public void apagaItem(Item item){
        this.inventario[buscaItem(item)]=null;
    }
    
    public int buscaItem(Item item){
         for(int i=0;i<this.inventario.length;i++){
            if(this.inventario[i]==item)return i;
        }
        System.out.println("O item procurado não se encontra no seu inventário"); 
        return -1;   
              
    }
    public void inicioArquivo()throws IOException{
        String linha;
        String nomeArq = this.getNome()+".txt";
        boolean exists = (new File(nomeArq)).exists();
        System.out.println(nomeArq);
        System.out.println(exists);
        if(exists){
        Scanner in = new Scanner(new FileReader(nomeArq));
        if(in.hasNextLine()){
            for(int i=0; in.hasNextLine();i++) {
               linha=in.nextLine();
            if(linha=="Orbe"){
                this.inventario[i]= new ItemMago();
            }else if(linha=="Band-aid"){
                this.inventario[i] = new ItemSuporte();
            }else if(linha=="Armadura"){
                this.inventario[i] = new ItemTank();
            }else if(linha=="Poção de cura"){
                this.inventario[i] = new ItemGenerico();
            }else if(linha=="Manopla")     {
                this.inventario[i] = new ItemGuerreiro();
            }else if(linha=="Lentes telescópicas"){
                this.inventario[i] = new itemAtirador();
            }
        }
        }
        
        in.close();
        }else{
            System.out.println("O usuário "+this.getNome()+" não possui um inventário prévio.");
        }
     }      
            
            
    public void fimArquivo() throws IOException{
        BufferedWriter w1 = new BufferedWriter(new FileWriter(this.getNome()+".txt"));
        for(int i=0; i<this.inventario.length; i++) {
            if(this.inventario[i]!=null){
            w1.append(this.inventario[i].getNome()+"\n");
            }
        }
        w1.close();
    }
    
}
