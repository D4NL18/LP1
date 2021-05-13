/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racobafoda.lp1;


public class Mago extends PersonagemComMana{
    
    private int manaM;
    
    public Mago(String nome) {
        super(nome);
        this.setVida(1);
        this.setRange(3);
        this.setMana(1);
        this.setItem(false);
        if(this.getNome()=="Dr. Estranho")this.setVisual("M1");
        else if(this.getNome()=="Toge Inumaki")this.setVisual("M2");
        
    }
    @Override
    public void atacar(Tabuleiro tabu, Personagem pAtacado,int x, int y){
        if(!this.getItem()){
            if(this.getNome()=="Dr. Estranho")System.out.println(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua magia");
            else if(this.getNome()=="Toge Inumaki")System.out.println(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua palavra amaldiçoada de nivel 1");
            System.out.println("+1 de Mana");
            pAtacado.setVida(pAtacado.getVida() - 3 + pAtacado.getDefesa());
            if(pAtacado.getVida()>0)System.out.println("Foi causado 3 de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
            else{
                System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                tabu.remover(tabu, x, y);
            }
            this.setMana(getMana()+1);
        }else{
            if(this.getNome()=="Dr. Estranho")System.out.println(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" usando sua orbe");
            else if(this.getNome()=="Toge Inumaki")System.out.println(this.getNome()+" atacou  inimigo: "+pAtacado.getNome()+" com sua palavra amaldiçoada de nivel 2");
            System.out.println("+1 de Mana");
            pAtacado.setVida(pAtacado.getVida() - 5 + pAtacado.getDefesa());
            if(pAtacado.getVida()>0)System.out.println("Foi causado 5 de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
            else{
                System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                tabu.remover(tabu, x, y);
            }
            this.setItem(false);
            this.setMana(getMana()+1);
        }
    }
    @Override
    public void ataqEsp(Tabuleiro tabu, Personagem pAtacado,int x, int y){
        if(!this.getItem()){
            manaM = getMana();
            if(manaM == 2){
                if(this.getNome()=="Dr. Estranho")System.out.println(this.getNome()+" usou sua jóia do tempo para paralisar e atacar o inimigo: "+pAtacado.getNome());
                else if(this.getNome()=="Toge Inumaki")System.out.println(this.getNome()+" recitou sua palavra proibida e inflingou grandes danos em: "+pAtacado.getNome());
                pAtacado.setVida(pAtacado.getVida() - 6);
                if(pAtacado.getVida()>0)System.out.println("Foi causado 6 de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
                else{
                System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                tabu.remover(tabu, x, y);
            }
                this.setMana(0);
            }
        }else{
            manaM = getMana();
            if(manaM == 2){
                if(this.getNome()=="Dr. Estranho")System.out.println(this.getNome()+" usou sua jóia do tempo amplificada pela orbe para viajar para o passado e atacar o inimigo: "+pAtacado.getNome()+" enquanto ainda era jovem");
                else if(this.getNome()=="Toge Inumaki")System.out.println(this.getNome()+" recitou sua palavra proibida mais poderosa e inflingou grandes danos nos órgãos do oponente "+pAtacado.getNome());
                pAtacado.setVida(pAtacado.getVida() - 10);
                if(pAtacado.getVida()>0)System.out.println("Foi causado 10 de dano ao inimigo "+pAtacado.getNome()+" restando "+pAtacado.getVida()+" de vida");
                else{
                System.out.println(this.getNome()+" causou dano suficiente para eliminar o inimigo!");
                tabu.remover(tabu, x, y);
            }
                this.setItem(false);
                this.setMana(0);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
