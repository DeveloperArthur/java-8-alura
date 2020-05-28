package br.com.java8.sort_and_foreach;

import java.util.function.Consumer;

public class ImprimeNaLinha implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
