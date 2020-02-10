package br.com.gustavoantunes.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsComLambda {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		// Instancia o comparator criado
		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		// Utilizando um novo metodo sort da api de java8
		// para poder realizar a ordenação
		palavras.sort(comparador);
		Collections.sort(palavras, comparador);

		// Realiza a impressão do array através do metodo forEach
		Consumer<String> consumidor = new ConsumidorDeString();
		palavras.forEach(consumidor);

//		palavras.forEach(s -> System.out.println(s));
	}
}

/**
 * 
 * @author gustavo Criação de comparator por tamanho da String
 */
class ComparadorDeStringPorTamanho implements Comparator<String> {

	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}

class ConsumidorDeString implements Consumer<String> {
	public void accept(String s) {
		System.out.println(s);
	}
}
