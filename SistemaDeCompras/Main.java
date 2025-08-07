package SistemaDeCompras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner getData = new Scanner(System.in);
        Carrinho carrinho = new Carrinho();
        Produto p = new Produto();

        for(int i = 0 ; i<3;i++ ){
            System.out.println("==================== Produto " + (i+1) + " =====================");
            System.out.println("Digite o nome do produto ");
            String produto = getData.nextLine();
            p.setNome(produto);

            System.out.println("Digite o preco de " + produto);
            double preco = getData.nextDouble();
            p.setPreco(preco);
            getData.nextLine();

            System.out.println("Digite a quantidade de " + produto);
            int quantidade = getData.nextInt();
            getData.nextLine();

            carrinho.adicionarProduto(p,quantidade);
        }

        getData.close();
        carrinho.mostrarResumo();
        carrinho.calcularTotal();




    }
}
