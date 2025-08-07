package SistemaDeCompras;
import java.util.ArrayList;
import java.util.List;

public class Carrinho{
    private List<Produto> carrinho = new ArrayList<>();

    public void adicionarProduto(Produto produto, int quantidade){
        for(Produto p: carrinho){
            carrinho.add(p);
        }
    }

    public double calcularTotal(){
        double total = 0;
        for(Produto p:carrinho){
            total += p.getPreco();
        }
        return total;
    }

    private int contarQuantidade(Produto produto){
        int soma = 0;
        for(Produto p:carrinho){
            if(p.equals(produto)) {
                soma++;
            }
        }
        return soma;
    }

    public void mostrarResumo(){
        System.out.println("Resumo da compra:");

        List<Produto> produtosCarrinho = new ArrayList<>();
        for(Produto p:carrinho){
            if(produtosCarrinho.contains(p)){
                int qtd = contarQuantidade(p);
                System.out.println(p.getNome() + " - R$" + p.getPreco() + " x " + qtd);
                produtosCarrinho.add(p);
            }
        }
    }


}
