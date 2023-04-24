package classesabstratas;

import classes.Cliente;

public abstract class Conta {

    private int id;
    private Boolean ativo;
    private int numAgenciaBancaria;
    private int numConta;
    private Cliente cliente;
    private Double saldo;

    public Conta(int id, int numAgenciaBancaria, int numConta, Cliente cliente) {
        this.setId(id);
        this.setAtivo(true);
        this.setNumAgenciaBancaria(numAgenciaBancaria);
        this.setNumConta(numConta);
        this.setCliente(cliente);
        this.setSaldo(0d);
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
    }

    public void depositar(double valor){
        if(valor > 0){
            this.setSaldo(this.getSaldo() + valor);
        }else{
            System.out.println("Por favor, digite um valor positivo para depositar.");
        }
    }

    public void sacar(double valor){
        if(valor > 0 && valor <= this.getSaldo()){
            this.setSaldo(this.getSaldo() - valor);
        }else{
            System.out.println("Por favor, digite um valor positivo e/ou menor ou igual ao saldo para sacar.");
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

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", ativo=" + ativo +
                ", numAgenciaBancaria=" + numAgenciaBancaria +
                ", numConta=" + numConta +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                '}';
    }
}
