public class Warrior extends Personagem{

	private boolean espWarrior = false;
	private int ad = 6;

	public Warrior(String nome){
		super(nome);
		this.setVida(75);
		this.setRange(2);
	}

	@Override
	public void atacar(Personagem pAtacado){
		if(!getEspWarrior()){
			System.out.println(this.getNome()+"Atacando o inimigo: "+pAtacado.getNome());
			pAtacado.setVida(pAtacado.getVida() - this.getAd());
		} else{
			// por para o ataque afetar a área ao redor.
		}
	}
	
	@Override
	public void ataqEsp(Personagem pAtacado){
		System.out.println(this.getNome()+" entrou em modo Berserk, ganhando dano de ataque e dano em área.");
		this.setEspWarrior(true);
		this.setAd(this.getAd() + 4);
		this.setRange(4);
	}

	@Override
	public void movimentar(){
		
	}

	public boolean getEspWarrior(){
		return this.espWarrior;
	}

	public void setEspWarrior(boolean value){
		this.espWarrior = value;
	}

	public boolean getAd(){
		return this.ad;
	}

	public void setAd(int value){
		this.ad = value;
	}
}