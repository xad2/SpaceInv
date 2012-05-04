package modelo;

import java.util.Observable;

public abstract class ModeloAbstrato extends Observable {
	

	public abstract void movimentarEixoX(int passo);
	
	public abstract void movimentarEixoY(int passo);
	
	public abstract void atualizar();
	
	

}