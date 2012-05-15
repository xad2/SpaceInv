package controle;

import java.util.Observable;

import javax.swing.JOptionPane;

import modelo.Fachada;
import edugraf.jadix.eventos.EventoDeAreaSensivel;
import edugraf.jadix.eventos.EventoDeGrade;
import edugraf.jadix.eventos.EventoDeMouse;
import edugraf.jadix.eventos.EventoDeSelecao;
import edugraf.jadix.eventos.EventoDeTeclado;
import edugraf.jadix.eventos.EventoSimples;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.NotificavelPorDix;
import edugraf.jadix.fachada.PaginaDix;

public class TratadorDeEvento extends ControleAbstrato implements
		NotificavelPorDix {

	private ControladorDoJogo controlador;
	private Fachada fachada;

	public TratadorDeEvento(PaginaDix pag, Fachada fachada, ControladorDoJogo controlador) {

		this.fachada = fachada;
		
		ComponenteDix teclado = pag.criarProcuradorDeComponente("teclado");
		teclado.adicionarTratadorDeEventos(this);
		
	}
	
	
	@Override
	public void seDito(EventoDeTeclado evento) {
		
		int tecla = evento.obterTecla();
		int dif = 1;
		
		if (evento.obterNomeDoEvento().toString() == "TECLA_REPETIDA") {
			
			
			
			
			if(tecla == 37) //esq
				fachada.movimentarNaveNoEixoX(-10);
			else if(tecla == 39) //dir
				fachada.movimentarNaveNoEixoX(10);
			else if(tecla == 38) // cima
				fachada.movimentarNaveNoEixoY(-10);
			else if(tecla == 40) 
				fachada.movimentarNaveNoEixoY(10);
		

		} 
	
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		

	}

	@Override
	public void seDito(EventoDeAreaSensivel evento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void seDito(EventoDeGrade evento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void seDito(EventoSimples evento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void seDito(EventoDeSelecao evento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void seDito(EventoDeMouse evento) {
		// TODO Auto-generated method stub

	}

}
