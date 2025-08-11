package SistemaDeCompras;

public class Produto {
    private String nome;
    private double preco;

    public Produto() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void aplicarDesconto(double percentual){
        if(percentual > 0 && percentual <= 100){
            preco -= preco *(percentual/100);
        }
    }

   public void exibirInfo(){
       System.out.println("Produto: " + nome + "| Preco: R$ " + preco);
   }

}
