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
 * file: AdaptadorFacturaFormaPagoControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Factura_FormaPago;

/**
 *
 * @author Juan Pablo
 */
public class AdaptadorFacturaFormaPagoControlador {
    
    FacturaFormaPagoJpaController controlador = new FacturaFormaPagoJpaController();

    public AdaptadorFacturaFormaPagoControlador() {
    }
    
    public int contarFacturasFormaPago() {
        return controlador.count();
    }
    
    public void eliminarFacturasFormaPago(Factura_FormaPago facturaFormaPago){
        controlador.delete(facturaFormaPago);
        System.out.println("Eliminando la forma de pago " + facturaFormaPago.getCodigoFormaPago() + " en la factura " + facturaFormaPago.getNumeroFactura());
    }
    
    public void crearFacturaFormaPago(Factura_FormaPago facturaFormaPago){
        controlador.create(facturaFormaPago);
        System.out.println("Registrando la forma de pago " + facturaFormaPago.getCodigoFormaPago() + " en la factura " + facturaFormaPago.getNumeroFactura());   
    }
    
    public void editarFacturaFormaPago(Factura_FormaPago facturaFormaPago){
        controlador.edit(facturaFormaPago);        
    }
    
    public Factura_FormaPago obtenerFacturaFormaPago(Long numeroFactura){
        Factura_FormaPago facturaFormaPago = controlador.find(numeroFactura);
        return facturaFormaPago;
    }
    
}
