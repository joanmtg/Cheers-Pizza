/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosORM;

import Administracion.Factura_FormaPago;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Pablo
 */
public class FachadaFacturaFormaPago extends AbstractFacade<Factura_FormaPago>{

    @PersistenceContext(name = "Cheers_PizzaPU")
    private EntityManager em = Persistence.createEntityManagerFactory("Cheers_PizzaPU").createEntityManager();
    
    public FachadaFacturaFormaPago(){
        super(Factura_FormaPago.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    
}
