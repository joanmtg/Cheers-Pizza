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
 * file: ItemFacturaJpaController.java
 * 
 */
package AccesoDatosORM;

import Administracion.Item;
import Administracion.ItemFactura;
import java.util.List;

/**
 *
 * @author invitado
 */
public class ItemFacturaJpaController {
    
    FachadaItemFactura fachada = new FachadaItemFactura();

    public ItemFacturaJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(ItemFactura itemFactura) {
        fachada.remove(itemFactura);
    }

    public void create(ItemFactura itemFactura) {
        fachada.create(itemFactura);
    }
    
    public void edit(ItemFactura itemFactura){
        fachada.edit(itemFactura);
    }
    
    public ItemFactura find(Long codigo){
        ItemFactura itemFactura = fachada.find(codigo);
        return itemFactura;
    }
    
    public List<ItemFactura> findAll(){
        List<ItemFactura> itemsFactura = fachada.findAll();
        return itemsFactura;
    }
    
}
