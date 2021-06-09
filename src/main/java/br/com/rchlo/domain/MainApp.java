package br.com.rchlo.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp {
	
	public static void main(String[] args) {
		
		final List<Produto> lista = ListaDeProdutos.lista();
		
		System.out.println("Lista Original: ");
		lista.forEach(System.out::println);
		
		System.out.println();
		System.out.println("Lista Ordenada por Código: (Ordenação Natural)");
		Collections.sort(lista);
		lista.forEach(System.out::println);
		
		//Informar aqui o código que será buscado
		final Produto produtoProcurado = new Produto(11L);
		
		System.out.println();
		System.out.println("Busca Binária por Código: (Na lista ordenada)");
		System.out.println("Procurando o Produto de Código = " + produtoProcurado.getCodigo());
		int indiceDaBusca = Collections.binarySearch(lista, produtoProcurado);
		System.out.println(indiceDaBusca >= 0 ? "O produto foi encontrado na posição: " + indiceDaBusca
		                                      : "O produto não foi encontrado na lista");
		
		final List<Produto> listaDesordenada = ListaDeProdutos.lista();
		System.out.println();
		System.out.println("Busca Binária por Código: (Na lista desordenada)");
		System.out.println("Procurando o Produto de Código = " + produtoProcurado.getCodigo());
		indiceDaBusca = Collections.binarySearch(listaDesordenada, produtoProcurado);
		System.out.println(indiceDaBusca >= 0 ? "O produto foi encontrado na posição: " + indiceDaBusca
		                                      : "O produto não foi encontrado na lista");
		
		//Informar aqui a cor que será filtrada
		final Produto produtoFiltrado = new Produto(Cor.VERMELHA);
		
		System.out.println();
		System.out.println("Filtra Produtos por Cor: (Usando forEach)");
		System.out.println("Filtrando o(s) Produto(s) de Cor = " + produtoFiltrado.getCor());
		final List<Produto> listaFiltrada = new ArrayList<>();
		lista.forEach(produto -> {
			if (produto.getCor().equals(produtoFiltrado.getCor())) {
				listaFiltrada.add(produto);
			}
		});
		listaFiltrada.forEach(produto -> System.out.println("Produto{" +
		                                                    "codigo=" + produto.getCodigo() +
		                                                    ", nome='" + produto.getNome() + '\'' +
		                                                    ", cor=" + produto.getCor() +
		                                                    '}'));
		
		System.out.println();
		System.out.println("Filtra Produtos por Cor: (Usando Stream)");
		System.out.println("Filtrando o(s) Produto(s) de Cor = " + produtoFiltrado.getCor());
		final List<Produto> listaFiltradaPorStream = lista.stream()
		                                                  .filter(produto -> produto.getCor()
		                                                                            .equals(produtoFiltrado.getCor()))
		                                                  .collect(Collectors.toList());
		listaFiltradaPorStream.forEach(produto -> System.out.println("Produto{" +
		                                                             "codigo=" + produto.getCodigo() +
		                                                             ", nome='" + produto.getNome() + '\'' +
		                                                             ", cor=" + produto.getCor() +
		                                                             '}'));
		
		System.out.println();
		System.out.println("Lista Ordenada por Preço Efetivo: (usando QuickSort)");
		final Produto[] todos = ListaDeProdutos.todos();
		QuickSort.ordena(todos, 0, todos.length);
		final List<Produto> produtosOrdenadosPorPreco = Arrays.asList(todos);
		produtosOrdenadosPorPreco.forEach(produto -> System.out.println("Produto{" +
		                                                                "codigo=" + produto.getCodigo() +
		                                                                ", nome='" + produto.getNome() + '\'' +
		                                                                ", preco efetivo=" + produto.getPrecoEfetivo() +
		                                                                '}'));
	}
}
