package modelo;

import java.awt.Rectangle;

public class Alien extends ModeloAbstrato {

	private Rectangle retAlien;
	private Movimentador movimentador;

	public Alien(Espaco espaco) {

		retAlien = espaco.pegarRetangAlien();
		geraPosicaoDefault();

		movimentador = new Movimentador(retAlien, espaco.pegarRetangEspaco());

	}

	public void geraPosicaoDefault() {

		int r = (int) (100 + Math.random() * 300);

		retAlien.setLocation(967, r);

	}
	
	public int getX(){
		return (int)retAlien.getX();
	}
	
	public int getY(){
		return (int)retAlien.getY();
	}

	@Override
	public void movimentarEixoX(int passo) {

		
		
		movimentador.movimentarEixoX(passo);
		
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

}
