

public class ArmazemDeEletronico extends Armazem<Eletronico>{


    @Override
    public void adicionarAoInventario(String nome, Eletronico eletronico) {
        super.adicionarAoInventario(nome, eletronico);
    }

    @Override
    public Eletronico obterDoInventario(String nome) {
        return super.obterDoInventario(nome);
    }
}
