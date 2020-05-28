package br.com.java8.sort_and_foreach;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<String>();
        palavras.add("alura online");
        palavras.add("java 8");
        palavras.add("estudando");

        Comparator comparator = new ComparaPorTamanho();
        palavras.sort(comparator);
        System.out.println(palavras);

        palavras.sort((o1, o2) -> {
            if (o1.length() < o2.length())
                return -1;
            if (o1.length() > o2.length())
                return 1;
            return 0;
        });

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        palavras.sort(Comparator.comparing(s -> s.length()));
        palavras.sort(Comparator.comparing(String::length));

        Function<String, Integer> funcao = s -> s.length();
        Comparator<String> comparator2 = Comparator.comparing(funcao);
        palavras.sort(comparator2);

        System.out.println(palavras);

        for (String p : palavras){
            System.out.println(p);
        }

        Consumer<String> consumer = new ImprimeNaLinha();
        palavras.forEach(consumer);

        Consumer<String> impressor = System.out::println;
        palavras.forEach(impressor);

        palavras.forEach(System.out::println);
    }
}
