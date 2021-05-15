package racobafoda.lp1;

public class ItemGuerreiro extends Item {

    private int vida = 15;
    private int dano = 5;

    @Override
    public void equipar(Personagem per) {
        per.setItem(true);
        per.setVida(per.getVida() + this.getVida());
        per.setDano(per.getDano() + this.getDano());
    }

    public int getVida() {
        return vida;
    }

    public int getDano() {
        return dano;
    }

    public ItemTank(){
        this.setNome("Manopla");
    }

}
