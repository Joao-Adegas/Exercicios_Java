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
        String email;
        do{
            System.out.println("Digte o email do cliente");
            email = getData.nextLine();
            if(!email.contains("@")){
                System.out.println("O email precisa conter @");
            }

        }while (!email.contains("@"));

            System.out.println("Digite nome do CLiente");
            String nomeCliente = getData.nextLine();

            cliente.setNome(nomeCliente);
            cliente.setEmail(email);

            System.out.println("Dados do cliente: ");
            cliente.mostrarDados();

            for(int i = 1;i<=2;i++){
                System.out.println("\nProduto " + i + " :");


                String nomeProduto;
                do {
                    System.out.println("Digite o nome do produto: ");
                    nomeProduto = getData.nextLine();

                    if(!Pattern.matches(caracteresEspeciais,nomeProduto)){
                        System.out.println("O nome do produto não deve conter nenhum caracter especial (@!#$%¨&*()<>,.:;?/°~^`´[[]]}{=+§-_*) ou numeros");
                    }
                }
                while(!Pattern.matches(caracteresEspeciais,nomeProduto));


                double precoProduto = 0;
                do {
                    System.out.println("Digite o preço do produto, use vírgula ( Ex: 1,99 ):");

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


        System.out.println("Digite o nome de um produto para aplicar 10% de desconto:");

        String nomeP = getData.nextLine();
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
                System.out.println("Digite o nome do produto que deseja remover do carrinnho:");
                String remover = getData.nextLine();
                carrinho.removerProdutos(remover);
            }

        getData.close();

    }
}
