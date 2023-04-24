package classes;

import java.util.Iterator;
import java.util.List;

public class CentralAgencias {
    public static AgenciaBancaria encontrarAgencia(List<AgenciaBancaria> listaAgencias, int numAgencia){
        Iterator<AgenciaBancaria> iterator = listaAgencias.iterator();
        while(iterator.hasNext()){
            AgenciaBancaria next = iterator.next();
            if((next.getNumAgencia() - numAgencia) == 0){
                return next;
            }
        }
        return null;
    }
}
