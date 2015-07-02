package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities;
// Generated 30/06/2015 12:55:54 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String identificacion;
     private TipoIdentificacion tipoIdentificacion;
     private TipoUsuario tipoUsuario;
     private String nombre;
     private String apellido;
     private String direccion;
     private String telefono;
     private String genero;
     private Set usuarioVehiculos = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String identificacion, TipoIdentificacion tipoIdentificacion, TipoUsuario tipoUsuario, String nombre, String apellido) {
        this.identificacion = identificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Usuario(String identificacion, TipoIdentificacion tipoIdentificacion, TipoUsuario tipoUsuario, String nombre, String apellido, String direccion, String telefono, String genero, Set usuarioVehiculos) {
       this.identificacion = identificacion;
       this.tipoIdentificacion = tipoIdentificacion;
       this.tipoUsuario = tipoUsuario;
       this.nombre = nombre;
       this.apellido = apellido;
       this.direccion = direccion;
       this.telefono = telefono;
       this.genero = genero;
       this.usuarioVehiculos = usuarioVehiculos;
    }
   
    public String getIdentificacion() {
        return this.identificacion;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public TipoIdentificacion getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }
    
    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Set getUsuarioVehiculos() {
        return this.usuarioVehiculos;
    }
    
    public void setUsuarioVehiculos(Set usuarioVehiculos) {
        this.usuarioVehiculos = usuarioVehiculos;
    }




}


