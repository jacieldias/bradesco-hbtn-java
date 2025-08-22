package Interfaces_Exercicios.resumo_pedido.provedores;

public class Sedex implements ProvedorFrete{

    @Override
    public Frete calcularFrete(double peso, double valor) {
        if(peso > 1) {
            return new Frete(valor * 0.1, TipoProvedorFrete.SEDEX);
        } else {
            return new Frete(valor * 0.05, TipoProvedorFrete.SEDEX);
        }
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }

}
