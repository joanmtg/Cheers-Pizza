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
 * file: Cliente.java
 * 
 */


package Administracion;

/**
 *
 * @author Fabio Andres
 */
public class Cliente {
    
    private String nombre, apellido, direccion, email;
    private int id, telefono, celular;
    

    //Constructor N°1
    public Cliente(String nombre, String apellido, String direccion, String email, int id, int telefono, int celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.id = id;
        this.telefono = telefono;
        this.celular = celular;
    }
    
    //Setter & Getters

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCelular() {
        return celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }
    
    
    
    
    
    
            
}
