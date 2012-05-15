package visao;

import java.util.Observable;

import controle.ConfigObservador;
import controle.ControladorDaNave;

import modelo.Estado;
import modelo.Nave;
import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class VisaoNave extends Renderizador {

	private Imagem imgNave;
	private ControladorDaNave cNave;
	
	
	
	public VisaoNave(PaginaDix pag,ControladorDaNave cNave) {
		super(pag);
		this.cNave = cNave;
		this.imgNave = criarImg("Nave", "recursos/nave.png", 0,
				new Coordenadas(cNave.getNaveMae().getXDefault(), cNave.getNaveMae().getYDefault()));
	
		new ConfigObservador(cNave.getNaveMae(), this);

	}

	@Override
	public void update(Observable o, Object arg) {

		if (cNave.colidiu()){
			desabilitar();
			criarColisao(cNave.getCoord(), "ColisaoNave", 1);
		}

		redesenhar(imgNave, cNave.getNaveMae().getX(), cNave.getNaveMae().getY());

	}
	
	public void desabilitar() {
		
		super.desabilitar(imgNave);
	}

	
	

}