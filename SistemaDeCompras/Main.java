package SistemaDeCompras;

import java.util.Locale;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner getData = new Scanner(System.in);
        getData.useLocale(new Locale("pt", "BR"));  // aceita vírgula como separador decimal
        Cliente cliente = new Cliente();
        Carrinho carrinho = new Carrinho();
        String caracteresEspeciais = "^[a-zA-ZÀ-ÿ ]+$";
/*
        System.out.println("Digte o email do cliente");
        String email = getData.nextLine();

        if(!email.contains("@")){
            System.out.println("O email precisa conter @");
        }
        */

        // EMAIL =======================================================================================================
        String email;
        do{
            System.out.println("Digte o email do cliente");
            email = getData.nextLine();
            if(!email.contains("@")){
                System.out.println("O email precisa conter @");
            }

        }while (!email.contains("@"));


        // NOME CLIENTE ================================================================================================
        System.out.println("Digite nome do CLiente"); // TRYCATCH PRA NUMERO
        String nomeCliente = getData.nextLine();

        cliente.setNome(nomeCliente);
        cliente.setEmail(email);

        System.out.println("Dados do cliente: ");
        cliente.mostrarDados();


        for(int i = 1;i<=2;i++){
            System.out.println("\nProduto " + i + " :");


            //NOME PRODUTO =============================================================================================
            String nomeProduto;
            do {
                System.out.println("Digite o nome do produto: "); // TRYCATCH PRA NUMERO
                nomeProduto = getData.nextLine();

                if(!Pattern.matches(caracteresEspeciais,nomeProduto)){
                    System.out.println("O nome do produto não deve conter nenhum caracter especial (@!#$%¨&*()<>,.:;?/°~^`´[[]]}{=+§-_*) ou numeros");
                }
            }
            while(!Pattern.matches(caracteresEspeciais,nomeProduto));


            // PRECO PRODUTO ===========================================================================================
            double precoProduto = 0;
            do {
                System.out.println("Digite o preço do produto, use vírgula ( Ex: 1,99 ):"); // TRYCATCH PRA STRING

                if (getData.hasNextDouble()) {
                    precoProduto = getData.nextDouble();
                    getData.nextLine();
                    if (precoProduto <= 0) {
                        System.out.println("O preço deve ser maior que zero.");
                    }
                } else {
                    System.out.println("Formato inválido! Use vírgula como separador decimal.");
                    getData.next(); // descarta entrada inválida
                }

            } while (precoProduto <= 0);


            // QUANTIDADE PRODUTO ======================================================================================
            // USAR TRYCATCH NumberFormatException PRA GARANTIR QUE O USUÁRIO NÃO VAI DIGITAR STRING
            int qtd;
            do{
                System.out.println("Digite a quantidade do produto: ");
                qtd = getData.nextInt();
                getData.nextLine();
                if(qtd <= 0){
                    System.out.println("Não é possivel inserir uma quantidade " + qtd + " no estoque!! Coloque um valor maior que 0");
                }
            }while (qtd <= 0);


            Produto p = new Produto();
            p.setNome(nomeProduto);
            p.setPreco(precoProduto);

            carrinho.adicionarProduto(p,qtd);

        }

            System.out.println("Resumo antes de deconto:");
            carrinho.mostrarResumo();


        // DESCONTO ====================================================================================================
        System.out.println("Digite o nome de um produto para aplicar 10% de desconto:");
        String nomeP = getData.nextLine(); // USAR TRYCATCH PRA GARANTIR QUE ELE N DIGITE NUMERO
        Produto produtoEncontrado = carrinho.buscarProdutoPeloNome(nomeP);

        if(produtoEncontrado != null){
            produtoEncontrado.aplicarDesconto(10);
            System.out.println("Desconto aplicado no produto " + nomeP);
        }
        else{
            System.out.println("Produto não encontrado no carrinho.");
        }


            System.out.println("Resumo depois do desconto:");
            carrinho.mostrarResumo();

            System.out.println("Deseja remover algum produto da lista?(s/n)");
            String a = getData.nextLine();

            if(a.equalsIgnoreCase("s")){
                // REMOVER PRODUTO DO CARRINHO =========================================================================
                System.out.println("Digite o nome do produto que deseja remover do carrinnho:");
                String remover = getData.nextLine();
                carrinho.removerProdutos(remover);
            }

        getData.close();

    }
}
