package racobafoda.lp1;


public abstract class PersonagemComMana extends Personagem{
        
	private int mana;

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
        
        public PersonagemComMana(String nome) {
        super(nome);
    }
        
}