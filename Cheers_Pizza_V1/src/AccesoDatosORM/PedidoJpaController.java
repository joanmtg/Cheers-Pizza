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
 * file: PedidoJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Pedido;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Query;

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
    
    public Pedido find(Long numero){
        Pedido pedido = fachada.find(numero);
        return pedido;
    }
    
    public List<Pedido> findAll(){
        List<Pedido> pedidos = fachada.findAll();
        return pedidos;
    }
    
    public List<BigInteger> joinExcept(){
        
        fachada.getEntityManager().getTransaction().begin();
        String join = "SELECT numero FROM Pedido WHERE Pedido.entregado = 'true'"
                    + "EXCEPT "
                    + "SELECT numero_pedido FROM Factura INNER JOIN Factura_FormaPago ON Factura.numero = Factura_FormaPago.factura_numero;";
        Query query = fachada.getEntityManager().createNativeQuery(join);
        List<BigInteger> pedidos = query.getResultList();
        fachada.getEntityManager().getTransaction().commit();
        return pedidos;
   
    }
    
   
}
