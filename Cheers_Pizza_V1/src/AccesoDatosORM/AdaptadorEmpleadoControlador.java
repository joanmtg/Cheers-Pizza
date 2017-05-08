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
 * file: AdaptadorEmpleadoControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Empleado;
import java.util.ArrayList;

/**
 *
 * @author Jhonier Andrés
 */
public class AdaptadorEmpleadoControlador {

    EmpleadoJpaController controlador = new EmpleadoJpaController();
    
    public AdaptadorEmpleadoControlador() {
    }
    
    public int contarEmpleados() {
        return controlador.count();
    }

    public void eliminarEmpleado(Empleado empleado) {
        controlador.delete(empleado);
        System.out.println("Eliminando el empleado " + empleado.getNombre());
    }

    public void crearEmpleado(Empleado empleado) {
        controlador.create(empleado);
        System.out.println("Registrando el empleado " + empleado.getNombre());
    }
    
    public void editarEmpleado(Empleado empleado){
        controlador.edit(empleado);
        System.out.println("Editando el empleado "+ empleado.getNombre());
    }
    
    public Empleado obtenerEmpleado(String idEmpleado){
        Empleado empleado = controlador.find(idEmpleado);
        return empleado;
    }
    
    public ArrayList<Empleado> obtenerTodosEmpleados(){
        ArrayList<Empleado> empleados = (ArrayList) controlador.findAll();
        return empleados;
    }
    
}