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
 * file: Cajero.java
 * 
 */



package Administracion;

import javax.swing.ImageIcon;

/**
 *
 * @author Fabio Andres
 */
public class Cajero extends Empleado{

    public Cajero(String id, String tipoId, String nombre, String apellido, String cargo, String horarioSemanal, String direccion, String email, String password, String telefono, String celular, ImageIcon foto) {
        super(id, tipoId, nombre, apellido, cargo, horarioSemanal, direccion, email, password, telefono, celular, foto);
    }
    
    public void facturarPedido(){
        
    }
    
    public void pagarPedido(){
        
    }
    
    public void generarReportes(){
        
    }
    
    
}
