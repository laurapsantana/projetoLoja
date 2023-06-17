import java.util.Scanner;

public class Main{
    private static Produto[] carrinho;

    public static void main(String[] args) {
        // Criando a Loja
        Loja loja = new Loja();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarNovoProduto(loja, scanner);
                    break;
                case 2:
                    exibirInformacoesProduto(loja, scanner);
                    break;
                case 3:
                    adicionarProdutoAoCarrinho(loja, scanner);
                    break;
                case 4:
                    removerProdutoDoCarrinho(loja, scanner);
                    break;
                case 5:
                    calcularValorTotalCompra(loja);
                    break;
                case 6:
                    loja.gerarRelatorio();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Digite um número válido.");
                    break;
            }

            System.out.println(); // Pula uma linha antes do próximo menu
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Cadastrar novo produto");
        System.out.println("2. Exibir informações sobre um produto");
        System.out.println("3. Adicionar produto ao carrinho");
        System.out.println("4. Remover produto do carrinho");
        System.out.println("5. Calcular valor total da compra");
        System.out.println("6. Gerar relatório de produtos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarNovoProduto(Loja loja, Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a descrição do produto: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();

        Produto produto = new Produto(codigo, nome, descricao, preco, quantidadeEstoque);
        loja.adicionarProduto(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void exibirInformacoesProduto(Loja loja, Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        try {
            loja.exibirInformacoesProduto(codigo);
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void adicionarProdutoAoCarrinho(Loja loja, Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        try {
            loja.exibirInformacoesProduto(codigo);
            System.out.print("Digite a quantidade desejada: ");
            int quantidade = scanner.nextInt();

            loja.adicionarAoCarrinho(codigo, quantidade);

            System.out.println("Produto adicionado ao carrinho!");
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (QuantidadeInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removerProdutoDoCarrinho(Loja loja, Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        try {
            loja.removerDoCarrinho(codigo);
            System.out.println("Produto removido do carrinho!");
        } catch (ProdutoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void exibirCarrinho(Loja loja) {
        System.out.println("=== Carrinho de Compras ===");

        for (Produto produto : loja.getCarrinho()) {
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: R$" + produto.getPreco());
            System.out.println("Quantidade: " + obterQuantidadeNoCarrinho(loja, produto));
            System.out.println("===========================");
        }

        double valorTotal = loja.calcularValorTotalCompra();
        System.out.println("Valor total da compra: R$" + valorTotal);
    }

    private static int obterQuantidadeNoCarrinho(Loja loja, Produto produto) {
        int quantidade = 0;

        for (Produto item : loja.getCarrinho()) {
            if (item.equals(produto)) {
                quantidade++;
            }
        }

        return quantidade;
    }

    private static double calcularValorTotalCompra(Loja loja) {
        double valorTotal = loja.calcularValorTotalCompra();
        System.out.println("Valor total da compra: R$" + valorTotal);

        return valorTotal;
    }
}

