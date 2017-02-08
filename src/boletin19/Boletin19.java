/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin19;

/**
 *
 * @author otorradomiguez
 */
public class Boletin19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Libreria l1=new Libreria();
        l1.añadirLibro();
        l1.añadirLibro();
        l1.Mostrar();
        l1.vender();
        l1.Mostrar();
    }
    
}
