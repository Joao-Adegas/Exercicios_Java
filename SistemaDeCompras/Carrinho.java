package SistemaDeCompras;
import java.util.ArrayList;
import java.util.List;

public class Carrinho{
    private List<Produto> produtos = new ArrayList<>();
    private List<Integer> quantidade = new ArrayList<>();

    void adicionarProduto(Produto p, int qtd){
        produtos.add(p);
        quantidade.add(qtd);
    }

    public Produto buscarProdutoPeloNome(String nome){
        for(Produto p:produtos){
            if(p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public double calcularTotal(){
        double total = 0;
        for(int i = 0; i < produtos.size(); i++){
            total += produtos.get(i).getPreco()* quantidade.get(i);
        }
        return total;
    }

     public void mostrarResumo(){
         System.out.println("\nResumo Do Carrinho:\n");
         for(int i =0 ; i< produtos.size(); i++){
             Produto p = produtos.get(i);
             int qtd = quantidade.get(i);
             System.out.println(p.getNome() + " - R$ " + p.getPreco() + " x " + qtd);
         }
         System.out.println("Total: R$ " + calcularTotal());

     }

     public void removerProdutos(String nome){
        for(int i = 0; i<produtos.size(); i++){
            Produto p = buscarProdutoPeloNome(nome);
            if(p != null){
                produtos.remove(i);
                quantidade.remove(i);
                System.out.println("Carrinho atualizado:");
                mostrarResumo();
                break;
            }
            else{
                System.out.println("Produto " + nome + " não existe no carrinho");
            }
        }
     }



}
