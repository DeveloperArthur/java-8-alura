package br.com.java8.stream_and_optional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamsCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JS", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("c", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
        cursos.forEach(c -> System.out.println(c.getNome()));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .forEach(c -> System.out.println(c.getNome()));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        int soma = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println(soma);

        cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .filter(c -> c.getNome().contains("J"))
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));

        OptionalDouble media = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .average();
        System.out.println(media.getAsDouble());

        List<Curso> cursosDeJava8 = cursos.stream()
                .filter(c -> c.getNome().equals("Java 8"))
                .collect(Collectors.toList());

        cursosDeJava8.forEach(c -> System.out.println(c.getNome()));

        cursos.stream()
                .collect(Collectors.toMap(Curso::getNome, Curso::getAlunos))
                .forEach((nome, valor) -> System.out.println(nome + " tem " + valor + " alunos "));

        cursos.stream().filter(c -> c.getAlunos() > 50).findFirst().ifPresent(c -> System.out.println(c.getNome()));

        OptionalDouble mediaDeTodos = cursos.stream().mapToInt(Curso::getAlunos).average();
        System.out.println(mediaDeTodos.getAsDouble());

        cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList()).forEach(c -> System.out.println(c.getNome()));


    }
}
