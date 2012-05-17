package geometria;

public class Ponto {
	
	private int x;
	private int y;
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void movimentarX(int dx){
		
		 this.x += dx;
	}
	
	public void movimentarY(int dy){
		this.y += dy;
	}
	
	
	public int distanciaEntre(int x, int y ){
		
		int x0 = this.x;
		int y0 = this.y;
		
		int distancia = (y - y0) + (x - x0);
		
		
		return distancia;

	}

}
