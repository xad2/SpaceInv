package visao;

import modelo.Nave;
import controle.ControladorDaNave;
import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class VisaoNave extends Renderizador {

	private Imagem imgNave;
	
	public VisaoNave(PaginaDix pag, Nave naveMae) {
		super(pag);

		this.imgNave = criarImg("Nave", "recursos/nave.png", 0,
				new Coordenadas(240, 240));
		new ControladorDaNave(naveMae, this);
		
		

	}

	@Override
	public void atualizar(String codigo) {

		codigo.trim();

		if (!codigo.equals("Colidiu/")) {
			String[] valores = codigo.split("/");
			String a = valores[0];
			int x = Integer.parseInt(a);
			String b = valores[1];
			int y = Integer.parseInt(b);

			imgNave.fixarEsquerda(x);
			imgNave.fixarTopo(y);
		}

	}

	public void desabilitar() {

		super.desabilitar(imgNave);
	}

}