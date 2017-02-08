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
public class Libro implements Comparable<Libro>{
    private String titulo,autor,isbn;
    private float precio;
    private int numUnidades;

    public Libro(String titulo, String autor, String isbn, float precio, int numUnidades) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
        this.numUnidades = numUnidades;
    }

    public Libro(String titulo, String autor, String isbn, float precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
        numUnidades=1;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }
    
    @Override
    public int compareTo(Libro l){
        return this.getTitulo().compareToIgnoreCase(l.getTitulo());
    }

    @Override
    public String toString() {
        return "Titulo: "+titulo+" Autor: "+autor+" Ejemplares: "+numUnidades;
    }
    
}
