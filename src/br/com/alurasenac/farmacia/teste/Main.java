package br.com.alurasenac.farmacia.teste;

import br.com.alurasenac.farmacia.modelo.Produto;
import br.com.alurasenac.farmacia.service.ProdutoService;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criar uma instância de ProdutoService
        ProdutoService produtoService = new ProdutoService();

       /* //Criar um novo produto
        Produto produto = new Produto("123458", 17.29, "Atroveran", "Hipera");

        // Chamar o método para cadastrar um novo produto
        produtoService.cadastrarNovoProduto(produto);
        System.out.println("Produto cadastrado com sucesso!");


        // Listar todos os produtos do banco de dados
        List<Produto> produtos = produtoService.listarTodosProdutos();

        // Exibir os produtos listados
        for (Produto produto : produtos) {
          System.out.println(produto);
        }*/

        /*// Listar todos os produtos do banco de dados antes da exclusão (apenas para verificação)
        System.out.println("Produtos antes da exclusão:");
        listarProdutos(produtoService);

        // Deletar um produto pelo seu id
        produtoService.deletarProduto("123456");

        //Listar todos os produtos do banco de dados após a exclusão
         System.out.println("\nProdutos após a exclusão:");
         listarProdutos(produtoService);
        }

        private static void listarProdutos(ProdutoService produtoService) {
        List<Produto> produtos = produtoService.listarTodosProdutos();
        for (Produto produto : produtos) {
           System.out.println(produto);
        }*/

        // Atualizar o preço do produto com ID "123456" para 15.00
        produtoService.atualizarPrecoProduto("123458", 15.00);

        // Imprimir uma mensagem para indicar que a atualização foi concluída
        System.out.println("Preço do produto atualizado com sucesso!");
    }
}