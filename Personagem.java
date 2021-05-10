package racobafoda.lp1;


public abstract class Personagem {

    
	private String nome;
        public String visual;
	private int vida;
	private int defesa;
	private int item;
	private int range;
	
	
	public abstract void atacar(Personagem pAtacado);
        
        public abstract void ataqEsp(Personagem pAtacado);
	
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	
        
    
        public String getVisual() {
            return visual;
        }
        public void setVisual(String visual) {
            this.visual = visual;
        }

        
        public Personagem(String nome){
        this.nome = nome;
    }
        
        
}
