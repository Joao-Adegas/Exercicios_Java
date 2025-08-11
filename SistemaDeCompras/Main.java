package SistemaDeCompras;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner getData = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Carrinho carrinho = new Carrinho();

        System.out.println("Digte o email do cliente");
        String email = getData.nextLine();

        System.out.println("Digite nome do CLiente");
        String nomeCliente = getData.nextLine();

        cliente.setNome(nomeCliente);
        cliente.setEmail(email);

        System.out.println("Dados do cliente: ");
        cliente.mostrarDados();

        for(int i = 1;i<=2;i++){
            System.out.println("\nProduto " + i + " :");

            System.out.println("Digite o nome do produto: ");
            String nomeProduto = getData.nextLine();

            System.out.println("Digite o preco do produto: ");
            double precoProduto = getData.nextDouble();

            System.out.println("Digite a quantidade do produto: ");
            int qtd = getData.nextInt();
            getData.nextLine();
            if(qtd <= 0){
                System.out.println("Não é possivel inserir uma quantidade " + qtd + " no estoque!! Coloque um valor maior que 0");
            }

            Produto p = new Produto();
            p.setNome(nomeProduto);
            p.setPreco(precoProduto);


            carrinho.adicionarProduto(p,qtd);
        }

        System.out.println("Digite o nome de um produto para aplicar 10% de desconto:");

        String nomeP = getData.nextLine();
        Produto produtoEncontrado = carrinho.buscarProduto(nomeP);

        if(produtoEncontrado != null){
            produtoEncontrado.aplicarDesconto(10);
            System.out.println("Desconto aplicado no produto " + nomeP);
        }
        else{
            System.out.println("Produto não encontrado no carrinho.");
        }

        carrinho.mostrarResumo();

        System.out.println("Deseja remover algum produto da lista?(s/n)");
        String a = getData.nextLine();

        if(a.equalsIgnoreCase("s")){
            System.out.println("Digite o nome do produto que deseja remover do carrinnho:");
            String remover = getData.nextLine();
            carrinho.removerProdutos(remover);
        }
        else{
            System.out.println("Tenha um bom dia!!");
        }

        getData.close();



    }
}
