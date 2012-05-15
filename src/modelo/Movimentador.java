package modelo;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Movimentador extends ModeloAbstrato {

	private Rectangle retangulo;
	private Rectangle espaco;

	public Movimentador(Rectangle retangulo, Rectangle espaco) {

		assert(espaco.contains(retangulo));
		
		this.espaco = espaco;
		this.retangulo = retangulo;
	}
	
	public boolean movimentarEixoX(int passo) { 

		int x = (int) retangulo.getX();
		x += passo;

		retangulo.setLocation(x, retangulo.y);

		return !consertaLimite();
	}
	
	public boolean movimentarEixoY(int passo) {
		int y = (int) retangulo.getY();
		y += passo;

		retangulo.setLocation(retangulo.x, y);
		
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

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	

	
	
	

}
