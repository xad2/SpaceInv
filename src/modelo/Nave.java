package modelo;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;

public class Nave extends ModeloAbstrato {

	private Rectangle retNave;
	private Movimentador movimentador;
	private Estado estado = Estado.VIVO;

	public Nave(Espaco espaco) {

		retNave = new Rectangle(new Dimension(50, 45));
		setPosicaoDefault();
		movimentador = new Movimentador(retNave, espaco.pegarRetangEspaco());

	}

	public void setPosicaoDefault() {

		retNave.setLocation(240, 240);

		atualizar();

	}

	public int getXDefault() {
		return 240;
	}

	public int getYDefault() {
		return 240;
	}

	public boolean intersecciona(Rectangle r) {

		return retNave.intersects(r);
	}

	public int getX() {

		return (int) retNave.getX();
	}

	public int getY() {

		return (int) retNave.getY();
	}

	public boolean movimentarEixoX(int p) {

		movimentador.movimentarEixoX(p);

		atualizar();

		return true;
	}

	public boolean movimentarEixoY(int p) {

		movimentador.movimentarEixoY(p);

		atualizar();

		return true;
	}

	public Estado getEstado() {
		return estado;
	}

	@Override
	public void atualizar() {
		setChanged();
		notifyObservers();
	}

	public void explodir() {
		estado = Estado.COLIDIU;

		atualizar();
	}

}
