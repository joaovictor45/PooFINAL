package model;

import java.util.ArrayList;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//@Entity
public class Escola {

    private String nome;
    private ArrayList<Serie> series;
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Escola(String nome) {
        this.nome = nome;
        this.series = new ArrayList<>();
    }

    public Escola() {
        this.series = new ArrayList<>();
    }

    public void adicionarSerie(Serie serie) {
        this.series.add(serie);
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Serie> getSeries() {
        return series;
    }

    public Serie getSerie(int index) {
        return series.get(index);
    }

    public String getName() {
        return nome;
    }

}
