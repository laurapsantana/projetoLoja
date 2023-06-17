public class ProdutoDigital extends Produto {
        private String formato;
        private double tamanhoArquivo;

        // Construtor
        public ProdutoDigital(int codigo, String nome, String descricao, double preco, int quantidadeEmEstoque,
                              String formato, double tamanhoArquivo) {
            super(codigo, nome, descricao, preco, quantidadeEmEstoque);
            this.formato = formato;
            this.tamanhoArquivo = tamanhoArquivo;
        }

        // Sobrescrevendo o método de exibir informações para incluir as informações específicas dos produtos digitais
         @Override
        public void exibirInformacoes() {
            super.exibirInformacoes();
            System.out.println("Digite o Formato do arquivo (MP3, PDF, etc...): " + formato);
            System.out.println("Tamanho do arquivo: " + " MB" + tamanhoArquivo);
        }
    }

