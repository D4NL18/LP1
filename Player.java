/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;

/**
 *
 * @author Bruno
 */
public class Player {

  
    
    
    private String nome;
    private int numero;
    private boolean turno;
    
    
    
    public boolean validaPeca(Tabuleiro tabu,int x,int y){
       if(tabu.descobreTabu(tabu)[x][y]!=null){
        int n = Integer.parseInt(tabu.descobreTabu(tabu)[x][y].visual.substring(1));
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
    
    
    
    
    
}
