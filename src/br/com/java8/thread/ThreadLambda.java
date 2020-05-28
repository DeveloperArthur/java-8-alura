package br.com.java8.thread;

public class ThreadLambda {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executando um Runnable");
            }
        }).start();

        //run nao recebe nenhum argumento entao é ()
        new Thread(() -> System.out.println("meu lambda deu certo")).start();
    }

}
