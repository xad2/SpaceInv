package controle;

import java.util.ArrayList;

import modelo.Alien;
import modelo.Espaco;
import modelo.Fachada;
import modelo.Nave;
import modelo.TratadorDeInteiros;
import modelo.TropaAlien;
import visao.VisaoAlien;
import visao.VisaoJogo;
import visao.VisaoNave;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.Pichador;

public class ControladorDoJogo {

	private ArrayList<Alien> aliens;
	private Espaco espaco;
	private Nave naveMae;
	private Fachada fachada;
	private ArrayList<VisaoAlien> aliensViews;
	private VisaoJogo visaoJogo;
	private VisaoNave visaoNave;
	private PaginaDix pagina;
	private ControladorDaNave cNave;

	public ControladorDoJogo(PaginaDix pagina) {
		this.pagina = pagina;
		this.espaco = new Espaco();
		this.aliens = TropaAlien.criarTropaAlien(espaco);
		this.naveMae = new Nave(espaco);
		this.fachada = new Fachada(naveMae);

		this.visaoJogo = new VisaoJogo(pagina);
		this.visaoNave = new VisaoNave(pagina, naveMae);

		this.aliensViews = new ArrayList<VisaoAlien>();
		for (Alien alien : aliens)
			aliensViews.add(new VisaoAlien(pagina, alien));

		new TratadorDeEvento(pagina, fachada, this);

	}

	public boolean receberTick() {

		// atualizar modelo

		int d = 0;
		ArrayList<Integer> inteirosRand = TratadorDeInteiros
				.criarArrayDeInteirosDiferentes(6, 450, 20, 30);
		for (Alien alien : aliens) {

			if (!alien.movimentarEixoX(-5)) {

				alien.resetaPosicao(inteirosRand.get(d));
				d++;
				continue;
			}

			if (naveMae.intersecciona(alien.getRetAlien())) {

				naveMae.explodir();
				
				Pichador pichador = new Pichador();
				pichador.descansar(1);
				
				gameOver();
				return false;

			}

		}
		return true;

	}

	public void gameOver() {

		for (VisaoAlien vAlien : aliensViews) {
			vAlien.desabilitar();
		}
		visaoNave.desabilitar();
		visaoJogo.trocarCaminho("recursos/Gameover.jpg");

	}

}
