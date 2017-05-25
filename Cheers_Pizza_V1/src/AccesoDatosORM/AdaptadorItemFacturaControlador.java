/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
