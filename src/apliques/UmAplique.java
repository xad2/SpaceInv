package apliques;

import javax.swing.JOptionPane;

import controle.ControladorDoJogo;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;

public class UmAplique extends Aplique {

	PaginaDix pagina = obterPaginaDix();
	@Override
	public void iniciar() {


		
		ControladorDoJogo controladorDoJogo = new ControladorDoJogo(pagina);
		
		int condicao = 0;
		
		do{	condicao = JOptionPane.showConfirmDialog(null, "Pronto ", "Pergunta", 1);
	
		}while(condicao != 0);
		
		
		boolean jogoEmAndamento = true;
		while (jogoEmAndamento) {
			
			jogoEmAndamento = controladorDoJogo.receberTick();			
			
		}

	}
}