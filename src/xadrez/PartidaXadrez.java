package xadrez;

import bordajogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;

	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciarPartida();
	}

	public PecaXadrez[][] getPecas() {
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);

			}
		}
		return mat;
	}
	
	private void novoLugarPecas(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void iniciarPartida() {
		novoLugarPecas('b', 6, new Torre(tabuleiro, Cores.BRANCO));
		novoLugarPecas('e', 8 ,new Rei(tabuleiro, Cores.PRETO));
		novoLugarPecas('e', 1, new Rei(tabuleiro, Cores.BRANCO));
	}
}
