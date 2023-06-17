import java.util.*;

public class Loja {
    private List<Produto> catalogo;
    private List<Produto> carrinho;

    public Loja() {
        catalogo = new ArrayList<>();
        carrinho = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        catalogo.add(produto);
    }

    public double calcularValorTotalCompra() {
            double valorTotal = 0.0;

            for (Produto produto : carrinho) {
                int quantidade = 0;
                for (Produto item : carrinho) {
                    if (item.equals(produto)) {
                        quantidade++;
                    }
                }
                valorTotal += produto.getPreco() * quantidade;
            }

            return valorTotal;
        }


        public void exibirInformacoesProduto(int codigoProduto) throws ProdutoNaoEncontradoException {
        Produto produtoEncontrado = null;

        for (Produto produto : catalogo) {
            if (produto.getCodigo() == codigoProduto) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado != null) {
            System.out.println("=== Informações do Produto ===");
            System.out.println("Código: " + produtoEncontrado.getCodigo());
            System.out.println("Nome: " + produtoEncontrado.getNome());
            System.out.println("Descrição: " + produtoEncontrado.getDescricao());
            System.out.println("Preço: R$" + produtoEncontrado.getPreco());
            System.out.println("Quantidade em estoque: " + produtoEncontrado.getQuantidadeEstoque());
            System.out.println("===============================");
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado na loja.");
        }
    }

    public void adicionarAoCarrinho(int codigoProduto, int quantidade) throws ProdutoNaoEncontradoException, QuantidadeInvalidaException {
        Produto produtoEncontrado = null;

        for (Produto produto : catalogo) {
            if (produto.getCodigo() == codigoProduto) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado != null) {
            if (quantidade <= 0 || quantidade > produtoEncontrado.getQuantidadeEstoque()) {
                throw new QuantidadeInvalidaException("Quantidade inválida!");
            }

            produtoEncontrado.setQuantidadeEstoque(produtoEncontrado.getQuantidadeEstoque() - quantidade);
            carrinho.add(produtoEncontrado);
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado na loja.");
        }
    }

    public void removerDoCarrinho(int codigoProduto) throws ProdutoNaoEncontradoException {
        Produto produtoEncontrado = null;

        for (Produto produto : carrinho) {
            if (produto.getCodigo() == codigoProduto) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado != null) {
            carrinho.remove(produtoEncontrado);
            Produto produtoCatalogo = buscarProdutoCatalogo(codigoProduto);
            produtoCatalogo.setQuantidadeEstoque(produtoCatalogo.getQuantidadeEstoque() + 1);
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado no carrinho.");
        }
    }

    private Produto buscarProdutoCatalogo(int codigoProduto) {
        for (Produto produto : catalogo) {
            if (produto.getCodigo() == codigoProduto) {
                return produto;
            }
        }
        return null;
    }

    public void gerarRelatorio() {
        System.out.println("=== Relatório de Produtos ===");

        for (Produto produto : catalogo) {
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: R$" + produto.getPreco());
            System.out.println("Quantidade em estoque: " + produto.getQuantidadeEstoque());
            System.out.println("===============================");
        }
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

}



