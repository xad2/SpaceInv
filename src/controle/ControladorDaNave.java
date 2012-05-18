package controle;

import javax.swing.JOptionPane;

import modelo.Nave;
import visao.VisaoNave;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class ControladorDaNave extends ControleAbstrato {

	private Nave naveMae;
	private VisaoNave vNave;

	public ControladorDaNave(Nave naveMae, VisaoNave vNave) {

		this.naveMae = naveMae;
		this.vNave = vNave;
		naveMae.adicionarObservador(vNave);
		naveMae.adicionarObservador(this);

	}

	@Override
	public void atualizar(String codigo) {

		if (codigo.equals("Colidiu/")) {
			JOptionPane.showMessageDialog(null, codigo);
			vNave.desabilitar();
			vNave.criarColisao(new Coordenadas(naveMae.getX(), naveMae.getY()),
					"ColisaoNave", 1);

		}

	}

}
