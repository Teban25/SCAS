/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoVehiculo;

/**
 *
 * @author ASUS
 */
public class TipoVehiculoEstadistica {

    private  TipoVehiculo tipoVehiculo;
    private long numeroDeIngresos;

    public TipoVehiculoEstadistica(TipoVehiculo tipoVehiculo, long numeroDeIngresos) {
        this.tipoVehiculo = tipoVehiculo;
        this.numeroDeIngresos = numeroDeIngresos;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public long getNumeroDeIngresos() {
        return numeroDeIngresos;
    }

    public void setNumeroDeIngresos(long numeroDeIngresos) {
        this.numeroDeIngresos = numeroDeIngresos;
    }
    
    
       
}
