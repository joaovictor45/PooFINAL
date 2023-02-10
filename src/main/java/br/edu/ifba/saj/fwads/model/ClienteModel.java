package br.edu.ifba.saj.fwads.model;

import java.time.LocalDate;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClienteModel {
    private final SimpleBooleanProperty selected;
    private final SimpleStringProperty nome;
    private final SimpleObjectProperty<LocalDate> dtNascimento;
    private final SimpleStringProperty rua;
    private final SimpleStringProperty bairro;
    private final SimpleObjectProperty<CartaoModel> cartao;

    public ClienteModel(String nome, LocalDate dtNascimento, String rua, String bairro) {
        this();
        this.setSelected(false);
        this.setNome(nome);
        this.setDtNascimento(dtNascimento);
        this.setRua(rua);
        this.setBairro(bairro);
    }

    public ClienteModel(String nome, LocalDate dtNascimento, String rua, String bairro, CartaoModel cartao) {
        this();
        this.setSelected(false);
        this.setNome(nome);
        this.setDtNascimento(dtNascimento);
        this.setRua(rua);
        this.setBairro(bairro);
        this.setCartao(cartao);
    }

    public ClienteModel() {
        this.selected = new SimpleBooleanProperty();
        this.nome = new SimpleStringProperty();
        this.dtNascimento = new SimpleObjectProperty<LocalDate>();
        this.rua = new SimpleStringProperty();
        this.bairro = new SimpleStringProperty();
        this.cartao = new SimpleObjectProperty<CartaoModel>();
    }

    public boolean isSelected() {
        return selected.get();
    }

    public SimpleBooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
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

    public LocalDate getDtNascimento() {
        return dtNascimento.get();
    }

    public SimpleObjectProperty<LocalDate> dtNascimentoProperty() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento.set(dtNascimento);
    }

    public String getRua() {
        return rua.get();
    }

    public SimpleStringProperty ruaProperty() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua.set(rua);
    }

    public String getBairro() {
        return bairro.get();
    }

    public SimpleStringProperty bairroProperty() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro.set(bairro);
    }

    public CartaoModel getCartao() {
        return cartao.get();
    }

    public SimpleObjectProperty<CartaoModel> cartaoProperty() {
        return cartao;
    }

    public void setCartao(CartaoModel cartao) {
        this.cartao.set(cartao);
    }

}
