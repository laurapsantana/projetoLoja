
import java.util.ArrayList;
import java.util.List;
public class Carrinho {
        private List<Produto> produtos;

        // Construtor
        public Carrinho() {
            produtos = new ArrayList<>();
        }

        // Método para adicionar um produto ao carrinho
        public void adicionarProduto(Produto produto) {
            produtos.add(produto);
        }

        // Método para remover um produto do carrinho
        public void removerProduto(Produto produto) {
            produtos.remove(produto);
        }



        // Método para calcular o valor total da compra
        public double calcularValorTotal() {
            double valorTotal = 0;
            for (Produto produto : produtos) {
                valorTotal += produto.getPreco();
            }
            return valorTotal;
        }
    }

