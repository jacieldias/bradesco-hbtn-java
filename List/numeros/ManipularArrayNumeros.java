import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> numeros, int numero){
        if(numeros.contains(numero)){
            return numeros.indexOf(numero);
        }

        return -1;
    }

    public static void adicionarNumero(List<Integer> numeros, int numeroAdicionar){
        if(buscarPosicaoNumero(numeros, numeroAdicionar) >= 0){
            throw new RuntimeException("Numero jah contido na lista");
        }

        numeros.add(numeroAdicionar);
    }

    public static void removerNumero(List<Integer> numeros, int numeroRemover){
        if(buscarPosicaoNumero(numeros, numeroRemover) < 0){
            throw new RuntimeException("Numero nao encontrado na lista");
        }

        numeros.remove(numeroRemover);
    }

    public static void substituirNumero(List<Integer> numeros, int numeroSubstituir, int numeroSubstituto){
        if(buscarPosicaoNumero(numeros, numeroSubstituir) >= 0){
            numeros.set(numeros.indexOf(numeroSubstituir), numeroSubstituto);
        }else{
            numeros.add(numeroSubstituto);
        }
    }

}
