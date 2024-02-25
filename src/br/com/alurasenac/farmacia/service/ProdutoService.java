package br.com.alurasenac.farmacia.service;

import br.com.alurasenac.farmacia.dao.ProdutoDao;
import br.com.alurasenac.farmacia.modelo.ConnectionFactory;
import br.com.alurasenac.farmacia.modelo.Produto;
import java.util.List;

public class ProdutoService {

    private final ProdutoDao produtoDao;

    public ProdutoService() {
        this.produtoDao = new ProdutoDao(new ConnectionFactory());
    }

    public void cadastrarNovoProduto(Produto produto) {
        produtoDao.salvar(produto);
    }

    public List<Produto> listarTodosProdutos() { return produtoDao.listarTodos(); }

    public void deletarProduto(String id) { produtoDao.deletar(id); }

    public void atualizarPrecoProduto(String id, double novoPreco) { produtoDao.atualizarPreco(id, novoPreco); }

}