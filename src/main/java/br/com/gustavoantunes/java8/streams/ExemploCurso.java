package br.com.gustavoantunes.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Curso {

	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		super();
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAlunos() {
		return alunos;
	}

	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}

}

public class ExemploCurso {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
//		cursos.forEach(c -> System.out.println(c.getNome()));
		
		//Dado uma lista de cursos imprime o nome daqueles que tem 
		//quantidade de alunos maior que 100
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.forEach(c ->System.out.println(c.getNome()));
		
		//Dado uma lista de cursos imprime a quantidade de alunos dos cursos,
		//que tem quantidade maior que 100
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.map(Curso::getAlunos)
			.forEach(System.out::println);
		
		//map vs mapToInt : O map é um array de streams generico,
		//enquanto o mapToInt é especifico e contém métodos específicos para int
		int soma = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.sum();
		
		System.out.println(soma);
		
		//Como transformar o nosso Stream<Curso> em um
		//Stream<String> contendo apenas os nomes dos cursos?
		Stream<String> nomes =  cursos.stream().map(Curso::getNome);
	}
}
