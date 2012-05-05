package modelo;

import java.awt.Rectangle;
import java.util.Observable;

public class Nave extends Espaco {

	private Rectangle retNave;
	private Movimentador movimentador;
	private boolean estado = true;

	
	public Nave(Espaco espaco) {

		retNave = espaco.pegarRetangNave();
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

	public void movimentarEixoX(int p) {

		movimentador.movimentarEixoX(p);
		
		atualizar();

	}

	public void movimentarEixoY(int p) {

		movimentador.movimentarEixoY(p);

		atualizar();
	}

	public void parar() {

		retNave.setLocation((int) retNave.getX(), (int) retNave.getY());
		atualizar();

	}
	
	public boolean getEstado(){
		return estado;
	}
	
	

	@Override
	public void atualizar() {
		setChanged();
		notifyObservers();
	}

	public void explodir() {
		estado =false;
		
		atualizar();
	}

}
