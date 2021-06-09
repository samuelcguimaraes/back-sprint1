package br.com.rchlo.domain;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
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
		                                                                "codigo=" +
		                                                                produto.getCodigo() +
		                                                                ", nome='" +
		                                                                produto.getNome() +
		                                                                '\'' +
		                                                                ", preco=" +
		                                                                produto.getPreco() +
		                                                                ", precoDesconto=" +
		                                                                produto.getPrecoDesconto() +
		                                                                ", preco efetivo=" +
		                                                                produto.getPrecoEfetivo() +
		                                                                '}'));
		
		System.out.println();
		System.out.println("Lista Ordenada por Nome: ");
		Collections.sort(lista, ComparatorUtil.porNome());
		lista.forEach(produto -> System.out.println("Produto{" +
		                                            "codigo=" + produto.getCodigo() +
		                                            ", nome='" + produto.getNome() + '\'' +
		                                            '}'));
		
		System.out.println();
		System.out.println("Lista Ordenada por Peso: ");
		Collections.sort(lista, ComparatorUtil.porPeso());
		lista.forEach(produto -> System.out.println("Produto{" +
		                                            "codigo=" + produto.getCodigo() +
		                                            ", nome='" + produto.getNome() + '\'' +
		                                            ", pesoEmGramas=" + produto.getPesoEmGramas() +
		                                            '}'));
		
		System.out.println();
		System.out.println("Lista Ordenada por Preço Menor (Efetivo): ");
		Collections.sort(lista, ComparatorUtil.porPrecoMenor());
		lista.forEach(produto -> System.out.println("Produto{" +
		                                            "codigo=" + produto.getCodigo() +
		                                            ", nome='" + produto.getNome() + '\'' +
		                                            ", preco=" + produto.getPreco() +
		                                            ", precoDesconto=" + produto.getPrecoDesconto() +
		                                            ", preco efetivo=" + produto.getPrecoEfetivo() +
		                                            '}'));
		
		System.out.println();
		System.out.println("Lista Ordenada por Preço Maior (Efetivo): ");
		Collections.sort(lista, ComparatorUtil.porPrecoMaior());
		lista.forEach(produto -> System.out.println("Produto{" +
		                                            "codigo=" + produto.getCodigo() +
		                                            ", nome='" + produto.getNome() + '\'' +
		                                            ", preco=" + produto.getPreco() +
		                                            ", precoDesconto=" + produto.getPrecoDesconto() +
		                                            ", preco efetivo=" + produto.getPrecoEfetivo() +
		                                            '}'));
		
		System.out.println();
		System.out.println("Lista Ordenada por Desconto Maior: ");
		Collections.sort(lista, ComparatorUtil.porDescontoMaior());
		lista.forEach(produto -> System.out.println("Produto{" +
		                                            "codigo=" + produto.getCodigo() +
		                                            ", nome='" + produto.getNome() + '\'' +
		                                            ", preco=" + produto.getPreco() +
		                                            ", precoDesconto=" + produto.getPrecoDesconto() +
		                                            ", preco efetivo=" + produto.getPrecoEfetivo() +
		                                            '}'));
		
		//Informar aqui a cor que será buscada
		final Produto produtoProcurado2 = new Produto(Cor.AZUL);
		
		System.out.println();
		System.out.println("Busca Binária por Cor: (Usando comparator default dos Enums)");
		System.out.println("Procurando um Produto de Cor = " + produtoProcurado2.getCor());
		Collections.sort(lista, ComparatorUtil.porCor());
		int indiceDaBusca2 = Collections.binarySearch(lista, produtoProcurado2,
		                                              ComparatorUtil.porCor());
		System.out.println(indiceDaBusca2 >= 0 ? "O primeiro produto encontrado está na posição: " + indiceDaBusca2
		                                       : "O produto não foi encontrado na lista");
		lista.forEach(produto -> System.out.println("Produto{" +
		                                            "codigo=" + produto.getCodigo() +
		                                            ", nome='" + produto.getNome() + '\'' +
		                                            ", cor=" + produto.getCor() +
		                                            '}'));
		
		//Múltiplos filtros
		Produto produtoBuscado = new Produto(
				null, //código
				null, //nome
				null, //descrição
				null, //slug
				null, //marca
				null, //preco
				null, //preco desconto
				null, //cor
				null, //tamanhos disponíveis
				null, //peso em gramas
				null //url imagem
		);
		
		System.out.println();
		System.out.println("Lista de produtos com múltiplos filtros: ");
		
		final Cor corFiltro = Cor.BRANCA;
		final Tamanho tamanhoFiltro = Tamanho.MEDIO;
		final String nomeFiltro = "Camiseta";
		final Boolean temDescontoFiltro = Boolean.TRUE;
		
		System.out.println("-Filtros aplicados:");
		System.out.println("--Cor           : " + (Objects.isNull(corFiltro) ? null : corFiltro.name()));
		System.out.println("--Tamanho       : " + (Objects.isNull(tamanhoFiltro) ? null : tamanhoFiltro.name()));
		System.out.println("--Nome (contém) : " + nomeFiltro);
		System.out.println("--Tem desconto? : " + temDescontoFiltro);
		System.out.println("-Resultados:");
		List<Produto> produtosComFiltrosMultiplos = aplicaMultiplosFiltros(ListaDeProdutos.todos(),
		                                                                   corFiltro,
		                                                                   tamanhoFiltro,
		                                                                   nomeFiltro,
		                                                                   temDescontoFiltro);
		produtosComFiltrosMultiplos.forEach(System.out::println);
		
		System.out.println();
		System.out.println("Lista de produtos com filtro por faixa de preços: ");
		
		final BigDecimal precoDe = new BigDecimal(30);
		final BigDecimal precoAte = new BigDecimal(100);
		System.out.println("-Faixa de preços: de " +
		                   NumberFormat.getCurrencyInstance().format(precoDe) +
		                   " à " +
		                   NumberFormat.getCurrencyInstance().format(precoAte));
		
		List<Produto> produtosFaixaPreco = aplicaFiltroFaixaDePrecos(ListaDeProdutos.todos(), precoDe, precoAte);
		produtosFaixaPreco.sort(ComparatorUtil.porPrecoMenor());
		produtosFaixaPreco.forEach(produto -> System.out.println("Produto{" +
		                                                         "codigo=" + produto.getCodigo() +
		                                                         ", nome='" + produto.getNome() + '\'' +
		                                                         ", preco=" + produto.getPreco() +
		                                                         ", precoDesconto=" + produto.getPrecoDesconto() +
		                                                         ", preco efetivo=" + produto.getPrecoEfetivo() +
		                                                         '}'));
		
		System.out.println();
		System.out.println("Lista de produtos com filtro por faixa de peso: ");
		
		final Integer pesoDe = 110;
		final Integer pesoAte = 150;
		System.out.println("-Faixa de pesos: de " +
		                   pesoDe +
		                   " à " +
		                   pesoAte + " gramas");
		
		List<Produto> produtosFaixaPeso = aplicaFiltroFaixaDePesos(ListaDeProdutos.todos(), pesoDe, pesoAte);
		produtosFaixaPeso.sort(ComparatorUtil.porPeso());
		produtosFaixaPeso.forEach(produto -> System.out.println("Produto{" +
		                                                        "codigo=" + produto.getCodigo() +
		                                                        ", nome='" + produto.getNome() + '\'' +
		                                                        ", pesoEmGramas=" + produto.getPesoEmGramas() +
		                                                        '}'));
		
		System.out.println();
		System.out.println("-----RELATÓRIOS-----");
		System.out.println();
		System.out.println("Quantidade de Produtos de Cada COR");
		
		Arrays.stream(Cor.values()).forEach(
				c -> System.out.println(c.name() + ": " + lista.stream().filter(p -> p.getCor().equals(c)).count()));
		
		System.out.println();
		System.out.println("Lista de Códigos dos Produtos por TAMANHO");
		
		Arrays.stream(Tamanho.values()).forEach(t -> System.out.println(t.name() +
		                                                                ": " +
		                                                                lista.stream()
		                                                                     .filter(p -> p.getTamanhosDisponiveis()
		                                                                                   .contains(t))
		                                                                     .mapToLong(Produto::getCodigo)
		                                                                     .boxed()
		                                                                     .collect(Collectors.toList())
		));
	}
	
	private static List<Produto> aplicaFiltroFaixaDePesos(final Produto[] todos,
	                                                      final Integer pesoDe,
	                                                      final Integer pesoAte) {
		return Arrays.stream(todos)
		             .filter(p -> {
			
			             if (Objects.isNull(pesoDe) && Objects.isNull(pesoAte)) {
				             return true;
			             }
			
			             return ((Objects.isNull(pesoDe) || p.getPesoEmGramas() >= pesoDe) &&
			                     (Objects.isNull(pesoAte) || p.getPesoEmGramas() <= pesoAte));
		             })
		             .collect(Collectors.toList());
	}
	
	private static List<Produto> aplicaFiltroFaixaDePrecos(final Produto[] todos,
	                                                       final BigDecimal precoDe,
	                                                       final BigDecimal precoAte) {
		return Arrays.stream(todos)
		             .filter(p -> {
			
			             if (Objects.isNull(precoDe) && Objects.isNull(precoAte)) {
				             return true;
			             }
			
			             return ((Objects.isNull(precoDe) || p.getPrecoEfetivo().compareTo(precoDe) >= 0) &&
			                     (Objects.isNull(precoAte) || p.getPrecoEfetivo().compareTo(precoAte) <= 0));
		             })
		             .collect(Collectors.toList());
		
	}
	
	private static List<Produto> aplicaMultiplosFiltros(final Produto[] todos,
	                                                    final Cor cor,
	                                                    final Tamanho tamanho,
	                                                    final String nome,
	                                                    final Boolean possuiDesconto) {
		
		return Arrays.stream(todos)
		             .filter(p -> Objects.isNull(cor) || cor.equals(p.getCor()))
		             .filter(p -> Objects.isNull(tamanho) ||
		                          (!p.getTamanhosDisponiveis().isEmpty() && p.getTamanhosDisponiveis().contains(
				                          tamanho)))
		             .filter(p -> Objects.isNull(nome) ||
		                          nome.isBlank() ||
		                          (Objects.nonNull(p.getNome()) &&
		                           p.getNome().toLowerCase().contains(nome.toLowerCase())))
		             .filter(p -> Objects.isNull(possuiDesconto) || p.temDesconto() == possuiDesconto)
		             .collect(Collectors.toList());
	}
}
