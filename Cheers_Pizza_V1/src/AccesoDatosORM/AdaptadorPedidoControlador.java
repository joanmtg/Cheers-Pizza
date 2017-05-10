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
 * file: AdaptadorPedidoControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Jhonier Andrés
 */
public class AdaptadorPedidoControlador {

    PedidoJpaController controlador = new PedidoJpaController();
    
    public AdaptadorPedidoControlador() {
    }
    
    public int contarPedidos() {
        return controlador.count();
    }

    public void eliminarPedido(Pedido pedido) {
        controlador.delete(pedido);
        System.out.println("Eliminando el pedido " + pedido.getNumero());
    }

    public void crearPedido(Pedido pedido) {
        controlador.create(pedido);
        System.out.println("Registrando el pedido " + pedido.getNumero());
    }
    
    public void editarPedido(Pedido pedido){
        controlador.edit(pedido);
        System.out.println("Editando el pedido "+ pedido.getNumero());
    }
    
    public Pedido obtenerPedido(Long numeroPedido){
        Pedido pedido = controlador.find(numeroPedido);
        return pedido;
    }
    
    public ArrayList<Pedido> obtenerTodosPedidos(){
        ArrayList<Pedido> pedidos = (ArrayList)controlador.findAll();
        return pedidos;
    }
    
    public ArrayList<Long> obtenerPedidosNoPagos(){
        
        ArrayList<Long> pedidosNoPagos = (ArrayList) controlador.joinExcept();
        return pedidosNoPagos;
        
    }
    
}
