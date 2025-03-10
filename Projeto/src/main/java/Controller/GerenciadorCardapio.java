package Controller;

import Model.ItemCardapio;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorCardapio {
    private List<ItemCardapio> itens;

    public GerenciadorCardapio() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    public void removerItem(ItemCardapio item) {
        itens.remove(item);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemCardapio::calcularTotal).sum();
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }
}