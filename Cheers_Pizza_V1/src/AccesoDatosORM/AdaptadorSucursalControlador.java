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
 * file: AdaptadorSucursalControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Sucursal;
import java.util.ArrayList;

/**
 *
 * @author Jhonier Andrés
 */
public class AdaptadorSucursalControlador {

    SucursalJpaController controlador = new SucursalJpaController();
    
    public AdaptadorSucursalControlador() {
    }
    
    public int contarSucursales() {
        return controlador.count();
    }

    public void eliminarSucursal(Sucursal sucursal) {
        controlador.delete(sucursal);
        System.out.println("Eliminando la sucursal " + sucursal.getNombre());
    }

    public void crearSucursal(Sucursal sucursal) {
        controlador.create(sucursal);
        System.out.println("Registrando la sucursal " + sucursal.getNombre());
    }
    
    public void editarSucursal(Sucursal sucursal){
        controlador.edit(sucursal);
        System.out.println("Editando la sucursal "+sucursal.getNombre());
    }
    
    public Sucursal obtenerSucursal(Long codigoSucursal){
        Sucursal sucursal = controlador.find(codigoSucursal);
        return sucursal;
    }
    
    public ArrayList<Sucursal> obtenerTodasLasSucursales(){
        ArrayList<Sucursal> sucursales = (ArrayList)controlador.findAll();
        return sucursales;
    }
    
}
