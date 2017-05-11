/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
