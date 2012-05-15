package modelo;

import java.awt.Dimension;
import java.awt.Rectangle;

public class Espaco {

	private final Rectangle espaco;

	public Espaco() {

		espaco = new Rectangle(new Dimension(1000, 480));

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

}
