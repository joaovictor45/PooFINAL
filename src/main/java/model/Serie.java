package model;

import java.util.ArrayList;
 
public class Serie {

    private String nome;
    public ArrayList<Item> itens;
    private Integer id;

    public Serie(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public Serie(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
        this.itens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie(String nome, ArrayList<Item> itens, Integer id) {
        this.nome = nome;
        this.itens = itens;
        this.id = id;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public void addItem(Item item) {
        this.itens.add(item);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Serie() {
    }
}
