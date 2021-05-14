package racobafoda.lp1;


public abstract class Personagem {

    
	private String nome;
        private String visual;
	private int vida;
	private int defesa;
        private int dano;
	private boolean item;
	private int range;
        
	
	
	public abstract void atacar(Tabuleiro tabu,Personagem pAtacado,int x,int y);
        
        public abstract void ataqEsp(Tabuleiro tabu, Personagem pAtacado,int x, int y);

	
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
	public boolean getItem() {
		return item;
	}
	public void setItem(boolean item) {
		this.item = item;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	 public int getDano() {
        return dano;
        }
        public void setDano(int dano) {
            this.dano = dano;
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
