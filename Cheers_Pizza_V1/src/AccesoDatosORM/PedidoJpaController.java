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
 * file: PedidoJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Pedido;

/**
 *
 * @author Jhonier Andrés
 */
public class PedidoJpaController{

    FachadaPedido fachada = new FachadaPedido();

    public PedidoJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(Pedido pedido) {
        fachada.remove(pedido);
    }

    public void create(Pedido pedido) {
        fachada.create(pedido);
    }
    
    public void edit(Pedido pedido){
        fachada.edit(pedido);
    }
    
    public Pedido find(String numero){
        Pedido pedido = fachada.find(numero);
        return pedido;
    }
    

}
