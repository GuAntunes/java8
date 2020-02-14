package br.com.gustavoantunes.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class OrdenaStringReferenceMethod {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		palavras.sort(Comparator.comparing(String::length));
		//Equivalente
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		//Equivalente
		palavras.sort(Comparator.comparing(s -> s.length()));
		//Equivalente
		Comparator<String> comparador  = Comparator.comparing(s -> s.length());
		palavras.sort(comparador);
		//Equivalente
		Function<String, Integer> funcao = s -> s.length(); 
		Comparator<String> comparador2  = Comparator.comparing(funcao);
		palavras.sort(comparador2);
		//Equivalente
		Function<String, Integer> funcao2 = new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		Comparator<String> comparador3 = Comparator.comparing(funcao2);
		palavras.sort(comparador3);
				
		palavras.forEach(s -> System.out.println(s));
		//Equivalente
		palavras.forEach(System.out::println);
		
		
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length()); 
		});
		
	}

}
