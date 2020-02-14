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

