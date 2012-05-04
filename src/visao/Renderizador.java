package visao;



import java.util.Observable;

import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class Renderizador extends VisaoAbstrata {

	
	
	
	protected PaginaDix pag;
	
	
	
	public Renderizador(PaginaDix pag){
		this.pag = pag;
		
	}
	
	public Imagem criarImg(String nomeImg, Imagem imagem,
			String caminho, int profundidade, Coordenadas coord) {
		
		
		imagem = pag.criarComponente(TiposDeComponentesDix.IMAGEM, nomeImg);
		imagem.fixarURI(caminho);
		imagem.fixarProfundidade(profundidade);
		imagem.fixarCoordenadas(coord);
		return imagem;
		
	}
	
	

	
	@Override
	public void update(Observable o, Object arg) {
		
		

		
	}

	@Override
	public void redesenhar() {
		// TODO Auto-generated method stub
		
	}

	

	

	
	
	
	
}
