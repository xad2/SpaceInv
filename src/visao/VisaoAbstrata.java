package visao;

import util.Observador;
import util.Observavel;
import edugraf.jadix.componentesDix.Imagem;

public abstract class VisaoAbstrata extends Observavel implements Observador{

	public abstract void redesenhar(Imagem imagem, int x, int y);

}
