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
 * file: AdaptadorItemControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Item;
import java.util.ArrayList;

/**
 *
 * @author Jhonier Andrés
 */
public class AdaptadorItemControlador {

    ItemJpaController controlador = new ItemJpaController();
    
    public AdaptadorItemControlador() {
    }
    
    public int contarItems() {
        return controlador.count();
    }

    public void eliminarItem(Item item) {
        controlador.delete(item);
        System.out.println("Eliminando el item " + item.getNombre());
    }

    public void crearItem(Item item) {
        controlador.create(item);
        System.out.println("Registrando el item " + item.getNombre());
    }
    
    public void editarItem(Item item){
        controlador.edit(item);
        System.out.println("Editando el item "+ item.getNombre());
    }
    
    public Item obtenerItem(Long codigoItem){
        Item item = controlador.find(codigoItem);
        return item;
    }
    
    public ArrayList<Item> obtenerTodosItems(){
        ArrayList<Item> items = (ArrayList)controlador.findAll();
        return items;
    }
    
}