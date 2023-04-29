package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatador {

    public static LocalDate stringToLocalDate(String dataNascimento){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataNascimentoFormatada = LocalDate.parse(dataNascimento, formatter);

        return dataNascimentoFormatada;
    }
}
