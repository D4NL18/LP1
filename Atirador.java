
package com.ninacalheira.lp1;


public class Atirador extends Personagem {
    
    private boolean espAtirador = false;
    
    public Atirador(String nome){
		super(nome);
		this.setVida(90);
		this.setRange(2);
                this.setVisual('A');
	}
    
    @Override
    public void atacar(Personagem pAtacado){
        System.out.println(this.getNome()+" atira em "+pAtacado.getNome());
        pAtacado.setVida(pAtacado.getVida() - 3);

    }

    
    @Override
    public void ataqEsp(Personagem pAtacado) {
        System.out.println(this.getNome()+" atira esmagadoramente em  "+pAtacado.getNome());
        pAtacado.setVida(pAtacado.getVida() - 6);
    }
    
    public boolean getEsp() {
		return espAtirador;
	}
	public void setEsp(boolean espAtirador) {
		this.espAtirador = espAtirador;
	}
    
}
