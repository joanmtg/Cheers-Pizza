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
 * file: FabricaPedidos.java
 * 
 */

package Administracion;

/**
 *
 * @author invitado
 */
public class FabricaPedidos {

    public FabricaPedidos() {
    }
    
        
    public Pedido crearPedido(String tipoPedido){
        
        Pedido pedidoGenerado = null;
        
        if(tipoPedido == null){
            pedidoGenerado = null;
        }
        
        else if(tipoPedido.equalsIgnoreCase("En mesa")){
            pedidoGenerado = new PedidoEnMesa();
        }
        
        else if(tipoPedido.equalsIgnoreCase("A domicilio")){
            pedidoGenerado = new PedidoADomicilio();
        }
        
        return pedidoGenerado;
    }
    
}
