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
 * file: ClienteJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Cliente;

/**
 *
 * @author Jhonier Andrés
 */
public class ClienteJpaController{

    FachadaCliente fachada = new FachadaCliente();

    public ClienteJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(Cliente cliente) {
        fachada.remove(cliente);
    }

    public void create(Cliente cliente) {
        fachada.create(cliente);
    }
    
    public void edit(Cliente cliente){
        fachada.edit(cliente);
    }
    
    public Cliente find(String id){
        Cliente cliente = fachada.find(id);
        return cliente;
    }
    

}