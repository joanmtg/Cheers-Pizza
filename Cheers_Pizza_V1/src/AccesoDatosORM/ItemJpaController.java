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
 * file: ItemJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Item;

/**
 *
 * @author Jhonier Andrés
 */
public class ItemJpaController {

    FachadaItem fachada = new FachadaItem();

    public ItemJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(Item item) {
        fachada.remove(item);
    }

    public void create(Item item) {
        fachada.create(item);
    }
    
    public void edit(Item item){
        fachada.edit(item);
    }
    
    public Item find(String codigo){
        Item item = fachada.find(codigo);
        return item;
    }

}
