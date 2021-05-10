package racobafoda.lp1;
public class Tank extends Personagem{
	
	private boolean espTank = false;
    
    public Tank(String nome) {
        super(nome);
        this.setVida(150);
        this.setRange(3);
        this.setVisual("T1");
    }
    @Override
    public void atacar(Personagem pAtacado){
        System.out.println(this.getNome()+"Socando o inimigo: "+pAtacado.getNome());
        pAtacado.setVida(pAtacado.getVida() - 3);

    }
    @Override
    public void ataqEsp(Personagem pAtacado){
    	System.out.println(this.getNome()+"impedindo o inimigo "+pAtacado.getNome()+"de atacar durante 1 rodada");
    	setEsp(true);
    }
    
	public boolean getEsp() {
		return espTank;
	}
	public void setEsp(boolean espTank) {
		this.espTank = espTank;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
