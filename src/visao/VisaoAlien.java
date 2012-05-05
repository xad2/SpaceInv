package visao;

import java.awt.Dimension;
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
		
		if(alien.getEstado() == false){
			
			imgAlien = criarColisao(new Coordenadas(alien.getX(), alien.getY()), imgAlien);
		}else
		
		
		if(!alien.estaAndando()){
			imgAlien.fixarProfundidade(-3);
			//JOptionPane.showMessageDialog(null, "X1: " + imgAlien.obterEsquerda() + "X2: " + alien.getX());
			imgAlien.desabilitar();
			
		}
		
		redesenhar(imgAlien, alien.getX(), alien.getY());
	}

}
