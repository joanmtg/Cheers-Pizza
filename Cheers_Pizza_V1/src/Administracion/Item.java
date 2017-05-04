/**
 * Proyecto Desarrollo de Software II
 * Fecha de entrega: 19/04/2017
 * Universidad del Valle
 * EISC
 *
 * Integrantes: 
 *
 * Jhonier Andrés Calero Rodas		1424599
 * Fabio Andrés Castañeda Duarte	1424386
 * Juan Pablo Moreno Muñoz		1423437
 * Joan Manuel Tovar Guzmán		1423124
 *
 * file: Item.java
 * 
 */


package Administracion;

import javax.swing.ImageIcon;

/**
 *
 * @author Fabio Andres
 */
public class Item {
    
    private String nombre, descripcion, categoria;
    private ImageIcon fotografia;
    private int precioActual;
    
    //Constructor N°1
    public Item(String nombre, String descripcion, String categoria, ImageIcon fotografia, int precioActual) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fotografia = fotografia;
        this.precioActual = precioActual;
    }
    
    //Setters & Getters 

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFotografia(ImageIcon fotografia) {
        this.fotografia = fotografia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioActual(int precioActual) {
        this.precioActual = precioActual;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ImageIcon getFotografia() {
        return fotografia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecioActual() {
        return precioActual;
    }
    
    
    
}
