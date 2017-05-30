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
 * file: AdaptadorItemFacturaControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.ItemFactura;
import java.util.ArrayList;

/**
 *
 * @author invitado
 */
public class AdaptadorItemFacturaControlador {
    
    ItemFacturaJpaController controlador = new ItemFacturaJpaController();
    
    public AdaptadorItemFacturaControlador() {
    }
    
    public int contarItemsFactura() {
        return controlador.count();
    }

    public void eliminarItemFactura(ItemFactura itemFactura) {
        controlador.delete(itemFactura);
        System.out.println("Eliminando el item " + itemFactura.getNombre());
    }

    public void crearItemFactura(ItemFactura itemFactura) {
        controlador.create(itemFactura);
        System.out.println("Registrando el item " + itemFactura.getNombre());
    }
    
    public void editarItemFactura(ItemFactura itemFactura){
        controlador.edit(itemFactura);
        System.out.println("Editando el item "+ itemFactura.getNombre());
    }
    
    public ItemFactura obtenerItemFactura(Long codigoItemFactura){
        ItemFactura item = controlador.find(codigoItemFactura);
        return item;
    }
    
    public ArrayList<ItemFactura> obtenerTodosItemsFactura(){
        ArrayList<ItemFactura> itemsFactura = (ArrayList)controlador.findAll();
        return itemsFactura;
    }
    
}
