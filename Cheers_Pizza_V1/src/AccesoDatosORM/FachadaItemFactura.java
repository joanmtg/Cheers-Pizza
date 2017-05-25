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
 * file: FachadaItemFactura.java
 * 
 */
package AccesoDatosORM;

import Administracion.ItemFactura;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jhonier Andrés
 */

public class FachadaItemFactura extends AbstractFacade<ItemFactura>{

    @PersistenceContext(name = "Cheers_PizzaPU")
    private EntityManager em = Persistence.createEntityManagerFactory("Cheers_PizzaPU").createEntityManager();
    
    public FachadaItemFactura() {
        super(ItemFactura.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
}
