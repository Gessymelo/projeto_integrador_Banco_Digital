package classes;

import classesabstratas.Conta;

import java.time.LocalDate;

public class ContaPoupanca extends Conta {

    private double valorGeradoJuros;
    public ContaPoupanca(int id, int numAgenciaBancaria, int numConta, Cliente cliente){
        super(id, numAgenciaBancaria, numConta, cliente);
    }

    public ContaPoupanca(int id, int numAgenciaBancaria, int numConta, Cliente cliente, Double saldo) {
        super(id, numAgenciaBancaria, numConta, cliente, saldo);
    }

    public void renderMensal(){
        int diaDoMesAniversario = this.getCliente().getDataNascimento().getDayOfMonth();
        int diaDeHoje = LocalDate.now().getDayOfMonth();
        if((diaDoMesAniversario - diaDeHoje) == 0){
            this.setValorGeradoJuros(this.getSaldo()*0.005);
            this.setSaldo(this.getSaldo()*1.005);
            System.out.printf("Dia de seu aniversário! Saldo atualizado com os juros: R$%.2f\n", this.getSaldo());
        } else{
            System.out.println("Ooops... Não é dia de seu aniversário.");
        }
    }

    public double getValorGeradoJuros() {
        return valorGeradoJuros;
    }

    public void setValorGeradoJuros(double valorGeradoJuros) {
        this.valorGeradoJuros = valorGeradoJuros;
    }
}
