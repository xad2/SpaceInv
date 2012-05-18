package modelo;

import java.awt.Dimension;
import java.awt.Rectangle;

public class Nave extends ModeloAbstrato {

	private Rectangle retNave;
	private Movimentador movimentador;
	private Estado estado = Estado.VIVO;

	public Nave(Espaco espaco) {

		retNave = new Rectangle(new Dimension(50, 45));
		setPosicaoDefault();
		movimentador = new Movimentador(retNave, espaco.retangulo());

	}

	public void setPosicaoDefault() {

		retNave.setLocation(240, 240);

		atualizar("240/240");

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

		int y = (int) (retNave.getY());
		int x = p + (int) retNave.getX();
		movimentador.movimentarEixoX(x);

		atualizar(x + "/" + y);

		return true;
	}

	public boolean movimentarEixoY(int p) {

		int y = (int) (p + retNave.getY());
		int x = (int) retNave.getX();
		movimentador.movimentarEixoY(y);

		atualizar(new String(x + "/" + y));

		return true;
	}

	public Estado getEstado() {
		return estado;
	}

	@Override
	public void atualizar(String argumento) {
		notificarObservadores(argumento);
	}

	public void explodir() {
		estado = Estado.COLIDIU;

		atualizar(new String("Colidiu/"));
	}

}
