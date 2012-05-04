package visao;

import java.util.Observable;

import javax.swing.JOptionPane;

import modelo.Alien;
import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class VisaoAlien extends Renderizador {

	private Imagem imgAlien;
	private Alien alien;

	public VisaoAlien(PaginaDix pag, Alien alien) {
		super(pag);

		imgAlien = criarImg("alien", imgAlien, "recursos/alien.gif", 0, new Coordenadas(
				alien.getX(), alien.getY()));

		this.alien = alien;

	}



	@Override
	public void update(Observable o, Object arg) {
		//JOptionPane.showMessageDialog(null, "X1: " + imgAlien.obterEsquerda() + "X2: " + alien.getX());
		//JOptionPane.showMessageDialog(null, arg.toString());
	
		
		redesenhar(imgAlien, alien.getX(), alien.getY());
	}

}
