package model;

import java.util.HashMap;

 

public class Estabelecimento {
   private String nome;
   HashMap<String,Double > mapearValores; 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

     

    public Estabelecimento(String nome) {
         this.nome = nome;
         mapearValores=new HashMap<String,Double >();
    }
    public void addItem(String nomeItem, double valor)
    {
        mapearValores.put(nomeItem, valor);
    }

    public Estabelecimento() {
    }

     
   
    
}
