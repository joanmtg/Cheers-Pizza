/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosORM;

import Administracion.FormaPago;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Juan Pablo
 */
public class FormaPagoJpaController {
    
    FachadaFormaPago  fachada = new FachadaFormaPago();
    
    public FormaPagoJpaController(){        
    }
    
    public int count() {
        return fachada.count();
    }
    
    public void delete(FormaPago formaPago){
        fachada.remove(formaPago);
    }
    
    public void create(FormaPago formaPago){
        fachada.create(formaPago);
    }
    
    public void edit(FormaPago formaPago){
        fachada.edit(formaPago);        
    }
    
    public FormaPago find(Long codigo){
        FormaPago formaPago = fachada.find(codigo);
        return formaPago;
    }
    
    public List<FormaPago> findAll(){
        List<FormaPago> formasPago = fachada.findAll();
        return formasPago;
    } 
    
}
