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
 * file: Factura.java
 * 
 */


package Administracion;

import java.util.ArrayList;

/**
 *
 * @author Fabio Andres
 */
public class Factura {
    
    private int numero, propina, descuento, impuestos, clienteId;
    private String horaPago, tipoPago;
    private ArrayList<Item> items;
    
    //Constructor N°1
    public Factura(int numero, int propina, int descuento, int impuestos, int clienteId, String horaPago, String tipoPago, ArrayList<Item> items) {
        this.numero = numero;
        this.propina = propina;
        this.descuento = descuento;
        this.impuestos = impuestos;
        this.clienteId = clienteId;
        this.horaPago = horaPago;
        this.tipoPago = tipoPago;
        this.items = items;
    }
    
    //Setters & Getters

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setHoraPago(String horaPago) {
        this.horaPago = horaPago;
    }

    public void setImpuestos(int impuestos) {
        this.impuestos = impuestos;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPropina(int propina) {
        this.propina = propina;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getDescuento() {
        return descuento;
    }

    public String getHoraPago() {
        return horaPago;
    }

    public int getImpuestos() {
        return impuestos;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getNumero() {
        return numero;
    }

    public int getPropina() {
        return propina;
    }

    public String getTipoPago() {
        return tipoPago;
    }
    
    
    
    
    
}
