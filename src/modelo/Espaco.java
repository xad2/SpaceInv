package modelo;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Collection;

import javax.swing.JOptionPane;

public class Espaco extends Retangulo {

	private Rectangle espaco;
	private Rectangle retNave;
	private Rectangle retAlien;

	public Espaco() {

		espaco = criarRetangulo(new Dimension(1000, 480));
		criarMundo();
		

	}

	public void criarMundo() {

		retAlien = criarRetangulo(new Dimension(33, 35));
		espaco.add(retAlien);

		retNave = criarRetangulo(new Dimension(70, 70));
		espaco.add(retNave);

	}

	public boolean contem(Rectangle r) {

		return espaco.contains(r);
	}

	public Rectangle pegarRetangEspaco() {

		return espaco;
	}

	public Rectangle retornarLimites() {

		return espaco.getBounds();

	}

	public double getMaxX() {

		return espaco.getMaxX();
	}

	public double getMaxY() {
		return espaco.getMaxY();
	}

	public Rectangle pegarRetangNave() {

		return retNave;
	}

	public Rectangle pegarRetangAlien() {
		return retAlien;
	}

	@Override
	public void movimentarEixoX(int passo) {
		// TODO Auto-generated method stub

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
