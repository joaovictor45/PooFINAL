package model;

import java.util.ArrayList;

public class Estabelecimento {

    private String nome;
    private ArrayList<Item> itens;
    private Integer id;

    public String getNome() {
        return nome;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addItem(Item item) {
        itens.add(item);
    }

    public Estabelecimento(String nome, ArrayList<Item> itens) {
        itens = new ArrayList<>();
        this.nome = nome;
        this.itens = itens;
    }

    public Estabelecimento() {
        itens = new ArrayList<>();
    }

    public Estabelecimento(String nome) {
        itens = new ArrayList<>();
        this.setNome(nome);
    }

}
