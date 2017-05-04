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

import java.time.LocalTime;

/**
 *
 * @author Fabio Andres
 */
public class Cajero extends Empleado{

    public Cajero(String id, String tipoId, String nombre, String apellidos, String direccion, String telefono, String cargo, String password, LocalTime horaInicio, LocalTime horaFin, String fotoURL, Sucursal cod_sucursal) {
        super(id, tipoId, nombre, apellidos, direccion, telefono, cargo, password, horaInicio, horaFin, fotoURL, cod_sucursal);
    }
    
    public void facturarPedido(){
        
    }
    
    public void pagarPedido(){
        
    }
    
    public void generarReportes(){
        
    }
    
    
}
