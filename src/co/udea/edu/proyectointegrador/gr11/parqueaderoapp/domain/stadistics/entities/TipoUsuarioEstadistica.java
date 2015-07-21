/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoUsuario;

/**
 *
 * @author JuanF
 */
public class TipoUsuarioEstadistica {
    
    private TipoUsuario tipoUsuario;
     
    private long numeroDeIngresos;

    public TipoUsuarioEstadistica(TipoUsuario tipoUsuario, long numeroDeIngresos) {
        this.tipoUsuario = tipoUsuario;
        this.numeroDeIngresos = numeroDeIngresos;
    }
    
    public long getNumeroDeIngresos() {
        return numeroDeIngresos;
    }

    public void setNumeroDeIngresos(long numeroDeIngresos) {
        this.numeroDeIngresos = numeroDeIngresos;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    

   
    
}
