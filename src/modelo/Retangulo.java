package modelo;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;


public abstract class Retangulo  extends ModeloAbstrato {

	
	
	
	public Rectangle criarRetangulo(Dimension d){
		
		return new Rectangle(d);
	}
	
	
	public Rectangle criarRetangulo(Point p, Dimension d){
		
		return new Rectangle(p,d);
	}
	
	
	
	
	
	

}
