public class Produto {

    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;

    public Produto(int codigo, String nome, String descricao, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    protected void exibirInformacoes() {
        this.exibirInformacoes();
    }
}







