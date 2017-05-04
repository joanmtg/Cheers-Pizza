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
 * file: AdaptadorCategoriaControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Categoria;
import java.util.ArrayList;

/**
 *
 * @author Jhonier Andrés
 */
public class AdaptadorCategoriaControlador {

    CategoriaJpaController controlador = new CategoriaJpaController();
    
    public AdaptadorCategoriaControlador() {
    }
    
    public int contarCategorias() {
        return controlador.count();
    }

    public void eliminarCategoria(Categoria categoria) {
        controlador.delete(categoria);
        System.out.println("Eliminando la categoria " + categoria.getNombre());
    }

    public void crearCategoria(Categoria categoria) {
        controlador.create(categoria);
        System.out.println("Registrando la categoria " + categoria.getNombre());
    }
    
    public void editarCategoria(Categoria categoria){
        controlador.edit(categoria);
        System.out.println("Editando la categoria "+ categoria.getNombre());
    }
    
    public Categoria obtenerCategoria(Long codigoCategoria){
        Categoria categoria = controlador.find(codigoCategoria);
        return categoria;
    }
    
    public ArrayList<Categoria> obtenerTodasCategorias(){
        ArrayList<Categoria> categorias = (ArrayList)controlador.findAll();
        return categorias;
    }
    
}