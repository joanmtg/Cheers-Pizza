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
 * file: SucursalJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Sucursal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Query;

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
    
    public List<String> sucursalSinGerente(){
        
        fachada.getEntityManager().getTransaction().begin();
        String join = "SELECT nombre from sucursal EXCEPT "
                + "(SELECT nombre from sucursal NATURAL JOIN "
                + "(SELECT cod_sucursal as codigo FROM empleado where cargo = 'Gerente')"
                + " as sub1);";
        Query query = fachada.getEntityManager().createNativeQuery(join);
        List<String> sucursales = query.getResultList();
        fachada.getEntityManager().getTransaction().commit();
        
        return sucursales;
    }
    
    public BigInteger obtenerCodigoSucursal(String nombreSucursal){
        
        fachada.getEntityManager().getTransaction().begin();
        String join = "SELECT codigo from sucursal "
                + "WHERE nombre = '" + nombreSucursal + "';";
        Query query = fachada.getEntityManager().createNativeQuery(join);
        BigInteger sucursal = (BigInteger) query.getSingleResult();
        fachada.getEntityManager().getTransaction().commit();
        
        return sucursal;
    }
    
    

}
