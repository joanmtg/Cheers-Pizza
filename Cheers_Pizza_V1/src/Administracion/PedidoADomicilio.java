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
 * file: PedidoADomicilio.java
 * 
 */


package Administracion;

import java.util.ArrayList;

/**
 *
 * @author invitado
 */
public class PedidoADomicilio extends Pedido{
    
    private String direccion;

    //Constructor N°|
    
    public PedidoADomicilio() {
    }

    //Constructor N°2
    
    public PedidoADomicilio(String direccion, int numeroMesa, String horaInicio, String mesero, String horaEntrega, ArrayList<Item> items) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
