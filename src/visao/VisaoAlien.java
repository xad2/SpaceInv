package visao;

import modelo.Alien;
import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class VisaoAlien extends Renderizador {

	private Imagem imgAlien;
	private Alien alien;
	private static int n = 0;

	public VisaoAlien(PaginaDix pag, Alien alien) {
		super(pag);

		n++;
		imgAlien = criarImg("alien" + n, "recursos/alien" + n % 2 + ".gif", 0,
				new Coordenadas(alien.getX(), alien.getY()));

		this.alien = alien;
		alien.adicionarObservador(this);

	}

	public void desabilitar() {

		super.desabilitar(imgAlien);
	}

	@Override
	public void atualizar(String codigo) {

		redesenhar(imgAlien, alien.getX(), alien.getY());
	}

}
