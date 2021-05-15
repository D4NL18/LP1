
public class ItemTank extends Item{
	
    private int vida = 20;
      
    @Override
    public void equipar(Personagem per){
        per.setItem(true);
        per.setVida(per.getVida() + this.getVida());
    }

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}


    
}
