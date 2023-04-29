package bank_app.interface_bank_app;

import bank_app.agencia.AgenciaBancaria;
import bank_app.agencia.CentralAgencias;
import utils.Formatador;

import java.util.Scanner;

public class InterfaceBankApp {

    static Scanner s = new Scanner(System.in);
    public static void exibirCabecalho(){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("------------------- JavaBank App -------------------");
        System.out.println("\t Um banco para todas suas necessidades");
        System.out.println("-----------------------------------------------");
    }
    public static void exibirMenu(){
        System.out.println("[1] Criar Conta");
        System.out.println("[2] Depositar");
        System.out.println("[3] Sacar");
        System.out.println("[4] Transferir");
        System.out.println("[5] Consultar extrato");
        System.out.println("[6] Acesso Restrito ao Administrador");
        System.out.println("[7] Sair do sistema");
        System.out.printf("Digite umas das opções acima: ");
    }

    public static void criarConta(){
        int numAgenciaBancariaEscolhida, numConta, tipoConta;
        String nome, cpf, email, dataNascimento;
        double limiteChequeEspecial;

        InterfaceBankApp.exibirCabecalho();
        InterfaceBankApp.exibirBemVindoArea("Criar Conta");

        System.out.println("-------- Agências Bancárias disponíveis -------");
        CentralAgencias.exibirTodasAgenciasBancariasDisponiveis();
        System.out.println("-----------------------------------------------");
        System.out.println("Para começar, o número da agência escolhida: ");
        numAgenciaBancariaEscolhida = s.nextInt();

        System.out.println("Agora, selecione o tipo de conta: \n[1] POUPANÇA ou [2] CORRENTE");
        System.out.printf("Opção: ");
        tipoConta = s.nextInt();

        System.out.printf("Digite o número da conta: ");
        numConta = s.nextInt();

        System.out.println("Por último, seus dados pessoais...");

        System.out.println("Nome:");
        nome = s.next();
        System.out.println("Cpf (só números):");
        cpf = s.next();
        System.out.println("E-mail:");
        email = s.next();
        System.out.println("Data de seu nascimento: ");
        dataNascimento = s.next();

        AgenciaBancaria agenciaBancariaEscolhida = CentralAgencias.encontrarAgenciaBancaria(numAgenciaBancariaEscolhida);
        agenciaBancariaEscolhida.adicionarCliente(nome, cpf, email, Formatador.stringToLocalDate(dataNascimento));

        if(tipoConta == 1){
            agenciaBancariaEscolhida.abrirContaPoupanca(numConta,
                    agenciaBancariaEscolhida.encontrarClientePorIndex(agenciaBancariaEscolhida.getQtdContas()), 0);
        } else if(tipoConta == 2){
            System.out.println("Observação: Você escolheu uma conta corrente.");
            System.out.println("Por causa disso, digite o limite do Cheque Especial: ");
            limiteChequeEspecial = s.nextDouble();

            agenciaBancariaEscolhida.abrirContaCorrente(numConta,
                    agenciaBancariaEscolhida.encontrarClientePorIndex(agenciaBancariaEscolhida.getQtdClientes()), 0 , limiteChequeEspecial);
        }

        System.out.println("Conta feita com sucesso. Obrigado! :)");
    }

    public static void depositar() {
        int numAgenciaBancaria, numConta;
        double valor;

        InterfaceBankApp.exibirCabecalho();
        InterfaceBankApp.exibirBemVindoArea("Depósito Conta");

        System.out.println("Digite a agência da conta:");
        numAgenciaBancaria = s.nextInt();
        System.out.println("Digite o número da conta:");
        numConta = s.nextInt();
        System.out.println("Digite o valor do depósito:");
        valor = s.nextDouble();

        CentralAgencias.encontrarAgenciaBancaria(numAgenciaBancaria)
                .encontrarContaPorNumConta(numConta)
                .depositar(valor);
    }

    public static void sacar(){
        int numAgenciaBancaria, numConta;
        double valor;

        InterfaceBankApp.exibirCabecalho();
        InterfaceBankApp.exibirBemVindoArea("Saque Conta");

        System.out.println("Digite a agência da conta:");
        numAgenciaBancaria = s.nextInt();
        System.out.println("Digite o número da conta:");
        numConta = s.nextInt();
        System.out.println("Digite o valor do saque:");
        valor = s.nextDouble();

        CentralAgencias.encontrarAgenciaBancaria(numAgenciaBancaria)
                .encontrarContaPorNumConta(numConta)
                .sacar(valor);
    }

    public static void transferir(){
        int numAgenciaBancariaOrigem, numContaOrigem, numAgenciaBancariaDestino, numContaDestino;
        double valor;

        InterfaceBankApp.exibirCabecalho();
        InterfaceBankApp.exibirBemVindoArea("Transfêrencia entre contas");

        System.out.println("Digite a agência da conta origem:");
        numAgenciaBancariaOrigem = s.nextInt();
        System.out.println("Digite o número da conta origem:");
        numContaOrigem = s.nextInt();

        System.out.println("Digite a agência da conta destino:");
        numAgenciaBancariaDestino = s.nextInt();
        System.out.println("Digite o número da conta destino:");
        numContaDestino = s.nextInt();

        System.out.println("Digite o valor da transfência:");
        valor = s.nextDouble();

        CentralAgencias.encontrarAgenciaBancaria(numAgenciaBancariaOrigem)
                .encontrarContaPorNumConta(numContaOrigem)
                .transferir(valor, numAgenciaBancariaDestino, numContaDestino);
    }

    public static void consultarExtrato() {
        int numAgenciaBancaria, numConta;

        InterfaceBankApp.exibirCabecalho();
        InterfaceBankApp.exibirBemVindoArea("Extrato de conta");

        System.out.println("Digite a agência da conta:");
        numAgenciaBancaria = s.nextInt();
        System.out.println("Digite o número da conta:");
        numConta = s.nextInt();

        System.out.println("VALOR\t\t\t\t DATA E HORA\t\t\t\t\t\t TIPO DE TRANSAÇÃO");
        CentralAgencias.encontrarAgenciaBancaria(numAgenciaBancaria)
                .encontrarContaPorNumConta(numConta)
                .consultarExtrato();
    }


    public static char confirmarSaida(){
        char resp = '0';
        while(resp != 'S' && resp != 'N'){
            System.out.println("Deseja realmente sair do sistema (S/N)?");
            resp = s.next().toUpperCase().charAt(0);
        }
        return resp;
    }

    private static void exibirBemVindoArea(String area){
        System.out.println();
        System.out.println("Seja bem vindo(a) para área de " + area);
        System.out.println();
    }

}
