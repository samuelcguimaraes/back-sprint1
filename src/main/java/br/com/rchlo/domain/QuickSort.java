package br.com.rchlo.domain;

public class QuickSort {
	
	public static void ordena(final Produto[] produtos, final int de, final int ate) {
		int elementos = ate - de;
		if (elementos > 1) {
			int posicaoDoPivo = particiona(produtos, de, ate);
			
			ordena(produtos, de, posicaoDoPivo);
			ordena(produtos, posicaoDoPivo + 1, ate);
		}
	}
	
	private static int particiona(final Produto[] produtos, int inicial, int termino) {
		
		int menoresEncontrados = 0;
		
		Produto pivo = produtos[termino - 1];
		
		for (int analisando = 0; analisando < termino - 1; analisando++) {
			Produto atual = produtos[analisando];
			
			if (pivo.getPrecoEfetivo().compareTo(atual.getPrecoEfetivo()) > 0) {
				troca(produtos, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}
		troca(produtos, termino - 1, menoresEncontrados);
		
		return menoresEncontrados;
	}
	
	private static void troca(final Produto[] produtos, final int de, final int para) {
		
		Produto nota1 = produtos[de];
		Produto nota2 = produtos[para];
		produtos[para] = nota1;
		produtos[de] = nota2;
		
	}
	
}