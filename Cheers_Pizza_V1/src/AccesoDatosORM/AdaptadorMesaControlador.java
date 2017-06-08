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
 * file: AdaptadorMesaControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Mesa;
import java.util.ArrayList;

/**
 *
 * @author Jhonier Andrés
 */
public class AdaptadorMesaControlador {

    MesaJpaController controlador = new MesaJpaController();
    
    public AdaptadorMesaControlador() {
    }
    
    public int contarMesas() {
        return controlador.count();
    }

    public void eliminarMesa(Mesa mesa) {
        controlador.delete(mesa);
        System.out.println("Eliminando mesa " + mesa.getNumero());
    }

    public void crearMesa(Mesa mesa) {
        controlador.create(mesa);
        System.out.println("Registrando la mesa " + mesa.getNumero());
    }
    
    public void editarMesa(Mesa mesa){
        controlador.edit(mesa);
        System.out.println("Editando la mesa "+ mesa.getNumero());
    }
    
    public Mesa obtenerMesa(Long numMesa){
        Mesa mesa = controlador.find(numMesa);
        return mesa;
    }
    
    public ArrayList<Mesa> obtenerTodasMesas(){
        ArrayList<Mesa> mesas = (ArrayList)controlador.findAll();
        return mesas;
    }
    
}