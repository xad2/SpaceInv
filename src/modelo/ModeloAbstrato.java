package modelo;

import java.util.Observable;

public abstract class ModeloAbstrato extends Observable {
	

	public abstract boolean movimentarEixoX(int passo);
	
	public abstract boolean movimentarEixoY(int passo);
	
	public abstract void atualizar();
	

	
	

}