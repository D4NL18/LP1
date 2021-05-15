package racobafoda.lp1;

import java.util.ArrayList;

public class Guerreiro extends Personagem {

	private int cooldown = 2;

	public Guerreiro(String nome) {
		super(nome);
		this.setVida(120);
		this.setDefesa(20);
		this.setRange(1);
		this.setDano(20);
		this.setItem(false);
		if (this.getNome().equals("Zoro")) {
			this.setVisual("G1");
		} else {
			this.setVisual("G2");
		}
	}

	@Override
	public void atacar(Tabuleiro tabu, Personagem pAtacado, int x, int y) {
		if (tabu.descobreTabu(tabu)[x][y] != null) {
			if (this.getNome().equals("Zoro")) {
				System.out.println(this.getNome() + " cortou o seu inimigo " + pAtacado.getNome() + " com a Shusui");
			} else {
				System.out.println(
						this.getNome() + " cortou o seu inimigo " + pAtacado.getNome() + " com o Machado Leviatã");
			}
			pAtacado.setVida(pAtacado.getVida() - (this.getDano() * (100 - pAtacado.getDefesa()) / 100));

			if (pAtacado.getVida() > 0) {
				System.out.println("Foi causado " + this.getDano() + " de dano ao inimigo " + pAtacado.getNome()
						+ " restando " + pAtacado.getVida() + " de vida");
			} else {
				System.out.println(this.getNome() + " causou dano suficiente para eliminar o inimigo!");
				tabu.remover(tabu, x, y);
			}

			if (this.getItem()) {
				this.setItem(false);
				this.setDano(this.getDano() - 5);
			}
		}
	}

	@Override
	public void ataqEsp(Tabuleiro tabu, Personagem pAtacado, int x, int y) {
		int xPos[] = { x - 1, x - 1, x - 1, x, x, x + 1, x + 1, x + 1 };
		int yPos[] = { y - 1, y, y + 1, y - 1, y + 1, y - 1, y, y + 1 };

		if (this.getNome().equals("Zoro")) {
			System.out.println(this.getNome() + " usou o golpe Kokujo O Tatsumaki!");
		} else {
			System.out.println(this.getNome() + " usou a Fúria Espartana!");
		}

		for (int i = 0; i < 8; i++) {
			Personagem persoAtacked = tabu.descobreTabu(tabu)[xPos[i]][yPos[i]];
			if (persoAtacked != null) {
				persoAtacked
						.setVida(persoAtacked.getVida() - (this.getDano() * (100 - persoAtacked.getDefesa()) / 100));

				if (persoAtacked.getVida() > 0) {
					System.out.println("Foi causado " + this.getDano() + " de dano ao inimigo " + persoAtacked.getNome() + " restando " + persoAtacked.getVida() + " de vida");
				} else {
					System.out.println(this.getNome() + " causou dano suficiente para eliminar o inimigo!");
					tabu.remover(tabu, xPos[i], yPos[i]);
				}
			}
		}

		if (this.getItem()) {
			this.setItem(false);
			this.setDano(this.getDano() - 5);
		}
	}
}