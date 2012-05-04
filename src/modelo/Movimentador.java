package modelo;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Movimentador extends ModeloAbstrato {

	private Rectangle retangulo;
	private Rectangle espaco;

	public Movimentador(Rectangle retangulo, Rectangle espaco) {

		this.espaco = espaco;
		this.retangulo = retangulo;
	}

	public void movimentarEixoX(int passo) {
		consertaLimite();
		if (espaco.intersects(retangulo) && espaco.contains(retangulo) ) {

			int x = (int) retangulo.getX();
			x += passo;

			retangulo.setLocation(x, retangulo.y);

		}

	}

	
	@Override
	public void movimentarEixoY(int passo) {
		consertaLimite();
		if (espaco.intersects(retangulo) && espaco.contains(retangulo) ) {

			int y = (int) retangulo.getY();
			y += passo;

			retangulo.setLocation(retangulo.x, y);
		}
	}

	public void consertaLimite() {

		if (espaco.getMaxX() < retangulo.getMaxX()) {
			retangulo.setLocation((int) espaco.getMaxX() - retangulo.width,
					(int) retangulo.getY());

		} else if (espaco.getX() > retangulo.getX()) {

			retangulo.setLocation((int) espaco.getX(), 
					(int) retangulo.getY());

		}

		if (espaco.getMaxY() < retangulo.getMaxY() ) {

			retangulo.setLocation((int) retangulo.getX(),
					(int) espaco.getMaxY()- retangulo.height) ;

		} else if (espaco.getY() > retangulo.getY()) {

			retangulo.setLocation((int) retangulo.getX(), (int) espaco.getY());

		}

	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

}
