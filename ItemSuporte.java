
public class ItemSuporte extends Item{
	
    private int dano = 15;
      
    @Override
    public void equipar(Personagem per){
        per.setItem(true);
        per.setDano(per.getDano() + this.getDano());
    }

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}


    
}
