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
 * file: CategoriaJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Categoria;
import java.util.List;

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
    
    public Categoria find(Long codigo){
        Categoria categoria = fachada.find(codigo);
        return categoria;
    }
    
    public List<Categoria> findAll(){
        List<Categoria> categorias = fachada.findAll();
        return categorias;
    }
    

}