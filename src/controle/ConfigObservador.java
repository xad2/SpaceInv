package controle;

import java.util.Observable;
import java.util.Observer;

public class ConfigObservador extends ControleAbstrato {

	
	
	
	public ConfigObservador(Observable o, Observer observer){
		
		
		o.addObserver(observer);
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		
	}
	
	

}
