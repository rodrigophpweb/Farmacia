package br.com.alurasenac.farmacia.dao;

import br.com.alurasenac.farmacia.modelo.ConnectionFactory;
import br.com.alurasenac.farmacia.modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private final ConnectionFactory connectionFactory;

    public ProdutoDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (id, nome, preco, fabricante) VALUES (?, ?, ?, ?)";
        try (Connection connection = connectionFactory.recuperarConexao();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setString(4, produto.getFabricante());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto no banco de dados", e);
        }
    }

    public List<Produto> listarTodos() {
        String sql = "SELECT id, nome, preco, fabricante FROM produto";
        List<Produto> produtos = new ArrayList<>();

        try (Connection connection = connectionFactory.recuperarConexao();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("id"),
                        rs.getDouble("preco"),
                        rs.getString("nome"),
                        rs.getString("fabricante")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos do banco de dados", e);
        }

        return produtos;
    }

    public void deletar(String id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection connection = connectionFactory.recuperarConexao();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto do banco de dados", e);
        }
    }

    public void atualizarPreco(String id, double novoPreco) {
        String sql = "UPDATE produto SET preco = ? WHERE id = ?";
        try (Connection connection = connectionFactory.recuperarConexao();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, novoPreco);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar preço do produto no banco de dados", e);
        }
    }
}