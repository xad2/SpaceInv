package apliques;

import javax.swing.JOptionPane;

import controle.ConfigObservador;
import controle.TratadorDeEvento;
import visao.Renderizador;
import visao.VisaoAlien;
import visao.VisaoJogo;
import visao.VisaoNave;
import modelo.Alien;
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
	Alien alien;
	VisaoAlien vAlien;
	Renderizador renderizador;

	@Override
	public void iniciar() {

		final int TICKS_PER_SECOND = 15;
		final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
		final int MAX_FRAMESKIP = 5;

		long next_game_tick = System.currentTimeMillis();
		
	
		espaco = new Espaco();
		naveMae = new Nave(espaco);
		alien = new Alien(espaco);
		fachada = new Fachada(naveMae);

		
		new VisaoJogo(pagina);
		vNave = new VisaoNave(pagina, naveMae);
		vAlien = new VisaoAlien(pagina, alien);

		new ConfigObservador(naveMae, vNave);
		new ConfigObservador(alien, vAlien);

		new TratadorDeEvento(pagina, fachada);

		boolean jogoEmAndamento = true;

		while (jogoEmAndamento) {

			int loops = 0;

			while (System.currentTimeMillis() > next_game_tick
					&& loops < MAX_FRAMESKIP) {

				alien.movimentarEixoX(-15 );
				next_game_tick += SKIP_TICKS;
				loops++;
				alien.atualizar();
				
				
				
				if(naveMae.intersecciona(alien.getRetAlien())){
					
					naveMae.explodir();
					JOptionPane.showMessageDialog(null, "");
					alien.explodir();
					break;
				}
				// float interpolacao = (float) System.currentTimeMillis() +
				// SKIP_TICKS - next_game_tick / (float) SKIP_TICKS;

			}
		}

	}
}