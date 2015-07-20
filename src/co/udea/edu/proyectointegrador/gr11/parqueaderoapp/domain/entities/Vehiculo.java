package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities;
// Generated 30/06/2015 12:55:54 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Vehiculo generated by hbm2java
 */
public class Vehiculo  implements java.io.Serializable {


     private String placa;
     private TipoVehiculo tipoVehiculo;
     private String marca;
     private String color;
     private String modelo;
     private Date fechaRegistro;

    public Vehiculo() {
    }

	
    public Vehiculo(String placa, TipoVehiculo tipoVehiculo, String marca,String Color, String modelo, Date fechaRegistro) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaRegistro = fechaRegistro;
        this.color=Color;
    }
   
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public TipoVehiculo getTipoVehiculo() {
        return this.tipoVehiculo;
    }
    
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}


