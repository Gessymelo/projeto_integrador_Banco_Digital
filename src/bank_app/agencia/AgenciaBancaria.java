package bank_app.agencia;

import bank_app.cliente.Cliente;
import bank_app.contas.ContaCorrente;
import bank_app.contas.ContaPoupanca;
import bank_app.contas.Conta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AgenciaBancaria {
    private int numAgenciaBancaria;
    private int qtdContas;
    private int qtdClientes;
    private List<Conta> contas;
    private List<Cliente> clientes;

    public AgenciaBancaria(int numAgencia){
        this.setNumAgencia(numAgencia);
        this.setQtdContas(0);
        this.setQtdClientes(0);
        contas = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void abrirContaPoupanca(int numConta, Cliente novoCliente, double saldo){
        this.setQtdContas(this.getQtdContas() + 1);
        int idNovaConta = this.getQtdContas();
        int numAgenciaBancaria = this.getNumAgencia();

        ContaPoupanca nova;

        if(saldo > 0){
            nova = new ContaPoupanca(idNovaConta, numAgenciaBancaria, numConta, novoCliente, saldo);
        } else{
            nova = new ContaPoupanca(idNovaConta, numAgenciaBancaria, numConta, novoCliente);
        }

        if(nova != null) {
            contas.add(nova);
        }
    }

    public void abrirContaCorrente(int numConta, Cliente novoCliente, double saldo, double limiteChequeEspecial){
        this.setQtdContas(this.getQtdContas() + 1);
        int idNovaConta = this.getQtdContas();
        int numAgenciaBancaria = this.getNumAgencia();

        ContaCorrente nova;

        if(saldo > 0){
            nova = new ContaCorrente(idNovaConta, numAgenciaBancaria, numConta, novoCliente, saldo, limiteChequeEspecial);
        } else{
            nova = new ContaCorrente(idNovaConta, numAgenciaBancaria, numConta, novoCliente);
        }

        if(nova != null) {
            contas.add(nova);
        }
    }

    public void adicionarCliente(String nome, String cpf, String email, LocalDate dataNascimento){
        this.setQtdClientes(this.getQtdClientes()+1);
        int idNovoCliente = this.getQtdClientes();
        Cliente novo = new Cliente (idNovoCliente, nome, cpf, email, dataNascimento);
        clientes.add(novo);
    }

    public Cliente encontrarClientePorCpf(String cpf){
        Iterator<Cliente> iterator = clientes.iterator();
        while(iterator.hasNext()){
            Cliente next = iterator.next();
            if((next.getCpf().equals(cpf))){
                return next;
            }
        }
        return null;
    }

    public Cliente encontrarClientePorIndex(int id){
        Iterator<Cliente> iterator = clientes.iterator();
        while(iterator.hasNext()){
            Cliente next = iterator.next();
            if((next.getId() - id) == 0){
                return next;
            }
        }
        return null;
    }

    public void removerClientePorIndex(int id){
//        Iterator<Cliente> iterator = clientes.iterator();
//        while(iterator.hasNext()){
//            Cliente next = iterator.next();
//            if((next.getId() - id) == 0){
//                iterator.remove();
//            }
//        }
    }

    public Conta encontrarContaPorNumConta(int numConta){
        Iterator<Conta> iterator = contas.iterator();
        while(iterator.hasNext()){
            Conta next = iterator.next();
            if((next.getNumConta() - numConta) == 0){
                return next;
            }
        }
        return null;
    }

    public Conta encontrarContaPorIndex(int id){
        Iterator<Conta> iterator = contas.iterator();
        while(iterator.hasNext()){
            Conta next = iterator.next();
            if((next.getId() - id) == 0){
                return next;
            }
        }
        return null;
    }

    public void removerContaPorIndex(int id){
        Iterator<Conta> iterator = contas.iterator();
        while(iterator.hasNext()){
            Conta next = iterator.next();
            if((next.getId() - id) == 0){
                iterator.remove();
            }
        }
    }

    public int getNumAgencia() {
        return numAgenciaBancaria;
    }

    public void setNumAgencia(int numAgencia) {
        this.numAgenciaBancaria = numAgencia;
    }

    public int getQtdContas() {
        return qtdContas;
    }

    public void setQtdContas(int qtdContas) {
        this.qtdContas = qtdContas;
    }

    public int getQtdClientes() {
        return qtdClientes;
    }

    public void setQtdClientes(int qtdClientes) {
        this.qtdClientes = qtdClientes;
    }

    public List<Conta> getTodasContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Cliente> getTodosClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "AgenciaBancaria{" +
                "numAgenciaBancaria=" + numAgenciaBancaria +
                ", qtdContas=" + qtdContas +
                ", qtdClientes=" + qtdClientes +
                ", contas=" + contas +
                ", clientes=" + clientes +
                '}';
    }
}
