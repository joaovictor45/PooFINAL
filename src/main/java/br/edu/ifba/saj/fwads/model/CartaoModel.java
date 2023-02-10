package br.edu.ifba.saj.fwads.model;

import java.time.LocalDate;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class CartaoModel {
    private final SimpleStringProperty nome;
    private final SimpleObjectProperty<LocalDate> dtValidade;

    public CartaoModel(String nome, LocalDate dtValidade) {
        this();
        this.setNome(nome);
        this.setDtValidade(dtValidade);
    }
    public CartaoModel() {
        this.nome = new SimpleStringProperty();
        this.dtValidade = new SimpleObjectProperty<LocalDate>();
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public LocalDate getDtValidade() {
        return dtValidade.get();
    }

    public SimpleObjectProperty<LocalDate> dtValidadeProperty() {
        return dtValidade;
    }

    public void setDtValidade(LocalDate dtValidade) {
        this.dtValidade.set(dtValidade);
    }

}
