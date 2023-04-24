import classes.AgenciaBancaria;
import classes.CentralAgencias;
import classes.ContaCorrente;
import classes.ContaPoupanca;
import classesabstratas.Conta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AgenciaBancaria> agencias = new ArrayList<>();

        AgenciaBancaria testeAgenciaBancaria = new AgenciaBancaria(1001);
        agencias.add(testeAgenciaBancaria);
        System.out.println(CentralAgencias.encontrarAgencia(agencias, 1001).toString());
        testeAgenciaBancaria.adicionarCliente("João", "12345678901", "joao@gmail.com", LocalDate.of(2000, 12, 24));
        testeAgenciaBancaria.abrirContaPoupanca(500, testeAgenciaBancaria.encontrarClientePorIndex(1),100d);
        System.out.println(testeAgenciaBancaria.getTodasContas().get(0));

        ContaPoupanca contaTeste = (ContaPoupanca) testeAgenciaBancaria.encontrarContaPorIndex(1);

        contaTeste.renderMensal();
        System.out.println(contaTeste.getSaldo());
        System.out.println(contaTeste.getValorGeradoJuros());
    }
}