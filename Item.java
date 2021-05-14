package racobafoda.lp1;

public abstract class Item {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
        
        public abstract void equipar(Personagem per);
            
        public Item(){
        this.nome = "Orbe";
    }
}
