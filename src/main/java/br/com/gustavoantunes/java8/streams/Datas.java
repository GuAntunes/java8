package br.com.gustavoantunes.java8.streams;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	public static void main(String[] args) {

		//Imprime a data de hoje
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		//Quantos anos passaram de hoje até as olimpiadas
		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
		int anos = olimpiadasRio.getYear() - hoje.getYear();
		System.out.println(anos);

		//Realiza o calculo do periodo entre duas datas
		Period periodo = Period.between(olimpiadasRio, hoje);
		System.out.println(periodo.getYears());
		
		//Próxima olimpiada
		LocalDate promixaOlimpiada = olimpiadasRio.plusYears(4);
		System.out.println(promixaOlimpiada);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(formatador.format(olimpiadasRio));
		
		
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
		
		LocalTime intervalo = LocalTime.of(15, 30);
		System.out.println(intervalo);
		
		
	}
}
