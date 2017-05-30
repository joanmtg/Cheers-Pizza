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
 * file: AdaptadorFormaPagoControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.FormaPago;
import java.util.ArrayList;
/**
 *
 * @author Juan Pablo
 */
public class AdaptadorFormaPagoControlador {
    
    FormaPagoJpaController controlador = new FormaPagoJpaController();

    public AdaptadorFormaPagoControlador() {
    }
    
    public int contarFormasPago(){
        return controlador.count();
    }
    
    public void eliminarFormaPago(FormaPago formaPago){
        controlador.delete(formaPago);
        System.out.println("Eliminando la forma de pago " + formaPago.getCodigo());
    }
    
    public void crearFormaPago(FormaPago formaPago){
        controlador.create(formaPago);
        System.out.println("Registrando la forma de pago " + formaPago.getCodigo());        
    }
    
    public void editarFormaPago(FormaPago formaPago){
        controlador.edit(formaPago);
    }
    
    public FormaPago obtenerFormaPago(Long codigoFormaPago){
        FormaPago formaPago = controlador.find(codigoFormaPago);
        return formaPago;        
    }
    
    public ArrayList<FormaPago> obtenerTodasFormasPago(){
        ArrayList<FormaPago> formasPago = (ArrayList)controlador.findAll();
        return formasPago;
    }
    
}
