package visao;

import java.util.Observable;

import modelo.Nave;
import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class VisaoNave extends Renderizador {

	private Imagem imgNave;
	private Nave naveMae;
	
	public VisaoNave(PaginaDix pag, Nave naveMae) {
		super(pag);
		this.imgNave = criarImg("Nave", imgNave, "recursos/nave.png", 0,
				new Coordenadas(naveMae.getXDefault(), naveMae.getYDefault()));
		
		this.naveMae = naveMae;

	}

	
	

	
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		
		
		redesenhar(imgNave, naveMae.retornaX(), naveMae.retornaY() );

	}
	

	
}