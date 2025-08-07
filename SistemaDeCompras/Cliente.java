package SistemaDeCompras;

public class Cliente {
    private String nome;
    private String email;
    int idade;

    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    void mostrarDados(){
        System.out.println("Nome: " + this.nome + "Cliente: " + this.email);
    }
}
