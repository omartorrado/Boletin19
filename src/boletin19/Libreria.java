/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin19;

import static PedirDatos.PedirDatos.*;
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

    public void Mostrar() {
        Collections.sort(libreria);
        for (int i = 0; i < libreria.size(); i++) {
            System.out.println(libreria.get(i).toString());
        }

    }

    public void vender(String titulo) {
        for (int i = 0; i < libreria.size(); i++) {
            Libro l = libreria.get(i);
            if ((l.getTitulo().equals(titulo))) { //&& l.getAutor().equals(libreria.get(i).getAutor())) || l.getIsbn().equals(libreria.get(i).getIsbn())) {
                if (l.getNumUnidades() > 1) {
                    int numU = l.getNumUnidades();
                    l.setNumUnidades(numU - 1);
                    libreria.set(i, l);
                } else if (l.getNumUnidades() == 1) {
                    libreria.remove(i);
                } else {
                    System.out.println("No quedan ejemplares de este libro");
                }
            }
        }
    }

    public void vender() {
        String titulo = Pstring("Indique el titulo a vender");
        for (int i = 0; i < libreria.size(); i++) {
            Libro l = libreria.get(i);
            if ((l.getTitulo().equals(titulo))) {
                if (l.getNumUnidades() > 1) {
                    int numU = l.getNumUnidades();
                    l.setNumUnidades(numU - 1);
                    libreria.set(i, l);
                } else if (l.getNumUnidades() == 1) {
                    libreria.remove(i);
                    System.out.println(libreria.get(i).toString());
                } else {
                    System.out.println("No quedan ejemplares de este libro");
                }
            }
        }
    }

}
