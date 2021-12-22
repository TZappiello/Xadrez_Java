package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import bordajogo.ExcecaoBorda;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaXadrez partxa = new PartidaXadrez();
		//UI.printTabuleiro(partxa.getPecas());

		while (true) {

			try {
				UI.printTabuleiro(partxa.getPecas());
				System.out.println();
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

				System.out.println();
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

				PecaXadrez pecaCapturada = partxa.movimentoXadrez(origem, destino);

			} catch (ExcecaoBorda e) {
				System.out.println(e.getMessage());
				sc.nextLine();

			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
