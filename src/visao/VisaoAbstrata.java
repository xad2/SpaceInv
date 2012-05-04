package visao;

import java.util.Observable;
import java.util.Observer;

public abstract class VisaoAbstrata extends Observable implements Observer {

	

	

	public abstract void redesenhar();
	
	
}
