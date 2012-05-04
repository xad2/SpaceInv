package visao;

import java.util.Observable;
import java.util.Observer;

import edugraf.jadix.componentesDix.Imagem;

public abstract class VisaoAbstrata extends Observable implements Observer {

	

	

	public abstract void redesenhar(Imagem imagem, int x, int y);
	
	
}
