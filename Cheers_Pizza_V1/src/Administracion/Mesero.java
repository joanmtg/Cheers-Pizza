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
 * file: Mesero.java
 * 
 */


package Administracion;

import java.time.LocalTime;
import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Fabio Andres
 */
public class Mesero extends Empleado{
    protected mesasOcupadas unaMesa;
    int mesaNoDisponible;
    ArrayList<Integer> mesasND = new ArrayList<>();

    public Mesero(String id, String tipoId, String nombre, String apellidos, String direccion, String telefono, String cargo, String password, LocalTime horaInicio, LocalTime horaFin, String fotoURL, Sucursal cod_sucursal) {
        super(id, tipoId, nombre, apellidos, direccion, telefono, cargo, password, horaInicio, horaFin, fotoURL, cod_sucursal);
    }
    
    
    
    /*public Mesero(mesasOcupadas mesa, String nombreMesero){
        this.unaMesa = mesa;
        this.unaMesa.agregarObservador(this);
        nombre = nombreMesero;
    }*/
    
    public void darInfoMesas(){
        String info="Hola, soy el mesero  " + this.getNombre() + " " + this.getApellidos() + ". Le informo que las siguientes mesas no se encuentran disponibles en estos momentos:";
        
        System.out.println(info);
        for (int i = 0; i < mesasND.size(); i++) {
            System.out.print(mesasND.get(i) + " - ");;
            
        }
        System.out.println("\n");
    }
    
    public void observarMesasOcupadas(mesasOcupadas mesa){
        this.unaMesa = mesa;
        this.unaMesa.agregarObservador(this);
    }
    
    public void setMesaOcupada(int unaMesa) {
        mesaNoDisponible = unaMesa;
        mesasND.add(mesaNoDisponible);
    }

    public void update_ocuparon() {
        
        darInfoMesas();
    }

    public void update_desocuparon() {
        
        //Se revisa si la mesa ya estaba ocupada
        for(int i = 0; i< mesasND.size(); i++){
            if(mesaNoDisponible == mesasND.get(i)){
                mesasND.remove(i);
            }
            
        }
        
        darInfoMesas();
    }
    
    public void eliminarPedido(){
        
    }
    
    public void consultarPedidos(){
        
    }
    
    public void modificarInfoPedido(){
        
    }

    public void registrarPedido(){
        
    }
    
    
}
