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
 * file: PedidoEnMesa.java
 * 
 */


package Administracion;

import java.util.ArrayList;

/**
 *
 * @author invitado
 */
public class PedidoEnMesa extends Pedido{
    
    private String numMesa;
    private String IDMesero;

    
    //Constructor N°1
    
    public PedidoEnMesa() {
    }
    
    //Constructor N°2

    public PedidoEnMesa(String numMesa, String IDMesero, int numeroMesa, String horaInicio, String mesero, String horaEntrega, ArrayList<Item> items) {
        this.numMesa = numMesa;
        this.IDMesero = IDMesero;
    }

    public String getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(String numMesa) {
        this.numMesa = numMesa;
    }

    public String getIDMesero() {
        return IDMesero;
    }

    public void setIDMesero(String IDMesero) {
        this.IDMesero = IDMesero;
    }
    
    
}
