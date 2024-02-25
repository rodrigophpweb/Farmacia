package br.com.alurasenac.farmacia.modelo;

public class Produto {

    private ConnectionFactory connection;

    Produto(){
        this.connection = new ConnectionFactory();
    }
    private String id;
    private double preco;
    private String nome;
    private String fabricante;

    public Produto(String id, double preco, String nome, String fabricante) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
        this.fabricante = fabricante;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    // Método toString para facilitar a impressão do objeto
    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }
}
