public class ProdutoFisico extends Produto {
        private double peso;
        private String dimensoes;

        // Construtor
        public ProdutoFisico(int codigo, String nome, String descricao, double preco, int quantidadeEmEstoque,
                             double peso, String dimensoes) {
            super(codigo, nome, descricao, preco, quantidadeEmEstoque);
            this.peso = peso;
            this.dimensoes = dimensoes;
        }

        // Sobrescrevendo o método de exibir informações para incluir as informações específicas de produto físico
       @Override
        public void exibirInformacoes() {
            super.exibirInformacoes();
            System.out.println("Peso: " + peso + " kg");
            System.out.println("Dimensões: " + dimensoes);
        }
    }




