package util;


import java.util.ArrayList;
import java.util.List;

public abstract class Observavel {
	
	
	private List<Observador> observadores = new ArrayList<Observador>();
	
	
	public void adicionarObservador(Observador o) {
		observadores.add(o);
	}
	
	
	public void notificarObservadores(String argumento) {
		for (Observador obs : observadores) {
			obs.atualizar(argumento);
		}
	}
}
