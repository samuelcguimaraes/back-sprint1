package br.com.rchlo.domain;

import java.math.BigDecimal;
import java.util.Comparator;

public abstract class ComparatorUtil {
	
	public static Comparator<Produto> porNome() {
		
		return Comparator.comparing(Produto::getNome);
	}
	
	public static Comparator<Produto> porPeso() {
		
		return Comparator.comparing(Produto::getPesoEmGramas);
	}
	
	public static Comparator<Produto> porPrecoMenor() {
		
		return Comparator.comparing(Produto::getPrecoEfetivo);
	}
	
	public static Comparator<Produto> porPrecoMaior() {
		
		return (produto1, produto2) -> produto2.getPrecoEfetivo().compareTo(produto1.getPrecoEfetivo());
	}
	
	public static Comparator<Produto> porDescontoMaior() {
		
		return (produto1, produto2) -> {
			
			final BigDecimal descontoProduto1 = produto1.temDesconto() ?
			                                    produto1.getPrecoDesconto() :
			                                    BigDecimal.ZERO;
			final BigDecimal descontoProduto2 = produto2.temDesconto() ?
			                                    produto2.getPrecoDesconto() :
			                                    BigDecimal.ZERO;
			
			return descontoProduto2.compareTo(descontoProduto1);
		};
	}
	
	public static Comparator<Produto> porCor() {
		
		return Comparator.comparing(Produto::getCor);
	}
}