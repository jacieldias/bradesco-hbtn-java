import exceptions.*;

public class ContaBancariaControlada extends ContaBancariaBasica{
    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo, double valorPenalidade){
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal(){
        double tarifaMensal = calcularTarifaMensal();
        double jurosMensal = calcularJurosMensal();
        saldo -= tarifaMensal;
        saldo += jurosMensal;

        if(saldo < saldoMinimo){
            saldo -= valorPenalidade;
        }
    }

}
