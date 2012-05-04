package apliques;

import javax.swing.JOptionPane;

import controle.ConfigObservador;
import controle.TratadorDeEvento;
import visao.VisaoJogo;
import visao.VisaoNave;
import modelo.Espaco;
import modelo.Fachada;
import modelo.Nave;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;

public class UmAplique extends Aplique {

	PaginaDix pagina = obterPaginaDix();
	Fachada fachada;
	Nave naveMae;
	VisaoNave vNave;
	Espaco espaco;

	@Override
	public void iniciar() {

		espaco = new Espaco();
		naveMae = new Nave(espaco);
		fachada = new Fachada(naveMae);

		new VisaoJogo(pagina);
		vNave = new VisaoNave(pagina, naveMae);

		new ConfigObservador(naveMae, vNave);
		new TratadorDeEvento(pagina, fachada);
		
		

	}
}