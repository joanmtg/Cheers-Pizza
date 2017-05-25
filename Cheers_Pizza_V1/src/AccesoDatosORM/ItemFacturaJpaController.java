/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
