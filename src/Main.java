import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Informe o valor do seu limite de crédito: ");
        Scanner inputLimite = new Scanner(System.in);
        Double credito = inputLimite.nextDouble();

        String continuar = "s";
        List<Produto> produtos = new ArrayList<>();

        while (continuar.equals("s")) {
            System.out.println("Informe o nome do produto para adicionar no carrinho: ");
            Scanner inputNome = new Scanner(System.in);
            String nomeProduto = inputNome.nextLine();

            System.out.println("Informe o preço do produto para adicionar no carrinho: ");
            Scanner inputPreco = new Scanner(System.in);
            Double valorProduto = inputPreco.nextDouble();

            Boolean saldoInsuficiente = valorProduto > credito;
            if (saldoInsuficiente) {
                System.out.println("\nCRÉDITO INSUFICIENTE!");
                System.out.println("Encerrando compras.\n");
                break;
            }

            credito -= valorProduto;
            System.out.println("Credito restante: " + credito);

            produtos.add(new Produto(nomeProduto, valorProduto));

            System.out.println("Deseja continuar? Informe 8digitando s (sim) ou n (nao): ");
            Scanner inputContinuar = new Scanner(System.in);
            continuar = inputContinuar.nextLine();
        }

        System.out.println("*************************");
        System.out.println("Compras realizadas (Valor crescente):");

        Double totalProdutos;
        Collections.sort(produtos);
        produtos.forEach(produto ->
            System.out.println(produto.getNome() + " | R$ " + produto.getPreco())
        );

        System.out.println("=========================");
        System.out.println("Crédito restante: R$ " + credito);

        System.out.println("*************************");
    }

}