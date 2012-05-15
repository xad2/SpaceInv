package modelo;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Random;

public class Alien extends ModeloAbstrato {

	private Rectangle retAlien;
	private Movimentador movimentador;
	private Estado estado;
	private int initialX, initialY;

	public Alien(Espaco espaco, int x, int y) {

		retAlien = new Rectangle(new Dimension(25, 25));
		this.initialX = x;
		this.initialY = y;

		setaPosicao(x, y);

		movimentador = new Movimentador(retAlien, espaco.pegarRetangEspaco());
		estado = Estado.VIVO;
	}

	public void setaPosicao(int x, int y) {

		retAlien.setLocation(initialX, initialY);
		atualizar();

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
	public boolean movimentarEixoX(int passo) {

		boolean movimentou = movimentador.movimentarEixoX(passo);

		atualizar();

		return movimentou;
	}

	@Override
	public boolean movimentarEixoY(int passo) {
		return false;
	}

	@Override
	public void atualizar() {
		setChanged();
		notifyObservers();

	}

	public Estado getEstado() {
		return estado;
	}

	public void explodir() {
		estado = Estado.COLIDIU;

		atualizar();
	}

	public void resetaPosicao(int newY) {

		retAlien.setLocation(initialX, newY);
		atualizar();
	}

}
