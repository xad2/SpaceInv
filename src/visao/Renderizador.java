package visao;

import java.util.Observable;

import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class Renderizador extends VisaoAbstrata {

	private PaginaDix pag;

	public Renderizador(PaginaDix pag) {
		this.pag = pag;
	}

	public Imagem criarImg(String nomeImg, String caminho,
			int profundidade, Coordenadas coord) {

		Imagem imagem;
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
	public void redesenhar(Imagem img, int x, int y) {
		img.fixarEsquerda(x);
		img.fixarTopo(y);

	}
	
	public Imagem criarColisao(Coordenadas coord, String nome, int n){
		return criarImg(nome, "recursos/colisao" + n + ".gif",0, coord);
		
	}
	
	public void desabilitar(Imagem imagem){
		
		imagem.fixarProfundidade(-5);
		imagem.tornarInvisivel();
		imagem.desabilitar();
		
	}
	
	
	
	

}
