public class Produto implements Comparable<Produto>{

    private String nome;

    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto: " + this.nome + " | " + "Preço: R$ " + this.preco;
    }

    @Override
    public int compareTo(Produto outroProduto) {
//        if (this.getPreco() > outroProduto.getPreco() ) {
//            return 1;
//        } else if (this.getPreco() < outroProduto.getPreco()) {
//            return -1;
//        } else {
//            return 0;
//        }
        return this.getPreco().compareTo(outroProduto.getPreco());
    }
}
