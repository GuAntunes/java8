package br.com.gustavoantunes.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExemploCurso {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.findAny()
			.ifPresent(c -> System.out.println(c.getNome()));
		
		//Este metodo não altera a collection original
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100);

		//Através do collect e Collectors é possível retornar a lista alterada
		cursos = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toList());
		

		//Através do collect e Collectors é possível retornar a lista alterada
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
		.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
		cursos.parallelStream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
		.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
	}
}
