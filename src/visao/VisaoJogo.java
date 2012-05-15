package visao;

import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class VisaoJogo extends Renderizador {
	private Imagem background;
	
	public VisaoJogo(PaginaDix pag) {
		super(pag);

		background = criarImg("Background", "recursos/background.jpeg", 0,
				new Coordenadas(0, 0));
	}
	
	public VisaoJogo(PaginaDix pag, String caminho) {
		super(pag);

		background = criarImg("Background", caminho  , 1,
				new Coordenadas(0, 0));
	}

	public void trocarCaminho(String caminho){
		
		background.fixarURI(caminho);
	}
	
	
	public void desabilitar() {
		
		super.desabilitar(background);
	}

}
