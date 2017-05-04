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
 * file: FacturaItemJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Factura_Item;

/**
 *
 * @author Jhonier Andrés
 */
public class FacturaItemJpaController{

    FachadaFacturaItem fachada = new FachadaFacturaItem();

    public FacturaItemJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(Factura_Item facturaItem) {
        fachada.remove(facturaItem);
    }

    public void create(Factura_Item facturaItem) {
        fachada.create(facturaItem);
    }
    
    public void edit(Factura_Item facturaItem){
        fachada.edit(facturaItem);
    }
    
    public Factura_Item find(String id){
        Factura_Item facturaItem = fachada.find(id);
        return facturaItem;
    }
    

}
