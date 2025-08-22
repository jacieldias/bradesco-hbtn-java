public class ContaBancariaTarifada extends ContaBancariaBasica{

    private int quantidadeTransacoes;

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException{
        super.sacar(valor);
        saldo -= 0.10;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException{
        super.depositar(valor);
        saldo -= 0.10;
    }

    public int getQuantidadeTransacoes(){
        return quantidadeTransacoes;
    }
}
