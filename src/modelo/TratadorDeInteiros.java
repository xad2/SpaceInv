package modelo;

import java.util.ArrayList;

public class TratadorDeInteiros {
	
	public static ArrayList<Integer> criarArrayDeInteirosDiferentes(int qtd,
			int tamMax, int tamMin, int dy) {

		ArrayList<Integer> lista = new ArrayList<Integer>(qtd);
		//inicializei
		for(int z=0; z < qtd; z++){
			lista.add(z,-50);
		}
		
		
		for (int z = 0; z < qtd; z++) {
			int cont =0;
			int r = 0;
			do {
				java.util.Random random = new java.util.Random();
				r = (int) (tamMin + random.nextDouble() * (tamMax - tamMin));
				cont++;
				if( cont == 200)
					System.out.println("Erro de diferença.");
				
			} while (nmrRepetido(z, r, lista, qtd, dy));

			lista.set(z, r);
		}

		return lista;
	}

	public static boolean nmrRepetido(int p, int re, ArrayList<Integer> lista,
			int qtd, int dy) {

		for (int k = 0; k < qtd; k++) {

			if (k == p) {

			} else if (re >= lista.get(k) - dy && re <= lista.get(k) + dy) {
				return true;

			}

		}

		return false;

	}


}
