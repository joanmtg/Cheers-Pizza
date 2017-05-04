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
 * file: Mesa.java
 * 
 */


package Administracion;

/**
 *
 * @author Fabio Andres
 */
public class Mesa {
    
    private int numeroMesa, cantidadPersonas;
    
    //Constructor N°1
    public Mesa(int numero, int cantidadPersonas) {
        this.numeroMesa = numero;
        this.cantidadPersonas = cantidadPersonas;
    }
    
    //Setters & Getters

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public void setNumero(int numero) {
        this.numeroMesa = numero;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public int getNumero() {
        return numeroMesa;
    }
    
    
    
}
