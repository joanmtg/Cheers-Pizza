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
