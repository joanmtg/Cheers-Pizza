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
 * file: FachadaFormaPago.java
 * 
 */
package AccesoDatosORM;

import Administracion.FormaPago;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Pablo
 */
public class FachadaFormaPago extends AbstractFacade<FormaPago>{
    
    @PersistenceContext(name = "Cheers_PizzaPU")
    private EntityManager em = Persistence.createEntityManagerFactory("Cheers_PizzaPU").createEntityManager();
    
    public FachadaFormaPago(){
        super(FormaPago.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    
    
}
