package aplicacao;

import xadrez.PartidaXadrez;

public class Programa {

	public static void main(String[] args) {

		PartidaXadrez partxa = new PartidaXadrez();
		UI.printTabuleiro(partxa.getPecas());
	}

}
