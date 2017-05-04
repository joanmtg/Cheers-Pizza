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
 * file: EmpleadoJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Empleado;

/**
 *
 * @author Jhonier Andrés
 */
public class EmpleadoJpaController{

    FachadaEmpleado fachada = new FachadaEmpleado();

    public EmpleadoJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(Empleado empleado) {
        fachada.remove(empleado);
    }

    public void create(Empleado empleado) {
        fachada.create(empleado);
    }
    
    public void edit(Empleado empleado){
        fachada.edit(empleado);
    }
    
    public Empleado find(String id){
        Empleado empleado = fachada.find(id);
        return empleado;
    }
    

}
