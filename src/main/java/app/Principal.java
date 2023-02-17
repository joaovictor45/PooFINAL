/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;
import model.*;


/**
 *
 * @author João Victor
 */
public class Principal {
 
    public static void main(String[] args) {
        Escola escola = new  Escola("Escola 1");
        Serie serie = new Serie("Primeira Série");
        Serie serie2 = new Serie("Escola 2");
        Item item = new Item("Lápis", "Azul", 10);
        serie.addItem(item);
        escola.adicionarSerie(serie);
        escola.adicionarSerie(serie2);
        System.out.println(escola.getSerie(0).getNome());
        
     
    }
 
    
}
