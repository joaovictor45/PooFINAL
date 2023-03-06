package model;

public class Item {

    private String nome, descricao, loja;
    private double preco;
    private Integer id;

    public Item() {
    }

    public Item(String nome, String loja, double preco) {
        this.nome = nome;
        this.loja = loja;
        this.preco = preco;
    }

    public Item(String nome, double preco, Integer id) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
    }

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
