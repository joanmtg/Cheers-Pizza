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
 * file: PedidoItemJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Pedido_Item;

/**
 *
 * @author Jhonier Andrés
 */
public class PedidoItemJpaController{

    FachadaPedidoItem fachada = new FachadaPedidoItem();

    public PedidoItemJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(Pedido_Item pedidoItem) {
        fachada.remove(pedidoItem);
    }

    public void create(Pedido_Item pedidoItem) {
        fachada.create(pedidoItem);
    }
    
    public void edit(Pedido_Item pedidoItem){
        fachada.edit(pedidoItem);
    }
    
    public Pedido_Item find(Long numeroPedido){
        Pedido_Item pedidoItem = fachada.find(numeroPedido);
        return pedidoItem;
    }
    

}
