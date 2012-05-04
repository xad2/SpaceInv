package visao;

import java.util.Observable;

import modelo.Nave;
import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class VisaoNave extends Renderizador {

	private Imagem nave;
	private Nave naveMae;
	
	public VisaoNave(PaginaDix pag, Nave naveMae) {
		super(pag);
		this.nave = criarImg("Nave", nave, "recursos/nave.png", 0,
				new Coordenadas(naveMae.getXDefault(), naveMae.getYDefault()));
		
		this.naveMae = naveMae;

	}

	
	public void redesenhar(){
		
		nave.fixarEsquerda( naveMae.retornaX());
		nave.fixarTopo(naveMae.retornaY());
	}

	
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		
		this.redesenhar();
		

	}
	

	
}