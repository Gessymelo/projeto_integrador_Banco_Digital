package bank_app.agencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CentralAgencias {

    private static List<AgenciaBancaria> agencias;

    public CentralAgencias() {
        agencias = new ArrayList<>();
    }

    public static void adicionarAgenciaBancaria(int numNovaAgenciaBancaria){
        AgenciaBancaria novaAgencia = new AgenciaBancaria(numNovaAgenciaBancaria);
        agencias.add(novaAgencia);
    }

    public static void adicionarAgenciaBancaria(AgenciaBancaria nova){
        agencias.add(nova);
    }

    public static AgenciaBancaria encontrarAgenciaBancaria(int numAgenciaBancaria){
        Iterator<AgenciaBancaria> iterator = agencias.iterator();
        while(iterator.hasNext()){
            AgenciaBancaria next = iterator.next();
            if((next.getNumAgencia() - numAgenciaBancaria) == 0){
                return next;
            }
        }
        return null;
    }

    public static void exibirTodasAgenciasDisponiveis(){
        Iterator<AgenciaBancaria> iterator = agencias.iterator();
        while(iterator.hasNext()){
            AgenciaBancaria next = iterator.next();
            System.out.println("Agência Bancária: " + next.getNumAgencia());
        }
    }
}
