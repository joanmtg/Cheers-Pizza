/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
