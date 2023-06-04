package bank_app.contas;

import bank_app.cliente.Cliente;

import java.time.LocalDateTime;
import java.util.Random;

public class ContaInvestimento extends Conta{

    private double valorGeradoJuros;

    public ContaInvestimento(int id, int numAgenciaBancaria, int numConta, Cliente cliente) {
        super(id, numAgenciaBancaria, numConta, cliente);
    }

    public ContaInvestimento(int id, int numAgenciaBancaria, int numConta, Cliente cliente, Double saldo) {
        super(id, numAgenciaBancaria, numConta, cliente, saldo);
    }

    public void renderFixo(){
        this.setValorGeradoJuros(this.getSaldo()*0.10);
        this.setSaldo(this.getSaldo()*1.10);

        Registro novo = new Registro(this.getValorGeradoJuros(), LocalDateTime.now(), "Rendimento fixo");
        this.getExtrato().add(novo);

        System.out.printf("Valor de juros gerados: %.2f\n", this.getValorGeradoJuros());
        System.out.printf("Investimento rendido com sucesso! Saldo atualizado com os juros: R$%.2f\n", this.getSaldo());
    }

    public void renderVariavel(){
        Random rand = new Random();
        double taxaJuros = rand.nextDouble(10,26);

        this.setValorGeradoJuros(this.getSaldo()*(taxaJuros/100));
        this.setSaldo(this.getSaldo()*(1 + (taxaJuros/100)));

        Registro novo = new Registro(this.getValorGeradoJuros(), LocalDateTime.now(), "Rendimento variável");
        this.getExtrato().add(novo);

        System.out.printf("Valor de juros gerados: %.2f\n", this.getValorGeradoJuros());
        System.out.printf("Investimento rendido com sucesso! Saldo atualizado com os juros: R$%.2f\n", this.getSaldo());
    }

    public double getValorGeradoJuros(){
        return this.valorGeradoJuros;
    }

    public void setValorGeradoJuros(double valorGeradoJuros){
        this.valorGeradoJuros = valorGeradoJuros;
    }
}
