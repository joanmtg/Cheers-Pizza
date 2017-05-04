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
 * file: mesasOcupadas.java
 * 
 */

package Administracion;

import java.util.*;

/**
 *
 * @author Fabio Andres
 */
public class mesasOcupadas extends Mesa{
    
    ArrayList<Mesero> listaMeseros = new ArrayList<>();
    
    private int numeroMesa;

    public mesasOcupadas(Long numero, int cantidadPersonas) {
        super(numero, cantidadPersonas);
    }
    
    public int getMesaOcupada(){
        return numeroMesa; 
    }
    
    public void ocuparMesa(int numeroMesa){
        this.numeroMesa = numeroMesa;
        ocuparonMesa_NotifyAllObservers(numeroMesa);
    }
    
    public void desocuparMesa(int numeroMesa){
        desocuparonMesa_NotifyAllObservers(numeroMesa);
    }
    
    public void agregarObservador(Mesero unMesero){
        listaMeseros.add(unMesero);
    }
    
    public void ocuparonMesa_NotifyAllObservers(int unaMesa){
        for(Mesero miMesero : listaMeseros){
            miMesero.setMesaOcupada(unaMesa);
            miMesero.update_ocuparon();
        }
    }
    
    public void desocuparonMesa_NotifyAllObservers(int unaMesa){
        for(Mesero miMesero : listaMeseros){
            miMesero.setMesaOcupada(unaMesa);
            miMesero.update_desocuparon();
        }
    }
    
}
