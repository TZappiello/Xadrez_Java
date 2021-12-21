package xadrez.pecas;

import bordajogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

	public Rei(Tabuleiro tabuleiro, Cores cores) {
		super(tabuleiro, cores);
	}

	@Override
	public String toString() {
		return "R";
	}

	
}
