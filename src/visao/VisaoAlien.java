package visao;

import java.util.Observable;

import javax.swing.JOptionPane;

import controle.ConfigObservador;

import modelo.Alien;
import modelo.Estado;
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
		imgAlien = criarImg("alien" + n, "recursos/alien"+ n% 2 + ".gif", 0,
				new Coordenadas(alien.getX(), alien.getY()));


		
		this.alien = alien;
		new ConfigObservador(alien, this);

	}
	
	public void desabilitar() {
		
		super.desabilitar(imgAlien);
	}

	@Override
	public void update(Observable o, Object arg) {


		redesenhar(imgAlien, alien.getX(), alien.getY());
	}

}
