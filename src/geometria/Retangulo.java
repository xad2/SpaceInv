package geometria;

import java.util.ArrayList;


public class Retangulo {

	private Ponto ponto;
	private Dimensao dimensao;
	private ArrayList<Ponto> pontosLimites;

	

	public Retangulo(Dimensao d) {
		this.dimensao = d;
		this.ponto = new Ponto(0, 0);
			
		this.pontosLimites = construirPontosLimites(ponto, dimensao);
		 
	}

	private ArrayList<Ponto> construirPontosLimites(Ponto ponto, Dimensao dimensao) {
		
		ArrayList<Ponto> pontosLimites = new ArrayList<Ponto>();
		Ponto pontoTopRight = new Ponto(ponto.getX() + dimensao.getLargura(),
				ponto.getY());
		pontosLimites.add(0, pontoTopRight);
		Ponto pontoBottomLeft = new Ponto(ponto.getX(), ponto.getY()
				+ dimensao.getAltura());
		pontosLimites.add(1, pontoBottomLeft);
		
		Ponto pontoMax = new Ponto(ponto.getX() + dimensao.getLargura(),
				ponto.getY() + dimensao.getAltura());
		pontosLimites.add(2, pontoMax);
		
	
		
		return pontosLimites;

	}

	public int getAltura() {
		return dimensao.getAltura();
	}

	public int getX() {
		return ponto.getX();
	}

	public int getY() {
		return ponto.getY();
	}

	public int getMaxX() {

		return ponto.getX() + getLargura();
	}

	public int getMaxY() {

		return ponto.getY() + getAltura();
	}

	public int getLargura() {
		return dimensao.getLargura();
	}
	
	
	public Ponto getPontoTopRight() {
		return pontosLimites.get(0);
	}

	public Ponto getPontoMax() {
		return pontosLimites.get(2);
	}

	public Ponto getPontoBottomLeft() {
		return pontosLimites.get(1);
	}

	public Ponto getPontoTopLeft() {
		return ponto;
	}

	public boolean contem(Ponto p) {

		int x0 = this.getX();
		int y0 = this.getY();
		int maxX = getMaxX();
		int maxY = getMaxY();

		int x = p.getX();
		int y = p.getY();

		if (x > maxX || x < x0 && y > maxY || y < y0)
			return false;

		return true;

	}

	public boolean contem(Retangulo r) {

		if (this.contem(r.getPontoBottomLeft()) && this.contem(r.getPontoMax())
				&& this.contem(r.getPontoTopLeft())
				&& this.contem(r.getPontoTopRight()))
			return true;
		return false;
	}

	public boolean intersecciona(Retangulo r) {

		if (this.contem(r.getPontoBottomLeft()) || this.contem(r.getPontoMax())
				|| this.contem(r.getPontoTopLeft())
				|| this.contem(r.getPontoTopRight()))
			return true;
		
		if(r.contem(this.getPontoBottomLeft()) || r.contem(this.getPontoTopLeft() )
				|| r.contem(this.getPontoMax()) || r.contem(this.getPontoTopRight()))
			return true;
		
		return false;

	}

	public void mudaPosicao(int x, int y) {

		ponto.movimentarX(x);
		ponto.movimentarY(y);
		for (Ponto pontop : pontosLimites) {
			pontop.movimentarX(x);
			pontop.movimentarY(y);
		}

	}
	public void setaPosicao(int x, int y) {

		ponto.setX(x);
		ponto.setY(y);
		for (Ponto pontop : pontosLimites) {
			pontop.movimentarX(x);
			pontop.movimentarY(y);
		}
		

	}
	

}
