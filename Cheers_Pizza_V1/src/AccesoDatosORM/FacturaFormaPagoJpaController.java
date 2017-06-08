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
 * file: FacturaFormaPagoJpaController.java
 * 
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
