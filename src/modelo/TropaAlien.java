package modelo;

import java.util.ArrayList;

public class TropaAlien {

	
	public TropaAlien() {

	}

	public static ArrayList<Alien> criarTropaAlien(Espaco espaco) {

		
		int x = 967;
		
		ArrayList<Integer> inteirosRand = TratadorDeInteiros.criarArrayDeInteirosDiferentes(6,450, 20, 30);

		ArrayList<Alien> tropaAlien = new ArrayList<Alien>();
		for (int i = 0; i < inteirosRand.size(); i++) {

			int r = inteirosRand.get(i);
			Alien alien = new Alien(espaco, x, r);

			

			tropaAlien.add(alien);

		}

		return tropaAlien;

	}

	
}
