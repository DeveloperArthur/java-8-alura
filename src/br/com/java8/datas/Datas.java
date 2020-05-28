package br.com.java8.datas;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadas = LocalDate.of(2022, Month.JUNE, 5);

        int anos = olimpiadas.getYear() - hoje.getYear();
        System.out.println("faltam " + anos + " anos para as olimpiadas");

        Period periodo = Period.between(hoje, olimpiadas);
        System.out.println("faltam " + periodo.getDays() + " dias, " + periodo.getMonths() + " meses e " + periodo.getYears() + " anos");

        LocalDate proximasOlimpiadas = olimpiadas.plusYears(4);
        System.out.println(proximasOlimpiadas);

        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = proximasOlimpiadas.format(formatadorData);
        System.out.println(dataFormatada);

        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorHora));

        LocalDate dataDeAgora = agora.toLocalDate();
        System.out.println(dataDeAgora);

        System.out.println(dataDeAgora.equals(hoje));

        YearMonth mes = YearMonth.now();
        System.out.println(mes);

        LocalTime intervalo = LocalTime.of(18, 15);
        System.out.println(intervalo);
    }
}
