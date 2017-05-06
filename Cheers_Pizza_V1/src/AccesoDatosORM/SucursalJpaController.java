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
 * file: SucursalJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Sucursal;
import java.util.List;

/**
 *
 * @author Jhonier Andrés
 */
public class SucursalJpaController {

    FachadaSucursal fachada = new FachadaSucursal();

    public SucursalJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(Sucursal sucursal) {
        fachada.remove(sucursal);
    }

    public void create(Sucursal sucursal) {
        fachada.create(sucursal);
    }
    
    public void edit(Sucursal sucursal){
        fachada.edit(sucursal);
    }
    
    public Sucursal find(Long codigo){
        Sucursal sucursal = fachada.find(codigo);
        return sucursal;        
    }
    
    public List<Sucursal> findAll(){
        List<Sucursal> sucursales = fachada.findAll();
        return sucursales;
    }
    
    

}
