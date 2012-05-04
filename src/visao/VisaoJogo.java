package visao;



import modelo.Fachada;
import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

import edugraf.pichador.desenho.Pintor;

public class VisaoJogo extends Renderizador {

	private Imagem background;
	
	
	public VisaoJogo(PaginaDix pag) {
		super(pag);
		
		criarImg("Background", background, "recursos/background.jpeg", 0,
				new Coordenadas(0, 0));
			}

	

	

}
