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
 * file: MesaJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Mesa;
import java.util.List;

/**
 *
 * @author Jhonier Andrés
 */
public class MesaJpaController{

    FachadaMesa fachada = new FachadaMesa();

    public MesaJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(Mesa mesa) {
        fachada.remove(mesa);
    }

    public void create(Mesa mesa) {
        fachada.create(mesa);
    }
    
    public void edit(Mesa mesa){
        fachada.edit(mesa);
    }
    
    public Mesa find(Long numero){
        Mesa mesa = fachada.find(numero);
        return mesa;
    }
    
    public List<Mesa> findAll(){
        List<Mesa> items = fachada.findAll();
        return items;
    }
    

}
