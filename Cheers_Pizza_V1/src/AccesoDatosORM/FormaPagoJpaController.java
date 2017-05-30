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
 * file: FormaPagoJpaController.java
 * 
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
