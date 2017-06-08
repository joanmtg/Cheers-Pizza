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
 * file: AdaptadorClienteControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Cliente;

/**
 *
 * @author Jhonier Andrés
 */
public class AdaptadorClienteControlador {

    ClienteJpaController controlador = new ClienteJpaController();
    
    public AdaptadorClienteControlador() {
    }
    
    public int contarClientes() {
        return controlador.count();
    }

    public void eliminarCliente(Cliente cliente) {
        controlador.delete(cliente);
        System.out.println("Eliminando el cliente " + cliente.getNombre());
    }

    public void crearCliente(Cliente cliente) {
        controlador.create(cliente);
        System.out.println("Registrando el cliente " + cliente.getNombre());
    }
    
    public void editarCliente(Cliente cliente){
        controlador.edit(cliente);
        System.out.println("Editando el cliente "+ cliente.getNombre());
    }
    
    public Cliente obtenerCliente(String idCliente){
        Cliente cliente = controlador.find(idCliente);
        return cliente;
    }
    
}