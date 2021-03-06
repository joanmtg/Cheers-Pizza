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
 * file: AdaptadorFacturaControlador.java
 * 
 */
package AccesoDatosORM;

import Administracion.Factura;
import java.util.ArrayList;

/**
 *
 * @author Jhonier Andrés
 */
public class AdaptadorFacturaControlador {

    FacturaJpaController controlador = new FacturaJpaController();
    
    public AdaptadorFacturaControlador() {
    }
    
    public int contarFacturas() {
        return controlador.count();
    }

    public void eliminarFactura(Factura factura) {
        controlador.delete(factura);
        System.out.println("Eliminando la factura " + factura.getNumero());
    }

    public void crearFactura(Factura factura) {
        controlador.create(factura);
        System.out.println("Registrando la factura " + factura.getNumero());
    }
    
    public void editarFactura(Factura factura){
        controlador.edit(factura);
        System.out.println("Editando la factura "+ factura.getNumero());
    }
    
    public Factura obtenerFactura(Long numeroFactura){
        Factura factura = controlador.find(numeroFactura);
        return factura;
    }
    
    public ArrayList<Factura> obtenerTodasFacturas(){
        ArrayList<Factura> facturas = (ArrayList)controlador.findAll();
        return facturas;
    }
    
}