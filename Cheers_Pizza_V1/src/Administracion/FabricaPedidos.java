/**
 * Proyecto Desarrollo de Software II
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
 * file: FabricaPedidos.java
 * 
 */

package Administracion;

import java.time.LocalTime;
import AccesoDatosORM.*;

/**
 *
 * @author invitado
 */


public class FabricaPedidos {
    
    AdaptadorPedidoControlador adaptadorPedido = new AdaptadorPedidoControlador();

    public FabricaPedidos() {
    }
    
        
    public Pedido crearPedido(String tipoPedido, LocalTime horaInicio, LocalTime horaEntrega, Mesa mesa, 
            Empleado mesero, Cliente cliente, Sucursal sucursal, double total, boolean entregado){
        
        Pedido pedidoGenerado = null;
        
        if(tipoPedido == null){
            pedidoGenerado = null;
        }
        
        else if(tipoPedido.equalsIgnoreCase("A la Mesa")){
            pedidoGenerado = new Pedido(tipoPedido, horaInicio, horaEntrega, entregado, total, mesa, cliente, mesero, sucursal);
            adaptadorPedido.crearPedido(pedidoGenerado);
            System.out.println("Registré pedido en mesa");
        }
        
        else if(tipoPedido.equalsIgnoreCase("Para llevar")){
            pedidoGenerado = new Pedido(tipoPedido, horaInicio, horaEntrega, entregado, total, cliente, sucursal);
            adaptadorPedido.crearPedido(pedidoGenerado);
            System.out.println("Registré pedido para llevar");
        }
        
        return pedidoGenerado;
    }
    
}
