package Interfaces_Exercicios.resumo_pedido;

import Interfaces_Exercicios.resumo_pedido.provedores.Frete;
import Interfaces_Exercicios.resumo_pedido.provedores.ProvedorFrete;

public class ProcessadorPedido {

    private ProvedorFrete provedorFrete;

    public ProcessadorPedido(ProvedorFrete provedorFrete) {
        this.provedorFrete = provedorFrete;
    }
    
    public void processar(Pedido pedido) {
        Frete frete = provedorFrete.calcularFrete(pedido.getPeso(), pedido.getTotal());
        pedido.setFrete(frete);
    }

}
