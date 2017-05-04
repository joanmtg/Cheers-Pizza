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

import Administracion.Categoria;

/**
 *
 * @author Jhonier Andrés
 */
public class CategoriaJpaController{

    FachadaCategoria fachada = new FachadaCategoria();

    public CategoriaJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(Categoria categoria) {
        fachada.remove(categoria);
    }

    public void create(Categoria categoria) {
        fachada.create(categoria);
    }
    
    public void edit(Categoria categoria){
        fachada.edit(categoria);
    }
    
    public Categoria find(String codigo){
        Categoria categoria = fachada.find(codigo);
        return categoria;
    }
    

}