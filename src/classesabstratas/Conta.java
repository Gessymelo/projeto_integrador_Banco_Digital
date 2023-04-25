package classesabstratas;

import classes.AgenciaBancaria;
import classes.CentralAgencias;
import classes.Cliente;
import classes.Registro;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    private int id;
    private Boolean ativo;
    private int numAgenciaBancaria;
    private int numConta;
    private Cliente cliente;
    private Double saldo;

    private List<Registro> extrato;

    public Conta(int id, int numAgenciaBancaria, int numConta, Cliente cliente) {
        this.setId(id);
        this.setAtivo(true);
        this.setNumAgenciaBancaria(numAgenciaBancaria);
        this.setNumConta(numConta);
        this.setCliente(cliente);
        this.setSaldo(0d);
        this.setExtrato(new ArrayList<>());
    }

    public Conta(int id, int numAgenciaBancaria, int numConta, Cliente cliente, Double saldo) {
        this.setId(id);
        this.setAtivo(true);
        this.setNumAgenciaBancaria(numAgenciaBancaria);
        this.setNumConta(numConta);
        this.setCliente(cliente);
        if(saldo > 0){
            this.setSaldo(saldo);
        }
        this.setExtrato(new ArrayList<>());
    }

    public void depositar(double valor){
        if(valor > 0){
            this.setSaldo(this.getSaldo() + valor);
            Registro novo = new Registro(valor, LocalDateTime.now(), "Depósito");
            this.getExtrato().add(novo);
        }else{
            System.out.println("Por favor, digite um valor positivo para depositar.");
        }
    }

    public void sacar(double valor) {
    }

    private void receberTransferencia(double valor){
        if(valor > 0){
            this.setSaldo(this.getSaldo() + valor);
        }else{
            System.out.println("Por favor, digite um valor positivo para depositar.");
        }
    }

    protected void retirarTransferencia(double valor){

    }


    public void transferir(double valor, int numAgenciaBancariaDestino, int numContaDestino){
        AgenciaBancaria agenciaBancariaDestino = CentralAgencias.encontrarAgencia(numAgenciaBancariaDestino);
        Conta contaDestino = agenciaBancariaDestino.encontrarContaPorNumConta(numContaDestino);

        this.retirarTransferencia(valor);

        Registro novoOrigem = new Registro(valor, LocalDateTime.now(), "Transferência enviada");
        this.getExtrato().add(novoOrigem);

        contaDestino.receberTransferencia(valor);

        Registro novoDestino = new Registro(valor, LocalDateTime.now(), "Transferência recebida");
        this.getExtrato().add(novoDestino);

    }

    public void consultarExtrato(){
        for(Registro registro : extrato){
            System.out.printf("Valor: R$%.2f ", registro.getValor());
            System.out.println(" | Data e hora: " + registro.getData() + "| Tipo de transação: " + registro.getTipoTransacao());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public int getNumConta() {
        return numConta;
    }

    public int getNumAgenciaBancaria() {
        return numAgenciaBancaria;
    }

    public void setNumAgenciaBancaria(int numAgenciaBancaria) {
        this.numAgenciaBancaria = numAgenciaBancaria;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Registro> getExtrato() {
        return extrato;
    }

    public void setExtrato(List<Registro> extrato) {
        this.extrato = extrato;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", ativo=" + ativo +
                ", numAgenciaBancaria=" + numAgenciaBancaria +
                ", numConta=" + numConta +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                ", extrato=" + extrato +
                '}';
    }
}
