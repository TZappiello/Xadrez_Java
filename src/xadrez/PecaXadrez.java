package xadrez;

import bordajogo.Peca;
import bordajogo.Tabuleiro;

public abstract class PecaXadrez extends Peca{
	
	private Cores cores;

	public PecaXadrez(Tabuleiro tabuleiro, Cores cores) {
		super(tabuleiro);
		this.cores = cores;
	}

	public Cores getCores() {
		return cores;
	}
	

}
