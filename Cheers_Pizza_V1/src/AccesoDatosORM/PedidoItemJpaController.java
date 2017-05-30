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
 * file: PedidoItemJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Pedido_Item;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Query;

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
    
    public Pedido_Item find(Long codigo){
        Pedido_Item pedidoItem = fachada.find(codigo);
        return pedidoItem;
    }
    
    /*public List<Object> joinItemPedido(String numPedido){
        
        fachada.getEntityManager().getTransaction().begin();
        String join = "SELECT codigo_item, numero_pedido, nombre, precio, cantidad, entregado FROM pedido_item "
                    + "NATURAL JOIN (SELECT codigo AS codigo_item, nombre, precio FROM item) AS sub1 "
                    + "NATURAL JOIN (select numero AS numero_pedido FROM pedido) AS sub2 "
                    + "WHERE numero_pedido = "+numPedido+";";
        Query query = fachada.getEntityManager().createNativeQuery(join);
        List<Object> itemsPedido = query.getResultList();
        
        return itemsPedido;
   
    }*/
    
    //Obtiene los codigos de los items de un pedido dado
    public List<BigInteger> obtenerCodigo_ItemsPedido(Long numPedido){
        fachada.getEntityManager().getTransaction().begin();
        String join = "SELECT codigo_item FROM pedido_item WHERE numero_pedido ="+numPedido+";";
        Query query = fachada.getEntityManager().createNativeQuery(join);
        List<BigInteger> itemsPedido = query.getResultList();
        fachada.getEntityManager().getTransaction().commit();
        
        return itemsPedido;
    }
    
    //Obtiene la cantidad de los items de un pedido dado
    public List<Integer> obtenerCantidadItemsPedido(Long numPedido){
        fachada.getEntityManager().getTransaction().begin();
        String join = "SELECT cantidad FROM pedido_item WHERE numero_pedido ="+numPedido+";";
        Query query = fachada.getEntityManager().createNativeQuery(join);
        List<Integer> itemsPedido = query.getResultList();
        fachada.getEntityManager().getTransaction().commit();
        
        return itemsPedido;
    }
    
    //Obtiene el estado de la entrega de los items de un pedido dado
    public List<Boolean> obtenerEntregadoItemsPedido(Long numPedido){
        fachada.getEntityManager().getTransaction().begin();
        String join = "SELECT entregado FROM pedido_item WHERE numero_pedido ="+numPedido+";";
        Query query = fachada.getEntityManager().createNativeQuery(join);
        List<Boolean> itemsPedido = query.getResultList();
        fachada.getEntityManager().getTransaction().commit();
        
        return itemsPedido;
    }
    
    //Actualiza que un item de un pedido dado fue entregado
    public void actualizarEntregadoItemsPedido(Long numPedido, Long numItem, boolean estadoEntrega){
        fachada.getEntityManager().getTransaction().begin();
        String join = "UPDATE pedido_item SET entregado ="+ estadoEntrega
                + " WHERE numero_pedido ="+numPedido+" AND codigo_item ="+ numItem+";";
        Query query = fachada.getEntityManager().createNativeQuery(join);
        query.executeUpdate();
        fachada.getEntityManager().getTransaction().commit();
        
    }

    public void eliminarPedidoItems(Long numeroPedido){
        
        fachada.getEntityManager().getTransaction().begin();
        String sql = "DELETE FROM pedido_item WHERE numero_pedido = "+numeroPedido;
        Query query = fachada.getEntityManager().createNativeQuery(sql);
        query.executeUpdate();
        fachada.getEntityManager().getTransaction().commit();
        
    }
    
}
