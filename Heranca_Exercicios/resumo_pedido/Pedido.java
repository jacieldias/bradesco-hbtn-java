public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens; 

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }
        return total * (1 - percentualDesconto / 100);
    }

    public String apresentarResumoPedido(){
        double totalBruto = 0.0;
        StringBuilder resumo = new StringBuilder();
        resumo.append("    ------- RESUMO PEDIDO -------\n");
        for (ItemPedido item : itens) {
            totalBruto += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
            resumo.append("    Tipo: ").append(item.getProduto().getClass().getSimpleName())
            .append("  Titulo: ").append(item.getProduto().getTitulo())
            .append(String.format("  Preco: %2.f", item.getProduto().obterPrecoLiquido()))
            .append(String.format("  Quant: %d", item.getQuantidade()))
            .append(String.format("  Total: %2.f\n", item.getQuantidade() * item.getProduto().obterPrecoLiquido()));
        }
        resumo.append("    ----------------------------\n");
        resumo.append(String.format("    DESCONTO: %2.f\n", totalBruto - calcularTotal()));
        resumo.append(String.format("    TOTAL PRODUTOS: %2.f\n", totalBruto));
        resumo.append("    ----------------------------\n");
        resumo.append(String.format("    TOTAL PEDIDO: %2.f\n", calcularTotal()));
        resumo.append("    ----------------------------\n");
        return resumo.toString();
    }

}
