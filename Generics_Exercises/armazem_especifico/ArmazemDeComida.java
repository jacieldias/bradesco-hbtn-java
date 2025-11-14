

public class ArmazemDeComida extends Armazem<Comida>{

    @Override
    public void adicionarAoInventario(String nome, Comida comida) {
        super.adicionarAoInventario(nome, comida);
    }

    @Override
    public Comida obterDoInventario(String nome) {
        return super.obterDoInventario(nome);
    }

    
}
