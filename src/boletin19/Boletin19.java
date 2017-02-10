/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin19;

import static MisFunciones.PedirDatos.*;

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
        Libreria l1 = new Libreria();
        //Hacer un menu para elegir las opciones
        l1.libreriaTest();
        //MENU
        int salir = 0;
        do {
            int opcion = Pint("Elije una opción:\n1.Añadir libro\n2.Vender libro\n3.Mostrar todos los libros\n4.Eliminar libros sin ejemplares\n5.Buscar un libro por su título");
            switch (opcion) {
                case 1:
                    l1.añadirLibro();
                    break;
                case 2:
                    l1.vender();
                    break;
                case 3:
                    l1.mostrarTodo();
                    break;
                case 4:
                    l1.darDeBaja();
                    break;
                case 5:
                    l1.mostrar(Pstring("Indique el título a buscar"));
                    break;
                case 0:
                    salir = 1;
                    break;
                default:
                    salir = 1;
                    break;
            }
        } while (salir == 0);
    }
}
