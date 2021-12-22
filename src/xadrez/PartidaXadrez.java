package xadrez;

import bordajogo.Peca;
import bordajogo.Posicao;
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

	public PecaXadrez movimentoXadrez(PosicaoXadrez origemPosicao, PosicaoXadrez  destinoPosicao) {
		Posicao origem = origemPosicao.toPosicao();
		Posicao destino = destinoPosicao.toPosicao();
		origemPosicaoValida(origem);
		Peca pecaCapturada = movimentoFeito(origem, destino);
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca  movimentoFeito(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca pecaCapturada = tabuleiro.removerPeca(destino);
		tabuleiro.lugarPeca(p, destino);
		return pecaCapturada;
	}
	
	private void origemPosicaoValida(Posicao posica) {
		if (!tabuleiro.haUmaPeca(posica)) {
			throw new ExcecaoXadrez("Não ha uma peca nessa posicao ");
		}
		if (!tabuleiro.peca(posica).haMovimentoPossivel()) {
			throw new ExcecaoXadrez("Não ha movimento possiveis essa peça. ");
		}
	}
	
	private void novoLugarPecas(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}

	private void iniciarPartida() {
		novoLugarPecas('c', 1, new Torre(tabuleiro, Cores.BRANCO));
		novoLugarPecas('c', 2, new Rei(tabuleiro, Cores.BRANCO));
		novoLugarPecas('d', 2, new Rei(tabuleiro, Cores.BRANCO));
		novoLugarPecas('e', 2, new Torre(tabuleiro, Cores.BRANCO));
		novoLugarPecas('e', 1, new Torre(tabuleiro, Cores.BRANCO));
		novoLugarPecas('d', 1, new Torre(tabuleiro, Cores.BRANCO));

		novoLugarPecas('c', 7, new Torre(tabuleiro, Cores.PRETO));
		novoLugarPecas('c', 8, new Torre(tabuleiro, Cores.PRETO));
		novoLugarPecas('d', 7, new Rei(tabuleiro, Cores.PRETO));

		novoLugarPecas('e', 7, new Torre(tabuleiro, Cores.PRETO));
		novoLugarPecas('e', 8, new Torre(tabuleiro, Cores.PRETO));
		novoLugarPecas('d', 8, new Torre(tabuleiro, Cores.PRETO));
	}
}
