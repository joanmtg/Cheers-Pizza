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
 * file: Empleado.java
 * 
 */

package Administracion;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Fabio Andres
 */

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {
    private static final long serialVersionUID = 2L;
    
    @Id
    private String id;
    
    @Column(name = "tipo_id", length = 30, nullable = false)
    private String tipoId;
    
    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;
    
    @Column(name = "apellidos", length = 80, nullable = false)
    private String apellidos;
    
    @Column(name = "direccion", length = 100)
    private String direccion; 
    
    @Column(name = "telefono", length = 10, nullable = false)
    private String telefono;
    
    @Column(name = "cargo", length = 30, nullable = false)
    private String cargo;
    
    @Column(name = "password", length = 50, nullable = false)
    private String password;
    
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;
    
    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;
    
    @Column(name = "foto", columnDefinition = "TEXT")
    private String fotoURL;
    
    @ManyToOne
    @JoinColumn(name = "cod_sucursal", nullable = false)
    private Sucursal sucursal;
    
    @OneToMany(mappedBy = "mesero", cascade = CascadeType.ALL)
    private List<Pedido> pedidosRegistrados = new ArrayList<>();
    
    @OneToMany(mappedBy = "cajero", cascade = CascadeType.ALL)
    private List<Factura> facturasGeneradas = new ArrayList<>();

    // Constructor N°1
    
    public Empleado() {
    }

    // Constructor N°2

    public Empleado(String id, String tipoId, String nombre, String apellidos, String direccion, String telefono, String cargo, String password, LocalTime horaInicio, LocalTime horaFin, String fotoURL, Sucursal cod_sucursal) {
        this.id = id;
        this.tipoId = tipoId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
        this.password = password;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fotoURL = fotoURL;
        this.sucursal = cod_sucursal;
    }
    
        
    //Setters & Getters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<Pedido> getPedidosRegistrados() {
        return pedidosRegistrados;
    }

    public void setPedidosRegistrados(List<Pedido> pedidosRegistrados) {
        this.pedidosRegistrados = pedidosRegistrados;
    }

    public List<Factura> getFacturasGeneradas() {
        return facturasGeneradas;
    }

    public void setFacturasGeneradas(List<Factura> facturasGeneradas) {
        this.facturasGeneradas = facturasGeneradas;
    }
    
    
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", tipoId=" + tipoId + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", cargo=" + cargo + ", password=" + password + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", fotoURL=" + fotoURL + ", cod_sucursal=" + sucursal + ", pedidosRegistrados=" + pedidosRegistrados + ", facturasGeneradas=" + facturasGeneradas + '}';
    }

    
    

    

    
        
}
