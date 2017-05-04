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

import java.time.LocalTime;

/**
 *
 * @author invitado
 */
public class PedidoEnMesa extends Pedido{
    
    //Constructor N°1
    
    public PedidoEnMesa() {
    }
    
    //Constructor N°2

    public PedidoEnMesa(String tipoPedido, LocalTime horaInicio, LocalTime horaEntrega, Mesa mesa, Cliente cliente, Empleado mesero, Sucursal sucursal) {
        super(tipoPedido, horaInicio, horaEntrega, mesa, cliente, mesero, sucursal);
    }
    
    
    
}
