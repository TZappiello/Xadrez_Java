package xadrez.pecas;

import bordajogo.Tabuleiro;
import xadrez.Cores;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

	public Torre(Tabuleiro tabuleiro, Cores cores) {
		super(tabuleiro, cores);
	}

	@Override
	public String toString() {
		return "T";
	}

	
	
}
