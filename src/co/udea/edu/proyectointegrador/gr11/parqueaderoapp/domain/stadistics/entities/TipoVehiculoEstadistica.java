/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities;

/**
 *
 * @author ASUS
 */
public class TipoVehiculoEstadistica {

    private int idTipoVehiculo;
    private String tipoVehiculoDescripcion;
    private int numeroDeIngresos;

    public TipoVehiculoEstadistica(int idTipoVehiculo, String tipoVehiculoDescripcion, int numeroDeIngresos) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.tipoVehiculoDescripcion = tipoVehiculoDescripcion;
        this.numeroDeIngresos = numeroDeIngresos;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getTipoVehiculoDescripcion() {
        return tipoVehiculoDescripcion;
    }

    public void setTipoVehiculoDescripcion(String tipoVehiculoDescripcion) {
        this.tipoVehiculoDescripcion = tipoVehiculoDescripcion;
    }

    public int getNumeroDeIngresos() {
        return numeroDeIngresos;
    }

    public void setNumeroDeIngresos(int numeroDeIngresos) {
        this.numeroDeIngresos = numeroDeIngresos;
    }
    
    

}
