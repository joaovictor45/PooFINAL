package model;

import java.util.HashMap;

 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estabelecimento {
   private String nome;
   HashMap<String,Double > mapearValores; 
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
