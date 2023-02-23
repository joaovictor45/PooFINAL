package model;

import java.util.ArrayList;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//@Entity

public class Serie {

    private String nome;
    public ArrayList<Item> itens;
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Serie(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Serie() {
    }
}
