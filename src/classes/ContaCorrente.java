package classes;

import classesabstratas.Conta;

import java.time.LocalDateTime;

public class ContaCorrente extends Conta {
    private double valorCobrancaChequeEspecial;
    private double limiteChequeEspecial;

    public ContaCorrente(int id, int numAgenciaBancaria, int numConta, Cliente cliente) {
        super(id, numAgenciaBancaria, numConta, cliente);
        this.setLimiteChequeEspecial(0);
    }

    public ContaCorrente(int id, int numAgenciaBancaria, int numConta, Cliente cliente, Double saldo, double valorChequeEspecial) {
        super(id, numAgenciaBancaria, numConta, cliente, saldo);
        this.setLimiteChequeEspecial(valorChequeEspecial);
    }

    public void sacar(double valor){
        double diferencaValorChequeEspecial = this.getSaldo() - valor;
        if(valor > 0 && diferencaValorChequeEspecial >= - (this.getLimiteChequeEspecial())){
            this.setSaldo(this.getSaldo() - valor);

            Registro novo = new Registro(valor, LocalDateTime.now(), "Saque");
            this.getExtrato().add(novo);

            if(this.getSaldo() < 0) {
                this.cobrarJurosChequeEspecial();
            }
        }else{
            System.out.println("Por favor, digite um valor positivo para sacar e/ou verifique seu limite no cheque especial.");
        }
    }

    protected void retirarTransferencia(double valor){
        double diferencaValorChequeEspecial = this.getSaldo() - valor;
        if(valor > 0 && diferencaValorChequeEspecial >= - (this.getLimiteChequeEspecial())){
            this.setSaldo(this.getSaldo() - valor);

            if(this.getSaldo() < 0) {
                this.cobrarJurosChequeEspecial();
            }
        }else{
            System.out.println("Por favor, digite um valor positivo para sacar e/ou verifique seu limite no cheque especial.");
        }
    }

    public void cobrarJurosChequeEspecial(){
        if(this.getSaldo() < 0){
            this.setValorCobrancaChequeEspecial(Math.abs(this.getSaldo())*1.5);
        }
    }

    public double getValorCobrancaChequeEspecial() {
        return valorCobrancaChequeEspecial;
    }

    public void setValorCobrancaChequeEspecial(double valorChequeEspecial) {
        this.valorCobrancaChequeEspecial = valorChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
}
