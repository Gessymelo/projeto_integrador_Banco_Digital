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

        CentralAgencias centralAgencias = new CentralAgencias();

        AgenciaBancaria agenciaBancaria1 = new AgenciaBancaria(1001);
        AgenciaBancaria agenciaBancaria2 = new AgenciaBancaria(2001);

        centralAgencias.adicionarAgenciaBancaria(agenciaBancaria1);
        centralAgencias.adicionarAgenciaBancaria(agenciaBancaria2);

        agenciaBancaria1.adicionarCliente("João Pessoa", "12345678901", "jp@gmail.com", LocalDate.of(2001, 5, 02));
        agenciaBancaria1.adicionarCliente("Tiradentes", "12345678902", "tira_dentes@gmail.com", LocalDate.of(1995, 6, 3));
        agenciaBancaria2.adicionarCliente("Getúlio Vargas", "12345678903", "gegegas@gmail.com", LocalDate.of(1998, 8, 17));
        agenciaBancaria2.adicionarCliente("Maria Antonieta", "12345678904", "toniamaria@gmail.com", LocalDate.of(1974, 10, 31));

        agenciaBancaria1.abrirContaPoupanca(1101,agenciaBancaria1.encontrarClientePorIndex(1),2000);
        agenciaBancaria1.abrirContaCorrente(1102,agenciaBancaria1.encontrarClientePorIndex(2),3000, 1000);
        agenciaBancaria2.abrirContaPoupanca(2101,agenciaBancaria2.encontrarClientePorIndex(1),2000);
        agenciaBancaria2.abrirContaCorrente(2102,agenciaBancaria2.encontrarClientePorIndex(2),3000, 1000);

//        CÓDIGO PARA TESTAR SAQUE E DEPOSITO EM UM CONTA (PODEM FICAR À VONTADE PRA EXPLORAR)
//
//        System.out.println(agenciaBancaria1.encontrarContaPorNumConta(1101).getSaldo());
//
//        agenciaBancaria1.encontrarContaPorNumConta(1101).sacar(100);
//        agenciaBancaria1.encontrarContaPorNumConta(1101).consultarExtrato();
//
//        agenciaBancaria1.encontrarContaPorNumConta(1101).depositar(200d);
//        agenciaBancaria1.encontrarContaPorNumConta(1101).consultarExtrato();
//
//        System.out.println(agenciaBancaria1.encontrarContaPorNumConta(1101).getSaldo());

//        CÓDIGO PARA TESTAR TRANSFERENCIA ENTRE CONTAS DE UMA MESMA AGENCIA BANCARA
//
//        agenciaBancaria1.encontrarContaPorNumConta(1101).transferir(100, 1001, 1102);
//        agenciaBancaria1.encontrarContaPorNumConta(1101).consultarExtrato();
//        System.out.println(agenciaBancaria1.encontrarContaPorNumConta(1101).getSaldo());
//        agenciaBancaria1.encontrarContaPorNumConta(1102).consultarExtrato();
//        System.out.println(agenciaBancaria1.encontrarContaPorNumConta(1102).getSaldo());


//        CÓDIGO PARA TESTAR TRANSFERENCIA ENTRE CONTAS DE DIFERENTES AGENCIAS
//
//        agenciaBancaria1.encontrarContaPorNumConta(1101).transferir(100, 2001, 2102);
//        agenciaBancaria1.encontrarContaPorNumConta(1101).consultarExtrato();
//        System.out.println(agenciaBancaria1.encontrarContaPorNumConta(1101).getSaldo());
//        agenciaBancaria2.encontrarContaPorNumConta(2102).consultarExtrato();
//        System.out.println(agenciaBancaria2.encontrarContaPorNumConta(2102).getSaldo());
    }
}