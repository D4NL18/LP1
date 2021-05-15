/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Player {

  
    
    public Item[] inventario = new Item[10];
    private String nome;
    private int numero;
    private boolean turno;
    
    public void mostraInventario(){
        for (int i=0;i<this.inventario.length;i++){
            if(this.inventario[i]!=null){
            System.out.println(this.inventario[i].getNome());
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
        Scanner in = new Scanner(new FileReader("arq.txt"));
        for(int i=0; in.hasNextLine();i++) {
            if(in.nextLine()=="Orbe"){
                this.inventario[i]= new ItemMago();
            }else if(in.nextLine()=="Band-aid"){
                this.inventario[i] = new ItemSuporte();
            }else if(in.nextLine()=="Armadura"){
                this.inventario[i] = new ItemTank();
            }else if(in.nextLine()=="Poção de cura"){
                this.inventario[i] = new ItemGenerico();
            }     
        }
        in.close();
     }      
            
            
    public void fimArquivo() throws IOException{
        BufferedWriter w1 = new BufferedWriter(new FileWriter(this.getNome()+".txt"));
        for(int i=0; i<this.inventario.length; i++) {
            w1.append(this.inventario[i].getNome()+"\n");
        }
        w1.close();
    }
    
}
