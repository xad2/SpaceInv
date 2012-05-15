package modelo;

public class Fachada {

	private Nave naveMae;
	


	public Fachada(Nave naveMae) {

		this.naveMae = naveMae;
		

	}
	
	public void movimentarNaveNoEixoX(int p) {
		
		
		naveMae.movimentarEixoX(p);

	}

	public void movimentarNaveNoEixoY(int p) {

		naveMae.movimentarEixoY(p);

	}

}
