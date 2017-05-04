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

import java.time.LocalTime;

/**
 *
 * @author invitado
 */
public class PedidoADomicilio extends Pedido{
    
    //Constructor N°1
    
    public PedidoADomicilio() {
    }

    //Constructor N°2
    
    public PedidoADomicilio(String tipoPedido, LocalTime horaInicio, LocalTime horaEntrega, Cliente cliente, Sucursal sucursal) {
        super(tipoPedido, horaInicio, horaEntrega, cliente, sucursal);
    }
    
    public Pedido toPedido(){
        Pedido pedido = new Pedido(this.getTipoPedido(), this.getHoraInicio(), this.getHoraEntrega(), this.getCliente(), this.getSucursal());
        return pedido;
    }
    
}
