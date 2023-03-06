package model;

import java.util.ArrayList;

public class Escola {

    private String nome;
    private ArrayList<Serie> series;
    private Integer id;

    public Escola(String nome, ArrayList<Serie> series1) {
        this.nome = nome;
        this.series = series1;
    }

    public Escola(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSeries(ArrayList<Serie> series) {
        this.series = series;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Escola(String nome) {
        this.nome = nome;
        this.series = new ArrayList<>();
    }

}
