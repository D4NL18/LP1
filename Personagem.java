package racobafoda.lp1;


public abstract class Personagem {
	private String nome;
	private int vida;
	private int defesa;
	private int item;
	private int range;
	private int posicao[][];
	
	public abstract void atacar(Personagem pAtacado);
	
	public abstract void movimentar();
	
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
	public int[][] getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao[][]) {
		this.posicao = posicao;
	}
        
        
        public Personagem(String nome){
        this.nome = nome;
    }
        
        
}
