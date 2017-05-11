/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosORM;

import Administracion.Factura_FormaPago;

/**
 *
 * @author Juan Pablo
 */
public class FacturaFormaPagoJpaController {
    
    FachadaFacturaFormaPago fachada = new FachadaFacturaFormaPago();

    public FacturaFormaPagoJpaController() {
    }
    
    public int count(){
        return fachada.count();
    }
    
    public void delete(Factura_FormaPago facturaFormaPago){
        fachada.remove(facturaFormaPago);        
    }
    
    public void create(Factura_FormaPago facturaFormaPago){
        fachada.create(facturaFormaPago);
    }
    
    public void edit(Factura_FormaPago facturaFormaPago){
        fachada.edit(facturaFormaPago);
    }
    
    public Factura_FormaPago find(Long numeroFactura){
        Factura_FormaPago facturaFormaPago = fachada.find(numeroFactura);
        return facturaFormaPago;
    }
    
    
}
