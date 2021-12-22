package bordajogo;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new ExcecaoBorda(
					"Erro ao criar o tabuleiro: É necessário que aja pelo menos 1 linha e 1 uma coluna.");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Peca peca(int linha, int coluna) {
		if (!posicaoExistentes(linha, coluna)) {
			throw new ExcecaoBorda("Posição fora do tabuleiro. ");
		}
		return pecas[linha][coluna];
	}

	public Peca peca(Posicao posicao) {
		if (!posicaoExistentes(posicao)) {
			throw new ExcecaoBorda("Posição fora do tabuleiro. ");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void lugarPeca(Peca peca, Posicao posicao) {
		if (haUmaPeca(posicao)) {
			throw new ExcecaoBorda("Há uma peça nessa posição  " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removerPeca(Posicao posicao) {
		if (!posicaoExistentes(posicao)) {
			throw new ExcecaoBorda("Posição fora do tabuleiro. ");
		}
		if (peca(posicao)==null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}

	private boolean posicaoExistentes(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}

	public boolean posicaoExistentes(Posicao posicao) {
		return posicaoExistentes(posicao.getLinha(), posicao.getColuna());
	}

	public boolean haUmaPeca(Posicao posicao) {
		if (!posicaoExistentes(posicao)) {
			throw new ExcecaoBorda("Posição fora do tabuleiro. ");
		}
		return peca(posicao) != null;
	}
}
