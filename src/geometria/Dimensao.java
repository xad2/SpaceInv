package geometria;

public class Dimensao {
	
	private int largura;
	private int altura;
	
	public Dimensao(int largura, int altura) {
		
		this.largura = largura;
		this.altura = altura;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public int getLargura() {
		return largura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public void setLargura(int largura) {
		this.largura = largura;
	}

}
