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
 * file: FacturaJpaController.java
 * 
 */

package AccesoDatosORM;

import Administracion.Factura;
import java.util.List;

/**
 *
 * @author Jhonier Andrés
 */
public class FacturaJpaController{

    FachadaFactura fachada = new FachadaFactura();

    public FacturaJpaController() {
    }

    public int count() {
        return fachada.count();
    }

    public void delete(Factura factura) {
        fachada.remove(factura);
    }

    public void create(Factura factura) {
        fachada.create(factura);
    }
    
    public void edit(Factura factura){
        fachada.edit(factura);
    }
    
    public Factura find(Long numero){
        Factura factura = fachada.find(numero);
        return factura;
    }
    
    public List<Factura> findAll(){
        List<Factura> facturas = fachada.findAll();
        return facturas;
    }
    
}