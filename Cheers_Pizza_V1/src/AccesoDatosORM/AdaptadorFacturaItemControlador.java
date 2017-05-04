/**
 * Proyecto Desarrollo de Software II
 * Fecha de entrega: 19/04/2017
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
 * file: AdaptadorFacturaItemControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Factura_Item;

/**
 *
 * @author Jhonier Andrés
 */
public class AdaptadorFacturaItemControlador {

    FacturaItemJpaController controlador = new FacturaItemJpaController();
    
    public AdaptadorFacturaItemControlador() {
    }
    
    public int contarFacturaItems() {
        return controlador.count();
    }

    public void eliminarFacturaItem(Factura_Item facturaItem) {
        controlador.delete(facturaItem);
        System.out.println("Eliminando el item " + facturaItem.getCodigoItem() + " en la factura " + facturaItem.getNumeroFactura());
    }

    public void crearFacturaItem(Factura_Item facturaItem) {
        controlador.create(facturaItem);
        System.out.println("Registrando el item " + facturaItem.getCodigoItem() + " en la factura " + facturaItem.getNumeroFactura());
    }
    
    public void editarFacturaItem(Factura_Item facturaItem){
        controlador.edit(facturaItem);
        System.out.println("Editando el item " + facturaItem.getCodigoItem() + " en la factura " + facturaItem.getNumeroFactura());
    }
    
    public Factura_Item obtenerFacturaItem(String numeroFactura){
        Factura_Item facturaItem = controlador.find(numeroFactura);
        return facturaItem;
    }
    
}
