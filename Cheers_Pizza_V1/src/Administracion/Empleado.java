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
 * file: Empleado.java
 * 
 */

package Administracion;

import javax.swing.ImageIcon;

/**
 *
 * @author Fabio Andres
 */
public class Empleado {
    
    public String id, tipoId, nombre, apellido, cargo, horarioSemanal, direccion, email, password, telefono, celular;
    ImageIcon foto;

    
    public Empleado(String id, String tipoId, String nombre, String apellido, String cargo, String horarioSemanal, String direccion, String email, String password, String telefono, String celular, ImageIcon foto) {
        this.id = id;
        this.tipoId = tipoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.horarioSemanal = horarioSemanal;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.celular = celular;
        this.foto = foto;
    }
    
    
    //Setters & Getters

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

    public void setHorarioSemanal(String horarioSemanal) {
        this.horarioSemanal = horarioSemanal;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCelular() {
        return celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public String getHorarioSemanal() {
        return horarioSemanal;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipoId() {
        return tipoId;
    }
    
    

    
    
    
    
}
