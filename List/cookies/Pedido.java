import java.util.ArrayList;

public class Pedido {

    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie){
        cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas(){
        return cookies.stream()
        .mapToInt(PedidoCookie::getQuantidadeCaixas)
        .sum();
    }

    public int removerSabor(String sabor){
        int totalRemovido = cookies.stream()
                            .filter(p -> p.getSabor().equalsIgnoreCase(sabor))
                            .mapToInt(PedidoCookie::getQuantidadeCaixas)
                            .sum();

        cookies.removeIf(p -> p.getSabor().equalsIgnoreCase(sabor));
        return totalRemovido;
    }
    

}
