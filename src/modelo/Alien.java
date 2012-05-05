package modelo;

import java.awt.Rectangle;

public class Alien extends ModeloAbstrato {

	private Rectangle retAlien;
	private Movimentador movimentador;
	private boolean andando = true;
	private boolean estado = true;
	private Espaco espaco;

	public Alien(Espaco espaco) {

		retAlien = espaco.pegarRetangAlien();
		gerarPosicaoDefault();
		this.espaco = espaco;
		movimentador = new Movimentador(retAlien, espaco.pegarRetangEspaco());

	}

	public void gerarPosicaoDefault() {

		int r = (int) (100 + Math.random() * 300);

		retAlien.setLocation(967, r);

	}

	public Rectangle getRetAlien() {
		return retAlien;
	}

	public int getX() {
		return (int) retAlien.getX();
	}

	public int getY() {
		return (int) retAlien.getY();
	}

	public boolean contem(Rectangle r) {

		return retAlien.contains(r);
	}

	public boolean intersecciona(Rectangle r) {

		return retAlien.intersects(r);
	}

	@Override
	public void movimentarEixoX(int passo) {

		movimentador.movimentarEixoX(passo);

		if (!espaco.contem(retAlien)) {
			andando = false;
		}
		
		atualizar();
	}

	@Override
	public void movimentarEixoY(int passo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar() {
		setChanged();
		notifyObservers();

	}

	public boolean estaAndando() {
		return andando;
	}

	public boolean getEstado() {
		return estado;
	}

	public void explodir() {
		estado = false;

		atualizar();
	}

}
