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

		movimentador = new Movimentador(retAlien, espaco.retangulo());
		estado = Estado.VIVO;
	}

	public void setaPosicao(int x, int y) {

		retAlien.setLocation(initialX, initialY);
		atualizar(new String(initialX + "/" + initialY));

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

	public boolean movimentarEixoX(int passo) {

		int x = (int) retAlien.getX() + passo;
		boolean movimentou = movimentador.movimentarEixoX(x);

		if (movimentou) {

			atualizar(new String(x + "/"));
		}

		return movimentou;
	}

	public boolean movimentarEixoY(int passo) {
		return false;
	}

	@Override
	public void atualizar(String argumento) {
		notificarObservadores(argumento);

	}

	public Estado getEstado() {
		return estado;
	}

	public void explodir() {
		estado = Estado.COLIDIU;

		atualizar(new String("Colidiu/"));
	}

	public void resetaPosicao(int newY) {

		retAlien.setLocation(initialX, newY);

		String x = initialX + "/" + newY;
		atualizar(x);

	}

}
