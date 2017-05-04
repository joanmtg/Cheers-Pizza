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
 * file: Pedido.java
 * 
 */


package Administracion;

import java.util.ArrayList;

/**
 *
 * @author Fabio Andres
 */
public class Pedido {
    
    private int numeroMesa;
    private String horaInicio, mesero, horaEntrega;
    private ArrayList<Item> items;
    
    //Constructor N°1
    
    public Pedido() {
    }

    //Constructor N°2
    public Pedido(int numeroMesa, String horaInicio, String mesero, String horaEntrega, ArrayList<Item> items) {
        this.numeroMesa = numeroMesa;
        this.horaInicio = horaInicio;
        this.mesero = mesero;
        this.horaEntrega = horaEntrega;
        this.items = items;
    }
    
    
    //Setters & Getters

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getMesero() {
        return mesero;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }
    
    
    
}
