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
 * file: AdaptadorPedidoItemControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Pedido_Item;

/**
 *
 * @author Jhonier Andrés
 */
public class AdaptadorPedidoItemControlador {

    PedidoItemJpaController controlador = new PedidoItemJpaController();
    
    public AdaptadorPedidoItemControlador() {
    }
    
    public int contarPedidoItems() {
        return controlador.count();
    }

    public void eliminarPedidoItem(Pedido_Item pedidoItem) {
        controlador.delete(pedidoItem);
        System.out.println("Eliminando el item " + pedidoItem.getCodigoItem() + " en el pedido " + pedidoItem.getNumeroPedido());
    }

    public void crearFacturaItem(Pedido_Item pedidoItem) {
        controlador.create(pedidoItem);
        System.out.println("Registrando el item " + pedidoItem.getCodigoItem() + " en el pedido " + pedidoItem.getNumeroPedido());
    }
    
    public void editarPedidoItem(Pedido_Item pedidoItem){
        controlador.edit(pedidoItem);
        System.out.println("Editando el item " + pedidoItem.getCodigoItem() + " en el pedido " + pedidoItem.getNumeroPedido());
    }
    
    public Pedido_Item obtenerFacturaItem(Long numeroPedido){
        Pedido_Item pedidoItem = controlador.find(numeroPedido);
        return pedidoItem;
    }
    
}
