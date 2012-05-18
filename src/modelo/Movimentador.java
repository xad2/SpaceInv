package modelo;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Movimentador {

	private Rectangle retangulo;
	private Rectangle espaco;

	public Movimentador(Rectangle retangulo, Rectangle espaco) {

		assert(espaco.contains(retangulo));
		
		this.espaco = espaco;
		this.retangulo = retangulo;
	}
	
	public boolean movimentarEixoX(int novoX) { 

		

		retangulo.setLocation(novoX, retangulo.y);

		return !consertaLimite();
	}
	
	public boolean movimentarEixoY(int novoY) {
		

		retangulo.setLocation(retangulo.x, novoY);
		
		return !consertaLimite();
	}

	public boolean consertaLimite() {

		boolean fixed = false;
		
		if (espaco.getMaxX() < retangulo.getMaxX()) {
			retangulo.setLocation((int) espaco.getMaxX() - retangulo.width,
					(int) retangulo.getY());
			
			fixed = true;
		}
		
		if (espaco.getX() > retangulo.getX()) 
		{
			retangulo.setLocation((int) espaco.getX(), 
					(int) retangulo.getY());
			
			fixed = true;
		}

		if (espaco.getMaxY() < retangulo.getMaxY() ) {

			retangulo.setLocation((int) retangulo.getX(),
					(int) espaco.getMaxY()- retangulo.height) ;

			fixed = true;
		}
		
		if (espaco.getY() > retangulo.getY()) {

			retangulo.setLocation((int) retangulo.getX(), (int) espaco.getY());
			fixed = true;
		}

		return fixed;
	}


	

	
	
	

}
