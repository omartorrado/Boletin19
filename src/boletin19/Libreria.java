/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin19;

import static MisFunciones.PedirDatos.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author otorradomiguez
 */
public class Libreria {

    private ArrayList<Libro> libreria = new ArrayList();

    public void añadirLibro() {
        Libro l = new Libro(Pstring("titulo?"), Pstring("autor?"), Pstring("ISBN?"), Pfloat("Precio?"), Pint("Nº de ejemplares?"));
        for (int i = 0; i < libreria.size(); i++) {
            if ((l.getTitulo().equals(libreria.get(i).getTitulo()) && l.getAutor().equals(libreria.get(i).getAutor())) || l.getIsbn().equals(libreria.get(i).getIsbn())) {
                int n = JOptionPane.showConfirmDialog(null, "El libro ya existe. ¿Desea añadir nuevos ejemplares?", "Libreria", JOptionPane.YES_NO_OPTION);
                //Si seleccionamos SI n=0, con NO n=1
                if (n == 0) {
                    l = libreria.get(i);
                    l.setNumUnidades(l.getNumUnidades() + Pint("Cuantos ejemplares desea añadir?"));
                    libreria.set(i, l);
                }
            } else {
                libreria.add(l);
            }
        }
    }

    public void mostrarTodo() {
        Collections.sort(libreria);
        for (int i = 0; i < libreria.size(); i++) {
            System.out.println(libreria.get(i).toString());
        }

    }

    public void vender(String titulo) {
        int vendido = 0;
        for (int i = 0; i < libreria.size(); i++) {
            Libro l = libreria.get(i);
            if ((l.getTitulo().equals(titulo)) && vendido == 0) {
                if (l.getNumUnidades() > 1) {
                    int numU = l.getNumUnidades();
                    l.setNumUnidades(numU - 1);
                    libreria.set(i, l);
                    vendido = 1;
                    System.out.println("Vendido");
                } else if (l.getNumUnidades() == 1 && vendido == 0) {
                    libreria.remove(i);
                    System.out.println(libreria.get(i).toString());
                    vendido = 1;
                    System.out.println("Vendido el ultimo ejemplar");
                } else {
                    System.out.println("No quedan ejemplares de este libro");
                }
            }
        }
    }

    public void vender() {
        String titulo = Pstring("Indique el titulo a vender");
        //auxiliar, para que solo venda la primera coincidencia con el titulo
        //igual era mejor que saltase un mensaje como en el metodo mostrar
        int vendido = 0;
        for (int i = 0; i < libreria.size(); i++) {
            Libro l = libreria.get(i);
            if ((l.getTitulo().equals(titulo)) && vendido == 0) {
                if (l.getNumUnidades() > 1) {
                    int numU = l.getNumUnidades();
                    l.setNumUnidades(numU - 1);
                    libreria.set(i, l);
                    vendido = 1;
                    System.out.println("Vendido");
                } else if (l.getNumUnidades() == 1 && vendido == 0) {
                    libreria.remove(i);
                    System.out.println(libreria.get(i).toString());
                    vendido = 1;
                    System.out.println("Vendido el ultimo ejemplar");
                } else {
                    System.out.println("No quedan ejemplares de este libro");
                }
            }
        }
    }

    public void darDeBaja() {
        for (int i = 0; i < libreria.size(); i++) {
            if (libreria.get(i).getNumUnidades() < 1) {
                libreria.remove(i);
            }
        }
    }

    public void mostrar(String titulo) {
        int existe = 0;
        int autorEncontrado = 0;
        for (int i = 0; i < libreria.size(); i++) {
            if (libreria.get(i).getTitulo().equals(titulo)) {
                System.out.println(libreria.get(i).toString());
                existe++;
            }
        }
        if (existe == 0) {
            System.out.println("El libro no esta disponible");
        } else if (existe > 1) {
            System.out.println("Hay mas de un libro con ese titulo. Indique el autor");
            String autor = Pstring("Nombre del autor?");
            for (int i = 0; i < libreria.size(); i++) {
                if (libreria.get(i).getAutor().equals(autor) && libreria.get(i).getTitulo().equals(titulo)) {
                    System.out.println(libreria.get(i).toString());
                    autorEncontrado = 1;
                }
            }
            if (autorEncontrado == 0) {
                System.out.println("No hay ningun libro de ese autor con ese titulo");
            }
        }
    }

    public void libreriaTest() {
        Libro l1 = new Libro("aaa", "ab", "l1", 12.50f, 2);
        Libro l2 = new Libro("aba", "ab", "l2", 10.50f, 3);
        Libro l3 = new Libro("aaa", "ac", "l3", 9.50f, 2);
        Libro l4 = new Libro("aza", "ac", "l4", 7.50f, 4);
        Libro l5 = new Libro("bbb", "ad", "l5", 18.50f, 0);
        libreria.add(l1);
        libreria.add(l2);
        libreria.add(l3);
        libreria.add(l4);
        libreria.add(l5);
    }

}
