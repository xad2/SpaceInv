package controle;

import edugraf.jadix.tiposPrimitivos.Coordenadas;
import visao.VisaoNave;
import modelo.Estado;
import modelo.Nave;

public class ControladorDaNave {
	
	private Nave naveMae;
	
	public ControladorDaNave(Nave naveMae) {
		
		this.naveMae = naveMae;
	}
	
	public Nave getNaveMae() {
		return naveMae;
	}
	
	public boolean colidiu(){
		return naveMae.getEstado() == Estado.COLIDIU;
	}
	
	public Coordenadas getCoord(){
		
		return new Coordenadas(naveMae.getX(), naveMae.getY());
	}
	

}
